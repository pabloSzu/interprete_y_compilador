package com.proyecto.interprete_ProyectoFinal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.proyecto.tablaSimbolos.Symbol;
import com.proyecto.tablaSimbolos.SymbolTable;

public class SimpleCustomVisitor extends SimpleBaseVisitor<Object> {
    private Stack<String> blockStack = new Stack<>();
    private List<String> errors = new ArrayList<>();
    private SymbolTable symbolTable = new SymbolTable();
    private CustomErrors customErrors = new CustomErrors(); // Añadir esta línea

    @Override
    public Object visitProgram(SimpleParser.ProgramContext ctx) {
        symbolTable.addContext();
        super.visitProgram(ctx);
        if (!blockStack.isEmpty()) {
            errors.add("Unmatched opening braces.");
        }
        System.out.println("Symbol table after visitProgram: " + symbolTable);
        return null;
    }

    @Override
    public Object visitAssignment(SimpleParser.AssignmentContext ctx) {
        String varName = ctx.ID().getText();
        Symbol symbol = symbolTable.searchGlobalId(varName);
        if (symbol == null) {
            customErrors.idNoDeclarado(ctx.getStart().getLine() + "", varName);
        } else {
            symbol.setUsed(true); // Marca el símbolo como usado
        }
        return super.visitAssignment(ctx);
    }

    // Si necesitas marcar una variable como inicializada
    @Override
    public Object visitDeclaration(SimpleParser.DeclarationContext ctx) {
        String varName = ctx.ID().getText();
        Symbol existingSymbol = symbolTable.searchGlobalId(varName);
        if (existingSymbol != null) {
            customErrors.idRedefinido(ctx.getStart().getLine() + "", varName);
        } else {
            Symbol newSymbol = new Symbol(varName, "int");
            symbolTable.addToCurrentContext(varName, newSymbol);
            System.out.println("Added symbol: " + newSymbol);
        }
        return super.visitDeclaration(ctx);
    }
    
    @Override
    public Object visitFunctionDeclaration(SimpleParser.FunctionDeclarationContext ctx) {
        blockStack.push("{");
        super.visitFunctionDeclaration(ctx);
        if (blockStack.isEmpty()) {
            errors.add("Unmatched closing brace found in function.");
        } else {
            blockStack.pop();
        }
        return null;
    }

    public List<String> getErrors() {
        return errors;
    }

    public SymbolTable getSymbolTable() {
        return symbolTable;
    }
}
