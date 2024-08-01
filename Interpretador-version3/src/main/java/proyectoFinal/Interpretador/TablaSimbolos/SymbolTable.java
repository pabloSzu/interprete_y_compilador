package proyectoFinal.Interpretador.TablaSimbolos;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class SymbolTable {
    private Map<String, Symbol> globalSymbols = new HashMap<>();
    private Stack<Map<String, Symbol>> localSymbolStack = new Stack<>();

    public void addGlobalSymbol(String name, Symbol symbol) {
        globalSymbols.put(name, symbol);
    }

    public void addLocalSymbol(String name, Symbol symbol) {
        if (!localSymbolStack.isEmpty()) {
            localSymbolStack.peek().put(name, symbol);
        }
    }

    public void enterLocalScope() {
        localSymbolStack.push(new HashMap<>());
    }

    public void exitLocalScope() {
        if (!localSymbolStack.isEmpty()) {
            localSymbolStack.pop();
        }
    }

    public boolean contains(String name) {
        if (!localSymbolStack.isEmpty() && localSymbolStack.peek().containsKey(name)) {
            return true;
        }
        return globalSymbols.containsKey(name);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Global Symbols:\n");
        for (Map.Entry<String, Symbol> entry : globalSymbols.entrySet()) {
            sb.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }
        sb.append("Local Symbols:\n");
        for (int i = localSymbolStack.size() - 1; i >= 0; i--) {
            sb.append("Scope ").append(i).append(":\n");
            Map<String, Symbol> localSymbols = localSymbolStack.get(i);
            for (Map.Entry<String, Symbol> entry : localSymbols.entrySet()) {
                sb.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
            }
        }
        return sb.toString();
    }

}
