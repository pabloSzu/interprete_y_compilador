package proyectoFinal.Interpretador;

import java.util.ArrayList;

public class CustomErrors {

    private static final String ERROR_PREFIX = "Error: ";
    private static final String WARNING_PREFIX = "Warning: ";
    private static final String LINE_PREFIX = "linea: ";
    private static final String SEMANTIC_SUFFIX = " (Error semantico)";
    private static final String SYNTAX_SUFFIX = " (Error sintactico)";

    public void noRetorno(String posicion) {
        System.out.println(ERROR_PREFIX + LINE_PREFIX + posicion + "; La funcion necesita un return" + SEMANTIC_SUFFIX);
    }

    public void declaradoComoVariable(String posicion, String id) {
        System.out.println(ERROR_PREFIX + LINE_PREFIX + posicion + "; '" + id + "' se ha declarado como variable" + SEMANTIC_SUFFIX);
    }

    public void funcionVoid(String posicion, String id) {
        System.out.println(ERROR_PREFIX + LINE_PREFIX + posicion + "; '" + id + "' retorna vacio" + SEMANTIC_SUFFIX);
    }

    public void funcionNoDeclarada(String posicion, String id) {
        System.out.println(ERROR_PREFIX + LINE_PREFIX + posicion + "; '" + id + "' se ha definido, pero no declarado" + SEMANTIC_SUFFIX);
    }

    public void cantidadParamArgsDistinta(String posicion) {
        System.out.println(ERROR_PREFIX + LINE_PREFIX + posicion + "; El numero de parametros es distinto al numero de argumentos" + SEMANTIC_SUFFIX);
    }

    public void ordenPrototipo(String posicion) {
        System.out.println(ERROR_PREFIX + LINE_PREFIX + posicion + "; El tipo o el orden no coincide con el prototipo." + SEMANTIC_SUFFIX);
    }

    public void idNoUsado(ArrayList<String> notUsed) {
        for (String id : notUsed) {
            System.out.println(WARNING_PREFIX + "'" + id + "' se ha declarado pero no usado" + SEMANTIC_SUFFIX);
        }
    }

    public void idRedefinido(String posicion, String id) {
        System.out.println(ERROR_PREFIX + LINE_PREFIX + posicion + "; '" + id + "' se ha redefinido" + SEMANTIC_SUFFIX);
    }

    public void idDeclarado(String posicion, String id) {
        System.out.println(ERROR_PREFIX + LINE_PREFIX + posicion + "; '" + id + "' se ha declarado en este contexto" + SEMANTIC_SUFFIX);
    }

    public void idNoDeclarado(String posicion, String id) {
        System.out.println(ERROR_PREFIX + LINE_PREFIX + posicion + "; '" + id + "' no ha sido declarado" + SEMANTIC_SUFFIX);
    }

    public void idDistintosTipos(String posicion, String tipo1, String tipo2) {
        System.out.println(WARNING_PREFIX + LINE_PREFIX + posicion + "; Esta intentando vincular un '" + tipo1 + "' con un '" + tipo2 + "'" + SEMANTIC_SUFFIX);
    }

    public void errorSintactico(String posicion, String msg) {
        System.out.println(ERROR_PREFIX + LINE_PREFIX + posicion + "; " + msg + SYNTAX_SUFFIX);
    }

    public void idNoInicializado(String posicion, String id) {
        System.out.println(ERROR_PREFIX + LINE_PREFIX + posicion + "; '" + id + "' no ha sido inicializado" + SEMANTIC_SUFFIX);
    }

    public void retornoFuncionVoid(String posicion) {
        System.out.println(ERROR_PREFIX + LINE_PREFIX + posicion + "; Una funcion void no retorna valores" + SEMANTIC_SUFFIX);
    }

    public void prototipoContexto(String posicion) {
        System.out.println(ERROR_PREFIX + LINE_PREFIX + posicion + "; El prototipo debe estar en el contexto global" + SEMANTIC_SUFFIX);
    }

    public void idDiferenteTiposParamArgs(String posicion, String tipo1, String tipo2, String id) {
        System.out.println(WARNING_PREFIX + LINE_PREFIX + posicion + "; El tipo '" + tipo1 + "' del argumento '" + id + "' no coincide con el tipo '" + tipo2 + "' del parametro" + SEMANTIC_SUFFIX);
    }

    public void invalidOperation(String posicion, String operation) {
        System.out.println(ERROR_PREFIX + LINE_PREFIX + posicion + "; Operación no válida: '" + operation + "'" + SEMANTIC_SUFFIX);
    }
}
