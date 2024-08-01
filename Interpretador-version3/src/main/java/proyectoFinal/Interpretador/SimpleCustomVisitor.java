package proyectoFinal.Interpretador;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.antlr.v4.runtime.tree.TerminalNode;

import proyectoFinal.Interpretador.TablaSimbolos.Symbol;
import proyectoFinal.Interpretador.TablaSimbolos.SymbolTable;
import proyectoFinal.Interpretador.TablaSimbolos.Function;

public class SimpleCustomVisitor extends SimpleBaseVisitor<Void> {

/*
symbolTable: una instancia de SymbolTable para gestionar símbolos.
customErrors: instancia de CustomErrors para manejar errores personalizados.
errors: lista para almacenar errores encontrados.
contextStack: pila para gestionar el contexto actual (global o local).
threeAddressCode: lista para almacenar el código de tres direcciones generado.
optimizedCode: lista para almacenar el código optimizado.
tempCount y labelCount: contadores para variables temporales y etiquetas. 
*/

    private SymbolTable symbolTable = new SymbolTable();
    private CustomErrors customErrors = new CustomErrors();
    private List<String> errors = new ArrayList<>();
    private Stack<Boolean> contextStack = new Stack<>();
    private List<String> threeAddressCode = new ArrayList<>();
    private List<String> optimizedCode = new ArrayList<>();
    private int tempCount = 0;
    private int labelCount = 0;


// Constructor de la clase que inicializa la pila de contexto con false, indicando que comienza en el contexto global.
    public SimpleCustomVisitor() {
        contextStack.push(false); 
    }


//Método sobrescrito para manejar la visita a un contexto ProgContext. Llama a visitChildren para procesar los nodos hijos y luego genera el código optimizado.
    @Override
    public Void visitProg(SimpleParser.ProgContext ctx) {
        visitChildren(ctx);
        generateOptimizedCode();
        return null;
    }



//Maneja la visita a DeclaracionFuncionContext, que se usa para declarar funciones y agregar símbolos globales a la tabla de símbolos.
    @Override
    public Void visitDeclaracionFuncion(SimpleParser.DeclaracionFuncionContext ctx) {
        
        // Function declarations are used to populate the symbol table
        String functionName = ctx.ID().getText();
        String returnType = ctx.tipoDato().getText();
        symbolTable.addGlobalSymbol(functionName, new Symbol(functionName, returnType));
        return null;
    }


/*
 Maneja la visita a DefinicionFuncionContext, que se usa para definir funciones:
    Abre un nuevo contexto local.
    Agrega parámetros a la tabla de símbolos y genera el código de tres direcciones para cada parámetro.
    Llama a visit para procesar el cuerpo de la función.
    Si la función tiene un tipo de retorno, añade una declaración de retorno.
    Finaliza la definición de la función y cierra el contexto local.
 */
@Override
public Void visitDefinicionFuncion(SimpleParser.DefinicionFuncionContext ctx) {
    String functionName = ctx.ID().getText();
    contextStack.push(true); // Entrar en el contexto local de la función

    // Crear un nuevo contexto local para la función
    symbolTable.enterLocalScope();
    threeAddressCode.add("func " + functionName + " {");
    
    // Manejar parámetros
    if (ctx.parametros() != null) {
        List<SimpleParser.TipoDatoContext> paramTypes = ctx.parametros().tipoDato();
        List<TerminalNode> paramIDs = ctx.parametros().ID();
        
        Function function = new Function(functionName);
        for (int i = 0; i < paramTypes.size(); i++) {
            String paramName = paramIDs.get(i).getText();
            String paramType = paramTypes.get(i).getText();
            function.addParameter(paramName);
            symbolTable.addLocalSymbol(paramName, new Symbol(paramName, paramType));
            threeAddressCode.add("param " + paramName);
        }
        symbolTable.addGlobalSymbol(functionName, function);
    }

    // Visitar el cuerpo de la función
    visit(ctx.bloque());

    // Si la función debe devolver un valor, añadir una declaración de retorno
    if (ctx.tipoDato() != null) {
        String returnVar = "t" + (tempCount - 1); // Variable temporal de retorno
        threeAddressCode.add("return " + returnVar);
    }

    // Terminar la definición de la función
    threeAddressCode.add("}");
    symbolTable.exitLocalScope();
    contextStack.pop(); // Salir del contexto local de la función
    return null;
}



/*
Maneja la visita a DeclaracionContext, que se usa para declarar variables:
    Agrega la variable a la tabla de símbolos (local o global según el contexto).
    Si hay una operación asociada, genera el código de tres direcciones para la operación y la asignación.
*/

@Override
public Void visitDeclaracion(SimpleParser.DeclaracionContext ctx) {
    String varName = ctx.ID().getText();
    String varType = ctx.tipoDato().getText();

    // Añadir símbolo a la tabla según el contexto actual
    if (contextStack.peek()) {
        // En contexto local
        symbolTable.addLocalSymbol(varName, new Symbol(varName, varType));
        System.out.println("Added local symbol: " + varName + " of type: " + varType);
    } else {
        // En contexto global
        symbolTable.addGlobalSymbol(varName, new Symbol(varName, varType));
        System.out.println("Added global symbol: " + varName + " of type: " + varType);
    }

    // Imprimir la tabla de símbolos actual
    System.out.println("Current symbol table:");
    System.out.println(symbolTable);

    // Generar código de tres direcciones si hay una operación
    if (ctx.operacion() != null) {
        String operation = ctx.operacion().getText();
        String tempVar = generateTempVar();
        String code = tempVar + " := " + operation;
        threeAddressCode.add(code);
        code = varName + " := " + tempVar;
        threeAddressCode.add(code);
    }

    return null;
}






/*
Maneja la visita a AsignacionContext, que se usa para asignar valores a variables:
    Verifica si la variable está declarada.
    Genera el código de tres direcciones para la operación y la asignación.
*/
    @Override
    public Void visitAsignacion(SimpleParser.AsignacionContext ctx) {
        String varName = ctx.ID().getText();
        if (!symbolTable.contains(varName)) {
            customErrors.idNoDeclarado(String.valueOf(ctx.start.getLine()), varName);
        }
        String operation = ctx.operacion().getText();
        String tempVar = generateTempVar();
        String code = tempVar + " := " + operation;
        threeAddressCode.add(code);
        code = varName + " := " + tempVar;
        threeAddressCode.add(code);
        return visitChildren(ctx);
    }



/*
Maneja la visita a LlamadaFuncionContext, que se usa para las llamadas a funciones:
    Verifica si la función está declarada.
    Genera el código de tres direcciones para la llamada a la función y almacena el resultado en una variable temporal.
*/
    @Override
    public Void visitLlamadaFuncion(SimpleParser.LlamadaFuncionContext ctx) {
        String functionName = ctx.ID().getText();
        if (!symbolTable.contains(functionName)) {
            customErrors.funcionNoDeclarada(String.valueOf(ctx.start.getLine()), functionName);
        }

        StringBuilder argList = new StringBuilder();
        List<SimpleParser.OperacionContext> args = ctx.argumentos().operacion();
        for (int i = 0; i < args.size(); i++) {
            if (i > 0) argList.append(", ");
            argList.append(args.get(i).getText());
        }
        
        String tempVar = generateTempVar();
        String code = tempVar + " := call " + functionName + "(" + argList.toString() + ")";
        threeAddressCode.add(code);
        return visitChildren(ctx);
    }



/*
Maneja la visita a CondifContext, que se usa para las estructuras condicionales (if):
    Genera etiquetas para las ramas else y el final.
    Evalúa la condición y genera el código de tres direcciones.
    Visita el bloque de código para la condición verdadera y falsa si existe.
*/
    @Override
    public Void visitCondif(SimpleParser.CondifContext ctx) {
        String elseLabel = generateLabel();
        String endLabel = generateLabel();
    
        // Visit condition
        String condition = ctx.operacion().getText();
        String tempVar = generateTempVar();
        String code = tempVar + " := " + condition;
        threeAddressCode.add(code);
        threeAddressCode.add("if " + tempVar + " goto " + elseLabel);
    
        // Visit true block
        threeAddressCode.add("{");
        contextStack.push(true); // Entering a new block (local context)
        visit(ctx.bloque(0));
        contextStack.pop(); // Leaving the block
        threeAddressCode.add("}");
        threeAddressCode.add("goto " + endLabel);
    
        // Visit false block if exists
        threeAddressCode.add(elseLabel + ": {");
        if (ctx.bloque().size() > 1) {
            contextStack.push(true); // Entering a new block (local context)
            visit(ctx.bloque(1));
            contextStack.pop(); // Leaving the block
        }
    
        // End label
        threeAddressCode.add("} " + endLabel + ":");
        return null;
    }




/*
Maneja la visita a BucleWhileContext, que se usa para los bucles while:
    Genera etiquetas para el inicio y el fin del bucle.
    Evalúa la condición del bucle y genera el código de tres direcciones.
    Visita el cuerpo del bucle y luego vuelve al inicio del bucle.
*/
    @Override
    public Void visitBucleWhile(SimpleParser.BucleWhileContext ctx) {
        String startLabel = generateLabel();
        String endLabel = generateLabel();

        threeAddressCode.add(startLabel + ":");

        // Visit condition
        String condition = ctx.operacion().getText();
        String tempVar = generateTempVar();
        String code = tempVar + " := " + condition;
        threeAddressCode.add(code);
        threeAddressCode.add("if " + tempVar + " goto " + endLabel);

        // Visit loop body
        threeAddressCode.add("{");
        contextStack.push(true); // Entering a new block (local context)
        visit(ctx.bloque());
        contextStack.pop(); // Leaving the block
        threeAddressCode.add("}");
        threeAddressCode.add("goto " + startLabel);

        // End label
        threeAddressCode.add(endLabel + ":");
        return null;
    }


/*
Maneja la visita a BloqueContext, que se usa para bloques de código:
    Agrega { al código de tres direcciones al inicio y } al final.
    Cambia el contexto al local mientras procesa los hijos del bloque.
*/
    @Override
    public Void visitBloque(SimpleParser.BloqueContext ctx) {
        threeAddressCode.add("{");
        contextStack.push(true); // Entrar en un nuevo bloque (contexto local)
        visitChildren(ctx);
        contextStack.pop(); // Salir del bloque
        threeAddressCode.add("}");
        return null;
    }


//Métodos auxiliares para generar variables temporales y etiquetas.
    private String generateTempVar() {
        return "t" + (tempCount++);
    }

//Métodos auxiliares para generar variables temporales y etiquetas.
    private String generateLabel() {
        return "L" + (labelCount++);
    }

    public SymbolTable getSymbolTable() {
        return symbolTable;
    }

    public List<String> getErrors() {
        return errors;
    }

    public List<String> getThreeAddressCode() {
        return threeAddressCode;
    }

    public List<String> getOptimizedCode() {
        return optimizedCode;
    }

    private void generateOptimizedCode() {
        OptimizedCode optimizedCodeGenerator = new OptimizedCode(threeAddressCode);
        this.optimizedCode = optimizedCodeGenerator.getOptimizedCode();
        optimizedCodeGenerator.printCode();
    }
}
