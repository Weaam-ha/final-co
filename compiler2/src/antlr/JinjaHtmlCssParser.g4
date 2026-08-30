parser grammar JinjaHtmlCssParser;

options { tokenVocab = JinjaHtmlCssLexer; }

document
    : DOCTYPE? node* EOF                              # DocumentNode
    ;

node
    : element                                         # NodeElement
    | jinjaBlock                                      # NodeJinjaBlock
    | jinjaVar                                        # NodeJinjaVar
    | styleBlock                                      # NodeStyleBlock
    | HTML_TEXT                                       # NodeHtmlText
    ;

styleBlock
    : STYLE_OPEN cssContent STYLE_CLOSE_IN_CSS        # StyleBlockNode
    ;

cssContent
    : (cssToken | jinjaVar | jinjaBlock)*             # CssContentNode
    ;

cssToken
    : CSS_LBRACE          # CssLBrace
    | CSS_RBRACE          # CssRBrace
    | CSS_LBRACKET        # CssLBracket
    | CSS_RBRACKET        # CssRBracket
    | CSS_LPAREN          # CssLParen
    | CSS_RPAREN          # CssRParen
    | CSS_COLON           # CssColon
    | CSS_DOUBLECOLON     # CssDoubleColon
    | CSS_SEMI            # CssSemi
    | CSS_COMMA           # CssComma
    | CSS_DOT             # CssDot
    | CSS_EQUAL           # CssEqual
    | CSS_UNIT            # CssUnit
    | CSS_STRING          # CssString
    | CSS_IDENTIFIER      # CssIdentifier
    | CSS_NUMBER          # CssNumber
    | CSS_OTHER           # CssOther
    ;
element
    : htmlElement                                     # HtmlElementNode
    ;

htmlElement
    : HTML_TAG_OPEN TAG_IDENTIFIER attribute* TAG_SELF_CLOSE
      # SelfClosingElement

    | HTML_TAG_OPEN TAG_VOID_NAME attribute* TAG_SELF_CLOSE
      # VoidSelfClosingElement

    | HTML_TAG_OPEN TAG_VOID_NAME attribute* TAG_CLOSE
      # VoidElement

    | HTML_TAG_OPEN openTag=TAG_IDENTIFIER attribute* TAG_CLOSE
      node*
      HTML_TAG_CLOSE_OPEN closeTag=TAG_IDENTIFIER TAG_CLOSE
      # NormalElement
    ;

attribute
    : attrName (TAG_EQUAL attributeValue+)?           # AttributeNode
    ;

attrName
    : TAG_IDENTIFIER
    | TAG_VOID_NAME
    ;

attributeValue
    : TAG_STRING                                      # AttrString
    | TAG_IDENTIFIER                                  # AttrIdentifier
    | TAG_VOID_NAME                                   # AttrVoidName
    | jinjaVar                                        # AttrJinjaVar
    | jinjaBlock                                      # AttrJinjaBlock
    ;

jinjaBlock
    : JINJA_BLOCK_START jinjaContent JINJA_BLOCK_END  # JinjaBlockNode
    ;

jinjaVar
    : JINJA_VAR_START jinjaContent JINJA_VAR_END      # JinjaVarNode
    ;

jinjaContent
    : jinjaToken*                                     # JinjaContentNode
    ;

jinjaToken
    : JINJA_KEYWORD                                   # JinjaKeyword
    | JINJA_IDENTIFIER                                # JinjaIdentifier
    | JINJA_DOT                                       # JinjaDot
    | JINJA_PIPE                                      # JinjaPipe
    | JINJA_COMMA                                     # JinjaComma
    | JINJA_LPAREN                                    # JinjaLParen
    | JINJA_RPAREN                                    # JinjaRParen
    | JINJA_LBRACKET                                  # JinjaLBracket
    | JINJA_RBRACKET                                  # JinjaRBracket
    | JINJA_OP                                        # JinjaOp
    | JINJA_NUMBER                                    # JinjaNumber
    | JINJA_STRING                                    # JinjaString
    | JINJA_ANY                                       # JinjaAny
    ;