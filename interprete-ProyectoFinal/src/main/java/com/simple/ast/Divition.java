package com.simple.ast;

import java.util.Map;

public class Divition implements ASTNode {
    private ASTNode operand1;
    private ASTNode operand2;

    public Divition(ASTNode operand1, ASTNode operand2) {
        super();
        this.operand1 = operand1;
        this.operand2 = operand2;
    }

    @Override
    public Object execute(Map<String, Object> symbolTable) {
        Object value1 = operand1.execute(symbolTable);
        Object value2 = operand2.execute(symbolTable);
        if (value1 instanceof Integer && value2 instanceof Integer) {
            if ((int) value2 == 0) {
                throw new RuntimeException("División por cero.");
            }
            return (int) value1 / (int) value2;
        } else {
            throw new RuntimeException("Operación de división solo soporta enteros.");
        }
    }
}
