// $ANTLR 3.4

	package entity.resource.entity.mopp;


import org.antlr.runtime3_4_0.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class EntityParser extends EntityANTLRParserBase {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "COMMENT", "FLOAT", "INTEGER", "LINEBREAK", "QUOTED_34_34", "TEXT", "WHITESPACE", "':'", "'Attribute'", "'Boolean'", "'Entity'", "'Float'", "'Integer'", "'Model'", "'Name'", "'RelEntity'", "'Relation'", "'String'", "'Title'", "'Type'", "'attributes'", "'has entities'", "'many'", "'one'", "'relations'", "'{'", "'}'"
    };

    public static final int EOF=-1;
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
    public static final int COMMENT=4;
    public static final int FLOAT=5;
    public static final int INTEGER=6;
    public static final int LINEBREAK=7;
    public static final int QUOTED_34_34=8;
    public static final int TEXT=9;
    public static final int WHITESPACE=10;

    // delegates
    public EntityANTLRParserBase[] getDelegates() {
        return new EntityANTLRParserBase[] {};
    }

    // delegators


    public EntityParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public EntityParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
        this.state.initializeRuleMemo(14 + 1);
         

    }

    public String[] getTokenNames() { return EntityParser.tokenNames; }
    public String getGrammarFileName() { return "Entity.g"; }


    	private entity.resource.entity.IEntityTokenResolverFactory tokenResolverFactory = new entity.resource.entity.mopp.EntityTokenResolverFactory();
    	
    	/**
    	 * the index of the last token that was handled by collectHiddenTokens()
    	 */
    	private int lastPosition;
    	
    	/**
    	 * A flag that indicates whether the parser should remember all expected elements.
    	 * This flag is set to true when using the parse for code completion. Otherwise it
    	 * is set to false.
    	 */
    	private boolean rememberExpectedElements = false;
    	
    	private Object parseToIndexTypeObject;
    	private int lastTokenIndex = 0;
    	
    	/**
    	 * A list of expected elements the were collected while parsing the input stream.
    	 * This list is only filled if <code>rememberExpectedElements</code> is set to
    	 * true.
    	 */
    	private java.util.List<entity.resource.entity.mopp.EntityExpectedTerminal> expectedElements = new java.util.ArrayList<entity.resource.entity.mopp.EntityExpectedTerminal>();
    	
    	private int mismatchedTokenRecoveryTries = 0;
    	/**
    	 * A helper list to allow a lexer to pass errors to its parser
    	 */
    	protected java.util.List<org.antlr.runtime3_4_0.RecognitionException> lexerExceptions = java.util.Collections.synchronizedList(new java.util.ArrayList<org.antlr.runtime3_4_0.RecognitionException>());
    	
    	/**
    	 * Another helper list to allow a lexer to pass positions of errors to its parser
    	 */
    	protected java.util.List<Integer> lexerExceptionsPosition = java.util.Collections.synchronizedList(new java.util.ArrayList<Integer>());
    	
    	/**
    	 * A stack for incomplete objects. This stack is used filled when the parser is
    	 * used for code completion. Whenever the parser starts to read an object it is
    	 * pushed on the stack. Once the element was parser completely it is popped from
    	 * the stack.
    	 */
    	java.util.List<org.eclipse.emf.ecore.EObject> incompleteObjects = new java.util.ArrayList<org.eclipse.emf.ecore.EObject>();
    	
    	private int stopIncludingHiddenTokens;
    	private int stopExcludingHiddenTokens;
    	private int tokenIndexOfLastCompleteElement;
    	
    	private int expectedElementsIndexOfLastCompleteElement;
    	
    	/**
    	 * The offset indicating the cursor position when the parser is used for code
    	 * completion by calling parseToExpectedElements().
    	 */
    	private int cursorOffset;
    	
    	/**
    	 * The offset of the first hidden token of the last expected element. This offset
    	 * is used to discard expected elements, which are not needed for code completion.
    	 */
    	private int lastStartIncludingHidden;
    	
    	protected void addErrorToResource(final String errorMessage, final int column, final int line, final int startIndex, final int stopIndex) {
    		postParseCommands.add(new entity.resource.entity.IEntityCommand<entity.resource.entity.IEntityTextResource>() {
    			public boolean execute(entity.resource.entity.IEntityTextResource resource) {
    				if (resource == null) {
    					// the resource can be null if the parser is used for code completion
    					return true;
    				}
    				resource.addProblem(new entity.resource.entity.IEntityProblem() {
    					public entity.resource.entity.EntityEProblemSeverity getSeverity() {
    						return entity.resource.entity.EntityEProblemSeverity.ERROR;
    					}
    					public entity.resource.entity.EntityEProblemType getType() {
    						return entity.resource.entity.EntityEProblemType.SYNTAX_ERROR;
    					}
    					public String getMessage() {
    						return errorMessage;
    					}
    					public java.util.Collection<entity.resource.entity.IEntityQuickFix> getQuickFixes() {
    						return null;
    					}
    				}, column, line, startIndex, stopIndex);
    				return true;
    			}
    		});
    	}
    	
    	public void addExpectedElement(org.eclipse.emf.ecore.EClass eClass, int[] ids) {
    		if (!this.rememberExpectedElements) {
    			return;
    		}
    		int terminalID = ids[0];
    		int followSetID = ids[1];
    		entity.resource.entity.IEntityExpectedElement terminal = entity.resource.entity.grammar.EntityFollowSetProvider.TERMINALS[terminalID];
    		entity.resource.entity.mopp.EntityContainedFeature[] containmentFeatures = new entity.resource.entity.mopp.EntityContainedFeature[ids.length - 2];
    		for (int i = 2; i < ids.length; i++) {
    			containmentFeatures[i - 2] = entity.resource.entity.grammar.EntityFollowSetProvider.LINKS[ids[i]];
    		}
    		entity.resource.entity.grammar.EntityContainmentTrace containmentTrace = new entity.resource.entity.grammar.EntityContainmentTrace(eClass, containmentFeatures);
    		org.eclipse.emf.ecore.EObject container = getLastIncompleteElement();
    		entity.resource.entity.mopp.EntityExpectedTerminal expectedElement = new entity.resource.entity.mopp.EntityExpectedTerminal(container, terminal, followSetID, containmentTrace);
    		setPosition(expectedElement, input.index());
    		int startIncludingHiddenTokens = expectedElement.getStartIncludingHiddenTokens();
    		if (lastStartIncludingHidden >= 0 && lastStartIncludingHidden < startIncludingHiddenTokens && cursorOffset > startIncludingHiddenTokens) {
    			// clear list of expected elements
    			this.expectedElements.clear();
    			this.expectedElementsIndexOfLastCompleteElement = 0;
    		}
    		lastStartIncludingHidden = startIncludingHiddenTokens;
    		this.expectedElements.add(expectedElement);
    	}
    	
    	protected void collectHiddenTokens(org.eclipse.emf.ecore.EObject element) {
    	}
    	
    	protected void copyLocalizationInfos(final org.eclipse.emf.ecore.EObject source, final org.eclipse.emf.ecore.EObject target) {
    		if (disableLocationMap) {
    			return;
    		}
    		postParseCommands.add(new entity.resource.entity.IEntityCommand<entity.resource.entity.IEntityTextResource>() {
    			public boolean execute(entity.resource.entity.IEntityTextResource resource) {
    				entity.resource.entity.IEntityLocationMap locationMap = resource.getLocationMap();
    				if (locationMap == null) {
    					// the locationMap can be null if the parser is used for code completion
    					return true;
    				}
    				locationMap.setCharStart(target, locationMap.getCharStart(source));
    				locationMap.setCharEnd(target, locationMap.getCharEnd(source));
    				locationMap.setColumn(target, locationMap.getColumn(source));
    				locationMap.setLine(target, locationMap.getLine(source));
    				return true;
    			}
    		});
    	}
    	
    	protected void copyLocalizationInfos(final org.antlr.runtime3_4_0.CommonToken source, final org.eclipse.emf.ecore.EObject target) {
    		if (disableLocationMap) {
    			return;
    		}
    		postParseCommands.add(new entity.resource.entity.IEntityCommand<entity.resource.entity.IEntityTextResource>() {
    			public boolean execute(entity.resource.entity.IEntityTextResource resource) {
    				entity.resource.entity.IEntityLocationMap locationMap = resource.getLocationMap();
    				if (locationMap == null) {
    					// the locationMap can be null if the parser is used for code completion
    					return true;
    				}
    				if (source == null) {
    					return true;
    				}
    				locationMap.setCharStart(target, source.getStartIndex());
    				locationMap.setCharEnd(target, source.getStopIndex());
    				locationMap.setColumn(target, source.getCharPositionInLine());
    				locationMap.setLine(target, source.getLine());
    				return true;
    			}
    		});
    	}
    	
    	/**
    	 * Sets the end character index and the last line for the given object in the
    	 * location map.
    	 */
    	protected void setLocalizationEnd(java.util.Collection<entity.resource.entity.IEntityCommand<entity.resource.entity.IEntityTextResource>> postParseCommands , final org.eclipse.emf.ecore.EObject object, final int endChar, final int endLine) {
    		if (disableLocationMap) {
    			return;
    		}
    		postParseCommands.add(new entity.resource.entity.IEntityCommand<entity.resource.entity.IEntityTextResource>() {
    			public boolean execute(entity.resource.entity.IEntityTextResource resource) {
    				entity.resource.entity.IEntityLocationMap locationMap = resource.getLocationMap();
    				if (locationMap == null) {
    					// the locationMap can be null if the parser is used for code completion
    					return true;
    				}
    				locationMap.setCharEnd(object, endChar);
    				locationMap.setLine(object, endLine);
    				return true;
    			}
    		});
    	}
    	
    	public entity.resource.entity.IEntityTextParser createInstance(java.io.InputStream actualInputStream, String encoding) {
    		try {
    			if (encoding == null) {
    				return new EntityParser(new org.antlr.runtime3_4_0.CommonTokenStream(new EntityLexer(new org.antlr.runtime3_4_0.ANTLRInputStream(actualInputStream))));
    			} else {
    				return new EntityParser(new org.antlr.runtime3_4_0.CommonTokenStream(new EntityLexer(new org.antlr.runtime3_4_0.ANTLRInputStream(actualInputStream, encoding))));
    			}
    		} catch (java.io.IOException e) {
    			new entity.resource.entity.util.EntityRuntimeUtil().logError("Error while creating parser.", e);
    			return null;
    		}
    	}
    	
    	/**
    	 * This default constructor is only used to call createInstance() on it.
    	 */
    	public EntityParser() {
    		super(null);
    	}
    	
    	protected org.eclipse.emf.ecore.EObject doParse() throws org.antlr.runtime3_4_0.RecognitionException {
    		this.lastPosition = 0;
    		// required because the lexer class can not be subclassed
    		((EntityLexer) getTokenStream().getTokenSource()).lexerExceptions = lexerExceptions;
    		((EntityLexer) getTokenStream().getTokenSource()).lexerExceptionsPosition = lexerExceptionsPosition;
    		Object typeObject = getTypeObject();
    		if (typeObject == null) {
    			return start();
    		} else if (typeObject instanceof org.eclipse.emf.ecore.EClass) {
    			org.eclipse.emf.ecore.EClass type = (org.eclipse.emf.ecore.EClass) typeObject;
    			if (type.getInstanceClass() == entity.Model.class) {
    				return parse_entity_Model();
    			}
    			if (type.getInstanceClass() == entity.Entity.class) {
    				return parse_entity_Entity();
    			}
    			if (type.getInstanceClass() == entity.Attribute.class) {
    				return parse_entity_Attribute();
    			}
    			if (type.getInstanceClass() == entity.Relation.class) {
    				return parse_entity_Relation();
    			}
    		}
    		throw new entity.resource.entity.mopp.EntityUnexpectedContentTypeException(typeObject);
    	}
    	
    	public int getMismatchedTokenRecoveryTries() {
    		return mismatchedTokenRecoveryTries;
    	}
    	
    	public Object getMissingSymbol(org.antlr.runtime3_4_0.IntStream arg0, org.antlr.runtime3_4_0.RecognitionException arg1, int arg2, org.antlr.runtime3_4_0.BitSet arg3) {
    		mismatchedTokenRecoveryTries++;
    		return super.getMissingSymbol(arg0, arg1, arg2, arg3);
    	}
    	
    	public Object getParseToIndexTypeObject() {
    		return parseToIndexTypeObject;
    	}
    	
    	protected Object getTypeObject() {
    		Object typeObject = getParseToIndexTypeObject();
    		if (typeObject != null) {
    			return typeObject;
    		}
    		java.util.Map<?,?> options = getOptions();
    		if (options != null) {
    			typeObject = options.get(entity.resource.entity.IEntityOptions.RESOURCE_CONTENT_TYPE);
    		}
    		return typeObject;
    	}
    	
    	/**
    	 * Implementation that calls {@link #doParse()} and handles the thrown
    	 * RecognitionExceptions.
    	 */
    	public entity.resource.entity.IEntityParseResult parse() {
    		terminateParsing = false;
    		postParseCommands = new java.util.ArrayList<entity.resource.entity.IEntityCommand<entity.resource.entity.IEntityTextResource>>();
    		entity.resource.entity.mopp.EntityParseResult parseResult = new entity.resource.entity.mopp.EntityParseResult();
    		try {
    			org.eclipse.emf.ecore.EObject result =  doParse();
    			if (lexerExceptions.isEmpty()) {
    				parseResult.setRoot(result);
    			}
    		} catch (org.antlr.runtime3_4_0.RecognitionException re) {
    			reportError(re);
    		} catch (java.lang.IllegalArgumentException iae) {
    			if ("The 'no null' constraint is violated".equals(iae.getMessage())) {
    				// can be caused if a null is set on EMF models where not allowed. this will just
    				// happen if other errors occurred before
    			} else {
    				iae.printStackTrace();
    			}
    		}
    		for (org.antlr.runtime3_4_0.RecognitionException re : lexerExceptions) {
    			reportLexicalError(re);
    		}
    		parseResult.getPostParseCommands().addAll(postParseCommands);
    		return parseResult;
    	}
    	
    	public java.util.List<entity.resource.entity.mopp.EntityExpectedTerminal> parseToExpectedElements(org.eclipse.emf.ecore.EClass type, entity.resource.entity.IEntityTextResource dummyResource, int cursorOffset) {
    		this.rememberExpectedElements = true;
    		this.parseToIndexTypeObject = type;
    		this.cursorOffset = cursorOffset;
    		this.lastStartIncludingHidden = -1;
    		final org.antlr.runtime3_4_0.CommonTokenStream tokenStream = (org.antlr.runtime3_4_0.CommonTokenStream) getTokenStream();
    		entity.resource.entity.IEntityParseResult result = parse();
    		for (org.eclipse.emf.ecore.EObject incompleteObject : incompleteObjects) {
    			org.antlr.runtime3_4_0.Lexer lexer = (org.antlr.runtime3_4_0.Lexer) tokenStream.getTokenSource();
    			int endChar = lexer.getCharIndex();
    			int endLine = lexer.getLine();
    			setLocalizationEnd(result.getPostParseCommands(), incompleteObject, endChar, endLine);
    		}
    		if (result != null) {
    			org.eclipse.emf.ecore.EObject root = result.getRoot();
    			if (root != null) {
    				dummyResource.getContentsInternal().add(root);
    			}
    			for (entity.resource.entity.IEntityCommand<entity.resource.entity.IEntityTextResource> command : result.getPostParseCommands()) {
    				command.execute(dummyResource);
    			}
    		}
    		// remove all expected elements that were added after the last complete element
    		expectedElements = expectedElements.subList(0, expectedElementsIndexOfLastCompleteElement + 1);
    		int lastFollowSetID = expectedElements.get(expectedElementsIndexOfLastCompleteElement).getFollowSetID();
    		java.util.Set<entity.resource.entity.mopp.EntityExpectedTerminal> currentFollowSet = new java.util.LinkedHashSet<entity.resource.entity.mopp.EntityExpectedTerminal>();
    		java.util.List<entity.resource.entity.mopp.EntityExpectedTerminal> newFollowSet = new java.util.ArrayList<entity.resource.entity.mopp.EntityExpectedTerminal>();
    		for (int i = expectedElementsIndexOfLastCompleteElement; i >= 0; i--) {
    			entity.resource.entity.mopp.EntityExpectedTerminal expectedElementI = expectedElements.get(i);
    			if (expectedElementI.getFollowSetID() == lastFollowSetID) {
    				currentFollowSet.add(expectedElementI);
    			} else {
    				break;
    			}
    		}
    		int followSetID = 52;
    		int i;
    		for (i = tokenIndexOfLastCompleteElement; i < tokenStream.size(); i++) {
    			org.antlr.runtime3_4_0.CommonToken nextToken = (org.antlr.runtime3_4_0.CommonToken) tokenStream.get(i);
    			if (nextToken.getType() < 0) {
    				break;
    			}
    			if (nextToken.getChannel() == 99) {
    				// hidden tokens do not reduce the follow set
    			} else {
    				// now that we have found the next visible token the position for that expected
    				// terminals can be set
    				for (entity.resource.entity.mopp.EntityExpectedTerminal nextFollow : newFollowSet) {
    					lastTokenIndex = 0;
    					setPosition(nextFollow, i);
    				}
    				newFollowSet.clear();
    				// normal tokens do reduce the follow set - only elements that match the token are
    				// kept
    				for (entity.resource.entity.mopp.EntityExpectedTerminal nextFollow : currentFollowSet) {
    					if (nextFollow.getTerminal().getTokenNames().contains(getTokenNames()[nextToken.getType()])) {
    						// keep this one - it matches
    						java.util.Collection<entity.resource.entity.util.EntityPair<entity.resource.entity.IEntityExpectedElement, entity.resource.entity.mopp.EntityContainedFeature[]>> newFollowers = nextFollow.getTerminal().getFollowers();
    						for (entity.resource.entity.util.EntityPair<entity.resource.entity.IEntityExpectedElement, entity.resource.entity.mopp.EntityContainedFeature[]> newFollowerPair : newFollowers) {
    							entity.resource.entity.IEntityExpectedElement newFollower = newFollowerPair.getLeft();
    							org.eclipse.emf.ecore.EObject container = getLastIncompleteElement();
    							entity.resource.entity.grammar.EntityContainmentTrace containmentTrace = new entity.resource.entity.grammar.EntityContainmentTrace(null, newFollowerPair.getRight());
    							entity.resource.entity.mopp.EntityExpectedTerminal newFollowTerminal = new entity.resource.entity.mopp.EntityExpectedTerminal(container, newFollower, followSetID, containmentTrace);
    							newFollowSet.add(newFollowTerminal);
    							expectedElements.add(newFollowTerminal);
    						}
    					}
    				}
    				currentFollowSet.clear();
    				currentFollowSet.addAll(newFollowSet);
    			}
    			followSetID++;
    		}
    		// after the last token in the stream we must set the position for the elements
    		// that were added during the last iteration of the loop
    		for (entity.resource.entity.mopp.EntityExpectedTerminal nextFollow : newFollowSet) {
    			lastTokenIndex = 0;
    			setPosition(nextFollow, i);
    		}
    		return this.expectedElements;
    	}
    	
    	public void setPosition(entity.resource.entity.mopp.EntityExpectedTerminal expectedElement, int tokenIndex) {
    		int currentIndex = Math.max(0, tokenIndex);
    		for (int index = lastTokenIndex; index < currentIndex; index++) {
    			if (index >= input.size()) {
    				break;
    			}
    			org.antlr.runtime3_4_0.CommonToken tokenAtIndex = (org.antlr.runtime3_4_0.CommonToken) input.get(index);
    			stopIncludingHiddenTokens = tokenAtIndex.getStopIndex() + 1;
    			if (tokenAtIndex.getChannel() != 99 && !anonymousTokens.contains(tokenAtIndex)) {
    				stopExcludingHiddenTokens = tokenAtIndex.getStopIndex() + 1;
    			}
    		}
    		lastTokenIndex = Math.max(0, currentIndex);
    		expectedElement.setPosition(stopExcludingHiddenTokens, stopIncludingHiddenTokens);
    	}
    	
    	public Object recoverFromMismatchedToken(org.antlr.runtime3_4_0.IntStream input, int ttype, org.antlr.runtime3_4_0.BitSet follow) throws org.antlr.runtime3_4_0.RecognitionException {
    		if (!rememberExpectedElements) {
    			return super.recoverFromMismatchedToken(input, ttype, follow);
    		} else {
    			return null;
    		}
    	}
    	
    	/**
    	 * Translates errors thrown by the parser into human readable messages.
    	 */
    	public void reportError(final org.antlr.runtime3_4_0.RecognitionException e)  {
    		String message = e.getMessage();
    		if (e instanceof org.antlr.runtime3_4_0.MismatchedTokenException) {
    			org.antlr.runtime3_4_0.MismatchedTokenException mte = (org.antlr.runtime3_4_0.MismatchedTokenException) e;
    			String expectedTokenName = formatTokenName(mte.expecting);
    			String actualTokenName = formatTokenName(e.token.getType());
    			message = "Syntax error on token \"" + e.token.getText() + " (" + actualTokenName + ")\", \"" + expectedTokenName + "\" expected";
    		} else if (e instanceof org.antlr.runtime3_4_0.MismatchedTreeNodeException) {
    			org.antlr.runtime3_4_0.MismatchedTreeNodeException mtne = (org.antlr.runtime3_4_0.MismatchedTreeNodeException) e;
    			String expectedTokenName = formatTokenName(mtne.expecting);
    			message = "mismatched tree node: " + "xxx" + "; tokenName " + expectedTokenName;
    		} else if (e instanceof org.antlr.runtime3_4_0.NoViableAltException) {
    			message = "Syntax error on token \"" + e.token.getText() + "\", check following tokens";
    		} else if (e instanceof org.antlr.runtime3_4_0.EarlyExitException) {
    			message = "Syntax error on token \"" + e.token.getText() + "\", delete this token";
    		} else if (e instanceof org.antlr.runtime3_4_0.MismatchedSetException) {
    			org.antlr.runtime3_4_0.MismatchedSetException mse = (org.antlr.runtime3_4_0.MismatchedSetException) e;
    			message = "mismatched token: " + e.token + "; expecting set " + mse.expecting;
    		} else if (e instanceof org.antlr.runtime3_4_0.MismatchedNotSetException) {
    			org.antlr.runtime3_4_0.MismatchedNotSetException mse = (org.antlr.runtime3_4_0.MismatchedNotSetException) e;
    			message = "mismatched token: " +  e.token + "; expecting set " + mse.expecting;
    		} else if (e instanceof org.antlr.runtime3_4_0.FailedPredicateException) {
    			org.antlr.runtime3_4_0.FailedPredicateException fpe = (org.antlr.runtime3_4_0.FailedPredicateException) e;
    			message = "rule " + fpe.ruleName + " failed predicate: {" +  fpe.predicateText + "}?";
    		}
    		// the resource may be null if the parser is used for code completion
    		final String finalMessage = message;
    		if (e.token instanceof org.antlr.runtime3_4_0.CommonToken) {
    			final org.antlr.runtime3_4_0.CommonToken ct = (org.antlr.runtime3_4_0.CommonToken) e.token;
    			addErrorToResource(finalMessage, ct.getCharPositionInLine(), ct.getLine(), ct.getStartIndex(), ct.getStopIndex());
    		} else {
    			addErrorToResource(finalMessage, e.token.getCharPositionInLine(), e.token.getLine(), 1, 5);
    		}
    	}
    	
    	/**
    	 * Translates errors thrown by the lexer into human readable messages.
    	 */
    	public void reportLexicalError(final org.antlr.runtime3_4_0.RecognitionException e)  {
    		String message = "";
    		if (e instanceof org.antlr.runtime3_4_0.MismatchedTokenException) {
    			org.antlr.runtime3_4_0.MismatchedTokenException mte = (org.antlr.runtime3_4_0.MismatchedTokenException) e;
    			message = "Syntax error on token \"" + ((char) e.c) + "\", \"" + (char) mte.expecting + "\" expected";
    		} else if (e instanceof org.antlr.runtime3_4_0.NoViableAltException) {
    			message = "Syntax error on token \"" + ((char) e.c) + "\", delete this token";
    		} else if (e instanceof org.antlr.runtime3_4_0.EarlyExitException) {
    			org.antlr.runtime3_4_0.EarlyExitException eee = (org.antlr.runtime3_4_0.EarlyExitException) e;
    			message = "required (...)+ loop (decision=" + eee.decisionNumber + ") did not match anything; on line " + e.line + ":" + e.charPositionInLine + " char=" + ((char) e.c) + "'";
    		} else if (e instanceof org.antlr.runtime3_4_0.MismatchedSetException) {
    			org.antlr.runtime3_4_0.MismatchedSetException mse = (org.antlr.runtime3_4_0.MismatchedSetException) e;
    			message = "mismatched char: '" + ((char) e.c) + "' on line " + e.line + ":" + e.charPositionInLine + "; expecting set " + mse.expecting;
    		} else if (e instanceof org.antlr.runtime3_4_0.MismatchedNotSetException) {
    			org.antlr.runtime3_4_0.MismatchedNotSetException mse = (org.antlr.runtime3_4_0.MismatchedNotSetException) e;
    			message = "mismatched char: '" + ((char) e.c) + "' on line " + e.line + ":" + e.charPositionInLine + "; expecting set " + mse.expecting;
    		} else if (e instanceof org.antlr.runtime3_4_0.MismatchedRangeException) {
    			org.antlr.runtime3_4_0.MismatchedRangeException mre = (org.antlr.runtime3_4_0.MismatchedRangeException) e;
    			message = "mismatched char: '" + ((char) e.c) + "' on line " + e.line + ":" + e.charPositionInLine + "; expecting set '" + (char) mre.a + "'..'" + (char) mre.b + "'";
    		} else if (e instanceof org.antlr.runtime3_4_0.FailedPredicateException) {
    			org.antlr.runtime3_4_0.FailedPredicateException fpe = (org.antlr.runtime3_4_0.FailedPredicateException) e;
    			message = "rule " + fpe.ruleName + " failed predicate: {" + fpe.predicateText + "}?";
    		}
    		addErrorToResource(message, e.charPositionInLine, e.line, lexerExceptionsPosition.get(lexerExceptions.indexOf(e)), lexerExceptionsPosition.get(lexerExceptions.indexOf(e)));
    	}
    	
    	private void startIncompleteElement(Object object) {
    		if (object instanceof org.eclipse.emf.ecore.EObject) {
    			this.incompleteObjects.add((org.eclipse.emf.ecore.EObject) object);
    		}
    	}
    	
    	private void completedElement(Object object, boolean isContainment) {
    		if (isContainment && !this.incompleteObjects.isEmpty()) {
    			boolean exists = this.incompleteObjects.remove(object);
    			if (!exists) {
    			}
    		}
    		if (object instanceof org.eclipse.emf.ecore.EObject) {
    			this.tokenIndexOfLastCompleteElement = getTokenStream().index();
    			this.expectedElementsIndexOfLastCompleteElement = expectedElements.size() - 1;
    		}
    	}
    	
    	private org.eclipse.emf.ecore.EObject getLastIncompleteElement() {
    		if (incompleteObjects.isEmpty()) {
    			return null;
    		}
    		return incompleteObjects.get(incompleteObjects.size() - 1);
    	}
    	



    // $ANTLR start "start"
    // Entity.g:508:1: start returns [ org.eclipse.emf.ecore.EObject element = null] : (c0= parse_entity_Model ) EOF ;
    public final org.eclipse.emf.ecore.EObject start() throws RecognitionException {
        org.eclipse.emf.ecore.EObject element =  null;

        int start_StartIndex = input.index();

        entity.Model c0 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return element; }

            // Entity.g:509:2: ( (c0= parse_entity_Model ) EOF )
            // Entity.g:510:2: (c0= parse_entity_Model ) EOF
            {
            if ( state.backtracking==0 ) {
            		// follow set for start rule(s)
            		addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[0]);
            		expectedElementsIndexOfLastCompleteElement = 0;
            	}

            // Entity.g:515:2: (c0= parse_entity_Model )
            // Entity.g:516:3: c0= parse_entity_Model
            {
            pushFollow(FOLLOW_parse_entity_Model_in_start82);
            c0=parse_entity_Model();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) { element = c0; }

            }


            match(input,EOF,FOLLOW_EOF_in_start89); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		retrieveLayoutInformation(element, null, null, false);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 1, start_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "start"



    // $ANTLR start "parse_entity_Model"
    // Entity.g:524:1: parse_entity_Model returns [entity.Model element = null] : a0= 'Model' a1= '{' (a2= 'Title' a3= ':' (a4= QUOTED_34_34 ) ( (a5= 'has entities' a6= ':' (a7_0= parse_entity_Entity ) ) )* ) a8= '}' ;
    public final entity.Model parse_entity_Model() throws RecognitionException {
        entity.Model element =  null;

        int parse_entity_Model_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a5=null;
        Token a6=null;
        Token a8=null;
        entity.Entity a7_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return element; }

            // Entity.g:527:2: (a0= 'Model' a1= '{' (a2= 'Title' a3= ':' (a4= QUOTED_34_34 ) ( (a5= 'has entities' a6= ':' (a7_0= parse_entity_Entity ) ) )* ) a8= '}' )
            // Entity.g:528:2: a0= 'Model' a1= '{' (a2= 'Title' a3= ':' (a4= QUOTED_34_34 ) ( (a5= 'has entities' a6= ':' (a7_0= parse_entity_Entity ) ) )* ) a8= '}'
            {
            a0=(Token)match(input,17,FOLLOW_17_in_parse_entity_Model115); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = entity.EntityFactory.eINSTANCE.createModel();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, entity.resource.entity.grammar.EntityGrammarInformationProvider.ENTITY_0_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[1]);
            	}

            a1=(Token)match(input,29,FOLLOW_29_in_parse_entity_Model129); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = entity.EntityFactory.eINSTANCE.createModel();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, entity.resource.entity.grammar.EntityGrammarInformationProvider.ENTITY_0_0_0_1, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[2]);
            	}

            // Entity.g:556:2: (a2= 'Title' a3= ':' (a4= QUOTED_34_34 ) ( (a5= 'has entities' a6= ':' (a7_0= parse_entity_Entity ) ) )* )
            // Entity.g:557:3: a2= 'Title' a3= ':' (a4= QUOTED_34_34 ) ( (a5= 'has entities' a6= ':' (a7_0= parse_entity_Entity ) ) )*
            {
            a2=(Token)match(input,22,FOLLOW_22_in_parse_entity_Model147); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (element == null) {
            				element = entity.EntityFactory.eINSTANCE.createModel();
            				startIncompleteElement(element);
            			}
            			collectHiddenTokens(element);
            			retrieveLayoutInformation(element, entity.resource.entity.grammar.EntityGrammarInformationProvider.ENTITY_0_0_0_2_0_0_0, null, true);
            			copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
            		}

            if ( state.backtracking==0 ) {
            			// expected elements (follow set)
            			addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[3]);
            		}

            a3=(Token)match(input,11,FOLLOW_11_in_parse_entity_Model164); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (element == null) {
            				element = entity.EntityFactory.eINSTANCE.createModel();
            				startIncompleteElement(element);
            			}
            			collectHiddenTokens(element);
            			retrieveLayoutInformation(element, entity.resource.entity.grammar.EntityGrammarInformationProvider.ENTITY_0_0_0_2_0_0_1, null, true);
            			copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
            		}

            if ( state.backtracking==0 ) {
            			// expected elements (follow set)
            			addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[4]);
            		}

            // Entity.g:585:3: (a4= QUOTED_34_34 )
            // Entity.g:586:4: a4= QUOTED_34_34
            {
            a4=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_entity_Model186); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            				if (terminateParsing) {
            					throw new entity.resource.entity.mopp.EntityTerminateParsingException();
            				}
            				if (element == null) {
            					element = entity.EntityFactory.eINSTANCE.createModel();
            					startIncompleteElement(element);
            				}
            				if (a4 != null) {
            					entity.resource.entity.IEntityTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
            					tokenResolver.setOptions(getOptions());
            					entity.resource.entity.IEntityTokenResolveResult result = getFreshTokenResolveResult();
            					tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(entity.EntityPackage.MODEL__TITLE), result);
            					Object resolvedObject = result.getResolvedToken();
            					if (resolvedObject == null) {
            						addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a4).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStopIndex());
            					}
            					java.lang.String resolved = (java.lang.String) resolvedObject;
            					if (resolved != null) {
            						Object value = resolved;
            						element.eSet(element.eClass().getEStructuralFeature(entity.EntityPackage.MODEL__TITLE), value);
            						completedElement(value, false);
            					}
            					collectHiddenTokens(element);
            					retrieveLayoutInformation(element, entity.resource.entity.grammar.EntityGrammarInformationProvider.ENTITY_0_0_0_2_0_0_2, resolved, true);
            					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a4, element);
            				}
            			}

            }


            if ( state.backtracking==0 ) {
            			// expected elements (follow set)
            			addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[5]);
            			addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[6]);
            		}

            // Entity.g:622:3: ( (a5= 'has entities' a6= ':' (a7_0= parse_entity_Entity ) ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==25) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // Entity.g:623:4: (a5= 'has entities' a6= ':' (a7_0= parse_entity_Entity ) )
            	    {
            	    // Entity.g:623:4: (a5= 'has entities' a6= ':' (a7_0= parse_entity_Entity ) )
            	    // Entity.g:624:5: a5= 'has entities' a6= ':' (a7_0= parse_entity_Entity )
            	    {
            	    a5=(Token)match(input,25,FOLLOW_25_in_parse_entity_Model224); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    					if (element == null) {
            	    						element = entity.EntityFactory.eINSTANCE.createModel();
            	    						startIncompleteElement(element);
            	    					}
            	    					collectHiddenTokens(element);
            	    					retrieveLayoutInformation(element, entity.resource.entity.grammar.EntityGrammarInformationProvider.ENTITY_0_0_0_2_0_0_3_0_0_0, null, true);
            	    					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
            	    				}

            	    if ( state.backtracking==0 ) {
            	    					// expected elements (follow set)
            	    					addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[7]);
            	    				}

            	    a6=(Token)match(input,11,FOLLOW_11_in_parse_entity_Model247); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    					if (element == null) {
            	    						element = entity.EntityFactory.eINSTANCE.createModel();
            	    						startIncompleteElement(element);
            	    					}
            	    					collectHiddenTokens(element);
            	    					retrieveLayoutInformation(element, entity.resource.entity.grammar.EntityGrammarInformationProvider.ENTITY_0_0_0_2_0_0_3_0_0_1, null, true);
            	    					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
            	    				}

            	    if ( state.backtracking==0 ) {
            	    					// expected elements (follow set)
            	    					addExpectedElement(entity.EntityPackage.eINSTANCE.getModel(), entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[8]);
            	    				}

            	    // Entity.g:652:5: (a7_0= parse_entity_Entity )
            	    // Entity.g:653:6: a7_0= parse_entity_Entity
            	    {
            	    pushFollow(FOLLOW_parse_entity_Entity_in_parse_entity_Model277);
            	    a7_0=parse_entity_Entity();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    						if (terminateParsing) {
            	    							throw new entity.resource.entity.mopp.EntityTerminateParsingException();
            	    						}
            	    						if (element == null) {
            	    							element = entity.EntityFactory.eINSTANCE.createModel();
            	    							startIncompleteElement(element);
            	    						}
            	    						if (a7_0 != null) {
            	    							if (a7_0 != null) {
            	    								Object value = a7_0;
            	    								addObjectToList(element, entity.EntityPackage.MODEL__ROOT_ENTITIES, value);
            	    								completedElement(value, true);
            	    							}
            	    							collectHiddenTokens(element);
            	    							retrieveLayoutInformation(element, entity.resource.entity.grammar.EntityGrammarInformationProvider.ENTITY_0_0_0_2_0_0_3_0_0_2, a7_0, true);
            	    							copyLocalizationInfos(a7_0, element);
            	    						}
            	    					}

            	    }


            	    if ( state.backtracking==0 ) {
            	    					// expected elements (follow set)
            	    					addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[9]);
            	    					addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[10]);
            	    				}

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            			// expected elements (follow set)
            			addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[11]);
            			addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[12]);
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[13]);
            	}

            a8=(Token)match(input,30,FOLLOW_30_in_parse_entity_Model335); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = entity.EntityFactory.eINSTANCE.createModel();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, entity.resource.entity.grammar.EntityGrammarInformationProvider.ENTITY_0_0_0_3, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a8, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 2, parse_entity_Model_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_entity_Model"



    // $ANTLR start "parse_entity_Entity"
    // Entity.g:708:1: parse_entity_Entity returns [entity.Entity element = null] : a0= 'Entity' a1= '{' (a2= 'Name' a3= ':' (a4= QUOTED_34_34 ) ( (a5= 'attributes' a6= ':' (a7_0= parse_entity_Attribute ) ) )* ( (a8= 'relations' a9= ':' (a10_0= parse_entity_Relation ) ) )* ) a11= '}' ;
    public final entity.Entity parse_entity_Entity() throws RecognitionException {
        entity.Entity element =  null;

        int parse_entity_Entity_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a5=null;
        Token a6=null;
        Token a8=null;
        Token a9=null;
        Token a11=null;
        entity.Attribute a7_0 =null;

        entity.Relation a10_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return element; }

            // Entity.g:711:2: (a0= 'Entity' a1= '{' (a2= 'Name' a3= ':' (a4= QUOTED_34_34 ) ( (a5= 'attributes' a6= ':' (a7_0= parse_entity_Attribute ) ) )* ( (a8= 'relations' a9= ':' (a10_0= parse_entity_Relation ) ) )* ) a11= '}' )
            // Entity.g:712:2: a0= 'Entity' a1= '{' (a2= 'Name' a3= ':' (a4= QUOTED_34_34 ) ( (a5= 'attributes' a6= ':' (a7_0= parse_entity_Attribute ) ) )* ( (a8= 'relations' a9= ':' (a10_0= parse_entity_Relation ) ) )* ) a11= '}'
            {
            a0=(Token)match(input,14,FOLLOW_14_in_parse_entity_Entity364); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = entity.EntityFactory.eINSTANCE.createEntity();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, entity.resource.entity.grammar.EntityGrammarInformationProvider.ENTITY_1_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[14]);
            	}

            a1=(Token)match(input,29,FOLLOW_29_in_parse_entity_Entity378); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = entity.EntityFactory.eINSTANCE.createEntity();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, entity.resource.entity.grammar.EntityGrammarInformationProvider.ENTITY_1_0_0_1, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[15]);
            	}

            // Entity.g:740:2: (a2= 'Name' a3= ':' (a4= QUOTED_34_34 ) ( (a5= 'attributes' a6= ':' (a7_0= parse_entity_Attribute ) ) )* ( (a8= 'relations' a9= ':' (a10_0= parse_entity_Relation ) ) )* )
            // Entity.g:741:3: a2= 'Name' a3= ':' (a4= QUOTED_34_34 ) ( (a5= 'attributes' a6= ':' (a7_0= parse_entity_Attribute ) ) )* ( (a8= 'relations' a9= ':' (a10_0= parse_entity_Relation ) ) )*
            {
            a2=(Token)match(input,18,FOLLOW_18_in_parse_entity_Entity396); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (element == null) {
            				element = entity.EntityFactory.eINSTANCE.createEntity();
            				startIncompleteElement(element);
            			}
            			collectHiddenTokens(element);
            			retrieveLayoutInformation(element, entity.resource.entity.grammar.EntityGrammarInformationProvider.ENTITY_1_0_0_2_0_0_0, null, true);
            			copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
            		}

            if ( state.backtracking==0 ) {
            			// expected elements (follow set)
            			addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[16]);
            		}

            a3=(Token)match(input,11,FOLLOW_11_in_parse_entity_Entity413); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (element == null) {
            				element = entity.EntityFactory.eINSTANCE.createEntity();
            				startIncompleteElement(element);
            			}
            			collectHiddenTokens(element);
            			retrieveLayoutInformation(element, entity.resource.entity.grammar.EntityGrammarInformationProvider.ENTITY_1_0_0_2_0_0_1, null, true);
            			copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
            		}

            if ( state.backtracking==0 ) {
            			// expected elements (follow set)
            			addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[17]);
            		}

            // Entity.g:769:3: (a4= QUOTED_34_34 )
            // Entity.g:770:4: a4= QUOTED_34_34
            {
            a4=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_entity_Entity435); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            				if (terminateParsing) {
            					throw new entity.resource.entity.mopp.EntityTerminateParsingException();
            				}
            				if (element == null) {
            					element = entity.EntityFactory.eINSTANCE.createEntity();
            					startIncompleteElement(element);
            				}
            				if (a4 != null) {
            					entity.resource.entity.IEntityTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
            					tokenResolver.setOptions(getOptions());
            					entity.resource.entity.IEntityTokenResolveResult result = getFreshTokenResolveResult();
            					tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(entity.EntityPackage.ENTITY__NAME), result);
            					Object resolvedObject = result.getResolvedToken();
            					if (resolvedObject == null) {
            						addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a4).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStopIndex());
            					}
            					java.lang.String resolved = (java.lang.String) resolvedObject;
            					if (resolved != null) {
            						Object value = resolved;
            						element.eSet(element.eClass().getEStructuralFeature(entity.EntityPackage.ENTITY__NAME), value);
            						completedElement(value, false);
            					}
            					collectHiddenTokens(element);
            					retrieveLayoutInformation(element, entity.resource.entity.grammar.EntityGrammarInformationProvider.ENTITY_1_0_0_2_0_0_2, resolved, true);
            					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a4, element);
            				}
            			}

            }


            if ( state.backtracking==0 ) {
            			// expected elements (follow set)
            			addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[18]);
            			addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[19]);
            			addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[20]);
            		}

            // Entity.g:807:3: ( (a5= 'attributes' a6= ':' (a7_0= parse_entity_Attribute ) ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==24) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // Entity.g:808:4: (a5= 'attributes' a6= ':' (a7_0= parse_entity_Attribute ) )
            	    {
            	    // Entity.g:808:4: (a5= 'attributes' a6= ':' (a7_0= parse_entity_Attribute ) )
            	    // Entity.g:809:5: a5= 'attributes' a6= ':' (a7_0= parse_entity_Attribute )
            	    {
            	    a5=(Token)match(input,24,FOLLOW_24_in_parse_entity_Entity473); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    					if (element == null) {
            	    						element = entity.EntityFactory.eINSTANCE.createEntity();
            	    						startIncompleteElement(element);
            	    					}
            	    					collectHiddenTokens(element);
            	    					retrieveLayoutInformation(element, entity.resource.entity.grammar.EntityGrammarInformationProvider.ENTITY_1_0_0_2_0_0_3_0_0_0, null, true);
            	    					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
            	    				}

            	    if ( state.backtracking==0 ) {
            	    					// expected elements (follow set)
            	    					addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[21]);
            	    				}

            	    a6=(Token)match(input,11,FOLLOW_11_in_parse_entity_Entity496); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    					if (element == null) {
            	    						element = entity.EntityFactory.eINSTANCE.createEntity();
            	    						startIncompleteElement(element);
            	    					}
            	    					collectHiddenTokens(element);
            	    					retrieveLayoutInformation(element, entity.resource.entity.grammar.EntityGrammarInformationProvider.ENTITY_1_0_0_2_0_0_3_0_0_1, null, true);
            	    					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
            	    				}

            	    if ( state.backtracking==0 ) {
            	    					// expected elements (follow set)
            	    					addExpectedElement(entity.EntityPackage.eINSTANCE.getEntity(), entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[22]);
            	    				}

            	    // Entity.g:837:5: (a7_0= parse_entity_Attribute )
            	    // Entity.g:838:6: a7_0= parse_entity_Attribute
            	    {
            	    pushFollow(FOLLOW_parse_entity_Attribute_in_parse_entity_Entity526);
            	    a7_0=parse_entity_Attribute();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    						if (terminateParsing) {
            	    							throw new entity.resource.entity.mopp.EntityTerminateParsingException();
            	    						}
            	    						if (element == null) {
            	    							element = entity.EntityFactory.eINSTANCE.createEntity();
            	    							startIncompleteElement(element);
            	    						}
            	    						if (a7_0 != null) {
            	    							if (a7_0 != null) {
            	    								Object value = a7_0;
            	    								addObjectToList(element, entity.EntityPackage.ENTITY__ATTRIBUTES, value);
            	    								completedElement(value, true);
            	    							}
            	    							collectHiddenTokens(element);
            	    							retrieveLayoutInformation(element, entity.resource.entity.grammar.EntityGrammarInformationProvider.ENTITY_1_0_0_2_0_0_3_0_0_2, a7_0, true);
            	    							copyLocalizationInfos(a7_0, element);
            	    						}
            	    					}

            	    }


            	    if ( state.backtracking==0 ) {
            	    					// expected elements (follow set)
            	    					addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[23]);
            	    					addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[24]);
            	    					addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[25]);
            	    				}

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            			// expected elements (follow set)
            			addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[26]);
            			addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[27]);
            			addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[28]);
            		}

            // Entity.g:874:3: ( (a8= 'relations' a9= ':' (a10_0= parse_entity_Relation ) ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==28) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // Entity.g:875:4: (a8= 'relations' a9= ':' (a10_0= parse_entity_Relation ) )
            	    {
            	    // Entity.g:875:4: (a8= 'relations' a9= ':' (a10_0= parse_entity_Relation ) )
            	    // Entity.g:876:5: a8= 'relations' a9= ':' (a10_0= parse_entity_Relation )
            	    {
            	    a8=(Token)match(input,28,FOLLOW_28_in_parse_entity_Entity588); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    					if (element == null) {
            	    						element = entity.EntityFactory.eINSTANCE.createEntity();
            	    						startIncompleteElement(element);
            	    					}
            	    					collectHiddenTokens(element);
            	    					retrieveLayoutInformation(element, entity.resource.entity.grammar.EntityGrammarInformationProvider.ENTITY_1_0_0_2_0_0_4_0_0_0, null, true);
            	    					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a8, element);
            	    				}

            	    if ( state.backtracking==0 ) {
            	    					// expected elements (follow set)
            	    					addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[29]);
            	    				}

            	    a9=(Token)match(input,11,FOLLOW_11_in_parse_entity_Entity611); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    					if (element == null) {
            	    						element = entity.EntityFactory.eINSTANCE.createEntity();
            	    						startIncompleteElement(element);
            	    					}
            	    					collectHiddenTokens(element);
            	    					retrieveLayoutInformation(element, entity.resource.entity.grammar.EntityGrammarInformationProvider.ENTITY_1_0_0_2_0_0_4_0_0_1, null, true);
            	    					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a9, element);
            	    				}

            	    if ( state.backtracking==0 ) {
            	    					// expected elements (follow set)
            	    					addExpectedElement(entity.EntityPackage.eINSTANCE.getEntity(), entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[30]);
            	    				}

            	    // Entity.g:904:5: (a10_0= parse_entity_Relation )
            	    // Entity.g:905:6: a10_0= parse_entity_Relation
            	    {
            	    pushFollow(FOLLOW_parse_entity_Relation_in_parse_entity_Entity641);
            	    a10_0=parse_entity_Relation();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    						if (terminateParsing) {
            	    							throw new entity.resource.entity.mopp.EntityTerminateParsingException();
            	    						}
            	    						if (element == null) {
            	    							element = entity.EntityFactory.eINSTANCE.createEntity();
            	    							startIncompleteElement(element);
            	    						}
            	    						if (a10_0 != null) {
            	    							if (a10_0 != null) {
            	    								Object value = a10_0;
            	    								addObjectToList(element, entity.EntityPackage.ENTITY__RELATIONS, value);
            	    								completedElement(value, true);
            	    							}
            	    							collectHiddenTokens(element);
            	    							retrieveLayoutInformation(element, entity.resource.entity.grammar.EntityGrammarInformationProvider.ENTITY_1_0_0_2_0_0_4_0_0_2, a10_0, true);
            	    							copyLocalizationInfos(a10_0, element);
            	    						}
            	    					}

            	    }


            	    if ( state.backtracking==0 ) {
            	    					// expected elements (follow set)
            	    					addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[31]);
            	    					addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[32]);
            	    				}

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            			// expected elements (follow set)
            			addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[33]);
            			addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[34]);
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[35]);
            	}

            a11=(Token)match(input,30,FOLLOW_30_in_parse_entity_Entity699); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = entity.EntityFactory.eINSTANCE.createEntity();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, entity.resource.entity.grammar.EntityGrammarInformationProvider.ENTITY_1_0_0_3, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a11, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[36]);
            		addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[37]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 3, parse_entity_Entity_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_entity_Entity"



    // $ANTLR start "parse_entity_Attribute"
    // Entity.g:962:1: parse_entity_Attribute returns [entity.Attribute element = null] : a0= 'Attribute' a1= '{' (a2= 'Name' a3= ':' (a4= QUOTED_34_34 ) ( (a5= 'Type' a6= ':' ( (a7= 'String' |a8= 'Float' |a9= 'Integer' |a10= 'Boolean' ) ) ) )* ) a13= '}' ;
    public final entity.Attribute parse_entity_Attribute() throws RecognitionException {
        entity.Attribute element =  null;

        int parse_entity_Attribute_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a5=null;
        Token a6=null;
        Token a7=null;
        Token a8=null;
        Token a9=null;
        Token a10=null;
        Token a13=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return element; }

            // Entity.g:965:2: (a0= 'Attribute' a1= '{' (a2= 'Name' a3= ':' (a4= QUOTED_34_34 ) ( (a5= 'Type' a6= ':' ( (a7= 'String' |a8= 'Float' |a9= 'Integer' |a10= 'Boolean' ) ) ) )* ) a13= '}' )
            // Entity.g:966:2: a0= 'Attribute' a1= '{' (a2= 'Name' a3= ':' (a4= QUOTED_34_34 ) ( (a5= 'Type' a6= ':' ( (a7= 'String' |a8= 'Float' |a9= 'Integer' |a10= 'Boolean' ) ) ) )* ) a13= '}'
            {
            a0=(Token)match(input,12,FOLLOW_12_in_parse_entity_Attribute728); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = entity.EntityFactory.eINSTANCE.createAttribute();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, entity.resource.entity.grammar.EntityGrammarInformationProvider.ENTITY_2_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[38]);
            	}

            a1=(Token)match(input,29,FOLLOW_29_in_parse_entity_Attribute742); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = entity.EntityFactory.eINSTANCE.createAttribute();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, entity.resource.entity.grammar.EntityGrammarInformationProvider.ENTITY_2_0_0_1, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[39]);
            	}

            // Entity.g:994:2: (a2= 'Name' a3= ':' (a4= QUOTED_34_34 ) ( (a5= 'Type' a6= ':' ( (a7= 'String' |a8= 'Float' |a9= 'Integer' |a10= 'Boolean' ) ) ) )* )
            // Entity.g:995:3: a2= 'Name' a3= ':' (a4= QUOTED_34_34 ) ( (a5= 'Type' a6= ':' ( (a7= 'String' |a8= 'Float' |a9= 'Integer' |a10= 'Boolean' ) ) ) )*
            {
            a2=(Token)match(input,18,FOLLOW_18_in_parse_entity_Attribute760); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (element == null) {
            				element = entity.EntityFactory.eINSTANCE.createAttribute();
            				startIncompleteElement(element);
            			}
            			collectHiddenTokens(element);
            			retrieveLayoutInformation(element, entity.resource.entity.grammar.EntityGrammarInformationProvider.ENTITY_2_0_0_2_0_0_0, null, true);
            			copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
            		}

            if ( state.backtracking==0 ) {
            			// expected elements (follow set)
            			addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[40]);
            		}

            a3=(Token)match(input,11,FOLLOW_11_in_parse_entity_Attribute777); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (element == null) {
            				element = entity.EntityFactory.eINSTANCE.createAttribute();
            				startIncompleteElement(element);
            			}
            			collectHiddenTokens(element);
            			retrieveLayoutInformation(element, entity.resource.entity.grammar.EntityGrammarInformationProvider.ENTITY_2_0_0_2_0_0_1, null, true);
            			copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
            		}

            if ( state.backtracking==0 ) {
            			// expected elements (follow set)
            			addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[41]);
            		}

            // Entity.g:1023:3: (a4= QUOTED_34_34 )
            // Entity.g:1024:4: a4= QUOTED_34_34
            {
            a4=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_entity_Attribute799); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            				if (terminateParsing) {
            					throw new entity.resource.entity.mopp.EntityTerminateParsingException();
            				}
            				if (element == null) {
            					element = entity.EntityFactory.eINSTANCE.createAttribute();
            					startIncompleteElement(element);
            				}
            				if (a4 != null) {
            					entity.resource.entity.IEntityTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
            					tokenResolver.setOptions(getOptions());
            					entity.resource.entity.IEntityTokenResolveResult result = getFreshTokenResolveResult();
            					tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(entity.EntityPackage.ATTRIBUTE__NAME), result);
            					Object resolvedObject = result.getResolvedToken();
            					if (resolvedObject == null) {
            						addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a4).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStopIndex());
            					}
            					java.lang.String resolved = (java.lang.String) resolvedObject;
            					if (resolved != null) {
            						Object value = resolved;
            						element.eSet(element.eClass().getEStructuralFeature(entity.EntityPackage.ATTRIBUTE__NAME), value);
            						completedElement(value, false);
            					}
            					collectHiddenTokens(element);
            					retrieveLayoutInformation(element, entity.resource.entity.grammar.EntityGrammarInformationProvider.ENTITY_2_0_0_2_0_0_2, resolved, true);
            					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a4, element);
            				}
            			}

            }


            if ( state.backtracking==0 ) {
            			// expected elements (follow set)
            			addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[42]);
            			addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[43]);
            		}

            // Entity.g:1060:3: ( (a5= 'Type' a6= ':' ( (a7= 'String' |a8= 'Float' |a9= 'Integer' |a10= 'Boolean' ) ) ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==23) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // Entity.g:1061:4: (a5= 'Type' a6= ':' ( (a7= 'String' |a8= 'Float' |a9= 'Integer' |a10= 'Boolean' ) ) )
            	    {
            	    // Entity.g:1061:4: (a5= 'Type' a6= ':' ( (a7= 'String' |a8= 'Float' |a9= 'Integer' |a10= 'Boolean' ) ) )
            	    // Entity.g:1062:5: a5= 'Type' a6= ':' ( (a7= 'String' |a8= 'Float' |a9= 'Integer' |a10= 'Boolean' ) )
            	    {
            	    a5=(Token)match(input,23,FOLLOW_23_in_parse_entity_Attribute837); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    					if (element == null) {
            	    						element = entity.EntityFactory.eINSTANCE.createAttribute();
            	    						startIncompleteElement(element);
            	    					}
            	    					collectHiddenTokens(element);
            	    					retrieveLayoutInformation(element, entity.resource.entity.grammar.EntityGrammarInformationProvider.ENTITY_2_0_0_2_0_0_3_0_0_0, null, true);
            	    					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
            	    				}

            	    if ( state.backtracking==0 ) {
            	    					// expected elements (follow set)
            	    					addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[44]);
            	    				}

            	    a6=(Token)match(input,11,FOLLOW_11_in_parse_entity_Attribute860); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    					if (element == null) {
            	    						element = entity.EntityFactory.eINSTANCE.createAttribute();
            	    						startIncompleteElement(element);
            	    					}
            	    					collectHiddenTokens(element);
            	    					retrieveLayoutInformation(element, entity.resource.entity.grammar.EntityGrammarInformationProvider.ENTITY_2_0_0_2_0_0_3_0_0_1, null, true);
            	    					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
            	    				}

            	    if ( state.backtracking==0 ) {
            	    					// expected elements (follow set)
            	    					addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[45]);
            	    				}

            	    // Entity.g:1090:5: ( (a7= 'String' |a8= 'Float' |a9= 'Integer' |a10= 'Boolean' ) )
            	    // Entity.g:1091:6: (a7= 'String' |a8= 'Float' |a9= 'Integer' |a10= 'Boolean' )
            	    {
            	    // Entity.g:1091:6: (a7= 'String' |a8= 'Float' |a9= 'Integer' |a10= 'Boolean' )
            	    int alt4=4;
            	    switch ( input.LA(1) ) {
            	    case 21:
            	        {
            	        alt4=1;
            	        }
            	        break;
            	    case 15:
            	        {
            	        alt4=2;
            	        }
            	        break;
            	    case 16:
            	        {
            	        alt4=3;
            	        }
            	        break;
            	    case 13:
            	        {
            	        alt4=4;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return element;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 4, 0, input);

            	        throw nvae;

            	    }

            	    switch (alt4) {
            	        case 1 :
            	            // Entity.g:1092:7: a7= 'String'
            	            {
            	            a7=(Token)match(input,21,FOLLOW_21_in_parse_entity_Attribute898); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            							if (element == null) {
            	            								element = entity.EntityFactory.eINSTANCE.createAttribute();
            	            								startIncompleteElement(element);
            	            							}
            	            							collectHiddenTokens(element);
            	            							retrieveLayoutInformation(element, entity.resource.entity.grammar.EntityGrammarInformationProvider.ENTITY_2_0_0_2_0_0_3_0_0_2, null, true);
            	            							copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a7, element);
            	            							// set value of enumeration attribute
            	            							Object value = entity.EntityPackage.eINSTANCE.getAttributeType().getEEnumLiteral(entity.AttributeType.STRING_VALUE).getInstance();
            	            							element.eSet(element.eClass().getEStructuralFeature(entity.EntityPackage.ATTRIBUTE__TYPE), value);
            	            							completedElement(value, false);
            	            						}

            	            }
            	            break;
            	        case 2 :
            	            // Entity.g:1105:14: a8= 'Float'
            	            {
            	            a8=(Token)match(input,15,FOLLOW_15_in_parse_entity_Attribute919); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            							if (element == null) {
            	            								element = entity.EntityFactory.eINSTANCE.createAttribute();
            	            								startIncompleteElement(element);
            	            							}
            	            							collectHiddenTokens(element);
            	            							retrieveLayoutInformation(element, entity.resource.entity.grammar.EntityGrammarInformationProvider.ENTITY_2_0_0_2_0_0_3_0_0_2, null, true);
            	            							copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a8, element);
            	            							// set value of enumeration attribute
            	            							Object value = entity.EntityPackage.eINSTANCE.getAttributeType().getEEnumLiteral(entity.AttributeType.FLOAT_VALUE).getInstance();
            	            							element.eSet(element.eClass().getEStructuralFeature(entity.EntityPackage.ATTRIBUTE__TYPE), value);
            	            							completedElement(value, false);
            	            						}

            	            }
            	            break;
            	        case 3 :
            	            // Entity.g:1118:14: a9= 'Integer'
            	            {
            	            a9=(Token)match(input,16,FOLLOW_16_in_parse_entity_Attribute940); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            							if (element == null) {
            	            								element = entity.EntityFactory.eINSTANCE.createAttribute();
            	            								startIncompleteElement(element);
            	            							}
            	            							collectHiddenTokens(element);
            	            							retrieveLayoutInformation(element, entity.resource.entity.grammar.EntityGrammarInformationProvider.ENTITY_2_0_0_2_0_0_3_0_0_2, null, true);
            	            							copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a9, element);
            	            							// set value of enumeration attribute
            	            							Object value = entity.EntityPackage.eINSTANCE.getAttributeType().getEEnumLiteral(entity.AttributeType.INTEGER_VALUE).getInstance();
            	            							element.eSet(element.eClass().getEStructuralFeature(entity.EntityPackage.ATTRIBUTE__TYPE), value);
            	            							completedElement(value, false);
            	            						}

            	            }
            	            break;
            	        case 4 :
            	            // Entity.g:1131:14: a10= 'Boolean'
            	            {
            	            a10=(Token)match(input,13,FOLLOW_13_in_parse_entity_Attribute961); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            							if (element == null) {
            	            								element = entity.EntityFactory.eINSTANCE.createAttribute();
            	            								startIncompleteElement(element);
            	            							}
            	            							collectHiddenTokens(element);
            	            							retrieveLayoutInformation(element, entity.resource.entity.grammar.EntityGrammarInformationProvider.ENTITY_2_0_0_2_0_0_3_0_0_2, null, true);
            	            							copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a10, element);
            	            							// set value of enumeration attribute
            	            							Object value = entity.EntityPackage.eINSTANCE.getAttributeType().getEEnumLiteral(entity.AttributeType.BOOLEAN_VALUE).getInstance();
            	            							element.eSet(element.eClass().getEStructuralFeature(entity.EntityPackage.ATTRIBUTE__TYPE), value);
            	            							completedElement(value, false);
            	            						}

            	            }
            	            break;

            	    }


            	    }


            	    if ( state.backtracking==0 ) {
            	    					// expected elements (follow set)
            	    					addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[46]);
            	    					addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[47]);
            	    				}

            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            			// expected elements (follow set)
            			addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[48]);
            			addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[49]);
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[50]);
            	}

            a13=(Token)match(input,30,FOLLOW_30_in_parse_entity_Attribute1022); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = entity.EntityFactory.eINSTANCE.createAttribute();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, entity.resource.entity.grammar.EntityGrammarInformationProvider.ENTITY_2_0_0_3, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a13, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[51]);
            		addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[52]);
            		addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[53]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 4, parse_entity_Attribute_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_entity_Attribute"



    // $ANTLR start "parse_entity_Relation"
    // Entity.g:1184:1: parse_entity_Relation returns [entity.Relation element = null] : a0= 'Relation' a1= '{' (a2= 'Name' a3= ':' (a4= QUOTED_34_34 ) a5= 'Type' a6= ':' ( (a7= 'one' |a8= 'many' ) ) ( (a11= 'RelEntity' a12= ':' (a13= TEXT ) ) )* ) a14= '}' ;
    public final entity.Relation parse_entity_Relation() throws RecognitionException {
        entity.Relation element =  null;

        int parse_entity_Relation_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a5=null;
        Token a6=null;
        Token a7=null;
        Token a8=null;
        Token a11=null;
        Token a12=null;
        Token a13=null;
        Token a14=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return element; }

            // Entity.g:1187:2: (a0= 'Relation' a1= '{' (a2= 'Name' a3= ':' (a4= QUOTED_34_34 ) a5= 'Type' a6= ':' ( (a7= 'one' |a8= 'many' ) ) ( (a11= 'RelEntity' a12= ':' (a13= TEXT ) ) )* ) a14= '}' )
            // Entity.g:1188:2: a0= 'Relation' a1= '{' (a2= 'Name' a3= ':' (a4= QUOTED_34_34 ) a5= 'Type' a6= ':' ( (a7= 'one' |a8= 'many' ) ) ( (a11= 'RelEntity' a12= ':' (a13= TEXT ) ) )* ) a14= '}'
            {
            a0=(Token)match(input,20,FOLLOW_20_in_parse_entity_Relation1051); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = entity.EntityFactory.eINSTANCE.createRelation();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, entity.resource.entity.grammar.EntityGrammarInformationProvider.ENTITY_3_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[54]);
            	}

            a1=(Token)match(input,29,FOLLOW_29_in_parse_entity_Relation1065); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = entity.EntityFactory.eINSTANCE.createRelation();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, entity.resource.entity.grammar.EntityGrammarInformationProvider.ENTITY_3_0_0_1, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[55]);
            	}

            // Entity.g:1216:2: (a2= 'Name' a3= ':' (a4= QUOTED_34_34 ) a5= 'Type' a6= ':' ( (a7= 'one' |a8= 'many' ) ) ( (a11= 'RelEntity' a12= ':' (a13= TEXT ) ) )* )
            // Entity.g:1217:3: a2= 'Name' a3= ':' (a4= QUOTED_34_34 ) a5= 'Type' a6= ':' ( (a7= 'one' |a8= 'many' ) ) ( (a11= 'RelEntity' a12= ':' (a13= TEXT ) ) )*
            {
            a2=(Token)match(input,18,FOLLOW_18_in_parse_entity_Relation1083); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (element == null) {
            				element = entity.EntityFactory.eINSTANCE.createRelation();
            				startIncompleteElement(element);
            			}
            			collectHiddenTokens(element);
            			retrieveLayoutInformation(element, entity.resource.entity.grammar.EntityGrammarInformationProvider.ENTITY_3_0_0_2_0_0_0, null, true);
            			copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
            		}

            if ( state.backtracking==0 ) {
            			// expected elements (follow set)
            			addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[56]);
            		}

            a3=(Token)match(input,11,FOLLOW_11_in_parse_entity_Relation1100); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (element == null) {
            				element = entity.EntityFactory.eINSTANCE.createRelation();
            				startIncompleteElement(element);
            			}
            			collectHiddenTokens(element);
            			retrieveLayoutInformation(element, entity.resource.entity.grammar.EntityGrammarInformationProvider.ENTITY_3_0_0_2_0_0_1, null, true);
            			copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
            		}

            if ( state.backtracking==0 ) {
            			// expected elements (follow set)
            			addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[57]);
            		}

            // Entity.g:1245:3: (a4= QUOTED_34_34 )
            // Entity.g:1246:4: a4= QUOTED_34_34
            {
            a4=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_entity_Relation1122); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            				if (terminateParsing) {
            					throw new entity.resource.entity.mopp.EntityTerminateParsingException();
            				}
            				if (element == null) {
            					element = entity.EntityFactory.eINSTANCE.createRelation();
            					startIncompleteElement(element);
            				}
            				if (a4 != null) {
            					entity.resource.entity.IEntityTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
            					tokenResolver.setOptions(getOptions());
            					entity.resource.entity.IEntityTokenResolveResult result = getFreshTokenResolveResult();
            					tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(entity.EntityPackage.RELATION__NAME), result);
            					Object resolvedObject = result.getResolvedToken();
            					if (resolvedObject == null) {
            						addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a4).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStopIndex());
            					}
            					java.lang.String resolved = (java.lang.String) resolvedObject;
            					if (resolved != null) {
            						Object value = resolved;
            						element.eSet(element.eClass().getEStructuralFeature(entity.EntityPackage.RELATION__NAME), value);
            						completedElement(value, false);
            					}
            					collectHiddenTokens(element);
            					retrieveLayoutInformation(element, entity.resource.entity.grammar.EntityGrammarInformationProvider.ENTITY_3_0_0_2_0_0_2, resolved, true);
            					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a4, element);
            				}
            			}

            }


            if ( state.backtracking==0 ) {
            			// expected elements (follow set)
            			addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[58]);
            		}

            a5=(Token)match(input,23,FOLLOW_23_in_parse_entity_Relation1149); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (element == null) {
            				element = entity.EntityFactory.eINSTANCE.createRelation();
            				startIncompleteElement(element);
            			}
            			collectHiddenTokens(element);
            			retrieveLayoutInformation(element, entity.resource.entity.grammar.EntityGrammarInformationProvider.ENTITY_3_0_0_2_0_0_3, null, true);
            			copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
            		}

            if ( state.backtracking==0 ) {
            			// expected elements (follow set)
            			addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[59]);
            		}

            a6=(Token)match(input,11,FOLLOW_11_in_parse_entity_Relation1166); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (element == null) {
            				element = entity.EntityFactory.eINSTANCE.createRelation();
            				startIncompleteElement(element);
            			}
            			collectHiddenTokens(element);
            			retrieveLayoutInformation(element, entity.resource.entity.grammar.EntityGrammarInformationProvider.ENTITY_3_0_0_2_0_0_4, null, true);
            			copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
            		}

            if ( state.backtracking==0 ) {
            			// expected elements (follow set)
            			addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[60]);
            		}

            // Entity.g:1309:3: ( (a7= 'one' |a8= 'many' ) )
            // Entity.g:1310:4: (a7= 'one' |a8= 'many' )
            {
            // Entity.g:1310:4: (a7= 'one' |a8= 'many' )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==27) ) {
                alt6=1;
            }
            else if ( (LA6_0==26) ) {
                alt6=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;

            }
            switch (alt6) {
                case 1 :
                    // Entity.g:1311:5: a7= 'one'
                    {
                    a7=(Token)match(input,27,FOLLOW_27_in_parse_entity_Relation1194); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    					if (element == null) {
                    						element = entity.EntityFactory.eINSTANCE.createRelation();
                    						startIncompleteElement(element);
                    					}
                    					collectHiddenTokens(element);
                    					retrieveLayoutInformation(element, entity.resource.entity.grammar.EntityGrammarInformationProvider.ENTITY_3_0_0_2_0_0_5, null, true);
                    					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a7, element);
                    					// set value of enumeration attribute
                    					Object value = entity.EntityPackage.eINSTANCE.getRelationType().getEEnumLiteral(entity.RelationType.ONE_VALUE).getInstance();
                    					element.eSet(element.eClass().getEStructuralFeature(entity.EntityPackage.RELATION__TYPE), value);
                    					completedElement(value, false);
                    				}

                    }
                    break;
                case 2 :
                    // Entity.g:1324:10: a8= 'many'
                    {
                    a8=(Token)match(input,26,FOLLOW_26_in_parse_entity_Relation1211); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    					if (element == null) {
                    						element = entity.EntityFactory.eINSTANCE.createRelation();
                    						startIncompleteElement(element);
                    					}
                    					collectHiddenTokens(element);
                    					retrieveLayoutInformation(element, entity.resource.entity.grammar.EntityGrammarInformationProvider.ENTITY_3_0_0_2_0_0_5, null, true);
                    					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a8, element);
                    					// set value of enumeration attribute
                    					Object value = entity.EntityPackage.eINSTANCE.getRelationType().getEEnumLiteral(entity.RelationType.MANY_VALUE).getInstance();
                    					element.eSet(element.eClass().getEStructuralFeature(entity.EntityPackage.RELATION__TYPE), value);
                    					completedElement(value, false);
                    				}

                    }
                    break;

            }


            }


            if ( state.backtracking==0 ) {
            			// expected elements (follow set)
            			addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[61]);
            			addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[62]);
            		}

            // Entity.g:1345:3: ( (a11= 'RelEntity' a12= ':' (a13= TEXT ) ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==19) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // Entity.g:1346:4: (a11= 'RelEntity' a12= ':' (a13= TEXT ) )
            	    {
            	    // Entity.g:1346:4: (a11= 'RelEntity' a12= ':' (a13= TEXT ) )
            	    // Entity.g:1347:5: a11= 'RelEntity' a12= ':' (a13= TEXT )
            	    {
            	    a11=(Token)match(input,19,FOLLOW_19_in_parse_entity_Relation1248); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    					if (element == null) {
            	    						element = entity.EntityFactory.eINSTANCE.createRelation();
            	    						startIncompleteElement(element);
            	    					}
            	    					collectHiddenTokens(element);
            	    					retrieveLayoutInformation(element, entity.resource.entity.grammar.EntityGrammarInformationProvider.ENTITY_3_0_0_2_0_0_6_0_0_0, null, true);
            	    					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a11, element);
            	    				}

            	    if ( state.backtracking==0 ) {
            	    					// expected elements (follow set)
            	    					addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[63]);
            	    				}

            	    a12=(Token)match(input,11,FOLLOW_11_in_parse_entity_Relation1271); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    					if (element == null) {
            	    						element = entity.EntityFactory.eINSTANCE.createRelation();
            	    						startIncompleteElement(element);
            	    					}
            	    					collectHiddenTokens(element);
            	    					retrieveLayoutInformation(element, entity.resource.entity.grammar.EntityGrammarInformationProvider.ENTITY_3_0_0_2_0_0_6_0_0_1, null, true);
            	    					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a12, element);
            	    				}

            	    if ( state.backtracking==0 ) {
            	    					// expected elements (follow set)
            	    					addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[64]);
            	    				}

            	    // Entity.g:1375:5: (a13= TEXT )
            	    // Entity.g:1376:6: a13= TEXT
            	    {
            	    a13=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_entity_Relation1301); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    						if (terminateParsing) {
            	    							throw new entity.resource.entity.mopp.EntityTerminateParsingException();
            	    						}
            	    						if (element == null) {
            	    							element = entity.EntityFactory.eINSTANCE.createRelation();
            	    							startIncompleteElement(element);
            	    						}
            	    						if (a13 != null) {
            	    							entity.resource.entity.IEntityTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            	    							tokenResolver.setOptions(getOptions());
            	    							entity.resource.entity.IEntityTokenResolveResult result = getFreshTokenResolveResult();
            	    							tokenResolver.resolve(a13.getText(), element.eClass().getEStructuralFeature(entity.EntityPackage.RELATION__REL_ENTITY), result);
            	    							Object resolvedObject = result.getResolvedToken();
            	    							if (resolvedObject == null) {
            	    								addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a13).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a13).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a13).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a13).getStopIndex());
            	    							}
            	    							String resolved = (String) resolvedObject;
            	    							entity.Entity proxy = entity.EntityFactory.eINSTANCE.createEntity();
            	    							collectHiddenTokens(element);
            	    							registerContextDependentProxy(new entity.resource.entity.mopp.EntityContextDependentURIFragmentFactory<entity.Relation, entity.Entity>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getRelationRelEntityReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(entity.EntityPackage.RELATION__REL_ENTITY), resolved, proxy);
            	    							if (proxy != null) {
            	    								Object value = proxy;
            	    								element.eSet(element.eClass().getEStructuralFeature(entity.EntityPackage.RELATION__REL_ENTITY), value);
            	    								completedElement(value, false);
            	    							}
            	    							collectHiddenTokens(element);
            	    							retrieveLayoutInformation(element, entity.resource.entity.grammar.EntityGrammarInformationProvider.ENTITY_3_0_0_2_0_0_6_0_0_2, proxy, true);
            	    							copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a13, element);
            	    							copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a13, proxy);
            	    						}
            	    					}

            	    }


            	    if ( state.backtracking==0 ) {
            	    					// expected elements (follow set)
            	    					addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[65]);
            	    					addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[66]);
            	    				}

            	    }


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            			// expected elements (follow set)
            			addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[67]);
            			addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[68]);
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[69]);
            	}

            a14=(Token)match(input,30,FOLLOW_30_in_parse_entity_Relation1365); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = entity.EntityFactory.eINSTANCE.createRelation();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, entity.resource.entity.grammar.EntityGrammarInformationProvider.ENTITY_3_0_0_3, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a14, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[70]);
            		addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[71]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 5, parse_entity_Relation_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_entity_Relation"

    // Delegated rules


 

    public static final BitSet FOLLOW_parse_entity_Model_in_start82 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_start89 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_parse_entity_Model115 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_parse_entity_Model129 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_parse_entity_Model147 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_parse_entity_Model164 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_entity_Model186 = new BitSet(new long[]{0x0000000042000000L});
    public static final BitSet FOLLOW_25_in_parse_entity_Model224 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_parse_entity_Model247 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_parse_entity_Entity_in_parse_entity_Model277 = new BitSet(new long[]{0x0000000042000000L});
    public static final BitSet FOLLOW_30_in_parse_entity_Model335 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_parse_entity_Entity364 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_parse_entity_Entity378 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_parse_entity_Entity396 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_parse_entity_Entity413 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_entity_Entity435 = new BitSet(new long[]{0x0000000051000000L});
    public static final BitSet FOLLOW_24_in_parse_entity_Entity473 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_parse_entity_Entity496 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_parse_entity_Attribute_in_parse_entity_Entity526 = new BitSet(new long[]{0x0000000051000000L});
    public static final BitSet FOLLOW_28_in_parse_entity_Entity588 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_parse_entity_Entity611 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_parse_entity_Relation_in_parse_entity_Entity641 = new BitSet(new long[]{0x0000000050000000L});
    public static final BitSet FOLLOW_30_in_parse_entity_Entity699 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_parse_entity_Attribute728 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_parse_entity_Attribute742 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_parse_entity_Attribute760 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_parse_entity_Attribute777 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_entity_Attribute799 = new BitSet(new long[]{0x0000000040800000L});
    public static final BitSet FOLLOW_23_in_parse_entity_Attribute837 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_parse_entity_Attribute860 = new BitSet(new long[]{0x000000000021A000L});
    public static final BitSet FOLLOW_21_in_parse_entity_Attribute898 = new BitSet(new long[]{0x0000000040800000L});
    public static final BitSet FOLLOW_15_in_parse_entity_Attribute919 = new BitSet(new long[]{0x0000000040800000L});
    public static final BitSet FOLLOW_16_in_parse_entity_Attribute940 = new BitSet(new long[]{0x0000000040800000L});
    public static final BitSet FOLLOW_13_in_parse_entity_Attribute961 = new BitSet(new long[]{0x0000000040800000L});
    public static final BitSet FOLLOW_30_in_parse_entity_Attribute1022 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_parse_entity_Relation1051 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_parse_entity_Relation1065 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_parse_entity_Relation1083 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_parse_entity_Relation1100 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_entity_Relation1122 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_parse_entity_Relation1149 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_parse_entity_Relation1166 = new BitSet(new long[]{0x000000000C000000L});
    public static final BitSet FOLLOW_27_in_parse_entity_Relation1194 = new BitSet(new long[]{0x0000000040080000L});
    public static final BitSet FOLLOW_26_in_parse_entity_Relation1211 = new BitSet(new long[]{0x0000000040080000L});
    public static final BitSet FOLLOW_19_in_parse_entity_Relation1248 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_parse_entity_Relation1271 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_TEXT_in_parse_entity_Relation1301 = new BitSet(new long[]{0x0000000040080000L});
    public static final BitSet FOLLOW_30_in_parse_entity_Relation1365 = new BitSet(new long[]{0x0000000000000002L});

}