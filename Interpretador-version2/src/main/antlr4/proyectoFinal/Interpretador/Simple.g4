grammar Simple;

@parser::header {
    import proyectoFinal.Interpretador.TablaSimbolos.Symbol;
    import proyectoFinal.Interpretador.TablaSimbolos.SymbolTable;
    import java.util.Map;
    import java.util.HashMap;
    import java.util.List;
    import java.util.ArrayList;
}

@parser::members {
    private Map<String, Symbol> symbolTable = new HashMap<>();
    private List<String> errors = new ArrayList<>();

    public Map<String, Symbol> getSymbolTable() {
        return symbolTable;
    }

    public List<String> getErrors() {
        return errors;
    }
}

// Tokens
PA       : '(' ;
PC       : ')' ;
CA       : '[' ;
CC       : ']' ;
LA       : '{' ;
LC       : '}' ;

PYC      : ';' ;
COMA     : ',' ;

IGUAL    : '=' ;

MAYOR    : '>' ;
MAYOR_IGUAL : '>=' ;
MENOR    : '<' ;
MENOR_IGUAL : '<=' ;
EQL      : '==' ;
DISTINTO : '!=' ;

SUM      : '+' ;
RES      : '-' ;
MUL      : '*' ;
DIV      : '/' ;
MOD      : '%' ;

OR       : '||' ;
AND      : '&&' ;
NOT      : '!' ;

WHILE    : 'while' ;
IF       : 'if' ;
ELSE     : 'else' ;

INT      : 'int' ;
CHAR     : 'char' ;
DOUBLE   : 'double' ;
VOID     : 'void' ;

RETURN   : 'return';

ID       : [a-zA-Z_][a-zA-Z_0-9]* ;

INTEGER  : [0-9]+ ; 
DECIMAL  : INTEGER '.' INTEGER ;
CHARACTER: '\'' [a-zA-Z0-9] '\'' ;

WS       : [ \r\n\t]+ -> skip ;
OTRO     : . ;

// Reglas gramaticales
prog: instrucciones EOF ; 

instrucciones 
    : instruccion+ 
    ;

instruccion 
    : declaracion PYC
    | asignacion PYC
    | bucleWhile
    | condif
    | declaracionFuncion
    | definicionFuncion
    | llamadaFuncion PYC
    | retorno PYC
    | bloque
    ;

retorno : RETURN operacion ;

declaracion : tipoDato ID (IGUAL operacion)? ;

asignacion : ID IGUAL operacion ;

tipoDato 
    : INT
    | CHAR
    | DOUBLE
    | VOID
    ;

// Instrucciones de control
condif
    : IF PA operacion PC bloque (ELSE bloque)?
    ;

bucleWhile
    : WHILE PA operacion PC bloque
    ;

declaracionFuncion : tipoDato ID PA parametros PC ;

definicionFuncion : tipoDato ID PA parametros PC bloque ;

parametros : (tipoDato ID (COMA tipoDato ID)*)? ;

llamadaFuncion : ID PA argumentos PC ;

argumentos : (operacion (COMA operacion)*)? ;

// Expresiones aritméticas y relacionales
operacion
    : expresion
    | llamadaFuncion
    ;

expresion
    : operacionComparacion
    ;

operacionComparacion
    : operacionLogica
    | operacionLogica (EQL | DISTINTO | MAYOR_IGUAL | MENOR_IGUAL | MAYOR | MENOR) operacionLogica
    ;

operacionLogica
    : operacionAritmetica
    | operacionAritmetica (OR | AND) operacionAritmetica
    ;

operacionAritmetica
    : term ((SUM | RES) term)*
    ;

term
    : factor ((MUL | DIV | MOD) factor)*
    ;

factor
    : PA operacion PC
    | llamadaFuncion
    | INTEGER
    | DECIMAL
    | CHARACTER
    | ID
    ;

bloque
    : LA instrucciones LC
    ;
