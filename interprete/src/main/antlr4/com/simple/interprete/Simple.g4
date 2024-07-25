grammar Simple;

@parser::header{
	import java.util.Map;
	import java.util.HashMap;
}

@parser::members{
	Map<String, Object> symbolTable = new HashMap<String, Object>();
}

// la gramática libre de contexto
program: PROGRAM ID BRA_OPEN sentence* BRA_CLOSE;

// lo que puede ser una sentencia
sentence: var_decl | var_assign | println | conditional;

var_decl: VAR ID SEMICOLON
	{symbolTable.put($ID.text,0);};  // guardo en la tabla de simbolos una entrada indexada por el nombre de la variable, y asociada al valor cero (ya que es una variable inicial)

var_assign: ID ASSIGN expression SEMICOLON   // Le asigno el nuevo valor a la variable
	{symbolTable.put($ID.text, $expression.value);};

println: PRINTLN expression SEMICOLON
	{System.out.println($expression.value);};
	
conditional: IF PAR_OPEN expression PAR_CLOSE
			BRA_OPEN sentence* BRA_CLOSE
			ELSE
			BRA_OPEN sentence* BRA_CLOSE;

expression returns [Object value]: 
	t1=factor {$value = $t1.value;} 
	(PLUS t2=factor {$value = (int)$value + (int)$t2.value;} 
	| MINUS t2=factor {$value = (int)$value - (int)$t2.value;}
	)*;   // le pongo paréntesis -> se llama clausura a la izquierda ya que una expresión puede ser 2+3 [term PLUS term] o 2+3+4+18 [term (PLUS term)*]
	      // luego gracias a ANTLR puedo diferenciar los términos poniéndole un nombre cualquiera como t1 y t2
	      // luego traspaso el valor al nodo superior que será $value

factor returns [Object value]: 
	t1=term {$value = $t1.value;} 
	(MULT t2=term {$value = (int)$value * (int)$t2.value;} 
	| DIV t2=term {$value = (int)$value / (int)$t2.value;}
	)*;

term returns [Object value]: 
	t1=base {$value = $t1.value;} 
	(EXP t2=base {$value = Math.pow((int)$value, (int)$t2.value);})*;

base returns [Object value]:
	NUMBER {$value = Integer.parseInt($NUMBER.text);}
	| 
	ID {$value = symbolTable.get($ID.text) != null ? symbolTable.get($ID.text) : 0;}
	|
	PAR_OPEN expression PAR_CLOSE {$value = $expression.value;};

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
