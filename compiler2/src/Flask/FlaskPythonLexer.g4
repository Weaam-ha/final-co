lexer grammar FlaskPythonLexer;

tokens { INDENT, DEDENT }

FROM: 'from';
IMPORT: 'import';
DEF: 'def';
RETURN: 'return';
PASS: 'pass';
IF: 'if';
ELSE: 'else';
FOR: 'for';
WHILE: 'while';
IN: 'in';
IS: 'is';
NOT: 'not';
NONE: 'None';
TRUE: 'True';
FALSE: 'False';
GLOBAL: 'global';
DOT: '.';

APP_ROUTE: '@app.route';

STRING
    : '"' (~["\\\r\n] | '\\' .)* '"'
    | '\'' (~['\\\r\n] | '\\' .)* '\''
    ;

NUMBER: [0-9]+ ('.' [0-9]+)?;


ID: [a-zA-Z_][a-zA-Z0-9_]*;

LTEQ: '<=';
GTEQ: '>=';
MINUS: '-';
STAR: '*';
MOD: '%';
EQEQ: '==';
NEQ: '!=';
EQ: '=';
PLUS: '+';
COMMA: ',';
COLON: ':';
LPAREN: '(';
RPAREN: ')';
LBRACKET: '[';
RBRACKET: ']';
LBRACE: '{';
RBRACE: '}';
ARROW: '->';
LT: '<';
GT: '>';
SLASH: '/';

// Augmented Assignment
PLUSEQ: '+=';
MINUSEQ: '-=';
STAREQ: '*=';
SLASHEQ: '/=';
MODEQ: '%=';
DOUBLESLASHEQ: '//=';
DOUBLESTAREQ: '**=';

// Set Operations
PIPE: '|';
AMP: '&';
CARET: '^';
TILDE: '~';


// Boolean Operations
AND: 'and';
OR: 'or';

// Additional
DOUBLESTAR: '**';
DOUBLESLASH: '//';

NEWLINE: ('\r'? '\n' [ \t]*)+;
WS: [ \t]+ -> skip;