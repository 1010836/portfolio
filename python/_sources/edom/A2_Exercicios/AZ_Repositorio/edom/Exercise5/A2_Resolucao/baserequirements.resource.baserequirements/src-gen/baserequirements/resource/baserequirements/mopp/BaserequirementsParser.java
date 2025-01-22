// $ANTLR 3.4

	package baserequirements.resource.baserequirements.mopp;


import org.antlr.runtime3_4_0.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class BaserequirementsParser extends BaserequirementsANTLRParserBase {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "COMMENT", "FLOAT", "LINEBREAK", "QUOTED_34_34", "TEXT", "WHITESPACE", "':'", "'ACCEPTED'", "'APPROVED'", "'Comment'", "'FUNCTIONAL'", "'HIGH'", "'IMPLEMENTED'", "'INVALID'", "'LATER'", "'LOW'", "'MEDIUM'", "'Model'", "'NEW'", "'NONFUNCTIONAL'", "'RESOLVED'", "'REVIEWED'", "'Requirement'", "'RequirementGroup'", "'Version'", "'author'", "'body'", "'children'", "'comments'", "'created'", "'dependencies'", "'description'", "'groups'", "'id'", "'major'", "'minor'", "'name'", "'parent'", "'priority'", "'requirements'", "'resolution'", "'service'", "'state'", "'subject'", "'title'", "'type'", "'version'", "'{'", "'}'"
    };

    public static final int EOF=-1;
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
    public static final int T__52=52;
    public static final int COMMENT=4;
    public static final int FLOAT=5;
    public static final int LINEBREAK=6;
    public static final int QUOTED_34_34=7;
    public static final int TEXT=8;
    public static final int WHITESPACE=9;

    // delegates
    public BaserequirementsANTLRParserBase[] getDelegates() {
        return new BaserequirementsANTLRParserBase[] {};
    }

    // delegators


    public BaserequirementsParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public BaserequirementsParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
        this.state.initializeRuleMemo(34 + 1);
         

    }

    public String[] getTokenNames() { return BaserequirementsParser.tokenNames; }
    public String getGrammarFileName() { return "Baserequirements.g"; }


    	private baserequirements.resource.baserequirements.IBaserequirementsTokenResolverFactory tokenResolverFactory = new baserequirements.resource.baserequirements.mopp.BaserequirementsTokenResolverFactory();
    	
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
    	private java.util.List<baserequirements.resource.baserequirements.mopp.BaserequirementsExpectedTerminal> expectedElements = new java.util.ArrayList<baserequirements.resource.baserequirements.mopp.BaserequirementsExpectedTerminal>();
    	
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
    		postParseCommands.add(new baserequirements.resource.baserequirements.IBaserequirementsCommand<baserequirements.resource.baserequirements.IBaserequirementsTextResource>() {
    			public boolean execute(baserequirements.resource.baserequirements.IBaserequirementsTextResource resource) {
    				if (resource == null) {
    					// the resource can be null if the parser is used for code completion
    					return true;
    				}
    				resource.addProblem(new baserequirements.resource.baserequirements.IBaserequirementsProblem() {
    					public baserequirements.resource.baserequirements.BaserequirementsEProblemSeverity getSeverity() {
    						return baserequirements.resource.baserequirements.BaserequirementsEProblemSeverity.ERROR;
    					}
    					public baserequirements.resource.baserequirements.BaserequirementsEProblemType getType() {
    						return baserequirements.resource.baserequirements.BaserequirementsEProblemType.SYNTAX_ERROR;
    					}
    					public String getMessage() {
    						return errorMessage;
    					}
    					public java.util.Collection<baserequirements.resource.baserequirements.IBaserequirementsQuickFix> getQuickFixes() {
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
    		baserequirements.resource.baserequirements.IBaserequirementsExpectedElement terminal = baserequirements.resource.baserequirements.grammar.BaserequirementsFollowSetProvider.TERMINALS[terminalID];
    		baserequirements.resource.baserequirements.mopp.BaserequirementsContainedFeature[] containmentFeatures = new baserequirements.resource.baserequirements.mopp.BaserequirementsContainedFeature[ids.length - 2];
    		for (int i = 2; i < ids.length; i++) {
    			containmentFeatures[i - 2] = baserequirements.resource.baserequirements.grammar.BaserequirementsFollowSetProvider.LINKS[ids[i]];
    		}
    		baserequirements.resource.baserequirements.grammar.BaserequirementsContainmentTrace containmentTrace = new baserequirements.resource.baserequirements.grammar.BaserequirementsContainmentTrace(eClass, containmentFeatures);
    		org.eclipse.emf.ecore.EObject container = getLastIncompleteElement();
    		baserequirements.resource.baserequirements.mopp.BaserequirementsExpectedTerminal expectedElement = new baserequirements.resource.baserequirements.mopp.BaserequirementsExpectedTerminal(container, terminal, followSetID, containmentTrace);
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
    		postParseCommands.add(new baserequirements.resource.baserequirements.IBaserequirementsCommand<baserequirements.resource.baserequirements.IBaserequirementsTextResource>() {
    			public boolean execute(baserequirements.resource.baserequirements.IBaserequirementsTextResource resource) {
    				baserequirements.resource.baserequirements.IBaserequirementsLocationMap locationMap = resource.getLocationMap();
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
    		postParseCommands.add(new baserequirements.resource.baserequirements.IBaserequirementsCommand<baserequirements.resource.baserequirements.IBaserequirementsTextResource>() {
    			public boolean execute(baserequirements.resource.baserequirements.IBaserequirementsTextResource resource) {
    				baserequirements.resource.baserequirements.IBaserequirementsLocationMap locationMap = resource.getLocationMap();
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
    	protected void setLocalizationEnd(java.util.Collection<baserequirements.resource.baserequirements.IBaserequirementsCommand<baserequirements.resource.baserequirements.IBaserequirementsTextResource>> postParseCommands , final org.eclipse.emf.ecore.EObject object, final int endChar, final int endLine) {
    		if (disableLocationMap) {
    			return;
    		}
    		postParseCommands.add(new baserequirements.resource.baserequirements.IBaserequirementsCommand<baserequirements.resource.baserequirements.IBaserequirementsTextResource>() {
    			public boolean execute(baserequirements.resource.baserequirements.IBaserequirementsTextResource resource) {
    				baserequirements.resource.baserequirements.IBaserequirementsLocationMap locationMap = resource.getLocationMap();
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
    	
    	public baserequirements.resource.baserequirements.IBaserequirementsTextParser createInstance(java.io.InputStream actualInputStream, String encoding) {
    		try {
    			if (encoding == null) {
    				return new BaserequirementsParser(new org.antlr.runtime3_4_0.CommonTokenStream(new BaserequirementsLexer(new org.antlr.runtime3_4_0.ANTLRInputStream(actualInputStream))));
    			} else {
    				return new BaserequirementsParser(new org.antlr.runtime3_4_0.CommonTokenStream(new BaserequirementsLexer(new org.antlr.runtime3_4_0.ANTLRInputStream(actualInputStream, encoding))));
    			}
    		} catch (java.io.IOException e) {
    			new baserequirements.resource.baserequirements.util.BaserequirementsRuntimeUtil().logError("Error while creating parser.", e);
    			return null;
    		}
    	}
    	
    	/**
    	 * This default constructor is only used to call createInstance() on it.
    	 */
    	public BaserequirementsParser() {
    		super(null);
    	}
    	
    	protected org.eclipse.emf.ecore.EObject doParse() throws org.antlr.runtime3_4_0.RecognitionException {
    		this.lastPosition = 0;
    		// required because the lexer class can not be subclassed
    		((BaserequirementsLexer) getTokenStream().getTokenSource()).lexerExceptions = lexerExceptions;
    		((BaserequirementsLexer) getTokenStream().getTokenSource()).lexerExceptionsPosition = lexerExceptionsPosition;
    		Object typeObject = getTypeObject();
    		if (typeObject == null) {
    			return start();
    		} else if (typeObject instanceof org.eclipse.emf.ecore.EClass) {
    			org.eclipse.emf.ecore.EClass type = (org.eclipse.emf.ecore.EClass) typeObject;
    			if (type.getInstanceClass() == baserequirements.Model.class) {
    				return parse_baserequirements_Model();
    			}
    			if (type.getInstanceClass() == baserequirements.RequirementGroup.class) {
    				return parse_baserequirements_RequirementGroup();
    			}
    			if (type.getInstanceClass() == baserequirements.Requirement.class) {
    				return parse_baserequirements_Requirement();
    			}
    			if (type.getInstanceClass() == baserequirements.Version.class) {
    				return parse_baserequirements_Version();
    			}
    			if (type.getInstanceClass() == baserequirements.Comment.class) {
    				return parse_baserequirements_Comment();
    			}
    		}
    		throw new baserequirements.resource.baserequirements.mopp.BaserequirementsUnexpectedContentTypeException(typeObject);
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
    			typeObject = options.get(baserequirements.resource.baserequirements.IBaserequirementsOptions.RESOURCE_CONTENT_TYPE);
    		}
    		return typeObject;
    	}
    	
    	/**
    	 * Implementation that calls {@link #doParse()} and handles the thrown
    	 * RecognitionExceptions.
    	 */
    	public baserequirements.resource.baserequirements.IBaserequirementsParseResult parse() {
    		terminateParsing = false;
    		postParseCommands = new java.util.ArrayList<baserequirements.resource.baserequirements.IBaserequirementsCommand<baserequirements.resource.baserequirements.IBaserequirementsTextResource>>();
    		baserequirements.resource.baserequirements.mopp.BaserequirementsParseResult parseResult = new baserequirements.resource.baserequirements.mopp.BaserequirementsParseResult();
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
    	
    	public java.util.List<baserequirements.resource.baserequirements.mopp.BaserequirementsExpectedTerminal> parseToExpectedElements(org.eclipse.emf.ecore.EClass type, baserequirements.resource.baserequirements.IBaserequirementsTextResource dummyResource, int cursorOffset) {
    		this.rememberExpectedElements = true;
    		this.parseToIndexTypeObject = type;
    		this.cursorOffset = cursorOffset;
    		this.lastStartIncludingHidden = -1;
    		final org.antlr.runtime3_4_0.CommonTokenStream tokenStream = (org.antlr.runtime3_4_0.CommonTokenStream) getTokenStream();
    		baserequirements.resource.baserequirements.IBaserequirementsParseResult result = parse();
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
    			for (baserequirements.resource.baserequirements.IBaserequirementsCommand<baserequirements.resource.baserequirements.IBaserequirementsTextResource> command : result.getPostParseCommands()) {
    				command.execute(dummyResource);
    			}
    		}
    		// remove all expected elements that were added after the last complete element
    		expectedElements = expectedElements.subList(0, expectedElementsIndexOfLastCompleteElement + 1);
    		int lastFollowSetID = expectedElements.get(expectedElementsIndexOfLastCompleteElement).getFollowSetID();
    		java.util.Set<baserequirements.resource.baserequirements.mopp.BaserequirementsExpectedTerminal> currentFollowSet = new java.util.LinkedHashSet<baserequirements.resource.baserequirements.mopp.BaserequirementsExpectedTerminal>();
    		java.util.List<baserequirements.resource.baserequirements.mopp.BaserequirementsExpectedTerminal> newFollowSet = new java.util.ArrayList<baserequirements.resource.baserequirements.mopp.BaserequirementsExpectedTerminal>();
    		for (int i = expectedElementsIndexOfLastCompleteElement; i >= 0; i--) {
    			baserequirements.resource.baserequirements.mopp.BaserequirementsExpectedTerminal expectedElementI = expectedElements.get(i);
    			if (expectedElementI.getFollowSetID() == lastFollowSetID) {
    				currentFollowSet.add(expectedElementI);
    			} else {
    				break;
    			}
    		}
    		int followSetID = 136;
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
    				for (baserequirements.resource.baserequirements.mopp.BaserequirementsExpectedTerminal nextFollow : newFollowSet) {
    					lastTokenIndex = 0;
    					setPosition(nextFollow, i);
    				}
    				newFollowSet.clear();
    				// normal tokens do reduce the follow set - only elements that match the token are
    				// kept
    				for (baserequirements.resource.baserequirements.mopp.BaserequirementsExpectedTerminal nextFollow : currentFollowSet) {
    					if (nextFollow.getTerminal().getTokenNames().contains(getTokenNames()[nextToken.getType()])) {
    						// keep this one - it matches
    						java.util.Collection<baserequirements.resource.baserequirements.util.BaserequirementsPair<baserequirements.resource.baserequirements.IBaserequirementsExpectedElement, baserequirements.resource.baserequirements.mopp.BaserequirementsContainedFeature[]>> newFollowers = nextFollow.getTerminal().getFollowers();
    						for (baserequirements.resource.baserequirements.util.BaserequirementsPair<baserequirements.resource.baserequirements.IBaserequirementsExpectedElement, baserequirements.resource.baserequirements.mopp.BaserequirementsContainedFeature[]> newFollowerPair : newFollowers) {
    							baserequirements.resource.baserequirements.IBaserequirementsExpectedElement newFollower = newFollowerPair.getLeft();
    							org.eclipse.emf.ecore.EObject container = getLastIncompleteElement();
    							baserequirements.resource.baserequirements.grammar.BaserequirementsContainmentTrace containmentTrace = new baserequirements.resource.baserequirements.grammar.BaserequirementsContainmentTrace(null, newFollowerPair.getRight());
    							baserequirements.resource.baserequirements.mopp.BaserequirementsExpectedTerminal newFollowTerminal = new baserequirements.resource.baserequirements.mopp.BaserequirementsExpectedTerminal(container, newFollower, followSetID, containmentTrace);
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
    		for (baserequirements.resource.baserequirements.mopp.BaserequirementsExpectedTerminal nextFollow : newFollowSet) {
    			lastTokenIndex = 0;
    			setPosition(nextFollow, i);
    		}
    		return this.expectedElements;
    	}
    	
    	public void setPosition(baserequirements.resource.baserequirements.mopp.BaserequirementsExpectedTerminal expectedElement, int tokenIndex) {
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
    // Baserequirements.g:511:1: start returns [ org.eclipse.emf.ecore.EObject element = null] : (c0= parse_baserequirements_Model ) EOF ;
    public final org.eclipse.emf.ecore.EObject start() throws RecognitionException {
        org.eclipse.emf.ecore.EObject element =  null;

        int start_StartIndex = input.index();

        baserequirements.Model c0 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return element; }

            // Baserequirements.g:512:2: ( (c0= parse_baserequirements_Model ) EOF )
            // Baserequirements.g:513:2: (c0= parse_baserequirements_Model ) EOF
            {
            if ( state.backtracking==0 ) {
            		// follow set for start rule(s)
            		addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[0]);
            		expectedElementsIndexOfLastCompleteElement = 0;
            	}

            // Baserequirements.g:518:2: (c0= parse_baserequirements_Model )
            // Baserequirements.g:519:3: c0= parse_baserequirements_Model
            {
            pushFollow(FOLLOW_parse_baserequirements_Model_in_start82);
            c0=parse_baserequirements_Model();

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



    // $ANTLR start "parse_baserequirements_Model"
    // Baserequirements.g:527:1: parse_baserequirements_Model returns [baserequirements.Model element = null] : a0= 'Model' a1= '{' (a2= 'title' a3= ':' (a4= QUOTED_34_34 ) ( (a5= 'groups' a6= ':' (a7_0= parse_baserequirements_RequirementGroup ) ) )* ) a8= '}' ;
    public final baserequirements.Model parse_baserequirements_Model() throws RecognitionException {
        baserequirements.Model element =  null;

        int parse_baserequirements_Model_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a5=null;
        Token a6=null;
        Token a8=null;
        baserequirements.RequirementGroup a7_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return element; }

            // Baserequirements.g:530:2: (a0= 'Model' a1= '{' (a2= 'title' a3= ':' (a4= QUOTED_34_34 ) ( (a5= 'groups' a6= ':' (a7_0= parse_baserequirements_RequirementGroup ) ) )* ) a8= '}' )
            // Baserequirements.g:531:2: a0= 'Model' a1= '{' (a2= 'title' a3= ':' (a4= QUOTED_34_34 ) ( (a5= 'groups' a6= ':' (a7_0= parse_baserequirements_RequirementGroup ) ) )* ) a8= '}'
            {
            a0=(Token)match(input,21,FOLLOW_21_in_parse_baserequirements_Model115); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = baserequirements.BaserequirementsFactory.eINSTANCE.createModel();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_0_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[1]);
            	}

            a1=(Token)match(input,51,FOLLOW_51_in_parse_baserequirements_Model129); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = baserequirements.BaserequirementsFactory.eINSTANCE.createModel();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_0_0_0_1, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[2]);
            	}

            // Baserequirements.g:559:2: (a2= 'title' a3= ':' (a4= QUOTED_34_34 ) ( (a5= 'groups' a6= ':' (a7_0= parse_baserequirements_RequirementGroup ) ) )* )
            // Baserequirements.g:560:3: a2= 'title' a3= ':' (a4= QUOTED_34_34 ) ( (a5= 'groups' a6= ':' (a7_0= parse_baserequirements_RequirementGroup ) ) )*
            {
            a2=(Token)match(input,48,FOLLOW_48_in_parse_baserequirements_Model147); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (element == null) {
            				element = baserequirements.BaserequirementsFactory.eINSTANCE.createModel();
            				startIncompleteElement(element);
            			}
            			collectHiddenTokens(element);
            			retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_0_0_0_2_0_0_0, null, true);
            			copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
            		}

            if ( state.backtracking==0 ) {
            			// expected elements (follow set)
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[3]);
            		}

            a3=(Token)match(input,10,FOLLOW_10_in_parse_baserequirements_Model164); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (element == null) {
            				element = baserequirements.BaserequirementsFactory.eINSTANCE.createModel();
            				startIncompleteElement(element);
            			}
            			collectHiddenTokens(element);
            			retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_0_0_0_2_0_0_1, null, true);
            			copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
            		}

            if ( state.backtracking==0 ) {
            			// expected elements (follow set)
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[4]);
            		}

            // Baserequirements.g:588:3: (a4= QUOTED_34_34 )
            // Baserequirements.g:589:4: a4= QUOTED_34_34
            {
            a4=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_baserequirements_Model186); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            				if (terminateParsing) {
            					throw new baserequirements.resource.baserequirements.mopp.BaserequirementsTerminateParsingException();
            				}
            				if (element == null) {
            					element = baserequirements.BaserequirementsFactory.eINSTANCE.createModel();
            					startIncompleteElement(element);
            				}
            				if (a4 != null) {
            					baserequirements.resource.baserequirements.IBaserequirementsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
            					tokenResolver.setOptions(getOptions());
            					baserequirements.resource.baserequirements.IBaserequirementsTokenResolveResult result = getFreshTokenResolveResult();
            					tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.MODEL__TITLE), result);
            					Object resolvedObject = result.getResolvedToken();
            					if (resolvedObject == null) {
            						addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a4).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStopIndex());
            					}
            					java.lang.String resolved = (java.lang.String) resolvedObject;
            					if (resolved != null) {
            						Object value = resolved;
            						element.eSet(element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.MODEL__TITLE), value);
            						completedElement(value, false);
            					}
            					collectHiddenTokens(element);
            					retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_0_0_0_2_0_0_2, resolved, true);
            					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a4, element);
            				}
            			}

            }


            if ( state.backtracking==0 ) {
            			// expected elements (follow set)
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[5]);
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[6]);
            		}

            // Baserequirements.g:625:3: ( (a5= 'groups' a6= ':' (a7_0= parse_baserequirements_RequirementGroup ) ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==36) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // Baserequirements.g:626:4: (a5= 'groups' a6= ':' (a7_0= parse_baserequirements_RequirementGroup ) )
            	    {
            	    // Baserequirements.g:626:4: (a5= 'groups' a6= ':' (a7_0= parse_baserequirements_RequirementGroup ) )
            	    // Baserequirements.g:627:5: a5= 'groups' a6= ':' (a7_0= parse_baserequirements_RequirementGroup )
            	    {
            	    a5=(Token)match(input,36,FOLLOW_36_in_parse_baserequirements_Model224); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    					if (element == null) {
            	    						element = baserequirements.BaserequirementsFactory.eINSTANCE.createModel();
            	    						startIncompleteElement(element);
            	    					}
            	    					collectHiddenTokens(element);
            	    					retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_0_0_0_2_0_0_3_0_0_0, null, true);
            	    					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
            	    				}

            	    if ( state.backtracking==0 ) {
            	    					// expected elements (follow set)
            	    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[7]);
            	    				}

            	    a6=(Token)match(input,10,FOLLOW_10_in_parse_baserequirements_Model247); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    					if (element == null) {
            	    						element = baserequirements.BaserequirementsFactory.eINSTANCE.createModel();
            	    						startIncompleteElement(element);
            	    					}
            	    					collectHiddenTokens(element);
            	    					retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_0_0_0_2_0_0_3_0_0_1, null, true);
            	    					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
            	    				}

            	    if ( state.backtracking==0 ) {
            	    					// expected elements (follow set)
            	    					addExpectedElement(baserequirements.BaserequirementsPackage.eINSTANCE.getModel(), baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[8]);
            	    				}

            	    // Baserequirements.g:655:5: (a7_0= parse_baserequirements_RequirementGroup )
            	    // Baserequirements.g:656:6: a7_0= parse_baserequirements_RequirementGroup
            	    {
            	    pushFollow(FOLLOW_parse_baserequirements_RequirementGroup_in_parse_baserequirements_Model277);
            	    a7_0=parse_baserequirements_RequirementGroup();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    						if (terminateParsing) {
            	    							throw new baserequirements.resource.baserequirements.mopp.BaserequirementsTerminateParsingException();
            	    						}
            	    						if (element == null) {
            	    							element = baserequirements.BaserequirementsFactory.eINSTANCE.createModel();
            	    							startIncompleteElement(element);
            	    						}
            	    						if (a7_0 != null) {
            	    							if (a7_0 != null) {
            	    								Object value = a7_0;
            	    								addObjectToList(element, baserequirements.BaserequirementsPackage.MODEL__GROUPS, value);
            	    								completedElement(value, true);
            	    							}
            	    							collectHiddenTokens(element);
            	    							retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_0_0_0_2_0_0_3_0_0_2, a7_0, true);
            	    							copyLocalizationInfos(a7_0, element);
            	    						}
            	    					}

            	    }


            	    if ( state.backtracking==0 ) {
            	    					// expected elements (follow set)
            	    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[9]);
            	    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[10]);
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
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[11]);
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[12]);
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[13]);
            	}

            a8=(Token)match(input,52,FOLLOW_52_in_parse_baserequirements_Model335); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = baserequirements.BaserequirementsFactory.eINSTANCE.createModel();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_0_0_0_3, null, true);
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
            if ( state.backtracking>0 ) { memoize(input, 2, parse_baserequirements_Model_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_baserequirements_Model"



    // $ANTLR start "parse_baserequirements_RequirementGroup"
    // Baserequirements.g:711:1: parse_baserequirements_RequirementGroup returns [baserequirements.RequirementGroup element = null] : a0= 'RequirementGroup' a1= '{' (a2= 'name' a3= ':' (a4= QUOTED_34_34 ) ( (a5= 'description' a6= ':' (a7= QUOTED_34_34 ) ) )? (a8= 'id' a9= ':' (a10= QUOTED_34_34 ) ) ( (a11= 'children' a12= ':' (a13_0= parse_baserequirements_RequirementGroup ) ) )* ( (a14= 'parent' a15= ':' (a16= TEXT ) ) )? ( (a17= 'requirements' a18= ':' (a19_0= parse_baserequirements_Requirement ) ) )* ) a20= '}' ;
    public final baserequirements.RequirementGroup parse_baserequirements_RequirementGroup() throws RecognitionException {
        baserequirements.RequirementGroup element =  null;

        int parse_baserequirements_RequirementGroup_StartIndex = input.index();

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
        Token a11=null;
        Token a12=null;
        Token a14=null;
        Token a15=null;
        Token a16=null;
        Token a17=null;
        Token a18=null;
        Token a20=null;
        baserequirements.RequirementGroup a13_0 =null;

        baserequirements.Requirement a19_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return element; }

            // Baserequirements.g:714:2: (a0= 'RequirementGroup' a1= '{' (a2= 'name' a3= ':' (a4= QUOTED_34_34 ) ( (a5= 'description' a6= ':' (a7= QUOTED_34_34 ) ) )? (a8= 'id' a9= ':' (a10= QUOTED_34_34 ) ) ( (a11= 'children' a12= ':' (a13_0= parse_baserequirements_RequirementGroup ) ) )* ( (a14= 'parent' a15= ':' (a16= TEXT ) ) )? ( (a17= 'requirements' a18= ':' (a19_0= parse_baserequirements_Requirement ) ) )* ) a20= '}' )
            // Baserequirements.g:715:2: a0= 'RequirementGroup' a1= '{' (a2= 'name' a3= ':' (a4= QUOTED_34_34 ) ( (a5= 'description' a6= ':' (a7= QUOTED_34_34 ) ) )? (a8= 'id' a9= ':' (a10= QUOTED_34_34 ) ) ( (a11= 'children' a12= ':' (a13_0= parse_baserequirements_RequirementGroup ) ) )* ( (a14= 'parent' a15= ':' (a16= TEXT ) ) )? ( (a17= 'requirements' a18= ':' (a19_0= parse_baserequirements_Requirement ) ) )* ) a20= '}'
            {
            a0=(Token)match(input,27,FOLLOW_27_in_parse_baserequirements_RequirementGroup364); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirementGroup();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_1_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[14]);
            	}

            a1=(Token)match(input,51,FOLLOW_51_in_parse_baserequirements_RequirementGroup378); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirementGroup();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_1_0_0_1, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[15]);
            	}

            // Baserequirements.g:743:2: (a2= 'name' a3= ':' (a4= QUOTED_34_34 ) ( (a5= 'description' a6= ':' (a7= QUOTED_34_34 ) ) )? (a8= 'id' a9= ':' (a10= QUOTED_34_34 ) ) ( (a11= 'children' a12= ':' (a13_0= parse_baserequirements_RequirementGroup ) ) )* ( (a14= 'parent' a15= ':' (a16= TEXT ) ) )? ( (a17= 'requirements' a18= ':' (a19_0= parse_baserequirements_Requirement ) ) )* )
            // Baserequirements.g:744:3: a2= 'name' a3= ':' (a4= QUOTED_34_34 ) ( (a5= 'description' a6= ':' (a7= QUOTED_34_34 ) ) )? (a8= 'id' a9= ':' (a10= QUOTED_34_34 ) ) ( (a11= 'children' a12= ':' (a13_0= parse_baserequirements_RequirementGroup ) ) )* ( (a14= 'parent' a15= ':' (a16= TEXT ) ) )? ( (a17= 'requirements' a18= ':' (a19_0= parse_baserequirements_Requirement ) ) )*
            {
            a2=(Token)match(input,40,FOLLOW_40_in_parse_baserequirements_RequirementGroup396); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (element == null) {
            				element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirementGroup();
            				startIncompleteElement(element);
            			}
            			collectHiddenTokens(element);
            			retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_1_0_0_2_0_0_0, null, true);
            			copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
            		}

            if ( state.backtracking==0 ) {
            			// expected elements (follow set)
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[16]);
            		}

            a3=(Token)match(input,10,FOLLOW_10_in_parse_baserequirements_RequirementGroup413); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (element == null) {
            				element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirementGroup();
            				startIncompleteElement(element);
            			}
            			collectHiddenTokens(element);
            			retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_1_0_0_2_0_0_1, null, true);
            			copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
            		}

            if ( state.backtracking==0 ) {
            			// expected elements (follow set)
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[17]);
            		}

            // Baserequirements.g:772:3: (a4= QUOTED_34_34 )
            // Baserequirements.g:773:4: a4= QUOTED_34_34
            {
            a4=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_baserequirements_RequirementGroup435); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            				if (terminateParsing) {
            					throw new baserequirements.resource.baserequirements.mopp.BaserequirementsTerminateParsingException();
            				}
            				if (element == null) {
            					element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirementGroup();
            					startIncompleteElement(element);
            				}
            				if (a4 != null) {
            					baserequirements.resource.baserequirements.IBaserequirementsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
            					tokenResolver.setOptions(getOptions());
            					baserequirements.resource.baserequirements.IBaserequirementsTokenResolveResult result = getFreshTokenResolveResult();
            					tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.REQUIREMENT_GROUP__NAME), result);
            					Object resolvedObject = result.getResolvedToken();
            					if (resolvedObject == null) {
            						addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a4).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStopIndex());
            					}
            					java.lang.String resolved = (java.lang.String) resolvedObject;
            					if (resolved != null) {
            						Object value = resolved;
            						element.eSet(element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.REQUIREMENT_GROUP__NAME), value);
            						completedElement(value, false);
            					}
            					collectHiddenTokens(element);
            					retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_1_0_0_2_0_0_2, resolved, true);
            					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a4, element);
            				}
            			}

            }


            if ( state.backtracking==0 ) {
            			// expected elements (follow set)
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[18]);
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[19]);
            		}

            // Baserequirements.g:809:3: ( (a5= 'description' a6= ':' (a7= QUOTED_34_34 ) ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==35) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // Baserequirements.g:810:4: (a5= 'description' a6= ':' (a7= QUOTED_34_34 ) )
                    {
                    // Baserequirements.g:810:4: (a5= 'description' a6= ':' (a7= QUOTED_34_34 ) )
                    // Baserequirements.g:811:5: a5= 'description' a6= ':' (a7= QUOTED_34_34 )
                    {
                    a5=(Token)match(input,35,FOLLOW_35_in_parse_baserequirements_RequirementGroup473); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    					if (element == null) {
                    						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirementGroup();
                    						startIncompleteElement(element);
                    					}
                    					collectHiddenTokens(element);
                    					retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_1_0_0_2_0_0_3_0_0_0, null, true);
                    					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
                    				}

                    if ( state.backtracking==0 ) {
                    					// expected elements (follow set)
                    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[20]);
                    				}

                    a6=(Token)match(input,10,FOLLOW_10_in_parse_baserequirements_RequirementGroup496); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    					if (element == null) {
                    						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirementGroup();
                    						startIncompleteElement(element);
                    					}
                    					collectHiddenTokens(element);
                    					retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_1_0_0_2_0_0_3_0_0_1, null, true);
                    					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
                    				}

                    if ( state.backtracking==0 ) {
                    					// expected elements (follow set)
                    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[21]);
                    				}

                    // Baserequirements.g:839:5: (a7= QUOTED_34_34 )
                    // Baserequirements.g:840:6: a7= QUOTED_34_34
                    {
                    a7=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_baserequirements_RequirementGroup526); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    						if (terminateParsing) {
                    							throw new baserequirements.resource.baserequirements.mopp.BaserequirementsTerminateParsingException();
                    						}
                    						if (element == null) {
                    							element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirementGroup();
                    							startIncompleteElement(element);
                    						}
                    						if (a7 != null) {
                    							baserequirements.resource.baserequirements.IBaserequirementsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
                    							tokenResolver.setOptions(getOptions());
                    							baserequirements.resource.baserequirements.IBaserequirementsTokenResolveResult result = getFreshTokenResolveResult();
                    							tokenResolver.resolve(a7.getText(), element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.REQUIREMENT_GROUP__DESCRIPTION), result);
                    							Object resolvedObject = result.getResolvedToken();
                    							if (resolvedObject == null) {
                    								addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a7).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a7).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a7).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a7).getStopIndex());
                    							}
                    							java.lang.String resolved = (java.lang.String) resolvedObject;
                    							if (resolved != null) {
                    								Object value = resolved;
                    								element.eSet(element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.REQUIREMENT_GROUP__DESCRIPTION), value);
                    								completedElement(value, false);
                    							}
                    							collectHiddenTokens(element);
                    							retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_1_0_0_2_0_0_3_0_0_2, resolved, true);
                    							copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a7, element);
                    						}
                    					}

                    }


                    if ( state.backtracking==0 ) {
                    					// expected elements (follow set)
                    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[22]);
                    				}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            			// expected elements (follow set)
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[23]);
            		}

            // Baserequirements.g:882:3: (a8= 'id' a9= ':' (a10= QUOTED_34_34 ) )
            // Baserequirements.g:883:4: a8= 'id' a9= ':' (a10= QUOTED_34_34 )
            {
            a8=(Token)match(input,37,FOLLOW_37_in_parse_baserequirements_RequirementGroup588); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            				if (element == null) {
            					element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirementGroup();
            					startIncompleteElement(element);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_1_0_0_2_0_0_4_0_0_0, null, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a8, element);
            			}

            if ( state.backtracking==0 ) {
            				// expected elements (follow set)
            				addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[24]);
            			}

            a9=(Token)match(input,10,FOLLOW_10_in_parse_baserequirements_RequirementGroup608); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            				if (element == null) {
            					element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirementGroup();
            					startIncompleteElement(element);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_1_0_0_2_0_0_4_0_0_1, null, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a9, element);
            			}

            if ( state.backtracking==0 ) {
            				// expected elements (follow set)
            				addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[25]);
            			}

            // Baserequirements.g:911:4: (a10= QUOTED_34_34 )
            // Baserequirements.g:912:5: a10= QUOTED_34_34
            {
            a10=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_baserequirements_RequirementGroup634); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            					if (terminateParsing) {
            						throw new baserequirements.resource.baserequirements.mopp.BaserequirementsTerminateParsingException();
            					}
            					if (element == null) {
            						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirementGroup();
            						startIncompleteElement(element);
            					}
            					if (a10 != null) {
            						baserequirements.resource.baserequirements.IBaserequirementsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
            						tokenResolver.setOptions(getOptions());
            						baserequirements.resource.baserequirements.IBaserequirementsTokenResolveResult result = getFreshTokenResolveResult();
            						tokenResolver.resolve(a10.getText(), element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.REQUIREMENT_GROUP__ID), result);
            						Object resolvedObject = result.getResolvedToken();
            						if (resolvedObject == null) {
            							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a10).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a10).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a10).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a10).getStopIndex());
            						}
            						java.lang.String resolved = (java.lang.String) resolvedObject;
            						if (resolved != null) {
            							Object value = resolved;
            							element.eSet(element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.REQUIREMENT_GROUP__ID), value);
            							completedElement(value, false);
            						}
            						collectHiddenTokens(element);
            						retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_1_0_0_2_0_0_4_0_0_2, resolved, true);
            						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a10, element);
            					}
            				}

            }


            if ( state.backtracking==0 ) {
            				// expected elements (follow set)
            				addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[26]);
            				addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[27]);
            				addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[28]);
            				addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[29]);
            			}

            }


            if ( state.backtracking==0 ) {
            			// expected elements (follow set)
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[30]);
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[31]);
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[32]);
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[33]);
            		}

            // Baserequirements.g:959:3: ( (a11= 'children' a12= ':' (a13_0= parse_baserequirements_RequirementGroup ) ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==31) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // Baserequirements.g:960:4: (a11= 'children' a12= ':' (a13_0= parse_baserequirements_RequirementGroup ) )
            	    {
            	    // Baserequirements.g:960:4: (a11= 'children' a12= ':' (a13_0= parse_baserequirements_RequirementGroup ) )
            	    // Baserequirements.g:961:5: a11= 'children' a12= ':' (a13_0= parse_baserequirements_RequirementGroup )
            	    {
            	    a11=(Token)match(input,31,FOLLOW_31_in_parse_baserequirements_RequirementGroup688); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    					if (element == null) {
            	    						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirementGroup();
            	    						startIncompleteElement(element);
            	    					}
            	    					collectHiddenTokens(element);
            	    					retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_1_0_0_2_0_0_5_0_0_0, null, true);
            	    					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a11, element);
            	    				}

            	    if ( state.backtracking==0 ) {
            	    					// expected elements (follow set)
            	    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[34]);
            	    				}

            	    a12=(Token)match(input,10,FOLLOW_10_in_parse_baserequirements_RequirementGroup711); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    					if (element == null) {
            	    						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirementGroup();
            	    						startIncompleteElement(element);
            	    					}
            	    					collectHiddenTokens(element);
            	    					retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_1_0_0_2_0_0_5_0_0_1, null, true);
            	    					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a12, element);
            	    				}

            	    if ( state.backtracking==0 ) {
            	    					// expected elements (follow set)
            	    					addExpectedElement(baserequirements.BaserequirementsPackage.eINSTANCE.getRequirementGroup(), baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[35]);
            	    				}

            	    // Baserequirements.g:989:5: (a13_0= parse_baserequirements_RequirementGroup )
            	    // Baserequirements.g:990:6: a13_0= parse_baserequirements_RequirementGroup
            	    {
            	    pushFollow(FOLLOW_parse_baserequirements_RequirementGroup_in_parse_baserequirements_RequirementGroup741);
            	    a13_0=parse_baserequirements_RequirementGroup();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    						if (terminateParsing) {
            	    							throw new baserequirements.resource.baserequirements.mopp.BaserequirementsTerminateParsingException();
            	    						}
            	    						if (element == null) {
            	    							element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirementGroup();
            	    							startIncompleteElement(element);
            	    						}
            	    						if (a13_0 != null) {
            	    							if (a13_0 != null) {
            	    								Object value = a13_0;
            	    								addObjectToList(element, baserequirements.BaserequirementsPackage.REQUIREMENT_GROUP__CHILDREN, value);
            	    								completedElement(value, true);
            	    							}
            	    							collectHiddenTokens(element);
            	    							retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_1_0_0_2_0_0_5_0_0_2, a13_0, true);
            	    							copyLocalizationInfos(a13_0, element);
            	    						}
            	    					}

            	    }


            	    if ( state.backtracking==0 ) {
            	    					// expected elements (follow set)
            	    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[36]);
            	    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[37]);
            	    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[38]);
            	    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[39]);
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
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[40]);
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[41]);
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[42]);
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[43]);
            		}

            // Baserequirements.g:1028:3: ( (a14= 'parent' a15= ':' (a16= TEXT ) ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==41) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // Baserequirements.g:1029:4: (a14= 'parent' a15= ':' (a16= TEXT ) )
                    {
                    // Baserequirements.g:1029:4: (a14= 'parent' a15= ':' (a16= TEXT ) )
                    // Baserequirements.g:1030:5: a14= 'parent' a15= ':' (a16= TEXT )
                    {
                    a14=(Token)match(input,41,FOLLOW_41_in_parse_baserequirements_RequirementGroup803); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    					if (element == null) {
                    						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirementGroup();
                    						startIncompleteElement(element);
                    					}
                    					collectHiddenTokens(element);
                    					retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_1_0_0_2_0_0_6_0_0_0, null, true);
                    					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a14, element);
                    				}

                    if ( state.backtracking==0 ) {
                    					// expected elements (follow set)
                    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[44]);
                    				}

                    a15=(Token)match(input,10,FOLLOW_10_in_parse_baserequirements_RequirementGroup826); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    					if (element == null) {
                    						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirementGroup();
                    						startIncompleteElement(element);
                    					}
                    					collectHiddenTokens(element);
                    					retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_1_0_0_2_0_0_6_0_0_1, null, true);
                    					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a15, element);
                    				}

                    if ( state.backtracking==0 ) {
                    					// expected elements (follow set)
                    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[45]);
                    				}

                    // Baserequirements.g:1058:5: (a16= TEXT )
                    // Baserequirements.g:1059:6: a16= TEXT
                    {
                    a16=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_baserequirements_RequirementGroup856); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    						if (terminateParsing) {
                    							throw new baserequirements.resource.baserequirements.mopp.BaserequirementsTerminateParsingException();
                    						}
                    						if (element == null) {
                    							element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirementGroup();
                    							startIncompleteElement(element);
                    						}
                    						if (a16 != null) {
                    							baserequirements.resource.baserequirements.IBaserequirementsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
                    							tokenResolver.setOptions(getOptions());
                    							baserequirements.resource.baserequirements.IBaserequirementsTokenResolveResult result = getFreshTokenResolveResult();
                    							tokenResolver.resolve(a16.getText(), element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.REQUIREMENT_GROUP__PARENT), result);
                    							Object resolvedObject = result.getResolvedToken();
                    							if (resolvedObject == null) {
                    								addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a16).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a16).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a16).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a16).getStopIndex());
                    							}
                    							String resolved = (String) resolvedObject;
                    							baserequirements.RequirementGroup proxy = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirementGroup();
                    							collectHiddenTokens(element);
                    							registerContextDependentProxy(new baserequirements.resource.baserequirements.mopp.BaserequirementsContextDependentURIFragmentFactory<baserequirements.RequirementGroup, baserequirements.RequirementGroup>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getRequirementGroupParentReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.REQUIREMENT_GROUP__PARENT), resolved, proxy);
                    							if (proxy != null) {
                    								Object value = proxy;
                    								element.eSet(element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.REQUIREMENT_GROUP__PARENT), value);
                    								completedElement(value, false);
                    							}
                    							collectHiddenTokens(element);
                    							retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_1_0_0_2_0_0_6_0_0_2, proxy, true);
                    							copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a16, element);
                    							copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a16, proxy);
                    						}
                    					}

                    }


                    if ( state.backtracking==0 ) {
                    					// expected elements (follow set)
                    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[46]);
                    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[47]);
                    				}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            			// expected elements (follow set)
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[48]);
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[49]);
            		}

            // Baserequirements.g:1107:3: ( (a17= 'requirements' a18= ':' (a19_0= parse_baserequirements_Requirement ) ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==43) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // Baserequirements.g:1108:4: (a17= 'requirements' a18= ':' (a19_0= parse_baserequirements_Requirement ) )
            	    {
            	    // Baserequirements.g:1108:4: (a17= 'requirements' a18= ':' (a19_0= parse_baserequirements_Requirement ) )
            	    // Baserequirements.g:1109:5: a17= 'requirements' a18= ':' (a19_0= parse_baserequirements_Requirement )
            	    {
            	    a17=(Token)match(input,43,FOLLOW_43_in_parse_baserequirements_RequirementGroup924); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    					if (element == null) {
            	    						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirementGroup();
            	    						startIncompleteElement(element);
            	    					}
            	    					collectHiddenTokens(element);
            	    					retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_1_0_0_2_0_0_7_0_0_0, null, true);
            	    					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a17, element);
            	    				}

            	    if ( state.backtracking==0 ) {
            	    					// expected elements (follow set)
            	    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[50]);
            	    				}

            	    a18=(Token)match(input,10,FOLLOW_10_in_parse_baserequirements_RequirementGroup947); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    					if (element == null) {
            	    						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirementGroup();
            	    						startIncompleteElement(element);
            	    					}
            	    					collectHiddenTokens(element);
            	    					retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_1_0_0_2_0_0_7_0_0_1, null, true);
            	    					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a18, element);
            	    				}

            	    if ( state.backtracking==0 ) {
            	    					// expected elements (follow set)
            	    					addExpectedElement(baserequirements.BaserequirementsPackage.eINSTANCE.getRequirementGroup(), baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[51]);
            	    				}

            	    // Baserequirements.g:1137:5: (a19_0= parse_baserequirements_Requirement )
            	    // Baserequirements.g:1138:6: a19_0= parse_baserequirements_Requirement
            	    {
            	    pushFollow(FOLLOW_parse_baserequirements_Requirement_in_parse_baserequirements_RequirementGroup977);
            	    a19_0=parse_baserequirements_Requirement();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    						if (terminateParsing) {
            	    							throw new baserequirements.resource.baserequirements.mopp.BaserequirementsTerminateParsingException();
            	    						}
            	    						if (element == null) {
            	    							element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirementGroup();
            	    							startIncompleteElement(element);
            	    						}
            	    						if (a19_0 != null) {
            	    							if (a19_0 != null) {
            	    								Object value = a19_0;
            	    								addObjectToList(element, baserequirements.BaserequirementsPackage.REQUIREMENT_GROUP__REQUIREMENTS, value);
            	    								completedElement(value, true);
            	    							}
            	    							collectHiddenTokens(element);
            	    							retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_1_0_0_2_0_0_7_0_0_2, a19_0, true);
            	    							copyLocalizationInfos(a19_0, element);
            	    						}
            	    					}

            	    }


            	    if ( state.backtracking==0 ) {
            	    					// expected elements (follow set)
            	    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[52]);
            	    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[53]);
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
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[54]);
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[55]);
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[56]);
            	}

            a20=(Token)match(input,52,FOLLOW_52_in_parse_baserequirements_RequirementGroup1035); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirementGroup();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_1_0_0_3, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a20, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[57]);
            		addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[58]);
            		addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[59]);
            		addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[60]);
            		addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[61]);
            		addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[62]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 3, parse_baserequirements_RequirementGroup_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_baserequirements_RequirementGroup"



    // $ANTLR start "parse_baserequirements_Requirement"
    // Baserequirements.g:1199:1: parse_baserequirements_Requirement returns [baserequirements.Requirement element = null] : a0= 'Requirement' a1= '{' (a2= 'title' a3= ':' (a4= QUOTED_34_34 ) ( (a5= 'description' a6= ':' (a7= QUOTED_34_34 ) ) )? ( (a8= 'type' a9= ':' ( (a10= 'FUNCTIONAL' |a11= 'NONFUNCTIONAL' ) ) ) )? ( (a14= 'priority' a15= ':' ( (a16= 'HIGH' |a17= 'MEDIUM' |a18= 'LOW' ) ) ) )? ( (a21= 'author' a22= ':' (a23= QUOTED_34_34 ) ) )? ( (a24= 'created' a25= ':' (a26= TEXT ) ) )? ( (a27= 'id' a28= ':' (a29= QUOTED_34_34 ) ) )? ( (a30= 'state' a31= ':' ( (a32= 'NEW' |a33= 'REVIEWED' |a34= 'APPROVED' |a35= 'RESOLVED' ) ) ) )? ( (a38= 'resolution' a39= ':' ( (a40= 'INVALID' |a41= 'ACCEPTED' |a42= 'IMPLEMENTED' |a43= 'LATER' ) ) ) )? ( (a46= 'version' a47= ':' (a48_0= parse_baserequirements_Version ) ) )? ( (a49= 'comments' a50= ':' (a51_0= parse_baserequirements_Comment ) ) )* ( (a52= 'dependencies' a53= ':' (a54= TEXT ) ) )* ( (a55= 'parent' a56= ':' (a57= TEXT ) ) )? ( (a58= 'children' a59= ':' (a60_0= parse_baserequirements_Requirement ) ) )* ) a61= '}' ;
    public final baserequirements.Requirement parse_baserequirements_Requirement() throws RecognitionException {
        baserequirements.Requirement element =  null;

        int parse_baserequirements_Requirement_StartIndex = input.index();

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
        Token a11=null;
        Token a14=null;
        Token a15=null;
        Token a16=null;
        Token a17=null;
        Token a18=null;
        Token a21=null;
        Token a22=null;
        Token a23=null;
        Token a24=null;
        Token a25=null;
        Token a26=null;
        Token a27=null;
        Token a28=null;
        Token a29=null;
        Token a30=null;
        Token a31=null;
        Token a32=null;
        Token a33=null;
        Token a34=null;
        Token a35=null;
        Token a38=null;
        Token a39=null;
        Token a40=null;
        Token a41=null;
        Token a42=null;
        Token a43=null;
        Token a46=null;
        Token a47=null;
        Token a49=null;
        Token a50=null;
        Token a52=null;
        Token a53=null;
        Token a54=null;
        Token a55=null;
        Token a56=null;
        Token a57=null;
        Token a58=null;
        Token a59=null;
        Token a61=null;
        baserequirements.Version a48_0 =null;

        baserequirements.Comment a51_0 =null;

        baserequirements.Requirement a60_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return element; }

            // Baserequirements.g:1202:2: (a0= 'Requirement' a1= '{' (a2= 'title' a3= ':' (a4= QUOTED_34_34 ) ( (a5= 'description' a6= ':' (a7= QUOTED_34_34 ) ) )? ( (a8= 'type' a9= ':' ( (a10= 'FUNCTIONAL' |a11= 'NONFUNCTIONAL' ) ) ) )? ( (a14= 'priority' a15= ':' ( (a16= 'HIGH' |a17= 'MEDIUM' |a18= 'LOW' ) ) ) )? ( (a21= 'author' a22= ':' (a23= QUOTED_34_34 ) ) )? ( (a24= 'created' a25= ':' (a26= TEXT ) ) )? ( (a27= 'id' a28= ':' (a29= QUOTED_34_34 ) ) )? ( (a30= 'state' a31= ':' ( (a32= 'NEW' |a33= 'REVIEWED' |a34= 'APPROVED' |a35= 'RESOLVED' ) ) ) )? ( (a38= 'resolution' a39= ':' ( (a40= 'INVALID' |a41= 'ACCEPTED' |a42= 'IMPLEMENTED' |a43= 'LATER' ) ) ) )? ( (a46= 'version' a47= ':' (a48_0= parse_baserequirements_Version ) ) )? ( (a49= 'comments' a50= ':' (a51_0= parse_baserequirements_Comment ) ) )* ( (a52= 'dependencies' a53= ':' (a54= TEXT ) ) )* ( (a55= 'parent' a56= ':' (a57= TEXT ) ) )? ( (a58= 'children' a59= ':' (a60_0= parse_baserequirements_Requirement ) ) )* ) a61= '}' )
            // Baserequirements.g:1203:2: a0= 'Requirement' a1= '{' (a2= 'title' a3= ':' (a4= QUOTED_34_34 ) ( (a5= 'description' a6= ':' (a7= QUOTED_34_34 ) ) )? ( (a8= 'type' a9= ':' ( (a10= 'FUNCTIONAL' |a11= 'NONFUNCTIONAL' ) ) ) )? ( (a14= 'priority' a15= ':' ( (a16= 'HIGH' |a17= 'MEDIUM' |a18= 'LOW' ) ) ) )? ( (a21= 'author' a22= ':' (a23= QUOTED_34_34 ) ) )? ( (a24= 'created' a25= ':' (a26= TEXT ) ) )? ( (a27= 'id' a28= ':' (a29= QUOTED_34_34 ) ) )? ( (a30= 'state' a31= ':' ( (a32= 'NEW' |a33= 'REVIEWED' |a34= 'APPROVED' |a35= 'RESOLVED' ) ) ) )? ( (a38= 'resolution' a39= ':' ( (a40= 'INVALID' |a41= 'ACCEPTED' |a42= 'IMPLEMENTED' |a43= 'LATER' ) ) ) )? ( (a46= 'version' a47= ':' (a48_0= parse_baserequirements_Version ) ) )? ( (a49= 'comments' a50= ':' (a51_0= parse_baserequirements_Comment ) ) )* ( (a52= 'dependencies' a53= ':' (a54= TEXT ) ) )* ( (a55= 'parent' a56= ':' (a57= TEXT ) ) )? ( (a58= 'children' a59= ':' (a60_0= parse_baserequirements_Requirement ) ) )* ) a61= '}'
            {
            a0=(Token)match(input,26,FOLLOW_26_in_parse_baserequirements_Requirement1064); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[63]);
            	}

            a1=(Token)match(input,51,FOLLOW_51_in_parse_baserequirements_Requirement1078); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_1, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[64]);
            	}

            // Baserequirements.g:1231:2: (a2= 'title' a3= ':' (a4= QUOTED_34_34 ) ( (a5= 'description' a6= ':' (a7= QUOTED_34_34 ) ) )? ( (a8= 'type' a9= ':' ( (a10= 'FUNCTIONAL' |a11= 'NONFUNCTIONAL' ) ) ) )? ( (a14= 'priority' a15= ':' ( (a16= 'HIGH' |a17= 'MEDIUM' |a18= 'LOW' ) ) ) )? ( (a21= 'author' a22= ':' (a23= QUOTED_34_34 ) ) )? ( (a24= 'created' a25= ':' (a26= TEXT ) ) )? ( (a27= 'id' a28= ':' (a29= QUOTED_34_34 ) ) )? ( (a30= 'state' a31= ':' ( (a32= 'NEW' |a33= 'REVIEWED' |a34= 'APPROVED' |a35= 'RESOLVED' ) ) ) )? ( (a38= 'resolution' a39= ':' ( (a40= 'INVALID' |a41= 'ACCEPTED' |a42= 'IMPLEMENTED' |a43= 'LATER' ) ) ) )? ( (a46= 'version' a47= ':' (a48_0= parse_baserequirements_Version ) ) )? ( (a49= 'comments' a50= ':' (a51_0= parse_baserequirements_Comment ) ) )* ( (a52= 'dependencies' a53= ':' (a54= TEXT ) ) )* ( (a55= 'parent' a56= ':' (a57= TEXT ) ) )? ( (a58= 'children' a59= ':' (a60_0= parse_baserequirements_Requirement ) ) )* )
            // Baserequirements.g:1232:3: a2= 'title' a3= ':' (a4= QUOTED_34_34 ) ( (a5= 'description' a6= ':' (a7= QUOTED_34_34 ) ) )? ( (a8= 'type' a9= ':' ( (a10= 'FUNCTIONAL' |a11= 'NONFUNCTIONAL' ) ) ) )? ( (a14= 'priority' a15= ':' ( (a16= 'HIGH' |a17= 'MEDIUM' |a18= 'LOW' ) ) ) )? ( (a21= 'author' a22= ':' (a23= QUOTED_34_34 ) ) )? ( (a24= 'created' a25= ':' (a26= TEXT ) ) )? ( (a27= 'id' a28= ':' (a29= QUOTED_34_34 ) ) )? ( (a30= 'state' a31= ':' ( (a32= 'NEW' |a33= 'REVIEWED' |a34= 'APPROVED' |a35= 'RESOLVED' ) ) ) )? ( (a38= 'resolution' a39= ':' ( (a40= 'INVALID' |a41= 'ACCEPTED' |a42= 'IMPLEMENTED' |a43= 'LATER' ) ) ) )? ( (a46= 'version' a47= ':' (a48_0= parse_baserequirements_Version ) ) )? ( (a49= 'comments' a50= ':' (a51_0= parse_baserequirements_Comment ) ) )* ( (a52= 'dependencies' a53= ':' (a54= TEXT ) ) )* ( (a55= 'parent' a56= ':' (a57= TEXT ) ) )? ( (a58= 'children' a59= ':' (a60_0= parse_baserequirements_Requirement ) ) )*
            {
            a2=(Token)match(input,48,FOLLOW_48_in_parse_baserequirements_Requirement1096); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (element == null) {
            				element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
            				startIncompleteElement(element);
            			}
            			collectHiddenTokens(element);
            			retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_0, null, true);
            			copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
            		}

            if ( state.backtracking==0 ) {
            			// expected elements (follow set)
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[65]);
            		}

            a3=(Token)match(input,10,FOLLOW_10_in_parse_baserequirements_Requirement1113); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (element == null) {
            				element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
            				startIncompleteElement(element);
            			}
            			collectHiddenTokens(element);
            			retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_1, null, true);
            			copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
            		}

            if ( state.backtracking==0 ) {
            			// expected elements (follow set)
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[66]);
            		}

            // Baserequirements.g:1260:3: (a4= QUOTED_34_34 )
            // Baserequirements.g:1261:4: a4= QUOTED_34_34
            {
            a4=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_baserequirements_Requirement1135); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            				if (terminateParsing) {
            					throw new baserequirements.resource.baserequirements.mopp.BaserequirementsTerminateParsingException();
            				}
            				if (element == null) {
            					element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
            					startIncompleteElement(element);
            				}
            				if (a4 != null) {
            					baserequirements.resource.baserequirements.IBaserequirementsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
            					tokenResolver.setOptions(getOptions());
            					baserequirements.resource.baserequirements.IBaserequirementsTokenResolveResult result = getFreshTokenResolveResult();
            					tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.REQUIREMENT__TITLE), result);
            					Object resolvedObject = result.getResolvedToken();
            					if (resolvedObject == null) {
            						addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a4).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStopIndex());
            					}
            					java.lang.String resolved = (java.lang.String) resolvedObject;
            					if (resolved != null) {
            						Object value = resolved;
            						element.eSet(element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.REQUIREMENT__TITLE), value);
            						completedElement(value, false);
            					}
            					collectHiddenTokens(element);
            					retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_2, resolved, true);
            					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a4, element);
            				}
            			}

            }


            if ( state.backtracking==0 ) {
            			// expected elements (follow set)
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[67]);
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[68]);
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[69]);
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[70]);
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[71]);
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[72]);
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[73]);
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[74]);
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[75]);
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[76]);
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[77]);
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[78]);
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[79]);
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[80]);
            		}

            // Baserequirements.g:1309:3: ( (a5= 'description' a6= ':' (a7= QUOTED_34_34 ) ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==35) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // Baserequirements.g:1310:4: (a5= 'description' a6= ':' (a7= QUOTED_34_34 ) )
                    {
                    // Baserequirements.g:1310:4: (a5= 'description' a6= ':' (a7= QUOTED_34_34 ) )
                    // Baserequirements.g:1311:5: a5= 'description' a6= ':' (a7= QUOTED_34_34 )
                    {
                    a5=(Token)match(input,35,FOLLOW_35_in_parse_baserequirements_Requirement1173); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    					if (element == null) {
                    						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
                    						startIncompleteElement(element);
                    					}
                    					collectHiddenTokens(element);
                    					retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_3_0_0_0, null, true);
                    					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
                    				}

                    if ( state.backtracking==0 ) {
                    					// expected elements (follow set)
                    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[81]);
                    				}

                    a6=(Token)match(input,10,FOLLOW_10_in_parse_baserequirements_Requirement1196); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    					if (element == null) {
                    						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
                    						startIncompleteElement(element);
                    					}
                    					collectHiddenTokens(element);
                    					retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_3_0_0_1, null, true);
                    					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
                    				}

                    if ( state.backtracking==0 ) {
                    					// expected elements (follow set)
                    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[82]);
                    				}

                    // Baserequirements.g:1339:5: (a7= QUOTED_34_34 )
                    // Baserequirements.g:1340:6: a7= QUOTED_34_34
                    {
                    a7=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_baserequirements_Requirement1226); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    						if (terminateParsing) {
                    							throw new baserequirements.resource.baserequirements.mopp.BaserequirementsTerminateParsingException();
                    						}
                    						if (element == null) {
                    							element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
                    							startIncompleteElement(element);
                    						}
                    						if (a7 != null) {
                    							baserequirements.resource.baserequirements.IBaserequirementsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
                    							tokenResolver.setOptions(getOptions());
                    							baserequirements.resource.baserequirements.IBaserequirementsTokenResolveResult result = getFreshTokenResolveResult();
                    							tokenResolver.resolve(a7.getText(), element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.REQUIREMENT__DESCRIPTION), result);
                    							Object resolvedObject = result.getResolvedToken();
                    							if (resolvedObject == null) {
                    								addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a7).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a7).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a7).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a7).getStopIndex());
                    							}
                    							java.lang.String resolved = (java.lang.String) resolvedObject;
                    							if (resolved != null) {
                    								Object value = resolved;
                    								element.eSet(element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.REQUIREMENT__DESCRIPTION), value);
                    								completedElement(value, false);
                    							}
                    							collectHiddenTokens(element);
                    							retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_3_0_0_2, resolved, true);
                    							copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a7, element);
                    						}
                    					}

                    }


                    if ( state.backtracking==0 ) {
                    					// expected elements (follow set)
                    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[83]);
                    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[84]);
                    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[85]);
                    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[86]);
                    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[87]);
                    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[88]);
                    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[89]);
                    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[90]);
                    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[91]);
                    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[92]);
                    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[93]);
                    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[94]);
                    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[95]);
                    				}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            			// expected elements (follow set)
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[96]);
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[97]);
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[98]);
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[99]);
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[100]);
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[101]);
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[102]);
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[103]);
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[104]);
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[105]);
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[106]);
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[107]);
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[108]);
            		}

            // Baserequirements.g:1406:3: ( (a8= 'type' a9= ':' ( (a10= 'FUNCTIONAL' |a11= 'NONFUNCTIONAL' ) ) ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==49) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // Baserequirements.g:1407:4: (a8= 'type' a9= ':' ( (a10= 'FUNCTIONAL' |a11= 'NONFUNCTIONAL' ) ) )
                    {
                    // Baserequirements.g:1407:4: (a8= 'type' a9= ':' ( (a10= 'FUNCTIONAL' |a11= 'NONFUNCTIONAL' ) ) )
                    // Baserequirements.g:1408:5: a8= 'type' a9= ':' ( (a10= 'FUNCTIONAL' |a11= 'NONFUNCTIONAL' ) )
                    {
                    a8=(Token)match(input,49,FOLLOW_49_in_parse_baserequirements_Requirement1294); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    					if (element == null) {
                    						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
                    						startIncompleteElement(element);
                    					}
                    					collectHiddenTokens(element);
                    					retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_4_0_0_0, null, true);
                    					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a8, element);
                    				}

                    if ( state.backtracking==0 ) {
                    					// expected elements (follow set)
                    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[109]);
                    				}

                    a9=(Token)match(input,10,FOLLOW_10_in_parse_baserequirements_Requirement1317); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    					if (element == null) {
                    						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
                    						startIncompleteElement(element);
                    					}
                    					collectHiddenTokens(element);
                    					retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_4_0_0_1, null, true);
                    					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a9, element);
                    				}

                    if ( state.backtracking==0 ) {
                    					// expected elements (follow set)
                    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[110]);
                    				}

                    // Baserequirements.g:1436:5: ( (a10= 'FUNCTIONAL' |a11= 'NONFUNCTIONAL' ) )
                    // Baserequirements.g:1437:6: (a10= 'FUNCTIONAL' |a11= 'NONFUNCTIONAL' )
                    {
                    // Baserequirements.g:1437:6: (a10= 'FUNCTIONAL' |a11= 'NONFUNCTIONAL' )
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( (LA7_0==14) ) {
                        alt7=1;
                    }
                    else if ( (LA7_0==23) ) {
                        alt7=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return element;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 7, 0, input);

                        throw nvae;

                    }
                    switch (alt7) {
                        case 1 :
                            // Baserequirements.g:1438:7: a10= 'FUNCTIONAL'
                            {
                            a10=(Token)match(input,14,FOLLOW_14_in_parse_baserequirements_Requirement1355); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            							if (element == null) {
                            								element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
                            								startIncompleteElement(element);
                            							}
                            							collectHiddenTokens(element);
                            							retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_4_0_0_2, null, true);
                            							copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a10, element);
                            							// set value of enumeration attribute
                            							Object value = baserequirements.BaserequirementsPackage.eINSTANCE.getType().getEEnumLiteral(baserequirements.Type.FUNCTIONAL_VALUE).getInstance();
                            							element.eSet(element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.REQUIREMENT__TYPE), value);
                            							completedElement(value, false);
                            						}

                            }
                            break;
                        case 2 :
                            // Baserequirements.g:1451:14: a11= 'NONFUNCTIONAL'
                            {
                            a11=(Token)match(input,23,FOLLOW_23_in_parse_baserequirements_Requirement1376); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            							if (element == null) {
                            								element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
                            								startIncompleteElement(element);
                            							}
                            							collectHiddenTokens(element);
                            							retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_4_0_0_2, null, true);
                            							copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a11, element);
                            							// set value of enumeration attribute
                            							Object value = baserequirements.BaserequirementsPackage.eINSTANCE.getType().getEEnumLiteral(baserequirements.Type.NONFUNCTIONAL_VALUE).getInstance();
                            							element.eSet(element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.REQUIREMENT__TYPE), value);
                            							completedElement(value, false);
                            						}

                            }
                            break;

                    }


                    }


                    if ( state.backtracking==0 ) {
                    					// expected elements (follow set)
                    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[111]);
                    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[112]);
                    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[113]);
                    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[114]);
                    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[115]);
                    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[116]);
                    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[117]);
                    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[118]);
                    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[119]);
                    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[120]);
                    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[121]);
                    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[122]);
                    				}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            			// expected elements (follow set)
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[123]);
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[124]);
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[125]);
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[126]);
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[127]);
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[128]);
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[129]);
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[130]);
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[131]);
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[132]);
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[133]);
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[134]);
            		}

            // Baserequirements.g:1500:3: ( (a14= 'priority' a15= ':' ( (a16= 'HIGH' |a17= 'MEDIUM' |a18= 'LOW' ) ) ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==42) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // Baserequirements.g:1501:4: (a14= 'priority' a15= ':' ( (a16= 'HIGH' |a17= 'MEDIUM' |a18= 'LOW' ) ) )
                    {
                    // Baserequirements.g:1501:4: (a14= 'priority' a15= ':' ( (a16= 'HIGH' |a17= 'MEDIUM' |a18= 'LOW' ) ) )
                    // Baserequirements.g:1502:5: a14= 'priority' a15= ':' ( (a16= 'HIGH' |a17= 'MEDIUM' |a18= 'LOW' ) )
                    {
                    a14=(Token)match(input,42,FOLLOW_42_in_parse_baserequirements_Requirement1441); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    					if (element == null) {
                    						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
                    						startIncompleteElement(element);
                    					}
                    					collectHiddenTokens(element);
                    					retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_5_0_0_0, null, true);
                    					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a14, element);
                    				}

                    if ( state.backtracking==0 ) {
                    					// expected elements (follow set)
                    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[135]);
                    				}

                    a15=(Token)match(input,10,FOLLOW_10_in_parse_baserequirements_Requirement1464); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    					if (element == null) {
                    						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
                    						startIncompleteElement(element);
                    					}
                    					collectHiddenTokens(element);
                    					retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_5_0_0_1, null, true);
                    					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a15, element);
                    				}

                    if ( state.backtracking==0 ) {
                    					// expected elements (follow set)
                    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[136]);
                    				}

                    // Baserequirements.g:1530:5: ( (a16= 'HIGH' |a17= 'MEDIUM' |a18= 'LOW' ) )
                    // Baserequirements.g:1531:6: (a16= 'HIGH' |a17= 'MEDIUM' |a18= 'LOW' )
                    {
                    // Baserequirements.g:1531:6: (a16= 'HIGH' |a17= 'MEDIUM' |a18= 'LOW' )
                    int alt9=3;
                    switch ( input.LA(1) ) {
                    case 15:
                        {
                        alt9=1;
                        }
                        break;
                    case 20:
                        {
                        alt9=2;
                        }
                        break;
                    case 19:
                        {
                        alt9=3;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return element;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 9, 0, input);

                        throw nvae;

                    }

                    switch (alt9) {
                        case 1 :
                            // Baserequirements.g:1532:7: a16= 'HIGH'
                            {
                            a16=(Token)match(input,15,FOLLOW_15_in_parse_baserequirements_Requirement1502); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            							if (element == null) {
                            								element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
                            								startIncompleteElement(element);
                            							}
                            							collectHiddenTokens(element);
                            							retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_5_0_0_2, null, true);
                            							copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a16, element);
                            							// set value of enumeration attribute
                            							Object value = baserequirements.BaserequirementsPackage.eINSTANCE.getPriority().getEEnumLiteral(baserequirements.Priority.HIGH_VALUE).getInstance();
                            							element.eSet(element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.REQUIREMENT__PRIORITY), value);
                            							completedElement(value, false);
                            						}

                            }
                            break;
                        case 2 :
                            // Baserequirements.g:1545:14: a17= 'MEDIUM'
                            {
                            a17=(Token)match(input,20,FOLLOW_20_in_parse_baserequirements_Requirement1523); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            							if (element == null) {
                            								element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
                            								startIncompleteElement(element);
                            							}
                            							collectHiddenTokens(element);
                            							retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_5_0_0_2, null, true);
                            							copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a17, element);
                            							// set value of enumeration attribute
                            							Object value = baserequirements.BaserequirementsPackage.eINSTANCE.getPriority().getEEnumLiteral(baserequirements.Priority.MEDIUM_VALUE).getInstance();
                            							element.eSet(element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.REQUIREMENT__PRIORITY), value);
                            							completedElement(value, false);
                            						}

                            }
                            break;
                        case 3 :
                            // Baserequirements.g:1558:14: a18= 'LOW'
                            {
                            a18=(Token)match(input,19,FOLLOW_19_in_parse_baserequirements_Requirement1544); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            							if (element == null) {
                            								element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
                            								startIncompleteElement(element);
                            							}
                            							collectHiddenTokens(element);
                            							retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_5_0_0_2, null, true);
                            							copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a18, element);
                            							// set value of enumeration attribute
                            							Object value = baserequirements.BaserequirementsPackage.eINSTANCE.getPriority().getEEnumLiteral(baserequirements.Priority.LOW_VALUE).getInstance();
                            							element.eSet(element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.REQUIREMENT__PRIORITY), value);
                            							completedElement(value, false);
                            						}

                            }
                            break;

                    }


                    }


                    if ( state.backtracking==0 ) {
                    					// expected elements (follow set)
                    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[137]);
                    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[138]);
                    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[139]);
                    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[140]);
                    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[141]);
                    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[142]);
                    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[143]);
                    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[144]);
                    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[145]);
                    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[146]);
                    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[147]);
                    				}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            			// expected elements (follow set)
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[148]);
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[149]);
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[150]);
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[151]);
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[152]);
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[153]);
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[154]);
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[155]);
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[156]);
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[157]);
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[158]);
            		}

            // Baserequirements.g:1605:3: ( (a21= 'author' a22= ':' (a23= QUOTED_34_34 ) ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==29) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // Baserequirements.g:1606:4: (a21= 'author' a22= ':' (a23= QUOTED_34_34 ) )
                    {
                    // Baserequirements.g:1606:4: (a21= 'author' a22= ':' (a23= QUOTED_34_34 ) )
                    // Baserequirements.g:1607:5: a21= 'author' a22= ':' (a23= QUOTED_34_34 )
                    {
                    a21=(Token)match(input,29,FOLLOW_29_in_parse_baserequirements_Requirement1609); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    					if (element == null) {
                    						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
                    						startIncompleteElement(element);
                    					}
                    					collectHiddenTokens(element);
                    					retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_6_0_0_0, null, true);
                    					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a21, element);
                    				}

                    if ( state.backtracking==0 ) {
                    					// expected elements (follow set)
                    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[159]);
                    				}

                    a22=(Token)match(input,10,FOLLOW_10_in_parse_baserequirements_Requirement1632); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    					if (element == null) {
                    						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
                    						startIncompleteElement(element);
                    					}
                    					collectHiddenTokens(element);
                    					retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_6_0_0_1, null, true);
                    					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a22, element);
                    				}

                    if ( state.backtracking==0 ) {
                    					// expected elements (follow set)
                    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[160]);
                    				}

                    // Baserequirements.g:1635:5: (a23= QUOTED_34_34 )
                    // Baserequirements.g:1636:6: a23= QUOTED_34_34
                    {
                    a23=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_baserequirements_Requirement1662); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    						if (terminateParsing) {
                    							throw new baserequirements.resource.baserequirements.mopp.BaserequirementsTerminateParsingException();
                    						}
                    						if (element == null) {
                    							element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
                    							startIncompleteElement(element);
                    						}
                    						if (a23 != null) {
                    							baserequirements.resource.baserequirements.IBaserequirementsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
                    							tokenResolver.setOptions(getOptions());
                    							baserequirements.resource.baserequirements.IBaserequirementsTokenResolveResult result = getFreshTokenResolveResult();
                    							tokenResolver.resolve(a23.getText(), element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.REQUIREMENT__AUTHOR), result);
                    							Object resolvedObject = result.getResolvedToken();
                    							if (resolvedObject == null) {
                    								addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a23).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a23).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a23).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a23).getStopIndex());
                    							}
                    							java.lang.String resolved = (java.lang.String) resolvedObject;
                    							if (resolved != null) {
                    								Object value = resolved;
                    								element.eSet(element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.REQUIREMENT__AUTHOR), value);
                    								completedElement(value, false);
                    							}
                    							collectHiddenTokens(element);
                    							retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_6_0_0_2, resolved, true);
                    							copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a23, element);
                    						}
                    					}

                    }


                    if ( state.backtracking==0 ) {
                    					// expected elements (follow set)
                    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[161]);
                    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[162]);
                    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[163]);
                    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[164]);
                    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[165]);
                    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[166]);
                    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[167]);
                    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[168]);
                    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[169]);
                    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[170]);
                    				}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            			// expected elements (follow set)
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[171]);
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[172]);
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[173]);
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[174]);
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[175]);
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[176]);
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[177]);
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[178]);
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[179]);
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[180]);
            		}

            // Baserequirements.g:1696:3: ( (a24= 'created' a25= ':' (a26= TEXT ) ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==33) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // Baserequirements.g:1697:4: (a24= 'created' a25= ':' (a26= TEXT ) )
                    {
                    // Baserequirements.g:1697:4: (a24= 'created' a25= ':' (a26= TEXT ) )
                    // Baserequirements.g:1698:5: a24= 'created' a25= ':' (a26= TEXT )
                    {
                    a24=(Token)match(input,33,FOLLOW_33_in_parse_baserequirements_Requirement1730); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    					if (element == null) {
                    						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
                    						startIncompleteElement(element);
                    					}
                    					collectHiddenTokens(element);
                    					retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_7_0_0_0, null, true);
                    					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a24, element);
                    				}

                    if ( state.backtracking==0 ) {
                    					// expected elements (follow set)
                    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[181]);
                    				}

                    a25=(Token)match(input,10,FOLLOW_10_in_parse_baserequirements_Requirement1753); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    					if (element == null) {
                    						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
                    						startIncompleteElement(element);
                    					}
                    					collectHiddenTokens(element);
                    					retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_7_0_0_1, null, true);
                    					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a25, element);
                    				}

                    if ( state.backtracking==0 ) {
                    					// expected elements (follow set)
                    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[182]);
                    				}

                    // Baserequirements.g:1726:5: (a26= TEXT )
                    // Baserequirements.g:1727:6: a26= TEXT
                    {
                    a26=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_baserequirements_Requirement1783); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    						if (terminateParsing) {
                    							throw new baserequirements.resource.baserequirements.mopp.BaserequirementsTerminateParsingException();
                    						}
                    						if (element == null) {
                    							element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
                    							startIncompleteElement(element);
                    						}
                    						if (a26 != null) {
                    							baserequirements.resource.baserequirements.IBaserequirementsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
                    							tokenResolver.setOptions(getOptions());
                    							baserequirements.resource.baserequirements.IBaserequirementsTokenResolveResult result = getFreshTokenResolveResult();
                    							tokenResolver.resolve(a26.getText(), element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.REQUIREMENT__CREATED), result);
                    							Object resolvedObject = result.getResolvedToken();
                    							if (resolvedObject == null) {
                    								addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a26).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a26).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a26).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a26).getStopIndex());
                    							}
                    							java.util.Date resolved = (java.util.Date) resolvedObject;
                    							if (resolved != null) {
                    								Object value = resolved;
                    								element.eSet(element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.REQUIREMENT__CREATED), value);
                    								completedElement(value, false);
                    							}
                    							collectHiddenTokens(element);
                    							retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_7_0_0_2, resolved, true);
                    							copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a26, element);
                    						}
                    					}

                    }


                    if ( state.backtracking==0 ) {
                    					// expected elements (follow set)
                    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[183]);
                    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[184]);
                    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[185]);
                    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[186]);
                    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[187]);
                    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[188]);
                    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[189]);
                    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[190]);
                    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[191]);
                    				}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            			// expected elements (follow set)
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[192]);
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[193]);
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[194]);
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[195]);
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[196]);
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[197]);
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[198]);
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[199]);
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[200]);
            		}

            // Baserequirements.g:1785:3: ( (a27= 'id' a28= ':' (a29= QUOTED_34_34 ) ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==37) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // Baserequirements.g:1786:4: (a27= 'id' a28= ':' (a29= QUOTED_34_34 ) )
                    {
                    // Baserequirements.g:1786:4: (a27= 'id' a28= ':' (a29= QUOTED_34_34 ) )
                    // Baserequirements.g:1787:5: a27= 'id' a28= ':' (a29= QUOTED_34_34 )
                    {
                    a27=(Token)match(input,37,FOLLOW_37_in_parse_baserequirements_Requirement1851); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    					if (element == null) {
                    						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
                    						startIncompleteElement(element);
                    					}
                    					collectHiddenTokens(element);
                    					retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_8_0_0_0, null, true);
                    					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a27, element);
                    				}

                    if ( state.backtracking==0 ) {
                    					// expected elements (follow set)
                    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[201]);
                    				}

                    a28=(Token)match(input,10,FOLLOW_10_in_parse_baserequirements_Requirement1874); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    					if (element == null) {
                    						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
                    						startIncompleteElement(element);
                    					}
                    					collectHiddenTokens(element);
                    					retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_8_0_0_1, null, true);
                    					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a28, element);
                    				}

                    if ( state.backtracking==0 ) {
                    					// expected elements (follow set)
                    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[202]);
                    				}

                    // Baserequirements.g:1815:5: (a29= QUOTED_34_34 )
                    // Baserequirements.g:1816:6: a29= QUOTED_34_34
                    {
                    a29=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_baserequirements_Requirement1904); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    						if (terminateParsing) {
                    							throw new baserequirements.resource.baserequirements.mopp.BaserequirementsTerminateParsingException();
                    						}
                    						if (element == null) {
                    							element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
                    							startIncompleteElement(element);
                    						}
                    						if (a29 != null) {
                    							baserequirements.resource.baserequirements.IBaserequirementsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
                    							tokenResolver.setOptions(getOptions());
                    							baserequirements.resource.baserequirements.IBaserequirementsTokenResolveResult result = getFreshTokenResolveResult();
                    							tokenResolver.resolve(a29.getText(), element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.REQUIREMENT__ID), result);
                    							Object resolvedObject = result.getResolvedToken();
                    							if (resolvedObject == null) {
                    								addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a29).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a29).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a29).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a29).getStopIndex());
                    							}
                    							java.lang.String resolved = (java.lang.String) resolvedObject;
                    							if (resolved != null) {
                    								Object value = resolved;
                    								element.eSet(element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.REQUIREMENT__ID), value);
                    								completedElement(value, false);
                    							}
                    							collectHiddenTokens(element);
                    							retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_8_0_0_2, resolved, true);
                    							copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a29, element);
                    						}
                    					}

                    }


                    if ( state.backtracking==0 ) {
                    					// expected elements (follow set)
                    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[203]);
                    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[204]);
                    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[205]);
                    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[206]);
                    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[207]);
                    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[208]);
                    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[209]);
                    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[210]);
                    				}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            			// expected elements (follow set)
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[211]);
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[212]);
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[213]);
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[214]);
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[215]);
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[216]);
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[217]);
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[218]);
            		}

            // Baserequirements.g:1872:3: ( (a30= 'state' a31= ':' ( (a32= 'NEW' |a33= 'REVIEWED' |a34= 'APPROVED' |a35= 'RESOLVED' ) ) ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==46) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // Baserequirements.g:1873:4: (a30= 'state' a31= ':' ( (a32= 'NEW' |a33= 'REVIEWED' |a34= 'APPROVED' |a35= 'RESOLVED' ) ) )
                    {
                    // Baserequirements.g:1873:4: (a30= 'state' a31= ':' ( (a32= 'NEW' |a33= 'REVIEWED' |a34= 'APPROVED' |a35= 'RESOLVED' ) ) )
                    // Baserequirements.g:1874:5: a30= 'state' a31= ':' ( (a32= 'NEW' |a33= 'REVIEWED' |a34= 'APPROVED' |a35= 'RESOLVED' ) )
                    {
                    a30=(Token)match(input,46,FOLLOW_46_in_parse_baserequirements_Requirement1972); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    					if (element == null) {
                    						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
                    						startIncompleteElement(element);
                    					}
                    					collectHiddenTokens(element);
                    					retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_9_0_0_0, null, true);
                    					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a30, element);
                    				}

                    if ( state.backtracking==0 ) {
                    					// expected elements (follow set)
                    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[219]);
                    				}

                    a31=(Token)match(input,10,FOLLOW_10_in_parse_baserequirements_Requirement1995); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    					if (element == null) {
                    						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
                    						startIncompleteElement(element);
                    					}
                    					collectHiddenTokens(element);
                    					retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_9_0_0_1, null, true);
                    					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a31, element);
                    				}

                    if ( state.backtracking==0 ) {
                    					// expected elements (follow set)
                    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[220]);
                    				}

                    // Baserequirements.g:1902:5: ( (a32= 'NEW' |a33= 'REVIEWED' |a34= 'APPROVED' |a35= 'RESOLVED' ) )
                    // Baserequirements.g:1903:6: (a32= 'NEW' |a33= 'REVIEWED' |a34= 'APPROVED' |a35= 'RESOLVED' )
                    {
                    // Baserequirements.g:1903:6: (a32= 'NEW' |a33= 'REVIEWED' |a34= 'APPROVED' |a35= 'RESOLVED' )
                    int alt14=4;
                    switch ( input.LA(1) ) {
                    case 22:
                        {
                        alt14=1;
                        }
                        break;
                    case 25:
                        {
                        alt14=2;
                        }
                        break;
                    case 12:
                        {
                        alt14=3;
                        }
                        break;
                    case 24:
                        {
                        alt14=4;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return element;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 14, 0, input);

                        throw nvae;

                    }

                    switch (alt14) {
                        case 1 :
                            // Baserequirements.g:1904:7: a32= 'NEW'
                            {
                            a32=(Token)match(input,22,FOLLOW_22_in_parse_baserequirements_Requirement2033); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            							if (element == null) {
                            								element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
                            								startIncompleteElement(element);
                            							}
                            							collectHiddenTokens(element);
                            							retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_9_0_0_2, null, true);
                            							copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a32, element);
                            							// set value of enumeration attribute
                            							Object value = baserequirements.BaserequirementsPackage.eINSTANCE.getState().getEEnumLiteral(baserequirements.State.NEW_VALUE).getInstance();
                            							element.eSet(element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.REQUIREMENT__STATE), value);
                            							completedElement(value, false);
                            						}

                            }
                            break;
                        case 2 :
                            // Baserequirements.g:1917:14: a33= 'REVIEWED'
                            {
                            a33=(Token)match(input,25,FOLLOW_25_in_parse_baserequirements_Requirement2054); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            							if (element == null) {
                            								element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
                            								startIncompleteElement(element);
                            							}
                            							collectHiddenTokens(element);
                            							retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_9_0_0_2, null, true);
                            							copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a33, element);
                            							// set value of enumeration attribute
                            							Object value = baserequirements.BaserequirementsPackage.eINSTANCE.getState().getEEnumLiteral(baserequirements.State.REVIEWED_VALUE).getInstance();
                            							element.eSet(element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.REQUIREMENT__STATE), value);
                            							completedElement(value, false);
                            						}

                            }
                            break;
                        case 3 :
                            // Baserequirements.g:1930:14: a34= 'APPROVED'
                            {
                            a34=(Token)match(input,12,FOLLOW_12_in_parse_baserequirements_Requirement2075); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            							if (element == null) {
                            								element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
                            								startIncompleteElement(element);
                            							}
                            							collectHiddenTokens(element);
                            							retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_9_0_0_2, null, true);
                            							copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a34, element);
                            							// set value of enumeration attribute
                            							Object value = baserequirements.BaserequirementsPackage.eINSTANCE.getState().getEEnumLiteral(baserequirements.State.APPROVED_VALUE).getInstance();
                            							element.eSet(element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.REQUIREMENT__STATE), value);
                            							completedElement(value, false);
                            						}

                            }
                            break;
                        case 4 :
                            // Baserequirements.g:1943:14: a35= 'RESOLVED'
                            {
                            a35=(Token)match(input,24,FOLLOW_24_in_parse_baserequirements_Requirement2096); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            							if (element == null) {
                            								element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
                            								startIncompleteElement(element);
                            							}
                            							collectHiddenTokens(element);
                            							retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_9_0_0_2, null, true);
                            							copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a35, element);
                            							// set value of enumeration attribute
                            							Object value = baserequirements.BaserequirementsPackage.eINSTANCE.getState().getEEnumLiteral(baserequirements.State.RESOLVED_VALUE).getInstance();
                            							element.eSet(element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.REQUIREMENT__STATE), value);
                            							completedElement(value, false);
                            						}

                            }
                            break;

                    }


                    }


                    if ( state.backtracking==0 ) {
                    					// expected elements (follow set)
                    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[221]);
                    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[222]);
                    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[223]);
                    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[224]);
                    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[225]);
                    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[226]);
                    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[227]);
                    				}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            			// expected elements (follow set)
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[228]);
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[229]);
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[230]);
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[231]);
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[232]);
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[233]);
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[234]);
            		}

            // Baserequirements.g:1982:3: ( (a38= 'resolution' a39= ':' ( (a40= 'INVALID' |a41= 'ACCEPTED' |a42= 'IMPLEMENTED' |a43= 'LATER' ) ) ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==44) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // Baserequirements.g:1983:4: (a38= 'resolution' a39= ':' ( (a40= 'INVALID' |a41= 'ACCEPTED' |a42= 'IMPLEMENTED' |a43= 'LATER' ) ) )
                    {
                    // Baserequirements.g:1983:4: (a38= 'resolution' a39= ':' ( (a40= 'INVALID' |a41= 'ACCEPTED' |a42= 'IMPLEMENTED' |a43= 'LATER' ) ) )
                    // Baserequirements.g:1984:5: a38= 'resolution' a39= ':' ( (a40= 'INVALID' |a41= 'ACCEPTED' |a42= 'IMPLEMENTED' |a43= 'LATER' ) )
                    {
                    a38=(Token)match(input,44,FOLLOW_44_in_parse_baserequirements_Requirement2161); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    					if (element == null) {
                    						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
                    						startIncompleteElement(element);
                    					}
                    					collectHiddenTokens(element);
                    					retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_10_0_0_0, null, true);
                    					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a38, element);
                    				}

                    if ( state.backtracking==0 ) {
                    					// expected elements (follow set)
                    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[235]);
                    				}

                    a39=(Token)match(input,10,FOLLOW_10_in_parse_baserequirements_Requirement2184); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    					if (element == null) {
                    						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
                    						startIncompleteElement(element);
                    					}
                    					collectHiddenTokens(element);
                    					retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_10_0_0_1, null, true);
                    					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a39, element);
                    				}

                    if ( state.backtracking==0 ) {
                    					// expected elements (follow set)
                    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[236]);
                    				}

                    // Baserequirements.g:2012:5: ( (a40= 'INVALID' |a41= 'ACCEPTED' |a42= 'IMPLEMENTED' |a43= 'LATER' ) )
                    // Baserequirements.g:2013:6: (a40= 'INVALID' |a41= 'ACCEPTED' |a42= 'IMPLEMENTED' |a43= 'LATER' )
                    {
                    // Baserequirements.g:2013:6: (a40= 'INVALID' |a41= 'ACCEPTED' |a42= 'IMPLEMENTED' |a43= 'LATER' )
                    int alt16=4;
                    switch ( input.LA(1) ) {
                    case 17:
                        {
                        alt16=1;
                        }
                        break;
                    case 11:
                        {
                        alt16=2;
                        }
                        break;
                    case 16:
                        {
                        alt16=3;
                        }
                        break;
                    case 18:
                        {
                        alt16=4;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return element;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 16, 0, input);

                        throw nvae;

                    }

                    switch (alt16) {
                        case 1 :
                            // Baserequirements.g:2014:7: a40= 'INVALID'
                            {
                            a40=(Token)match(input,17,FOLLOW_17_in_parse_baserequirements_Requirement2222); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            							if (element == null) {
                            								element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
                            								startIncompleteElement(element);
                            							}
                            							collectHiddenTokens(element);
                            							retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_10_0_0_2, null, true);
                            							copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a40, element);
                            							// set value of enumeration attribute
                            							Object value = baserequirements.BaserequirementsPackage.eINSTANCE.getResolution().getEEnumLiteral(baserequirements.Resolution.INVALID_VALUE).getInstance();
                            							element.eSet(element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.REQUIREMENT__RESOLUTION), value);
                            							completedElement(value, false);
                            						}

                            }
                            break;
                        case 2 :
                            // Baserequirements.g:2027:14: a41= 'ACCEPTED'
                            {
                            a41=(Token)match(input,11,FOLLOW_11_in_parse_baserequirements_Requirement2243); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            							if (element == null) {
                            								element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
                            								startIncompleteElement(element);
                            							}
                            							collectHiddenTokens(element);
                            							retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_10_0_0_2, null, true);
                            							copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a41, element);
                            							// set value of enumeration attribute
                            							Object value = baserequirements.BaserequirementsPackage.eINSTANCE.getResolution().getEEnumLiteral(baserequirements.Resolution.ACCEPTED_VALUE).getInstance();
                            							element.eSet(element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.REQUIREMENT__RESOLUTION), value);
                            							completedElement(value, false);
                            						}

                            }
                            break;
                        case 3 :
                            // Baserequirements.g:2040:14: a42= 'IMPLEMENTED'
                            {
                            a42=(Token)match(input,16,FOLLOW_16_in_parse_baserequirements_Requirement2264); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            							if (element == null) {
                            								element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
                            								startIncompleteElement(element);
                            							}
                            							collectHiddenTokens(element);
                            							retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_10_0_0_2, null, true);
                            							copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a42, element);
                            							// set value of enumeration attribute
                            							Object value = baserequirements.BaserequirementsPackage.eINSTANCE.getResolution().getEEnumLiteral(baserequirements.Resolution.IMPLEMENTED_VALUE).getInstance();
                            							element.eSet(element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.REQUIREMENT__RESOLUTION), value);
                            							completedElement(value, false);
                            						}

                            }
                            break;
                        case 4 :
                            // Baserequirements.g:2053:14: a43= 'LATER'
                            {
                            a43=(Token)match(input,18,FOLLOW_18_in_parse_baserequirements_Requirement2285); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            							if (element == null) {
                            								element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
                            								startIncompleteElement(element);
                            							}
                            							collectHiddenTokens(element);
                            							retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_10_0_0_2, null, true);
                            							copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a43, element);
                            							// set value of enumeration attribute
                            							Object value = baserequirements.BaserequirementsPackage.eINSTANCE.getResolution().getEEnumLiteral(baserequirements.Resolution.LATER_VALUE).getInstance();
                            							element.eSet(element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.REQUIREMENT__RESOLUTION), value);
                            							completedElement(value, false);
                            						}

                            }
                            break;

                    }


                    }


                    if ( state.backtracking==0 ) {
                    					// expected elements (follow set)
                    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[237]);
                    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[238]);
                    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[239]);
                    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[240]);
                    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[241]);
                    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[242]);
                    				}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            			// expected elements (follow set)
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[243]);
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[244]);
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[245]);
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[246]);
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[247]);
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[248]);
            		}

            // Baserequirements.g:2090:3: ( (a46= 'version' a47= ':' (a48_0= parse_baserequirements_Version ) ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==50) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // Baserequirements.g:2091:4: (a46= 'version' a47= ':' (a48_0= parse_baserequirements_Version ) )
                    {
                    // Baserequirements.g:2091:4: (a46= 'version' a47= ':' (a48_0= parse_baserequirements_Version ) )
                    // Baserequirements.g:2092:5: a46= 'version' a47= ':' (a48_0= parse_baserequirements_Version )
                    {
                    a46=(Token)match(input,50,FOLLOW_50_in_parse_baserequirements_Requirement2350); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    					if (element == null) {
                    						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
                    						startIncompleteElement(element);
                    					}
                    					collectHiddenTokens(element);
                    					retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_11_0_0_0, null, true);
                    					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a46, element);
                    				}

                    if ( state.backtracking==0 ) {
                    					// expected elements (follow set)
                    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[249]);
                    				}

                    a47=(Token)match(input,10,FOLLOW_10_in_parse_baserequirements_Requirement2373); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    					if (element == null) {
                    						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
                    						startIncompleteElement(element);
                    					}
                    					collectHiddenTokens(element);
                    					retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_11_0_0_1, null, true);
                    					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a47, element);
                    				}

                    if ( state.backtracking==0 ) {
                    					// expected elements (follow set)
                    					addExpectedElement(baserequirements.BaserequirementsPackage.eINSTANCE.getRequirement(), baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[250]);
                    				}

                    // Baserequirements.g:2120:5: (a48_0= parse_baserequirements_Version )
                    // Baserequirements.g:2121:6: a48_0= parse_baserequirements_Version
                    {
                    pushFollow(FOLLOW_parse_baserequirements_Version_in_parse_baserequirements_Requirement2403);
                    a48_0=parse_baserequirements_Version();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    						if (terminateParsing) {
                    							throw new baserequirements.resource.baserequirements.mopp.BaserequirementsTerminateParsingException();
                    						}
                    						if (element == null) {
                    							element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
                    							startIncompleteElement(element);
                    						}
                    						if (a48_0 != null) {
                    							if (a48_0 != null) {
                    								Object value = a48_0;
                    								element.eSet(element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.REQUIREMENT__VERSION), value);
                    								completedElement(value, true);
                    							}
                    							collectHiddenTokens(element);
                    							retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_11_0_0_2, a48_0, true);
                    							copyLocalizationInfos(a48_0, element);
                    						}
                    					}

                    }


                    if ( state.backtracking==0 ) {
                    					// expected elements (follow set)
                    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[251]);
                    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[252]);
                    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[253]);
                    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[254]);
                    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[255]);
                    				}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            			// expected elements (follow set)
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[256]);
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[257]);
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[258]);
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[259]);
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[260]);
            		}

            // Baserequirements.g:2161:3: ( (a49= 'comments' a50= ':' (a51_0= parse_baserequirements_Comment ) ) )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==32) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // Baserequirements.g:2162:4: (a49= 'comments' a50= ':' (a51_0= parse_baserequirements_Comment ) )
            	    {
            	    // Baserequirements.g:2162:4: (a49= 'comments' a50= ':' (a51_0= parse_baserequirements_Comment ) )
            	    // Baserequirements.g:2163:5: a49= 'comments' a50= ':' (a51_0= parse_baserequirements_Comment )
            	    {
            	    a49=(Token)match(input,32,FOLLOW_32_in_parse_baserequirements_Requirement2465); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    					if (element == null) {
            	    						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
            	    						startIncompleteElement(element);
            	    					}
            	    					collectHiddenTokens(element);
            	    					retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_12_0_0_0, null, true);
            	    					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a49, element);
            	    				}

            	    if ( state.backtracking==0 ) {
            	    					// expected elements (follow set)
            	    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[261]);
            	    				}

            	    a50=(Token)match(input,10,FOLLOW_10_in_parse_baserequirements_Requirement2488); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    					if (element == null) {
            	    						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
            	    						startIncompleteElement(element);
            	    					}
            	    					collectHiddenTokens(element);
            	    					retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_12_0_0_1, null, true);
            	    					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a50, element);
            	    				}

            	    if ( state.backtracking==0 ) {
            	    					// expected elements (follow set)
            	    					addExpectedElement(baserequirements.BaserequirementsPackage.eINSTANCE.getRequirement(), baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[262]);
            	    				}

            	    // Baserequirements.g:2191:5: (a51_0= parse_baserequirements_Comment )
            	    // Baserequirements.g:2192:6: a51_0= parse_baserequirements_Comment
            	    {
            	    pushFollow(FOLLOW_parse_baserequirements_Comment_in_parse_baserequirements_Requirement2518);
            	    a51_0=parse_baserequirements_Comment();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    						if (terminateParsing) {
            	    							throw new baserequirements.resource.baserequirements.mopp.BaserequirementsTerminateParsingException();
            	    						}
            	    						if (element == null) {
            	    							element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
            	    							startIncompleteElement(element);
            	    						}
            	    						if (a51_0 != null) {
            	    							if (a51_0 != null) {
            	    								Object value = a51_0;
            	    								addObjectToList(element, baserequirements.BaserequirementsPackage.REQUIREMENT__COMMENTS, value);
            	    								completedElement(value, true);
            	    							}
            	    							collectHiddenTokens(element);
            	    							retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_12_0_0_2, a51_0, true);
            	    							copyLocalizationInfos(a51_0, element);
            	    						}
            	    					}

            	    }


            	    if ( state.backtracking==0 ) {
            	    					// expected elements (follow set)
            	    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[263]);
            	    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[264]);
            	    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[265]);
            	    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[266]);
            	    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[267]);
            	    				}

            	    }


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            			// expected elements (follow set)
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[268]);
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[269]);
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[270]);
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[271]);
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[272]);
            		}

            // Baserequirements.g:2232:3: ( (a52= 'dependencies' a53= ':' (a54= TEXT ) ) )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==34) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // Baserequirements.g:2233:4: (a52= 'dependencies' a53= ':' (a54= TEXT ) )
            	    {
            	    // Baserequirements.g:2233:4: (a52= 'dependencies' a53= ':' (a54= TEXT ) )
            	    // Baserequirements.g:2234:5: a52= 'dependencies' a53= ':' (a54= TEXT )
            	    {
            	    a52=(Token)match(input,34,FOLLOW_34_in_parse_baserequirements_Requirement2580); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    					if (element == null) {
            	    						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
            	    						startIncompleteElement(element);
            	    					}
            	    					collectHiddenTokens(element);
            	    					retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_13_0_0_0, null, true);
            	    					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a52, element);
            	    				}

            	    if ( state.backtracking==0 ) {
            	    					// expected elements (follow set)
            	    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[273]);
            	    				}

            	    a53=(Token)match(input,10,FOLLOW_10_in_parse_baserequirements_Requirement2603); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    					if (element == null) {
            	    						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
            	    						startIncompleteElement(element);
            	    					}
            	    					collectHiddenTokens(element);
            	    					retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_13_0_0_1, null, true);
            	    					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a53, element);
            	    				}

            	    if ( state.backtracking==0 ) {
            	    					// expected elements (follow set)
            	    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[274]);
            	    				}

            	    // Baserequirements.g:2262:5: (a54= TEXT )
            	    // Baserequirements.g:2263:6: a54= TEXT
            	    {
            	    a54=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_baserequirements_Requirement2633); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    						if (terminateParsing) {
            	    							throw new baserequirements.resource.baserequirements.mopp.BaserequirementsTerminateParsingException();
            	    						}
            	    						if (element == null) {
            	    							element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
            	    							startIncompleteElement(element);
            	    						}
            	    						if (a54 != null) {
            	    							baserequirements.resource.baserequirements.IBaserequirementsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            	    							tokenResolver.setOptions(getOptions());
            	    							baserequirements.resource.baserequirements.IBaserequirementsTokenResolveResult result = getFreshTokenResolveResult();
            	    							tokenResolver.resolve(a54.getText(), element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.REQUIREMENT__DEPENDENCIES), result);
            	    							Object resolvedObject = result.getResolvedToken();
            	    							if (resolvedObject == null) {
            	    								addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a54).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a54).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a54).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a54).getStopIndex());
            	    							}
            	    							String resolved = (String) resolvedObject;
            	    							baserequirements.Requirement proxy = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
            	    							collectHiddenTokens(element);
            	    							registerContextDependentProxy(new baserequirements.resource.baserequirements.mopp.BaserequirementsContextDependentURIFragmentFactory<baserequirements.Requirement, baserequirements.Requirement>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getRequirementDependenciesReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.REQUIREMENT__DEPENDENCIES), resolved, proxy);
            	    							if (proxy != null) {
            	    								Object value = proxy;
            	    								addObjectToList(element, baserequirements.BaserequirementsPackage.REQUIREMENT__DEPENDENCIES, value);
            	    								completedElement(value, false);
            	    							}
            	    							collectHiddenTokens(element);
            	    							retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_13_0_0_2, proxy, true);
            	    							copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a54, element);
            	    							copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a54, proxy);
            	    						}
            	    					}

            	    }


            	    if ( state.backtracking==0 ) {
            	    					// expected elements (follow set)
            	    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[275]);
            	    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[276]);
            	    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[277]);
            	    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[278]);
            	    				}

            	    }


            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            			// expected elements (follow set)
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[279]);
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[280]);
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[281]);
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[282]);
            		}

            // Baserequirements.g:2315:3: ( (a55= 'parent' a56= ':' (a57= TEXT ) ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==41) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // Baserequirements.g:2316:4: (a55= 'parent' a56= ':' (a57= TEXT ) )
                    {
                    // Baserequirements.g:2316:4: (a55= 'parent' a56= ':' (a57= TEXT ) )
                    // Baserequirements.g:2317:5: a55= 'parent' a56= ':' (a57= TEXT )
                    {
                    a55=(Token)match(input,41,FOLLOW_41_in_parse_baserequirements_Requirement2701); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    					if (element == null) {
                    						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
                    						startIncompleteElement(element);
                    					}
                    					collectHiddenTokens(element);
                    					retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_14_0_0_0, null, true);
                    					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a55, element);
                    				}

                    if ( state.backtracking==0 ) {
                    					// expected elements (follow set)
                    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[283]);
                    				}

                    a56=(Token)match(input,10,FOLLOW_10_in_parse_baserequirements_Requirement2724); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    					if (element == null) {
                    						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
                    						startIncompleteElement(element);
                    					}
                    					collectHiddenTokens(element);
                    					retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_14_0_0_1, null, true);
                    					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a56, element);
                    				}

                    if ( state.backtracking==0 ) {
                    					// expected elements (follow set)
                    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[284]);
                    				}

                    // Baserequirements.g:2345:5: (a57= TEXT )
                    // Baserequirements.g:2346:6: a57= TEXT
                    {
                    a57=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_baserequirements_Requirement2754); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    						if (terminateParsing) {
                    							throw new baserequirements.resource.baserequirements.mopp.BaserequirementsTerminateParsingException();
                    						}
                    						if (element == null) {
                    							element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
                    							startIncompleteElement(element);
                    						}
                    						if (a57 != null) {
                    							baserequirements.resource.baserequirements.IBaserequirementsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
                    							tokenResolver.setOptions(getOptions());
                    							baserequirements.resource.baserequirements.IBaserequirementsTokenResolveResult result = getFreshTokenResolveResult();
                    							tokenResolver.resolve(a57.getText(), element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.REQUIREMENT__PARENT), result);
                    							Object resolvedObject = result.getResolvedToken();
                    							if (resolvedObject == null) {
                    								addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a57).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a57).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a57).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a57).getStopIndex());
                    							}
                    							String resolved = (String) resolvedObject;
                    							baserequirements.Requirement proxy = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
                    							collectHiddenTokens(element);
                    							registerContextDependentProxy(new baserequirements.resource.baserequirements.mopp.BaserequirementsContextDependentURIFragmentFactory<baserequirements.Requirement, baserequirements.Requirement>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getRequirementParentReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.REQUIREMENT__PARENT), resolved, proxy);
                    							if (proxy != null) {
                    								Object value = proxy;
                    								element.eSet(element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.REQUIREMENT__PARENT), value);
                    								completedElement(value, false);
                    							}
                    							collectHiddenTokens(element);
                    							retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_14_0_0_2, proxy, true);
                    							copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a57, element);
                    							copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a57, proxy);
                    						}
                    					}

                    }


                    if ( state.backtracking==0 ) {
                    					// expected elements (follow set)
                    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[285]);
                    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[286]);
                    				}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            			// expected elements (follow set)
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[287]);
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[288]);
            		}

            // Baserequirements.g:2394:3: ( (a58= 'children' a59= ':' (a60_0= parse_baserequirements_Requirement ) ) )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==31) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // Baserequirements.g:2395:4: (a58= 'children' a59= ':' (a60_0= parse_baserequirements_Requirement ) )
            	    {
            	    // Baserequirements.g:2395:4: (a58= 'children' a59= ':' (a60_0= parse_baserequirements_Requirement ) )
            	    // Baserequirements.g:2396:5: a58= 'children' a59= ':' (a60_0= parse_baserequirements_Requirement )
            	    {
            	    a58=(Token)match(input,31,FOLLOW_31_in_parse_baserequirements_Requirement2822); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    					if (element == null) {
            	    						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
            	    						startIncompleteElement(element);
            	    					}
            	    					collectHiddenTokens(element);
            	    					retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_15_0_0_0, null, true);
            	    					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a58, element);
            	    				}

            	    if ( state.backtracking==0 ) {
            	    					// expected elements (follow set)
            	    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[289]);
            	    				}

            	    a59=(Token)match(input,10,FOLLOW_10_in_parse_baserequirements_Requirement2845); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    					if (element == null) {
            	    						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
            	    						startIncompleteElement(element);
            	    					}
            	    					collectHiddenTokens(element);
            	    					retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_15_0_0_1, null, true);
            	    					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a59, element);
            	    				}

            	    if ( state.backtracking==0 ) {
            	    					// expected elements (follow set)
            	    					addExpectedElement(baserequirements.BaserequirementsPackage.eINSTANCE.getRequirement(), baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[290]);
            	    				}

            	    // Baserequirements.g:2424:5: (a60_0= parse_baserequirements_Requirement )
            	    // Baserequirements.g:2425:6: a60_0= parse_baserequirements_Requirement
            	    {
            	    pushFollow(FOLLOW_parse_baserequirements_Requirement_in_parse_baserequirements_Requirement2875);
            	    a60_0=parse_baserequirements_Requirement();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    						if (terminateParsing) {
            	    							throw new baserequirements.resource.baserequirements.mopp.BaserequirementsTerminateParsingException();
            	    						}
            	    						if (element == null) {
            	    							element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
            	    							startIncompleteElement(element);
            	    						}
            	    						if (a60_0 != null) {
            	    							if (a60_0 != null) {
            	    								Object value = a60_0;
            	    								addObjectToList(element, baserequirements.BaserequirementsPackage.REQUIREMENT__CHILDREN, value);
            	    								completedElement(value, true);
            	    							}
            	    							collectHiddenTokens(element);
            	    							retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_15_0_0_2, a60_0, true);
            	    							copyLocalizationInfos(a60_0, element);
            	    						}
            	    					}

            	    }


            	    if ( state.backtracking==0 ) {
            	    					// expected elements (follow set)
            	    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[291]);
            	    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[292]);
            	    				}

            	    }


            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            			// expected elements (follow set)
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[293]);
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[294]);
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[295]);
            	}

            a61=(Token)match(input,52,FOLLOW_52_in_parse_baserequirements_Requirement2933); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_3, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a61, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[296]);
            		addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[297]);
            		addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[298]);
            		addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[299]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 4, parse_baserequirements_Requirement_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_baserequirements_Requirement"



    // $ANTLR start "parse_baserequirements_Version"
    // Baserequirements.g:2484:1: parse_baserequirements_Version returns [baserequirements.Version element = null] : a0= 'Version' a1= '{' (a2= 'major' a3= ':' (a4= TEXT ) (a5= 'minor' a6= ':' (a7= TEXT ) ) (a8= 'service' a9= ':' (a10= TEXT ) ) ) a11= '}' ;
    public final baserequirements.Version parse_baserequirements_Version() throws RecognitionException {
        baserequirements.Version element =  null;

        int parse_baserequirements_Version_StartIndex = input.index();

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
        Token a11=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return element; }

            // Baserequirements.g:2487:2: (a0= 'Version' a1= '{' (a2= 'major' a3= ':' (a4= TEXT ) (a5= 'minor' a6= ':' (a7= TEXT ) ) (a8= 'service' a9= ':' (a10= TEXT ) ) ) a11= '}' )
            // Baserequirements.g:2488:2: a0= 'Version' a1= '{' (a2= 'major' a3= ':' (a4= TEXT ) (a5= 'minor' a6= ':' (a7= TEXT ) ) (a8= 'service' a9= ':' (a10= TEXT ) ) ) a11= '}'
            {
            a0=(Token)match(input,28,FOLLOW_28_in_parse_baserequirements_Version2962); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = baserequirements.BaserequirementsFactory.eINSTANCE.createVersion();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_3_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[300]);
            	}

            a1=(Token)match(input,51,FOLLOW_51_in_parse_baserequirements_Version2976); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = baserequirements.BaserequirementsFactory.eINSTANCE.createVersion();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_3_0_0_1, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[301]);
            	}

            // Baserequirements.g:2516:2: (a2= 'major' a3= ':' (a4= TEXT ) (a5= 'minor' a6= ':' (a7= TEXT ) ) (a8= 'service' a9= ':' (a10= TEXT ) ) )
            // Baserequirements.g:2517:3: a2= 'major' a3= ':' (a4= TEXT ) (a5= 'minor' a6= ':' (a7= TEXT ) ) (a8= 'service' a9= ':' (a10= TEXT ) )
            {
            a2=(Token)match(input,38,FOLLOW_38_in_parse_baserequirements_Version2994); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (element == null) {
            				element = baserequirements.BaserequirementsFactory.eINSTANCE.createVersion();
            				startIncompleteElement(element);
            			}
            			collectHiddenTokens(element);
            			retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_3_0_0_2_0_0_0, null, true);
            			copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
            		}

            if ( state.backtracking==0 ) {
            			// expected elements (follow set)
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[302]);
            		}

            a3=(Token)match(input,10,FOLLOW_10_in_parse_baserequirements_Version3011); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (element == null) {
            				element = baserequirements.BaserequirementsFactory.eINSTANCE.createVersion();
            				startIncompleteElement(element);
            			}
            			collectHiddenTokens(element);
            			retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_3_0_0_2_0_0_1, null, true);
            			copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
            		}

            if ( state.backtracking==0 ) {
            			// expected elements (follow set)
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[303]);
            		}

            // Baserequirements.g:2545:3: (a4= TEXT )
            // Baserequirements.g:2546:4: a4= TEXT
            {
            a4=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_baserequirements_Version3033); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            				if (terminateParsing) {
            					throw new baserequirements.resource.baserequirements.mopp.BaserequirementsTerminateParsingException();
            				}
            				if (element == null) {
            					element = baserequirements.BaserequirementsFactory.eINSTANCE.createVersion();
            					startIncompleteElement(element);
            				}
            				if (a4 != null) {
            					baserequirements.resource.baserequirements.IBaserequirementsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            					tokenResolver.setOptions(getOptions());
            					baserequirements.resource.baserequirements.IBaserequirementsTokenResolveResult result = getFreshTokenResolveResult();
            					tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.VERSION__MAJOR), result);
            					Object resolvedObject = result.getResolvedToken();
            					if (resolvedObject == null) {
            						addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a4).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStopIndex());
            					}
            					java.lang.Integer resolved = (java.lang.Integer) resolvedObject;
            					if (resolved != null) {
            						Object value = resolved;
            						element.eSet(element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.VERSION__MAJOR), value);
            						completedElement(value, false);
            					}
            					collectHiddenTokens(element);
            					retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_3_0_0_2_0_0_2, resolved, true);
            					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a4, element);
            				}
            			}

            }


            if ( state.backtracking==0 ) {
            			// expected elements (follow set)
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[304]);
            		}

            // Baserequirements.g:2581:3: (a5= 'minor' a6= ':' (a7= TEXT ) )
            // Baserequirements.g:2582:4: a5= 'minor' a6= ':' (a7= TEXT )
            {
            a5=(Token)match(input,39,FOLLOW_39_in_parse_baserequirements_Version3065); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            				if (element == null) {
            					element = baserequirements.BaserequirementsFactory.eINSTANCE.createVersion();
            					startIncompleteElement(element);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_3_0_0_2_0_0_3_0_0_0, null, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
            			}

            if ( state.backtracking==0 ) {
            				// expected elements (follow set)
            				addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[305]);
            			}

            a6=(Token)match(input,10,FOLLOW_10_in_parse_baserequirements_Version3085); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            				if (element == null) {
            					element = baserequirements.BaserequirementsFactory.eINSTANCE.createVersion();
            					startIncompleteElement(element);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_3_0_0_2_0_0_3_0_0_1, null, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
            			}

            if ( state.backtracking==0 ) {
            				// expected elements (follow set)
            				addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[306]);
            			}

            // Baserequirements.g:2610:4: (a7= TEXT )
            // Baserequirements.g:2611:5: a7= TEXT
            {
            a7=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_baserequirements_Version3111); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            					if (terminateParsing) {
            						throw new baserequirements.resource.baserequirements.mopp.BaserequirementsTerminateParsingException();
            					}
            					if (element == null) {
            						element = baserequirements.BaserequirementsFactory.eINSTANCE.createVersion();
            						startIncompleteElement(element);
            					}
            					if (a7 != null) {
            						baserequirements.resource.baserequirements.IBaserequirementsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            						tokenResolver.setOptions(getOptions());
            						baserequirements.resource.baserequirements.IBaserequirementsTokenResolveResult result = getFreshTokenResolveResult();
            						tokenResolver.resolve(a7.getText(), element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.VERSION__MINOR), result);
            						Object resolvedObject = result.getResolvedToken();
            						if (resolvedObject == null) {
            							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a7).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a7).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a7).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a7).getStopIndex());
            						}
            						java.lang.Integer resolved = (java.lang.Integer) resolvedObject;
            						if (resolved != null) {
            							Object value = resolved;
            							element.eSet(element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.VERSION__MINOR), value);
            							completedElement(value, false);
            						}
            						collectHiddenTokens(element);
            						retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_3_0_0_2_0_0_3_0_0_2, resolved, true);
            						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a7, element);
            					}
            				}

            }


            if ( state.backtracking==0 ) {
            				// expected elements (follow set)
            				addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[307]);
            			}

            }


            if ( state.backtracking==0 ) {
            			// expected elements (follow set)
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[308]);
            		}

            // Baserequirements.g:2652:3: (a8= 'service' a9= ':' (a10= TEXT ) )
            // Baserequirements.g:2653:4: a8= 'service' a9= ':' (a10= TEXT )
            {
            a8=(Token)match(input,45,FOLLOW_45_in_parse_baserequirements_Version3159); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            				if (element == null) {
            					element = baserequirements.BaserequirementsFactory.eINSTANCE.createVersion();
            					startIncompleteElement(element);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_3_0_0_2_0_0_4_0_0_0, null, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a8, element);
            			}

            if ( state.backtracking==0 ) {
            				// expected elements (follow set)
            				addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[309]);
            			}

            a9=(Token)match(input,10,FOLLOW_10_in_parse_baserequirements_Version3179); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            				if (element == null) {
            					element = baserequirements.BaserequirementsFactory.eINSTANCE.createVersion();
            					startIncompleteElement(element);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_3_0_0_2_0_0_4_0_0_1, null, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a9, element);
            			}

            if ( state.backtracking==0 ) {
            				// expected elements (follow set)
            				addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[310]);
            			}

            // Baserequirements.g:2681:4: (a10= TEXT )
            // Baserequirements.g:2682:5: a10= TEXT
            {
            a10=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_baserequirements_Version3205); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            					if (terminateParsing) {
            						throw new baserequirements.resource.baserequirements.mopp.BaserequirementsTerminateParsingException();
            					}
            					if (element == null) {
            						element = baserequirements.BaserequirementsFactory.eINSTANCE.createVersion();
            						startIncompleteElement(element);
            					}
            					if (a10 != null) {
            						baserequirements.resource.baserequirements.IBaserequirementsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            						tokenResolver.setOptions(getOptions());
            						baserequirements.resource.baserequirements.IBaserequirementsTokenResolveResult result = getFreshTokenResolveResult();
            						tokenResolver.resolve(a10.getText(), element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.VERSION__SERVICE), result);
            						Object resolvedObject = result.getResolvedToken();
            						if (resolvedObject == null) {
            							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a10).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a10).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a10).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a10).getStopIndex());
            						}
            						java.lang.Integer resolved = (java.lang.Integer) resolvedObject;
            						if (resolved != null) {
            							Object value = resolved;
            							element.eSet(element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.VERSION__SERVICE), value);
            							completedElement(value, false);
            						}
            						collectHiddenTokens(element);
            						retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_3_0_0_2_0_0_4_0_0_2, resolved, true);
            						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a10, element);
            					}
            				}

            }


            if ( state.backtracking==0 ) {
            				// expected elements (follow set)
            				addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[311]);
            			}

            }


            if ( state.backtracking==0 ) {
            			// expected elements (follow set)
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[312]);
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[313]);
            	}

            a11=(Token)match(input,52,FOLLOW_52_in_parse_baserequirements_Version3255); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = baserequirements.BaserequirementsFactory.eINSTANCE.createVersion();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_3_0_0_3, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a11, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[314]);
            		addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[315]);
            		addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[316]);
            		addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[317]);
            		addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[318]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 5, parse_baserequirements_Version_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_baserequirements_Version"



    // $ANTLR start "parse_baserequirements_Comment"
    // Baserequirements.g:2749:1: parse_baserequirements_Comment returns [baserequirements.Comment element = null] : a0= 'Comment' a1= '{' (a2= 'subject' a3= ':' (a4= QUOTED_34_34 ) (a5= 'body' a6= ':' (a7= QUOTED_34_34 ) ) (a8= 'author' a9= ':' (a10= QUOTED_34_34 ) ) (a11= 'created' a12= ':' (a13= TEXT ) ) ( (a14= 'children' a15= ':' (a16_0= parse_baserequirements_Comment ) ) )* ) a17= '}' ;
    public final baserequirements.Comment parse_baserequirements_Comment() throws RecognitionException {
        baserequirements.Comment element =  null;

        int parse_baserequirements_Comment_StartIndex = input.index();

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
        Token a11=null;
        Token a12=null;
        Token a13=null;
        Token a14=null;
        Token a15=null;
        Token a17=null;
        baserequirements.Comment a16_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return element; }

            // Baserequirements.g:2752:2: (a0= 'Comment' a1= '{' (a2= 'subject' a3= ':' (a4= QUOTED_34_34 ) (a5= 'body' a6= ':' (a7= QUOTED_34_34 ) ) (a8= 'author' a9= ':' (a10= QUOTED_34_34 ) ) (a11= 'created' a12= ':' (a13= TEXT ) ) ( (a14= 'children' a15= ':' (a16_0= parse_baserequirements_Comment ) ) )* ) a17= '}' )
            // Baserequirements.g:2753:2: a0= 'Comment' a1= '{' (a2= 'subject' a3= ':' (a4= QUOTED_34_34 ) (a5= 'body' a6= ':' (a7= QUOTED_34_34 ) ) (a8= 'author' a9= ':' (a10= QUOTED_34_34 ) ) (a11= 'created' a12= ':' (a13= TEXT ) ) ( (a14= 'children' a15= ':' (a16_0= parse_baserequirements_Comment ) ) )* ) a17= '}'
            {
            a0=(Token)match(input,13,FOLLOW_13_in_parse_baserequirements_Comment3284); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = baserequirements.BaserequirementsFactory.eINSTANCE.createComment();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_4_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[319]);
            	}

            a1=(Token)match(input,51,FOLLOW_51_in_parse_baserequirements_Comment3298); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = baserequirements.BaserequirementsFactory.eINSTANCE.createComment();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_4_0_0_1, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[320]);
            	}

            // Baserequirements.g:2781:2: (a2= 'subject' a3= ':' (a4= QUOTED_34_34 ) (a5= 'body' a6= ':' (a7= QUOTED_34_34 ) ) (a8= 'author' a9= ':' (a10= QUOTED_34_34 ) ) (a11= 'created' a12= ':' (a13= TEXT ) ) ( (a14= 'children' a15= ':' (a16_0= parse_baserequirements_Comment ) ) )* )
            // Baserequirements.g:2782:3: a2= 'subject' a3= ':' (a4= QUOTED_34_34 ) (a5= 'body' a6= ':' (a7= QUOTED_34_34 ) ) (a8= 'author' a9= ':' (a10= QUOTED_34_34 ) ) (a11= 'created' a12= ':' (a13= TEXT ) ) ( (a14= 'children' a15= ':' (a16_0= parse_baserequirements_Comment ) ) )*
            {
            a2=(Token)match(input,47,FOLLOW_47_in_parse_baserequirements_Comment3316); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (element == null) {
            				element = baserequirements.BaserequirementsFactory.eINSTANCE.createComment();
            				startIncompleteElement(element);
            			}
            			collectHiddenTokens(element);
            			retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_4_0_0_2_0_0_0, null, true);
            			copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
            		}

            if ( state.backtracking==0 ) {
            			// expected elements (follow set)
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[321]);
            		}

            a3=(Token)match(input,10,FOLLOW_10_in_parse_baserequirements_Comment3333); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (element == null) {
            				element = baserequirements.BaserequirementsFactory.eINSTANCE.createComment();
            				startIncompleteElement(element);
            			}
            			collectHiddenTokens(element);
            			retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_4_0_0_2_0_0_1, null, true);
            			copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
            		}

            if ( state.backtracking==0 ) {
            			// expected elements (follow set)
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[322]);
            		}

            // Baserequirements.g:2810:3: (a4= QUOTED_34_34 )
            // Baserequirements.g:2811:4: a4= QUOTED_34_34
            {
            a4=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_baserequirements_Comment3355); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            				if (terminateParsing) {
            					throw new baserequirements.resource.baserequirements.mopp.BaserequirementsTerminateParsingException();
            				}
            				if (element == null) {
            					element = baserequirements.BaserequirementsFactory.eINSTANCE.createComment();
            					startIncompleteElement(element);
            				}
            				if (a4 != null) {
            					baserequirements.resource.baserequirements.IBaserequirementsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
            					tokenResolver.setOptions(getOptions());
            					baserequirements.resource.baserequirements.IBaserequirementsTokenResolveResult result = getFreshTokenResolveResult();
            					tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.COMMENT__SUBJECT), result);
            					Object resolvedObject = result.getResolvedToken();
            					if (resolvedObject == null) {
            						addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a4).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStopIndex());
            					}
            					java.lang.String resolved = (java.lang.String) resolvedObject;
            					if (resolved != null) {
            						Object value = resolved;
            						element.eSet(element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.COMMENT__SUBJECT), value);
            						completedElement(value, false);
            					}
            					collectHiddenTokens(element);
            					retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_4_0_0_2_0_0_2, resolved, true);
            					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a4, element);
            				}
            			}

            }


            if ( state.backtracking==0 ) {
            			// expected elements (follow set)
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[323]);
            		}

            // Baserequirements.g:2846:3: (a5= 'body' a6= ':' (a7= QUOTED_34_34 ) )
            // Baserequirements.g:2847:4: a5= 'body' a6= ':' (a7= QUOTED_34_34 )
            {
            a5=(Token)match(input,30,FOLLOW_30_in_parse_baserequirements_Comment3387); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            				if (element == null) {
            					element = baserequirements.BaserequirementsFactory.eINSTANCE.createComment();
            					startIncompleteElement(element);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_4_0_0_2_0_0_3_0_0_0, null, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
            			}

            if ( state.backtracking==0 ) {
            				// expected elements (follow set)
            				addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[324]);
            			}

            a6=(Token)match(input,10,FOLLOW_10_in_parse_baserequirements_Comment3407); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            				if (element == null) {
            					element = baserequirements.BaserequirementsFactory.eINSTANCE.createComment();
            					startIncompleteElement(element);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_4_0_0_2_0_0_3_0_0_1, null, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
            			}

            if ( state.backtracking==0 ) {
            				// expected elements (follow set)
            				addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[325]);
            			}

            // Baserequirements.g:2875:4: (a7= QUOTED_34_34 )
            // Baserequirements.g:2876:5: a7= QUOTED_34_34
            {
            a7=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_baserequirements_Comment3433); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            					if (terminateParsing) {
            						throw new baserequirements.resource.baserequirements.mopp.BaserequirementsTerminateParsingException();
            					}
            					if (element == null) {
            						element = baserequirements.BaserequirementsFactory.eINSTANCE.createComment();
            						startIncompleteElement(element);
            					}
            					if (a7 != null) {
            						baserequirements.resource.baserequirements.IBaserequirementsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
            						tokenResolver.setOptions(getOptions());
            						baserequirements.resource.baserequirements.IBaserequirementsTokenResolveResult result = getFreshTokenResolveResult();
            						tokenResolver.resolve(a7.getText(), element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.COMMENT__BODY), result);
            						Object resolvedObject = result.getResolvedToken();
            						if (resolvedObject == null) {
            							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a7).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a7).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a7).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a7).getStopIndex());
            						}
            						java.lang.String resolved = (java.lang.String) resolvedObject;
            						if (resolved != null) {
            							Object value = resolved;
            							element.eSet(element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.COMMENT__BODY), value);
            							completedElement(value, false);
            						}
            						collectHiddenTokens(element);
            						retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_4_0_0_2_0_0_3_0_0_2, resolved, true);
            						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a7, element);
            					}
            				}

            }


            if ( state.backtracking==0 ) {
            				// expected elements (follow set)
            				addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[326]);
            			}

            }


            if ( state.backtracking==0 ) {
            			// expected elements (follow set)
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[327]);
            		}

            // Baserequirements.g:2917:3: (a8= 'author' a9= ':' (a10= QUOTED_34_34 ) )
            // Baserequirements.g:2918:4: a8= 'author' a9= ':' (a10= QUOTED_34_34 )
            {
            a8=(Token)match(input,29,FOLLOW_29_in_parse_baserequirements_Comment3481); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            				if (element == null) {
            					element = baserequirements.BaserequirementsFactory.eINSTANCE.createComment();
            					startIncompleteElement(element);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_4_0_0_2_0_0_4_0_0_0, null, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a8, element);
            			}

            if ( state.backtracking==0 ) {
            				// expected elements (follow set)
            				addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[328]);
            			}

            a9=(Token)match(input,10,FOLLOW_10_in_parse_baserequirements_Comment3501); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            				if (element == null) {
            					element = baserequirements.BaserequirementsFactory.eINSTANCE.createComment();
            					startIncompleteElement(element);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_4_0_0_2_0_0_4_0_0_1, null, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a9, element);
            			}

            if ( state.backtracking==0 ) {
            				// expected elements (follow set)
            				addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[329]);
            			}

            // Baserequirements.g:2946:4: (a10= QUOTED_34_34 )
            // Baserequirements.g:2947:5: a10= QUOTED_34_34
            {
            a10=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_baserequirements_Comment3527); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            					if (terminateParsing) {
            						throw new baserequirements.resource.baserequirements.mopp.BaserequirementsTerminateParsingException();
            					}
            					if (element == null) {
            						element = baserequirements.BaserequirementsFactory.eINSTANCE.createComment();
            						startIncompleteElement(element);
            					}
            					if (a10 != null) {
            						baserequirements.resource.baserequirements.IBaserequirementsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
            						tokenResolver.setOptions(getOptions());
            						baserequirements.resource.baserequirements.IBaserequirementsTokenResolveResult result = getFreshTokenResolveResult();
            						tokenResolver.resolve(a10.getText(), element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.COMMENT__AUTHOR), result);
            						Object resolvedObject = result.getResolvedToken();
            						if (resolvedObject == null) {
            							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a10).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a10).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a10).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a10).getStopIndex());
            						}
            						java.lang.String resolved = (java.lang.String) resolvedObject;
            						if (resolved != null) {
            							Object value = resolved;
            							element.eSet(element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.COMMENT__AUTHOR), value);
            							completedElement(value, false);
            						}
            						collectHiddenTokens(element);
            						retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_4_0_0_2_0_0_4_0_0_2, resolved, true);
            						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a10, element);
            					}
            				}

            }


            if ( state.backtracking==0 ) {
            				// expected elements (follow set)
            				addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[330]);
            			}

            }


            if ( state.backtracking==0 ) {
            			// expected elements (follow set)
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[331]);
            		}

            // Baserequirements.g:2988:3: (a11= 'created' a12= ':' (a13= TEXT ) )
            // Baserequirements.g:2989:4: a11= 'created' a12= ':' (a13= TEXT )
            {
            a11=(Token)match(input,33,FOLLOW_33_in_parse_baserequirements_Comment3575); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            				if (element == null) {
            					element = baserequirements.BaserequirementsFactory.eINSTANCE.createComment();
            					startIncompleteElement(element);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_4_0_0_2_0_0_5_0_0_0, null, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a11, element);
            			}

            if ( state.backtracking==0 ) {
            				// expected elements (follow set)
            				addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[332]);
            			}

            a12=(Token)match(input,10,FOLLOW_10_in_parse_baserequirements_Comment3595); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            				if (element == null) {
            					element = baserequirements.BaserequirementsFactory.eINSTANCE.createComment();
            					startIncompleteElement(element);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_4_0_0_2_0_0_5_0_0_1, null, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a12, element);
            			}

            if ( state.backtracking==0 ) {
            				// expected elements (follow set)
            				addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[333]);
            			}

            // Baserequirements.g:3017:4: (a13= TEXT )
            // Baserequirements.g:3018:5: a13= TEXT
            {
            a13=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_baserequirements_Comment3621); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            					if (terminateParsing) {
            						throw new baserequirements.resource.baserequirements.mopp.BaserequirementsTerminateParsingException();
            					}
            					if (element == null) {
            						element = baserequirements.BaserequirementsFactory.eINSTANCE.createComment();
            						startIncompleteElement(element);
            					}
            					if (a13 != null) {
            						baserequirements.resource.baserequirements.IBaserequirementsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            						tokenResolver.setOptions(getOptions());
            						baserequirements.resource.baserequirements.IBaserequirementsTokenResolveResult result = getFreshTokenResolveResult();
            						tokenResolver.resolve(a13.getText(), element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.COMMENT__CREATED), result);
            						Object resolvedObject = result.getResolvedToken();
            						if (resolvedObject == null) {
            							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a13).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a13).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a13).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a13).getStopIndex());
            						}
            						java.util.Date resolved = (java.util.Date) resolvedObject;
            						if (resolved != null) {
            							Object value = resolved;
            							element.eSet(element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.COMMENT__CREATED), value);
            							completedElement(value, false);
            						}
            						collectHiddenTokens(element);
            						retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_4_0_0_2_0_0_5_0_0_2, resolved, true);
            						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a13, element);
            					}
            				}

            }


            if ( state.backtracking==0 ) {
            				// expected elements (follow set)
            				addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[334]);
            				addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[335]);
            			}

            }


            if ( state.backtracking==0 ) {
            			// expected elements (follow set)
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[336]);
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[337]);
            		}

            // Baserequirements.g:3061:3: ( (a14= 'children' a15= ':' (a16_0= parse_baserequirements_Comment ) ) )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==31) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // Baserequirements.g:3062:4: (a14= 'children' a15= ':' (a16_0= parse_baserequirements_Comment ) )
            	    {
            	    // Baserequirements.g:3062:4: (a14= 'children' a15= ':' (a16_0= parse_baserequirements_Comment ) )
            	    // Baserequirements.g:3063:5: a14= 'children' a15= ':' (a16_0= parse_baserequirements_Comment )
            	    {
            	    a14=(Token)match(input,31,FOLLOW_31_in_parse_baserequirements_Comment3675); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    					if (element == null) {
            	    						element = baserequirements.BaserequirementsFactory.eINSTANCE.createComment();
            	    						startIncompleteElement(element);
            	    					}
            	    					collectHiddenTokens(element);
            	    					retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_4_0_0_2_0_0_6_0_0_0, null, true);
            	    					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a14, element);
            	    				}

            	    if ( state.backtracking==0 ) {
            	    					// expected elements (follow set)
            	    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[338]);
            	    				}

            	    a15=(Token)match(input,10,FOLLOW_10_in_parse_baserequirements_Comment3698); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    					if (element == null) {
            	    						element = baserequirements.BaserequirementsFactory.eINSTANCE.createComment();
            	    						startIncompleteElement(element);
            	    					}
            	    					collectHiddenTokens(element);
            	    					retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_4_0_0_2_0_0_6_0_0_1, null, true);
            	    					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a15, element);
            	    				}

            	    if ( state.backtracking==0 ) {
            	    					// expected elements (follow set)
            	    					addExpectedElement(baserequirements.BaserequirementsPackage.eINSTANCE.getComment(), baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[339]);
            	    				}

            	    // Baserequirements.g:3091:5: (a16_0= parse_baserequirements_Comment )
            	    // Baserequirements.g:3092:6: a16_0= parse_baserequirements_Comment
            	    {
            	    pushFollow(FOLLOW_parse_baserequirements_Comment_in_parse_baserequirements_Comment3728);
            	    a16_0=parse_baserequirements_Comment();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    						if (terminateParsing) {
            	    							throw new baserequirements.resource.baserequirements.mopp.BaserequirementsTerminateParsingException();
            	    						}
            	    						if (element == null) {
            	    							element = baserequirements.BaserequirementsFactory.eINSTANCE.createComment();
            	    							startIncompleteElement(element);
            	    						}
            	    						if (a16_0 != null) {
            	    							if (a16_0 != null) {
            	    								Object value = a16_0;
            	    								addObjectToList(element, baserequirements.BaserequirementsPackage.COMMENT__CHILDREN, value);
            	    								completedElement(value, true);
            	    							}
            	    							collectHiddenTokens(element);
            	    							retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_4_0_0_2_0_0_6_0_0_2, a16_0, true);
            	    							copyLocalizationInfos(a16_0, element);
            	    						}
            	    					}

            	    }


            	    if ( state.backtracking==0 ) {
            	    					// expected elements (follow set)
            	    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[340]);
            	    					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[341]);
            	    				}

            	    }


            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            			// expected elements (follow set)
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[342]);
            			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[343]);
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[344]);
            	}

            a17=(Token)match(input,52,FOLLOW_52_in_parse_baserequirements_Comment3786); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = baserequirements.BaserequirementsFactory.eINSTANCE.createComment();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_4_0_0_3, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a17, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[345]);
            		addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[346]);
            		addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[347]);
            		addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[348]);
            		addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[349]);
            		addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[350]);
            		addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[351]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 6, parse_baserequirements_Comment_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_baserequirements_Comment"

    // Delegated rules


 

    public static final BitSet FOLLOW_parse_baserequirements_Model_in_start82 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_start89 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_parse_baserequirements_Model115 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_parse_baserequirements_Model129 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_48_in_parse_baserequirements_Model147 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_parse_baserequirements_Model164 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_baserequirements_Model186 = new BitSet(new long[]{0x0010001000000000L});
    public static final BitSet FOLLOW_36_in_parse_baserequirements_Model224 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_parse_baserequirements_Model247 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_parse_baserequirements_RequirementGroup_in_parse_baserequirements_Model277 = new BitSet(new long[]{0x0010001000000000L});
    public static final BitSet FOLLOW_52_in_parse_baserequirements_Model335 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_parse_baserequirements_RequirementGroup364 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_parse_baserequirements_RequirementGroup378 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_parse_baserequirements_RequirementGroup396 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_parse_baserequirements_RequirementGroup413 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_baserequirements_RequirementGroup435 = new BitSet(new long[]{0x0000002800000000L});
    public static final BitSet FOLLOW_35_in_parse_baserequirements_RequirementGroup473 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_parse_baserequirements_RequirementGroup496 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_baserequirements_RequirementGroup526 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_parse_baserequirements_RequirementGroup588 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_parse_baserequirements_RequirementGroup608 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_baserequirements_RequirementGroup634 = new BitSet(new long[]{0x00100A0080000000L});
    public static final BitSet FOLLOW_31_in_parse_baserequirements_RequirementGroup688 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_parse_baserequirements_RequirementGroup711 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_parse_baserequirements_RequirementGroup_in_parse_baserequirements_RequirementGroup741 = new BitSet(new long[]{0x00100A0080000000L});
    public static final BitSet FOLLOW_41_in_parse_baserequirements_RequirementGroup803 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_parse_baserequirements_RequirementGroup826 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_TEXT_in_parse_baserequirements_RequirementGroup856 = new BitSet(new long[]{0x0010080000000000L});
    public static final BitSet FOLLOW_43_in_parse_baserequirements_RequirementGroup924 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_parse_baserequirements_RequirementGroup947 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_parse_baserequirements_Requirement_in_parse_baserequirements_RequirementGroup977 = new BitSet(new long[]{0x0010080000000000L});
    public static final BitSet FOLLOW_52_in_parse_baserequirements_RequirementGroup1035 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_parse_baserequirements_Requirement1064 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_parse_baserequirements_Requirement1078 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_48_in_parse_baserequirements_Requirement1096 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_parse_baserequirements_Requirement1113 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_baserequirements_Requirement1135 = new BitSet(new long[]{0x0016562FA0000000L});
    public static final BitSet FOLLOW_35_in_parse_baserequirements_Requirement1173 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_parse_baserequirements_Requirement1196 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_baserequirements_Requirement1226 = new BitSet(new long[]{0x00165627A0000000L});
    public static final BitSet FOLLOW_49_in_parse_baserequirements_Requirement1294 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_parse_baserequirements_Requirement1317 = new BitSet(new long[]{0x0000000000804000L});
    public static final BitSet FOLLOW_14_in_parse_baserequirements_Requirement1355 = new BitSet(new long[]{0x00145627A0000000L});
    public static final BitSet FOLLOW_23_in_parse_baserequirements_Requirement1376 = new BitSet(new long[]{0x00145627A0000000L});
    public static final BitSet FOLLOW_42_in_parse_baserequirements_Requirement1441 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_parse_baserequirements_Requirement1464 = new BitSet(new long[]{0x0000000000188000L});
    public static final BitSet FOLLOW_15_in_parse_baserequirements_Requirement1502 = new BitSet(new long[]{0x00145227A0000000L});
    public static final BitSet FOLLOW_20_in_parse_baserequirements_Requirement1523 = new BitSet(new long[]{0x00145227A0000000L});
    public static final BitSet FOLLOW_19_in_parse_baserequirements_Requirement1544 = new BitSet(new long[]{0x00145227A0000000L});
    public static final BitSet FOLLOW_29_in_parse_baserequirements_Requirement1609 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_parse_baserequirements_Requirement1632 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_baserequirements_Requirement1662 = new BitSet(new long[]{0x0014522780000000L});
    public static final BitSet FOLLOW_33_in_parse_baserequirements_Requirement1730 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_parse_baserequirements_Requirement1753 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_TEXT_in_parse_baserequirements_Requirement1783 = new BitSet(new long[]{0x0014522580000000L});
    public static final BitSet FOLLOW_37_in_parse_baserequirements_Requirement1851 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_parse_baserequirements_Requirement1874 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_baserequirements_Requirement1904 = new BitSet(new long[]{0x0014520580000000L});
    public static final BitSet FOLLOW_46_in_parse_baserequirements_Requirement1972 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_parse_baserequirements_Requirement1995 = new BitSet(new long[]{0x0000000003401000L});
    public static final BitSet FOLLOW_22_in_parse_baserequirements_Requirement2033 = new BitSet(new long[]{0x0014120580000000L});
    public static final BitSet FOLLOW_25_in_parse_baserequirements_Requirement2054 = new BitSet(new long[]{0x0014120580000000L});
    public static final BitSet FOLLOW_12_in_parse_baserequirements_Requirement2075 = new BitSet(new long[]{0x0014120580000000L});
    public static final BitSet FOLLOW_24_in_parse_baserequirements_Requirement2096 = new BitSet(new long[]{0x0014120580000000L});
    public static final BitSet FOLLOW_44_in_parse_baserequirements_Requirement2161 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_parse_baserequirements_Requirement2184 = new BitSet(new long[]{0x0000000000070800L});
    public static final BitSet FOLLOW_17_in_parse_baserequirements_Requirement2222 = new BitSet(new long[]{0x0014020580000000L});
    public static final BitSet FOLLOW_11_in_parse_baserequirements_Requirement2243 = new BitSet(new long[]{0x0014020580000000L});
    public static final BitSet FOLLOW_16_in_parse_baserequirements_Requirement2264 = new BitSet(new long[]{0x0014020580000000L});
    public static final BitSet FOLLOW_18_in_parse_baserequirements_Requirement2285 = new BitSet(new long[]{0x0014020580000000L});
    public static final BitSet FOLLOW_50_in_parse_baserequirements_Requirement2350 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_parse_baserequirements_Requirement2373 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_parse_baserequirements_Version_in_parse_baserequirements_Requirement2403 = new BitSet(new long[]{0x0010020580000000L});
    public static final BitSet FOLLOW_32_in_parse_baserequirements_Requirement2465 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_parse_baserequirements_Requirement2488 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_parse_baserequirements_Comment_in_parse_baserequirements_Requirement2518 = new BitSet(new long[]{0x0010020580000000L});
    public static final BitSet FOLLOW_34_in_parse_baserequirements_Requirement2580 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_parse_baserequirements_Requirement2603 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_TEXT_in_parse_baserequirements_Requirement2633 = new BitSet(new long[]{0x0010020480000000L});
    public static final BitSet FOLLOW_41_in_parse_baserequirements_Requirement2701 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_parse_baserequirements_Requirement2724 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_TEXT_in_parse_baserequirements_Requirement2754 = new BitSet(new long[]{0x0010000080000000L});
    public static final BitSet FOLLOW_31_in_parse_baserequirements_Requirement2822 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_parse_baserequirements_Requirement2845 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_parse_baserequirements_Requirement_in_parse_baserequirements_Requirement2875 = new BitSet(new long[]{0x0010000080000000L});
    public static final BitSet FOLLOW_52_in_parse_baserequirements_Requirement2933 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_parse_baserequirements_Version2962 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_parse_baserequirements_Version2976 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_parse_baserequirements_Version2994 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_parse_baserequirements_Version3011 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_TEXT_in_parse_baserequirements_Version3033 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_parse_baserequirements_Version3065 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_parse_baserequirements_Version3085 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_TEXT_in_parse_baserequirements_Version3111 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_45_in_parse_baserequirements_Version3159 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_parse_baserequirements_Version3179 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_TEXT_in_parse_baserequirements_Version3205 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_52_in_parse_baserequirements_Version3255 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_parse_baserequirements_Comment3284 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_parse_baserequirements_Comment3298 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_parse_baserequirements_Comment3316 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_parse_baserequirements_Comment3333 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_baserequirements_Comment3355 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_parse_baserequirements_Comment3387 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_parse_baserequirements_Comment3407 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_baserequirements_Comment3433 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_parse_baserequirements_Comment3481 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_parse_baserequirements_Comment3501 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_baserequirements_Comment3527 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_parse_baserequirements_Comment3575 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_parse_baserequirements_Comment3595 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_TEXT_in_parse_baserequirements_Comment3621 = new BitSet(new long[]{0x0010000080000000L});
    public static final BitSet FOLLOW_31_in_parse_baserequirements_Comment3675 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_parse_baserequirements_Comment3698 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_parse_baserequirements_Comment_in_parse_baserequirements_Comment3728 = new BitSet(new long[]{0x0010000080000000L});
    public static final BitSet FOLLOW_52_in_parse_baserequirements_Comment3786 = new BitSet(new long[]{0x0000000000000002L});

}