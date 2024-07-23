package com.proyecto.interprete;

import java.io.IOException;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

public class Main {

    private static final String EXTENSION = "pyc";
    private static final String DIRBASE = "src/test/resources/";

    public static void main(String[] args) throws IOException {
        String files[] = args.length==0? new String[]{ "test." + EXTENSION } : args;
        System.out.println("Dirbase: " + DIRBASE);
        for (String file : files){
            System.out.println("Interpreting file: " + file);

            CharStream in = CharStreams.fromFileName(DIRBASE + file);
            
            proyectoLexer lexer = new proyectoLexer(in);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            proyectoParser parser = new proyectoParser(tokens);
            
            //arbol de sintaxis
            proyectoParser.StartContext tree = parser.start();
            
            proyectoCustomVisitor visitor = new proyectoCustomVisitor();
            
            //visita cada uno de los nodos del arbol
            visitor.visit(tree);

            System.out.println("Interpretation finished: " + file);
        }
    }
}
