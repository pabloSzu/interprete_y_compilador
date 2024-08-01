package proyectoFinal.Interpretador;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import proyectoFinal.Interpretador.TablaSimbolos.Function;
import proyectoFinal.Interpretador.TablaSimbolos.Symbol;
import proyectoFinal.Interpretador.TablaSimbolos.SymbolTable;

public class SimpleCustomVisitor extends SimpleBaseVisitor<Void> {

    private SymbolTable symbolTable = new SymbolTable();
    private CustomErrors customErrors = new CustomErrors();
    private List<String> errors = new ArrayList<>();
    private Stack<Boolean> contextStack = new Stack<>();
    private List<String> threeAddressCode = new ArrayList<>();
    private List<String> optimizedCode = new ArrayList<>();
    private int tempCount = 0;
    private int labelCount = 0;

    public SimpleCustomVisitor() {
        contextStack.push(false); // Start in global context
    }

    @Override
    public Void visitProg(SimpleParser.ProgContext ctx) {
        System.out.println("Visiting prog...");
        visitChildren(ctx);
        generateOptimizedCode();
        printCode(); // Print the codes with comments
        return null;
    }

    @Override
    public Void visitDeclaracionFuncion(SimpleParser.DeclaracionFuncionContext ctx) {
        String functionName = ctx.ID().getText();
        String returnType = ctx.tipoDato().getText();
        Function functionSymbol = new Function(functionName);
        
        // Add parameters to function symbol
        SimpleParser.ParametrosContext parametrosCtx = ctx.parametros();
        if (parametrosCtx != null) {
            for (int i = 0; i < parametrosCtx.getChildCount(); i += 3) {
                String paramType = parametrosCtx.getChild(i).getText();
                String paramName = parametrosCtx.getChild(i + 1).getText();
                functionSymbol.addParameter(paramName);
            }
        }
        
        symbolTable.addGlobalSymbol(functionName, functionSymbol);
        System.out.println("Added function symbol: " + functionName + " of type: " + returnType);
        return null;
    }

    @Override
    public Void visitDefinicionFuncion(SimpleParser.DefinicionFuncionContext ctx) {
        String functionName = ctx.ID().getText();
        String returnType = ctx.tipoDato().getText();

        // Ensure the function is defined in the global scope
        Function functionSymbol = (Function) symbolTable.getSymbol(functionName);
        if (functionSymbol == null) {
            functionSymbol = new Function(functionName);
            symbolTable.addGlobalSymbol(functionName, functionSymbol);
        }

        // Enter local scope for function
        symbolTable.enterLocalScope();
        contextStack.push(true); // Entering function context

        // Process function parameters
        SimpleParser.ParametrosContext parametrosCtx = ctx.parametros();
        if (parametrosCtx != null) {
            for (int i = 0; i < parametrosCtx.getChildCount(); i += 3) {
                String paramType = parametrosCtx.getChild(i).getText();
                String paramName = parametrosCtx.getChild(i + 1).getText();
                functionSymbol.addParameter(paramName);
            }
        }

        // Process function body
        visit(ctx.bloque());

        // Exit local scope of the function
        symbolTable.exitLocalScope();
        contextStack.pop(); // Leaving function context
        return null;
    }

    @Override
    public Void visitDeclaracion(SimpleParser.DeclaracionContext ctx) {
        String varName = ctx.ID().getText();
        String varType = ctx.tipoDato().getText();
        Symbol symbol = new Symbol(varName, varType);
        
        if (contextStack.peek()) {
            // Inside a function
            symbolTable.addLocalSymbol(varName, symbol);
        } else {
            // Global scope
            symbolTable.addGlobalSymbol(varName, symbol);
        }
        System.out.println("Added symbol: " + varName + " of type: " + varType);
        return null;
    }

