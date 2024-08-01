// Generated from proyectoFinal\Interpretador\Simple.g4 by ANTLR 4.9.2
package proyectoFinal.Interpretador;

    import proyectoFinal.Interpretador.TablaSimbolos.Symbol;
    import proyectoFinal.Interpretador.TablaSimbolos.SymbolTable;
    import java.util.Map;
    import java.util.HashMap;
    import java.util.List;
    import java.util.ArrayList;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SimpleParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PREPROCESSOR=1, PA=2, PC=3, CA=4, CC=5, LA=6, LC=7, PYC=8, COMA=9, IGUAL=10, 
		MAYOR=11, MAYOR_IGUAL=12, MENOR=13, MENOR_IGUAL=14, EQL=15, DISTINTO=16, 
		SUM=17, RES=18, MUL=19, DIV=20, MOD=21, OR=22, AND=23, NOT=24, WHILE=25, 
		IF=26, ELSE=27, INT=28, CHAR=29, DOUBLE=30, VOID=31, RETURN=32, PRINT=33, 
		PRINTF=34, ID=35, INTEGER=36, DECIMAL=37, CHARACTER=38, STRING=39, WS=40, 
		OTRO=41;
	public static final int
		RULE_prog = 0, RULE_instrucciones = 1, RULE_instruccion = 2, RULE_retorno = 3, 
		RULE_declaracion = 4, RULE_asignacion = 5, RULE_tipoDato = 6, RULE_condif = 7, 
		RULE_bucleWhile = 8, RULE_declaracionFuncion = 9, RULE_definicionFuncion = 10, 
		RULE_parametros = 11, RULE_llamadaFuncion = 12, RULE_llamadaPrint = 13, 
		RULE_llamadaPrintf = 14, RULE_argumentos = 15, RULE_operacion = 16, RULE_expresion = 17, 
		RULE_operacionComparacion = 18, RULE_operacionLogica = 19, RULE_operacionAritmetica = 20, 
		RULE_term = 21, RULE_factor = 22, RULE_bloque = 23;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "instrucciones", "instruccion", "retorno", "declaracion", "asignacion", 
			"tipoDato", "condif", "bucleWhile", "declaracionFuncion", "definicionFuncion", 
			"parametros", "llamadaFuncion", "llamadaPrint", "llamadaPrintf", "argumentos", 
			"operacion", "expresion", "operacionComparacion", "operacionLogica", 
			"operacionAritmetica", "term", "factor", "bloque"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, "'('", "')'", "'['", "']'", "'{'", "'}'", "';'", "','", "'='", 
			"'>'", "'>='", "'<'", "'<='", "'=='", "'!='", "'+'", "'-'", "'*'", "'/'", 
			"'%'", "'||'", "'&&'", "'!'", "'while'", "'if'", "'else'", "'int'", "'char'", 
			"'double'", "'void'", "'return'", "'print'", "'printf'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "PREPROCESSOR", "PA", "PC", "CA", "CC", "LA", "LC", "PYC", "COMA", 
			"IGUAL", "MAYOR", "MAYOR_IGUAL", "MENOR", "MENOR_IGUAL", "EQL", "DISTINTO", 
			"SUM", "RES", "MUL", "DIV", "MOD", "OR", "AND", "NOT", "WHILE", "IF", 
			"ELSE", "INT", "CHAR", "DOUBLE", "VOID", "RETURN", "PRINT", "PRINTF", 
			"ID", "INTEGER", "DECIMAL", "CHARACTER", "STRING", "WS", "OTRO"
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


	    private Map<String, Symbol> symbolTable = new HashMap<>();
	    private List<String> errors = new ArrayList<>();

	    public Map<String, Symbol> getSymbolTable() {
	        return symbolTable;
	    }

	    public List<String> getErrors() {
	        return errors;
	    }

	public SimpleParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(SimpleParser.EOF, 0); }
		public TerminalNode PREPROCESSOR() { return getToken(SimpleParser.PREPROCESSOR, 0); }
		public InstruccionesContext instrucciones() {
			return getRuleContext(InstruccionesContext.class,0);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleListener ) ((SimpleListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleListener ) ((SimpleListener)listener).exitProg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleVisitor ) return ((SimpleVisitor<? extends T>)visitor).visitProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PREPROCESSOR:
				{
				setState(48);
				match(PREPROCESSOR);
				}
				break;
			case LA:
			case WHILE:
			case IF:
			case INT:
			case CHAR:
			case DOUBLE:
			case VOID:
			case RETURN:
			case PRINT:
			case PRINTF:
			case ID:
				{
				setState(49);
				instrucciones();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(52);
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

	public static class InstruccionesContext extends ParserRuleContext {
		public List<InstruccionContext> instruccion() {
			return getRuleContexts(InstruccionContext.class);
		}
		public InstruccionContext instruccion(int i) {
			return getRuleContext(InstruccionContext.class,i);
		}
		public InstruccionesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instrucciones; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleListener ) ((SimpleListener)listener).enterInstrucciones(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleListener ) ((SimpleListener)listener).exitInstrucciones(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleVisitor ) return ((SimpleVisitor<? extends T>)visitor).visitInstrucciones(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstruccionesContext instrucciones() throws RecognitionException {
		InstruccionesContext _localctx = new InstruccionesContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_instrucciones);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(54);
				instruccion();
				}
				}
				setState(57); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LA) | (1L << WHILE) | (1L << IF) | (1L << INT) | (1L << CHAR) | (1L << DOUBLE) | (1L << VOID) | (1L << RETURN) | (1L << PRINT) | (1L << PRINTF) | (1L << ID))) != 0) );
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

	public static class InstruccionContext extends ParserRuleContext {
		public DeclaracionContext declaracion() {
			return getRuleContext(DeclaracionContext.class,0);
		}
		public TerminalNode PYC() { return getToken(SimpleParser.PYC, 0); }
		public AsignacionContext asignacion() {
			return getRuleContext(AsignacionContext.class,0);
		}
		public BucleWhileContext bucleWhile() {
			return getRuleContext(BucleWhileContext.class,0);
		}
		public CondifContext condif() {
			return getRuleContext(CondifContext.class,0);
		}
		public DeclaracionFuncionContext declaracionFuncion() {
			return getRuleContext(DeclaracionFuncionContext.class,0);
		}
		public DefinicionFuncionContext definicionFuncion() {
			return getRuleContext(DefinicionFuncionContext.class,0);
		}
		public LlamadaFuncionContext llamadaFuncion() {
			return getRuleContext(LlamadaFuncionContext.class,0);
		}
		public RetornoContext retorno() {
			return getRuleContext(RetornoContext.class,0);
		}
		public BloqueContext bloque() {
			return getRuleContext(BloqueContext.class,0);
		}
		public LlamadaPrintContext llamadaPrint() {
			return getRuleContext(LlamadaPrintContext.class,0);
		}
		public LlamadaPrintfContext llamadaPrintf() {
			return getRuleContext(LlamadaPrintfContext.class,0);
		}
		public InstruccionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instruccion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleListener ) ((SimpleListener)listener).enterInstruccion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleListener ) ((SimpleListener)listener).exitInstruccion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleVisitor ) return ((SimpleVisitor<? extends T>)visitor).visitInstruccion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstruccionContext instruccion() throws RecognitionException {
		InstruccionContext _localctx = new InstruccionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_instruccion);
		try {
			setState(84);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(59);
				declaracion();
				setState(60);
				match(PYC);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(62);
				asignacion();
				setState(63);
				match(PYC);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(65);
				bucleWhile();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(66);
				condif();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(67);
				declaracionFuncion();
				setState(68);
				match(PYC);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(70);
				definicionFuncion();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(71);
				llamadaFuncion();
				setState(72);
				match(PYC);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(74);
				retorno();
				setState(75);
				match(PYC);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(77);
				bloque();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(78);
				llamadaPrint();
				setState(79);
				match(PYC);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(81);
				llamadaPrintf();
				setState(82);
				match(PYC);
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

	public static class RetornoContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(SimpleParser.RETURN, 0); }
		public OperacionContext operacion() {
			return getRuleContext(OperacionContext.class,0);
		}
		public RetornoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_retorno; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleListener ) ((SimpleListener)listener).enterRetorno(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleListener ) ((SimpleListener)listener).exitRetorno(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleVisitor ) return ((SimpleVisitor<? extends T>)visitor).visitRetorno(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RetornoContext retorno() throws RecognitionException {
		RetornoContext _localctx = new RetornoContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_retorno);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			match(RETURN);
			setState(87);
			operacion();
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

	public static class DeclaracionContext extends ParserRuleContext {
		public TipoDatoContext tipoDato() {
			return getRuleContext(TipoDatoContext.class,0);
		}
		public TerminalNode ID() { return getToken(SimpleParser.ID, 0); }
		public TerminalNode IGUAL() { return getToken(SimpleParser.IGUAL, 0); }
		public OperacionContext operacion() {
			return getRuleContext(OperacionContext.class,0);
		}
		public DeclaracionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleListener ) ((SimpleListener)listener).enterDeclaracion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleListener ) ((SimpleListener)listener).exitDeclaracion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleVisitor ) return ((SimpleVisitor<? extends T>)visitor).visitDeclaracion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclaracionContext declaracion() throws RecognitionException {
		DeclaracionContext _localctx = new DeclaracionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_declaracion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
			tipoDato();
			setState(90);
			match(ID);
			setState(93);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IGUAL) {
				{
				setState(91);
				match(IGUAL);
				setState(92);
				operacion();
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

	public static class AsignacionContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(SimpleParser.ID, 0); }
		public TerminalNode IGUAL() { return getToken(SimpleParser.IGUAL, 0); }
		public OperacionContext operacion() {
			return getRuleContext(OperacionContext.class,0);
		}
		public AsignacionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_asignacion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleListener ) ((SimpleListener)listener).enterAsignacion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleListener ) ((SimpleListener)listener).exitAsignacion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleVisitor ) return ((SimpleVisitor<? extends T>)visitor).visitAsignacion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AsignacionContext asignacion() throws RecognitionException {
		AsignacionContext _localctx = new AsignacionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_asignacion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			match(ID);
			setState(96);
			match(IGUAL);
			setState(97);
			operacion();
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

	public static class TipoDatoContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(SimpleParser.INT, 0); }
		public TerminalNode CHAR() { return getToken(SimpleParser.CHAR, 0); }
		public TerminalNode DOUBLE() { return getToken(SimpleParser.DOUBLE, 0); }
		public TerminalNode VOID() { return getToken(SimpleParser.VOID, 0); }
		public TipoDatoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipoDato; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleListener ) ((SimpleListener)listener).enterTipoDato(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleListener ) ((SimpleListener)listener).exitTipoDato(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleVisitor ) return ((SimpleVisitor<? extends T>)visitor).visitTipoDato(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TipoDatoContext tipoDato() throws RecognitionException {
		TipoDatoContext _localctx = new TipoDatoContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_tipoDato);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << CHAR) | (1L << DOUBLE) | (1L << VOID))) != 0)) ) {
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

	public static class CondifContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(SimpleParser.IF, 0); }
		public TerminalNode PA() { return getToken(SimpleParser.PA, 0); }
		public OperacionContext operacion() {
			return getRuleContext(OperacionContext.class,0);
		}
		public TerminalNode PC() { return getToken(SimpleParser.PC, 0); }
		public List<BloqueContext> bloque() {
			return getRuleContexts(BloqueContext.class);
		}
		public BloqueContext bloque(int i) {
			return getRuleContext(BloqueContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(SimpleParser.ELSE, 0); }
		public CondifContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condif; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleListener ) ((SimpleListener)listener).enterCondif(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleListener ) ((SimpleListener)listener).exitCondif(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleVisitor ) return ((SimpleVisitor<? extends T>)visitor).visitCondif(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CondifContext condif() throws RecognitionException {
		CondifContext _localctx = new CondifContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_condif);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(101);
			match(IF);
			setState(102);
			match(PA);
			setState(103);
			operacion();
			setState(104);
			match(PC);
			setState(105);
			bloque();
			setState(108);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(106);
				match(ELSE);
				setState(107);
				bloque();
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

	public static class BucleWhileContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(SimpleParser.WHILE, 0); }
		public TerminalNode PA() { return getToken(SimpleParser.PA, 0); }
		public OperacionContext operacion() {
			return getRuleContext(OperacionContext.class,0);
		}
		public TerminalNode PC() { return getToken(SimpleParser.PC, 0); }
		public BloqueContext bloque() {
			return getRuleContext(BloqueContext.class,0);
		}
		public BucleWhileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bucleWhile; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleListener ) ((SimpleListener)listener).enterBucleWhile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleListener ) ((SimpleListener)listener).exitBucleWhile(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleVisitor ) return ((SimpleVisitor<? extends T>)visitor).visitBucleWhile(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BucleWhileContext bucleWhile() throws RecognitionException {
		BucleWhileContext _localctx = new BucleWhileContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_bucleWhile);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			match(WHILE);
			setState(111);
			match(PA);
			setState(112);
			operacion();
			setState(113);
			match(PC);
			setState(114);
			bloque();
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

	public static class DeclaracionFuncionContext extends ParserRuleContext {
		public TipoDatoContext tipoDato() {
			return getRuleContext(TipoDatoContext.class,0);
		}
		public TerminalNode ID() { return getToken(SimpleParser.ID, 0); }
		public TerminalNode PA() { return getToken(SimpleParser.PA, 0); }
		public ParametrosContext parametros() {
			return getRuleContext(ParametrosContext.class,0);
		}
		public TerminalNode PC() { return getToken(SimpleParser.PC, 0); }
		public DeclaracionFuncionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracionFuncion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleListener ) ((SimpleListener)listener).enterDeclaracionFuncion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleListener ) ((SimpleListener)listener).exitDeclaracionFuncion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleVisitor ) return ((SimpleVisitor<? extends T>)visitor).visitDeclaracionFuncion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclaracionFuncionContext declaracionFuncion() throws RecognitionException {
		DeclaracionFuncionContext _localctx = new DeclaracionFuncionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_declaracionFuncion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			tipoDato();
			setState(117);
			match(ID);
			setState(118);
			match(PA);
			setState(119);
			parametros();
			setState(120);
			match(PC);
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

	public static class DefinicionFuncionContext extends ParserRuleContext {
		public TipoDatoContext tipoDato() {
			return getRuleContext(TipoDatoContext.class,0);
		}
		public TerminalNode ID() { return getToken(SimpleParser.ID, 0); }
		public TerminalNode PA() { return getToken(SimpleParser.PA, 0); }
		public ParametrosContext parametros() {
			return getRuleContext(ParametrosContext.class,0);
		}
		public TerminalNode PC() { return getToken(SimpleParser.PC, 0); }
		public BloqueContext bloque() {
			return getRuleContext(BloqueContext.class,0);
		}
		public DefinicionFuncionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_definicionFuncion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleListener ) ((SimpleListener)listener).enterDefinicionFuncion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleListener ) ((SimpleListener)listener).exitDefinicionFuncion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleVisitor ) return ((SimpleVisitor<? extends T>)visitor).visitDefinicionFuncion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefinicionFuncionContext definicionFuncion() throws RecognitionException {
		DefinicionFuncionContext _localctx = new DefinicionFuncionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_definicionFuncion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
			tipoDato();
			setState(123);
			match(ID);
			setState(124);
			match(PA);
			setState(125);
			parametros();
			setState(126);
			match(PC);
			setState(127);
			bloque();
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

	public static class ParametrosContext extends ParserRuleContext {
		public List<TipoDatoContext> tipoDato() {
			return getRuleContexts(TipoDatoContext.class);
		}
		public TipoDatoContext tipoDato(int i) {
			return getRuleContext(TipoDatoContext.class,i);
		}
		public List<TerminalNode> ID() { return getTokens(SimpleParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(SimpleParser.ID, i);
		}
		public List<TerminalNode> COMA() { return getTokens(SimpleParser.COMA); }
		public TerminalNode COMA(int i) {
			return getToken(SimpleParser.COMA, i);
		}
		public ParametrosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parametros; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleListener ) ((SimpleListener)listener).enterParametros(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleListener ) ((SimpleListener)listener).exitParametros(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleVisitor ) return ((SimpleVisitor<? extends T>)visitor).visitParametros(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParametrosContext parametros() throws RecognitionException {
		ParametrosContext _localctx = new ParametrosContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_parametros);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << CHAR) | (1L << DOUBLE) | (1L << VOID))) != 0)) {
				{
				setState(129);
				tipoDato();
				setState(130);
				match(ID);
				setState(137);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMA) {
					{
					{
					setState(131);
					match(COMA);
					setState(132);
					tipoDato();
					setState(133);
					match(ID);
					}
					}
					setState(139);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
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

	public static class LlamadaFuncionContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(SimpleParser.ID, 0); }
		public TerminalNode PA() { return getToken(SimpleParser.PA, 0); }
		public ArgumentosContext argumentos() {
			return getRuleContext(ArgumentosContext.class,0);
		}
		public TerminalNode PC() { return getToken(SimpleParser.PC, 0); }
		public LlamadaFuncionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_llamadaFuncion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleListener ) ((SimpleListener)listener).enterLlamadaFuncion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleListener ) ((SimpleListener)listener).exitLlamadaFuncion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleVisitor ) return ((SimpleVisitor<? extends T>)visitor).visitLlamadaFuncion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LlamadaFuncionContext llamadaFuncion() throws RecognitionException {
		LlamadaFuncionContext _localctx = new LlamadaFuncionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_llamadaFuncion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
			match(ID);
			setState(143);
			match(PA);
			setState(144);
			argumentos();
			setState(145);
			match(PC);
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

	public static class LlamadaPrintContext extends ParserRuleContext {
		public TerminalNode PRINT() { return getToken(SimpleParser.PRINT, 0); }
		public TerminalNode PA() { return getToken(SimpleParser.PA, 0); }
		public OperacionContext operacion() {
			return getRuleContext(OperacionContext.class,0);
		}
		public TerminalNode PC() { return getToken(SimpleParser.PC, 0); }
		public LlamadaPrintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_llamadaPrint; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleListener ) ((SimpleListener)listener).enterLlamadaPrint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleListener ) ((SimpleListener)listener).exitLlamadaPrint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleVisitor ) return ((SimpleVisitor<? extends T>)visitor).visitLlamadaPrint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LlamadaPrintContext llamadaPrint() throws RecognitionException {
		LlamadaPrintContext _localctx = new LlamadaPrintContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_llamadaPrint);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
			match(PRINT);
			setState(148);
			match(PA);
			setState(149);
			operacion();
			setState(150);
			match(PC);
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

	public static class LlamadaPrintfContext extends ParserRuleContext {
		public TerminalNode PRINTF() { return getToken(SimpleParser.PRINTF, 0); }
		public TerminalNode PA() { return getToken(SimpleParser.PA, 0); }
		public TerminalNode STRING() { return getToken(SimpleParser.STRING, 0); }
		public TerminalNode PC() { return getToken(SimpleParser.PC, 0); }
		public List<TerminalNode> COMA() { return getTokens(SimpleParser.COMA); }
		public TerminalNode COMA(int i) {
			return getToken(SimpleParser.COMA, i);
		}
		public List<OperacionContext> operacion() {
			return getRuleContexts(OperacionContext.class);
		}
		public OperacionContext operacion(int i) {
			return getRuleContext(OperacionContext.class,i);
		}
		public LlamadaPrintfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_llamadaPrintf; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleListener ) ((SimpleListener)listener).enterLlamadaPrintf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleListener ) ((SimpleListener)listener).exitLlamadaPrintf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleVisitor ) return ((SimpleVisitor<? extends T>)visitor).visitLlamadaPrintf(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LlamadaPrintfContext llamadaPrintf() throws RecognitionException {
		LlamadaPrintfContext _localctx = new LlamadaPrintfContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_llamadaPrintf);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(152);
			match(PRINTF);
			setState(153);
			match(PA);
			setState(154);
			match(STRING);
			setState(159);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(155);
				match(COMA);
				setState(156);
				operacion();
				}
				}
				setState(161);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(162);
			match(PC);
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

	public static class ArgumentosContext extends ParserRuleContext {
		public List<OperacionContext> operacion() {
			return getRuleContexts(OperacionContext.class);
		}
		public OperacionContext operacion(int i) {
			return getRuleContext(OperacionContext.class,i);
		}
		public List<TerminalNode> COMA() { return getTokens(SimpleParser.COMA); }
		public TerminalNode COMA(int i) {
			return getToken(SimpleParser.COMA, i);
		}
		public ArgumentosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argumentos; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleListener ) ((SimpleListener)listener).enterArgumentos(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleListener ) ((SimpleListener)listener).exitArgumentos(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleVisitor ) return ((SimpleVisitor<? extends T>)visitor).visitArgumentos(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentosContext argumentos() throws RecognitionException {
		ArgumentosContext _localctx = new ArgumentosContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_argumentos);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PA) | (1L << PRINT) | (1L << PRINTF) | (1L << ID) | (1L << INTEGER) | (1L << DECIMAL) | (1L << CHARACTER))) != 0)) {
				{
				setState(164);
				operacion();
				setState(169);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMA) {
					{
					{
					setState(165);
					match(COMA);
					setState(166);
					operacion();
					}
					}
					setState(171);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
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

	public static class OperacionContext extends ParserRuleContext {
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public LlamadaFuncionContext llamadaFuncion() {
			return getRuleContext(LlamadaFuncionContext.class,0);
		}
		public OperacionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operacion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleListener ) ((SimpleListener)listener).enterOperacion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleListener ) ((SimpleListener)listener).exitOperacion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleVisitor ) return ((SimpleVisitor<? extends T>)visitor).visitOperacion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OperacionContext operacion() throws RecognitionException {
		OperacionContext _localctx = new OperacionContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_operacion);
		try {
			setState(176);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(174);
				expresion();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(175);
				llamadaFuncion();
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

	public static class ExpresionContext extends ParserRuleContext {
		public OperacionComparacionContext operacionComparacion() {
			return getRuleContext(OperacionComparacionContext.class,0);
		}
		public ExpresionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expresion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleListener ) ((SimpleListener)listener).enterExpresion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleListener ) ((SimpleListener)listener).exitExpresion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleVisitor ) return ((SimpleVisitor<? extends T>)visitor).visitExpresion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpresionContext expresion() throws RecognitionException {
		ExpresionContext _localctx = new ExpresionContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_expresion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(178);
			operacionComparacion();
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

	public static class OperacionComparacionContext extends ParserRuleContext {
		public List<OperacionLogicaContext> operacionLogica() {
			return getRuleContexts(OperacionLogicaContext.class);
		}
		public OperacionLogicaContext operacionLogica(int i) {
			return getRuleContext(OperacionLogicaContext.class,i);
		}
		public TerminalNode EQL() { return getToken(SimpleParser.EQL, 0); }
		public TerminalNode DISTINTO() { return getToken(SimpleParser.DISTINTO, 0); }
		public TerminalNode MAYOR_IGUAL() { return getToken(SimpleParser.MAYOR_IGUAL, 0); }
		public TerminalNode MENOR_IGUAL() { return getToken(SimpleParser.MENOR_IGUAL, 0); }
		public TerminalNode MAYOR() { return getToken(SimpleParser.MAYOR, 0); }
		public TerminalNode MENOR() { return getToken(SimpleParser.MENOR, 0); }
		public OperacionComparacionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operacionComparacion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleListener ) ((SimpleListener)listener).enterOperacionComparacion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleListener ) ((SimpleListener)listener).exitOperacionComparacion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleVisitor ) return ((SimpleVisitor<? extends T>)visitor).visitOperacionComparacion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OperacionComparacionContext operacionComparacion() throws RecognitionException {
		OperacionComparacionContext _localctx = new OperacionComparacionContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_operacionComparacion);
		int _la;
		try {
			setState(185);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(180);
				operacionLogica();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(181);
				operacionLogica();
				setState(182);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MAYOR) | (1L << MAYOR_IGUAL) | (1L << MENOR) | (1L << MENOR_IGUAL) | (1L << EQL) | (1L << DISTINTO))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(183);
				operacionLogica();
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

	public static class OperacionLogicaContext extends ParserRuleContext {
		public List<OperacionAritmeticaContext> operacionAritmetica() {
			return getRuleContexts(OperacionAritmeticaContext.class);
		}
		public OperacionAritmeticaContext operacionAritmetica(int i) {
			return getRuleContext(OperacionAritmeticaContext.class,i);
		}
		public TerminalNode OR() { return getToken(SimpleParser.OR, 0); }
		public TerminalNode AND() { return getToken(SimpleParser.AND, 0); }
		public OperacionLogicaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operacionLogica; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleListener ) ((SimpleListener)listener).enterOperacionLogica(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleListener ) ((SimpleListener)listener).exitOperacionLogica(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleVisitor ) return ((SimpleVisitor<? extends T>)visitor).visitOperacionLogica(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OperacionLogicaContext operacionLogica() throws RecognitionException {
		OperacionLogicaContext _localctx = new OperacionLogicaContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_operacionLogica);
		int _la;
		try {
			setState(192);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(187);
				operacionAritmetica();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(188);
				operacionAritmetica();
				setState(189);
				_la = _input.LA(1);
				if ( !(_la==OR || _la==AND) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(190);
				operacionAritmetica();
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

	public static class OperacionAritmeticaContext extends ParserRuleContext {
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public List<TerminalNode> SUM() { return getTokens(SimpleParser.SUM); }
		public TerminalNode SUM(int i) {
			return getToken(SimpleParser.SUM, i);
		}
		public List<TerminalNode> RES() { return getTokens(SimpleParser.RES); }
		public TerminalNode RES(int i) {
			return getToken(SimpleParser.RES, i);
		}
		public OperacionAritmeticaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operacionAritmetica; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleListener ) ((SimpleListener)listener).enterOperacionAritmetica(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleListener ) ((SimpleListener)listener).exitOperacionAritmetica(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleVisitor ) return ((SimpleVisitor<? extends T>)visitor).visitOperacionAritmetica(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OperacionAritmeticaContext operacionAritmetica() throws RecognitionException {
		OperacionAritmeticaContext _localctx = new OperacionAritmeticaContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_operacionAritmetica);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(194);
			term();
			setState(199);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SUM || _la==RES) {
				{
				{
				setState(195);
				_la = _input.LA(1);
				if ( !(_la==SUM || _la==RES) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(196);
				term();
				}
				}
				setState(201);
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

	public static class TermContext extends ParserRuleContext {
		public List<FactorContext> factor() {
			return getRuleContexts(FactorContext.class);
		}
		public FactorContext factor(int i) {
			return getRuleContext(FactorContext.class,i);
		}
		public List<TerminalNode> MUL() { return getTokens(SimpleParser.MUL); }
		public TerminalNode MUL(int i) {
			return getToken(SimpleParser.MUL, i);
		}
		public List<TerminalNode> DIV() { return getTokens(SimpleParser.DIV); }
		public TerminalNode DIV(int i) {
			return getToken(SimpleParser.DIV, i);
		}
		public List<TerminalNode> MOD() { return getTokens(SimpleParser.MOD); }
		public TerminalNode MOD(int i) {
			return getToken(SimpleParser.MOD, i);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleVisitor ) return ((SimpleVisitor<? extends T>)visitor).visitTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(202);
			factor();
			setState(207);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MUL) | (1L << DIV) | (1L << MOD))) != 0)) {
				{
				{
				setState(203);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MUL) | (1L << DIV) | (1L << MOD))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(204);
				factor();
				}
				}
				setState(209);
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

	public static class FactorContext extends ParserRuleContext {
		public TerminalNode PA() { return getToken(SimpleParser.PA, 0); }
		public OperacionContext operacion() {
			return getRuleContext(OperacionContext.class,0);
		}
		public TerminalNode PC() { return getToken(SimpleParser.PC, 0); }
		public LlamadaFuncionContext llamadaFuncion() {
			return getRuleContext(LlamadaFuncionContext.class,0);
		}
		public LlamadaPrintContext llamadaPrint() {
			return getRuleContext(LlamadaPrintContext.class,0);
		}
		public LlamadaPrintfContext llamadaPrintf() {
			return getRuleContext(LlamadaPrintfContext.class,0);
		}
		public TerminalNode INTEGER() { return getToken(SimpleParser.INTEGER, 0); }
		public TerminalNode DECIMAL() { return getToken(SimpleParser.DECIMAL, 0); }
		public TerminalNode CHARACTER() { return getToken(SimpleParser.CHARACTER, 0); }
		public TerminalNode ID() { return getToken(SimpleParser.ID, 0); }
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleVisitor ) return ((SimpleVisitor<? extends T>)visitor).visitFactor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_factor);
		try {
			setState(221);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(210);
				match(PA);
				setState(211);
				operacion();
				setState(212);
				match(PC);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(214);
				llamadaFuncion();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(215);
				llamadaPrint();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(216);
				llamadaPrintf();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(217);
				match(INTEGER);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(218);
				match(DECIMAL);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(219);
				match(CHARACTER);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(220);
				match(ID);
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

	public static class BloqueContext extends ParserRuleContext {
		public TerminalNode LA() { return getToken(SimpleParser.LA, 0); }
		public InstruccionesContext instrucciones() {
			return getRuleContext(InstruccionesContext.class,0);
		}
		public TerminalNode LC() { return getToken(SimpleParser.LC, 0); }
		public BloqueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bloque; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleListener ) ((SimpleListener)listener).enterBloque(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleListener ) ((SimpleListener)listener).exitBloque(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleVisitor ) return ((SimpleVisitor<? extends T>)visitor).visitBloque(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BloqueContext bloque() throws RecognitionException {
		BloqueContext _localctx = new BloqueContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_bloque);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(223);
			match(LA);
			setState(224);
			instrucciones();
			setState(225);
			match(LC);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3+\u00e6\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\3\2\3\2\5\2\65\n\2\3\2\3\2\3\3\6\3:\n\3\r\3\16\3;\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\5\4W\n\4\3\5\3\5\3\5\3\6\3\6\3\6\3\6\5\6`\n\6\3\7\3\7\3\7\3"+
		"\7\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\to\n\t\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\7\r\u008a\n\r\f\r\16\r\u008d\13\r\5\r\u008f\n\r\3\16\3"+
		"\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\7"+
		"\20\u00a0\n\20\f\20\16\20\u00a3\13\20\3\20\3\20\3\21\3\21\3\21\7\21\u00aa"+
		"\n\21\f\21\16\21\u00ad\13\21\5\21\u00af\n\21\3\22\3\22\5\22\u00b3\n\22"+
		"\3\23\3\23\3\24\3\24\3\24\3\24\3\24\5\24\u00bc\n\24\3\25\3\25\3\25\3\25"+
		"\3\25\5\25\u00c3\n\25\3\26\3\26\3\26\7\26\u00c8\n\26\f\26\16\26\u00cb"+
		"\13\26\3\27\3\27\3\27\7\27\u00d0\n\27\f\27\16\27\u00d3\13\27\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\5\30\u00e0\n\30\3\31\3\31"+
		"\3\31\3\31\3\31\2\2\32\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,"+
		".\60\2\7\3\2\36!\3\2\r\22\3\2\30\31\3\2\23\24\3\2\25\27\2\u00ec\2\64\3"+
		"\2\2\2\49\3\2\2\2\6V\3\2\2\2\bX\3\2\2\2\n[\3\2\2\2\fa\3\2\2\2\16e\3\2"+
		"\2\2\20g\3\2\2\2\22p\3\2\2\2\24v\3\2\2\2\26|\3\2\2\2\30\u008e\3\2\2\2"+
		"\32\u0090\3\2\2\2\34\u0095\3\2\2\2\36\u009a\3\2\2\2 \u00ae\3\2\2\2\"\u00b2"+
		"\3\2\2\2$\u00b4\3\2\2\2&\u00bb\3\2\2\2(\u00c2\3\2\2\2*\u00c4\3\2\2\2,"+
		"\u00cc\3\2\2\2.\u00df\3\2\2\2\60\u00e1\3\2\2\2\62\65\7\3\2\2\63\65\5\4"+
		"\3\2\64\62\3\2\2\2\64\63\3\2\2\2\65\66\3\2\2\2\66\67\7\2\2\3\67\3\3\2"+
		"\2\28:\5\6\4\298\3\2\2\2:;\3\2\2\2;9\3\2\2\2;<\3\2\2\2<\5\3\2\2\2=>\5"+
		"\n\6\2>?\7\n\2\2?W\3\2\2\2@A\5\f\7\2AB\7\n\2\2BW\3\2\2\2CW\5\22\n\2DW"+
		"\5\20\t\2EF\5\24\13\2FG\7\n\2\2GW\3\2\2\2HW\5\26\f\2IJ\5\32\16\2JK\7\n"+
		"\2\2KW\3\2\2\2LM\5\b\5\2MN\7\n\2\2NW\3\2\2\2OW\5\60\31\2PQ\5\34\17\2Q"+
		"R\7\n\2\2RW\3\2\2\2ST\5\36\20\2TU\7\n\2\2UW\3\2\2\2V=\3\2\2\2V@\3\2\2"+
		"\2VC\3\2\2\2VD\3\2\2\2VE\3\2\2\2VH\3\2\2\2VI\3\2\2\2VL\3\2\2\2VO\3\2\2"+
		"\2VP\3\2\2\2VS\3\2\2\2W\7\3\2\2\2XY\7\"\2\2YZ\5\"\22\2Z\t\3\2\2\2[\\\5"+
		"\16\b\2\\_\7%\2\2]^\7\f\2\2^`\5\"\22\2_]\3\2\2\2_`\3\2\2\2`\13\3\2\2\2"+
		"ab\7%\2\2bc\7\f\2\2cd\5\"\22\2d\r\3\2\2\2ef\t\2\2\2f\17\3\2\2\2gh\7\34"+
		"\2\2hi\7\4\2\2ij\5\"\22\2jk\7\5\2\2kn\5\60\31\2lm\7\35\2\2mo\5\60\31\2"+
		"nl\3\2\2\2no\3\2\2\2o\21\3\2\2\2pq\7\33\2\2qr\7\4\2\2rs\5\"\22\2st\7\5"+
		"\2\2tu\5\60\31\2u\23\3\2\2\2vw\5\16\b\2wx\7%\2\2xy\7\4\2\2yz\5\30\r\2"+
		"z{\7\5\2\2{\25\3\2\2\2|}\5\16\b\2}~\7%\2\2~\177\7\4\2\2\177\u0080\5\30"+
		"\r\2\u0080\u0081\7\5\2\2\u0081\u0082\5\60\31\2\u0082\27\3\2\2\2\u0083"+
		"\u0084\5\16\b\2\u0084\u008b\7%\2\2\u0085\u0086\7\13\2\2\u0086\u0087\5"+
		"\16\b\2\u0087\u0088\7%\2\2\u0088\u008a\3\2\2\2\u0089\u0085\3\2\2\2\u008a"+
		"\u008d\3\2\2\2\u008b\u0089\3\2\2\2\u008b\u008c\3\2\2\2\u008c\u008f\3\2"+
		"\2\2\u008d\u008b\3\2\2\2\u008e\u0083\3\2\2\2\u008e\u008f\3\2\2\2\u008f"+
		"\31\3\2\2\2\u0090\u0091\7%\2\2\u0091\u0092\7\4\2\2\u0092\u0093\5 \21\2"+
		"\u0093\u0094\7\5\2\2\u0094\33\3\2\2\2\u0095\u0096\7#\2\2\u0096\u0097\7"+
		"\4\2\2\u0097\u0098\5\"\22\2\u0098\u0099\7\5\2\2\u0099\35\3\2\2\2\u009a"+
		"\u009b\7$\2\2\u009b\u009c\7\4\2\2\u009c\u00a1\7)\2\2\u009d\u009e\7\13"+
		"\2\2\u009e\u00a0\5\"\22\2\u009f\u009d\3\2\2\2\u00a0\u00a3\3\2\2\2\u00a1"+
		"\u009f\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a4\3\2\2\2\u00a3\u00a1\3\2"+
		"\2\2\u00a4\u00a5\7\5\2\2\u00a5\37\3\2\2\2\u00a6\u00ab\5\"\22\2\u00a7\u00a8"+
		"\7\13\2\2\u00a8\u00aa\5\"\22\2\u00a9\u00a7\3\2\2\2\u00aa\u00ad\3\2\2\2"+
		"\u00ab\u00a9\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00af\3\2\2\2\u00ad\u00ab"+
		"\3\2\2\2\u00ae\u00a6\3\2\2\2\u00ae\u00af\3\2\2\2\u00af!\3\2\2\2\u00b0"+
		"\u00b3\5$\23\2\u00b1\u00b3\5\32\16\2\u00b2\u00b0\3\2\2\2\u00b2\u00b1\3"+
		"\2\2\2\u00b3#\3\2\2\2\u00b4\u00b5\5&\24\2\u00b5%\3\2\2\2\u00b6\u00bc\5"+
		"(\25\2\u00b7\u00b8\5(\25\2\u00b8\u00b9\t\3\2\2\u00b9\u00ba\5(\25\2\u00ba"+
		"\u00bc\3\2\2\2\u00bb\u00b6\3\2\2\2\u00bb\u00b7\3\2\2\2\u00bc\'\3\2\2\2"+
		"\u00bd\u00c3\5*\26\2\u00be\u00bf\5*\26\2\u00bf\u00c0\t\4\2\2\u00c0\u00c1"+
		"\5*\26\2\u00c1\u00c3\3\2\2\2\u00c2\u00bd\3\2\2\2\u00c2\u00be\3\2\2\2\u00c3"+
		")\3\2\2\2\u00c4\u00c9\5,\27\2\u00c5\u00c6\t\5\2\2\u00c6\u00c8\5,\27\2"+
		"\u00c7\u00c5\3\2\2\2\u00c8\u00cb\3\2\2\2\u00c9\u00c7\3\2\2\2\u00c9\u00ca"+
		"\3\2\2\2\u00ca+\3\2\2\2\u00cb\u00c9\3\2\2\2\u00cc\u00d1\5.\30\2\u00cd"+
		"\u00ce\t\6\2\2\u00ce\u00d0\5.\30\2\u00cf\u00cd\3\2\2\2\u00d0\u00d3\3\2"+
		"\2\2\u00d1\u00cf\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2-\3\2\2\2\u00d3\u00d1"+
		"\3\2\2\2\u00d4\u00d5\7\4\2\2\u00d5\u00d6\5\"\22\2\u00d6\u00d7\7\5\2\2"+
		"\u00d7\u00e0\3\2\2\2\u00d8\u00e0\5\32\16\2\u00d9\u00e0\5\34\17\2\u00da"+
		"\u00e0\5\36\20\2\u00db\u00e0\7&\2\2\u00dc\u00e0\7\'\2\2\u00dd\u00e0\7"+
		"(\2\2\u00de\u00e0\7%\2\2\u00df\u00d4\3\2\2\2\u00df\u00d8\3\2\2\2\u00df"+
		"\u00d9\3\2\2\2\u00df\u00da\3\2\2\2\u00df\u00db\3\2\2\2\u00df\u00dc\3\2"+
		"\2\2\u00df\u00dd\3\2\2\2\u00df\u00de\3\2\2\2\u00e0/\3\2\2\2\u00e1\u00e2"+
		"\7\b\2\2\u00e2\u00e3\5\4\3\2\u00e3\u00e4\7\t\2\2\u00e4\61\3\2\2\2\22\64"+
		";V_n\u008b\u008e\u00a1\u00ab\u00ae\u00b2\u00bb\u00c2\u00c9\u00d1\u00df";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}