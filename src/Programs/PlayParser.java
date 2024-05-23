// Generated from Play.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class PlayParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, OR=3, AND=4, EQ=5, NEQ=6, GT=7, LT=8, GTEQ=9, LTEQ=10, 
		PLUS=11, MINUS=12, MULT=13, DIV=14, MOD=15, NOT=16, ASSIGN=17, OPAR=18, 
		CPAR=19, OBRACE=20, CBRACE=21, TRUE=22, FALSE=23, NULL=24, IF=25, OTHERWISE=26, 
		WHILE=27, DISPLAY=28, FUNCTION=29, RETURN=30, INPUT=31, ID=32, INT=33, 
		FLOAT=34, STRING=35, COMMENT=36, SPACE=37, OTHER=38;
	public static final int
		RULE_parse = 0, RULE_block = 1, RULE_stat = 2, RULE_assignment = 3, RULE_if_stat = 4, 
		RULE_condition_block = 5, RULE_stat_block = 6, RULE_while_stat = 7, RULE_display = 8, 
		RULE_input = 9, RULE_function_def = 10, RULE_params = 11, RULE_function_call = 12, 
		RULE_args = 13, RULE_return_stat = 14, RULE_expr = 15, RULE_atom = 16;
	private static String[] makeRuleNames() {
		return new String[] {
			"parse", "block", "stat", "assignment", "if_stat", "condition_block", 
			"stat_block", "while_stat", "display", "input", "function_def", "params", 
			"function_call", "args", "return_stat", "expr", "atom"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'setv'", "','", "'||'", "'&&'", "'=='", "'!='", "'>'", "'<'", 
			"'>='", "'<='", "'+'", "'-'", "'*'", "'/'", "'%'", "'!'", "'->'", "'('", 
			"')'", "'{'", "'}'", "'true'", "'false'", "'null'", "'if'", "'otherwise'", 
			"'while'", "'display'", "'function'", "'return'", "'input'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, "OR", "AND", "EQ", "NEQ", "GT", "LT", "GTEQ", "LTEQ", 
			"PLUS", "MINUS", "MULT", "DIV", "MOD", "NOT", "ASSIGN", "OPAR", "CPAR", 
			"OBRACE", "CBRACE", "TRUE", "FALSE", "NULL", "IF", "OTHERWISE", "WHILE", 
			"DISPLAY", "FUNCTION", "RETURN", "INPUT", "ID", "INT", "FLOAT", "STRING", 
			"COMMENT", "SPACE", "OTHER"
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
	public String getGrammarFileName() { return "Play.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public PlayParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParseContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode EOF() { return getToken(PlayParser.EOF, 0); }
		public ParseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parse; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlayListener ) ((PlayListener)listener).enterParse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlayListener ) ((PlayListener)listener).exitParse(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlayVisitor ) return ((PlayVisitor<? extends T>)visitor).visitParse(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParseContext parse() throws RecognitionException {
		ParseContext _localctx = new ParseContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_parse);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34);
			block();
			setState(35);
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
	public static class BlockContext extends ParserRuleContext {
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlayListener ) ((PlayListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlayListener ) ((PlayListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlayVisitor ) return ((PlayVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(40);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 283367178242L) != 0)) {
				{
				{
				setState(37);
				stat();
				}
				}
				setState(42);
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
	public static class StatContext extends ParserRuleContext {
		public Token OTHER;
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public If_statContext if_stat() {
			return getRuleContext(If_statContext.class,0);
		}
		public While_statContext while_stat() {
			return getRuleContext(While_statContext.class,0);
		}
		public DisplayContext display() {
			return getRuleContext(DisplayContext.class,0);
		}
		public Function_defContext function_def() {
			return getRuleContext(Function_defContext.class,0);
		}
		public Function_callContext function_call() {
			return getRuleContext(Function_callContext.class,0);
		}
		public Return_statContext return_stat() {
			return getRuleContext(Return_statContext.class,0);
		}
		public InputContext input() {
			return getRuleContext(InputContext.class,0);
		}
		public TerminalNode OTHER() { return getToken(PlayParser.OTHER, 0); }
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlayListener ) ((PlayListener)listener).enterStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlayListener ) ((PlayListener)listener).exitStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlayVisitor ) return ((PlayVisitor<? extends T>)visitor).visitStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_stat);
		try {
			setState(53);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(43);
				assignment();
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 2);
				{
				setState(44);
				if_stat();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 3);
				{
				setState(45);
				while_stat();
				}
				break;
			case DISPLAY:
				enterOuterAlt(_localctx, 4);
				{
				setState(46);
				display();
				}
				break;
			case FUNCTION:
				enterOuterAlt(_localctx, 5);
				{
				setState(47);
				function_def();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 6);
				{
				setState(48);
				function_call();
				}
				break;
			case RETURN:
				enterOuterAlt(_localctx, 7);
				{
				setState(49);
				return_stat();
				}
				break;
			case INPUT:
				enterOuterAlt(_localctx, 8);
				{
				setState(50);
				input();
				}
				break;
			case OTHER:
				enterOuterAlt(_localctx, 9);
				{
				setState(51);
				((StatContext)_localctx).OTHER = match(OTHER);
				System.err.println("unknown char: " + (((StatContext)_localctx).OTHER!=null?((StatContext)_localctx).OTHER.getText():null));
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
	public static class AssignmentContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(PlayParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(PlayParser.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public InputContext input() {
			return getRuleContext(InputContext.class,0);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlayListener ) ((PlayListener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlayListener ) ((PlayListener)listener).exitAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlayVisitor ) return ((PlayVisitor<? extends T>)visitor).visitAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_assignment);
		try {
			setState(63);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(55);
				match(T__0);
				setState(56);
				match(ID);
				setState(57);
				match(ASSIGN);
				setState(58);
				expr(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(59);
				match(T__0);
				setState(60);
				match(ID);
				setState(61);
				match(ASSIGN);
				setState(62);
				input();
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
	public static class If_statContext extends ParserRuleContext {
		public List<TerminalNode> IF() { return getTokens(PlayParser.IF); }
		public TerminalNode IF(int i) {
			return getToken(PlayParser.IF, i);
		}
		public List<Condition_blockContext> condition_block() {
			return getRuleContexts(Condition_blockContext.class);
		}
		public Condition_blockContext condition_block(int i) {
			return getRuleContext(Condition_blockContext.class,i);
		}
		public List<TerminalNode> OTHERWISE() { return getTokens(PlayParser.OTHERWISE); }
		public TerminalNode OTHERWISE(int i) {
			return getToken(PlayParser.OTHERWISE, i);
		}
		public Stat_blockContext stat_block() {
			return getRuleContext(Stat_blockContext.class,0);
		}
		public If_statContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_stat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlayListener ) ((PlayListener)listener).enterIf_stat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlayListener ) ((PlayListener)listener).exitIf_stat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlayVisitor ) return ((PlayVisitor<? extends T>)visitor).visitIf_stat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final If_statContext if_stat() throws RecognitionException {
		If_statContext _localctx = new If_statContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_if_stat);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(65);
			match(IF);
			setState(66);
			condition_block();
			setState(72);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(67);
					match(OTHERWISE);
					setState(68);
					match(IF);
					setState(69);
					condition_block();
					}
					} 
				}
				setState(74);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			setState(77);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(75);
				match(OTHERWISE);
				setState(76);
				stat_block();
				}
				break;
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
	public static class Condition_blockContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Stat_blockContext stat_block() {
			return getRuleContext(Stat_blockContext.class,0);
		}
		public Condition_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlayListener ) ((PlayListener)listener).enterCondition_block(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlayListener ) ((PlayListener)listener).exitCondition_block(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlayVisitor ) return ((PlayVisitor<? extends T>)visitor).visitCondition_block(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Condition_blockContext condition_block() throws RecognitionException {
		Condition_blockContext _localctx = new Condition_blockContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_condition_block);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(79);
			expr(0);
			setState(80);
			stat_block();
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
	public static class Stat_blockContext extends ParserRuleContext {
		public TerminalNode OBRACE() { return getToken(PlayParser.OBRACE, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode CBRACE() { return getToken(PlayParser.CBRACE, 0); }
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public Stat_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlayListener ) ((PlayListener)listener).enterStat_block(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlayListener ) ((PlayListener)listener).exitStat_block(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlayVisitor ) return ((PlayVisitor<? extends T>)visitor).visitStat_block(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Stat_blockContext stat_block() throws RecognitionException {
		Stat_blockContext _localctx = new Stat_blockContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_stat_block);
		try {
			setState(87);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OBRACE:
				enterOuterAlt(_localctx, 1);
				{
				setState(82);
				match(OBRACE);
				setState(83);
				block();
				setState(84);
				match(CBRACE);
				}
				break;
			case T__0:
			case IF:
			case WHILE:
			case DISPLAY:
			case FUNCTION:
			case RETURN:
			case INPUT:
			case ID:
			case OTHER:
				enterOuterAlt(_localctx, 2);
				{
				setState(86);
				stat();
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
	public static class While_statContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(PlayParser.WHILE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Stat_blockContext stat_block() {
			return getRuleContext(Stat_blockContext.class,0);
		}
		public While_statContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_while_stat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlayListener ) ((PlayListener)listener).enterWhile_stat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlayListener ) ((PlayListener)listener).exitWhile_stat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlayVisitor ) return ((PlayVisitor<? extends T>)visitor).visitWhile_stat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final While_statContext while_stat() throws RecognitionException {
		While_statContext _localctx = new While_statContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_while_stat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
			match(WHILE);
			setState(90);
			expr(0);
			setState(91);
			stat_block();
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
	public static class DisplayContext extends ParserRuleContext {
		public TerminalNode DISPLAY() { return getToken(PlayParser.DISPLAY, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public DisplayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_display; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlayListener ) ((PlayListener)listener).enterDisplay(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlayListener ) ((PlayListener)listener).exitDisplay(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlayVisitor ) return ((PlayVisitor<? extends T>)visitor).visitDisplay(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DisplayContext display() throws RecognitionException {
		DisplayContext _localctx = new DisplayContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_display);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			match(DISPLAY);
			setState(94);
			expr(0);
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
	public static class InputContext extends ParserRuleContext {
		public TerminalNode INPUT() { return getToken(PlayParser.INPUT, 0); }
		public TerminalNode OPAR() { return getToken(PlayParser.OPAR, 0); }
		public TerminalNode CPAR() { return getToken(PlayParser.CPAR, 0); }
		public TerminalNode STRING() { return getToken(PlayParser.STRING, 0); }
		public InputContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_input; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlayListener ) ((PlayListener)listener).enterInput(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlayListener ) ((PlayListener)listener).exitInput(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlayVisitor ) return ((PlayVisitor<? extends T>)visitor).visitInput(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InputContext input() throws RecognitionException {
		InputContext _localctx = new InputContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_input);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			match(INPUT);
			setState(97);
			match(OPAR);
			setState(99);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STRING) {
				{
				setState(98);
				match(STRING);
				}
			}

			setState(101);
			match(CPAR);
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
	public static class Function_defContext extends ParserRuleContext {
		public TerminalNode FUNCTION() { return getToken(PlayParser.FUNCTION, 0); }
		public TerminalNode ID() { return getToken(PlayParser.ID, 0); }
		public TerminalNode OPAR() { return getToken(PlayParser.OPAR, 0); }
		public TerminalNode CPAR() { return getToken(PlayParser.CPAR, 0); }
		public TerminalNode OBRACE() { return getToken(PlayParser.OBRACE, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode CBRACE() { return getToken(PlayParser.CBRACE, 0); }
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public Function_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_def; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlayListener ) ((PlayListener)listener).enterFunction_def(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlayListener ) ((PlayListener)listener).exitFunction_def(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlayVisitor ) return ((PlayVisitor<? extends T>)visitor).visitFunction_def(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_defContext function_def() throws RecognitionException {
		Function_defContext _localctx = new Function_defContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_function_def);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			match(FUNCTION);
			setState(104);
			match(ID);
			setState(105);
			match(OPAR);
			setState(107);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(106);
				params();
				}
			}

			setState(109);
			match(CPAR);
			setState(110);
			match(OBRACE);
			setState(111);
			block();
			setState(112);
			match(CBRACE);
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
	public static class ParamsContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(PlayParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(PlayParser.ID, i);
		}
		public ParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_params; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlayListener ) ((PlayListener)listener).enterParams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlayListener ) ((PlayListener)listener).exitParams(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlayVisitor ) return ((PlayVisitor<? extends T>)visitor).visitParams(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamsContext params() throws RecognitionException {
		ParamsContext _localctx = new ParamsContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_params);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(114);
			match(ID);
			setState(119);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(115);
				match(T__1);
				setState(116);
				match(ID);
				}
				}
				setState(121);
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
	public static class Function_callContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(PlayParser.ID, 0); }
		public TerminalNode OPAR() { return getToken(PlayParser.OPAR, 0); }
		public TerminalNode CPAR() { return getToken(PlayParser.CPAR, 0); }
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public Function_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_call; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlayListener ) ((PlayListener)listener).enterFunction_call(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlayListener ) ((PlayListener)listener).exitFunction_call(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlayVisitor ) return ((PlayVisitor<? extends T>)visitor).visitFunction_call(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_callContext function_call() throws RecognitionException {
		Function_callContext _localctx = new Function_callContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_function_call);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
			match(ID);
			setState(123);
			match(OPAR);
			setState(125);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 64454201344L) != 0)) {
				{
				setState(124);
				args();
				}
			}

			setState(127);
			match(CPAR);
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
	public static class ArgsContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_args; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlayListener ) ((PlayListener)listener).enterArgs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlayListener ) ((PlayListener)listener).exitArgs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlayVisitor ) return ((PlayVisitor<? extends T>)visitor).visitArgs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgsContext args() throws RecognitionException {
		ArgsContext _localctx = new ArgsContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_args);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129);
			expr(0);
			setState(134);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(130);
				match(T__1);
				setState(131);
				expr(0);
				}
				}
				setState(136);
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
	public static class Return_statContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(PlayParser.RETURN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Return_statContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_return_stat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlayListener ) ((PlayListener)listener).enterReturn_stat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlayListener ) ((PlayListener)listener).exitReturn_stat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlayVisitor ) return ((PlayVisitor<? extends T>)visitor).visitReturn_stat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Return_statContext return_stat() throws RecognitionException {
		Return_statContext _localctx = new Return_statContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_return_stat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			match(RETURN);
			setState(138);
			expr(0);
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
	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NotExprContext extends ExprContext {
		public TerminalNode NOT() { return getToken(PlayParser.NOT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public NotExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlayListener ) ((PlayListener)listener).enterNotExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlayListener ) ((PlayListener)listener).exitNotExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlayVisitor ) return ((PlayVisitor<? extends T>)visitor).visitNotExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class UnaryMinusExprContext extends ExprContext {
		public TerminalNode MINUS() { return getToken(PlayParser.MINUS, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public UnaryMinusExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlayListener ) ((PlayListener)listener).enterUnaryMinusExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlayListener ) ((PlayListener)listener).exitUnaryMinusExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlayVisitor ) return ((PlayVisitor<? extends T>)visitor).visitUnaryMinusExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FunctionCallExprContext extends ExprContext {
		public Function_callContext function_call() {
			return getRuleContext(Function_callContext.class,0);
		}
		public FunctionCallExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlayListener ) ((PlayListener)listener).enterFunctionCallExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlayListener ) ((PlayListener)listener).exitFunctionCallExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlayVisitor ) return ((PlayVisitor<? extends T>)visitor).visitFunctionCallExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MultiplicationExprContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode MULT() { return getToken(PlayParser.MULT, 0); }
		public TerminalNode DIV() { return getToken(PlayParser.DIV, 0); }
		public TerminalNode MOD() { return getToken(PlayParser.MOD, 0); }
		public MultiplicationExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlayListener ) ((PlayListener)listener).enterMultiplicationExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlayListener ) ((PlayListener)listener).exitMultiplicationExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlayVisitor ) return ((PlayVisitor<? extends T>)visitor).visitMultiplicationExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AtomExprContext extends ExprContext {
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public AtomExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlayListener ) ((PlayListener)listener).enterAtomExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlayListener ) ((PlayListener)listener).exitAtomExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlayVisitor ) return ((PlayVisitor<? extends T>)visitor).visitAtomExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class OrExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode OR() { return getToken(PlayParser.OR, 0); }
		public OrExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlayListener ) ((PlayListener)listener).enterOrExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlayListener ) ((PlayListener)listener).exitOrExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlayVisitor ) return ((PlayVisitor<? extends T>)visitor).visitOrExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AdditiveExprContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode PLUS() { return getToken(PlayParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(PlayParser.MINUS, 0); }
		public AdditiveExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlayListener ) ((PlayListener)listener).enterAdditiveExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlayListener ) ((PlayListener)listener).exitAdditiveExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlayVisitor ) return ((PlayVisitor<? extends T>)visitor).visitAdditiveExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RelationalExprContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode LTEQ() { return getToken(PlayParser.LTEQ, 0); }
		public TerminalNode GTEQ() { return getToken(PlayParser.GTEQ, 0); }
		public TerminalNode LT() { return getToken(PlayParser.LT, 0); }
		public TerminalNode GT() { return getToken(PlayParser.GT, 0); }
		public RelationalExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlayListener ) ((PlayListener)listener).enterRelationalExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlayListener ) ((PlayListener)listener).exitRelationalExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlayVisitor ) return ((PlayVisitor<? extends T>)visitor).visitRelationalExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EqualityExprContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode EQ() { return getToken(PlayParser.EQ, 0); }
		public TerminalNode NEQ() { return getToken(PlayParser.NEQ, 0); }
		public EqualityExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlayListener ) ((PlayListener)listener).enterEqualityExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlayListener ) ((PlayListener)listener).exitEqualityExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlayVisitor ) return ((PlayVisitor<? extends T>)visitor).visitEqualityExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AndExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode AND() { return getToken(PlayParser.AND, 0); }
		public AndExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlayListener ) ((PlayListener)listener).enterAndExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlayListener ) ((PlayListener)listener).exitAndExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlayVisitor ) return ((PlayVisitor<? extends T>)visitor).visitAndExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 30;
		enterRecursionRule(_localctx, 30, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				_localctx = new UnaryMinusExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(141);
				match(MINUS);
				setState(142);
				expr(10);
				}
				break;
			case 2:
				{
				_localctx = new NotExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(143);
				match(NOT);
				setState(144);
				expr(9);
				}
				break;
			case 3:
				{
				_localctx = new AtomExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(145);
				atom();
				}
				break;
			case 4:
				{
				_localctx = new FunctionCallExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(146);
				function_call();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(169);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(167);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
					case 1:
						{
						_localctx = new MultiplicationExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(149);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(150);
						((MultiplicationExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 57344L) != 0)) ) {
							((MultiplicationExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(151);
						expr(9);
						}
						break;
					case 2:
						{
						_localctx = new AdditiveExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(152);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(153);
						((AdditiveExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
							((AdditiveExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(154);
						expr(8);
						}
						break;
					case 3:
						{
						_localctx = new RelationalExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(155);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(156);
						((RelationalExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1920L) != 0)) ) {
							((RelationalExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(157);
						expr(7);
						}
						break;
					case 4:
						{
						_localctx = new EqualityExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(158);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(159);
						((EqualityExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==EQ || _la==NEQ) ) {
							((EqualityExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(160);
						expr(6);
						}
						break;
					case 5:
						{
						_localctx = new AndExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(161);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(162);
						match(AND);
						setState(163);
						expr(5);
						}
						break;
					case 6:
						{
						_localctx = new OrExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(164);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(165);
						match(OR);
						setState(166);
						expr(4);
						}
						break;
					}
					} 
				}
				setState(171);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AtomContext extends ParserRuleContext {
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
	 
		public AtomContext() { }
		public void copyFrom(AtomContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParExprContext extends AtomContext {
		public TerminalNode OPAR() { return getToken(PlayParser.OPAR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode CPAR() { return getToken(PlayParser.CPAR, 0); }
		public ParExprContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlayListener ) ((PlayListener)listener).enterParExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlayListener ) ((PlayListener)listener).exitParExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlayVisitor ) return ((PlayVisitor<? extends T>)visitor).visitParExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BooleanAtomContext extends AtomContext {
		public TerminalNode TRUE() { return getToken(PlayParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(PlayParser.FALSE, 0); }
		public BooleanAtomContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlayListener ) ((PlayListener)listener).enterBooleanAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlayListener ) ((PlayListener)listener).exitBooleanAtom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlayVisitor ) return ((PlayVisitor<? extends T>)visitor).visitBooleanAtom(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IdAtomContext extends AtomContext {
		public TerminalNode ID() { return getToken(PlayParser.ID, 0); }
		public IdAtomContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlayListener ) ((PlayListener)listener).enterIdAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlayListener ) ((PlayListener)listener).exitIdAtom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlayVisitor ) return ((PlayVisitor<? extends T>)visitor).visitIdAtom(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StringAtomContext extends AtomContext {
		public TerminalNode STRING() { return getToken(PlayParser.STRING, 0); }
		public StringAtomContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlayListener ) ((PlayListener)listener).enterStringAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlayListener ) ((PlayListener)listener).exitStringAtom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlayVisitor ) return ((PlayVisitor<? extends T>)visitor).visitStringAtom(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NumberAtomContext extends AtomContext {
		public TerminalNode INT() { return getToken(PlayParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(PlayParser.FLOAT, 0); }
		public NumberAtomContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlayListener ) ((PlayListener)listener).enterNumberAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlayListener ) ((PlayListener)listener).exitNumberAtom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlayVisitor ) return ((PlayVisitor<? extends T>)visitor).visitNumberAtom(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NullAtomContext extends AtomContext {
		public TerminalNode NULL() { return getToken(PlayParser.NULL, 0); }
		public NullAtomContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlayListener ) ((PlayListener)listener).enterNullAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlayListener ) ((PlayListener)listener).exitNullAtom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PlayVisitor ) return ((PlayVisitor<? extends T>)visitor).visitNullAtom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_atom);
		int _la;
		try {
			setState(181);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OPAR:
				_localctx = new ParExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(172);
				match(OPAR);
				setState(173);
				expr(0);
				setState(174);
				match(CPAR);
				}
				break;
			case INT:
			case FLOAT:
				_localctx = new NumberAtomContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(176);
				_la = _input.LA(1);
				if ( !(_la==INT || _la==FLOAT) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case TRUE:
			case FALSE:
				_localctx = new BooleanAtomContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(177);
				_la = _input.LA(1);
				if ( !(_la==TRUE || _la==FALSE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case ID:
				_localctx = new IdAtomContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(178);
				match(ID);
				}
				break;
			case STRING:
				_localctx = new StringAtomContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(179);
				match(STRING);
				}
				break;
			case NULL:
				_localctx = new NullAtomContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(180);
				match(NULL);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 15:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 8);
		case 1:
			return precpred(_ctx, 7);
		case 2:
			return precpred(_ctx, 6);
		case 3:
			return precpred(_ctx, 5);
		case 4:
			return precpred(_ctx, 4);
		case 5:
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001&\u00b8\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001"+
		"\u0005\u0001\'\b\u0001\n\u0001\f\u0001*\t\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0003\u00026\b\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0003\u0003@\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0005\u0004G\b\u0004\n\u0004\f\u0004J\t\u0004\u0001\u0004"+
		"\u0001\u0004\u0003\u0004N\b\u0004\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006"+
		"X\b\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001"+
		"\b\u0001\b\u0001\t\u0001\t\u0001\t\u0003\td\b\t\u0001\t\u0001\t\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0003\nl\b\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000bv\b\u000b\n"+
		"\u000b\f\u000by\t\u000b\u0001\f\u0001\f\u0001\f\u0003\f~\b\f\u0001\f\u0001"+
		"\f\u0001\r\u0001\r\u0001\r\u0005\r\u0085\b\r\n\r\f\r\u0088\t\r\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u0094\b\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0005\u000f"+
		"\u00a8\b\u000f\n\u000f\f\u000f\u00ab\t\u000f\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0003\u0010\u00b6\b\u0010\u0001\u0010\u0000\u0001\u001e\u0011\u0000"+
		"\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c"+
		"\u001e \u0000\u0006\u0001\u0000\r\u000f\u0001\u0000\u000b\f\u0001\u0000"+
		"\u0007\n\u0001\u0000\u0005\u0006\u0001\u0000!\"\u0001\u0000\u0016\u0017"+
		"\u00c6\u0000\"\u0001\u0000\u0000\u0000\u0002(\u0001\u0000\u0000\u0000"+
		"\u00045\u0001\u0000\u0000\u0000\u0006?\u0001\u0000\u0000\u0000\bA\u0001"+
		"\u0000\u0000\u0000\nO\u0001\u0000\u0000\u0000\fW\u0001\u0000\u0000\u0000"+
		"\u000eY\u0001\u0000\u0000\u0000\u0010]\u0001\u0000\u0000\u0000\u0012`"+
		"\u0001\u0000\u0000\u0000\u0014g\u0001\u0000\u0000\u0000\u0016r\u0001\u0000"+
		"\u0000\u0000\u0018z\u0001\u0000\u0000\u0000\u001a\u0081\u0001\u0000\u0000"+
		"\u0000\u001c\u0089\u0001\u0000\u0000\u0000\u001e\u0093\u0001\u0000\u0000"+
		"\u0000 \u00b5\u0001\u0000\u0000\u0000\"#\u0003\u0002\u0001\u0000#$\u0005"+
		"\u0000\u0000\u0001$\u0001\u0001\u0000\u0000\u0000%\'\u0003\u0004\u0002"+
		"\u0000&%\u0001\u0000\u0000\u0000\'*\u0001\u0000\u0000\u0000(&\u0001\u0000"+
		"\u0000\u0000()\u0001\u0000\u0000\u0000)\u0003\u0001\u0000\u0000\u0000"+
		"*(\u0001\u0000\u0000\u0000+6\u0003\u0006\u0003\u0000,6\u0003\b\u0004\u0000"+
		"-6\u0003\u000e\u0007\u0000.6\u0003\u0010\b\u0000/6\u0003\u0014\n\u0000"+
		"06\u0003\u0018\f\u000016\u0003\u001c\u000e\u000026\u0003\u0012\t\u0000"+
		"34\u0005&\u0000\u000046\u0006\u0002\uffff\uffff\u00005+\u0001\u0000\u0000"+
		"\u00005,\u0001\u0000\u0000\u00005-\u0001\u0000\u0000\u00005.\u0001\u0000"+
		"\u0000\u00005/\u0001\u0000\u0000\u000050\u0001\u0000\u0000\u000051\u0001"+
		"\u0000\u0000\u000052\u0001\u0000\u0000\u000053\u0001\u0000\u0000\u0000"+
		"6\u0005\u0001\u0000\u0000\u000078\u0005\u0001\u0000\u000089\u0005 \u0000"+
		"\u00009:\u0005\u0011\u0000\u0000:@\u0003\u001e\u000f\u0000;<\u0005\u0001"+
		"\u0000\u0000<=\u0005 \u0000\u0000=>\u0005\u0011\u0000\u0000>@\u0003\u0012"+
		"\t\u0000?7\u0001\u0000\u0000\u0000?;\u0001\u0000\u0000\u0000@\u0007\u0001"+
		"\u0000\u0000\u0000AB\u0005\u0019\u0000\u0000BH\u0003\n\u0005\u0000CD\u0005"+
		"\u001a\u0000\u0000DE\u0005\u0019\u0000\u0000EG\u0003\n\u0005\u0000FC\u0001"+
		"\u0000\u0000\u0000GJ\u0001\u0000\u0000\u0000HF\u0001\u0000\u0000\u0000"+
		"HI\u0001\u0000\u0000\u0000IM\u0001\u0000\u0000\u0000JH\u0001\u0000\u0000"+
		"\u0000KL\u0005\u001a\u0000\u0000LN\u0003\f\u0006\u0000MK\u0001\u0000\u0000"+
		"\u0000MN\u0001\u0000\u0000\u0000N\t\u0001\u0000\u0000\u0000OP\u0003\u001e"+
		"\u000f\u0000PQ\u0003\f\u0006\u0000Q\u000b\u0001\u0000\u0000\u0000RS\u0005"+
		"\u0014\u0000\u0000ST\u0003\u0002\u0001\u0000TU\u0005\u0015\u0000\u0000"+
		"UX\u0001\u0000\u0000\u0000VX\u0003\u0004\u0002\u0000WR\u0001\u0000\u0000"+
		"\u0000WV\u0001\u0000\u0000\u0000X\r\u0001\u0000\u0000\u0000YZ\u0005\u001b"+
		"\u0000\u0000Z[\u0003\u001e\u000f\u0000[\\\u0003\f\u0006\u0000\\\u000f"+
		"\u0001\u0000\u0000\u0000]^\u0005\u001c\u0000\u0000^_\u0003\u001e\u000f"+
		"\u0000_\u0011\u0001\u0000\u0000\u0000`a\u0005\u001f\u0000\u0000ac\u0005"+
		"\u0012\u0000\u0000bd\u0005#\u0000\u0000cb\u0001\u0000\u0000\u0000cd\u0001"+
		"\u0000\u0000\u0000de\u0001\u0000\u0000\u0000ef\u0005\u0013\u0000\u0000"+
		"f\u0013\u0001\u0000\u0000\u0000gh\u0005\u001d\u0000\u0000hi\u0005 \u0000"+
		"\u0000ik\u0005\u0012\u0000\u0000jl\u0003\u0016\u000b\u0000kj\u0001\u0000"+
		"\u0000\u0000kl\u0001\u0000\u0000\u0000lm\u0001\u0000\u0000\u0000mn\u0005"+
		"\u0013\u0000\u0000no\u0005\u0014\u0000\u0000op\u0003\u0002\u0001\u0000"+
		"pq\u0005\u0015\u0000\u0000q\u0015\u0001\u0000\u0000\u0000rw\u0005 \u0000"+
		"\u0000st\u0005\u0002\u0000\u0000tv\u0005 \u0000\u0000us\u0001\u0000\u0000"+
		"\u0000vy\u0001\u0000\u0000\u0000wu\u0001\u0000\u0000\u0000wx\u0001\u0000"+
		"\u0000\u0000x\u0017\u0001\u0000\u0000\u0000yw\u0001\u0000\u0000\u0000"+
		"z{\u0005 \u0000\u0000{}\u0005\u0012\u0000\u0000|~\u0003\u001a\r\u0000"+
		"}|\u0001\u0000\u0000\u0000}~\u0001\u0000\u0000\u0000~\u007f\u0001\u0000"+
		"\u0000\u0000\u007f\u0080\u0005\u0013\u0000\u0000\u0080\u0019\u0001\u0000"+
		"\u0000\u0000\u0081\u0086\u0003\u001e\u000f\u0000\u0082\u0083\u0005\u0002"+
		"\u0000\u0000\u0083\u0085\u0003\u001e\u000f\u0000\u0084\u0082\u0001\u0000"+
		"\u0000\u0000\u0085\u0088\u0001\u0000\u0000\u0000\u0086\u0084\u0001\u0000"+
		"\u0000\u0000\u0086\u0087\u0001\u0000\u0000\u0000\u0087\u001b\u0001\u0000"+
		"\u0000\u0000\u0088\u0086\u0001\u0000\u0000\u0000\u0089\u008a\u0005\u001e"+
		"\u0000\u0000\u008a\u008b\u0003\u001e\u000f\u0000\u008b\u001d\u0001\u0000"+
		"\u0000\u0000\u008c\u008d\u0006\u000f\uffff\uffff\u0000\u008d\u008e\u0005"+
		"\f\u0000\u0000\u008e\u0094\u0003\u001e\u000f\n\u008f\u0090\u0005\u0010"+
		"\u0000\u0000\u0090\u0094\u0003\u001e\u000f\t\u0091\u0094\u0003 \u0010"+
		"\u0000\u0092\u0094\u0003\u0018\f\u0000\u0093\u008c\u0001\u0000\u0000\u0000"+
		"\u0093\u008f\u0001\u0000\u0000\u0000\u0093\u0091\u0001\u0000\u0000\u0000"+
		"\u0093\u0092\u0001\u0000\u0000\u0000\u0094\u00a9\u0001\u0000\u0000\u0000"+
		"\u0095\u0096\n\b\u0000\u0000\u0096\u0097\u0007\u0000\u0000\u0000\u0097"+
		"\u00a8\u0003\u001e\u000f\t\u0098\u0099\n\u0007\u0000\u0000\u0099\u009a"+
		"\u0007\u0001\u0000\u0000\u009a\u00a8\u0003\u001e\u000f\b\u009b\u009c\n"+
		"\u0006\u0000\u0000\u009c\u009d\u0007\u0002\u0000\u0000\u009d\u00a8\u0003"+
		"\u001e\u000f\u0007\u009e\u009f\n\u0005\u0000\u0000\u009f\u00a0\u0007\u0003"+
		"\u0000\u0000\u00a0\u00a8\u0003\u001e\u000f\u0006\u00a1\u00a2\n\u0004\u0000"+
		"\u0000\u00a2\u00a3\u0005\u0004\u0000\u0000\u00a3\u00a8\u0003\u001e\u000f"+
		"\u0005\u00a4\u00a5\n\u0003\u0000\u0000\u00a5\u00a6\u0005\u0003\u0000\u0000"+
		"\u00a6\u00a8\u0003\u001e\u000f\u0004\u00a7\u0095\u0001\u0000\u0000\u0000"+
		"\u00a7\u0098\u0001\u0000\u0000\u0000\u00a7\u009b\u0001\u0000\u0000\u0000"+
		"\u00a7\u009e\u0001\u0000\u0000\u0000\u00a7\u00a1\u0001\u0000\u0000\u0000"+
		"\u00a7\u00a4\u0001\u0000\u0000\u0000\u00a8\u00ab\u0001\u0000\u0000\u0000"+
		"\u00a9\u00a7\u0001\u0000\u0000\u0000\u00a9\u00aa\u0001\u0000\u0000\u0000"+
		"\u00aa\u001f\u0001\u0000\u0000\u0000\u00ab\u00a9\u0001\u0000\u0000\u0000"+
		"\u00ac\u00ad\u0005\u0012\u0000\u0000\u00ad\u00ae\u0003\u001e\u000f\u0000"+
		"\u00ae\u00af\u0005\u0013\u0000\u0000\u00af\u00b6\u0001\u0000\u0000\u0000"+
		"\u00b0\u00b6\u0007\u0004\u0000\u0000\u00b1\u00b6\u0007\u0005\u0000\u0000"+
		"\u00b2\u00b6\u0005 \u0000\u0000\u00b3\u00b6\u0005#\u0000\u0000\u00b4\u00b6"+
		"\u0005\u0018\u0000\u0000\u00b5\u00ac\u0001\u0000\u0000\u0000\u00b5\u00b0"+
		"\u0001\u0000\u0000\u0000\u00b5\u00b1\u0001\u0000\u0000\u0000\u00b5\u00b2"+
		"\u0001\u0000\u0000\u0000\u00b5\u00b3\u0001\u0000\u0000\u0000\u00b5\u00b4"+
		"\u0001\u0000\u0000\u0000\u00b6!\u0001\u0000\u0000\u0000\u000f(5?HMWck"+
		"w}\u0086\u0093\u00a7\u00a9\u00b5";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}