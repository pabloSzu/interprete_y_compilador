package proyectoFinal.Interpretador;

import java.io.File;
import java.io.IOException;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import proyectoFinal.Interpretador.TablaSimbolos.SymbolTable;


public class Main {

    private static final String EXTENSION = "smp";
    private static final String DIRBASE = "src/test/resources/";
    private static final String OUTPUT_DIR = "src/test/output/";

    public static void main(String[] args) throws IOException {
        // Verificar y crear el directorio de salida si no existe
        File outputDir = new File(OUTPUT_DIR);
        if (!outputDir.exists()) {
            if (outputDir.mkdirs()) {
                System.out.println("Output directory created: " + OUTPUT_DIR);
            } else {
                System.err.println("Failed to create output directory: " + OUTPUT_DIR);
                return; // Termina el programa si no se puede crear el directorio
            }
        }

        String[] files = args.length == 0 ? new String[]{ "test." + EXTENSION } : args;
        System.out.println("Dirbase: " + DIRBASE);

        for (String file : files) {
            System.out.println("START: " + file);

            CharStream in = CharStreams.fromFileName(DIRBASE + file);
            SimpleLexer lexer = new SimpleLexer(in);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            SimpleParser parser = new SimpleParser(tokens);
            SimpleParser.ProgContext tree = parser.prog();

            SimpleCustomVisitor visitor = new SimpleCustomVisitor();
            visitor.visit(tree);

            SymbolTable symbolTable = visitor.getSymbolTable();
            String outputFilePath = OUTPUT_DIR + "symbol_table.txt";

            // Verificar y crear el archivo de salida si no existe
            File outputFile = new File(outputFilePath);
            if (!outputFile.exists()) {
                if (outputFile.createNewFile()) {
                    System.out.println("File created: " + outputFilePath);
                } else {
                    System.err.println("Failed to create file: " + outputFilePath);
                    continue; // Salta al siguiente archivo si no se puede crear el archivo
                }
            }

            if (visitor.getErrors().isEmpty()) {
                System.out.println("No errors found.");
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
