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
        if (!outputDir.exists() && !outputDir.mkdirs()) {
            System.err.println("Failed to create output directory: " + OUTPUT_DIR);
            return; // Termina el programa si no se puede crear el directorio
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
                String symbolTableFilePath = OUTPUT_DIR + "symbol_table_" + file.replace(".", "_") + ".txt";
                String threeAddressCodeFilePath = OUTPUT_DIR + "three_address_code_" + file.replace(".", "_") + ".txt";
                String optimizedCodeFilePath = OUTPUT_DIR + "optimized_code_" + file.replace(".", "_") + ".txt";

                // Verificar y crear los archivos de salida si no existen
                createFileIfNotExists(symbolTableFilePath);
                createFileIfNotExists(threeAddressCodeFilePath);
                createFileIfNotExists(optimizedCodeFilePath);

                if (visitor.getErrors().isEmpty()) {
                    System.out.println("No errors found.");
                    // Imprimir la tabla de símbolos en la consola
                    symbolTable.print();
                    // Escribir la tabla de símbolos en un archivo
                    symbolTable.writeToFile(symbolTableFilePath);
                    System.out.println("Symbol table written to " + symbolTableFilePath);

                    // Escribir el código de tres direcciones en un archivo
                    visitor.writeThreeAddressCodeToFile(threeAddressCodeFilePath);
                    System.out.println("Three address code written to " + threeAddressCodeFilePath);

                    // Escribir el código optimizado en un archivo
                    visitor.writeOptimizedCodeToFile(optimizedCodeFilePath);
                    System.out.println("Optimized code written to " + optimizedCodeFilePath);
                } else {
                    System.out.println("Errors found:");
                    visitor.getErrors().forEach(System.out::println);
                }

            } catch (IOException e) {
                System.err.println("File not found: " + inputFilePath);
                System.exit(1);
            }
        }
    }

    private static void createFileIfNotExists(String filePath) throws IOException {
        File file = new File(filePath);
        if (!file.exists() && file.createNewFile()) {
            System.out.println("File created: " + filePath);
        } else if (!file.exists()) {
            System.err.println("Failed to create file: " + filePath);
        }
    }
}
