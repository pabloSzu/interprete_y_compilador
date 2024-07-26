package proyectoFinal.Interpretador.TablaSimbolos;

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

    public void addContext() {
        HashMap<String, Symbol> context = new HashMap<>();
        this.symbolTable.add(context);
        System.out.println("Added new context. Total contexts: " + symbolTable.size());
    }

    public void removeContext() {
        if (!symbolTable.isEmpty()) {
            this.symbolTable.removeLast();
            System.out.println("Removed last context. Total contexts: " + symbolTable.size());
        }
    }

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

    public void addToCurrentContext(String key, Symbol value) {
        if (!symbolTable.isEmpty()) {
            HashMap<String, Symbol> currentContext = this.symbolTable.getLast();
            currentContext.put(key, value);
            System.out.println("Added to current context: " + key + " -> " + value); // Debugging output
        }
    }

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

    public Symbol searchLocalId(String id) {
        return symbolTable.getLast().get(id);
    }

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
