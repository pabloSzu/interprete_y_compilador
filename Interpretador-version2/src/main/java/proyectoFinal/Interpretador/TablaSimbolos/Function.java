package proyectoFinal.Interpretador.TablaSimbolos;

import java.util.ArrayList;
import java.util.List;

public class Function extends Symbol {

    private List<String> parameters; // Lista de parámetros de la función
    private boolean hasReturn; // Indica si la función tiene una declaración de retorno

    // Constructor que usa el constructor de Symbol
    public Function(String name) {
        super(name, "function"); // Asumiendo que "function" es el tipo para Function
        this.parameters = new ArrayList<>();
        this.hasReturn = false;
    }

    /**
     * Añade un parámetro a la lista de parámetros de la función.
     * @param paramName Nombre del parámetro.
     */
    public void addParameter(String paramName) {
        if (paramName == null || paramName.isEmpty()) {
            throw new IllegalArgumentException("Parameter name cannot be null or empty");
        }
        if (!parameters.contains(paramName)) {
            parameters.add(paramName);
        }
    }

    /**
     * Devuelve la lista de parámetros de la función.
     * @return Lista de nombres de parámetros.
     */
    public List<String> getParameters() {
        return new ArrayList<>(parameters); // Retorna una copia para proteger el estado interno
    }

    /**
     * Verifica si la función tiene un parámetro con el nombre dado.
     * @param paramName Nombre del parámetro a verificar.
     * @return true si el parámetro está en la lista, false en caso contrario.
     */
    public boolean hasParameter(String paramName) {
        return parameters.contains(paramName);
    }

    /**
     * Marca la función como que tiene una declaración de retorno.
     * @param hasReturn true si la función tiene un retorno, false en caso contrario.
     */
    public void setHasReturn(boolean hasReturn) {
        this.hasReturn = hasReturn;
    }

    /**
     * Verifica si la función tiene una declaración de retorno.
     * @return true si la función tiene un retorno, false en caso contrario.
     */
    public boolean hasReturn() {
        return hasReturn;
    }

    @Override
    public String toString() {
        return super.toString() + " Parameters: " + parameters.toString() + ", Has return: " + hasReturn;
    }
}
