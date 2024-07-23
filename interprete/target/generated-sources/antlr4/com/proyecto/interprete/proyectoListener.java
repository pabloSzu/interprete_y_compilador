// Generated from proyecto.g4 by ANTLR 4.4
package com.proyecto.interprete;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link proyectoParser}.
 */
public interface proyectoListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link proyectoParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(@NotNull proyectoParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link proyectoParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(@NotNull proyectoParser.StartContext ctx);
}