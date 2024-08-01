// Generated from proyectoFinal\Interpretador\Simple.g4 by ANTLR 4.9.2
package proyectoFinal.Interpretador;
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
		PREPROCESSOR=1, PA=2, PC=3, CA=4, CC=5, LA=6, LC=7, PYC=8, COMA=9, IGUAL=10, 
		MAYOR=11, MAYOR_IGUAL=12, MENOR=13, MENOR_IGUAL=14, EQL=15, DISTINTO=16, 
		SUM=17, RES=18, MUL=19, DIV=20, MOD=21, OR=22, AND=23, NOT=24, WHILE=25, 
		IF=26, ELSE=27, INT=28, CHAR=29, DOUBLE=30, VOID=31, RETURN=32, PRINT=33, 
		PRINTF=34, ID=35, INTEGER=36, DECIMAL=37, CHARACTER=38, STRING=39, WS=40, 
		OTRO=41;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"PREPROCESSOR", "PA", "PC", "CA", "CC", "LA", "LC", "PYC", "COMA", "IGUAL", 
			"MAYOR", "MAYOR_IGUAL", "MENOR", "MENOR_IGUAL", "EQL", "DISTINTO", "SUM", 
			"RES", "MUL", "DIV", "MOD", "OR", "AND", "NOT", "WHILE", "IF", "ELSE", 
			"INT", "CHAR", "DOUBLE", "VOID", "RETURN", "PRINT", "PRINTF", "ID", "INTEGER", 
			"DECIMAL", "CHARACTER", "STRING", "WS", "OTRO"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2+\u00f3\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3"+
		"\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3"+
		"\16\3\16\3\17\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\23\3"+
		"\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3\30\3\31\3"+
		"\31\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3"+
		"\34\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3"+
		"\37\3\37\3\37\3 \3 \3 \3 \3 \3!\3!\3!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\""+
		"\3\"\3#\3#\3#\3#\3#\3#\3#\3$\3$\7$\u00d0\n$\f$\16$\u00d3\13$\3%\6%\u00d6"+
		"\n%\r%\16%\u00d7\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3(\3(\7(\u00e4\n(\f(\16("+
		"\u00e7\13(\3(\3(\3)\6)\u00ec\n)\r)\16)\u00ed\3)\3)\3*\3*\3\u00e5\2+\3"+
		"\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37"+
		"\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37="+
		" ?!A\"C#E$G%I&K\'M(O)Q*S+\3\2\7\5\2C\\aac|\6\2\62;C\\aac|\3\2\62;\5\2"+
		"\62;C\\c|\5\2\13\f\17\17\"\"\2\u00f6\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2"+
		"\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23"+
		"\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2"+
		"\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2"+
		"\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3"+
		"\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2"+
		"\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2"+
		"\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\3U\3\2\2\2\5b\3\2\2\2\7d\3\2\2\2\tf"+
		"\3\2\2\2\13h\3\2\2\2\rj\3\2\2\2\17l\3\2\2\2\21n\3\2\2\2\23p\3\2\2\2\25"+
		"r\3\2\2\2\27t\3\2\2\2\31v\3\2\2\2\33y\3\2\2\2\35{\3\2\2\2\37~\3\2\2\2"+
		"!\u0081\3\2\2\2#\u0084\3\2\2\2%\u0086\3\2\2\2\'\u0088\3\2\2\2)\u008a\3"+
		"\2\2\2+\u008c\3\2\2\2-\u008e\3\2\2\2/\u0091\3\2\2\2\61\u0094\3\2\2\2\63"+
		"\u0096\3\2\2\2\65\u009c\3\2\2\2\67\u009f\3\2\2\29\u00a4\3\2\2\2;\u00a8"+
		"\3\2\2\2=\u00ad\3\2\2\2?\u00b4\3\2\2\2A\u00b9\3\2\2\2C\u00c0\3\2\2\2E"+
		"\u00c6\3\2\2\2G\u00cd\3\2\2\2I\u00d5\3\2\2\2K\u00d9\3\2\2\2M\u00dd\3\2"+
		"\2\2O\u00e1\3\2\2\2Q\u00eb\3\2\2\2S\u00f1\3\2\2\2UV\7%\2\2VW\7k\2\2WX"+
		"\7p\2\2XY\7e\2\2YZ\7n\2\2Z[\7w\2\2[\\\7f\2\2\\]\7g\2\2]^\3\2\2\2^_\7>"+
		"\2\2_`\5G$\2`a\7@\2\2a\4\3\2\2\2bc\7*\2\2c\6\3\2\2\2de\7+\2\2e\b\3\2\2"+
		"\2fg\7]\2\2g\n\3\2\2\2hi\7_\2\2i\f\3\2\2\2jk\7}\2\2k\16\3\2\2\2lm\7\177"+
		"\2\2m\20\3\2\2\2no\7=\2\2o\22\3\2\2\2pq\7.\2\2q\24\3\2\2\2rs\7?\2\2s\26"+
		"\3\2\2\2tu\7@\2\2u\30\3\2\2\2vw\7@\2\2wx\7?\2\2x\32\3\2\2\2yz\7>\2\2z"+
		"\34\3\2\2\2{|\7>\2\2|}\7?\2\2}\36\3\2\2\2~\177\7?\2\2\177\u0080\7?\2\2"+
		"\u0080 \3\2\2\2\u0081\u0082\7#\2\2\u0082\u0083\7?\2\2\u0083\"\3\2\2\2"+
		"\u0084\u0085\7-\2\2\u0085$\3\2\2\2\u0086\u0087\7/\2\2\u0087&\3\2\2\2\u0088"+
		"\u0089\7,\2\2\u0089(\3\2\2\2\u008a\u008b\7\61\2\2\u008b*\3\2\2\2\u008c"+
		"\u008d\7\'\2\2\u008d,\3\2\2\2\u008e\u008f\7~\2\2\u008f\u0090\7~\2\2\u0090"+
		".\3\2\2\2\u0091\u0092\7(\2\2\u0092\u0093\7(\2\2\u0093\60\3\2\2\2\u0094"+
		"\u0095\7#\2\2\u0095\62\3\2\2\2\u0096\u0097\7y\2\2\u0097\u0098\7j\2\2\u0098"+
		"\u0099\7k\2\2\u0099\u009a\7n\2\2\u009a\u009b\7g\2\2\u009b\64\3\2\2\2\u009c"+
		"\u009d\7k\2\2\u009d\u009e\7h\2\2\u009e\66\3\2\2\2\u009f\u00a0\7g\2\2\u00a0"+
		"\u00a1\7n\2\2\u00a1\u00a2\7u\2\2\u00a2\u00a3\7g\2\2\u00a38\3\2\2\2\u00a4"+
		"\u00a5\7k\2\2\u00a5\u00a6\7p\2\2\u00a6\u00a7\7v\2\2\u00a7:\3\2\2\2\u00a8"+
		"\u00a9\7e\2\2\u00a9\u00aa\7j\2\2\u00aa\u00ab\7c\2\2\u00ab\u00ac\7t\2\2"+
		"\u00ac<\3\2\2\2\u00ad\u00ae\7f\2\2\u00ae\u00af\7q\2\2\u00af\u00b0\7w\2"+
		"\2\u00b0\u00b1\7d\2\2\u00b1\u00b2\7n\2\2\u00b2\u00b3\7g\2\2\u00b3>\3\2"+
		"\2\2\u00b4\u00b5\7x\2\2\u00b5\u00b6\7q\2\2\u00b6\u00b7\7k\2\2\u00b7\u00b8"+
		"\7f\2\2\u00b8@\3\2\2\2\u00b9\u00ba\7t\2\2\u00ba\u00bb\7g\2\2\u00bb\u00bc"+
		"\7v\2\2\u00bc\u00bd\7w\2\2\u00bd\u00be\7t\2\2\u00be\u00bf\7p\2\2\u00bf"+
		"B\3\2\2\2\u00c0\u00c1\7r\2\2\u00c1\u00c2\7t\2\2\u00c2\u00c3\7k\2\2\u00c3"+
		"\u00c4\7p\2\2\u00c4\u00c5\7v\2\2\u00c5D\3\2\2\2\u00c6\u00c7\7r\2\2\u00c7"+
		"\u00c8\7t\2\2\u00c8\u00c9\7k\2\2\u00c9\u00ca\7p\2\2\u00ca\u00cb\7v\2\2"+
		"\u00cb\u00cc\7h\2\2\u00ccF\3\2\2\2\u00cd\u00d1\t\2\2\2\u00ce\u00d0\t\3"+
		"\2\2\u00cf\u00ce\3\2\2\2\u00d0\u00d3\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d1"+
		"\u00d2\3\2\2\2\u00d2H\3\2\2\2\u00d3\u00d1\3\2\2\2\u00d4\u00d6\t\4\2\2"+
		"\u00d5\u00d4\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7\u00d5\3\2\2\2\u00d7\u00d8"+
		"\3\2\2\2\u00d8J\3\2\2\2\u00d9\u00da\5I%\2\u00da\u00db\7\60\2\2\u00db\u00dc"+
		"\5I%\2\u00dcL\3\2\2\2\u00dd\u00de\7)\2\2\u00de\u00df\t\5\2\2\u00df\u00e0"+
		"\7)\2\2\u00e0N\3\2\2\2\u00e1\u00e5\7$\2\2\u00e2\u00e4\13\2\2\2\u00e3\u00e2"+
		"\3\2\2\2\u00e4\u00e7\3\2\2\2\u00e5\u00e6\3\2\2\2\u00e5\u00e3\3\2\2\2\u00e6"+
		"\u00e8\3\2\2\2\u00e7\u00e5\3\2\2\2\u00e8\u00e9\7$\2\2\u00e9P\3\2\2\2\u00ea"+
		"\u00ec\t\6\2\2\u00eb\u00ea\3\2\2\2\u00ec\u00ed\3\2\2\2\u00ed\u00eb\3\2"+
		"\2\2\u00ed\u00ee\3\2\2\2\u00ee\u00ef\3\2\2\2\u00ef\u00f0\b)\2\2\u00f0"+
		"R\3\2\2\2\u00f1\u00f2\13\2\2\2\u00f2T\3\2\2\2\7\2\u00d1\u00d7\u00e5\u00ed"+
		"\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}