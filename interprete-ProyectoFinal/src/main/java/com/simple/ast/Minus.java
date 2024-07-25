package com.simple.ast;

import java.util.Map;

public class Minus implements ASTNode {
    private ASTNode operand1;
    private ASTNode operand2;

    public Minus(ASTNode operand1, ASTNode operand2) {
        super();
        this.operand1 = operand1;
        this.operand2 = operand2;
    }

    @Override
    public Object execute(Map<String, Object> symbolTable) {
        Object value1 = operand1.execute(symbolTable);
        Object value2 = operand2.execute(symbolTable);
        if (value1 instanceof Integer && value2 instanceof Integer) {
            return (int) value1 + (int) value2;
        } else {
            throw new RuntimeException("Operación de resta solo soporta enteros.");
        }
    }
}
