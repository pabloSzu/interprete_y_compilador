
package proyectoFinal.Interpretador;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.antlr.v4.runtime.tree.TerminalNode;

import proyectoFinal.Interpretador.TablaSimbolos.Function;
import proyectoFinal.Interpretador.TablaSimbolos.Symbol;
import proyectoFinal.Interpretador.TablaSimbolos.SymbolTable;


public class SimpleCustomVisitor extends SimpleBaseVisitor<Object> {
    private Stack<String> blockStack = new Stack<>();
    private List<String> errors = new ArrayList<>();
    private SymbolTable symbolTable = new SymbolTable();
    private CustomErrors customErrors = new CustomErrors(); // Instancia de CustomErrors

    @Override
    public Object visitProg(SimpleParser.ProgContext ctx) {
        System.out.println("Visiting prog...");
        symbolTable.addContext();
        visitChildren(ctx); // Visita los hijos del contexto
        if (!blockStack.isEmpty()) {
            errors.add("Unmatched opening braces.");
        }
        symbolTable.removeContext(); // Elimina el contexto al finalizar
        System.out.println("Symbol table after visitProg: " + symbolTable);
        System.out.println("Errors after visitProg: " + errors);
        return null;
    }

    @Override
    public Object visitDeclaracion(SimpleParser.DeclaracionContext ctx) {
        System.out.println("Visiting declaracion...");
        String idName = ctx.ID().getText();
        String type = ctx.tipoDato().getText();
        Symbol symbol = new Symbol(idName, type);
        symbolTable.addToCurrentContext(idName, symbol);
        System.out.println("Added symbol: " + idName + " of type: " + type);
        return super.visitDeclaracion(ctx);
    }

    @Override
    public Object visitAsignacion(SimpleParser.AsignacionContext ctx) {
        System.out.println("Visiting asignacion...");
        handleId(ctx.ID());
        return super.visitAsignacion(ctx);
    }

    @Override
    public Object visitDeclaracionFuncion(SimpleParser.DeclaracionFuncionContext ctx) {
        System.out.println("Visiting declaracionFuncion...");
        symbolTable.addContext(); // Agrega un nuevo contexto para la función
        String idName = ctx.ID().getText();
        String type = ctx.tipoDato().getText();
        Symbol symbol = new Symbol(idName, type);
        symbolTable.addToCurrentContext(idName, symbol);
        System.out.println("Added function symbol: " + idName + " of type: " + type);
        super.visitDeclaracionFuncion(ctx);
        if (blockStack.isEmpty()) {
            errors.add("Unmatched closing brace found in function.");
        } else {
            blockStack.pop();
        }
        symbolTable.removeContext(); // Elimina el contexto de la función después de visitarlo
        return null;
    }

    @Override
    public Object visitLlamadaFuncion(SimpleParser.LlamadaFuncionContext ctx) {
        System.out.println("Visiting llamadaFuncion...");
        handleId(ctx.ID());
        return super.visitLlamadaFuncion(ctx);
    }

    private void handleId(TerminalNode idNode) {
        System.out.println("Handling ID: " + idNode.getText());
        String name = idNode.getText();
        Symbol symbol = symbolTable.searchGlobalId(name);
        if (symbol == null) {
            customErrors.idNoDeclarado(idNode.getSymbol().getLine() + "", name);
        } else {
            symbol.setUsed(true);
        }
    }

    public List<String> getErrors() {
        return errors;
    }

    public SymbolTable getSymbolTable() {
        return symbolTable;
    }
}