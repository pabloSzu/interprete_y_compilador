package proyectoFinal.Interpretador;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import proyectoFinal.Interpretador.TablaSimbolos.SymbolTable;
import proyectoFinal.Interpretador.TablaSimbolos.Symbol;

public class SimpleCustomVisitor extends SimpleBaseVisitor<String> {

    private SymbolTable symbolTable = new SymbolTable();
    private CustomErrors customErrors = new CustomErrors();
    private Stack<Boolean> contextStack = new Stack<>();
    private List<String> threeAddressCode = new ArrayList<>();
    private int tempVarCounter = 0;
    private int labelCounter = 0;

    public SimpleCustomVisitor() {
        contextStack.push(false); // Start in global context
    }

    @Override
    public String visitProg(SimpleParser.ProgContext ctx) {
        visitChildren(ctx);
        generateThreeAddressCode(ctx);
        return null;
    }

    @Override
    public String visitDeclaracion(SimpleParser.DeclaracionContext ctx) {
        String varName = ctx.ID().getText();
        String varType = ctx.tipoDato().getText();
        Symbol symbol = new Symbol(varName, varType);
        if (contextStack.peek()) {
            symbolTable.addLocalSymbol(varName, symbol);
        } else {
            symbolTable.addGlobalSymbol(varName, symbol);
        }

        System.out.println("Added symbol: " + varName + " of type " + varType);

        if (ctx.operacion() != null) {
            String value = visit(ctx.operacion());
            threeAddressCode.add(varName + " = " + value);
        }

        return null;
    }

    @Override
    public String visitAsignacion(SimpleParser.AsignacionContext ctx) {
        String varName = ctx.ID().getText();
        if (!symbolTable.contains(varName)) {
            customErrors.idNoDeclarado(Integer.toString(ctx.start.getLine()), varName);
        }
        String value = visit(ctx.operacion());
        threeAddressCode.add(varName + " = " + value);
        return null;
    }

    @Override
    public String visitCondif(SimpleParser.CondifContext ctx) {
        String condition = visit(ctx.operacion());
        String labelTrue = generateNewLabel();
        String labelEnd = generateNewLabel();

        threeAddressCode.add("if " + condition + " goto " + labelTrue);
        visit(ctx.bloque(0));
        threeAddressCode.add("goto " + labelEnd);
        threeAddressCode.add(labelTrue + ":");
        if (ctx.bloque().size() > 1) {
            visit(ctx.bloque(1));
        }
        threeAddressCode.add(labelEnd + ":");

        return null;
    }

    @Override
    public String visitBucleWhile(SimpleParser.BucleWhileContext ctx) {
        String labelStart = generateNewLabel();
        String labelEnd = generateNewLabel();

        threeAddressCode.add(labelStart + ":");
        String condition = visit(ctx.operacion());
        threeAddressCode.add("if not " + condition + " goto " + labelEnd);
        visit(ctx.bloque());
        threeAddressCode.add("goto " + labelStart);
        threeAddressCode.add(labelEnd + ":");

        return null;
    }

    @Override
    public String visitDefinicionFuncion(SimpleParser.DefinicionFuncionContext ctx) {
        String functionName = ctx.ID().getText();
        String returnType = ctx.tipoDato().getText();
        Symbol symbol = new Symbol(functionName, returnType);
        symbolTable.addGlobalSymbol(functionName, symbol);
        System.out.println("Added function: " + functionName + " with return type " + returnType);
        contextStack.push(true); // Entering a new function (local context)
        visit(ctx.parametros());
        visit(ctx.bloque());
        contextStack.pop(); // Leaving the function (return to previous context)
        symbolTable.clearLocalSymbols();
        return null;
    }

    @Override
    public String visitLlamadaFuncion(SimpleParser.LlamadaFuncionContext ctx) {
        String functionName = ctx.ID().getText();
        String tempVar = generateTempVar();
        String args = visit(ctx.argumentos());
        threeAddressCode.add(tempVar + " = call " + functionName + "(" + args + ")");
        return tempVar;
    }

