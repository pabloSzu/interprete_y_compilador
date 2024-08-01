// Generated from c:/Users/pablo/Desktop/TC-Final/Interprete_y_compilador/interprete/src/main/antlr4/com/simple/interprete/Simple.g4 by ANTLR 4.13.1

	import java.util.Map;
	import java.util.HashMap;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class SimpleParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WS=1, PROGRAM=2, VAR=3, PRINTLN=4, IF=5, ELSE=6, PLUS=7, MINUS=8, MULT=9, 
		DIV=10, EXP=11, AND=12, OR=13, NOT=14, NEQ=15, EQ=16, GEQ=17, LEQ=18, 
		GT=19, LT=20, ASSIGN=21, BRA_OPEN=22, BRA_CLOSE=23, PAR_OPEN=24, PAR_CLOSE=25, 
		SEMICOLON=26, BOOLEAN=27, ID=28, NUMBER=29;
	public static final int
		RULE_program = 0, RULE_sentence = 1, RULE_var_decl = 2, RULE_var_assign = 3, 
		RULE_println = 4, RULE_conditional = 5, RULE_expression = 6, RULE_factor = 7, 
		RULE_term = 8, RULE_base = 9;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "sentence", "var_decl", "var_assign", "println", "conditional", 
			"expression", "factor", "term", "base"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, "'program'", "'var'", "'println'", "'if'", "'else'", "'+'", 
			"'-'", "'*'", "'/'", "'^'", "'&&'", "'||'", "'!'", "'!='", "'=='", "'>='", 
			"'<='", "'>'", "'<'", "'='", "'{'", "'}'", "'('", "')'", "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "WS", "PROGRAM", "VAR", "PRINTLN", "IF", "ELSE", "PLUS", "MINUS", 
			"MULT", "DIV", "EXP", "AND", "OR", "NOT", "NEQ", "EQ", "GEQ", "LEQ", 
			"GT", "LT", "ASSIGN", "BRA_OPEN", "BRA_CLOSE", "PAR_OPEN", "PAR_CLOSE", 
			"SEMICOLON", "BOOLEAN", "ID", "NUMBER"
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
	public String getGrammarFileName() { return "Simple.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


		Map<String, Object> symbolTable = new HashMap<String, Object>();

	public SimpleParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode PROGRAM() { return getToken(SimpleParser.PROGRAM, 0); }
		public TerminalNode ID() { return getToken(SimpleParser.ID, 0); }
		public TerminalNode BRA_OPEN() { return getToken(SimpleParser.BRA_OPEN, 0); }
		public TerminalNode BRA_CLOSE() { return getToken(SimpleParser.BRA_CLOSE, 0); }
		public List<SentenceContext> sentence() {
			return getRuleContexts(SentenceContext.class);
		}
		public SentenceContext sentence(int i) {
			return getRuleContext(SentenceContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleListener ) ((SimpleListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleListener ) ((SimpleListener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(20);
			match(PROGRAM);
			setState(21);
			match(ID);
			setState(22);
			match(BRA_OPEN);
			setState(26);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 268435512L) != 0)) {
				{
				{
				setState(23);
				sentence();
				}
				}
				setState(28);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(29);
			match(BRA_CLOSE);
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
	public static class SentenceContext extends ParserRuleContext {
		public Var_declContext var_decl() {
			return getRuleContext(Var_declContext.class,0);
		}
		public Var_assignContext var_assign() {
			return getRuleContext(Var_assignContext.class,0);
		}
		public PrintlnContext println() {
			return getRuleContext(PrintlnContext.class,0);
		}
		public ConditionalContext conditional() {
			return getRuleContext(ConditionalContext.class,0);
		}
		public SentenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentence; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleListener ) ((SimpleListener)listener).enterSentence(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleListener ) ((SimpleListener)listener).exitSentence(this);
		}
	}

	public final SentenceContext sentence() throws RecognitionException {
		SentenceContext _localctx = new SentenceContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_sentence);
		try {
			setState(35);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(31);
				var_decl();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(32);
				var_assign();
				}
				break;
			case PRINTLN:
				enterOuterAlt(_localctx, 3);
				{
				setState(33);
				println();
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 4);
				{
				setState(34);
				conditional();
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
	public static class Var_declContext extends ParserRuleContext {
		public Token ID;
		public TerminalNode VAR() { return getToken(SimpleParser.VAR, 0); }
		public TerminalNode ID() { return getToken(SimpleParser.ID, 0); }
		public TerminalNode SEMICOLON() { return getToken(SimpleParser.SEMICOLON, 0); }
		public Var_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleListener ) ((SimpleListener)listener).enterVar_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleListener ) ((SimpleListener)listener).exitVar_decl(this);
		}
	}

	public final Var_declContext var_decl() throws RecognitionException {
		Var_declContext _localctx = new Var_declContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_var_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(37);
			match(VAR);
			setState(38);
			((Var_declContext)_localctx).ID = match(ID);
			setState(39);
			match(SEMICOLON);
			symbolTable.put((((Var_declContext)_localctx).ID!=null?((Var_declContext)_localctx).ID.getText():null),0);
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
	public static class Var_assignContext extends ParserRuleContext {
		public Token ID;
		public ExpressionContext expression;
		public TerminalNode ID() { return getToken(SimpleParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(SimpleParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(SimpleParser.SEMICOLON, 0); }
		public Var_assignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_assign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleListener ) ((SimpleListener)listener).enterVar_assign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleListener ) ((SimpleListener)listener).exitVar_assign(this);
		}
	}

	public final Var_assignContext var_assign() throws RecognitionException {
		Var_assignContext _localctx = new Var_assignContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_var_assign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
			((Var_assignContext)_localctx).ID = match(ID);
			setState(43);
			match(ASSIGN);
			setState(44);
			((Var_assignContext)_localctx).expression = expression();
			setState(45);
			match(SEMICOLON);
			symbolTable.put((((Var_assignContext)_localctx).ID!=null?((Var_assignContext)_localctx).ID.getText():null), ((Var_assignContext)_localctx).expression.value);
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
	public static class PrintlnContext extends ParserRuleContext {
		public ExpressionContext expression;
		public TerminalNode PRINTLN() { return getToken(SimpleParser.PRINTLN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(SimpleParser.SEMICOLON, 0); }
		public PrintlnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_println; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleListener ) ((SimpleListener)listener).enterPrintln(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleListener ) ((SimpleListener)listener).exitPrintln(this);
		}
	}

	public final PrintlnContext println() throws RecognitionException {
		PrintlnContext _localctx = new PrintlnContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_println);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48);
			match(PRINTLN);
			setState(49);
			((PrintlnContext)_localctx).expression = expression();
			setState(50);
			match(SEMICOLON);
			System.out.println(((PrintlnContext)_localctx).expression.value);
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
	public static class ConditionalContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(SimpleParser.IF, 0); }
		public TerminalNode PAR_OPEN() { return getToken(SimpleParser.PAR_OPEN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode PAR_CLOSE() { return getToken(SimpleParser.PAR_CLOSE, 0); }
		public List<TerminalNode> BRA_OPEN() { return getTokens(SimpleParser.BRA_OPEN); }
		public TerminalNode BRA_OPEN(int i) {
			return getToken(SimpleParser.BRA_OPEN, i);
		}
		public List<TerminalNode> BRA_CLOSE() { return getTokens(SimpleParser.BRA_CLOSE); }
		public TerminalNode BRA_CLOSE(int i) {
			return getToken(SimpleParser.BRA_CLOSE, i);
		}
		public TerminalNode ELSE() { return getToken(SimpleParser.ELSE, 0); }
		public List<SentenceContext> sentence() {
			return getRuleContexts(SentenceContext.class);
		}
		public SentenceContext sentence(int i) {
			return getRuleContext(SentenceContext.class,i);
		}
		public ConditionalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditional; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleListener ) ((SimpleListener)listener).enterConditional(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleListener ) ((SimpleListener)listener).exitConditional(this);
		}
	}

	public final ConditionalContext conditional() throws RecognitionException {
		ConditionalContext _localctx = new ConditionalContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_conditional);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			match(IF);
			setState(54);
			match(PAR_OPEN);
			setState(55);
			expression();
			setState(56);
			match(PAR_CLOSE);
			setState(57);
			match(BRA_OPEN);
			setState(61);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 268435512L) != 0)) {
				{
				{
				setState(58);
				sentence();
				}
				}
				setState(63);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(64);
			match(BRA_CLOSE);
			setState(65);
			match(ELSE);
			setState(66);
			match(BRA_OPEN);
			setState(70);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 268435512L) != 0)) {
				{
				{
				setState(67);
				sentence();
				}
				}
				setState(72);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(73);
			match(BRA_CLOSE);
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
	public static class ExpressionContext extends ParserRuleContext {
		public Object value;
		public FactorContext t1;
		public FactorContext t2;
		public List<FactorContext> factor() {
			return getRuleContexts(FactorContext.class);
		}
		public FactorContext factor(int i) {
			return getRuleContext(FactorContext.class,i);
		}
		public List<TerminalNode> PLUS() { return getTokens(SimpleParser.PLUS); }
		public TerminalNode PLUS(int i) {
			return getToken(SimpleParser.PLUS, i);
		}
		public List<TerminalNode> MINUS() { return getTokens(SimpleParser.MINUS); }
		public TerminalNode MINUS(int i) {
			return getToken(SimpleParser.MINUS, i);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleListener ) ((SimpleListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleListener ) ((SimpleListener)listener).exitExpression(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			((ExpressionContext)_localctx).t1 = factor();
			((ExpressionContext)_localctx).value =  ((ExpressionContext)_localctx).t1.value;
			setState(87);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PLUS || _la==MINUS) {
				{
				setState(85);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case PLUS:
					{
					setState(77);
					match(PLUS);
					setState(78);
					((ExpressionContext)_localctx).t2 = factor();
					((ExpressionContext)_localctx).value =  (int)_localctx.value + (int)((ExpressionContext)_localctx).t2.value;
					}
					break;
				case MINUS:
					{
					setState(81);
					match(MINUS);
					setState(82);
					((ExpressionContext)_localctx).t2 = factor();
					((ExpressionContext)_localctx).value =  (int)_localctx.value - (int)((ExpressionContext)_localctx).t2.value;
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(89);
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
	public static class FactorContext extends ParserRuleContext {
		public Object value;
		public TermContext t1;
		public TermContext t2;
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public List<TerminalNode> MULT() { return getTokens(SimpleParser.MULT); }
		public TerminalNode MULT(int i) {
			return getToken(SimpleParser.MULT, i);
		}
		public List<TerminalNode> DIV() { return getTokens(SimpleParser.DIV); }
		public TerminalNode DIV(int i) {
			return getToken(SimpleParser.DIV, i);
		}
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleListener ) ((SimpleListener)listener).enterFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleListener ) ((SimpleListener)listener).exitFactor(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_factor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			((FactorContext)_localctx).t1 = term();
			((FactorContext)_localctx).value =  ((FactorContext)_localctx).t1.value;
			setState(102);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MULT || _la==DIV) {
				{
				setState(100);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case MULT:
					{
					setState(92);
					match(MULT);
					setState(93);
					((FactorContext)_localctx).t2 = term();
					((FactorContext)_localctx).value =  (int)_localctx.value * (int)((FactorContext)_localctx).t2.value;
					}
					break;
				case DIV:
					{
					setState(96);
					match(DIV);
					setState(97);
					((FactorContext)_localctx).t2 = term();
					((FactorContext)_localctx).value =  (int)_localctx.value / (int)((FactorContext)_localctx).t2.value;
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(104);
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
	public static class TermContext extends ParserRuleContext {
		public Object value;
		public BaseContext t1;
		public BaseContext t2;
		public List<BaseContext> base() {
			return getRuleContexts(BaseContext.class);
		}
		public BaseContext base(int i) {
			return getRuleContext(BaseContext.class,i);
		}
		public List<TerminalNode> EXP() { return getTokens(SimpleParser.EXP); }
		public TerminalNode EXP(int i) {
			return getToken(SimpleParser.EXP, i);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleListener ) ((SimpleListener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleListener ) ((SimpleListener)listener).exitTerm(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			((TermContext)_localctx).t1 = base();
			((TermContext)_localctx).value =  ((TermContext)_localctx).t1.value;
			setState(113);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==EXP) {
				{
				{
				setState(107);
				match(EXP);
				setState(108);
				((TermContext)_localctx).t2 = base();
				((TermContext)_localctx).value =  Math.pow((int)_localctx.value, (int)((TermContext)_localctx).t2.value);
				}
				}
				setState(115);
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
	public static class BaseContext extends ParserRuleContext {
		public Object value;
		public Token NUMBER;
		public Token ID;
		public ExpressionContext expression;
		public TerminalNode NUMBER() { return getToken(SimpleParser.NUMBER, 0); }
		public TerminalNode ID() { return getToken(SimpleParser.ID, 0); }
		public TerminalNode PAR_OPEN() { return getToken(SimpleParser.PAR_OPEN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode PAR_CLOSE() { return getToken(SimpleParser.PAR_CLOSE, 0); }
		public BaseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_base; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleListener ) ((SimpleListener)listener).enterBase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleListener ) ((SimpleListener)listener).exitBase(this);
		}
	}

	public final BaseContext base() throws RecognitionException {
		BaseContext _localctx = new BaseContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_base);
		try {
			setState(125);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMBER:
				enterOuterAlt(_localctx, 1);
				{
				setState(116);
				((BaseContext)_localctx).NUMBER = match(NUMBER);
				((BaseContext)_localctx).value =  Integer.parseInt((((BaseContext)_localctx).NUMBER!=null?((BaseContext)_localctx).NUMBER.getText():null));
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(118);
				((BaseContext)_localctx).ID = match(ID);
				((BaseContext)_localctx).value =  symbolTable.get((((BaseContext)_localctx).ID!=null?((BaseContext)_localctx).ID.getText():null)) != null ? symbolTable.get((((BaseContext)_localctx).ID!=null?((BaseContext)_localctx).ID.getText():null)) : 0;
				}
				break;
			case PAR_OPEN:
				enterOuterAlt(_localctx, 3);
				{
				setState(120);
				match(PAR_OPEN);
				setState(121);
				((BaseContext)_localctx).expression = expression();
				setState(122);
				match(PAR_CLOSE);
				((BaseContext)_localctx).value =  ((BaseContext)_localctx).expression.value;
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
		"\u0004\u0001\u001d\u0080\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0005\u0000\u0019\b\u0000\n\u0000\f\u0000\u001c\t\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001"+
		"$\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005"+
		"<\b\u0005\n\u0005\f\u0005?\t\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0005\u0005E\b\u0005\n\u0005\f\u0005H\t\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0005\u0006"+
		"V\b\u0006\n\u0006\f\u0006Y\t\u0006\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0005\u0007e\b\u0007\n\u0007\f\u0007h\t\u0007\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0005\bp\b\b\n\b\f\bs\t\b\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003\t~\b"+
		"\t\u0001\t\u0000\u0000\n\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012"+
		"\u0000\u0000\u0082\u0000\u0014\u0001\u0000\u0000\u0000\u0002#\u0001\u0000"+
		"\u0000\u0000\u0004%\u0001\u0000\u0000\u0000\u0006*\u0001\u0000\u0000\u0000"+
		"\b0\u0001\u0000\u0000\u0000\n5\u0001\u0000\u0000\u0000\fK\u0001\u0000"+
		"\u0000\u0000\u000eZ\u0001\u0000\u0000\u0000\u0010i\u0001\u0000\u0000\u0000"+
		"\u0012}\u0001\u0000\u0000\u0000\u0014\u0015\u0005\u0002\u0000\u0000\u0015"+
		"\u0016\u0005\u001c\u0000\u0000\u0016\u001a\u0005\u0016\u0000\u0000\u0017"+
		"\u0019\u0003\u0002\u0001\u0000\u0018\u0017\u0001\u0000\u0000\u0000\u0019"+
		"\u001c\u0001\u0000\u0000\u0000\u001a\u0018\u0001\u0000\u0000\u0000\u001a"+
		"\u001b\u0001\u0000\u0000\u0000\u001b\u001d\u0001\u0000\u0000\u0000\u001c"+
		"\u001a\u0001\u0000\u0000\u0000\u001d\u001e\u0005\u0017\u0000\u0000\u001e"+
		"\u0001\u0001\u0000\u0000\u0000\u001f$\u0003\u0004\u0002\u0000 $\u0003"+
		"\u0006\u0003\u0000!$\u0003\b\u0004\u0000\"$\u0003\n\u0005\u0000#\u001f"+
		"\u0001\u0000\u0000\u0000# \u0001\u0000\u0000\u0000#!\u0001\u0000\u0000"+
		"\u0000#\"\u0001\u0000\u0000\u0000$\u0003\u0001\u0000\u0000\u0000%&\u0005"+
		"\u0003\u0000\u0000&\'\u0005\u001c\u0000\u0000\'(\u0005\u001a\u0000\u0000"+
		"()\u0006\u0002\uffff\uffff\u0000)\u0005\u0001\u0000\u0000\u0000*+\u0005"+
		"\u001c\u0000\u0000+,\u0005\u0015\u0000\u0000,-\u0003\f\u0006\u0000-.\u0005"+
		"\u001a\u0000\u0000./\u0006\u0003\uffff\uffff\u0000/\u0007\u0001\u0000"+
		"\u0000\u000001\u0005\u0004\u0000\u000012\u0003\f\u0006\u000023\u0005\u001a"+
		"\u0000\u000034\u0006\u0004\uffff\uffff\u00004\t\u0001\u0000\u0000\u0000"+
		"56\u0005\u0005\u0000\u000067\u0005\u0018\u0000\u000078\u0003\f\u0006\u0000"+
		"89\u0005\u0019\u0000\u00009=\u0005\u0016\u0000\u0000:<\u0003\u0002\u0001"+
		"\u0000;:\u0001\u0000\u0000\u0000<?\u0001\u0000\u0000\u0000=;\u0001\u0000"+
		"\u0000\u0000=>\u0001\u0000\u0000\u0000>@\u0001\u0000\u0000\u0000?=\u0001"+
		"\u0000\u0000\u0000@A\u0005\u0017\u0000\u0000AB\u0005\u0006\u0000\u0000"+
		"BF\u0005\u0016\u0000\u0000CE\u0003\u0002\u0001\u0000DC\u0001\u0000\u0000"+
		"\u0000EH\u0001\u0000\u0000\u0000FD\u0001\u0000\u0000\u0000FG\u0001\u0000"+
		"\u0000\u0000GI\u0001\u0000\u0000\u0000HF\u0001\u0000\u0000\u0000IJ\u0005"+
		"\u0017\u0000\u0000J\u000b\u0001\u0000\u0000\u0000KL\u0003\u000e\u0007"+
		"\u0000LW\u0006\u0006\uffff\uffff\u0000MN\u0005\u0007\u0000\u0000NO\u0003"+
		"\u000e\u0007\u0000OP\u0006\u0006\uffff\uffff\u0000PV\u0001\u0000\u0000"+
		"\u0000QR\u0005\b\u0000\u0000RS\u0003\u000e\u0007\u0000ST\u0006\u0006\uffff"+
		"\uffff\u0000TV\u0001\u0000\u0000\u0000UM\u0001\u0000\u0000\u0000UQ\u0001"+
		"\u0000\u0000\u0000VY\u0001\u0000\u0000\u0000WU\u0001\u0000\u0000\u0000"+
		"WX\u0001\u0000\u0000\u0000X\r\u0001\u0000\u0000\u0000YW\u0001\u0000\u0000"+
		"\u0000Z[\u0003\u0010\b\u0000[f\u0006\u0007\uffff\uffff\u0000\\]\u0005"+
		"\t\u0000\u0000]^\u0003\u0010\b\u0000^_\u0006\u0007\uffff\uffff\u0000_"+
		"e\u0001\u0000\u0000\u0000`a\u0005\n\u0000\u0000ab\u0003\u0010\b\u0000"+
		"bc\u0006\u0007\uffff\uffff\u0000ce\u0001\u0000\u0000\u0000d\\\u0001\u0000"+
		"\u0000\u0000d`\u0001\u0000\u0000\u0000eh\u0001\u0000\u0000\u0000fd\u0001"+
		"\u0000\u0000\u0000fg\u0001\u0000\u0000\u0000g\u000f\u0001\u0000\u0000"+
		"\u0000hf\u0001\u0000\u0000\u0000ij\u0003\u0012\t\u0000jq\u0006\b\uffff"+
		"\uffff\u0000kl\u0005\u000b\u0000\u0000lm\u0003\u0012\t\u0000mn\u0006\b"+
		"\uffff\uffff\u0000np\u0001\u0000\u0000\u0000ok\u0001\u0000\u0000\u0000"+
		"ps\u0001\u0000\u0000\u0000qo\u0001\u0000\u0000\u0000qr\u0001\u0000\u0000"+
		"\u0000r\u0011\u0001\u0000\u0000\u0000sq\u0001\u0000\u0000\u0000tu\u0005"+
		"\u001d\u0000\u0000u~\u0006\t\uffff\uffff\u0000vw\u0005\u001c\u0000\u0000"+
		"w~\u0006\t\uffff\uffff\u0000xy\u0005\u0018\u0000\u0000yz\u0003\f\u0006"+
		"\u0000z{\u0005\u0019\u0000\u0000{|\u0006\t\uffff\uffff\u0000|~\u0001\u0000"+
		"\u0000\u0000}t\u0001\u0000\u0000\u0000}v\u0001\u0000\u0000\u0000}x\u0001"+
		"\u0000\u0000\u0000~\u0013\u0001\u0000\u0000\u0000\n\u001a#=FUWdfq}";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}