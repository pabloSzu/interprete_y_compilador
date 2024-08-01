// Generated from proyectoFinal\Interpretador\Simple.g4 by ANTLR 4.9.2
package proyectoFinal.Interpretador;

    import proyectoFinal.Interpretador.TablaSimbolos.Symbol;
    import proyectoFinal.Interpretador.TablaSimbolos.SymbolTable;
    import java.util.Map;
    import java.util.HashMap;
    import java.util.List;
    import java.util.ArrayList;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SimpleParser}.
 */
public interface SimpleListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SimpleParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(SimpleParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(SimpleParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#instrucciones}.
	 * @param ctx the parse tree
	 */
	void enterInstrucciones(SimpleParser.InstruccionesContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#instrucciones}.
	 * @param ctx the parse tree
	 */
	void exitInstrucciones(SimpleParser.InstruccionesContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void enterInstruccion(SimpleParser.InstruccionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void exitInstruccion(SimpleParser.InstruccionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#retorno}.
	 * @param ctx the parse tree
	 */
	void enterRetorno(SimpleParser.RetornoContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#retorno}.
	 * @param ctx the parse tree
	 */
	void exitRetorno(SimpleParser.RetornoContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#declaracion}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracion(SimpleParser.DeclaracionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#declaracion}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracion(SimpleParser.DeclaracionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#asignacion}.
	 * @param ctx the parse tree
	 */
	void enterAsignacion(SimpleParser.AsignacionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#asignacion}.
	 * @param ctx the parse tree
	 */
	void exitAsignacion(SimpleParser.AsignacionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#tipoDato}.
	 * @param ctx the parse tree
	 */
	void enterTipoDato(SimpleParser.TipoDatoContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#tipoDato}.
	 * @param ctx the parse tree
	 */
	void exitTipoDato(SimpleParser.TipoDatoContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#condif}.
	 * @param ctx the parse tree
	 */
	void enterCondif(SimpleParser.CondifContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#condif}.
	 * @param ctx the parse tree
	 */
	void exitCondif(SimpleParser.CondifContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#bucleWhile}.
	 * @param ctx the parse tree
	 */
	void enterBucleWhile(SimpleParser.BucleWhileContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#bucleWhile}.
	 * @param ctx the parse tree
	 */
	void exitBucleWhile(SimpleParser.BucleWhileContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#declaracionFuncion}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracionFuncion(SimpleParser.DeclaracionFuncionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#declaracionFuncion}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracionFuncion(SimpleParser.DeclaracionFuncionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#definicionFuncion}.
	 * @param ctx the parse tree
	 */
	void enterDefinicionFuncion(SimpleParser.DefinicionFuncionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#definicionFuncion}.
	 * @param ctx the parse tree
	 */
	void exitDefinicionFuncion(SimpleParser.DefinicionFuncionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#parametros}.
	 * @param ctx the parse tree
	 */
	void enterParametros(SimpleParser.ParametrosContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#parametros}.
	 * @param ctx the parse tree
	 */
	void exitParametros(SimpleParser.ParametrosContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#llamadaFuncion}.
	 * @param ctx the parse tree
	 */
	void enterLlamadaFuncion(SimpleParser.LlamadaFuncionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#llamadaFuncion}.
	 * @param ctx the parse tree
	 */
	void exitLlamadaFuncion(SimpleParser.LlamadaFuncionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#llamadaPrint}.
	 * @param ctx the parse tree
	 */
	void enterLlamadaPrint(SimpleParser.LlamadaPrintContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#llamadaPrint}.
	 * @param ctx the parse tree
	 */
	void exitLlamadaPrint(SimpleParser.LlamadaPrintContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#llamadaPrintf}.
	 * @param ctx the parse tree
	 */
	void enterLlamadaPrintf(SimpleParser.LlamadaPrintfContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#llamadaPrintf}.
	 * @param ctx the parse tree
	 */
	void exitLlamadaPrintf(SimpleParser.LlamadaPrintfContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#argumentos}.
	 * @param ctx the parse tree
	 */
	void enterArgumentos(SimpleParser.ArgumentosContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#argumentos}.
	 * @param ctx the parse tree
	 */
	void exitArgumentos(SimpleParser.ArgumentosContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#operacion}.
	 * @param ctx the parse tree
	 */
	void enterOperacion(SimpleParser.OperacionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#operacion}.
	 * @param ctx the parse tree
	 */
	void exitOperacion(SimpleParser.OperacionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExpresion(SimpleParser.ExpresionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExpresion(SimpleParser.ExpresionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#operacionComparacion}.
	 * @param ctx the parse tree
	 */
	void enterOperacionComparacion(SimpleParser.OperacionComparacionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#operacionComparacion}.
	 * @param ctx the parse tree
	 */
	void exitOperacionComparacion(SimpleParser.OperacionComparacionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#operacionLogica}.
	 * @param ctx the parse tree
	 */
	void enterOperacionLogica(SimpleParser.OperacionLogicaContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#operacionLogica}.
	 * @param ctx the parse tree
	 */
	void exitOperacionLogica(SimpleParser.OperacionLogicaContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#operacionAritmetica}.
	 * @param ctx the parse tree
	 */
	void enterOperacionAritmetica(SimpleParser.OperacionAritmeticaContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#operacionAritmetica}.
	 * @param ctx the parse tree
	 */
	void exitOperacionAritmetica(SimpleParser.OperacionAritmeticaContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(SimpleParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(SimpleParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(SimpleParser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(SimpleParser.FactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#bloque}.
	 * @param ctx the parse tree
	 */
	void enterBloque(SimpleParser.BloqueContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#bloque}.
	 * @param ctx the parse tree
	 */
	void exitBloque(SimpleParser.BloqueContext ctx);
}