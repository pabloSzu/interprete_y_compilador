// Generated from proyectoFinal\Interpretador\Simple.g4 by ANTLR 4.9.2
package proyectoFinal.Interpretador;

    import proyectoFinal.Interpretador.TablaSimbolos.Symbol;
    import proyectoFinal.Interpretador.TablaSimbolos.SymbolTable;
    import java.util.Map;
    import java.util.HashMap;
    import java.util.List;
    import java.util.ArrayList;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SimpleParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SimpleVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SimpleParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(SimpleParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#instrucciones}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstrucciones(SimpleParser.InstruccionesContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#instruccion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstruccion(SimpleParser.InstruccionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#retorno}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRetorno(SimpleParser.RetornoContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#declaracion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracion(SimpleParser.DeclaracionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#asignacion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsignacion(SimpleParser.AsignacionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#tipoDato}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipoDato(SimpleParser.TipoDatoContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#condif}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondif(SimpleParser.CondifContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#bucleWhile}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBucleWhile(SimpleParser.BucleWhileContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#declaracionFuncion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracionFuncion(SimpleParser.DeclaracionFuncionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#definicionFuncion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefinicionFuncion(SimpleParser.DefinicionFuncionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#parametros}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParametros(SimpleParser.ParametrosContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#llamadaFuncion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLlamadaFuncion(SimpleParser.LlamadaFuncionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#argumentos}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgumentos(SimpleParser.ArgumentosContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#operacion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperacion(SimpleParser.OperacionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpresion(SimpleParser.ExpresionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#operacionComparacion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperacionComparacion(SimpleParser.OperacionComparacionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#operacionLogica}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperacionLogica(SimpleParser.OperacionLogicaContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#operacionAritmetica}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperacionAritmetica(SimpleParser.OperacionAritmeticaContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(SimpleParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactor(SimpleParser.FactorContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#bloque}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBloque(SimpleParser.BloqueContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#printStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintStmt(SimpleParser.PrintStmtContext ctx);
}