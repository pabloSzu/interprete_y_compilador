package com.proyecto.interprete_ProyectoFinal;

import java.io.File;
import java.io.IOException;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import com.proyecto.tablaSimbolos.SymbolTable;
import com.proyecto.interprete_ProyectoFinal.SimpleCustomVisitor;
import com.proyecto.interprete_ProyectoFinal.SimpleLexer;
import com.proyecto.interprete_ProyectoFinal.SimpleParser;

public class Main {

    private static final String EXTENSION = "smp";
    private static final String DIRBASE = "src/test/resources/";
    private static final String OUTPUT_DIR = "src/test/output/";

    public static void main(String[] args) throws IOException {
    	
    	 File outputDir = new File(OUTPUT_DIR);
         if (!outputDir.exists()) {
             outputDir.mkdirs();
         }
    	

        String files[] = args.length == 0 ? new String[]{ "test." + EXTENSION } : args;
        System.out.println("Dirbase: " + DIRBASE);

        for (String file : files) {
            System.out.println("START: " + file);

            CharStream in = CharStreams.fromFileName(DIRBASE + file);
            SimpleLexer lexer = new SimpleLexer(in);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            SimpleParser parser = new SimpleParser(tokens);
            SimpleParser.ProgramContext tree = parser.program();

            SimpleCustomVisitor visitor = new SimpleCustomVisitor();
            visitor.visit(tree);

            if (visitor.getErrors().isEmpty()) {
                System.out.println("No errors found.");
                SymbolTable symbolTable = visitor.getSymbolTable();
                String outputFilePath = OUTPUT_DIR + "symbol_table.txt";
                symbolTable.writeToFile(outputFilePath);
                System.out.println("Symbol table written to " + outputFilePath);
            } else {
                for (String error : visitor.getErrors()) {
                    System.out.println(error);
                }
            }

            System.out.println("FINISH: " + file);
        }
    }
}
