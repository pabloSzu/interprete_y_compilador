package proyectoFinal.Interpretador.TablaSimbolos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class SymbolTable {
    private Map<String, Symbol> globalSymbols = new HashMap<>();
    private Stack<Map<String, Symbol>> localSymbolStack = new Stack<>();

    // Constructor para inicializar el stack con un contexto vacío
    public SymbolTable() {
        localSymbolStack.push(new HashMap<>());
    }

    public void addGlobalSymbol(String name, Symbol symbol) {
        globalSymbols.put(name, symbol);
    }

    public void addLocalSymbol(String name, Symbol symbol) {
        localSymbolStack.peek().put(name, symbol);
    }

    public boolean contains(String name) {
        for (Map<String, Symbol> localSymbols : localSymbolStack) {
            if (localSymbols.containsKey(name)) {
                return true;
            }
        }
        return globalSymbols.containsKey(name);
    }

    public Symbol getSymbol(String name) {
        for (Map<String, Symbol> localSymbols : localSymbolStack) {
            if (localSymbols.containsKey(name)) {
                return localSymbols.get(name);
            }
        }
        return globalSymbols.get(name);
    }

    // Métodos para manejar el stack de símbolos locales
    public void enterLocalScope() {
        localSymbolStack.push(new HashMap<>());
    }

    public void exitLocalScope() {
        localSymbolStack.pop();
    }

    public void clearLocalSymbols() {
        if (!localSymbolStack.isEmpty()) {
            localSymbolStack.peek().clear();
        }
    }

    public void writeToFile(String filePath) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("Global Symbols:\n");
        for (Map.Entry<String, Symbol> entry : globalSymbols.entrySet()) {
            sb.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }
        sb.append("Local Symbols:\n");
        for (Map<String, Symbol> localSymbols : localSymbolStack) {
            for (Map.Entry<String, Symbol> entry : localSymbols.entrySet()) {
                sb.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
            }
        }
        Files.write(Paths.get(filePath), sb.toString().getBytes());
    }
}
