package proyectoFinal.Interpretador;

import java.util.ArrayList;
import java.util.List;

public class CustomErrors {

    private String msgError;
    private String msgWarning;
    private String msgLine;
    private String msgSemantico;
    private String msgSintactico;
    private List<String> errors;

    public CustomErrors() {
        msgError = "Error: ";
        msgWarning = "Warning: ";
        msgLine = "linea: ";
        msgSemantico = " " + "(Error semantico)";
        msgSintactico = " " + "(Error sintactico)";
        errors = new ArrayList<>();
    }

    public void noRetorno(String posicion){
        errors.add(msgError + msgLine + posicion + "; La funcion necesita un return" + msgSemantico);
    }

    public void declaradoComoVariable(String posicion, String id){
        errors.add(msgError + msgLine + posicion + "; '" + id + "' se ha declarado como variable" + msgSemantico);
    }

    public void funcionVoid(String posicion, String id){
        errors.add(msgError + msgLine + posicion + "; '" + id + "' retorna vacio" + msgSemantico);
    }

    public void funcionNoDeclarada(String posicion, String id){
        errors.add(msgError + msgLine + posicion + "; '" + id + "' se ha definido, pero no declarado" + msgSemantico);
    }

    public void cantidadParamArgsDistinta(String posicion){
        errors.add(msgError + msgLine + posicion + "; El numero de parametros es distinto al numero de argumentos" + msgSemantico);
    }

    public void ordenPrototipo(String posicion){
        errors.add(msgError + msgLine + posicion + "; El tipo o el orden no coincide con el prototipo." + msgSemantico);
    }

    public void idNoUsado(List<String> notUsed){
        for (String id : notUsed) {
            errors.add(msgWarning + "'" + id + "' se ha declarado pero no usado" + msgSemantico);
        }
    }

    public void idRedefinido(String posicion, String id){
        errors.add(msgError + msgLine + posicion + "; '" + id + "' se ha redefinido" + msgSemantico);
    }

    public void idDeclarado(String posicion, String id){
        errors.add(msgError + msgLine + posicion + "; '" + id + "' se ha declarado en este contexto" + msgSemantico);
    }

    public void idNoDeclarado(String posicion, String id){
        errors.add(msgError + msgLine + posicion + "; '" + id + "' no ha sido declarado" + msgSemantico);
    }

    public void idDistintosTipos(String posicion, String tipo1, String tipo2){
        errors.add(msgWarning + msgLine + posicion + "; Esta intentando vincular un '" + tipo1 + "' con un '" + tipo2 + "'" + msgSemantico);
    }

    public void errorSintactico(String posicion, String msg){
        errors.add(msgError + msgLine + posicion + "; " + msg + msgSintactico);
    }

    public void idNoInicializado(String posicion, String id){
        errors.add(msgError + msgLine + posicion + "; '" + id + "' no ha sido inicializado" + msgSemantico);
    }

    public void retornoFuncionVoid(String posicion){
        errors.add(msgError + msgLine + posicion + "; Una funcion void no retorna valores" + msgSemantico);
    }

    public void prototipoContexto(String posicion){
        errors.add(msgError + msgLine + posicion + "; El prototipo debe estar en el contexto global" + msgSemantico);
    }

    public void idDiferenteTiposParamArgs(String posicion, String tipo1, String tipo2, String id){
        errors.add(msgWarning + msgLine + posicion + "; El tipo '" + tipo1 + "' del argumento '" + id + "' no coincide con el tipo '" + tipo2 + "' del parametro" + msgSemantico);
    }

    public List<String> getAllErrors() {
        return errors;
    }

    public boolean isEmpty() {
        return errors.isEmpty();
    }
}
