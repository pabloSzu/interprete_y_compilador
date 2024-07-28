package proyectoFinal.Interpretador;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
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
            System.err.println("Error: no se pudo crear el directorio de salida.");
            return;
        }

        File dir = new File(DIRBASE);
        File[] files = dir.listFiles((d, name) -> name.endsWith(EXTENSION));

        if (files == null) {
            System.err.println("Error: no se encontraron archivos con la extensión " + EXTENSION + " en el directorio especificado.");
            return;
        }

        for (File file : files) {
            processFile(file);
        }
    }

    private static void processFile(File file) throws IOException {
        CharStream input = CharStreams.fromFileName(file.getAbsolutePath());
        SimpleLexer lexer = new SimpleLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        SimpleParser parser = new SimpleParser(tokens);

        SimpleCustomVisitor visitor = new SimpleCustomVisitor();
        visitor.visit(parser.prog());

        // Escribir los resultados a archivos
        String baseFileName = file.getName().replace("." + EXTENSION, "");

        // Escribir la tabla de símbolos
        SymbolTable symbolTable = visitor.getSymbolTable();
        String symbolTablePath = OUTPUT_DIR + baseFileName + "_symbol_table.txt";
        symbolTable.writeToFile(symbolTablePath);

        // Escribir el código de tres direcciones
        String threeAddressCodePath = OUTPUT_DIR + baseFileName + "_three_address_code.txt";
        Files.write(Paths.get(threeAddressCodePath), visitor.getThreeAddressCode());

        // Escribir el código optimizado
        String optimizedCodePath = OUTPUT_DIR + baseFileName + "_optimized_code.txt";
        Files.write(Paths.get(optimizedCodePath), visitor.getOptimizedCode());

        // Escribir errores si los hay
        if (!visitor.getErrors().isEmpty()) {
            String errorsPath = OUTPUT_DIR + baseFileName + "_errors.txt";
            Files.write(Paths.get(errorsPath), visitor.getErrors());
        }

        System.out.println("Processed file: " + file.getName());
    }
}
