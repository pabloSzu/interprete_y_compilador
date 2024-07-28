package proyectoFinal.Interpretador;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OptimizedCode {

    private List<String> threeAddressCode;
    private List<String> optimizedCode;

    public OptimizedCode(List<String> threeAddressCode) {
        this.threeAddressCode = new ArrayList<>(threeAddressCode);
        this.optimizedCode = new ArrayList<>();
        generateOptimizedCode();
    }

    private void generateOptimizedCode() {
        Map<String, String> constants = new HashMap<>();
        Map<String, String> lastValue = new HashMap<>();
        Set<String> calledFunctions = new HashSet<>();
        
        Pattern constantPattern = Pattern.compile("\\d+");

        for (String line : threeAddressCode) {
            if (line.contains("=")) {
                String[] parts = line.split("=");
                if (parts.length != 2) continue;

                String left = parts[0].trim();
                String right = parts[1].trim();

                if (isConstantExpression(right, constantPattern)) {
                    constants.put(left, right);
                    optimizedCode.add(left + " = " + right + ";  // Optimized by propagating constant value.");
                } else if (constants.containsKey(right)) {
                    optimizedCode.add(left + " = " + constants.get(right) + ";  // Optimized by using constant value.");
                } else {
                    String optimizedRight = optimizeExpression(right, constants);
                    if (!optimizedRight.equals(right)) {
                        optimizedCode.add(left + " = " + optimizedRight + ";  // Optimized by simplifying expression.");
                    } else {
                        optimizedCode.add(line);
                    }
                }
                lastValue.put(left, right);

            } else if (line.startsWith("call ")) {
                // Check if the function call is redundant
                if (!calledFunctions.contains(line)) {
                    calledFunctions.add(line);
                    optimizedCode.add(line + "  // Function call added.");
                }
            } else {
                optimizedCode.add(line);
            }
        }

        // Additional optimizations (e.g., removing redundant operations) can be added here
    }

    private boolean isConstantExpression(String expression, Pattern pattern) {
        Matcher matcher = pattern.matcher(expression);
        return matcher.matches();
    }

    private String optimizeExpression(String expression, Map<String, String> constants) {
        // Replace variables with constants where possible
        for (Map.Entry<String, String> entry : constants.entrySet()) {
            expression = expression.replace(entry.getKey(), entry.getValue());
        }

        // Further simplify the expression if possible
        // For example: remove unnecessary parentheses or perform basic arithmetic simplifications
        expression = simplifyArithmetic(expression);

        return expression;
    }

    private String simplifyArithmetic(String expression) {
        // Example simplifications (e.g., "x + 0" -> "x", "x * 1" -> "x")
        expression = expression.replaceAll("\\+\\s*0", "");
        expression = expression.replaceAll("\\*\\s*1", "");
        expression = expression.replaceAll("0\\s*\\+", "");
        expression = expression.replaceAll("1\\s*\\*", "");

        return expression;
    }

    public List<String> getThreeAddressCode() {
        return threeAddressCode;
    }

    public List<String> getOptimizedCode() {
        return optimizedCode;
    }

    public void printCode() {
        System.out.println("Three Address Code with Comments:");
        for (String line : threeAddressCode) {
            System.out.println(line);
        }
        System.out.println("\nOptimized Code with Comments:");
        for (String line : optimizedCode) {
            System.out.println(line);
        }
    }
}
