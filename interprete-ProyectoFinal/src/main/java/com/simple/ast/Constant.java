package com.simple.ast;

import java.util.Map;

public class Constant implements ASTNode {
    private Object value;

    public Constant(int value) {
        this.value = value;
    }

    public Constant(boolean value) {
        this.value = value;
    }

    @Override
    public Object execute(Map<String, Object> symbolTable) {
        return value;
    }

    public Object getValue() {
        return value;
    }
}
