package com.proyecto.tablaSimbolos;

public class Symbol {
    private String name;
    private String type;
    private boolean initialized;
    private boolean used;

    public Symbol(String name, String type) {
        this.name = name;
        this.type = type;
        this.initialized = false; // Default value
        this.used = false; // Default value
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public boolean isInitialized() {
        return initialized;
    }

    public void setInitialized(boolean initialized) {
        this.initialized = initialized;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    @Override
    public String toString() {
        return "Symbol{name='" + name + "', type='" + type + "', initialized=" + initialized + ", used=" + used + "}";
    }
}
