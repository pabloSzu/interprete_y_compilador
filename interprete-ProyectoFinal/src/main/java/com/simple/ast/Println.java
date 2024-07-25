package com.simple.ast;

import java.util.Map;

public class Println implements ASTNode {
    private ASTNode expression;

    public Println(ASTNode expression) {
        this.expression = expression;
    }

    @Override
    public Object execute(Map<String, Object> symbolTable) {
        Object result = expression.execute(symbolTable);
        System.out.println(result);
        return null;
    }
}
