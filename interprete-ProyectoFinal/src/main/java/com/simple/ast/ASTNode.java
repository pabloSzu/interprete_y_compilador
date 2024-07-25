package com.simple.ast;

import java.util.Map;

public interface ASTNode {
    Object execute(Map<String, Object> symbolTable);
}