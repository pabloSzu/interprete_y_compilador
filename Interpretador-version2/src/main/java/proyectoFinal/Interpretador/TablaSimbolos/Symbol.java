package proyectoFinal.Interpretador.TablaSimbolos;

public class Symbol {
    private String name;
    private String type;
    private boolean isUsed;
    private boolean isInitialized;

    public Symbol(String name, String type) {
        this.name = name;
        this.type = type;
        this.isUsed = false;
        this.isInitialized = false;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public boolean isUsed() {
        return isUsed;
    }

    public void setUsed(boolean used) {
        isUsed = used;
    }

    public boolean isInitialized() {
        return isInitialized;
    }

    public void setInitialized(boolean initialized) {
        isInitialized = initialized;
    }

    @Override
    public String toString() {
        return "Symbol{name='" + name + "', type='" + type + "'}";
    }

}