    @Override
    public String visitArgumentos(SimpleParser.ArgumentosContext ctx) {
        if (ctx.operacion().isEmpty()) return "";
        StringBuilder args = new StringBuilder();
        for (int i = 0; i < ctx.operacion().size(); i++) {
            if (i > 0) args.append(", ");
            args.append(visit(ctx.operacion(i)));
        }
        return args.toString();
    }

    @Override
    public String visitOperacion(SimpleParser.OperacionContext ctx) {
        return visit(ctx.expresion());
    }

    @Override
    public String visitExpresion(SimpleParser.ExpresionContext ctx) {
        if (ctx.operacionComparacion() != null) {
            return visit(ctx.operacionComparacion());
        }
        return "";
    }

    @Override
    public String visitOperacionComparacion(SimpleParser.OperacionComparacionContext ctx) {
        if (ctx.operacionLogica().size() == 1) {
            return visit(ctx.operacionLogica(0));
        }
        String left = visit(ctx.operacionLogica(0));
        String right = visit(ctx.operacionLogica(1));
        String op = ctx.getChild(1).getText();
        String tempVar = generateTempVar();
        threeAddressCode.add(tempVar + " = " + left + " " + op + " " + right);
        return tempVar;
    }

    @Override
    public String visitOperacionLogica(SimpleParser.OperacionLogicaContext ctx) {
        if (ctx.operacionAritmetica().size() == 1) {
            return visit(ctx.operacionAritmetica(0));
        }
        String left = visit(ctx.operacionAritmetica(0));
        String right = visit(ctx.operacionAritmetica(1));
        String op = ctx.getChild(1).getText();
        String tempVar = generateTempVar();
        threeAddressCode.add(tempVar + " = " + left + " " + op + " " + right);
        return tempVar;
    }

    @Override
    public String visitOperacionAritmetica(SimpleParser.OperacionAritmeticaContext ctx) {
        if (ctx.term().size() == 1) {
            return visit(ctx.term(0));
        }
        String left = visit(ctx.term(0));
        String right = visit(ctx.term(1));
        String op = ctx.getChild(1).getText();
        String tempVar = generateTempVar();
        threeAddressCode.add(tempVar + " = " + left + " " + op + " " + right);
        return tempVar;
    }

    @Override
    public String visitTerm(SimpleParser.TermContext ctx) {
        if (ctx.factor().size() == 1) {
            return visit(ctx.factor(0));
        }
        String left = visit(ctx.factor(0));
        String right = visit(ctx.factor(1));
        String op = ctx.getChild(1).getText();
        String tempVar = generateTempVar();
        threeAddressCode.add(tempVar + " = " + left + " " + op + " " + right);
        return tempVar;
    }

    @Override
    public String visitFactor(SimpleParser.FactorContext ctx) {
        if (ctx.operacion() != null) {
            return "(" + visit(ctx.operacion()) + ")";
        }
        if (ctx.llamadaFuncion() != null) {
            return visit(ctx.llamadaFuncion());
        }
        if (ctx.INTEGER() != null) {
            return ctx.INTEGER().getText();
        }
        if (ctx.DECIMAL() != null) {
            return ctx.DECIMAL().getText();
        }
        if (ctx.CHARACTER() != null) {
            return ctx.CHARACTER().getText();
        }
        if (ctx.ID() != null) {
            return ctx.ID().getText();
        }
        return "";
    }

    @Override
    public String visitBloque(SimpleParser.BloqueContext ctx) {
        contextStack.push(true); // Entering a new block (local context)
        visitChildren(ctx);
        contextStack.pop(); // Leaving the block
        return null;
    }

    private String generateTempVar() {
        return "t" + (tempVarCounter++);
    }

    private String generateNewLabel() {
        return "L" + (labelCounter++);
    }

    private void generateThreeAddressCode(SimpleParser.ProgContext ctx) {
        // Code generation logic (if needed)
    }

    public List<String> getThreeAddressCode() {
        return threeAddressCode;
    }

    public SymbolTable getSymbolTable() {
        return symbolTable;
    }

    public CustomErrors getCustomErrors() {
        return customErrors;
    }
}
