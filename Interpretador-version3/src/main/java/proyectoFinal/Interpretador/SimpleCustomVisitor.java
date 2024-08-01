package proyectoFinal.Interpretador;

import org.antlr.v4.runtime.tree.TerminalNode;
import proyectoFinal.Interpretador.TablaSimbolos.Function;
import proyectoFinal.Interpretador.TablaSimbolos.Symbol;
import proyectoFinal.Interpretador.TablaSimbolos.SymbolTable;

import java.util.ArrayList;
import java.util.List;

public class SimpleCustomVisitor extends SimpleBaseVisitor<Void> {

    private SymbolTable symbolTable = new SymbolTable();
    private CustomErrors customErrors = new CustomErrors();
    private List<String> errors = new ArrayList<>();
    private List<String> threeAddressCode = new ArrayList<>();
    private List<String> optimizedCode = new ArrayList<>();
    private int tempCount = 0;
    private int labelCount = 0;

    @Override
    public Void visitProg(SimpleParser.ProgContext ctx) {
        visitChildren(ctx);
        System.out.println("Symbol Table:");
        System.out.println(symbolTable);
        generateOptimizedCode();
        return null;
    }

    @Override
    public Void visitDeclaracion(SimpleParser.DeclaracionContext ctx) {
        String name = ctx.ID().getText();
        String type = ctx.tipoDato().getText();
        Symbol symbol = new Symbol(name, type);

        if (symbolTable.contains(name)) {
            errors.add("Variable " + name + " ya declarada.");
        } else if (symbolTable.inLocalScope()) {
            symbolTable.addLocalSymbol(name, symbol);
        } else {
            symbolTable.addGlobalSymbol(name, symbol);
        }

        if (ctx.operacion() != null) {
            // Procesa la asignación si existe
            visit(ctx.operacion());
            symbol.setInitialized(true);
        }

        return null;
    }

    @Override
    public Void visitAsignacion(SimpleParser.AsignacionContext ctx) {
        String name = ctx.ID().getText();
        Symbol symbol = symbolTable.getSymbol(name);
        if (symbol == null) {
            errors.add("Variable " + name + " no está declarada.");
        } else {
            visit(ctx.operacion());
            symbol.setInitialized(true);
        }
        return null;
    }

    @Override
    public Void visitDefinicionFuncion(SimpleParser.DefinicionFuncionContext ctx) {
        String functionName = ctx.ID().getText();
        String returnType = ctx.tipoDato().getText();
        symbolTable.enterLocalScope(functionName);

        // Maneja los parámetros
        List<SimpleParser.TipoDatoContext> paramTypes = ctx.parametros().tipoDato();
        List<TerminalNode> paramIDs = ctx.parametros().ID();
        
        Function function = new Function(functionName, returnType);
        for (int i = 0; i < paramTypes.size(); i++) {
            String paramName = paramIDs.get(i).getText();
            String paramType = paramTypes.get(i).getText();
            function.addParameter(paramName);
            symbolTable.addLocalSymbol(paramName, new Symbol(paramName, paramType));
        }
        symbolTable.addGlobalFunction(function);

        // Procesa el bloque de la función
        visit(ctx.bloque());
        symbolTable.exitLocalScope();
        return null;
    }

    @Override
    public Void visitCondif(SimpleParser.CondifContext ctx) {
        String elseLabel = generateLabel();
        String endLabel = generateLabel();

        String condition = ctx.operacion().getText();
        String tempVar = generateTempVar();
        String code = tempVar + " := " + condition;
        threeAddressCode.add(code);
        threeAddressCode.add("if " + tempVar + " goto " + elseLabel);

        // Visitar el bloque 'if'
        visit(ctx.bloque(0));
        threeAddressCode.add("goto " + endLabel);
        threeAddressCode.add(elseLabel + ":");

        if (ctx.bloque().size() > 1) {
            // Visitar el bloque 'else'
            visit(ctx.bloque(1));
        }

        threeAddressCode.add(endLabel + ":");
        return null;
    }

    @Override
    public Void visitBucleWhile(SimpleParser.BucleWhileContext ctx) {
        String startLabel = generateLabel();
        String endLabel = generateLabel();

        threeAddressCode.add(startLabel + ":");
        String condition = ctx.operacion().getText();
        String tempVar = generateTempVar();
        String code = tempVar + " := " + condition;
        threeAddressCode.add(code);
        threeAddressCode.add("if not " + tempVar + " goto " + endLabel);

        // Visitar el bloque 'while'
        visit(ctx.bloque());

        threeAddressCode.add("goto " + startLabel);
        threeAddressCode.add(endLabel + ":");
        return null;
    }

