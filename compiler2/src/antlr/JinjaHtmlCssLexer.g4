lexer grammar JinjaHtmlCssLexer;

// ================= DEFAULT MODE =================

DOCTYPE
    : '<!' 'DOCTYPE' [ \t\r\n]+ [a-zA-Z0-9]+ '>'
    ;

HTML_COMMENT
    : '<!--' .*? '-->' -> skip
    ;

JINJA_COMMENT
    : '{#' .*? '#}' -> skip
    ;

STYLE_OPEN
    : '<style>' -> pushMode(CSS_MODE)
    ;

HTML_TAG_CLOSE_OPEN
    : '</' -> pushMode(TAG_MODE)
    ;

HTML_TAG_OPEN
    : '<' -> pushMode(TAG_MODE)
    ;

JINJA_VAR_START
    : '{{' -> pushMode(JINJA_MODE)
    ;

JINJA_BLOCK_START
    : '{%' -> pushMode(JINJA_MODE)
    ;

HTML_TEXT
    : ~[<{]+
    ;

// ================= TAG MODE =================
mode TAG_MODE;

TAG_SELF_CLOSE
    : '/>' -> popMode
    ;

TAG_CLOSE
    : '>' -> popMode
    ;

TAG_VOID_NAME
    : 'meta' | 'link' | 'input' | 'br' | 'hr'
    | 'img' | 'area' | 'base' | 'col' | 'embed'
    | 'param' | 'source' | 'track' | 'wbr'
    ;

TAG_IDENTIFIER
    : [a-zA-Z][a-zA-Z0-9-]*
    ;

TAG_EQUAL
    : '='
    ;

TAG_STRING
    : '"' (~["])* '"'
    | '\'' (~['])* '\''
    ;

TAG_WS
    : [ \t\r\n]+ -> skip
    ;

TAG_JINJA_VAR_START
    : '{{' -> type(JINJA_VAR_START), pushMode(JINJA_MODE)
    ;

TAG_JINJA_BLOCK_START
    : '{%' -> type(JINJA_BLOCK_START), pushMode(JINJA_MODE)
    ;

// ================= CSS MODE =================
// ================= CSS MODE =================
mode CSS_MODE;

STYLE_CLOSE_IN_CSS
    : '</style>' -> popMode
    ;

CSS_COMMENT
    : '/*' .*? '*/' -> skip
    ;

CSS_LBRACE      : '{' ;
CSS_RBRACE      : '}' ;
CSS_LBRACKET    : '[' ;
CSS_RBRACKET    : ']' ;
CSS_LPAREN      : '(' ;
CSS_RPAREN      : ')' ;

CSS_COLON       : ':' ;
CSS_DOUBLECOLON : '::' ;
CSS_SEMI        : ';' ;
CSS_COMMA       : ',' ;
CSS_DOT         : '.' ;
CSS_EQUAL       : '=' ;

CSS_UNIT
    : [0-9]+ ('.' [0-9]+)?
      ('px'|'em'|'rem'|'vh'|'vw'|'pt'|'%')
    ;

CSS_NUMBER
    : [0-9]+ ('.' [0-9]+)?
    ;

CSS_STRING
    : '"' (~["\r\n])* '"'
    | '\'' (~['\r\n])* '\''
    ;

CSS_IDENTIFIER
    : '-'? [a-zA-Z_][a-zA-Z0-9_-]*
    | '#' [a-zA-Z0-9_-]+
    | '.' [a-zA-Z0-9_-]+
    | '@' [a-zA-Z-]+
    ;

CSS_JINJA_VAR_START
    : '{{' -> type(JINJA_VAR_START), pushMode(JINJA_MODE)
    ;

CSS_JINJA_BLOCK_START
    : '{%' -> type(JINJA_BLOCK_START), pushMode(JINJA_MODE)
    ;

CSS_WS
    : [ \t\r\n]+ -> skip
    ;

CSS_OTHER
    : [+\-*/~^$!&|]
    ;
// ================= JINJA MODE =================
mode JINJA_MODE;

JINJA_VAR_END
    : '}}' -> popMode
    ;

JINJA_BLOCK_END
    : '%}' -> popMode
    ;

JINJA_KEYWORD
    : 'for' | 'in' | 'if' | 'else' | 'elif'
    | 'endif' | 'endfor' | 'not' | 'and' | 'or'
    | 'true' | 'false' | 'none' | 'loop'
    ;

JINJA_IDENTIFIER
    : [a-zA-Z_][a-zA-Z0-9_]*
    ;

JINJA_DOT       : '.' ;
JINJA_PIPE      : '|' ;
JINJA_COMMA     : ',' ;
JINJA_LPAREN    : '(' ;
JINJA_RPAREN    : ')' ;
JINJA_LBRACKET  : '[' ;
JINJA_RBRACKET  : ']' ;

JINJA_OP
    : '==' | '!=' | '>=' | '<='
    | '>' | '<' | '+' | '-'
    | '*' | '/' | '//' | '%'
    | '**' | '~'
    ;

JINJA_NUMBER
    : [0-9]+ ('.' [0-9]+)?
    ;

JINJA_STRING
    : '"' (~["])* '"'
    | '\'' (~['])* '\''
    ;

JINJA_WS
    : [ \t\r\n]+ -> skip
    ;

JINJA_ANY
    : .
    ;