package proyectoFinal.Interpretador;

import proyectoFinal.Interpretador.TablaSimbolos.SymbolTable;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

public class Main {

    private static final String EXTENSION = "smp";
    private static final String DIRBASE = "src/test/resources/";
    private static final String OUTPUT_DIR = "src/test/output/";

    public static void main(String[] args) {
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

        // Si no se pasan argumentos, usar un archivo de prueba por defecto
        String[] files = args.length == 0 ? new String[]{ "test." + EXTENSION } : args;

        System.out.println("Dirbase: " + DIRBASE);

        for (String file : files) {
            System.out.println("START: " + file);

            // Crear la ruta completa del archivo de entrada
            String inputFilePath = DIRBASE + file;

            try {
                CharStream in = CharStreams.fromFileName(inputFilePath);
                SimpleLexer lexer = new SimpleLexer(in);
                CommonTokenStream tokens = new CommonTokenStream(lexer);
                SimpleParser parser = new SimpleParser(tokens);
                SimpleParser.ProgContext tree = parser.prog();

                SimpleCustomVisitor visitor = new SimpleCustomVisitor();
                visitor.visit(tree);

                SymbolTable symbolTable = visitor.getSymbolTable();
                String baseFileName = file.replace(".", "_");

                // Crear archivo de tabla de símbolos
                String symbolTableFilePath = OUTPUT_DIR + "symbol_table_" + baseFileName + ".txt";
                String symbolTableContent = symbolTable.toString();
                System.out.println("Symbol Table Content:\n" + symbolTableContent);
                writeToFile(symbolTableFilePath, symbolTableContent);

                // Crear archivo de código de tres direcciones
                String threeAddressCodeFilePath = OUTPUT_DIR + "three_address_code_" + baseFileName + ".txt";
                writeToFile(threeAddressCodeFilePath, String.join("\n", visitor.getThreeAddressCode()));

                // Crear archivo de código optimizado
                String optimizedCodeFilePath = OUTPUT_DIR + "optimized_code_" + baseFileName + ".txt";
                //writeToFile(optimizedCodeFilePath, String.join("\n", visitor.getOptimizedCode()));

                if (visitor.getCustomErrors().isEmpty()) {
                    System.out.println("No errors found.");
                    System.out.println("Symbol table written to " + symbolTableFilePath);
                    System.out.println("Three address code written to " + threeAddressCodeFilePath);
                    System.out.println("Optimized code written to " + optimizedCodeFilePath);
                } else {
                    System.err.println("Errors found:");
                    for (String error : visitor.getCustomErrors().getAllErrors()) {
                        System.err.println(error);
                    }
                }

            } catch (IOException e) {
                System.err.println("Error reading file: " + inputFilePath);
                e.printStackTrace();
            } catch (Exception e) {
                System.err.println("Error processing file: " + inputFilePath);
                e.printStackTrace();
            }

            System.out.println("FINISH: " + file);
        }
    }

    private static void writeToFile(String filePath, String content) throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(content);
        }
    }
}
