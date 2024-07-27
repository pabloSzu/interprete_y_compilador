package proyectoFinal.Interpretador.TablaSimbolos;

import java.io.FileWriter;
import java.io.IOException;
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
        return globalSymbols.containsKey(name) || localSymbols.containsKey(name);
    }

    public Symbol getSymbol(String name) {
        return globalSymbols.getOrDefault(name, localSymbols.get(name));
    }

    public void clearLocalSymbols() {
        localSymbols.clear();
    }

    public void writeToFile(String filePath) throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            if (globalSymbols.isEmpty() && localSymbols.isEmpty()) {
                writer.write("Symbol table is empty.\n");
            } else {
                writer.write("Global Symbols:\n");
                for (Map.Entry<String, Symbol> entry : globalSymbols.entrySet()) {
                    writer.write(entry.getKey() + ": " + entry.getValue().toString() + "\n");
                }
                writer.write("Local Symbols:\n");
                for (Map.Entry<String, Symbol> entry : localSymbols.entrySet()) {
                    writer.write(entry.getKey() + ": " + entry.getValue().toString() + "\n");
                }
            }
        }
    }
}
