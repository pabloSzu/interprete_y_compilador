package proyectoFinal.Interpretador.TablaSimbolos;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class SymbolTable {
    private Map<String, Symbol> globalSymbols;
    private Map<String, Function> globalFunctions;
    private Stack<Map<String, Symbol>> localScopes;
    private String currentFunctionContext;

    public SymbolTable() {
        this.globalSymbols = new HashMap<>();
        this.globalFunctions = new HashMap<>();
        this.localScopes = new Stack<>();
        this.currentFunctionContext = null;
    }

    public void enterLocalScope(String functionName) {
        currentFunctionContext = functionName;
        localScopes.push(new HashMap<>());
    }

    public void exitLocalScope() {
        localScopes.pop();
        currentFunctionContext = localScopes.isEmpty() ? null : currentFunctionContext;
    }

    public void addGlobalSymbol(String name, Symbol symbol) {
        globalSymbols.put(name, symbol);
    }

    public void addLocalSymbol(String name, Symbol symbol) {
        symbol.setFunctionContext(currentFunctionContext);
        if (!localScopes.isEmpty()) {
            localScopes.peek().put(name, symbol);
        }
    }

    public void addGlobalFunction(Function function) {
        globalFunctions.put(function.getName(), function);
    }

    public Symbol getSymbol(String name) {
        for (Map<String, Symbol> scope : localScopes) {
            if (scope.containsKey(name)) {
                return scope.get(name);
            }
        }
        return globalSymbols.get(name);
    }

    public boolean contains(String name) {
        return getSymbol(name) != null;
    }

    public boolean inLocalScope() {
        return !localScopes.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Global Symbols:\n");
        for (Symbol symbol : globalSymbols.values()) {
            sb.append(symbol).append("\n");
        }
        sb.append("Global Functions:\n");
        for (Function function : globalFunctions.values()) {
            sb.append(function).append("\n");
        }
        sb.append("Local Scopes:\n");
        for (Map<String, Symbol> scope : localScopes) {
            sb.append("Scope:\n");
            for (Symbol symbol : scope.values()) {
                sb.append(symbol).append("\n");
            }
        }
        return sb.toString();
    }
}
