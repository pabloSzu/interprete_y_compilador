// Generated from com\proyecto\interprete\proyecto.g4 by ANTLR 4.9.2
package com.proyecto.interprete;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

/**
 * This class provides an empty implementation of {@link proyectoVisitor},
 * which can be extended to create a visitor which only needs to handle a subset
 * of the available methods.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public class proyectoBaseVisitor<T> extends AbstractParseTreeVisitor<T> implements proyectoVisitor<T> {
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitStart(proyectoParser.StartContext ctx) { return visitChildren(ctx); }
}