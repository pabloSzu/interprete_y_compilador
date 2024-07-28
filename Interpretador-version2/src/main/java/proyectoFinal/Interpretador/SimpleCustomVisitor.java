package proyectoFinal.Interpretador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import proyectoFinal.Interpretador.TablaSimbolos.Symbol;
import proyectoFinal.Interpretador.TablaSimbolos.SymbolTable;

public class SimpleCustomVisitor extends SimpleBaseVisitor<Void> {

    private SymbolTable symbolTable = new SymbolTable();
    private List<String> errors = new ArrayList<>();
    private Stack<Boolean> contextStack = new Stack<>();
    private List<String> threeAddressCode = new ArrayList<>();
    private List<String> optimizedCode = new ArrayList<>();

    public SimpleCustomVisitor() {
        contextStack.push(false); // Start in global context
    }

    @Override
    public Void visitProg(SimpleParser.ProgContext ctx) {
        System.out.println("Visiting prog...");
        visitChildren(ctx);
        try {
            symbolTable.writeToFile("symbol_table.txt");
            writeThreeAddressCodeToFile("three_address_code.txt");
            generateOptimizedCode();
            writeOptimizedCodeToFile("optimized_code.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Void visitDeclaracionFuncion(SimpleParser.DeclaracionFuncionContext ctx) {
        String functionName = ctx.ID().getText();
        String returnType = ctx.tipoDato().getText();
        symbolTable.addGlobalSymbol(functionName, new Symbol(functionName, returnType));
        System.out.println("Added function symbol: " + functionName + " of type: " + returnType);
        return null;
    }

    @Override
    public Void visitDefinicionFuncion(SimpleParser.DefinicionFuncionContext ctx) {
        String functionName = ctx.ID().getText();
        String returnType = ctx.tipoDato().getText();
        if (!symbolTable.contains(functionName)) {
            symbolTable.addGlobalSymbol(functionName, new Symbol(functionName, returnType));
            System.out.println("Added function symbol: " + functionName + " of type: " + returnType);
        }
        contextStack.push(true); // Entering a new function (local context)
        visit(ctx.parametros());
        visit(ctx.bloque());
        contextStack.pop(); // Leaving the function (return to previous context)
        symbolTable.clearLocalSymbols();
        return null;
    }

    @Override
    public Void visitDeclaracion(SimpleParser.DeclaracionContext ctx) {
        String varName = ctx.ID().getText();
        String varType = ctx.tipoDato().getText();
        if (contextStack.peek()) {
            symbolTable.addLocalSymbol(varName, new Symbol(varName, varType));
        } else {
            symbolTable.addGlobalSymbol(varName, new Symbol(varName, varType));
        }
        System.out.println("Added symbol: " + varName + " of type: " + varType);
        return null;
    }

    @Override
    public Void visitAsignacion(SimpleParser.AsignacionContext ctx) {
        String varName = ctx.ID().getText();
        if (!symbolTable.contains(varName)) {
            errors.add("Error: linea: " + ctx.start.getLine() + "; '" + varName + "' no ha sido declarado (Error semantico)");
        }
        String code = varName + " = " + ctx.operacion().getText() + ";";
        threeAddressCode.add(code);
        return visitChildren(ctx);
    }

    @Override
    public Void visitLlamadaFuncion(SimpleParser.LlamadaFuncionContext ctx) {
        String functionName = ctx.ID().getText();
        if (!symbolTable.contains(functionName)) {
            errors.add("Error: linea: " + ctx.start.getLine() + "; '" + functionName + "' no ha sido declarado (Error semantico)");
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
        visit(ctx.operacion());
        contextStack.push(true); // Entering a new block (local context)
        visit(ctx.bloque(0));
        contextStack.pop(); // Leaving the block
        if (ctx.bloque().size() > 1) {
            contextStack.push(true); // Entering a new block (local context)
            visit(ctx.bloque(1));
            contextStack.pop(); // Leaving the block
        }
        return null;
    }

    @Override
    public Void visitBucleWhile(SimpleParser.BucleWhileContext ctx) {
        visit(ctx.operacion());
        contextStack.push(true); // Entering a new block (local context)
        visit(ctx.bloque());
        contextStack.pop(); // Leaving the block
        return null;
    }

    @Override
    public Void visitBloque(SimpleParser.BloqueContext ctx) {
        contextStack.push(true); // Entering a new block (local context)
        visitChildren(ctx);
        contextStack.pop(); // Leaving the block
        return null;
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
        // Aquí podrías agregar la lógica para optimizar el código de tres direcciones
        // Por simplicidad, vamos a copiar el código de tres direcciones tal como está
        optimizedCode.addAll(threeAddressCode);
    }

    public void writeThreeAddressCodeToFile(String filePath) throws IOException {
        java.nio.file.Files.write(java.nio.file.Paths.get(filePath), threeAddressCode);
    }

    public void writeOptimizedCodeToFile(String filePath) throws IOException {
        java.nio.file.Files.write(java.nio.file.Paths.get(filePath), optimizedCode);
    }
}
