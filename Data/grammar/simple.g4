grammar simple;

@header {
package com.simple.compiler;
}

program : 'declare' declaration_list 'begin' statement_list 'end' ';';

statement_list : statement statement_list
| statement;

statement : assignment_statement ';'
      | print_statement ';'
      | if_statement
      | while_statement
      | for_statement
      | function_statement
      | function_call_statement ';';


declaration_list : declaration ';' declaration_list
	  | declaration ';';
	  
declaration : int_declaration
      | bool_declaration
      | var_declaration;
      
      
var_declaration : 'variable' IDENTIFIER ';' ;
      
int_declaration : 'int' IDENTIFIER;

bool_declaration : 'bool' IDENTIFIER;


assignment_statement : IDENTIFIER '=' expression
					| IDENTIFIER '=' bool_expression;


if_statement : 'if' '(' bool_expression ')' ':' statement_list 'endif' else_statement?;

else_statement : 'else' ':' statement_list 'endelse';

while_statement : 'while' '(' bool_expression ')' ':' statement_list 'endwhile';

for_statement : 'for' '(' bool_expression ')' ':' statement_list 'endfor';

print_statement : 'print' expression;

function_statement : 'def' IDENTIFIER '('(IDENTIFIER | (IDENTIFIER (',' IDENTIFIER)*))?')' ':' declaration_list? statement_list (return_statement)? 'endfunc';

return_statement :'return' expression ';';

function_call_statement : IDENTIFIER '('(expression | expression (',' expression)*)?')' ;


conditional_expression : expression '==' expression
        | expression '!=' expression
        | expression '<' expression
        | expression '<=' expression
        | expression '>' expression
        | expression '>=' expression
        | expression '==' BOOLEAN
        | expression '!=' BOOLEAN
        | '?' bool_factor;
        


bool_expression : conditional_expression
        | bool_factor ;


expression : term '+' expression
      | term '-' expression
      | term;
	  

term :  factor '*' term
      | factor '/' term
      | factor '%' term
      | factor;


factor : '(' expression ')'
    | IDENTIFIER
    | function_call_statement
    | NUMBER;
    

bool_factor : IDENTIFIER | BOOLEAN;

IDENTIFIER : [a-zA-Z][a-zA-Z0-9]*  ;

BOOLEAN : 'true' | 'false' ;

NUMBER :[0-9]+;

WHITE_SPACE : [ \t\r\n]+ -> skip ;

COMMENT : '#' ~[\r\n]* -> skip;