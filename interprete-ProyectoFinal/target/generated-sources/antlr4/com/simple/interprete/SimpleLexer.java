// Generated from Simple.g4 by ANTLR 4.4
package com.simple.interprete;
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
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WS=1, PROGRAM=2, VAR=3, PRINTLN=4, IF=5, ELSE=6, PLUS=7, MINUS=8, MULT=9, 
		DIV=10, EXP=11, AND=12, OR=13, NOT=14, NEQ=15, EQ=16, GEQ=17, LEQ=18, 
		GT=19, LT=20, ASSIGN=21, BRA_OPEN=22, BRA_CLOSE=23, PAR_OPEN=24, PAR_CLOSE=25, 
		SEMICOLON=26, BOOLEAN=27, ID=28, NUMBER=29;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'", "'\\u0011'", "'\\u0012'", 
		"'\\u0013'", "'\\u0014'", "'\\u0015'", "'\\u0016'", "'\\u0017'", "'\\u0018'", 
		"'\\u0019'", "'\\u001A'", "'\\u001B'", "'\\u001C'", "'\\u001D'"
	};
	public static final String[] ruleNames = {
		"WS", "PROGRAM", "VAR", "PRINTLN", "IF", "ELSE", "PLUS", "MINUS", "MULT", 
		"DIV", "EXP", "AND", "OR", "NOT", "NEQ", "EQ", "GEQ", "LEQ", "GT", "LT", 
		"ASSIGN", "BRA_OPEN", "BRA_CLOSE", "PAR_OPEN", "PAR_CLOSE", "SEMICOLON", 
		"BOOLEAN", "ID", "NUMBER"
	};


	public SimpleLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Simple.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\37\u00a5\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\3\2\6\2?\n\2\r"+
		"\2\16\2@\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\t"+
		"\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3"+
		"\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3"+
		"\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3"+
		"\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\5\34\u0098\n\34\3\35\3\35"+
		"\7\35\u009c\n\35\f\35\16\35\u009f\13\35\3\36\6\36\u00a2\n\36\r\36\16\36"+
		"\u00a3\2\2\37\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16"+
		"\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34"+
		"\67\359\36;\37\3\2\6\5\2\13\f\17\17\"\"\5\2C\\aac|\6\2\62;C\\aac|\3\2"+
		"\62;\u00a8\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2"+
		"\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27"+
		"\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2"+
		"\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2"+
		"\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2"+
		"\2\2\2;\3\2\2\2\3>\3\2\2\2\5D\3\2\2\2\7L\3\2\2\2\tP\3\2\2\2\13X\3\2\2"+
		"\2\r[\3\2\2\2\17`\3\2\2\2\21b\3\2\2\2\23d\3\2\2\2\25f\3\2\2\2\27h\3\2"+
		"\2\2\31j\3\2\2\2\33m\3\2\2\2\35p\3\2\2\2\37r\3\2\2\2!u\3\2\2\2#x\3\2\2"+
		"\2%{\3\2\2\2\'~\3\2\2\2)\u0080\3\2\2\2+\u0082\3\2\2\2-\u0084\3\2\2\2/"+
		"\u0086\3\2\2\2\61\u0088\3\2\2\2\63\u008a\3\2\2\2\65\u008c\3\2\2\2\67\u0097"+
		"\3\2\2\29\u0099\3\2\2\2;\u00a1\3\2\2\2=?\t\2\2\2>=\3\2\2\2?@\3\2\2\2@"+
		">\3\2\2\2@A\3\2\2\2AB\3\2\2\2BC\b\2\2\2C\4\3\2\2\2DE\7r\2\2EF\7t\2\2F"+
		"G\7q\2\2GH\7i\2\2HI\7t\2\2IJ\7c\2\2JK\7o\2\2K\6\3\2\2\2LM\7x\2\2MN\7c"+
		"\2\2NO\7t\2\2O\b\3\2\2\2PQ\7r\2\2QR\7t\2\2RS\7k\2\2ST\7p\2\2TU\7v\2\2"+
		"UV\7n\2\2VW\7p\2\2W\n\3\2\2\2XY\7k\2\2YZ\7h\2\2Z\f\3\2\2\2[\\\7g\2\2\\"+
		"]\7n\2\2]^\7u\2\2^_\7g\2\2_\16\3\2\2\2`a\7-\2\2a\20\3\2\2\2bc\7/\2\2c"+
		"\22\3\2\2\2de\7,\2\2e\24\3\2\2\2fg\7\61\2\2g\26\3\2\2\2hi\7`\2\2i\30\3"+
		"\2\2\2jk\7(\2\2kl\7(\2\2l\32\3\2\2\2mn\7~\2\2no\7~\2\2o\34\3\2\2\2pq\7"+
		"#\2\2q\36\3\2\2\2rs\7#\2\2st\7?\2\2t \3\2\2\2uv\7?\2\2vw\7?\2\2w\"\3\2"+
		"\2\2xy\7@\2\2yz\7?\2\2z$\3\2\2\2{|\7>\2\2|}\7?\2\2}&\3\2\2\2~\177\7@\2"+
		"\2\177(\3\2\2\2\u0080\u0081\7>\2\2\u0081*\3\2\2\2\u0082\u0083\7?\2\2\u0083"+
		",\3\2\2\2\u0084\u0085\7}\2\2\u0085.\3\2\2\2\u0086\u0087\7\177\2\2\u0087"+
		"\60\3\2\2\2\u0088\u0089\7*\2\2\u0089\62\3\2\2\2\u008a\u008b\7+\2\2\u008b"+
		"\64\3\2\2\2\u008c\u008d\7=\2\2\u008d\66\3\2\2\2\u008e\u008f\7v\2\2\u008f"+
		"\u0090\7t\2\2\u0090\u0091\7w\2\2\u0091\u0098\7g\2\2\u0092\u0093\7h\2\2"+
		"\u0093\u0094\7c\2\2\u0094\u0095\7n\2\2\u0095\u0096\7u\2\2\u0096\u0098"+
		"\7g\2\2\u0097\u008e\3\2\2\2\u0097\u0092\3\2\2\2\u00988\3\2\2\2\u0099\u009d"+
		"\t\3\2\2\u009a\u009c\t\4\2\2\u009b\u009a\3\2\2\2\u009c\u009f\3\2\2\2\u009d"+
		"\u009b\3\2\2\2\u009d\u009e\3\2\2\2\u009e:\3\2\2\2\u009f\u009d\3\2\2\2"+
		"\u00a0\u00a2\t\5\2\2\u00a1\u00a0\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00a1"+
		"\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4<\3\2\2\2\7\2@\u0097\u009d\u00a3\3\b"+
		"\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}