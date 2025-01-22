// $ANTLR 3.4

	package baserequirements.resource.baseRequirements.mopp;


import org.antlr.runtime3_4_0.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class BaseRequirementsLexer extends Lexer {
    public static final int EOF=-1;
    public static final int T__9=9;
    public static final int T__10=10;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__19=19;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__50=50;
    public static final int T__51=51;
    public static final int COMMENT=4;
    public static final int LINEBREAK=5;
    public static final int QUOTED_34_34=6;
    public static final int TEXT=7;
    public static final int WHITESPACE=8;

    	public java.util.List<org.antlr.runtime3_4_0.RecognitionException> lexerExceptions  = new java.util.ArrayList<org.antlr.runtime3_4_0.RecognitionException>();
    	public java.util.List<Integer> lexerExceptionsPosition = new java.util.ArrayList<Integer>();
    	
    	public void reportError(org.antlr.runtime3_4_0.RecognitionException e) {
    		lexerExceptions.add(e);
    		lexerExceptionsPosition.add(((org.antlr.runtime3_4_0.ANTLRStringStream) input).index());
    	}


    // delegates
    // delegators
    public Lexer[] getDelegates() {
        return new Lexer[] {};
    }

    public BaseRequirementsLexer() {} 
    public BaseRequirementsLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public BaseRequirementsLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "BaseRequirements.g"; }

    // $ANTLR start "T__9"
    public final void mT__9() throws RecognitionException {
        try {
            int _type = T__9;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // BaseRequirements.g:15:6: ( ':' )
            // BaseRequirements.g:15:8: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__9"

    // $ANTLR start "T__10"
    public final void mT__10() throws RecognitionException {
        try {
            int _type = T__10;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // BaseRequirements.g:16:7: ( 'ACCEPTED' )
            // BaseRequirements.g:16:9: 'ACCEPTED'
            {
            match("ACCEPTED"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__10"

    // $ANTLR start "T__11"
    public final void mT__11() throws RecognitionException {
        try {
            int _type = T__11;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // BaseRequirements.g:17:7: ( 'APPROVED' )
            // BaseRequirements.g:17:9: 'APPROVED'
            {
            match("APPROVED"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__11"

    // $ANTLR start "T__12"
    public final void mT__12() throws RecognitionException {
        try {
            int _type = T__12;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // BaseRequirements.g:18:7: ( 'Comment' )
            // BaseRequirements.g:18:9: 'Comment'
            {
            match("Comment"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__12"

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // BaseRequirements.g:19:7: ( 'FUNCTIONAL' )
            // BaseRequirements.g:19:9: 'FUNCTIONAL'
            {
            match("FUNCTIONAL"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__13"

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // BaseRequirements.g:20:7: ( 'HIGH' )
            // BaseRequirements.g:20:9: 'HIGH'
            {
            match("HIGH"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__14"

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // BaseRequirements.g:21:7: ( 'IMPLEMENTED' )
            // BaseRequirements.g:21:9: 'IMPLEMENTED'
            {
            match("IMPLEMENTED"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // BaseRequirements.g:22:7: ( 'INVALID' )
            // BaseRequirements.g:22:9: 'INVALID'
            {
            match("INVALID"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // BaseRequirements.g:23:7: ( 'LATER' )
            // BaseRequirements.g:23:9: 'LATER'
            {
            match("LATER"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // BaseRequirements.g:24:7: ( 'LOW' )
            // BaseRequirements.g:24:9: 'LOW'
            {
            match("LOW"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // BaseRequirements.g:25:7: ( 'MEDIUM' )
            // BaseRequirements.g:25:9: 'MEDIUM'
            {
            match("MEDIUM"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // BaseRequirements.g:26:7: ( 'Model' )
            // BaseRequirements.g:26:9: 'Model'
            {
            match("Model"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // BaseRequirements.g:27:7: ( 'NEW' )
            // BaseRequirements.g:27:9: 'NEW'
            {
            match("NEW"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // BaseRequirements.g:28:7: ( 'NONFUNCTIONAL' )
            // BaseRequirements.g:28:9: 'NONFUNCTIONAL'
            {
            match("NONFUNCTIONAL"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // BaseRequirements.g:29:7: ( 'RESOLVED' )
            // BaseRequirements.g:29:9: 'RESOLVED'
            {
            match("RESOLVED"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // BaseRequirements.g:30:7: ( 'REVIEWED' )
            // BaseRequirements.g:30:9: 'REVIEWED'
            {
            match("REVIEWED"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // BaseRequirements.g:31:7: ( 'Requirement' )
            // BaseRequirements.g:31:9: 'Requirement'
            {
            match("Requirement"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // BaseRequirements.g:32:7: ( 'RequirementGroup' )
            // BaseRequirements.g:32:9: 'RequirementGroup'
            {
            match("RequirementGroup"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // BaseRequirements.g:33:7: ( 'Version' )
            // BaseRequirements.g:33:9: 'Version'
            {
            match("Version"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // BaseRequirements.g:34:7: ( 'author' )
            // BaseRequirements.g:34:9: 'author'
            {
            match("author"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // BaseRequirements.g:35:7: ( 'body' )
            // BaseRequirements.g:35:9: 'body'
            {
            match("body"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // BaseRequirements.g:36:7: ( 'children' )
            // BaseRequirements.g:36:9: 'children'
            {
            match("children"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__30"

    // $ANTLR start "T__31"
    public final void mT__31() throws RecognitionException {
        try {
            int _type = T__31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // BaseRequirements.g:37:7: ( 'comments' )
            // BaseRequirements.g:37:9: 'comments'
            {
            match("comments"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__31"

    // $ANTLR start "T__32"
    public final void mT__32() throws RecognitionException {
        try {
            int _type = T__32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // BaseRequirements.g:38:7: ( 'created' )
            // BaseRequirements.g:38:9: 'created'
            {
            match("created"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__32"

    // $ANTLR start "T__33"
    public final void mT__33() throws RecognitionException {
        try {
            int _type = T__33;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // BaseRequirements.g:39:7: ( 'dependencies' )
            // BaseRequirements.g:39:9: 'dependencies'
            {
            match("dependencies"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__33"

    // $ANTLR start "T__34"
    public final void mT__34() throws RecognitionException {
        try {
            int _type = T__34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // BaseRequirements.g:40:7: ( 'description' )
            // BaseRequirements.g:40:9: 'description'
            {
            match("description"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__34"

    // $ANTLR start "T__35"
    public final void mT__35() throws RecognitionException {
        try {
            int _type = T__35;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // BaseRequirements.g:41:7: ( 'groups' )
            // BaseRequirements.g:41:9: 'groups'
            {
            match("groups"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__35"

    // $ANTLR start "T__36"
    public final void mT__36() throws RecognitionException {
        try {
            int _type = T__36;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // BaseRequirements.g:42:7: ( 'id' )
            // BaseRequirements.g:42:9: 'id'
            {
            match("id"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__36"

    // $ANTLR start "T__37"
    public final void mT__37() throws RecognitionException {
        try {
            int _type = T__37;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // BaseRequirements.g:43:7: ( 'major' )
            // BaseRequirements.g:43:9: 'major'
            {
            match("major"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__37"

    // $ANTLR start "T__38"
    public final void mT__38() throws RecognitionException {
        try {
            int _type = T__38;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // BaseRequirements.g:44:7: ( 'minor' )
            // BaseRequirements.g:44:9: 'minor'
            {
            match("minor"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__38"

    // $ANTLR start "T__39"
    public final void mT__39() throws RecognitionException {
        try {
            int _type = T__39;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // BaseRequirements.g:45:7: ( 'name' )
            // BaseRequirements.g:45:9: 'name'
            {
            match("name"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__39"

    // $ANTLR start "T__40"
    public final void mT__40() throws RecognitionException {
        try {
            int _type = T__40;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // BaseRequirements.g:46:7: ( 'parent' )
            // BaseRequirements.g:46:9: 'parent'
            {
            match("parent"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__40"

    // $ANTLR start "T__41"
    public final void mT__41() throws RecognitionException {
        try {
            int _type = T__41;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // BaseRequirements.g:47:7: ( 'priority' )
            // BaseRequirements.g:47:9: 'priority'
            {
            match("priority"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__41"

    // $ANTLR start "T__42"
    public final void mT__42() throws RecognitionException {
        try {
            int _type = T__42;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // BaseRequirements.g:48:7: ( 'requirements' )
            // BaseRequirements.g:48:9: 'requirements'
            {
            match("requirements"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__42"

    // $ANTLR start "T__43"
    public final void mT__43() throws RecognitionException {
        try {
            int _type = T__43;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // BaseRequirements.g:49:7: ( 'resolution' )
            // BaseRequirements.g:49:9: 'resolution'
            {
            match("resolution"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__43"

    // $ANTLR start "T__44"
    public final void mT__44() throws RecognitionException {
        try {
            int _type = T__44;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // BaseRequirements.g:50:7: ( 'service' )
            // BaseRequirements.g:50:9: 'service'
            {
            match("service"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__44"

    // $ANTLR start "T__45"
    public final void mT__45() throws RecognitionException {
        try {
            int _type = T__45;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // BaseRequirements.g:51:7: ( 'state' )
            // BaseRequirements.g:51:9: 'state'
            {
            match("state"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__45"

    // $ANTLR start "T__46"
    public final void mT__46() throws RecognitionException {
        try {
            int _type = T__46;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // BaseRequirements.g:52:7: ( 'subject' )
            // BaseRequirements.g:52:9: 'subject'
            {
            match("subject"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__46"

    // $ANTLR start "T__47"
    public final void mT__47() throws RecognitionException {
        try {
            int _type = T__47;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // BaseRequirements.g:53:7: ( 'title' )
            // BaseRequirements.g:53:9: 'title'
            {
            match("title"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__47"

    // $ANTLR start "T__48"
    public final void mT__48() throws RecognitionException {
        try {
            int _type = T__48;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // BaseRequirements.g:54:7: ( 'type' )
            // BaseRequirements.g:54:9: 'type'
            {
            match("type"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__48"

    // $ANTLR start "T__49"
    public final void mT__49() throws RecognitionException {
        try {
            int _type = T__49;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // BaseRequirements.g:55:7: ( 'version' )
            // BaseRequirements.g:55:9: 'version'
            {
            match("version"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__49"

    // $ANTLR start "T__50"
    public final void mT__50() throws RecognitionException {
        try {
            int _type = T__50;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // BaseRequirements.g:56:7: ( '{' )
            // BaseRequirements.g:56:9: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__50"

    // $ANTLR start "T__51"
    public final void mT__51() throws RecognitionException {
        try {
            int _type = T__51;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // BaseRequirements.g:57:7: ( '}' )
            // BaseRequirements.g:57:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__51"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // BaseRequirements.g:3198:8: ( ( '//' (~ ( '\\n' | '\\r' | '\\uffff' ) )* ) )
            // BaseRequirements.g:3199:2: ( '//' (~ ( '\\n' | '\\r' | '\\uffff' ) )* )
            {
            // BaseRequirements.g:3199:2: ( '//' (~ ( '\\n' | '\\r' | '\\uffff' ) )* )
            // BaseRequirements.g:3199:3: '//' (~ ( '\\n' | '\\r' | '\\uffff' ) )*
            {
            match("//"); 



            // BaseRequirements.g:3199:7: (~ ( '\\n' | '\\r' | '\\uffff' ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0 >= '\u0000' && LA1_0 <= '\t')||(LA1_0 >= '\u000B' && LA1_0 <= '\f')||(LA1_0 >= '\u000E' && LA1_0 <= '\uFFFE')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // BaseRequirements.g:
            	    {
            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '\uFFFE') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }


             _channel = 99; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "COMMENT"

    // $ANTLR start "TEXT"
    public final void mTEXT() throws RecognitionException {
        try {
            int _type = TEXT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // BaseRequirements.g:3202:5: ( ( ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+ ) )
            // BaseRequirements.g:3203:2: ( ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+ )
            {
            // BaseRequirements.g:3203:2: ( ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+ )
            // BaseRequirements.g:3203:3: ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+
            {
            // BaseRequirements.g:3203:3: ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0=='-'||(LA2_0 >= '0' && LA2_0 <= '9')||(LA2_0 >= 'A' && LA2_0 <= 'Z')||LA2_0=='_'||(LA2_0 >= 'a' && LA2_0 <= 'z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // BaseRequirements.g:
            	    {
            	    if ( input.LA(1)=='-'||(input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);


            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "TEXT"

    // $ANTLR start "WHITESPACE"
    public final void mWHITESPACE() throws RecognitionException {
        try {
            int _type = WHITESPACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // BaseRequirements.g:3205:11: ( ( ( ' ' | '\\t' | '\\f' ) ) )
            // BaseRequirements.g:3206:2: ( ( ' ' | '\\t' | '\\f' ) )
            {
            if ( input.LA(1)=='\t'||input.LA(1)=='\f'||input.LA(1)==' ' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


             _channel = 99; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "WHITESPACE"

    // $ANTLR start "LINEBREAK"
    public final void mLINEBREAK() throws RecognitionException {
        try {
            int _type = LINEBREAK;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // BaseRequirements.g:3209:10: ( ( ( '\\r\\n' | '\\r' | '\\n' ) ) )
            // BaseRequirements.g:3210:2: ( ( '\\r\\n' | '\\r' | '\\n' ) )
            {
            // BaseRequirements.g:3210:2: ( ( '\\r\\n' | '\\r' | '\\n' ) )
            // BaseRequirements.g:3210:3: ( '\\r\\n' | '\\r' | '\\n' )
            {
            // BaseRequirements.g:3210:3: ( '\\r\\n' | '\\r' | '\\n' )
            int alt3=3;
            int LA3_0 = input.LA(1);

            if ( (LA3_0=='\r') ) {
                int LA3_1 = input.LA(2);

                if ( (LA3_1=='\n') ) {
                    alt3=1;
                }
                else {
                    alt3=2;
                }
            }
            else if ( (LA3_0=='\n') ) {
                alt3=3;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;

            }
            switch (alt3) {
                case 1 :
                    // BaseRequirements.g:3210:4: '\\r\\n'
                    {
                    match("\r\n"); 



                    }
                    break;
                case 2 :
                    // BaseRequirements.g:3210:13: '\\r'
                    {
                    match('\r'); 

                    }
                    break;
                case 3 :
                    // BaseRequirements.g:3210:20: '\\n'
                    {
                    match('\n'); 

                    }
                    break;

            }


            }


             _channel = 99; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LINEBREAK"

    // $ANTLR start "QUOTED_34_34"
    public final void mQUOTED_34_34() throws RecognitionException {
        try {
            int _type = QUOTED_34_34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // BaseRequirements.g:3213:13: ( ( ( '\"' ) (~ ( '\"' ) )* ( '\"' ) ) )
            // BaseRequirements.g:3214:2: ( ( '\"' ) (~ ( '\"' ) )* ( '\"' ) )
            {
            // BaseRequirements.g:3214:2: ( ( '\"' ) (~ ( '\"' ) )* ( '\"' ) )
            // BaseRequirements.g:3214:3: ( '\"' ) (~ ( '\"' ) )* ( '\"' )
            {
            // BaseRequirements.g:3214:3: ( '\"' )
            // BaseRequirements.g:3214:4: '\"'
            {
            match('\"'); 

            }


            // BaseRequirements.g:3214:8: (~ ( '\"' ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0 >= '\u0000' && LA4_0 <= '!')||(LA4_0 >= '#' && LA4_0 <= '\uFFFF')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // BaseRequirements.g:
            	    {
            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '!')||(input.LA(1) >= '#' && input.LA(1) <= '\uFFFF') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            // BaseRequirements.g:3214:17: ( '\"' )
            // BaseRequirements.g:3214:18: '\"'
            {
            match('\"'); 

            }


            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "QUOTED_34_34"

    public void mTokens() throws RecognitionException {
        // BaseRequirements.g:1:8: ( T__9 | T__10 | T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | COMMENT | TEXT | WHITESPACE | LINEBREAK | QUOTED_34_34 )
        int alt5=48;
        alt5 = dfa5.predict(input);
        switch (alt5) {
            case 1 :
                // BaseRequirements.g:1:10: T__9
                {
                mT__9(); 


                }
                break;
            case 2 :
                // BaseRequirements.g:1:15: T__10
                {
                mT__10(); 


                }
                break;
            case 3 :
                // BaseRequirements.g:1:21: T__11
                {
                mT__11(); 


                }
                break;
            case 4 :
                // BaseRequirements.g:1:27: T__12
                {
                mT__12(); 


                }
                break;
            case 5 :
                // BaseRequirements.g:1:33: T__13
                {
                mT__13(); 


                }
                break;
            case 6 :
                // BaseRequirements.g:1:39: T__14
                {
                mT__14(); 


                }
                break;
            case 7 :
                // BaseRequirements.g:1:45: T__15
                {
                mT__15(); 


                }
                break;
            case 8 :
                // BaseRequirements.g:1:51: T__16
                {
                mT__16(); 


                }
                break;
            case 9 :
                // BaseRequirements.g:1:57: T__17
                {
                mT__17(); 


                }
                break;
            case 10 :
                // BaseRequirements.g:1:63: T__18
                {
                mT__18(); 


                }
                break;
            case 11 :
                // BaseRequirements.g:1:69: T__19
                {
                mT__19(); 


                }
                break;
            case 12 :
                // BaseRequirements.g:1:75: T__20
                {
                mT__20(); 


                }
                break;
            case 13 :
                // BaseRequirements.g:1:81: T__21
                {
                mT__21(); 


                }
                break;
            case 14 :
                // BaseRequirements.g:1:87: T__22
                {
                mT__22(); 


                }
                break;
            case 15 :
                // BaseRequirements.g:1:93: T__23
                {
                mT__23(); 


                }
                break;
            case 16 :
                // BaseRequirements.g:1:99: T__24
                {
                mT__24(); 


                }
                break;
            case 17 :
                // BaseRequirements.g:1:105: T__25
                {
                mT__25(); 


                }
                break;
            case 18 :
                // BaseRequirements.g:1:111: T__26
                {
                mT__26(); 


                }
                break;
            case 19 :
                // BaseRequirements.g:1:117: T__27
                {
                mT__27(); 


                }
                break;
            case 20 :
                // BaseRequirements.g:1:123: T__28
                {
                mT__28(); 


                }
                break;
            case 21 :
                // BaseRequirements.g:1:129: T__29
                {
                mT__29(); 


                }
                break;
            case 22 :
                // BaseRequirements.g:1:135: T__30
                {
                mT__30(); 


                }
                break;
            case 23 :
                // BaseRequirements.g:1:141: T__31
                {
                mT__31(); 


                }
                break;
            case 24 :
                // BaseRequirements.g:1:147: T__32
                {
                mT__32(); 


                }
                break;
            case 25 :
                // BaseRequirements.g:1:153: T__33
                {
                mT__33(); 


                }
                break;
            case 26 :
                // BaseRequirements.g:1:159: T__34
                {
                mT__34(); 


                }
                break;
            case 27 :
                // BaseRequirements.g:1:165: T__35
                {
                mT__35(); 


                }
                break;
            case 28 :
                // BaseRequirements.g:1:171: T__36
                {
                mT__36(); 


                }
                break;
            case 29 :
                // BaseRequirements.g:1:177: T__37
                {
                mT__37(); 


                }
                break;
            case 30 :
                // BaseRequirements.g:1:183: T__38
                {
                mT__38(); 


                }
                break;
            case 31 :
                // BaseRequirements.g:1:189: T__39
                {
                mT__39(); 


                }
                break;
            case 32 :
                // BaseRequirements.g:1:195: T__40
                {
                mT__40(); 


                }
                break;
            case 33 :
                // BaseRequirements.g:1:201: T__41
                {
                mT__41(); 


                }
                break;
            case 34 :
                // BaseRequirements.g:1:207: T__42
                {
                mT__42(); 


                }
                break;
            case 35 :
                // BaseRequirements.g:1:213: T__43
                {
                mT__43(); 


                }
                break;
            case 36 :
                // BaseRequirements.g:1:219: T__44
                {
                mT__44(); 


                }
                break;
            case 37 :
                // BaseRequirements.g:1:225: T__45
                {
                mT__45(); 


                }
                break;
            case 38 :
                // BaseRequirements.g:1:231: T__46
                {
                mT__46(); 


                }
                break;
            case 39 :
                // BaseRequirements.g:1:237: T__47
                {
                mT__47(); 


                }
                break;
            case 40 :
                // BaseRequirements.g:1:243: T__48
                {
                mT__48(); 


                }
                break;
            case 41 :
                // BaseRequirements.g:1:249: T__49
                {
                mT__49(); 


                }
                break;
            case 42 :
                // BaseRequirements.g:1:255: T__50
                {
                mT__50(); 


                }
                break;
            case 43 :
                // BaseRequirements.g:1:261: T__51
                {
                mT__51(); 


                }
                break;
            case 44 :
                // BaseRequirements.g:1:267: COMMENT
                {
                mCOMMENT(); 


                }
                break;
            case 45 :
                // BaseRequirements.g:1:275: TEXT
                {
                mTEXT(); 


                }
                break;
            case 46 :
                // BaseRequirements.g:1:280: WHITESPACE
                {
                mWHITESPACE(); 


                }
                break;
            case 47 :
                // BaseRequirements.g:1:291: LINEBREAK
                {
                mLINEBREAK(); 


                }
                break;
            case 48 :
                // BaseRequirements.g:1:301: QUOTED_34_34
                {
                mQUOTED_34_34(); 


                }
                break;

        }

    }


    protected DFA5 dfa5 = new DFA5(this);
    static final String DFA5_eotS =
        "\2\uffff\27\34\7\uffff\27\34\1\135\24\34\1\163\2\34\1\166\15\34"+
        "\1\uffff\21\34\1\u0095\3\34\1\uffff\2\34\1\uffff\6\34\1\u00a1\10"+
        "\34\1\u00aa\10\34\1\u00b3\5\34\1\uffff\2\34\1\u00bb\1\34\1\u00bd"+
        "\6\34\1\uffff\6\34\1\u00ca\1\u00cb\1\uffff\5\34\1\u00d1\1\34\1\u00d3"+
        "\1\uffff\7\34\1\uffff\1\u00db\1\uffff\5\34\1\u00e1\5\34\1\u00e7"+
        "\2\uffff\1\u00e8\4\34\1\uffff\1\34\1\uffff\3\34\1\u00f1\2\34\1\u00f4"+
        "\1\uffff\4\34\1\u00f9\1\uffff\2\34\1\u00fc\2\34\2\uffff\3\34\1\u0102"+
        "\1\u0103\1\u0104\1\u0105\1\u0106\1\uffff\2\34\1\uffff\1\34\1\u010a"+
        "\1\u010b\1\34\1\uffff\1\u010d\1\u010e\1\uffff\2\34\1\u0111\2\34"+
        "\5\uffff\3\34\2\uffff\1\34\2\uffff\2\34\1\uffff\2\34\1\u011c\6\34"+
        "\1\u0123\1\uffff\1\u0124\1\34\1\u0127\1\34\1\u0129\1\34\2\uffff"+
        "\2\34\1\uffff\1\u012d\1\uffff\1\u012e\1\u012f\1\34\3\uffff\2\34"+
        "\1\u0133\1\uffff";
    static final String DFA5_eofS =
        "\u0134\uffff";
    static final String DFA5_minS =
        "\1\11\1\uffff\1\103\1\157\1\125\1\111\1\115\1\101\3\105\1\145\1"+
        "\165\1\157\1\150\1\145\1\162\1\144\3\141\2\145\1\151\1\145\7\uffff"+
        "\1\103\1\120\1\155\1\116\1\107\1\120\1\126\1\124\1\127\1\104\1\144"+
        "\1\127\1\116\1\123\1\161\1\162\1\164\1\144\1\151\1\155\1\145\1\160"+
        "\1\157\1\55\1\152\1\156\1\155\1\162\1\151\1\161\1\162\1\141\1\142"+
        "\1\164\1\160\1\162\1\105\1\122\1\155\1\103\1\110\1\114\1\101\1\105"+
        "\1\55\1\111\1\145\1\55\1\106\1\117\1\111\1\165\1\163\1\150\1\171"+
        "\1\154\1\155\1\141\1\145\1\143\1\165\1\uffff\2\157\2\145\1\157\1"+
        "\165\1\157\1\166\1\164\1\152\1\154\1\145\1\163\1\120\1\117\1\145"+
        "\1\124\1\55\1\105\1\114\1\122\1\uffff\1\125\1\154\1\uffff\1\125"+
        "\1\114\1\105\2\151\1\157\1\55\1\144\1\145\1\164\1\156\1\162\1\160"+
        "\2\162\1\55\1\156\1\162\1\151\1\154\1\151\3\145\1\55\1\151\1\124"+
        "\1\126\1\156\1\111\1\uffff\1\115\1\111\1\55\1\115\1\55\1\116\1\126"+
        "\1\127\1\162\1\157\1\162\1\uffff\1\162\1\156\1\145\1\144\1\151\1"+
        "\163\2\55\1\uffff\1\164\1\151\1\162\1\165\1\143\1\55\1\143\1\55"+
        "\1\uffff\1\157\2\105\1\164\1\117\1\105\1\104\1\uffff\1\55\1\uffff"+
        "\1\103\2\105\1\145\1\156\1\55\1\145\1\164\1\144\1\145\1\160\1\55"+
        "\2\uffff\1\55\1\164\1\145\1\164\1\145\1\uffff\1\164\1\uffff\1\156"+
        "\2\104\1\55\2\116\1\55\1\uffff\1\124\2\104\1\155\1\55\1\uffff\1"+
        "\156\1\163\1\55\1\156\1\164\2\uffff\1\171\1\155\1\151\5\55\1\uffff"+
        "\1\101\1\124\1\uffff\1\111\2\55\1\145\1\uffff\2\55\1\uffff\1\143"+
        "\1\151\1\55\1\145\1\157\5\uffff\1\114\1\105\1\117\2\uffff\1\156"+
        "\2\uffff\1\151\1\157\1\uffff\2\156\1\55\1\104\1\116\1\164\1\145"+
        "\1\156\1\164\1\55\1\uffff\1\55\1\101\1\55\1\163\1\55\1\163\2\uffff"+
        "\1\114\1\162\1\uffff\1\55\1\uffff\2\55\1\157\3\uffff\1\165\1\160"+
        "\1\55\1\uffff";
    static final String DFA5_maxS =
        "\1\175\1\uffff\1\120\1\157\1\125\1\111\1\116\1\117\1\157\1\117\2"+
        "\145\1\165\1\157\1\162\1\145\1\162\1\144\1\151\1\141\1\162\1\145"+
        "\1\165\1\171\1\145\7\uffff\1\103\1\120\1\155\1\116\1\107\1\120\1"+
        "\126\1\124\1\127\1\104\1\144\1\127\1\116\1\126\1\161\1\162\1\164"+
        "\1\144\1\151\1\155\1\145\1\163\1\157\1\172\1\152\1\156\1\155\1\162"+
        "\1\151\1\163\1\162\1\141\1\142\1\164\1\160\1\162\1\105\1\122\1\155"+
        "\1\103\1\110\1\114\1\101\1\105\1\172\1\111\1\145\1\172\1\106\1\117"+
        "\1\111\1\165\1\163\1\150\1\171\1\154\1\155\1\141\1\145\1\143\1\165"+
        "\1\uffff\2\157\2\145\1\157\1\165\1\157\1\166\1\164\1\152\1\154\1"+
        "\145\1\163\1\120\1\117\1\145\1\124\1\172\1\105\1\114\1\122\1\uffff"+
        "\1\125\1\154\1\uffff\1\125\1\114\1\105\2\151\1\157\1\172\1\144\1"+
        "\145\1\164\1\156\1\162\1\160\2\162\1\172\1\156\1\162\1\151\1\154"+
        "\1\151\3\145\1\172\1\151\1\124\1\126\1\156\1\111\1\uffff\1\115\1"+
        "\111\1\172\1\115\1\172\1\116\1\126\1\127\1\162\1\157\1\162\1\uffff"+
        "\1\162\1\156\1\145\1\144\1\151\1\163\2\172\1\uffff\1\164\1\151\1"+
        "\162\1\165\1\143\1\172\1\143\1\172\1\uffff\1\157\2\105\1\164\1\117"+
        "\1\105\1\104\1\uffff\1\172\1\uffff\1\103\2\105\1\145\1\156\1\172"+
        "\1\145\1\164\1\144\1\145\1\160\1\172\2\uffff\1\172\1\164\1\145\1"+
        "\164\1\145\1\uffff\1\164\1\uffff\1\156\2\104\1\172\2\116\1\172\1"+
        "\uffff\1\124\2\104\1\155\1\172\1\uffff\1\156\1\163\1\172\1\156\1"+
        "\164\2\uffff\1\171\1\155\1\151\5\172\1\uffff\1\101\1\124\1\uffff"+
        "\1\111\2\172\1\145\1\uffff\2\172\1\uffff\1\143\1\151\1\172\1\145"+
        "\1\157\5\uffff\1\114\1\105\1\117\2\uffff\1\156\2\uffff\1\151\1\157"+
        "\1\uffff\2\156\1\172\1\104\1\116\1\164\1\145\1\156\1\164\1\172\1"+
        "\uffff\1\172\1\101\1\172\1\163\1\172\1\163\2\uffff\1\114\1\162\1"+
        "\uffff\1\172\1\uffff\2\172\1\157\3\uffff\1\165\1\160\1\172\1\uffff";
    static final String DFA5_acceptS =
        "\1\uffff\1\1\27\uffff\1\52\1\53\1\54\1\55\1\56\1\57\1\60\75\uffff"+
        "\1\34\25\uffff\1\12\2\uffff\1\15\36\uffff\1\6\13\uffff\1\25\10\uffff"+
        "\1\37\10\uffff\1\50\7\uffff\1\11\1\uffff\1\14\14\uffff\1\35\1\36"+
        "\5\uffff\1\45\1\uffff\1\47\7\uffff\1\13\5\uffff\1\24\5\uffff\1\33"+
        "\1\40\10\uffff\1\4\2\uffff\1\10\4\uffff\1\23\2\uffff\1\30\5\uffff"+
        "\1\44\1\46\1\51\1\2\1\3\3\uffff\1\17\1\20\1\uffff\1\26\1\27\2\uffff"+
        "\1\41\12\uffff\1\5\6\uffff\1\43\1\7\2\uffff\1\21\1\uffff\1\32\3"+
        "\uffff\1\31\1\42\1\16\3\uffff\1\22";
    static final String DFA5_specialS =
        "\u0134\uffff}>";
    static final String[] DFA5_transitionS = {
            "\1\35\1\36\1\uffff\1\35\1\36\22\uffff\1\35\1\uffff\1\37\12\uffff"+
            "\1\34\1\uffff\1\33\12\34\1\1\6\uffff\1\2\1\34\1\3\2\34\1\4\1"+
            "\34\1\5\1\6\2\34\1\7\1\10\1\11\3\34\1\12\3\34\1\13\4\34\4\uffff"+
            "\1\34\1\uffff\1\14\1\15\1\16\1\17\2\34\1\20\1\34\1\21\3\34\1"+
            "\22\1\23\1\34\1\24\1\34\1\25\1\26\1\27\1\34\1\30\4\34\1\31\1"+
            "\uffff\1\32",
            "",
            "\1\40\14\uffff\1\41",
            "\1\42",
            "\1\43",
            "\1\44",
            "\1\45\1\46",
            "\1\47\15\uffff\1\50",
            "\1\51\51\uffff\1\52",
            "\1\53\11\uffff\1\54",
            "\1\55\37\uffff\1\56",
            "\1\57",
            "\1\60",
            "\1\61",
            "\1\62\6\uffff\1\63\2\uffff\1\64",
            "\1\65",
            "\1\66",
            "\1\67",
            "\1\70\7\uffff\1\71",
            "\1\72",
            "\1\73\20\uffff\1\74",
            "\1\75",
            "\1\76\16\uffff\1\77\1\100",
            "\1\101\17\uffff\1\102",
            "\1\103",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\104",
            "\1\105",
            "\1\106",
            "\1\107",
            "\1\110",
            "\1\111",
            "\1\112",
            "\1\113",
            "\1\114",
            "\1\115",
            "\1\116",
            "\1\117",
            "\1\120",
            "\1\121\2\uffff\1\122",
            "\1\123",
            "\1\124",
            "\1\125",
            "\1\126",
            "\1\127",
            "\1\130",
            "\1\131",
            "\1\132\2\uffff\1\133",
            "\1\134",
            "\1\34\2\uffff\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\1\136",
            "\1\137",
            "\1\140",
            "\1\141",
            "\1\142",
            "\1\143\1\uffff\1\144",
            "\1\145",
            "\1\146",
            "\1\147",
            "\1\150",
            "\1\151",
            "\1\152",
            "\1\153",
            "\1\154",
            "\1\155",
            "\1\156",
            "\1\157",
            "\1\160",
            "\1\161",
            "\1\162",
            "\1\34\2\uffff\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\1\164",
            "\1\165",
            "\1\34\2\uffff\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\1\167",
            "\1\170",
            "\1\171",
            "\1\172",
            "\1\173",
            "\1\174",
            "\1\175",
            "\1\176",
            "\1\177",
            "\1\u0080",
            "\1\u0081",
            "\1\u0082",
            "\1\u0083",
            "",
            "\1\u0084",
            "\1\u0085",
            "\1\u0086",
            "\1\u0087",
            "\1\u0088",
            "\1\u0089",
            "\1\u008a",
            "\1\u008b",
            "\1\u008c",
            "\1\u008d",
            "\1\u008e",
            "\1\u008f",
            "\1\u0090",
            "\1\u0091",
            "\1\u0092",
            "\1\u0093",
            "\1\u0094",
            "\1\34\2\uffff\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\1\u0096",
            "\1\u0097",
            "\1\u0098",
            "",
            "\1\u0099",
            "\1\u009a",
            "",
            "\1\u009b",
            "\1\u009c",
            "\1\u009d",
            "\1\u009e",
            "\1\u009f",
            "\1\u00a0",
            "\1\34\2\uffff\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\1\u00a2",
            "\1\u00a3",
            "\1\u00a4",
            "\1\u00a5",
            "\1\u00a6",
            "\1\u00a7",
            "\1\u00a8",
            "\1\u00a9",
            "\1\34\2\uffff\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\1\u00ab",
            "\1\u00ac",
            "\1\u00ad",
            "\1\u00ae",
            "\1\u00af",
            "\1\u00b0",
            "\1\u00b1",
            "\1\u00b2",
            "\1\34\2\uffff\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\1\u00b4",
            "\1\u00b5",
            "\1\u00b6",
            "\1\u00b7",
            "\1\u00b8",
            "",
            "\1\u00b9",
            "\1\u00ba",
            "\1\34\2\uffff\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\1\u00bc",
            "\1\34\2\uffff\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\1\u00be",
            "\1\u00bf",
            "\1\u00c0",
            "\1\u00c1",
            "\1\u00c2",
            "\1\u00c3",
            "",
            "\1\u00c4",
            "\1\u00c5",
            "\1\u00c6",
            "\1\u00c7",
            "\1\u00c8",
            "\1\u00c9",
            "\1\34\2\uffff\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\1\34\2\uffff\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "",
            "\1\u00cc",
            "\1\u00cd",
            "\1\u00ce",
            "\1\u00cf",
            "\1\u00d0",
            "\1\34\2\uffff\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\1\u00d2",
            "\1\34\2\uffff\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "",
            "\1\u00d4",
            "\1\u00d5",
            "\1\u00d6",
            "\1\u00d7",
            "\1\u00d8",
            "\1\u00d9",
            "\1\u00da",
            "",
            "\1\34\2\uffff\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "",
            "\1\u00dc",
            "\1\u00dd",
            "\1\u00de",
            "\1\u00df",
            "\1\u00e0",
            "\1\34\2\uffff\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\1\u00e2",
            "\1\u00e3",
            "\1\u00e4",
            "\1\u00e5",
            "\1\u00e6",
            "\1\34\2\uffff\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "",
            "",
            "\1\34\2\uffff\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\1\u00e9",
            "\1\u00ea",
            "\1\u00eb",
            "\1\u00ec",
            "",
            "\1\u00ed",
            "",
            "\1\u00ee",
            "\1\u00ef",
            "\1\u00f0",
            "\1\34\2\uffff\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\1\u00f2",
            "\1\u00f3",
            "\1\34\2\uffff\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "",
            "\1\u00f5",
            "\1\u00f6",
            "\1\u00f7",
            "\1\u00f8",
            "\1\34\2\uffff\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "",
            "\1\u00fa",
            "\1\u00fb",
            "\1\34\2\uffff\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\1\u00fd",
            "\1\u00fe",
            "",
            "",
            "\1\u00ff",
            "\1\u0100",
            "\1\u0101",
            "\1\34\2\uffff\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\1\34\2\uffff\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\1\34\2\uffff\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\1\34\2\uffff\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\1\34\2\uffff\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "",
            "\1\u0107",
            "\1\u0108",
            "",
            "\1\u0109",
            "\1\34\2\uffff\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\1\34\2\uffff\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\1\u010c",
            "",
            "\1\34\2\uffff\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\1\34\2\uffff\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "",
            "\1\u010f",
            "\1\u0110",
            "\1\34\2\uffff\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\1\u0112",
            "\1\u0113",
            "",
            "",
            "",
            "",
            "",
            "\1\u0114",
            "\1\u0115",
            "\1\u0116",
            "",
            "",
            "\1\u0117",
            "",
            "",
            "\1\u0118",
            "\1\u0119",
            "",
            "\1\u011a",
            "\1\u011b",
            "\1\34\2\uffff\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\1\u011d",
            "\1\u011e",
            "\1\u011f",
            "\1\u0120",
            "\1\u0121",
            "\1\u0122",
            "\1\34\2\uffff\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "",
            "\1\34\2\uffff\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\1\u0125",
            "\1\34\2\uffff\12\34\7\uffff\6\34\1\u0126\23\34\4\uffff\1\34"+
            "\1\uffff\32\34",
            "\1\u0128",
            "\1\34\2\uffff\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\1\u012a",
            "",
            "",
            "\1\u012b",
            "\1\u012c",
            "",
            "\1\34\2\uffff\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "",
            "\1\34\2\uffff\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\1\34\2\uffff\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\1\u0130",
            "",
            "",
            "",
            "\1\u0131",
            "\1\u0132",
            "\1\34\2\uffff\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            ""
    };

    static final short[] DFA5_eot = DFA.unpackEncodedString(DFA5_eotS);
    static final short[] DFA5_eof = DFA.unpackEncodedString(DFA5_eofS);
    static final char[] DFA5_min = DFA.unpackEncodedStringToUnsignedChars(DFA5_minS);
    static final char[] DFA5_max = DFA.unpackEncodedStringToUnsignedChars(DFA5_maxS);
    static final short[] DFA5_accept = DFA.unpackEncodedString(DFA5_acceptS);
    static final short[] DFA5_special = DFA.unpackEncodedString(DFA5_specialS);
    static final short[][] DFA5_transition;

    static {
        int numStates = DFA5_transitionS.length;
        DFA5_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA5_transition[i] = DFA.unpackEncodedString(DFA5_transitionS[i]);
        }
    }

    class DFA5 extends DFA {

        public DFA5(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 5;
            this.eot = DFA5_eot;
            this.eof = DFA5_eof;
            this.min = DFA5_min;
            this.max = DFA5_max;
            this.accept = DFA5_accept;
            this.special = DFA5_special;
            this.transition = DFA5_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__9 | T__10 | T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | COMMENT | TEXT | WHITESPACE | LINEBREAK | QUOTED_34_34 );";
        }
    }
 

}