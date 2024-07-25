package com.simple.ast;

import java.util.Map;

public class Variable implements ASTNode {
    private String name;

    public Variable(String name) {
        this.name = name;
    }

    @Override
    public Object execute(Map<String, Object> symbolTable) {
        if (symbolTable.containsKey(name)) {
            return symbolTable.get(name);
        } else {
            throw new RuntimeException("Variable no definida: " + name);
        }
    }

    public String getName() {
        return name;
    }
}
