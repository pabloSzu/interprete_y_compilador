grammar Simple;

// Importaciones y miembros del parser
@parser::header{
    import java.util.Map;
    import java.util.HashMap;
    import java.util.List;
    import java.util.ArrayList;
}

@parser::members{
    Map<String, String> symbolTable = new HashMap<>();
    List<String> errors = new ArrayList<>();
}

// Reglas
program returns [boolean isValid]: 
    (statement)* EOF 
    {
        if (errors.isEmpty()) {
            $isValid = true;
        } else {
            $isValid = false;
        }
    }
    ;
    

statement: 
    declaration 
    | assignment 
    | ifStatement 
    | whileStatement 
    | functionCall 
    | functionDeclaration 
    ;

declaration: 
    ('int' | 'boolean') ID ';' 
    {
        String varName = $ID.text;
        if (symbolTable.containsKey(varName)) {
            errors.add("Variable already declared: " + varName);
        } else {
            symbolTable.put(varName, $ctx.getText());
        }
    }
    ;

assignment: 
    ID '=' expression ';' 
    {
        String varName = $ID.text;
        if (!symbolTable.containsKey(varName)) {
            errors.add("Variable not declared: " + varName);
        }
    }
    ;
    
ifStatement: 
    'if' '(' expression ')' block ('else' block)? 
    ;

whileStatement: 
    'while' '(' expression ')' block 
    ;

functionCall: 
    ID '(' (expression (',' expression)*)? ')' ';' 
    ;

functionDeclaration: 
    ('void' | 'int' | 'boolean') ID '(' (ID (',' ID)*)? ')' block 
    ;

block: 
    '{' (statement)* '}' 
    ;

expression: 
    expression ('+' | '-' | '*' | '/' | '&&' | '||' | '==' | '!=' | '<' | '>' | '<=' | '>=') expression 
    | '(' expression ')' 
    | ID 
    | NUMBER 
    | BOOLEAN 
    ;

// Tokens
ID: [a-zA-Z_][a-zA-Z_0-9]*;
NUMBER: [0-9]+;
BOOLEAN: 'true' | 'false';

WS: [ \t\r\n]+ -> skip;

// Operadores
PLUS: '+';
MINUS: '-';
MULT: '*';
DIV: '/';
AND: '&&';
OR: '||';
EQ: '==';
NEQ: '!=';
LT: '<';
GT: '>';
LEQ: '<=';
GEQ: '>=';

// Paréntesis y corchetes
PAR_OPEN: '(';
PAR_CLOSE: ')';
BRA_OPEN: '{';
BRA_CLOSE: '}';
SEMICOLON: ';';