    @Override
    public Void visitAsignacion(SimpleParser.AsignacionContext ctx) {
        String varName = ctx.ID().getText();
        if (!symbolTable.contains(varName)) {
            customErrors.idNoDeclarado(String.valueOf(ctx.start.getLine()), varName);
        }
        String operation = ctx.operacion().getText();
        String tempVar = generateTempVar();
        String code = tempVar + " = " + operation + ";";
        threeAddressCode.add(code);
        code = varName + " = " + tempVar + ";";
        threeAddressCode.add(code);
        return visitChildren(ctx);
    }

    @Override
    public Void visitLlamadaFuncion(SimpleParser.LlamadaFuncionContext ctx) {
        String functionName = ctx.ID().getText();
        if (!symbolTable.contains(functionName)) {
            customErrors.funcionNoDeclarada(String.valueOf(ctx.start.getLine()), functionName);
        }
        
        Function function = symbolTable.getFunction(functionName);
        if (function != null) {
            // You can add parameter checking here if needed
        }
        
        String code = "call " + functionName + "();";
        threeAddressCode.add(code);
        return visitChildren(ctx);
    }

    @Override
    public Void visitLlamadaPrint(SimpleParser.LlamadaPrintContext ctx) {
        String printArg = ctx.operacion().getText();
        String code = "print(" + printArg + ");";
        threeAddressCode.add(code);
        return visitChildren(ctx);
    }

    @Override
    public Void visitCondif(SimpleParser.CondifContext ctx) {
        String conditionTemp = generateTempVar();
        visit(ctx.operacion()); // Visit condition expression
        threeAddressCode.add(conditionTemp + " = " + ctx.operacion().getText() + ";");
        
        String endIfLabel = generateLabel();
        String elseLabel = generateLabel();

        threeAddressCode.add("if " + conditionTemp + " == 0 goto " + elseLabel + ";");
        contextStack.push(true); // Entering if block context
        visit(ctx.bloque(0));
        contextStack.pop(); // Leaving if block context

        if (ctx.bloque().size() > 1) {
            threeAddressCode.add("goto " + endIfLabel + ";");
            threeAddressCode.add(elseLabel + ":");
            contextStack.push(true); // Entering else block context
            visit(ctx.bloque(1));
            contextStack.pop(); // Leaving else block context
        } else {
            threeAddressCode.add(elseLabel + ":");
        }

        threeAddressCode.add(endIfLabel + ":");
        return null;
    }

    @Override
    public Void visitBucleWhile(SimpleParser.BucleWhileContext ctx) {
        String startWhileLabel = generateLabel();
        String endWhileLabel = generateLabel();

        threeAddressCode.add(startWhileLabel + ":");
        visit(ctx.operacion()); // Visit condition expression
        threeAddressCode.add("if " + ctx.operacion().getText() + " == 0 goto " + endWhileLabel + ";");

        contextStack.push(true); // Entering while block context
        visit(ctx.bloque());
        contextStack.pop(); // Leaving while block context

        threeAddressCode.add("goto " + startWhileLabel + ";");
        threeAddressCode.add(endWhileLabel + ":");
        return null;
    }

    @Override
    public Void visitBloque(SimpleParser.BloqueContext ctx) {
        contextStack.push(true); // Entering block context
        visitChildren(ctx);
        contextStack.pop(); // Leaving block context
        return null;
    }

    private String generateTempVar() {
        return "t" + (tempCount++);
    }

    private String generateLabel() {
        return "L" + (labelCount++);
    }

    public SymbolTable getSymbolTable() {
        return symbolTable;
    }

    public List<String> getErrors() {
        return errors;
    }

    public List<String> getThreeAddressCode() {
        return threeAddressCode;
    }

    public List<String> getOptimizedCode() {
        return optimizedCode;
    }

    private void generateOptimizedCode() {
        OptimizedCode optimizedCodeGenerator = new OptimizedCode(threeAddressCode);
        this.optimizedCode = optimizedCodeGenerator.getOptimizedCode();
    }

    private void printCode() {
        System.out.println("Three Address Code with Comments:");
        for (String line : threeAddressCode) {
            System.out.println(line);
        }
        System.out.println("\nOptimized Code with Comments:");
        for (String line : optimizedCode) {
            System.out.println(line);
        }
    }
}
