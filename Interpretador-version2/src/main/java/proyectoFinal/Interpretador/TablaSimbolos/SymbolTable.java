package proyectoFinal.Interpretador.TablaSimbolos;

import java.util.HashMap;
import java.util.Map;

public class SymbolTable {
    private Map<String, Symbol> globalSymbols = new HashMap<>();
    private Map<String, Symbol> localSymbols = new HashMap<>();

    public void addGlobalSymbol(String name, Symbol symbol) {
        globalSymbols.put(name, symbol);
    }

    public void addLocalSymbol(String name, Symbol symbol) {
        localSymbols.put(name, symbol);
    }

    public boolean contains(String name) {
        return localSymbols.containsKey(name) || globalSymbols.containsKey(name);
    }

    public Symbol getSymbol(String name) {
        if (localSymbols.containsKey(name)) {
            return localSymbols.get(name);
        }
        return globalSymbols.get(name);
    }

    public void clearLocalSymbols() {
        localSymbols.clear();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Global Symbols:\n");
        for (Map.Entry<String, Symbol> entry : globalSymbols.entrySet()) {
            sb.append(entry.getKey()).append(" : ").append(entry.getValue()).append("\n");
        }
        sb.append("Local Symbols:\n");
        for (Map.Entry<String, Symbol> entry : localSymbols.entrySet()) {
            sb.append(entry.getKey()).append(" : ").append(entry.getValue()).append("\n");
        }
        return sb.toString();
    }
}
