// Generated from c:/Users/pablo/Desktop/TC-Final/Interprete_y_compilador/interprete/src/main/antlr4/com/simple/interprete/Simple.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class SimpleLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WS=1, PROGRAM=2, VAR=3, PRINTLN=4, IF=5, ELSE=6, PLUS=7, MINUS=8, MULT=9, 
		DIV=10, EXP=11, AND=12, OR=13, NOT=14, NEQ=15, EQ=16, GEQ=17, LEQ=18, 
		GT=19, LT=20, ASSIGN=21, BRA_OPEN=22, BRA_CLOSE=23, PAR_OPEN=24, PAR_CLOSE=25, 
		SEMICOLON=26, BOOLEAN=27, ID=28, NUMBER=29;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"WS", "PROGRAM", "VAR", "PRINTLN", "IF", "ELSE", "PLUS", "MINUS", "MULT", 
			"DIV", "EXP", "AND", "OR", "NOT", "NEQ", "EQ", "GEQ", "LEQ", "GT", "LT", 
			"ASSIGN", "BRA_OPEN", "BRA_CLOSE", "PAR_OPEN", "PAR_CLOSE", "SEMICOLON", 
			"BOOLEAN", "ID", "NUMBER"
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
		"\u0004\u0000\u001d\u00a3\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017"+
		"\u0002\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a"+
		"\u0002\u001b\u0007\u001b\u0002\u001c\u0007\u001c\u0001\u0000\u0004\u0000"+
		"=\b\u0000\u000b\u0000\f\u0000>\u0001\u0000\u0001\u0000\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001"+
		"\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0012"+
		"\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0015"+
		"\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0018"+
		"\u0001\u0018\u0001\u0019\u0001\u0019\u0001\u001a\u0001\u001a\u0001\u001a"+
		"\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a"+
		"\u0003\u001a\u0096\b\u001a\u0001\u001b\u0001\u001b\u0005\u001b\u009a\b"+
		"\u001b\n\u001b\f\u001b\u009d\t\u001b\u0001\u001c\u0004\u001c\u00a0\b\u001c"+
		"\u000b\u001c\f\u001c\u00a1\u0000\u0000\u001d\u0001\u0001\u0003\u0002\u0005"+
		"\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n"+
		"\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010!\u0011"+
		"#\u0012%\u0013\'\u0014)\u0015+\u0016-\u0017/\u00181\u00193\u001a5\u001b"+
		"7\u001c9\u001d\u0001\u0000\u0004\u0003\u0000\t\n\r\r  \u0003\u0000AZ_"+
		"_az\u0004\u000009AZ__az\u0001\u000009\u00a6\u0000\u0001\u0001\u0000\u0000"+
		"\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000"+
		"\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000"+
		"\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000"+
		"\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000"+
		"\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000"+
		"\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000"+
		"\u001b\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000"+
		"\u001f\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001"+
		"\u0000\u0000\u0000\u0000%\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000"+
		"\u0000\u0000\u0000)\u0001\u0000\u0000\u0000\u0000+\u0001\u0000\u0000\u0000"+
		"\u0000-\u0001\u0000\u0000\u0000\u0000/\u0001\u0000\u0000\u0000\u00001"+
		"\u0001\u0000\u0000\u0000\u00003\u0001\u0000\u0000\u0000\u00005\u0001\u0000"+
		"\u0000\u0000\u00007\u0001\u0000\u0000\u0000\u00009\u0001\u0000\u0000\u0000"+
		"\u0001<\u0001\u0000\u0000\u0000\u0003B\u0001\u0000\u0000\u0000\u0005J"+
		"\u0001\u0000\u0000\u0000\u0007N\u0001\u0000\u0000\u0000\tV\u0001\u0000"+
		"\u0000\u0000\u000bY\u0001\u0000\u0000\u0000\r^\u0001\u0000\u0000\u0000"+
		"\u000f`\u0001\u0000\u0000\u0000\u0011b\u0001\u0000\u0000\u0000\u0013d"+
		"\u0001\u0000\u0000\u0000\u0015f\u0001\u0000\u0000\u0000\u0017h\u0001\u0000"+
		"\u0000\u0000\u0019k\u0001\u0000\u0000\u0000\u001bn\u0001\u0000\u0000\u0000"+
		"\u001dp\u0001\u0000\u0000\u0000\u001fs\u0001\u0000\u0000\u0000!v\u0001"+
		"\u0000\u0000\u0000#y\u0001\u0000\u0000\u0000%|\u0001\u0000\u0000\u0000"+
		"\'~\u0001\u0000\u0000\u0000)\u0080\u0001\u0000\u0000\u0000+\u0082\u0001"+
		"\u0000\u0000\u0000-\u0084\u0001\u0000\u0000\u0000/\u0086\u0001\u0000\u0000"+
		"\u00001\u0088\u0001\u0000\u0000\u00003\u008a\u0001\u0000\u0000\u00005"+
		"\u0095\u0001\u0000\u0000\u00007\u0097\u0001\u0000\u0000\u00009\u009f\u0001"+
		"\u0000\u0000\u0000;=\u0007\u0000\u0000\u0000<;\u0001\u0000\u0000\u0000"+
		"=>\u0001\u0000\u0000\u0000><\u0001\u0000\u0000\u0000>?\u0001\u0000\u0000"+
		"\u0000?@\u0001\u0000\u0000\u0000@A\u0006\u0000\u0000\u0000A\u0002\u0001"+
		"\u0000\u0000\u0000BC\u0005p\u0000\u0000CD\u0005r\u0000\u0000DE\u0005o"+
		"\u0000\u0000EF\u0005g\u0000\u0000FG\u0005r\u0000\u0000GH\u0005a\u0000"+
		"\u0000HI\u0005m\u0000\u0000I\u0004\u0001\u0000\u0000\u0000JK\u0005v\u0000"+
		"\u0000KL\u0005a\u0000\u0000LM\u0005r\u0000\u0000M\u0006\u0001\u0000\u0000"+
		"\u0000NO\u0005p\u0000\u0000OP\u0005r\u0000\u0000PQ\u0005i\u0000\u0000"+
		"QR\u0005n\u0000\u0000RS\u0005t\u0000\u0000ST\u0005l\u0000\u0000TU\u0005"+
		"n\u0000\u0000U\b\u0001\u0000\u0000\u0000VW\u0005i\u0000\u0000WX\u0005"+
		"f\u0000\u0000X\n\u0001\u0000\u0000\u0000YZ\u0005e\u0000\u0000Z[\u0005"+
		"l\u0000\u0000[\\\u0005s\u0000\u0000\\]\u0005e\u0000\u0000]\f\u0001\u0000"+
		"\u0000\u0000^_\u0005+\u0000\u0000_\u000e\u0001\u0000\u0000\u0000`a\u0005"+
		"-\u0000\u0000a\u0010\u0001\u0000\u0000\u0000bc\u0005*\u0000\u0000c\u0012"+
		"\u0001\u0000\u0000\u0000de\u0005/\u0000\u0000e\u0014\u0001\u0000\u0000"+
		"\u0000fg\u0005^\u0000\u0000g\u0016\u0001\u0000\u0000\u0000hi\u0005&\u0000"+
		"\u0000ij\u0005&\u0000\u0000j\u0018\u0001\u0000\u0000\u0000kl\u0005|\u0000"+
		"\u0000lm\u0005|\u0000\u0000m\u001a\u0001\u0000\u0000\u0000no\u0005!\u0000"+
		"\u0000o\u001c\u0001\u0000\u0000\u0000pq\u0005!\u0000\u0000qr\u0005=\u0000"+
		"\u0000r\u001e\u0001\u0000\u0000\u0000st\u0005=\u0000\u0000tu\u0005=\u0000"+
		"\u0000u \u0001\u0000\u0000\u0000vw\u0005>\u0000\u0000wx\u0005=\u0000\u0000"+
		"x\"\u0001\u0000\u0000\u0000yz\u0005<\u0000\u0000z{\u0005=\u0000\u0000"+
		"{$\u0001\u0000\u0000\u0000|}\u0005>\u0000\u0000}&\u0001\u0000\u0000\u0000"+
		"~\u007f\u0005<\u0000\u0000\u007f(\u0001\u0000\u0000\u0000\u0080\u0081"+
		"\u0005=\u0000\u0000\u0081*\u0001\u0000\u0000\u0000\u0082\u0083\u0005{"+
		"\u0000\u0000\u0083,\u0001\u0000\u0000\u0000\u0084\u0085\u0005}\u0000\u0000"+
		"\u0085.\u0001\u0000\u0000\u0000\u0086\u0087\u0005(\u0000\u0000\u00870"+
		"\u0001\u0000\u0000\u0000\u0088\u0089\u0005)\u0000\u0000\u00892\u0001\u0000"+
		"\u0000\u0000\u008a\u008b\u0005;\u0000\u0000\u008b4\u0001\u0000\u0000\u0000"+
		"\u008c\u008d\u0005t\u0000\u0000\u008d\u008e\u0005r\u0000\u0000\u008e\u008f"+
		"\u0005u\u0000\u0000\u008f\u0096\u0005e\u0000\u0000\u0090\u0091\u0005f"+
		"\u0000\u0000\u0091\u0092\u0005a\u0000\u0000\u0092\u0093\u0005l\u0000\u0000"+
		"\u0093\u0094\u0005s\u0000\u0000\u0094\u0096\u0005e\u0000\u0000\u0095\u008c"+
		"\u0001\u0000\u0000\u0000\u0095\u0090\u0001\u0000\u0000\u0000\u00966\u0001"+
		"\u0000\u0000\u0000\u0097\u009b\u0007\u0001\u0000\u0000\u0098\u009a\u0007"+
		"\u0002\u0000\u0000\u0099\u0098\u0001\u0000\u0000\u0000\u009a\u009d\u0001"+
		"\u0000\u0000\u0000\u009b\u0099\u0001\u0000\u0000\u0000\u009b\u009c\u0001"+
		"\u0000\u0000\u0000\u009c8\u0001\u0000\u0000\u0000\u009d\u009b\u0001\u0000"+
		"\u0000\u0000\u009e\u00a0\u0007\u0003\u0000\u0000\u009f\u009e\u0001\u0000"+
		"\u0000\u0000\u00a0\u00a1\u0001\u0000\u0000\u0000\u00a1\u009f\u0001\u0000"+
		"\u0000\u0000\u00a1\u00a2\u0001\u0000\u0000\u0000\u00a2:\u0001\u0000\u0000"+
		"\u0000\u0005\u0000>\u0095\u009b\u00a1\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}