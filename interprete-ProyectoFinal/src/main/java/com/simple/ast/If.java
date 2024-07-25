package com.simple.ast;

import java.util.List;
import java.util.Map;

public class If implements ASTNode {
    private ASTNode condition;
    private List<ASTNode> body;
    private List<ASTNode> elseBody;

    public If(ASTNode condition, List<ASTNode> body, List<ASTNode> elseBody) {
        this.condition = condition;
        this.body = body;
        this.elseBody = elseBody;
    }

    @Override
    public Object execute(Map<String, Object> symbolTable) {
        Object conditionResult = condition.execute(symbolTable);
        if (conditionResult instanceof Boolean && (Boolean) conditionResult) {
            for (ASTNode node : body) {
                node.execute(symbolTable);
            }
        } else {
            for (ASTNode node : elseBody) {
                node.execute(symbolTable);
            }
        }
        return null;
    }
}
