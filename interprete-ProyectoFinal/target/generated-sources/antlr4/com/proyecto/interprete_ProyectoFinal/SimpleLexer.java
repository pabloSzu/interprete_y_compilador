// Generated from com\proyecto\interprete_ProyectoFinal\Simple.g4 by ANTLR 4.9.2
package com.proyecto.interprete_ProyectoFinal;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SimpleLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, ID=9, 
		NUMBER=10, BOOLEAN=11, WS=12, PLUS=13, MINUS=14, MULT=15, DIV=16, AND=17, 
		OR=18, EQ=19, NEQ=20, LT=21, GT=22, LEQ=23, GEQ=24, PAR_OPEN=25, PAR_CLOSE=26, 
		BRA_OPEN=27, BRA_CLOSE=28, SEMICOLON=29;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "ID", 
			"NUMBER", "BOOLEAN", "WS", "PLUS", "MINUS", "MULT", "DIV", "AND", "OR", 
			"EQ", "NEQ", "LT", "GT", "LEQ", "GEQ", "PAR_OPEN", "PAR_CLOSE", "BRA_OPEN", 
			"BRA_CLOSE", "SEMICOLON"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'int'", "'boolean'", "'='", "'if'", "'else'", "'while'", "','", 
			"'void'", null, null, null, null, "'+'", "'-'", "'*'", "'/'", "'&&'", 
			"'||'", "'=='", "'!='", "'<'", "'>'", "'<='", "'>='", "'('", "')'", "'{'", 
			"'}'", "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, "ID", "NUMBER", 
			"BOOLEAN", "WS", "PLUS", "MINUS", "MULT", "DIV", "AND", "OR", "EQ", "NEQ", 
			"LT", "GT", "LEQ", "GEQ", "PAR_OPEN", "PAR_CLOSE", "BRA_OPEN", "BRA_CLOSE", 
			"SEMICOLON"
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


	public SimpleLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Simple.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\37\u00a6\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\3\2\3\2\3\2\3"+
		"\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\6\3\6"+
		"\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\7\nc"+
		"\n\n\f\n\16\nf\13\n\3\13\6\13i\n\13\r\13\16\13j\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\5\fv\n\f\3\r\6\ry\n\r\r\r\16\rz\3\r\3\r\3\16\3\16\3\17"+
		"\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\24"+
		"\3\25\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\31\3\32"+
		"\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\2\2\37\3\3\5\4\7\5\t\6\13"+
		"\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'"+
		"\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37\3\2\6\5\2C\\aac|\6"+
		"\2\62;C\\aac|\3\2\62;\5\2\13\f\17\17\"\"\2\u00a9\2\3\3\2\2\2\2\5\3\2\2"+
		"\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21"+
		"\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2"+
		"\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3"+
		"\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3"+
		"\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\3=\3\2\2\2\5A\3"+
		"\2\2\2\7I\3\2\2\2\tK\3\2\2\2\13N\3\2\2\2\rS\3\2\2\2\17Y\3\2\2\2\21[\3"+
		"\2\2\2\23`\3\2\2\2\25h\3\2\2\2\27u\3\2\2\2\31x\3\2\2\2\33~\3\2\2\2\35"+
		"\u0080\3\2\2\2\37\u0082\3\2\2\2!\u0084\3\2\2\2#\u0086\3\2\2\2%\u0089\3"+
		"\2\2\2\'\u008c\3\2\2\2)\u008f\3\2\2\2+\u0092\3\2\2\2-\u0094\3\2\2\2/\u0096"+
		"\3\2\2\2\61\u0099\3\2\2\2\63\u009c\3\2\2\2\65\u009e\3\2\2\2\67\u00a0\3"+
		"\2\2\29\u00a2\3\2\2\2;\u00a4\3\2\2\2=>\7k\2\2>?\7p\2\2?@\7v\2\2@\4\3\2"+
		"\2\2AB\7d\2\2BC\7q\2\2CD\7q\2\2DE\7n\2\2EF\7g\2\2FG\7c\2\2GH\7p\2\2H\6"+
		"\3\2\2\2IJ\7?\2\2J\b\3\2\2\2KL\7k\2\2LM\7h\2\2M\n\3\2\2\2NO\7g\2\2OP\7"+
		"n\2\2PQ\7u\2\2QR\7g\2\2R\f\3\2\2\2ST\7y\2\2TU\7j\2\2UV\7k\2\2VW\7n\2\2"+
		"WX\7g\2\2X\16\3\2\2\2YZ\7.\2\2Z\20\3\2\2\2[\\\7x\2\2\\]\7q\2\2]^\7k\2"+
		"\2^_\7f\2\2_\22\3\2\2\2`d\t\2\2\2ac\t\3\2\2ba\3\2\2\2cf\3\2\2\2db\3\2"+
		"\2\2de\3\2\2\2e\24\3\2\2\2fd\3\2\2\2gi\t\4\2\2hg\3\2\2\2ij\3\2\2\2jh\3"+
		"\2\2\2jk\3\2\2\2k\26\3\2\2\2lm\7v\2\2mn\7t\2\2no\7w\2\2ov\7g\2\2pq\7h"+
		"\2\2qr\7c\2\2rs\7n\2\2st\7u\2\2tv\7g\2\2ul\3\2\2\2up\3\2\2\2v\30\3\2\2"+
		"\2wy\t\5\2\2xw\3\2\2\2yz\3\2\2\2zx\3\2\2\2z{\3\2\2\2{|\3\2\2\2|}\b\r\2"+
		"\2}\32\3\2\2\2~\177\7-\2\2\177\34\3\2\2\2\u0080\u0081\7/\2\2\u0081\36"+
		"\3\2\2\2\u0082\u0083\7,\2\2\u0083 \3\2\2\2\u0084\u0085\7\61\2\2\u0085"+
		"\"\3\2\2\2\u0086\u0087\7(\2\2\u0087\u0088\7(\2\2\u0088$\3\2\2\2\u0089"+
		"\u008a\7~\2\2\u008a\u008b\7~\2\2\u008b&\3\2\2\2\u008c\u008d\7?\2\2\u008d"+
		"\u008e\7?\2\2\u008e(\3\2\2\2\u008f\u0090\7#\2\2\u0090\u0091\7?\2\2\u0091"+
		"*\3\2\2\2\u0092\u0093\7>\2\2\u0093,\3\2\2\2\u0094\u0095\7@\2\2\u0095."+
		"\3\2\2\2\u0096\u0097\7>\2\2\u0097\u0098\7?\2\2\u0098\60\3\2\2\2\u0099"+
		"\u009a\7@\2\2\u009a\u009b\7?\2\2\u009b\62\3\2\2\2\u009c\u009d\7*\2\2\u009d"+
		"\64\3\2\2\2\u009e\u009f\7+\2\2\u009f\66\3\2\2\2\u00a0\u00a1\7}\2\2\u00a1"+
		"8\3\2\2\2\u00a2\u00a3\7\177\2\2\u00a3:\3\2\2\2\u00a4\u00a5\7=\2\2\u00a5"+
		"<\3\2\2\2\7\2djuz\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}