package proyectoFinal.Interpretador.TablaSimbolos;

import java.util.ArrayList;
import java.util.List;

public class Function extends Symbol {

    private List<String> parameters; // Lista de parámetros de la función
    private boolean hasReturn; // Indica si la función tiene una declaración de retorno

    public Function(String name) {
        super(name, "function"); // Asumiendo que "function" es el tipo para Function
        this.parameters = new ArrayList<>();
        this.hasReturn = false;
    }

    public void addParameter(String paramName) {
        if (paramName == null || paramName.isEmpty()) {
            throw new IllegalArgumentException("Parameter name cannot be null or empty");
        }
        if (!parameters.contains(paramName)) {
            parameters.add(paramName);
        }
    }

    public List<String> getParameters() {
        return new ArrayList<>(parameters);
    }

    public boolean hasParameter(String paramName) {
        return parameters.contains(paramName);
    }

    public void setHasReturn(boolean hasReturn) {
        this.hasReturn = hasReturn;
    }

    public boolean hasReturn() {
        return hasReturn;
    }

    @Override
    public String toString() {
        return super.toString() + " Parameters: " + parameters.toString() + ", Has return: " + hasReturn;
    }
}
