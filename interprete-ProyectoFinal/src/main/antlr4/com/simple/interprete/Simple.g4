grammar Simple;

@parser::header{
    import java.util.Map;
    import java.util.HashMap;
    import java.util.List;
    import java.util.ArrayList;
    import com.simple.ast.*;
}

@parser::members{
    Map<String, Object> symbolTable = new HashMap<String, Object>();
}

// la gramática libre de contexto
program returns [List<ASTNode> body]: 
    PROGRAM ID BRA_OPEN 
    {
        $body = new ArrayList<ASTNode>();
    }
    (sentence {$body.add($sentence.node);})* 
    BRA_CLOSE
    {
        Map<String, Object> symbolTable = new HashMap<>();
        for(ASTNode n : $body){
            n.execute(symbolTable);
        }
    }
    ;

// lo que puede ser una sentencia
sentence returns [ASTNode node]: 
    println {$node = $println.node;} 
    | conditional {$node = $conditional.node;}
    ;

println returns [ASTNode node]: 
    PRINTLN expression SEMICOLON 
    {
        $node = new Println($expression.node);
    }
    ;

conditional returns [ASTNode node]: 
    IF PAR_OPEN expression PAR_CLOSE 
    {
        List<ASTNode> body = new ArrayList<ASTNode>();
    } 
    BRA_OPEN (s1=sentence {body.add($s1.node);})* BRA_CLOSE 
    ELSE 
    {
        List<ASTNode> elseBody = new ArrayList<ASTNode>();
    } 
    BRA_OPEN (s2=sentence {elseBody.add($s2.node);})* BRA_CLOSE 
    {
        $node = new If($expression.node, body, elseBody);
    }
    ;

expression returns [ASTNode node]: 
    t1=factor {$node = $t1.node;} 
    (PLUS t2=factor {$node = new Addition($node, $t2.node);} 
    | MINUS t2=factor {$node = new Minus($node, $t2.node);}
    )*
    ;

factor returns [ASTNode node]: 
    t1=term {$node = $t1.node;} 
    (MULT t2=term {$node = new Multiplication($node, $t2.node);} 
    | DIV t2=term {$node = new Divition($node, $t2.node);}
    )*
    ;

term returns [ASTNode node]: 
    NUMBER {$node = new Constant(Integer.parseInt($NUMBER.text));} 
    | ID {$node = new Variable($ID.text);} 
    | BOOLEAN {$node = new Constant(Boolean.parseBoolean($BOOLEAN.text));}
    | PAR_OPEN expression PAR_CLOSE {$node = $expression.node;}
    ;

// saltar esto
WS: [ \t\r\n]+ -> skip;

// palabras clave
PROGRAM: 'program';
VAR: 'var';
PRINTLN: 'println';
IF: 'if';
ELSE: 'else';

// operadores aritméticos
PLUS: '+';
MINUS: '-';
MULT: '*';
DIV: '/';
EXP: '^';

// operadores lógicos
AND: '&&';
OR: '||';
NOT: '!';

NEQ: '!=';
EQ: '==';
GEQ: '>=';
LEQ: '<=';
GT: '>';
LT: '<';

// asignación
ASSIGN: '=';

// brackets
BRA_OPEN: '{';
BRA_CLOSE: '}';

// Paréntesis
PAR_OPEN: '(';
PAR_CLOSE: ')';

// punto y coma
SEMICOLON: ';';

BOOLEAN: 'true' | 'false';

// Identificadores
ID: [a-zA-Z_][a-zA-Z0-9_]*;

NUMBER: [0-9]+;
