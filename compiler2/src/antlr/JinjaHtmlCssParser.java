// Generated from E:/S.F.S/compiler002/compiler001/compiler2/src/antlr/JinjaHtmlCssParser.g4 by ANTLR 4.13.2
package antlr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class JinjaHtmlCssParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		DOCTYPE=1, HTML_COMMENT=2, JINJA_COMMENT=3, STYLE_OPEN=4, HTML_TAG_CLOSE_OPEN=5, 
		HTML_TAG_OPEN=6, JINJA_VAR_START=7, JINJA_BLOCK_START=8, HTML_TEXT=9, 
		TAG_SELF_CLOSE=10, TAG_CLOSE=11, TAG_VOID_NAME=12, TAG_IDENTIFIER=13, 
		TAG_EQUAL=14, TAG_STRING=15, TAG_WS=16, STYLE_CLOSE_IN_CSS=17, CSS_COMMENT=18, 
		CSS_LBRACE=19, CSS_RBRACE=20, CSS_LBRACKET=21, CSS_RBRACKET=22, CSS_LPAREN=23, 
		CSS_RPAREN=24, CSS_COLON=25, CSS_DOUBLECOLON=26, CSS_SEMI=27, CSS_COMMA=28, 
		CSS_DOT=29, CSS_EQUAL=30, CSS_UNIT=31, CSS_NUMBER=32, CSS_STRING=33, CSS_IDENTIFIER=34, 
		CSS_WS=35, CSS_OTHER=36, JINJA_VAR_END=37, JINJA_BLOCK_END=38, JINJA_KEYWORD=39, 
		JINJA_IDENTIFIER=40, JINJA_DOT=41, JINJA_PIPE=42, JINJA_COMMA=43, JINJA_LPAREN=44, 
		JINJA_RPAREN=45, JINJA_LBRACKET=46, JINJA_RBRACKET=47, JINJA_OP=48, JINJA_NUMBER=49, 
		JINJA_STRING=50, JINJA_WS=51, JINJA_ANY=52;
	public static final int
		RULE_document = 0, RULE_node = 1, RULE_styleBlock = 2, RULE_cssContent = 3, 
		RULE_cssToken = 4, RULE_element = 5, RULE_htmlElement = 6, RULE_attribute = 7, 
		RULE_attrName = 8, RULE_attributeValue = 9, RULE_jinjaBlock = 10, RULE_jinjaVar = 11, 
		RULE_jinjaContent = 12, RULE_jinjaToken = 13;
	private static String[] makeRuleNames() {
		return new String[] {
			"document", "node", "styleBlock", "cssContent", "cssToken", "element", 
			"htmlElement", "attribute", "attrName", "attributeValue", "jinjaBlock", 
			"jinjaVar", "jinjaContent", "jinjaToken"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, "'<style>'", "'</'", "'<'", "'{{'", "'{%'", null, 
			"'/>'", "'>'", null, null, null, null, null, "'</style>'", null, "'{'", 
			"'}'", null, null, null, null, "':'", "'::'", "';'", null, null, null, 
			null, null, null, null, null, null, "'}}'", "'%}'", null, null, null, 
			"'|'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "DOCTYPE", "HTML_COMMENT", "JINJA_COMMENT", "STYLE_OPEN", "HTML_TAG_CLOSE_OPEN", 
			"HTML_TAG_OPEN", "JINJA_VAR_START", "JINJA_BLOCK_START", "HTML_TEXT", 
			"TAG_SELF_CLOSE", "TAG_CLOSE", "TAG_VOID_NAME", "TAG_IDENTIFIER", "TAG_EQUAL", 
			"TAG_STRING", "TAG_WS", "STYLE_CLOSE_IN_CSS", "CSS_COMMENT", "CSS_LBRACE", 
			"CSS_RBRACE", "CSS_LBRACKET", "CSS_RBRACKET", "CSS_LPAREN", "CSS_RPAREN", 
			"CSS_COLON", "CSS_DOUBLECOLON", "CSS_SEMI", "CSS_COMMA", "CSS_DOT", "CSS_EQUAL", 
			"CSS_UNIT", "CSS_NUMBER", "CSS_STRING", "CSS_IDENTIFIER", "CSS_WS", "CSS_OTHER", 
			"JINJA_VAR_END", "JINJA_BLOCK_END", "JINJA_KEYWORD", "JINJA_IDENTIFIER", 
			"JINJA_DOT", "JINJA_PIPE", "JINJA_COMMA", "JINJA_LPAREN", "JINJA_RPAREN", 
			"JINJA_LBRACKET", "JINJA_RBRACKET", "JINJA_OP", "JINJA_NUMBER", "JINJA_STRING", 
			"JINJA_WS", "JINJA_ANY"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "JinjaHtmlCssParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public JinjaHtmlCssParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DocumentContext extends ParserRuleContext {
		public DocumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_document; }
	 
		public DocumentContext() { }
		public void copyFrom(DocumentContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DocumentNodeContext extends DocumentContext {
		public TerminalNode EOF() { return getToken(JinjaHtmlCssParser.EOF, 0); }
		public TerminalNode DOCTYPE() { return getToken(JinjaHtmlCssParser.DOCTYPE, 0); }
		public List<NodeContext> node() {
			return getRuleContexts(NodeContext.class);
		}
		public NodeContext node(int i) {
			return getRuleContext(NodeContext.class,i);
		}
		public DocumentNodeContext(DocumentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JinjaHtmlCssParserListener ) ((JinjaHtmlCssParserListener)listener).enterDocumentNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JinjaHtmlCssParserListener ) ((JinjaHtmlCssParserListener)listener).exitDocumentNode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JinjaHtmlCssParserVisitor ) return ((JinjaHtmlCssParserVisitor<? extends T>)visitor).visitDocumentNode(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DocumentContext document() throws RecognitionException {
		DocumentContext _localctx = new DocumentContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_document);
		int _la;
		try {
			_localctx = new DocumentNodeContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(29);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DOCTYPE) {
				{
				setState(28);
				match(DOCTYPE);
				}
			}

			setState(34);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 976L) != 0)) {
				{
				{
				setState(31);
				node();
				}
				}
				setState(36);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(37);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NodeContext extends ParserRuleContext {
		public NodeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_node; }
	 
		public NodeContext() { }
		public void copyFrom(NodeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NodeHtmlTextContext extends NodeContext {
		public TerminalNode HTML_TEXT() { return getToken(JinjaHtmlCssParser.HTML_TEXT, 0); }
		public NodeHtmlTextContext(NodeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JinjaHtmlCssParserListener ) ((JinjaHtmlCssParserListener)listener).enterNodeHtmlText(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JinjaHtmlCssParserListener ) ((JinjaHtmlCssParserListener)listener).exitNodeHtmlText(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JinjaHtmlCssParserVisitor ) return ((JinjaHtmlCssParserVisitor<? extends T>)visitor).visitNodeHtmlText(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NodeJinjaVarContext extends NodeContext {
		public JinjaVarContext jinjaVar() {
			return getRuleContext(JinjaVarContext.class,0);
		}
		public NodeJinjaVarContext(NodeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JinjaHtmlCssParserListener ) ((JinjaHtmlCssParserListener)listener).enterNodeJinjaVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JinjaHtmlCssParserListener ) ((JinjaHtmlCssParserListener)listener).exitNodeJinjaVar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JinjaHtmlCssParserVisitor ) return ((JinjaHtmlCssParserVisitor<? extends T>)visitor).visitNodeJinjaVar(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NodeJinjaBlockContext extends NodeContext {
		public JinjaBlockContext jinjaBlock() {
			return getRuleContext(JinjaBlockContext.class,0);
		}
		public NodeJinjaBlockContext(NodeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JinjaHtmlCssParserListener ) ((JinjaHtmlCssParserListener)listener).enterNodeJinjaBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JinjaHtmlCssParserListener ) ((JinjaHtmlCssParserListener)listener).exitNodeJinjaBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JinjaHtmlCssParserVisitor ) return ((JinjaHtmlCssParserVisitor<? extends T>)visitor).visitNodeJinjaBlock(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NodeElementContext extends NodeContext {
		public ElementContext element() {
			return getRuleContext(ElementContext.class,0);
		}
		public NodeElementContext(NodeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JinjaHtmlCssParserListener ) ((JinjaHtmlCssParserListener)listener).enterNodeElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JinjaHtmlCssParserListener ) ((JinjaHtmlCssParserListener)listener).exitNodeElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JinjaHtmlCssParserVisitor ) return ((JinjaHtmlCssParserVisitor<? extends T>)visitor).visitNodeElement(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NodeStyleBlockContext extends NodeContext {
		public StyleBlockContext styleBlock() {
			return getRuleContext(StyleBlockContext.class,0);
		}
		public NodeStyleBlockContext(NodeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JinjaHtmlCssParserListener ) ((JinjaHtmlCssParserListener)listener).enterNodeStyleBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JinjaHtmlCssParserListener ) ((JinjaHtmlCssParserListener)listener).exitNodeStyleBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JinjaHtmlCssParserVisitor ) return ((JinjaHtmlCssParserVisitor<? extends T>)visitor).visitNodeStyleBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NodeContext node() throws RecognitionException {
		NodeContext _localctx = new NodeContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_node);
		try {
			setState(44);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case HTML_TAG_OPEN:
				_localctx = new NodeElementContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(39);
				element();
				}
				break;
			case JINJA_BLOCK_START:
				_localctx = new NodeJinjaBlockContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(40);
				jinjaBlock();
				}
				break;
			case JINJA_VAR_START:
				_localctx = new NodeJinjaVarContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(41);
				jinjaVar();
				}
				break;
			case STYLE_OPEN:
				_localctx = new NodeStyleBlockContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(42);
				styleBlock();
				}
				break;
			case HTML_TEXT:
				_localctx = new NodeHtmlTextContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(43);
				match(HTML_TEXT);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StyleBlockContext extends ParserRuleContext {
		public StyleBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_styleBlock; }
	 
		public StyleBlockContext() { }
		public void copyFrom(StyleBlockContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StyleBlockNodeContext extends StyleBlockContext {
		public TerminalNode STYLE_OPEN() { return getToken(JinjaHtmlCssParser.STYLE_OPEN, 0); }
		public CssContentContext cssContent() {
			return getRuleContext(CssContentContext.class,0);
		}
		public TerminalNode STYLE_CLOSE_IN_CSS() { return getToken(JinjaHtmlCssParser.STYLE_CLOSE_IN_CSS, 0); }
		public StyleBlockNodeContext(StyleBlockContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JinjaHtmlCssParserListener ) ((JinjaHtmlCssParserListener)listener).enterStyleBlockNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JinjaHtmlCssParserListener ) ((JinjaHtmlCssParserListener)listener).exitStyleBlockNode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JinjaHtmlCssParserVisitor ) return ((JinjaHtmlCssParserVisitor<? extends T>)visitor).visitStyleBlockNode(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StyleBlockContext styleBlock() throws RecognitionException {
		StyleBlockContext _localctx = new StyleBlockContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_styleBlock);
		try {
			_localctx = new StyleBlockNodeContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(46);
			match(STYLE_OPEN);
			setState(47);
			cssContent();
			setState(48);
			match(STYLE_CLOSE_IN_CSS);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CssContentContext extends ParserRuleContext {
		public CssContentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cssContent; }
	 
		public CssContentContext() { }
		public void copyFrom(CssContentContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CssContentNodeContext extends CssContentContext {
		public List<CssTokenContext> cssToken() {
			return getRuleContexts(CssTokenContext.class);
		}
		public CssTokenContext cssToken(int i) {
			return getRuleContext(CssTokenContext.class,i);
		}
		public List<JinjaVarContext> jinjaVar() {
			return getRuleContexts(JinjaVarContext.class);
		}
		public JinjaVarContext jinjaVar(int i) {
			return getRuleContext(JinjaVarContext.class,i);
		}
		public List<JinjaBlockContext> jinjaBlock() {
			return getRuleContexts(JinjaBlockContext.class);
		}
		public JinjaBlockContext jinjaBlock(int i) {
			return getRuleContext(JinjaBlockContext.class,i);
		}
		public CssContentNodeContext(CssContentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JinjaHtmlCssParserListener ) ((JinjaHtmlCssParserListener)listener).enterCssContentNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JinjaHtmlCssParserListener ) ((JinjaHtmlCssParserListener)listener).exitCssContentNode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JinjaHtmlCssParserVisitor ) return ((JinjaHtmlCssParserVisitor<? extends T>)visitor).visitCssContentNode(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CssContentContext cssContent() throws RecognitionException {
		CssContentContext _localctx = new CssContentContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_cssContent);
		int _la;
		try {
			_localctx = new CssContentNodeContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 103078691200L) != 0)) {
				{
				setState(53);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case CSS_LBRACE:
				case CSS_RBRACE:
				case CSS_LBRACKET:
				case CSS_RBRACKET:
				case CSS_LPAREN:
				case CSS_RPAREN:
				case CSS_COLON:
				case CSS_DOUBLECOLON:
				case CSS_SEMI:
				case CSS_COMMA:
				case CSS_DOT:
				case CSS_EQUAL:
				case CSS_UNIT:
				case CSS_NUMBER:
				case CSS_STRING:
				case CSS_IDENTIFIER:
				case CSS_OTHER:
					{
					setState(50);
					cssToken();
					}
					break;
				case JINJA_VAR_START:
					{
					setState(51);
					jinjaVar();
					}
					break;
				case JINJA_BLOCK_START:
					{
					setState(52);
					jinjaBlock();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(57);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CssTokenContext extends ParserRuleContext {
		public CssTokenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cssToken; }
	 
		public CssTokenContext() { }
		public void copyFrom(CssTokenContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CssColonContext extends CssTokenContext {
		public TerminalNode CSS_COLON() { return getToken(JinjaHtmlCssParser.CSS_COLON, 0); }
		public CssColonContext(CssTokenContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JinjaHtmlCssParserListener ) ((JinjaHtmlCssParserListener)listener).enterCssColon(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JinjaHtmlCssParserListener ) ((JinjaHtmlCssParserListener)listener).exitCssColon(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JinjaHtmlCssParserVisitor ) return ((JinjaHtmlCssParserVisitor<? extends T>)visitor).visitCssColon(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CssIdentifierContext extends CssTokenContext {
		public TerminalNode CSS_IDENTIFIER() { return getToken(JinjaHtmlCssParser.CSS_IDENTIFIER, 0); }
		public CssIdentifierContext(CssTokenContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JinjaHtmlCssParserListener ) ((JinjaHtmlCssParserListener)listener).enterCssIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JinjaHtmlCssParserListener ) ((JinjaHtmlCssParserListener)listener).exitCssIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JinjaHtmlCssParserVisitor ) return ((JinjaHtmlCssParserVisitor<? extends T>)visitor).visitCssIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CssLParenContext extends CssTokenContext {
		public TerminalNode CSS_LPAREN() { return getToken(JinjaHtmlCssParser.CSS_LPAREN, 0); }
		public CssLParenContext(CssTokenContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JinjaHtmlCssParserListener ) ((JinjaHtmlCssParserListener)listener).enterCssLParen(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JinjaHtmlCssParserListener ) ((JinjaHtmlCssParserListener)listener).exitCssLParen(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JinjaHtmlCssParserVisitor ) return ((JinjaHtmlCssParserVisitor<? extends T>)visitor).visitCssLParen(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CssStringContext extends CssTokenContext {
		public TerminalNode CSS_STRING() { return getToken(JinjaHtmlCssParser.CSS_STRING, 0); }
		public CssStringContext(CssTokenContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JinjaHtmlCssParserListener ) ((JinjaHtmlCssParserListener)listener).enterCssString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JinjaHtmlCssParserListener ) ((JinjaHtmlCssParserListener)listener).exitCssString(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JinjaHtmlCssParserVisitor ) return ((JinjaHtmlCssParserVisitor<? extends T>)visitor).visitCssString(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CssRParenContext extends CssTokenContext {
		public TerminalNode CSS_RPAREN() { return getToken(JinjaHtmlCssParser.CSS_RPAREN, 0); }
		public CssRParenContext(CssTokenContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JinjaHtmlCssParserListener ) ((JinjaHtmlCssParserListener)listener).enterCssRParen(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JinjaHtmlCssParserListener ) ((JinjaHtmlCssParserListener)listener).exitCssRParen(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JinjaHtmlCssParserVisitor ) return ((JinjaHtmlCssParserVisitor<? extends T>)visitor).visitCssRParen(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CssRBraceContext extends CssTokenContext {
		public TerminalNode CSS_RBRACE() { return getToken(JinjaHtmlCssParser.CSS_RBRACE, 0); }
		public CssRBraceContext(CssTokenContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JinjaHtmlCssParserListener ) ((JinjaHtmlCssParserListener)listener).enterCssRBrace(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JinjaHtmlCssParserListener ) ((JinjaHtmlCssParserListener)listener).exitCssRBrace(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JinjaHtmlCssParserVisitor ) return ((JinjaHtmlCssParserVisitor<? extends T>)visitor).visitCssRBrace(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CssOtherContext extends CssTokenContext {
		public TerminalNode CSS_OTHER() { return getToken(JinjaHtmlCssParser.CSS_OTHER, 0); }
		public CssOtherContext(CssTokenContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JinjaHtmlCssParserListener ) ((JinjaHtmlCssParserListener)listener).enterCssOther(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JinjaHtmlCssParserListener ) ((JinjaHtmlCssParserListener)listener).exitCssOther(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JinjaHtmlCssParserVisitor ) return ((JinjaHtmlCssParserVisitor<? extends T>)visitor).visitCssOther(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CssLBracketContext extends CssTokenContext {
		public TerminalNode CSS_LBRACKET() { return getToken(JinjaHtmlCssParser.CSS_LBRACKET, 0); }
		public CssLBracketContext(CssTokenContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JinjaHtmlCssParserListener ) ((JinjaHtmlCssParserListener)listener).enterCssLBracket(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JinjaHtmlCssParserListener ) ((JinjaHtmlCssParserListener)listener).exitCssLBracket(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JinjaHtmlCssParserVisitor ) return ((JinjaHtmlCssParserVisitor<? extends T>)visitor).visitCssLBracket(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CssSemiContext extends CssTokenContext {
		public TerminalNode CSS_SEMI() { return getToken(JinjaHtmlCssParser.CSS_SEMI, 0); }
		public CssSemiContext(CssTokenContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JinjaHtmlCssParserListener ) ((JinjaHtmlCssParserListener)listener).enterCssSemi(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JinjaHtmlCssParserListener ) ((JinjaHtmlCssParserListener)listener).exitCssSemi(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JinjaHtmlCssParserVisitor ) return ((JinjaHtmlCssParserVisitor<? extends T>)visitor).visitCssSemi(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CssEqualContext extends CssTokenContext {
		public TerminalNode CSS_EQUAL() { return getToken(JinjaHtmlCssParser.CSS_EQUAL, 0); }
		public CssEqualContext(CssTokenContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JinjaHtmlCssParserListener ) ((JinjaHtmlCssParserListener)listener).enterCssEqual(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JinjaHtmlCssParserListener ) ((JinjaHtmlCssParserListener)listener).exitCssEqual(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JinjaHtmlCssParserVisitor ) return ((JinjaHtmlCssParserVisitor<? extends T>)visitor).visitCssEqual(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CssLBraceContext extends CssTokenContext {
		public TerminalNode CSS_LBRACE() { return getToken(JinjaHtmlCssParser.CSS_LBRACE, 0); }
		public CssLBraceContext(CssTokenContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JinjaHtmlCssParserListener ) ((JinjaHtmlCssParserListener)listener).enterCssLBrace(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JinjaHtmlCssParserListener ) ((JinjaHtmlCssParserListener)listener).exitCssLBrace(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JinjaHtmlCssParserVisitor ) return ((JinjaHtmlCssParserVisitor<? extends T>)visitor).visitCssLBrace(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CssDoubleColonContext extends CssTokenContext {
		public TerminalNode CSS_DOUBLECOLON() { return getToken(JinjaHtmlCssParser.CSS_DOUBLECOLON, 0); }
		public CssDoubleColonContext(CssTokenContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JinjaHtmlCssParserListener ) ((JinjaHtmlCssParserListener)listener).enterCssDoubleColon(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JinjaHtmlCssParserListener ) ((JinjaHtmlCssParserListener)listener).exitCssDoubleColon(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JinjaHtmlCssParserVisitor ) return ((JinjaHtmlCssParserVisitor<? extends T>)visitor).visitCssDoubleColon(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CssCommaContext extends CssTokenContext {
		public TerminalNode CSS_COMMA() { return getToken(JinjaHtmlCssParser.CSS_COMMA, 0); }
		public CssCommaContext(CssTokenContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JinjaHtmlCssParserListener ) ((JinjaHtmlCssParserListener)listener).enterCssComma(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JinjaHtmlCssParserListener ) ((JinjaHtmlCssParserListener)listener).exitCssComma(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JinjaHtmlCssParserVisitor ) return ((JinjaHtmlCssParserVisitor<? extends T>)visitor).visitCssComma(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CssNumberContext extends CssTokenContext {
		public TerminalNode CSS_NUMBER() { return getToken(JinjaHtmlCssParser.CSS_NUMBER, 0); }
		public CssNumberContext(CssTokenContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JinjaHtmlCssParserListener ) ((JinjaHtmlCssParserListener)listener).enterCssNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JinjaHtmlCssParserListener ) ((JinjaHtmlCssParserListener)listener).exitCssNumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JinjaHtmlCssParserVisitor ) return ((JinjaHtmlCssParserVisitor<? extends T>)visitor).visitCssNumber(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CssDotContext extends CssTokenContext {
		public TerminalNode CSS_DOT() { return getToken(JinjaHtmlCssParser.CSS_DOT, 0); }
		public CssDotContext(CssTokenContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JinjaHtmlCssParserListener ) ((JinjaHtmlCssParserListener)listener).enterCssDot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JinjaHtmlCssParserListener ) ((JinjaHtmlCssParserListener)listener).exitCssDot(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JinjaHtmlCssParserVisitor ) return ((JinjaHtmlCssParserVisitor<? extends T>)visitor).visitCssDot(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CssRBracketContext extends CssTokenContext {
		public TerminalNode CSS_RBRACKET() { return getToken(JinjaHtmlCssParser.CSS_RBRACKET, 0); }
		public CssRBracketContext(CssTokenContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JinjaHtmlCssParserListener ) ((JinjaHtmlCssParserListener)listener).enterCssRBracket(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JinjaHtmlCssParserListener ) ((JinjaHtmlCssParserListener)listener).exitCssRBracket(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JinjaHtmlCssParserVisitor ) return ((JinjaHtmlCssParserVisitor<? extends T>)visitor).visitCssRBracket(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CssUnitContext extends CssTokenContext {
		public TerminalNode CSS_UNIT() { return getToken(JinjaHtmlCssParser.CSS_UNIT, 0); }
		public CssUnitContext(CssTokenContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JinjaHtmlCssParserListener ) ((JinjaHtmlCssParserListener)listener).enterCssUnit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JinjaHtmlCssParserListener ) ((JinjaHtmlCssParserListener)listener).exitCssUnit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JinjaHtmlCssParserVisitor ) return ((JinjaHtmlCssParserVisitor<? extends T>)visitor).visitCssUnit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CssTokenContext cssToken() throws RecognitionException {
		CssTokenContext _localctx = new CssTokenContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_cssToken);
		try {
			setState(75);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CSS_LBRACE:
				_localctx = new CssLBraceContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(58);
				match(CSS_LBRACE);
				}
				break;
			case CSS_RBRACE:
				_localctx = new CssRBraceContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(59);
				match(CSS_RBRACE);
				}
				break;
			case CSS_LBRACKET:
				_localctx = new CssLBracketContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(60);
				match(CSS_LBRACKET);
				}
				break;
			case CSS_RBRACKET:
				_localctx = new CssRBracketContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(61);
				match(CSS_RBRACKET);
				}
				break;
			case CSS_LPAREN:
				_localctx = new CssLParenContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(62);
				match(CSS_LPAREN);
				}
				break;
			case CSS_RPAREN:
				_localctx = new CssRParenContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(63);
				match(CSS_RPAREN);
				}
				break;
			case CSS_COLON:
				_localctx = new CssColonContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(64);
				match(CSS_COLON);
				}
				break;
			case CSS_DOUBLECOLON:
				_localctx = new CssDoubleColonContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(65);
				match(CSS_DOUBLECOLON);
				}
				break;
			case CSS_SEMI:
				_localctx = new CssSemiContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(66);
				match(CSS_SEMI);
				}
				break;
			case CSS_COMMA:
				_localctx = new CssCommaContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(67);
				match(CSS_COMMA);
				}
				break;
			case CSS_DOT:
				_localctx = new CssDotContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(68);
				match(CSS_DOT);
				}
				break;
			case CSS_EQUAL:
				_localctx = new CssEqualContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(69);
				match(CSS_EQUAL);
				}
				break;
			case CSS_UNIT:
				_localctx = new CssUnitContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(70);
				match(CSS_UNIT);
				}
				break;
			case CSS_STRING:
				_localctx = new CssStringContext(_localctx);
				enterOuterAlt(_localctx, 14);
				{
				setState(71);
				match(CSS_STRING);
				}
				break;
			case CSS_IDENTIFIER:
				_localctx = new CssIdentifierContext(_localctx);
				enterOuterAlt(_localctx, 15);
				{
				setState(72);
				match(CSS_IDENTIFIER);
				}
				break;
			case CSS_NUMBER:
				_localctx = new CssNumberContext(_localctx);
				enterOuterAlt(_localctx, 16);
				{
				setState(73);
				match(CSS_NUMBER);
				}
				break;
			case CSS_OTHER:
				_localctx = new CssOtherContext(_localctx);
				enterOuterAlt(_localctx, 17);
				{
				setState(74);
				match(CSS_OTHER);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ElementContext extends ParserRuleContext {
		public ElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_element; }
	 
		public ElementContext() { }
		public void copyFrom(ElementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class HtmlElementNodeContext extends ElementContext {
		public HtmlElementContext htmlElement() {
			return getRuleContext(HtmlElementContext.class,0);
		}
		public HtmlElementNodeContext(ElementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JinjaHtmlCssParserListener ) ((JinjaHtmlCssParserListener)listener).enterHtmlElementNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JinjaHtmlCssParserListener ) ((JinjaHtmlCssParserListener)listener).exitHtmlElementNode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JinjaHtmlCssParserVisitor ) return ((JinjaHtmlCssParserVisitor<? extends T>)visitor).visitHtmlElementNode(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElementContext element() throws RecognitionException {
		ElementContext _localctx = new ElementContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_element);
		try {
			_localctx = new HtmlElementNodeContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			htmlElement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class HtmlElementContext extends ParserRuleContext {
		public HtmlElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_htmlElement; }
	 
		public HtmlElementContext() { }
		public void copyFrom(HtmlElementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VoidSelfClosingElementContext extends HtmlElementContext {
		public TerminalNode HTML_TAG_OPEN() { return getToken(JinjaHtmlCssParser.HTML_TAG_OPEN, 0); }
		public TerminalNode TAG_VOID_NAME() { return getToken(JinjaHtmlCssParser.TAG_VOID_NAME, 0); }
		public TerminalNode TAG_SELF_CLOSE() { return getToken(JinjaHtmlCssParser.TAG_SELF_CLOSE, 0); }
		public List<AttributeContext> attribute() {
			return getRuleContexts(AttributeContext.class);
		}
		public AttributeContext attribute(int i) {
			return getRuleContext(AttributeContext.class,i);
		}
		public VoidSelfClosingElementContext(HtmlElementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JinjaHtmlCssParserListener ) ((JinjaHtmlCssParserListener)listener).enterVoidSelfClosingElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JinjaHtmlCssParserListener ) ((JinjaHtmlCssParserListener)listener).exitVoidSelfClosingElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JinjaHtmlCssParserVisitor ) return ((JinjaHtmlCssParserVisitor<? extends T>)visitor).visitVoidSelfClosingElement(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VoidElementContext extends HtmlElementContext {
		public TerminalNode HTML_TAG_OPEN() { return getToken(JinjaHtmlCssParser.HTML_TAG_OPEN, 0); }
		public TerminalNode TAG_VOID_NAME() { return getToken(JinjaHtmlCssParser.TAG_VOID_NAME, 0); }
		public TerminalNode TAG_CLOSE() { return getToken(JinjaHtmlCssParser.TAG_CLOSE, 0); }
		public List<AttributeContext> attribute() {
			return getRuleContexts(AttributeContext.class);
		}
		public AttributeContext attribute(int i) {
			return getRuleContext(AttributeContext.class,i);
		}
		public VoidElementContext(HtmlElementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JinjaHtmlCssParserListener ) ((JinjaHtmlCssParserListener)listener).enterVoidElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JinjaHtmlCssParserListener ) ((JinjaHtmlCssParserListener)listener).exitVoidElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JinjaHtmlCssParserVisitor ) return ((JinjaHtmlCssParserVisitor<? extends T>)visitor).visitVoidElement(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SelfClosingElementContext extends HtmlElementContext {
		public TerminalNode HTML_TAG_OPEN() { return getToken(JinjaHtmlCssParser.HTML_TAG_OPEN, 0); }
		public TerminalNode TAG_IDENTIFIER() { return getToken(JinjaHtmlCssParser.TAG_IDENTIFIER, 0); }
		public TerminalNode TAG_SELF_CLOSE() { return getToken(JinjaHtmlCssParser.TAG_SELF_CLOSE, 0); }
		public List<AttributeContext> attribute() {
			return getRuleContexts(AttributeContext.class);
		}
		public AttributeContext attribute(int i) {
			return getRuleContext(AttributeContext.class,i);
		}
		public SelfClosingElementContext(HtmlElementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JinjaHtmlCssParserListener ) ((JinjaHtmlCssParserListener)listener).enterSelfClosingElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JinjaHtmlCssParserListener ) ((JinjaHtmlCssParserListener)listener).exitSelfClosingElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JinjaHtmlCssParserVisitor ) return ((JinjaHtmlCssParserVisitor<? extends T>)visitor).visitSelfClosingElement(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NormalElementContext extends HtmlElementContext {
		public Token openTag;
		public Token closeTag;
		public TerminalNode HTML_TAG_OPEN() { return getToken(JinjaHtmlCssParser.HTML_TAG_OPEN, 0); }
		public List<TerminalNode> TAG_CLOSE() { return getTokens(JinjaHtmlCssParser.TAG_CLOSE); }
		public TerminalNode TAG_CLOSE(int i) {
			return getToken(JinjaHtmlCssParser.TAG_CLOSE, i);
		}
		public TerminalNode HTML_TAG_CLOSE_OPEN() { return getToken(JinjaHtmlCssParser.HTML_TAG_CLOSE_OPEN, 0); }
		public List<TerminalNode> TAG_IDENTIFIER() { return getTokens(JinjaHtmlCssParser.TAG_IDENTIFIER); }
		public TerminalNode TAG_IDENTIFIER(int i) {
			return getToken(JinjaHtmlCssParser.TAG_IDENTIFIER, i);
		}
		public List<AttributeContext> attribute() {
			return getRuleContexts(AttributeContext.class);
		}
		public AttributeContext attribute(int i) {
			return getRuleContext(AttributeContext.class,i);
		}
		public List<NodeContext> node() {
			return getRuleContexts(NodeContext.class);
		}
		public NodeContext node(int i) {
			return getRuleContext(NodeContext.class,i);
		}
		public NormalElementContext(HtmlElementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JinjaHtmlCssParserListener ) ((JinjaHtmlCssParserListener)listener).enterNormalElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JinjaHtmlCssParserListener ) ((JinjaHtmlCssParserListener)listener).exitNormalElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JinjaHtmlCssParserVisitor ) return ((JinjaHtmlCssParserVisitor<? extends T>)visitor).visitNormalElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HtmlElementContext htmlElement() throws RecognitionException {
		HtmlElementContext _localctx = new HtmlElementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_htmlElement);
		int _la;
		try {
			setState(124);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				_localctx = new SelfClosingElementContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(79);
				match(HTML_TAG_OPEN);
				setState(80);
				match(TAG_IDENTIFIER);
				setState(84);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==TAG_VOID_NAME || _la==TAG_IDENTIFIER) {
					{
					{
					setState(81);
					attribute();
					}
					}
					setState(86);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(87);
				match(TAG_SELF_CLOSE);
				}
				break;
			case 2:
				_localctx = new VoidSelfClosingElementContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(88);
				match(HTML_TAG_OPEN);
				setState(89);
				match(TAG_VOID_NAME);
				setState(93);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==TAG_VOID_NAME || _la==TAG_IDENTIFIER) {
					{
					{
					setState(90);
					attribute();
					}
					}
					setState(95);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(96);
				match(TAG_SELF_CLOSE);
				}
				break;
			case 3:
				_localctx = new VoidElementContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(97);
				match(HTML_TAG_OPEN);
				setState(98);
				match(TAG_VOID_NAME);
				setState(102);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==TAG_VOID_NAME || _la==TAG_IDENTIFIER) {
					{
					{
					setState(99);
					attribute();
					}
					}
					setState(104);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(105);
				match(TAG_CLOSE);
				}
				break;
			case 4:
				_localctx = new NormalElementContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(106);
				match(HTML_TAG_OPEN);
				setState(107);
				((NormalElementContext)_localctx).openTag = match(TAG_IDENTIFIER);
				setState(111);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==TAG_VOID_NAME || _la==TAG_IDENTIFIER) {
					{
					{
					setState(108);
					attribute();
					}
					}
					setState(113);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(114);
				match(TAG_CLOSE);
				setState(118);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 976L) != 0)) {
					{
					{
					setState(115);
					node();
					}
					}
					setState(120);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(121);
				match(HTML_TAG_CLOSE_OPEN);
				setState(122);
				((NormalElementContext)_localctx).closeTag = match(TAG_IDENTIFIER);
				setState(123);
				match(TAG_CLOSE);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AttributeContext extends ParserRuleContext {
		public AttributeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attribute; }
	 
		public AttributeContext() { }
		public void copyFrom(AttributeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AttributeNodeContext extends AttributeContext {
		public AttrNameContext attrName() {
			return getRuleContext(AttrNameContext.class,0);
		}
		public TerminalNode TAG_EQUAL() { return getToken(JinjaHtmlCssParser.TAG_EQUAL, 0); }
		public List<AttributeValueContext> attributeValue() {
			return getRuleContexts(AttributeValueContext.class);
		}
		public AttributeValueContext attributeValue(int i) {
			return getRuleContext(AttributeValueContext.class,i);
		}
		public AttributeNodeContext(AttributeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JinjaHtmlCssParserListener ) ((JinjaHtmlCssParserListener)listener).enterAttributeNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JinjaHtmlCssParserListener ) ((JinjaHtmlCssParserListener)listener).exitAttributeNode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JinjaHtmlCssParserVisitor ) return ((JinjaHtmlCssParserVisitor<? extends T>)visitor).visitAttributeNode(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttributeContext attribute() throws RecognitionException {
		AttributeContext _localctx = new AttributeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_attribute);
		int _la;
		try {
			int _alt;
			_localctx = new AttributeNodeContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			attrName();
			setState(133);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TAG_EQUAL) {
				{
				setState(127);
				match(TAG_EQUAL);
				setState(129); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(128);
						attributeValue();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(131); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AttrNameContext extends ParserRuleContext {
		public TerminalNode TAG_IDENTIFIER() { return getToken(JinjaHtmlCssParser.TAG_IDENTIFIER, 0); }
		public TerminalNode TAG_VOID_NAME() { return getToken(JinjaHtmlCssParser.TAG_VOID_NAME, 0); }
		public AttrNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attrName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JinjaHtmlCssParserListener ) ((JinjaHtmlCssParserListener)listener).enterAttrName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JinjaHtmlCssParserListener ) ((JinjaHtmlCssParserListener)listener).exitAttrName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JinjaHtmlCssParserVisitor ) return ((JinjaHtmlCssParserVisitor<? extends T>)visitor).visitAttrName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttrNameContext attrName() throws RecognitionException {
		AttrNameContext _localctx = new AttrNameContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_attrName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			_la = _input.LA(1);
			if ( !(_la==TAG_VOID_NAME || _la==TAG_IDENTIFIER) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AttributeValueContext extends ParserRuleContext {
		public AttributeValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributeValue; }
	 
		public AttributeValueContext() { }
		public void copyFrom(AttributeValueContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AttrStringContext extends AttributeValueContext {
		public TerminalNode TAG_STRING() { return getToken(JinjaHtmlCssParser.TAG_STRING, 0); }
		public AttrStringContext(AttributeValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JinjaHtmlCssParserListener ) ((JinjaHtmlCssParserListener)listener).enterAttrString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JinjaHtmlCssParserListener ) ((JinjaHtmlCssParserListener)listener).exitAttrString(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JinjaHtmlCssParserVisitor ) return ((JinjaHtmlCssParserVisitor<? extends T>)visitor).visitAttrString(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AttrVoidNameContext extends AttributeValueContext {
		public TerminalNode TAG_VOID_NAME() { return getToken(JinjaHtmlCssParser.TAG_VOID_NAME, 0); }
		public AttrVoidNameContext(AttributeValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JinjaHtmlCssParserListener ) ((JinjaHtmlCssParserListener)listener).enterAttrVoidName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JinjaHtmlCssParserListener ) ((JinjaHtmlCssParserListener)listener).exitAttrVoidName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JinjaHtmlCssParserVisitor ) return ((JinjaHtmlCssParserVisitor<? extends T>)visitor).visitAttrVoidName(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AttrJinjaVarContext extends AttributeValueContext {
		public JinjaVarContext jinjaVar() {
			return getRuleContext(JinjaVarContext.class,0);
		}
		public AttrJinjaVarContext(AttributeValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JinjaHtmlCssParserListener ) ((JinjaHtmlCssParserListener)listener).enterAttrJinjaVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JinjaHtmlCssParserListener ) ((JinjaHtmlCssParserListener)listener).exitAttrJinjaVar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JinjaHtmlCssParserVisitor ) return ((JinjaHtmlCssParserVisitor<? extends T>)visitor).visitAttrJinjaVar(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AttrIdentifierContext extends AttributeValueContext {
		public TerminalNode TAG_IDENTIFIER() { return getToken(JinjaHtmlCssParser.TAG_IDENTIFIER, 0); }
		public AttrIdentifierContext(AttributeValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JinjaHtmlCssParserListener ) ((JinjaHtmlCssParserListener)listener).enterAttrIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JinjaHtmlCssParserListener ) ((JinjaHtmlCssParserListener)listener).exitAttrIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JinjaHtmlCssParserVisitor ) return ((JinjaHtmlCssParserVisitor<? extends T>)visitor).visitAttrIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AttrJinjaBlockContext extends AttributeValueContext {
		public JinjaBlockContext jinjaBlock() {
			return getRuleContext(JinjaBlockContext.class,0);
		}
		public AttrJinjaBlockContext(AttributeValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JinjaHtmlCssParserListener ) ((JinjaHtmlCssParserListener)listener).enterAttrJinjaBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JinjaHtmlCssParserListener ) ((JinjaHtmlCssParserListener)listener).exitAttrJinjaBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JinjaHtmlCssParserVisitor ) return ((JinjaHtmlCssParserVisitor<? extends T>)visitor).visitAttrJinjaBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttributeValueContext attributeValue() throws RecognitionException {
		AttributeValueContext _localctx = new AttributeValueContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_attributeValue);
		try {
			setState(142);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TAG_STRING:
				_localctx = new AttrStringContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(137);
				match(TAG_STRING);
				}
				break;
			case TAG_IDENTIFIER:
				_localctx = new AttrIdentifierContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(138);
				match(TAG_IDENTIFIER);
				}
				break;
			case TAG_VOID_NAME:
				_localctx = new AttrVoidNameContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(139);
				match(TAG_VOID_NAME);
				}
				break;
			case JINJA_VAR_START:
				_localctx = new AttrJinjaVarContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(140);
				jinjaVar();
				}
				break;
			case JINJA_BLOCK_START:
				_localctx = new AttrJinjaBlockContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(141);
				jinjaBlock();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class JinjaBlockContext extends ParserRuleContext {
		public JinjaBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jinjaBlock; }
	 
		public JinjaBlockContext() { }
		public void copyFrom(JinjaBlockContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class JinjaBlockNodeContext extends JinjaBlockContext {
		public TerminalNode JINJA_BLOCK_START() { return getToken(JinjaHtmlCssParser.JINJA_BLOCK_START, 0); }
		public JinjaContentContext jinjaContent() {
			return getRuleContext(JinjaContentContext.class,0);
		}
		public TerminalNode JINJA_BLOCK_END() { return getToken(JinjaHtmlCssParser.JINJA_BLOCK_END, 0); }
		public JinjaBlockNodeContext(JinjaBlockContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JinjaHtmlCssParserListener ) ((JinjaHtmlCssParserListener)listener).enterJinjaBlockNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JinjaHtmlCssParserListener ) ((JinjaHtmlCssParserListener)listener).exitJinjaBlockNode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JinjaHtmlCssParserVisitor ) return ((JinjaHtmlCssParserVisitor<? extends T>)visitor).visitJinjaBlockNode(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JinjaBlockContext jinjaBlock() throws RecognitionException {
		JinjaBlockContext _localctx = new JinjaBlockContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_jinjaBlock);
		try {
			_localctx = new JinjaBlockNodeContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			match(JINJA_BLOCK_START);
			setState(145);
			jinjaContent();
			setState(146);
			match(JINJA_BLOCK_END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class JinjaVarContext extends ParserRuleContext {
		public JinjaVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jinjaVar; }
	 
		public JinjaVarContext() { }
		public void copyFrom(JinjaVarContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class JinjaVarNodeContext extends JinjaVarContext {
		public TerminalNode JINJA_VAR_START() { return getToken(JinjaHtmlCssParser.JINJA_VAR_START, 0); }
		public JinjaContentContext jinjaContent() {
			return getRuleContext(JinjaContentContext.class,0);
		}
		public TerminalNode JINJA_VAR_END() { return getToken(JinjaHtmlCssParser.JINJA_VAR_END, 0); }
		public JinjaVarNodeContext(JinjaVarContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JinjaHtmlCssParserListener ) ((JinjaHtmlCssParserListener)listener).enterJinjaVarNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JinjaHtmlCssParserListener ) ((JinjaHtmlCssParserListener)listener).exitJinjaVarNode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JinjaHtmlCssParserVisitor ) return ((JinjaHtmlCssParserVisitor<? extends T>)visitor).visitJinjaVarNode(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JinjaVarContext jinjaVar() throws RecognitionException {
		JinjaVarContext _localctx = new JinjaVarContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_jinjaVar);
		try {
			_localctx = new JinjaVarNodeContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(148);
			match(JINJA_VAR_START);
			setState(149);
			jinjaContent();
			setState(150);
			match(JINJA_VAR_END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class JinjaContentContext extends ParserRuleContext {
		public JinjaContentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jinjaContent; }
	 
		public JinjaContentContext() { }
		public void copyFrom(JinjaContentContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class JinjaContentNodeContext extends JinjaContentContext {
		public List<JinjaTokenContext> jinjaToken() {
			return getRuleContexts(JinjaTokenContext.class);
		}
		public JinjaTokenContext jinjaToken(int i) {
			return getRuleContext(JinjaTokenContext.class,i);
		}
		public JinjaContentNodeContext(JinjaContentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JinjaHtmlCssParserListener ) ((JinjaHtmlCssParserListener)listener).enterJinjaContentNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JinjaHtmlCssParserListener ) ((JinjaHtmlCssParserListener)listener).exitJinjaContentNode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JinjaHtmlCssParserVisitor ) return ((JinjaHtmlCssParserVisitor<? extends T>)visitor).visitJinjaContentNode(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JinjaContentContext jinjaContent() throws RecognitionException {
		JinjaContentContext _localctx = new JinjaContentContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_jinjaContent);
		int _la;
		try {
			_localctx = new JinjaContentNodeContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(155);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 6754849685241856L) != 0)) {
				{
				{
				setState(152);
				jinjaToken();
				}
				}
				setState(157);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class JinjaTokenContext extends ParserRuleContext {
		public JinjaTokenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jinjaToken; }
	 
		public JinjaTokenContext() { }
		public void copyFrom(JinjaTokenContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class JinjaRParenContext extends JinjaTokenContext {
		public TerminalNode JINJA_RPAREN() { return getToken(JinjaHtmlCssParser.JINJA_RPAREN, 0); }
		public JinjaRParenContext(JinjaTokenContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JinjaHtmlCssParserListener ) ((JinjaHtmlCssParserListener)listener).enterJinjaRParen(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JinjaHtmlCssParserListener ) ((JinjaHtmlCssParserListener)listener).exitJinjaRParen(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JinjaHtmlCssParserVisitor ) return ((JinjaHtmlCssParserVisitor<? extends T>)visitor).visitJinjaRParen(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class JinjaStringContext extends JinjaTokenContext {
		public TerminalNode JINJA_STRING() { return getToken(JinjaHtmlCssParser.JINJA_STRING, 0); }
		public JinjaStringContext(JinjaTokenContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JinjaHtmlCssParserListener ) ((JinjaHtmlCssParserListener)listener).enterJinjaString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JinjaHtmlCssParserListener ) ((JinjaHtmlCssParserListener)listener).exitJinjaString(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JinjaHtmlCssParserVisitor ) return ((JinjaHtmlCssParserVisitor<? extends T>)visitor).visitJinjaString(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class JinjaCommaContext extends JinjaTokenContext {
		public TerminalNode JINJA_COMMA() { return getToken(JinjaHtmlCssParser.JINJA_COMMA, 0); }
		public JinjaCommaContext(JinjaTokenContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JinjaHtmlCssParserListener ) ((JinjaHtmlCssParserListener)listener).enterJinjaComma(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JinjaHtmlCssParserListener ) ((JinjaHtmlCssParserListener)listener).exitJinjaComma(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JinjaHtmlCssParserVisitor ) return ((JinjaHtmlCssParserVisitor<? extends T>)visitor).visitJinjaComma(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class JinjaLParenContext extends JinjaTokenContext {
		public TerminalNode JINJA_LPAREN() { return getToken(JinjaHtmlCssParser.JINJA_LPAREN, 0); }
		public JinjaLParenContext(JinjaTokenContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JinjaHtmlCssParserListener ) ((JinjaHtmlCssParserListener)listener).enterJinjaLParen(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JinjaHtmlCssParserListener ) ((JinjaHtmlCssParserListener)listener).exitJinjaLParen(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JinjaHtmlCssParserVisitor ) return ((JinjaHtmlCssParserVisitor<? extends T>)visitor).visitJinjaLParen(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class JinjaKeywordContext extends JinjaTokenContext {
		public TerminalNode JINJA_KEYWORD() { return getToken(JinjaHtmlCssParser.JINJA_KEYWORD, 0); }
		public JinjaKeywordContext(JinjaTokenContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JinjaHtmlCssParserListener ) ((JinjaHtmlCssParserListener)listener).enterJinjaKeyword(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JinjaHtmlCssParserListener ) ((JinjaHtmlCssParserListener)listener).exitJinjaKeyword(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JinjaHtmlCssParserVisitor ) return ((JinjaHtmlCssParserVisitor<? extends T>)visitor).visitJinjaKeyword(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class JinjaIdentifierContext extends JinjaTokenContext {
		public TerminalNode JINJA_IDENTIFIER() { return getToken(JinjaHtmlCssParser.JINJA_IDENTIFIER, 0); }
		public JinjaIdentifierContext(JinjaTokenContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JinjaHtmlCssParserListener ) ((JinjaHtmlCssParserListener)listener).enterJinjaIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JinjaHtmlCssParserListener ) ((JinjaHtmlCssParserListener)listener).exitJinjaIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JinjaHtmlCssParserVisitor ) return ((JinjaHtmlCssParserVisitor<? extends T>)visitor).visitJinjaIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class JinjaNumberContext extends JinjaTokenContext {
		public TerminalNode JINJA_NUMBER() { return getToken(JinjaHtmlCssParser.JINJA_NUMBER, 0); }
		public JinjaNumberContext(JinjaTokenContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JinjaHtmlCssParserListener ) ((JinjaHtmlCssParserListener)listener).enterJinjaNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JinjaHtmlCssParserListener ) ((JinjaHtmlCssParserListener)listener).exitJinjaNumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JinjaHtmlCssParserVisitor ) return ((JinjaHtmlCssParserVisitor<? extends T>)visitor).visitJinjaNumber(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class JinjaLBracketContext extends JinjaTokenContext {
		public TerminalNode JINJA_LBRACKET() { return getToken(JinjaHtmlCssParser.JINJA_LBRACKET, 0); }
		public JinjaLBracketContext(JinjaTokenContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JinjaHtmlCssParserListener ) ((JinjaHtmlCssParserListener)listener).enterJinjaLBracket(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JinjaHtmlCssParserListener ) ((JinjaHtmlCssParserListener)listener).exitJinjaLBracket(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JinjaHtmlCssParserVisitor ) return ((JinjaHtmlCssParserVisitor<? extends T>)visitor).visitJinjaLBracket(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class JinjaPipeContext extends JinjaTokenContext {
		public TerminalNode JINJA_PIPE() { return getToken(JinjaHtmlCssParser.JINJA_PIPE, 0); }
		public JinjaPipeContext(JinjaTokenContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JinjaHtmlCssParserListener ) ((JinjaHtmlCssParserListener)listener).enterJinjaPipe(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JinjaHtmlCssParserListener ) ((JinjaHtmlCssParserListener)listener).exitJinjaPipe(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JinjaHtmlCssParserVisitor ) return ((JinjaHtmlCssParserVisitor<? extends T>)visitor).visitJinjaPipe(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class JinjaAnyContext extends JinjaTokenContext {
		public TerminalNode JINJA_ANY() { return getToken(JinjaHtmlCssParser.JINJA_ANY, 0); }
		public JinjaAnyContext(JinjaTokenContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JinjaHtmlCssParserListener ) ((JinjaHtmlCssParserListener)listener).enterJinjaAny(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JinjaHtmlCssParserListener ) ((JinjaHtmlCssParserListener)listener).exitJinjaAny(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JinjaHtmlCssParserVisitor ) return ((JinjaHtmlCssParserVisitor<? extends T>)visitor).visitJinjaAny(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class JinjaDotContext extends JinjaTokenContext {
		public TerminalNode JINJA_DOT() { return getToken(JinjaHtmlCssParser.JINJA_DOT, 0); }
		public JinjaDotContext(JinjaTokenContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JinjaHtmlCssParserListener ) ((JinjaHtmlCssParserListener)listener).enterJinjaDot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JinjaHtmlCssParserListener ) ((JinjaHtmlCssParserListener)listener).exitJinjaDot(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JinjaHtmlCssParserVisitor ) return ((JinjaHtmlCssParserVisitor<? extends T>)visitor).visitJinjaDot(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class JinjaRBracketContext extends JinjaTokenContext {
		public TerminalNode JINJA_RBRACKET() { return getToken(JinjaHtmlCssParser.JINJA_RBRACKET, 0); }
		public JinjaRBracketContext(JinjaTokenContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JinjaHtmlCssParserListener ) ((JinjaHtmlCssParserListener)listener).enterJinjaRBracket(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JinjaHtmlCssParserListener ) ((JinjaHtmlCssParserListener)listener).exitJinjaRBracket(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JinjaHtmlCssParserVisitor ) return ((JinjaHtmlCssParserVisitor<? extends T>)visitor).visitJinjaRBracket(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class JinjaOpContext extends JinjaTokenContext {
		public TerminalNode JINJA_OP() { return getToken(JinjaHtmlCssParser.JINJA_OP, 0); }
		public JinjaOpContext(JinjaTokenContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JinjaHtmlCssParserListener ) ((JinjaHtmlCssParserListener)listener).enterJinjaOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JinjaHtmlCssParserListener ) ((JinjaHtmlCssParserListener)listener).exitJinjaOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JinjaHtmlCssParserVisitor ) return ((JinjaHtmlCssParserVisitor<? extends T>)visitor).visitJinjaOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JinjaTokenContext jinjaToken() throws RecognitionException {
		JinjaTokenContext _localctx = new JinjaTokenContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_jinjaToken);
		try {
			setState(171);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case JINJA_KEYWORD:
				_localctx = new JinjaKeywordContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(158);
				match(JINJA_KEYWORD);
				}
				break;
			case JINJA_IDENTIFIER:
				_localctx = new JinjaIdentifierContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(159);
				match(JINJA_IDENTIFIER);
				}
				break;
			case JINJA_DOT:
				_localctx = new JinjaDotContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(160);
				match(JINJA_DOT);
				}
				break;
			case JINJA_PIPE:
				_localctx = new JinjaPipeContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(161);
				match(JINJA_PIPE);
				}
				break;
			case JINJA_COMMA:
				_localctx = new JinjaCommaContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(162);
				match(JINJA_COMMA);
				}
				break;
			case JINJA_LPAREN:
				_localctx = new JinjaLParenContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(163);
				match(JINJA_LPAREN);
				}
				break;
			case JINJA_RPAREN:
				_localctx = new JinjaRParenContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(164);
				match(JINJA_RPAREN);
				}
				break;
			case JINJA_LBRACKET:
				_localctx = new JinjaLBracketContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(165);
				match(JINJA_LBRACKET);
				}
				break;
			case JINJA_RBRACKET:
				_localctx = new JinjaRBracketContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(166);
				match(JINJA_RBRACKET);
				}
				break;
			case JINJA_OP:
				_localctx = new JinjaOpContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(167);
				match(JINJA_OP);
				}
				break;
			case JINJA_NUMBER:
				_localctx = new JinjaNumberContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(168);
				match(JINJA_NUMBER);
				}
				break;
			case JINJA_STRING:
				_localctx = new JinjaStringContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(169);
				match(JINJA_STRING);
				}
				break;
			case JINJA_ANY:
				_localctx = new JinjaAnyContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(170);
				match(JINJA_ANY);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u00014\u00ae\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0001\u0000\u0003\u0000\u001e\b\u0000\u0001"+
		"\u0000\u0005\u0000!\b\u0000\n\u0000\f\u0000$\t\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003"+
		"\u0001-\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0005\u00036\b\u0003\n\u0003\f\u00039\t"+
		"\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003"+
		"\u0004L\b\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0005\u0006S\b\u0006\n\u0006\f\u0006V\t\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0005\u0006\\\b\u0006\n\u0006\f\u0006_"+
		"\t\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0005\u0006e"+
		"\b\u0006\n\u0006\f\u0006h\t\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0005\u0006n\b\u0006\n\u0006\f\u0006q\t\u0006\u0001\u0006"+
		"\u0001\u0006\u0005\u0006u\b\u0006\n\u0006\f\u0006x\t\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0003\u0006}\b\u0006\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0004\u0007\u0082\b\u0007\u000b\u0007\f\u0007\u0083\u0003"+
		"\u0007\u0086\b\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0003\t\u008f\b\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\f\u0005\f\u009a\b\f\n\f\f\f\u009d"+
		"\t\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0003\r\u00ac\b\r\u0001\r\u0000\u0000"+
		"\u000e\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018"+
		"\u001a\u0000\u0001\u0001\u0000\f\r\u00d3\u0000\u001d\u0001\u0000\u0000"+
		"\u0000\u0002,\u0001\u0000\u0000\u0000\u0004.\u0001\u0000\u0000\u0000\u0006"+
		"7\u0001\u0000\u0000\u0000\bK\u0001\u0000\u0000\u0000\nM\u0001\u0000\u0000"+
		"\u0000\f|\u0001\u0000\u0000\u0000\u000e~\u0001\u0000\u0000\u0000\u0010"+
		"\u0087\u0001\u0000\u0000\u0000\u0012\u008e\u0001\u0000\u0000\u0000\u0014"+
		"\u0090\u0001\u0000\u0000\u0000\u0016\u0094\u0001\u0000\u0000\u0000\u0018"+
		"\u009b\u0001\u0000\u0000\u0000\u001a\u00ab\u0001\u0000\u0000\u0000\u001c"+
		"\u001e\u0005\u0001\u0000\u0000\u001d\u001c\u0001\u0000\u0000\u0000\u001d"+
		"\u001e\u0001\u0000\u0000\u0000\u001e\"\u0001\u0000\u0000\u0000\u001f!"+
		"\u0003\u0002\u0001\u0000 \u001f\u0001\u0000\u0000\u0000!$\u0001\u0000"+
		"\u0000\u0000\" \u0001\u0000\u0000\u0000\"#\u0001\u0000\u0000\u0000#%\u0001"+
		"\u0000\u0000\u0000$\"\u0001\u0000\u0000\u0000%&\u0005\u0000\u0000\u0001"+
		"&\u0001\u0001\u0000\u0000\u0000\'-\u0003\n\u0005\u0000(-\u0003\u0014\n"+
		"\u0000)-\u0003\u0016\u000b\u0000*-\u0003\u0004\u0002\u0000+-\u0005\t\u0000"+
		"\u0000,\'\u0001\u0000\u0000\u0000,(\u0001\u0000\u0000\u0000,)\u0001\u0000"+
		"\u0000\u0000,*\u0001\u0000\u0000\u0000,+\u0001\u0000\u0000\u0000-\u0003"+
		"\u0001\u0000\u0000\u0000./\u0005\u0004\u0000\u0000/0\u0003\u0006\u0003"+
		"\u000001\u0005\u0011\u0000\u00001\u0005\u0001\u0000\u0000\u000026\u0003"+
		"\b\u0004\u000036\u0003\u0016\u000b\u000046\u0003\u0014\n\u000052\u0001"+
		"\u0000\u0000\u000053\u0001\u0000\u0000\u000054\u0001\u0000\u0000\u0000"+
		"69\u0001\u0000\u0000\u000075\u0001\u0000\u0000\u000078\u0001\u0000\u0000"+
		"\u00008\u0007\u0001\u0000\u0000\u000097\u0001\u0000\u0000\u0000:L\u0005"+
		"\u0013\u0000\u0000;L\u0005\u0014\u0000\u0000<L\u0005\u0015\u0000\u0000"+
		"=L\u0005\u0016\u0000\u0000>L\u0005\u0017\u0000\u0000?L\u0005\u0018\u0000"+
		"\u0000@L\u0005\u0019\u0000\u0000AL\u0005\u001a\u0000\u0000BL\u0005\u001b"+
		"\u0000\u0000CL\u0005\u001c\u0000\u0000DL\u0005\u001d\u0000\u0000EL\u0005"+
		"\u001e\u0000\u0000FL\u0005\u001f\u0000\u0000GL\u0005!\u0000\u0000HL\u0005"+
		"\"\u0000\u0000IL\u0005 \u0000\u0000JL\u0005$\u0000\u0000K:\u0001\u0000"+
		"\u0000\u0000K;\u0001\u0000\u0000\u0000K<\u0001\u0000\u0000\u0000K=\u0001"+
		"\u0000\u0000\u0000K>\u0001\u0000\u0000\u0000K?\u0001\u0000\u0000\u0000"+
		"K@\u0001\u0000\u0000\u0000KA\u0001\u0000\u0000\u0000KB\u0001\u0000\u0000"+
		"\u0000KC\u0001\u0000\u0000\u0000KD\u0001\u0000\u0000\u0000KE\u0001\u0000"+
		"\u0000\u0000KF\u0001\u0000\u0000\u0000KG\u0001\u0000\u0000\u0000KH\u0001"+
		"\u0000\u0000\u0000KI\u0001\u0000\u0000\u0000KJ\u0001\u0000\u0000\u0000"+
		"L\t\u0001\u0000\u0000\u0000MN\u0003\f\u0006\u0000N\u000b\u0001\u0000\u0000"+
		"\u0000OP\u0005\u0006\u0000\u0000PT\u0005\r\u0000\u0000QS\u0003\u000e\u0007"+
		"\u0000RQ\u0001\u0000\u0000\u0000SV\u0001\u0000\u0000\u0000TR\u0001\u0000"+
		"\u0000\u0000TU\u0001\u0000\u0000\u0000UW\u0001\u0000\u0000\u0000VT\u0001"+
		"\u0000\u0000\u0000W}\u0005\n\u0000\u0000XY\u0005\u0006\u0000\u0000Y]\u0005"+
		"\f\u0000\u0000Z\\\u0003\u000e\u0007\u0000[Z\u0001\u0000\u0000\u0000\\"+
		"_\u0001\u0000\u0000\u0000][\u0001\u0000\u0000\u0000]^\u0001\u0000\u0000"+
		"\u0000^`\u0001\u0000\u0000\u0000_]\u0001\u0000\u0000\u0000`}\u0005\n\u0000"+
		"\u0000ab\u0005\u0006\u0000\u0000bf\u0005\f\u0000\u0000ce\u0003\u000e\u0007"+
		"\u0000dc\u0001\u0000\u0000\u0000eh\u0001\u0000\u0000\u0000fd\u0001\u0000"+
		"\u0000\u0000fg\u0001\u0000\u0000\u0000gi\u0001\u0000\u0000\u0000hf\u0001"+
		"\u0000\u0000\u0000i}\u0005\u000b\u0000\u0000jk\u0005\u0006\u0000\u0000"+
		"ko\u0005\r\u0000\u0000ln\u0003\u000e\u0007\u0000ml\u0001\u0000\u0000\u0000"+
		"nq\u0001\u0000\u0000\u0000om\u0001\u0000\u0000\u0000op\u0001\u0000\u0000"+
		"\u0000pr\u0001\u0000\u0000\u0000qo\u0001\u0000\u0000\u0000rv\u0005\u000b"+
		"\u0000\u0000su\u0003\u0002\u0001\u0000ts\u0001\u0000\u0000\u0000ux\u0001"+
		"\u0000\u0000\u0000vt\u0001\u0000\u0000\u0000vw\u0001\u0000\u0000\u0000"+
		"wy\u0001\u0000\u0000\u0000xv\u0001\u0000\u0000\u0000yz\u0005\u0005\u0000"+
		"\u0000z{\u0005\r\u0000\u0000{}\u0005\u000b\u0000\u0000|O\u0001\u0000\u0000"+
		"\u0000|X\u0001\u0000\u0000\u0000|a\u0001\u0000\u0000\u0000|j\u0001\u0000"+
		"\u0000\u0000}\r\u0001\u0000\u0000\u0000~\u0085\u0003\u0010\b\u0000\u007f"+
		"\u0081\u0005\u000e\u0000\u0000\u0080\u0082\u0003\u0012\t\u0000\u0081\u0080"+
		"\u0001\u0000\u0000\u0000\u0082\u0083\u0001\u0000\u0000\u0000\u0083\u0081"+
		"\u0001\u0000\u0000\u0000\u0083\u0084\u0001\u0000\u0000\u0000\u0084\u0086"+
		"\u0001\u0000\u0000\u0000\u0085\u007f\u0001\u0000\u0000\u0000\u0085\u0086"+
		"\u0001\u0000\u0000\u0000\u0086\u000f\u0001\u0000\u0000\u0000\u0087\u0088"+
		"\u0007\u0000\u0000\u0000\u0088\u0011\u0001\u0000\u0000\u0000\u0089\u008f"+
		"\u0005\u000f\u0000\u0000\u008a\u008f\u0005\r\u0000\u0000\u008b\u008f\u0005"+
		"\f\u0000\u0000\u008c\u008f\u0003\u0016\u000b\u0000\u008d\u008f\u0003\u0014"+
		"\n\u0000\u008e\u0089\u0001\u0000\u0000\u0000\u008e\u008a\u0001\u0000\u0000"+
		"\u0000\u008e\u008b\u0001\u0000\u0000\u0000\u008e\u008c\u0001\u0000\u0000"+
		"\u0000\u008e\u008d\u0001\u0000\u0000\u0000\u008f\u0013\u0001\u0000\u0000"+
		"\u0000\u0090\u0091\u0005\b\u0000\u0000\u0091\u0092\u0003\u0018\f\u0000"+
		"\u0092\u0093\u0005&\u0000\u0000\u0093\u0015\u0001\u0000\u0000\u0000\u0094"+
		"\u0095\u0005\u0007\u0000\u0000\u0095\u0096\u0003\u0018\f\u0000\u0096\u0097"+
		"\u0005%\u0000\u0000\u0097\u0017\u0001\u0000\u0000\u0000\u0098\u009a\u0003"+
		"\u001a\r\u0000\u0099\u0098\u0001\u0000\u0000\u0000\u009a\u009d\u0001\u0000"+
		"\u0000\u0000\u009b\u0099\u0001\u0000\u0000\u0000\u009b\u009c\u0001\u0000"+
		"\u0000\u0000\u009c\u0019\u0001\u0000\u0000\u0000\u009d\u009b\u0001\u0000"+
		"\u0000\u0000\u009e\u00ac\u0005\'\u0000\u0000\u009f\u00ac\u0005(\u0000"+
		"\u0000\u00a0\u00ac\u0005)\u0000\u0000\u00a1\u00ac\u0005*\u0000\u0000\u00a2"+
		"\u00ac\u0005+\u0000\u0000\u00a3\u00ac\u0005,\u0000\u0000\u00a4\u00ac\u0005"+
		"-\u0000\u0000\u00a5\u00ac\u0005.\u0000\u0000\u00a6\u00ac\u0005/\u0000"+
		"\u0000\u00a7\u00ac\u00050\u0000\u0000\u00a8\u00ac\u00051\u0000\u0000\u00a9"+
		"\u00ac\u00052\u0000\u0000\u00aa\u00ac\u00054\u0000\u0000\u00ab\u009e\u0001"+
		"\u0000\u0000\u0000\u00ab\u009f\u0001\u0000\u0000\u0000\u00ab\u00a0\u0001"+
		"\u0000\u0000\u0000\u00ab\u00a1\u0001\u0000\u0000\u0000\u00ab\u00a2\u0001"+
		"\u0000\u0000\u0000\u00ab\u00a3\u0001\u0000\u0000\u0000\u00ab\u00a4\u0001"+
		"\u0000\u0000\u0000\u00ab\u00a5\u0001\u0000\u0000\u0000\u00ab\u00a6\u0001"+
		"\u0000\u0000\u0000\u00ab\u00a7\u0001\u0000\u0000\u0000\u00ab\u00a8\u0001"+
		"\u0000\u0000\u0000\u00ab\u00a9\u0001\u0000\u0000\u0000\u00ab\u00aa\u0001"+
		"\u0000\u0000\u0000\u00ac\u001b\u0001\u0000\u0000\u0000\u0011\u001d\","+
		"57KT]fov|\u0083\u0085\u008e\u009b\u00ab";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}