    @Override
    public Void visitRetorno(SimpleParser.RetornoContext ctx) {
        String returnValue = ctx.operacion().getText();
        threeAddressCode.add("return " + returnValue);
        return null;
    }

    @Override
    public Void visitOperacion(SimpleParser.OperacionContext ctx) {
        if (ctx.expresion() != null) {
            visit(ctx.expresion());
        } else if (ctx.llamadaFuncion() != null) {
            visit(ctx.llamadaFuncion());
        }
        return null;
    }

    @Override
    public Void visitExpresion(SimpleParser.ExpresionContext ctx) {
        if (ctx.operacionComparacion() != null) {
            visit(ctx.operacionComparacion());
        }
        return null;
    }

    @Override
    public Void visitOperacionComparacion(SimpleParser.OperacionComparacionContext ctx) {
        if (ctx.operacionLogica().size() > 1) {
            String leftOperand = ctx.operacionLogica(0).getText();
            String rightOperand = ctx.operacionLogica(1).getText();
            String operator = ctx.getChild(1).getText();
            String tempVar = generateTempVar();
            String code = tempVar + " := " + leftOperand + " " + operator + " " + rightOperand;
            threeAddressCode.add(code);
        } else {
            visit(ctx.operacionLogica(0));
        }
        return null;
    }

    @Override
    public Void visitOperacionLogica(SimpleParser.OperacionLogicaContext ctx) {
        if (ctx.operacionAritmetica().size() > 1) {
            String leftOperand = ctx.operacionAritmetica(0).getText();
            String rightOperand = ctx.operacionAritmetica(1).getText();
            String operator = ctx.getChild(1).getText();
            String tempVar = generateTempVar();
            String code = tempVar + " := " + leftOperand + " " + operator + " " + rightOperand;
            threeAddressCode.add(code);
        } else {
            visit(ctx.operacionAritmetica(0));
        }
        return null;
    }

    @Override
    public Void visitOperacionAritmetica(SimpleParser.OperacionAritmeticaContext ctx) {
        if (ctx.term().size() > 1) {
            String leftOperand = ctx.term(0).getText();
            String rightOperand = ctx.term(1).getText();
            String operator = ctx.getChild(1).getText();
            String tempVar = generateTempVar();
            String code = tempVar + " := " + leftOperand + " " + operator + " " + rightOperand;
            threeAddressCode.add(code);
        } else {
            visit(ctx.term(0));
        }
        return null;
    }

    @Override
    public Void visitTerm(SimpleParser.TermContext ctx) {
        if (ctx.factor().size() > 1) {
            String leftOperand = ctx.factor(0).getText();
            String rightOperand = ctx.factor(1).getText();
            String operator = ctx.getChild(1).getText();
            String tempVar = generateTempVar();
            String code = tempVar + " := " + leftOperand + " " + operator + " " + rightOperand;
            threeAddressCode.add(code);
        } else {
            visit(ctx.factor(0));
        }
        return null;
    }

    @Override
    public Void visitFactor(SimpleParser.FactorContext ctx) {
        if (ctx.PA() != null && ctx.operacion() != null && ctx.PC() != null) {
            visit(ctx.operacion());
        } else if (ctx.ID() != null) {
            // Aquí puedes manejar la lógica de acceso a variables
        } else if (ctx.INTEGER() != null) {
            // Aquí puedes manejar la lógica de valores enteros
        } else if (ctx.DECIMAL() != null) {
            // Aquí puedes manejar la lógica de valores decimales
        } else if (ctx.CHARACTER() != null) {
            // Aquí puedes manejar la lógica de valores de caracteres
        }
        return null;
    }

    @Override
    public Void visitLlamadaFuncion(SimpleParser.LlamadaFuncionContext ctx) {
        String functionName = ctx.ID().getText();
        List<SimpleParser.OperacionContext> args = ctx.argumentos().operacion();
        for (SimpleParser.OperacionContext arg : args) {
            visit(arg);
        }
        String tempVar = generateTempVar();
        threeAddressCode.add(tempVar + " := call " + functionName);
        return null;
    }

    @Override
    public Void visitBloque(SimpleParser.BloqueContext ctx) {
        visitChildren(ctx);
        return null;
    }

    private String generateTempVar() {
        return "t" + (tempCount++);
    }

    private String generateLabel() {
        return "L" + (labelCount++);
    }

    public List<String> getThreeAddressCode() {
        return threeAddressCode;
    }

    public List<String> getOptimizedCode() {
        return optimizedCode;
    }

    private void generateOptimizedCode() {
        // Implementar la optimización del código de tres direcciones aquí
        optimizedCode.addAll(threeAddressCode);
    }




    public List<String> getErrors() {
        return errors;
    }

}
