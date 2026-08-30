parser grammar FlaskPythonParser;

options { tokenVocab=FlaskPythonLexer; }

program: NEWLINE? stmt* EOF ;

stmt
    : importStmt NEWLINE?
    | varAssign NEWLINE?
    | augAssign NEWLINE?
    | decoratorFunc
    | globalStmt NEWLINE?
    | exprStmt NEWLINE?
    | ifStmt
    | forStmt
    | whileStmt
    | RETURN returnValues? NEWLINE?
    | PASS NEWLINE?
    | NEWLINE
    ;

globalStmt: GLOBAL ID (COMMA ID)* ;

augAssign: ID augOp expr ;
augOp: PLUSEQ | MINUSEQ | STAREQ | SLASHEQ | MODEQ | DOUBLESLASHEQ | DOUBLESTAREQ ;

importStmt: FROM ID IMPORT importList ;
importList: ID (COMMA ID)* ;

varAssign: ID EQ expr ;

decoratorFunc: APP_ROUTE LPAREN argList RPAREN NEWLINE? funcDef ;
funcDef: DEF ID LPAREN paramList? RPAREN COLON block ;
paramList: ID (COMMA ID)* ;

// A block always starts right after a header line's NEWLINE, is marked by
// a synthetic INDENT from IndentAwareTokenSource, contains one or more
// statements (each responsible for consuming its own trailing NEWLINE),
// and ends with the matching synthetic DEDENT.
block: NEWLINE INDENT stmt+ DEDENT ;

ifStmt: IF expr COLON block (ELSE COLON block)? ;

forStmt: FOR ID IN expr COLON block ;

whileStmt: WHILE expr COLON block ;

returnValues: expr (COMMA expr)* ;

expr
    : NOT expr                        # notExpr
    | expr OR expr                    # orExpr
    | expr AND expr                   # andExpr
    | dottedID LPAREN expr FOR ID IN expr (IF expr)? RPAREN  # funcCallGenerator
    | dottedID LPAREN argList? RPAREN # funcCall
    | expr LBRACKET sliceOrIndex RBRACKET  # indexOrSliceExpr
    | expr EQEQ expr                  # eqExpr
    | expr NEQ expr                   # neqExpr
    | expr IS expr                    # isExpr
    | expr IS NOT expr                # isNotExpr
    | expr IN expr                    # inExpr
    | expr NOT IN expr                # notInExpr
    | expr PLUS expr                  # plusExpr
    | expr MINUS expr                 # minusExpr
    | expr STAR expr                  # starExpr
    | expr SLASH expr                 # slashExpr
    | expr DOUBLESLASH expr           # doubleSlashExpr
    | expr MOD expr                   # modExpr
    | expr DOUBLESTAR expr            # doubleStarExpr
    | expr LT expr                    # ltExpr
    | expr GT expr                    # gtExpr
    | expr LTEQ expr                  # lteqExpr
    | expr GTEQ expr                  # gteqExpr
    | expr PIPE expr                  # pipeExpr
    | expr AMP expr                   # ampExpr
    | expr CARET expr                 # caretExpr
    | generatorExpr                   # generatorExprAlt
    | tupleLiteral                    # tupleExpr
    | listLiteral                     # listExpr
    | dictLiteral                     # dictExpr
    | STRING                          # stringExpr
    | NUMBER                          # numberExpr
    | TRUE                            # trueExpr
    | FALSE                           # falseExpr
    | NONE                            # noneExpr
    | dottedID                        # idExpr
    ;

sliceOrIndex
    : expr                                    # indexOnly
    | expr? COLON expr?                       # sliceOnly
    | expr? COLON expr? COLON expr?           # sliceWithStep
    ;

dottedID: ID (DOT ID)* ;

argList: argument (COMMA NEWLINE? argument)* ;
argument: expr | ID EQ expr ;

tupleLiteral
    : LPAREN (NEWLINE? expr (COMMA NEWLINE? expr)* COMMA? NEWLINE?)? RPAREN
    ;

generatorExpr
    : LPAREN expr FOR ID IN expr (IF expr)? RPAREN
    ;

listLiteral
    : LBRACKET (NEWLINE? expr (COMMA NEWLINE? expr)* COMMA? NEWLINE?)? RBRACKET ;

dictLiteral
    : LBRACE (NEWLINE? dictItem (COMMA NEWLINE? dictItem)* COMMA? NEWLINE?)? RBRACE ;

dictItem: STRING COLON expr | ID COLON expr ;

exprStmt: expr ;