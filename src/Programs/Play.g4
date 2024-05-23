grammar Play;

parse
 : block EOF
 ;

block
 : stat*
 ;

stat
 : assignment
 | if_stat
 | while_stat
 | display
 | function_def
 | function_call
 | return_stat
 | input 
 | OTHER {System.err.println("unknown char: " + $OTHER.text);}
 ;

assignment
 : 'setv' ID '->' expr
 | 'setv' ID '->' input  
 ;

if_stat
 : IF condition_block (OTHERWISE IF condition_block)* (OTHERWISE stat_block)?
 ;

condition_block
 : expr stat_block
 ;

stat_block
 : OBRACE block CBRACE
 | stat
 ;

while_stat
 : WHILE expr stat_block
 ;

display
 : DISPLAY expr
 ;

input
 : 'input' '(' STRING? ')'  
 ;

function_def
 : 'function' ID OPAR params? CPAR OBRACE block CBRACE
 ;

params
 : ID (',' ID)*
 ;

function_call
 : ID OPAR args? CPAR
 ;

args
 : expr (',' expr)*
 ;
 

return_stat
 : 'return' expr
 ;

expr
 : MINUS expr                           #unaryMinusExpr
 | NOT expr                             #notExpr
 | expr op=(MULT | DIV | MOD) expr      #multiplicationExpr
 | expr op=(PLUS | MINUS) expr          #additiveExpr
 | expr op=(LTEQ | GTEQ | LT | GT) expr #relationalExpr
 | expr op=(EQ | NEQ) expr              #equalityExpr
 | expr AND expr                        #andExpr
 | expr OR expr                         #orExpr
 | atom                                 #atomExpr
 | function_call                        #functionCallExpr
 ;

atom
 : OPAR expr CPAR #parExpr
 | (INT | FLOAT)  #numberAtom
 | (TRUE | FALSE) #booleanAtom
 | ID             #idAtom
 | STRING         #stringAtom
 | NULL           #nullAtom
 ;

OR : '||';
AND : '&&';
EQ : '==';
NEQ : '!=';
GT : '>';
LT : '<';
GTEQ : '>=';
LTEQ : '<=';
PLUS : '+';
MINUS : '-';
MULT : '*';
DIV : '/';
MOD : '%';
NOT : '!';
ASSIGN : '->';
OPAR : '(';
CPAR : ')';
OBRACE : '{';
CBRACE : '}';
TRUE : 'true';
FALSE : 'false';
NULL : 'null';
IF : 'if';
OTHERWISE : 'otherwise';
WHILE : 'while';
DISPLAY : 'display';
FUNCTION : 'function';
RETURN : 'return';
INPUT : 'input';
ID : [a-zA-Z_] [a-zA-Z_0-9]*;
INT : [0-9]+;
FLOAT : [0-9]+ '.' [0-9]* | '.' [0-9]+;
STRING : '"' (~["\r\n] | '""')* '"';
COMMENT : '#' ~[\r\n]* -> skip;
SPACE : [ \t\r\n] -> skip;
OTHER : . ;
