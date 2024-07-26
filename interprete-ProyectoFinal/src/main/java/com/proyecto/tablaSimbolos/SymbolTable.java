package com.proyecto.tablaSimbolos;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

public class SymbolTable {

    private LinkedList<HashMap<String, Symbol>> symbolTable;

    public SymbolTable() {
        symbolTable = new LinkedList<>();
    }

    /*
     * Creates an empty context
     */
    public void addContext() {
        HashMap<String, Symbol> context = new HashMap<>();
        this.symbolTable.add(context);
    }

    /*
     * Removes the last context
     */
    public void removeContext() {
        if (!symbolTable.isEmpty()) {
            this.symbolTable.removeLast();
        }
    }

    /*
     * Finds unused variables that are not functions or are not the main function.
     * If it’s not an instance of Function and is not initialized, it will be added to the list.
     * Returns a list of unused variables
     */
    public ArrayList<String> findUnusedIds() {
        ArrayList<String> unusedVariables = new ArrayList<>();
        HashMap<String, Symbol> lastContext = symbolTable.getLast();
        for (Entry<String, Symbol> entry : lastContext.entrySet()) {
            Symbol symbol = entry.getValue();
            if (!symbol.isUsed() && !symbol.getName().equals("main")) {
                if (symbol instanceof Function && !symbol.isInitialized()) {
                    continue;
                } else {
                    unusedVariables.add(entry.getKey());
                }
            }
        }
        return unusedVariables;
    }


    /*
     * Puts the values into the current context
     */
    public void addToCurrentContext(String key, Symbol value) {
        this.symbolTable.getLast().put(key, value);
    }

    /*
     * Searches for the symbol in the local context, if not found, searches in other contexts
     */
    public Symbol searchGlobalId(String id) {
        Symbol symbol = searchLocalId(id);
        if (symbol != null) {
            return symbol;
        } else {
            for (int i = symbolTable.size() - 2; i >= 0; i--) {
                symbol = symbolTable.get(i).get(id);
                if (symbol != null) {
                    return symbol;
                }
            }
        }
        return null;
    }

    /*
     * Searches for the symbol in the local context
     */
    public Symbol searchLocalId(String id) {
        return symbolTable.getLast().get(id);
    }

    /*
     * Returns the symbol table with all contexts
     */
    public LinkedList<HashMap<String, Symbol>> getSymbolTable() {
        return symbolTable;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int contextIndex = 1;
        for (HashMap<String, Symbol> context : symbolTable) {
            sb.append("Context ").append(contextIndex++).append(":\n");
            for (Entry<String, Symbol> entry : context.entrySet()) {
                sb.append("  ").append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
            }
            sb.append("\n");
        }
        return sb.toString();
    }


    /*
     * Writes the symbol table to a file
     */
    public void writeToFile(String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            if (symbolTable.isEmpty()) {
                writer.write("Symbol table is empty.\n");
            } else {
                writer.write(toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
