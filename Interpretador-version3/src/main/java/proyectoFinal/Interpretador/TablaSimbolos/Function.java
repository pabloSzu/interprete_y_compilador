package proyectoFinal.Interpretador.TablaSimbolos;

import java.util.ArrayList;
import java.util.List;

public class Function extends Symbol {
    private List<String> parameters;
    private boolean hasReturnStatement;

    public Function(String name, String type) {
        super(name, type);
        this.parameters = new ArrayList<>();
        this.hasReturnStatement = false;
    }

    public void addParameter(String parameter) {
        parameters.add(parameter);
    }

    public List<String> getParameters() {
        return parameters;
    }

    public boolean hasReturnStatement() {
        return hasReturnStatement;
    }

    public void setHasReturnStatement(boolean hasReturnStatement) {
        this.hasReturnStatement = hasReturnStatement;
    }

    @Override
    public String toString() {
        return "Function{" +
                "name='" + getName() + '\'' +
                ", type='" + getType() + '\'' +
                ", parameters=" + parameters +
                ", hasReturnStatement=" + hasReturnStatement +
                '}';
    }
}
