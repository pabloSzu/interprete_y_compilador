package proyectoFinal.Interpretador.TablaSimbolos;

public class Symbol {
    private String name;
    private String type;
    private boolean isInitialized;
    private boolean isUsed;
    private String functionContext; // Nombre de la función en la que se declara la variable

    public Symbol(String name, String type) {
        this.name = name;
        this.type = type;
        this.isInitialized = false;
        this.isUsed = false;
        this.functionContext = null;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public boolean isInitialized() {
        return isInitialized;
    }

    public void setInitialized(boolean initialized) {
        isInitialized = initialized;
    }

    public boolean isUsed() {
        return isUsed;
    }

    public void setUsed(boolean used) {
        isUsed = used;
    }

    public String getFunctionContext() {
        return functionContext;
    }

    public void setFunctionContext(String functionContext) {
        this.functionContext = functionContext;
    }

    @Override
    public String toString() {
        return "Symbol{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", isInitialized=" + isInitialized +
                ", isUsed=" + isUsed +
                ", functionContext='" + functionContext + '\'' +
                '}';
    }
}
