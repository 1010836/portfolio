// $ANTLR 3.4

	package baserequirements.resource.baseRequirements.mopp;


import org.antlr.runtime3_4_0.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class BaseRequirementsParser extends BaseRequirementsANTLRParserBase {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "COMMENT", "LINEBREAK", "QUOTED_34_34", "TEXT", "WHITESPACE", "':'", "'ACCEPTED'", "'APPROVED'", "'Comment'", "'FUNCTIONAL'", "'HIGH'", "'IMPLEMENTED'", "'INVALID'", "'LATER'", "'LOW'", "'MEDIUM'", "'Model'", "'NEW'", "'NONFUNCTIONAL'", "'RESOLVED'", "'REVIEWED'", "'Requirement'", "'RequirementGroup'", "'Version'", "'author'", "'body'", "'children'", "'comments'", "'created'", "'dependencies'", "'description'", "'groups'", "'id'", "'major'", "'minor'", "'name'", "'parent'", "'priority'", "'requirements'", "'resolution'", "'service'", "'state'", "'subject'", "'title'", "'type'", "'version'", "'{'", "'}'"
    };

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

    // delegates
    public BaseRequirementsANTLRParserBase[] getDelegates() {
        return new BaseRequirementsANTLRParserBase[] {};
    }

    // delegators


    public BaseRequirementsParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public BaseRequirementsParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
        this.state.initializeRuleMemo(40 + 1);
         

    }

    public String[] getTokenNames() { return BaseRequirementsParser.tokenNames; }
    public String getGrammarFileName() { return "BaseRequirements.g"; }


    	private baserequirements.resource.baseRequirements.IBaseRequirementsTokenResolverFactory tokenResolverFactory = new baserequirements.resource.baseRequirements.mopp.BaseRequirementsTokenResolverFactory();
    	
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
    	private java.util.List<baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectedTerminal> expectedElements = new java.util.ArrayList<baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectedTerminal>();
    	
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
    		postParseCommands.add(new baserequirements.resource.baseRequirements.IBaseRequirementsCommand<baserequirements.resource.baseRequirements.IBaseRequirementsTextResource>() {
    			public boolean execute(baserequirements.resource.baseRequirements.IBaseRequirementsTextResource resource) {
    				if (resource == null) {
    					// the resource can be null if the parser is used for code completion
    					return true;
    				}
    				resource.addProblem(new baserequirements.resource.baseRequirements.IBaseRequirementsProblem() {
    					public baserequirements.resource.baseRequirements.BaseRequirementsEProblemSeverity getSeverity() {
    						return baserequirements.resource.baseRequirements.BaseRequirementsEProblemSeverity.ERROR;
    					}
    					public baserequirements.resource.baseRequirements.BaseRequirementsEProblemType getType() {
    						return baserequirements.resource.baseRequirements.BaseRequirementsEProblemType.SYNTAX_ERROR;
    					}
    					public String getMessage() {
    						return errorMessage;
    					}
    					public java.util.Collection<baserequirements.resource.baseRequirements.IBaseRequirementsQuickFix> getQuickFixes() {
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
    		baserequirements.resource.baseRequirements.IBaseRequirementsExpectedElement terminal = baserequirements.resource.baseRequirements.grammar.BaseRequirementsFollowSetProvider.TERMINALS[terminalID];
    		baserequirements.resource.baseRequirements.mopp.BaseRequirementsContainedFeature[] containmentFeatures = new baserequirements.resource.baseRequirements.mopp.BaseRequirementsContainedFeature[ids.length - 2];
    		for (int i = 2; i < ids.length; i++) {
    			containmentFeatures[i - 2] = baserequirements.resource.baseRequirements.grammar.BaseRequirementsFollowSetProvider.LINKS[ids[i]];
    		}
    		baserequirements.resource.baseRequirements.grammar.BaseRequirementsContainmentTrace containmentTrace = new baserequirements.resource.baseRequirements.grammar.BaseRequirementsContainmentTrace(eClass, containmentFeatures);
    		org.eclipse.emf.ecore.EObject container = getLastIncompleteElement();
    		baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectedTerminal expectedElement = new baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectedTerminal(container, terminal, followSetID, containmentTrace);
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
    		postParseCommands.add(new baserequirements.resource.baseRequirements.IBaseRequirementsCommand<baserequirements.resource.baseRequirements.IBaseRequirementsTextResource>() {
    			public boolean execute(baserequirements.resource.baseRequirements.IBaseRequirementsTextResource resource) {
    				baserequirements.resource.baseRequirements.IBaseRequirementsLocationMap locationMap = resource.getLocationMap();
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
    		postParseCommands.add(new baserequirements.resource.baseRequirements.IBaseRequirementsCommand<baserequirements.resource.baseRequirements.IBaseRequirementsTextResource>() {
    			public boolean execute(baserequirements.resource.baseRequirements.IBaseRequirementsTextResource resource) {
    				baserequirements.resource.baseRequirements.IBaseRequirementsLocationMap locationMap = resource.getLocationMap();
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
    	protected void setLocalizationEnd(java.util.Collection<baserequirements.resource.baseRequirements.IBaseRequirementsCommand<baserequirements.resource.baseRequirements.IBaseRequirementsTextResource>> postParseCommands , final org.eclipse.emf.ecore.EObject object, final int endChar, final int endLine) {
    		if (disableLocationMap) {
    			return;
    		}
    		postParseCommands.add(new baserequirements.resource.baseRequirements.IBaseRequirementsCommand<baserequirements.resource.baseRequirements.IBaseRequirementsTextResource>() {
    			public boolean execute(baserequirements.resource.baseRequirements.IBaseRequirementsTextResource resource) {
    				baserequirements.resource.baseRequirements.IBaseRequirementsLocationMap locationMap = resource.getLocationMap();
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
    	
    	public baserequirements.resource.baseRequirements.IBaseRequirementsTextParser createInstance(java.io.InputStream actualInputStream, String encoding) {
    		try {
    			if (encoding == null) {
    				return new BaseRequirementsParser(new org.antlr.runtime3_4_0.CommonTokenStream(new BaseRequirementsLexer(new org.antlr.runtime3_4_0.ANTLRInputStream(actualInputStream))));
    			} else {
    				return new BaseRequirementsParser(new org.antlr.runtime3_4_0.CommonTokenStream(new BaseRequirementsLexer(new org.antlr.runtime3_4_0.ANTLRInputStream(actualInputStream, encoding))));
    			}
    		} catch (java.io.IOException e) {
    			new baserequirements.resource.baseRequirements.util.BaseRequirementsRuntimeUtil().logError("Error while creating parser.", e);
    			return null;
    		}
    	}
    	
    	/**
    	 * This default constructor is only used to call createInstance() on it.
    	 */
    	public BaseRequirementsParser() {
    		super(null);
    	}
    	
    	protected org.eclipse.emf.ecore.EObject doParse() throws org.antlr.runtime3_4_0.RecognitionException {
    		this.lastPosition = 0;
    		// required because the lexer class can not be subclassed
    		((BaseRequirementsLexer) getTokenStream().getTokenSource()).lexerExceptions = lexerExceptions;
    		((BaseRequirementsLexer) getTokenStream().getTokenSource()).lexerExceptionsPosition = lexerExceptionsPosition;
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
    		throw new baserequirements.resource.baseRequirements.mopp.BaseRequirementsUnexpectedContentTypeException(typeObject);
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
    			typeObject = options.get(baserequirements.resource.baseRequirements.IBaseRequirementsOptions.RESOURCE_CONTENT_TYPE);
    		}
    		return typeObject;
    	}
    	
    	/**
    	 * Implementation that calls {@link #doParse()} and handles the thrown
    	 * RecognitionExceptions.
    	 */
    	public baserequirements.resource.baseRequirements.IBaseRequirementsParseResult parse() {
    		terminateParsing = false;
    		postParseCommands = new java.util.ArrayList<baserequirements.resource.baseRequirements.IBaseRequirementsCommand<baserequirements.resource.baseRequirements.IBaseRequirementsTextResource>>();
    		baserequirements.resource.baseRequirements.mopp.BaseRequirementsParseResult parseResult = new baserequirements.resource.baseRequirements.mopp.BaseRequirementsParseResult();
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
    	
    	public java.util.List<baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectedTerminal> parseToExpectedElements(org.eclipse.emf.ecore.EClass type, baserequirements.resource.baseRequirements.IBaseRequirementsTextResource dummyResource, int cursorOffset) {
    		this.rememberExpectedElements = true;
    		this.parseToIndexTypeObject = type;
    		this.cursorOffset = cursorOffset;
    		this.lastStartIncludingHidden = -1;
    		final org.antlr.runtime3_4_0.CommonTokenStream tokenStream = (org.antlr.runtime3_4_0.CommonTokenStream) getTokenStream();
    		baserequirements.resource.baseRequirements.IBaseRequirementsParseResult result = parse();
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
    			for (baserequirements.resource.baseRequirements.IBaseRequirementsCommand<baserequirements.resource.baseRequirements.IBaseRequirementsTextResource> command : result.getPostParseCommands()) {
    				command.execute(dummyResource);
    			}
    		}
    		// remove all expected elements that were added after the last complete element
    		expectedElements = expectedElements.subList(0, expectedElementsIndexOfLastCompleteElement + 1);
    		int lastFollowSetID = expectedElements.get(expectedElementsIndexOfLastCompleteElement).getFollowSetID();
    		java.util.Set<baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectedTerminal> currentFollowSet = new java.util.LinkedHashSet<baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectedTerminal>();
    		java.util.List<baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectedTerminal> newFollowSet = new java.util.ArrayList<baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectedTerminal>();
    		for (int i = expectedElementsIndexOfLastCompleteElement; i >= 0; i--) {
    			baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectedTerminal expectedElementI = expectedElements.get(i);
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
    				for (baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectedTerminal nextFollow : newFollowSet) {
    					lastTokenIndex = 0;
    					setPosition(nextFollow, i);
    				}
    				newFollowSet.clear();
    				// normal tokens do reduce the follow set - only elements that match the token are
    				// kept
    				for (baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectedTerminal nextFollow : currentFollowSet) {
    					if (nextFollow.getTerminal().getTokenNames().contains(getTokenNames()[nextToken.getType()])) {
    						// keep this one - it matches
    						java.util.Collection<baserequirements.resource.baseRequirements.util.BaseRequirementsPair<baserequirements.resource.baseRequirements.IBaseRequirementsExpectedElement, baserequirements.resource.baseRequirements.mopp.BaseRequirementsContainedFeature[]>> newFollowers = nextFollow.getTerminal().getFollowers();
    						for (baserequirements.resource.baseRequirements.util.BaseRequirementsPair<baserequirements.resource.baseRequirements.IBaseRequirementsExpectedElement, baserequirements.resource.baseRequirements.mopp.BaseRequirementsContainedFeature[]> newFollowerPair : newFollowers) {
    							baserequirements.resource.baseRequirements.IBaseRequirementsExpectedElement newFollower = newFollowerPair.getLeft();
    							org.eclipse.emf.ecore.EObject container = getLastIncompleteElement();
    							baserequirements.resource.baseRequirements.grammar.BaseRequirementsContainmentTrace containmentTrace = new baserequirements.resource.baseRequirements.grammar.BaseRequirementsContainmentTrace(null, newFollowerPair.getRight());
    							baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectedTerminal newFollowTerminal = new baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectedTerminal(container, newFollower, followSetID, containmentTrace);
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
    		for (baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectedTerminal nextFollow : newFollowSet) {
    			lastTokenIndex = 0;
    			setPosition(nextFollow, i);
    		}
    		return this.expectedElements;
    	}
    	
    	public void setPosition(baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectedTerminal expectedElement, int tokenIndex) {
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
    // BaseRequirements.g:511:1: start returns [ org.eclipse.emf.ecore.EObject element = null] : (c0= parse_baserequirements_Model ) EOF ;
    public final org.eclipse.emf.ecore.EObject start() throws RecognitionException {
        org.eclipse.emf.ecore.EObject element =  null;

        int start_StartIndex = input.index();

        baserequirements.Model c0 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return element; }

            // BaseRequirements.g:512:2: ( (c0= parse_baserequirements_Model ) EOF )
            // BaseRequirements.g:513:2: (c0= parse_baserequirements_Model ) EOF
            {
            if ( state.backtracking==0 ) {
            		// follow set for start rule(s)
            		addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[0]);
            		expectedElementsIndexOfLastCompleteElement = 0;
            	}

            // BaseRequirements.g:518:2: (c0= parse_baserequirements_Model )
            // BaseRequirements.g:519:3: c0= parse_baserequirements_Model
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
    // BaseRequirements.g:527:1: parse_baserequirements_Model returns [baserequirements.Model element = null] : a0= 'Model' a1= '{' (a2= 'title' a3= ':' (a4= QUOTED_34_34 ) ( (a5= 'groups' a6= ':' (a7_0= parse_baserequirements_RequirementGroup ) ) )* ) a8= '}' ;
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

            // BaseRequirements.g:530:2: (a0= 'Model' a1= '{' (a2= 'title' a3= ':' (a4= QUOTED_34_34 ) ( (a5= 'groups' a6= ':' (a7_0= parse_baserequirements_RequirementGroup ) ) )* ) a8= '}' )
            // BaseRequirements.g:531:2: a0= 'Model' a1= '{' (a2= 'title' a3= ':' (a4= QUOTED_34_34 ) ( (a5= 'groups' a6= ':' (a7_0= parse_baserequirements_RequirementGroup ) ) )* ) a8= '}'
            {
            a0=(Token)match(input,20,FOLLOW_20_in_parse_baserequirements_Model115); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = baserequirements.BaserequirementsFactory.eINSTANCE.createModel();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_0_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[1]);
            	}

            a1=(Token)match(input,50,FOLLOW_50_in_parse_baserequirements_Model129); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = baserequirements.BaserequirementsFactory.eINSTANCE.createModel();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_0_0_0_1, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[2]);
            	}

            // BaseRequirements.g:559:2: (a2= 'title' a3= ':' (a4= QUOTED_34_34 ) ( (a5= 'groups' a6= ':' (a7_0= parse_baserequirements_RequirementGroup ) ) )* )
            // BaseRequirements.g:560:3: a2= 'title' a3= ':' (a4= QUOTED_34_34 ) ( (a5= 'groups' a6= ':' (a7_0= parse_baserequirements_RequirementGroup ) ) )*
            {
            a2=(Token)match(input,47,FOLLOW_47_in_parse_baserequirements_Model147); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (element == null) {
            				element = baserequirements.BaserequirementsFactory.eINSTANCE.createModel();
            				startIncompleteElement(element);
            			}
            			collectHiddenTokens(element);
            			retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_0_0_0_2_0_0_0, null, true);
            			copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
            		}

            if ( state.backtracking==0 ) {
            			// expected elements (follow set)
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[3]);
            		}

            a3=(Token)match(input,9,FOLLOW_9_in_parse_baserequirements_Model164); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (element == null) {
            				element = baserequirements.BaserequirementsFactory.eINSTANCE.createModel();
            				startIncompleteElement(element);
            			}
            			collectHiddenTokens(element);
            			retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_0_0_0_2_0_0_1, null, true);
            			copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
            		}

            if ( state.backtracking==0 ) {
            			// expected elements (follow set)
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[4]);
            		}

            // BaseRequirements.g:588:3: (a4= QUOTED_34_34 )
            // BaseRequirements.g:589:4: a4= QUOTED_34_34
            {
            a4=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_baserequirements_Model186); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            				if (terminateParsing) {
            					throw new baserequirements.resource.baseRequirements.mopp.BaseRequirementsTerminateParsingException();
            				}
            				if (element == null) {
            					element = baserequirements.BaserequirementsFactory.eINSTANCE.createModel();
            					startIncompleteElement(element);
            				}
            				if (a4 != null) {
            					baserequirements.resource.baseRequirements.IBaseRequirementsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
            					tokenResolver.setOptions(getOptions());
            					baserequirements.resource.baseRequirements.IBaseRequirementsTokenResolveResult result = getFreshTokenResolveResult();
            					tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.MODEL__TITLE), result);
            					Object resolvedObject = result.getResolvedToken();
            					if (resolvedObject == null) {
            						addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a4).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStopIndex());
            					}
            					java.lang.String resolved = (java.lang.String) resolvedObject;
            					if (resolved != null) {
            						Object value = resolved;
            						addObjectToList(element, baserequirements.BaserequirementsPackage.MODEL__TITLE, value);
            						completedElement(value, false);
            					}
            					collectHiddenTokens(element);
            					retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_0_0_0_2_0_0_2, resolved, true);
            					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a4, element);
            				}
            			}

            }


            if ( state.backtracking==0 ) {
            			// expected elements (follow set)
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[5]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[6]);
            		}

            // BaseRequirements.g:625:3: ( (a5= 'groups' a6= ':' (a7_0= parse_baserequirements_RequirementGroup ) ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==35) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // BaseRequirements.g:626:4: (a5= 'groups' a6= ':' (a7_0= parse_baserequirements_RequirementGroup ) )
            	    {
            	    // BaseRequirements.g:626:4: (a5= 'groups' a6= ':' (a7_0= parse_baserequirements_RequirementGroup ) )
            	    // BaseRequirements.g:627:5: a5= 'groups' a6= ':' (a7_0= parse_baserequirements_RequirementGroup )
            	    {
            	    a5=(Token)match(input,35,FOLLOW_35_in_parse_baserequirements_Model224); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    					if (element == null) {
            	    						element = baserequirements.BaserequirementsFactory.eINSTANCE.createModel();
            	    						startIncompleteElement(element);
            	    					}
            	    					collectHiddenTokens(element);
            	    					retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_0_0_0_2_0_0_3_0_0_0, null, true);
            	    					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
            	    				}

            	    if ( state.backtracking==0 ) {
            	    					// expected elements (follow set)
            	    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[7]);
            	    				}

            	    a6=(Token)match(input,9,FOLLOW_9_in_parse_baserequirements_Model247); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    					if (element == null) {
            	    						element = baserequirements.BaserequirementsFactory.eINSTANCE.createModel();
            	    						startIncompleteElement(element);
            	    					}
            	    					collectHiddenTokens(element);
            	    					retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_0_0_0_2_0_0_3_0_0_1, null, true);
            	    					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
            	    				}

            	    if ( state.backtracking==0 ) {
            	    					// expected elements (follow set)
            	    					addExpectedElement(baserequirements.BaserequirementsPackage.eINSTANCE.getModel(), baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[8]);
            	    				}

            	    // BaseRequirements.g:655:5: (a7_0= parse_baserequirements_RequirementGroup )
            	    // BaseRequirements.g:656:6: a7_0= parse_baserequirements_RequirementGroup
            	    {
            	    pushFollow(FOLLOW_parse_baserequirements_RequirementGroup_in_parse_baserequirements_Model277);
            	    a7_0=parse_baserequirements_RequirementGroup();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    						if (terminateParsing) {
            	    							throw new baserequirements.resource.baseRequirements.mopp.BaseRequirementsTerminateParsingException();
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
            	    							retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_0_0_0_2_0_0_3_0_0_2, a7_0, true);
            	    							copyLocalizationInfos(a7_0, element);
            	    						}
            	    					}

            	    }


            	    if ( state.backtracking==0 ) {
            	    					// expected elements (follow set)
            	    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[9]);
            	    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[10]);
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
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[11]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[12]);
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[13]);
            	}

            a8=(Token)match(input,51,FOLLOW_51_in_parse_baserequirements_Model335); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = baserequirements.BaserequirementsFactory.eINSTANCE.createModel();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_0_0_0_3, null, true);
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
    // BaseRequirements.g:711:1: parse_baserequirements_RequirementGroup returns [baserequirements.RequirementGroup element = null] : a0= 'RequirementGroup' a1= '{' (a2= 'name' a3= ':' (a4= QUOTED_34_34 ) ( (a5= 'description' a6= ':' (a7= QUOTED_34_34 ) ) )? ( (a8= 'id' a9= ':' (a10= QUOTED_34_34 ) ) )? ( (a11= 'children' a12= ':' (a13_0= parse_baserequirements_RequirementGroup ) ) )* ( (a14= 'parent' a15= ':' (a16= TEXT ) ) )? ( (a17= 'requirements' a18= ':' (a19_0= parse_baserequirements_Requirement ) ) )* ) a20= '}' ;
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

            // BaseRequirements.g:714:2: (a0= 'RequirementGroup' a1= '{' (a2= 'name' a3= ':' (a4= QUOTED_34_34 ) ( (a5= 'description' a6= ':' (a7= QUOTED_34_34 ) ) )? ( (a8= 'id' a9= ':' (a10= QUOTED_34_34 ) ) )? ( (a11= 'children' a12= ':' (a13_0= parse_baserequirements_RequirementGroup ) ) )* ( (a14= 'parent' a15= ':' (a16= TEXT ) ) )? ( (a17= 'requirements' a18= ':' (a19_0= parse_baserequirements_Requirement ) ) )* ) a20= '}' )
            // BaseRequirements.g:715:2: a0= 'RequirementGroup' a1= '{' (a2= 'name' a3= ':' (a4= QUOTED_34_34 ) ( (a5= 'description' a6= ':' (a7= QUOTED_34_34 ) ) )? ( (a8= 'id' a9= ':' (a10= QUOTED_34_34 ) ) )? ( (a11= 'children' a12= ':' (a13_0= parse_baserequirements_RequirementGroup ) ) )* ( (a14= 'parent' a15= ':' (a16= TEXT ) ) )? ( (a17= 'requirements' a18= ':' (a19_0= parse_baserequirements_Requirement ) ) )* ) a20= '}'
            {
            a0=(Token)match(input,26,FOLLOW_26_in_parse_baserequirements_RequirementGroup364); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirementGroup();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_1_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[14]);
            	}

            a1=(Token)match(input,50,FOLLOW_50_in_parse_baserequirements_RequirementGroup378); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirementGroup();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_1_0_0_1, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[15]);
            	}

            // BaseRequirements.g:743:2: (a2= 'name' a3= ':' (a4= QUOTED_34_34 ) ( (a5= 'description' a6= ':' (a7= QUOTED_34_34 ) ) )? ( (a8= 'id' a9= ':' (a10= QUOTED_34_34 ) ) )? ( (a11= 'children' a12= ':' (a13_0= parse_baserequirements_RequirementGroup ) ) )* ( (a14= 'parent' a15= ':' (a16= TEXT ) ) )? ( (a17= 'requirements' a18= ':' (a19_0= parse_baserequirements_Requirement ) ) )* )
            // BaseRequirements.g:744:3: a2= 'name' a3= ':' (a4= QUOTED_34_34 ) ( (a5= 'description' a6= ':' (a7= QUOTED_34_34 ) ) )? ( (a8= 'id' a9= ':' (a10= QUOTED_34_34 ) ) )? ( (a11= 'children' a12= ':' (a13_0= parse_baserequirements_RequirementGroup ) ) )* ( (a14= 'parent' a15= ':' (a16= TEXT ) ) )? ( (a17= 'requirements' a18= ':' (a19_0= parse_baserequirements_Requirement ) ) )*
            {
            a2=(Token)match(input,39,FOLLOW_39_in_parse_baserequirements_RequirementGroup396); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (element == null) {
            				element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirementGroup();
            				startIncompleteElement(element);
            			}
            			collectHiddenTokens(element);
            			retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_1_0_0_2_0_0_0, null, true);
            			copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
            		}

            if ( state.backtracking==0 ) {
            			// expected elements (follow set)
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[16]);
            		}

            a3=(Token)match(input,9,FOLLOW_9_in_parse_baserequirements_RequirementGroup413); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (element == null) {
            				element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirementGroup();
            				startIncompleteElement(element);
            			}
            			collectHiddenTokens(element);
            			retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_1_0_0_2_0_0_1, null, true);
            			copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
            		}

            if ( state.backtracking==0 ) {
            			// expected elements (follow set)
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[17]);
            		}

            // BaseRequirements.g:772:3: (a4= QUOTED_34_34 )
            // BaseRequirements.g:773:4: a4= QUOTED_34_34
            {
            a4=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_baserequirements_RequirementGroup435); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            				if (terminateParsing) {
            					throw new baserequirements.resource.baseRequirements.mopp.BaseRequirementsTerminateParsingException();
            				}
            				if (element == null) {
            					element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirementGroup();
            					startIncompleteElement(element);
            				}
            				if (a4 != null) {
            					baserequirements.resource.baseRequirements.IBaseRequirementsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
            					tokenResolver.setOptions(getOptions());
            					baserequirements.resource.baseRequirements.IBaseRequirementsTokenResolveResult result = getFreshTokenResolveResult();
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
            					retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_1_0_0_2_0_0_2, resolved, true);
            					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a4, element);
            				}
            			}

            }


            if ( state.backtracking==0 ) {
            			// expected elements (follow set)
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[18]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[19]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[20]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[21]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[22]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[23]);
            		}

            // BaseRequirements.g:813:3: ( (a5= 'description' a6= ':' (a7= QUOTED_34_34 ) ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==34) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // BaseRequirements.g:814:4: (a5= 'description' a6= ':' (a7= QUOTED_34_34 ) )
                    {
                    // BaseRequirements.g:814:4: (a5= 'description' a6= ':' (a7= QUOTED_34_34 ) )
                    // BaseRequirements.g:815:5: a5= 'description' a6= ':' (a7= QUOTED_34_34 )
                    {
                    a5=(Token)match(input,34,FOLLOW_34_in_parse_baserequirements_RequirementGroup473); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    					if (element == null) {
                    						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirementGroup();
                    						startIncompleteElement(element);
                    					}
                    					collectHiddenTokens(element);
                    					retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_1_0_0_2_0_0_3_0_0_0, null, true);
                    					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
                    				}

                    if ( state.backtracking==0 ) {
                    					// expected elements (follow set)
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[24]);
                    				}

                    a6=(Token)match(input,9,FOLLOW_9_in_parse_baserequirements_RequirementGroup496); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    					if (element == null) {
                    						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirementGroup();
                    						startIncompleteElement(element);
                    					}
                    					collectHiddenTokens(element);
                    					retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_1_0_0_2_0_0_3_0_0_1, null, true);
                    					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
                    				}

                    if ( state.backtracking==0 ) {
                    					// expected elements (follow set)
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[25]);
                    				}

                    // BaseRequirements.g:843:5: (a7= QUOTED_34_34 )
                    // BaseRequirements.g:844:6: a7= QUOTED_34_34
                    {
                    a7=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_baserequirements_RequirementGroup526); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    						if (terminateParsing) {
                    							throw new baserequirements.resource.baseRequirements.mopp.BaseRequirementsTerminateParsingException();
                    						}
                    						if (element == null) {
                    							element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirementGroup();
                    							startIncompleteElement(element);
                    						}
                    						if (a7 != null) {
                    							baserequirements.resource.baseRequirements.IBaseRequirementsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
                    							tokenResolver.setOptions(getOptions());
                    							baserequirements.resource.baseRequirements.IBaseRequirementsTokenResolveResult result = getFreshTokenResolveResult();
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
                    							retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_1_0_0_2_0_0_3_0_0_2, resolved, true);
                    							copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a7, element);
                    						}
                    					}

                    }


                    if ( state.backtracking==0 ) {
                    					// expected elements (follow set)
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[26]);
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[27]);
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[28]);
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[29]);
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[30]);
                    				}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            			// expected elements (follow set)
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[31]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[32]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[33]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[34]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[35]);
            		}

            // BaseRequirements.g:894:3: ( (a8= 'id' a9= ':' (a10= QUOTED_34_34 ) ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==36) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // BaseRequirements.g:895:4: (a8= 'id' a9= ':' (a10= QUOTED_34_34 ) )
                    {
                    // BaseRequirements.g:895:4: (a8= 'id' a9= ':' (a10= QUOTED_34_34 ) )
                    // BaseRequirements.g:896:5: a8= 'id' a9= ':' (a10= QUOTED_34_34 )
                    {
                    a8=(Token)match(input,36,FOLLOW_36_in_parse_baserequirements_RequirementGroup594); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    					if (element == null) {
                    						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirementGroup();
                    						startIncompleteElement(element);
                    					}
                    					collectHiddenTokens(element);
                    					retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_1_0_0_2_0_0_4_0_0_0, null, true);
                    					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a8, element);
                    				}

                    if ( state.backtracking==0 ) {
                    					// expected elements (follow set)
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[36]);
                    				}

                    a9=(Token)match(input,9,FOLLOW_9_in_parse_baserequirements_RequirementGroup617); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    					if (element == null) {
                    						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirementGroup();
                    						startIncompleteElement(element);
                    					}
                    					collectHiddenTokens(element);
                    					retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_1_0_0_2_0_0_4_0_0_1, null, true);
                    					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a9, element);
                    				}

                    if ( state.backtracking==0 ) {
                    					// expected elements (follow set)
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[37]);
                    				}

                    // BaseRequirements.g:924:5: (a10= QUOTED_34_34 )
                    // BaseRequirements.g:925:6: a10= QUOTED_34_34
                    {
                    a10=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_baserequirements_RequirementGroup647); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    						if (terminateParsing) {
                    							throw new baserequirements.resource.baseRequirements.mopp.BaseRequirementsTerminateParsingException();
                    						}
                    						if (element == null) {
                    							element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirementGroup();
                    							startIncompleteElement(element);
                    						}
                    						if (a10 != null) {
                    							baserequirements.resource.baseRequirements.IBaseRequirementsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
                    							tokenResolver.setOptions(getOptions());
                    							baserequirements.resource.baseRequirements.IBaseRequirementsTokenResolveResult result = getFreshTokenResolveResult();
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
                    							retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_1_0_0_2_0_0_4_0_0_2, resolved, true);
                    							copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a10, element);
                    						}
                    					}

                    }


                    if ( state.backtracking==0 ) {
                    					// expected elements (follow set)
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[38]);
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[39]);
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[40]);
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[41]);
                    				}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            			// expected elements (follow set)
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[42]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[43]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[44]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[45]);
            		}

            // BaseRequirements.g:973:3: ( (a11= 'children' a12= ':' (a13_0= parse_baserequirements_RequirementGroup ) ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==30) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // BaseRequirements.g:974:4: (a11= 'children' a12= ':' (a13_0= parse_baserequirements_RequirementGroup ) )
            	    {
            	    // BaseRequirements.g:974:4: (a11= 'children' a12= ':' (a13_0= parse_baserequirements_RequirementGroup ) )
            	    // BaseRequirements.g:975:5: a11= 'children' a12= ':' (a13_0= parse_baserequirements_RequirementGroup )
            	    {
            	    a11=(Token)match(input,30,FOLLOW_30_in_parse_baserequirements_RequirementGroup715); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    					if (element == null) {
            	    						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirementGroup();
            	    						startIncompleteElement(element);
            	    					}
            	    					collectHiddenTokens(element);
            	    					retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_1_0_0_2_0_0_5_0_0_0, null, true);
            	    					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a11, element);
            	    				}

            	    if ( state.backtracking==0 ) {
            	    					// expected elements (follow set)
            	    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[46]);
            	    				}

            	    a12=(Token)match(input,9,FOLLOW_9_in_parse_baserequirements_RequirementGroup738); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    					if (element == null) {
            	    						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirementGroup();
            	    						startIncompleteElement(element);
            	    					}
            	    					collectHiddenTokens(element);
            	    					retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_1_0_0_2_0_0_5_0_0_1, null, true);
            	    					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a12, element);
            	    				}

            	    if ( state.backtracking==0 ) {
            	    					// expected elements (follow set)
            	    					addExpectedElement(baserequirements.BaserequirementsPackage.eINSTANCE.getRequirementGroup(), baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[47]);
            	    				}

            	    // BaseRequirements.g:1003:5: (a13_0= parse_baserequirements_RequirementGroup )
            	    // BaseRequirements.g:1004:6: a13_0= parse_baserequirements_RequirementGroup
            	    {
            	    pushFollow(FOLLOW_parse_baserequirements_RequirementGroup_in_parse_baserequirements_RequirementGroup768);
            	    a13_0=parse_baserequirements_RequirementGroup();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    						if (terminateParsing) {
            	    							throw new baserequirements.resource.baseRequirements.mopp.BaseRequirementsTerminateParsingException();
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
            	    							retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_1_0_0_2_0_0_5_0_0_2, a13_0, true);
            	    							copyLocalizationInfos(a13_0, element);
            	    						}
            	    					}

            	    }


            	    if ( state.backtracking==0 ) {
            	    					// expected elements (follow set)
            	    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[48]);
            	    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[49]);
            	    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[50]);
            	    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[51]);
            	    				}

            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            			// expected elements (follow set)
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[52]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[53]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[54]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[55]);
            		}

            // BaseRequirements.g:1042:3: ( (a14= 'parent' a15= ':' (a16= TEXT ) ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==40) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // BaseRequirements.g:1043:4: (a14= 'parent' a15= ':' (a16= TEXT ) )
                    {
                    // BaseRequirements.g:1043:4: (a14= 'parent' a15= ':' (a16= TEXT ) )
                    // BaseRequirements.g:1044:5: a14= 'parent' a15= ':' (a16= TEXT )
                    {
                    a14=(Token)match(input,40,FOLLOW_40_in_parse_baserequirements_RequirementGroup830); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    					if (element == null) {
                    						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirementGroup();
                    						startIncompleteElement(element);
                    					}
                    					collectHiddenTokens(element);
                    					retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_1_0_0_2_0_0_6_0_0_0, null, true);
                    					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a14, element);
                    				}

                    if ( state.backtracking==0 ) {
                    					// expected elements (follow set)
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[56]);
                    				}

                    a15=(Token)match(input,9,FOLLOW_9_in_parse_baserequirements_RequirementGroup853); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    					if (element == null) {
                    						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirementGroup();
                    						startIncompleteElement(element);
                    					}
                    					collectHiddenTokens(element);
                    					retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_1_0_0_2_0_0_6_0_0_1, null, true);
                    					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a15, element);
                    				}

                    if ( state.backtracking==0 ) {
                    					// expected elements (follow set)
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[57]);
                    				}

                    // BaseRequirements.g:1072:5: (a16= TEXT )
                    // BaseRequirements.g:1073:6: a16= TEXT
                    {
                    a16=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_baserequirements_RequirementGroup883); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    						if (terminateParsing) {
                    							throw new baserequirements.resource.baseRequirements.mopp.BaseRequirementsTerminateParsingException();
                    						}
                    						if (element == null) {
                    							element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirementGroup();
                    							startIncompleteElement(element);
                    						}
                    						if (a16 != null) {
                    							baserequirements.resource.baseRequirements.IBaseRequirementsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
                    							tokenResolver.setOptions(getOptions());
                    							baserequirements.resource.baseRequirements.IBaseRequirementsTokenResolveResult result = getFreshTokenResolveResult();
                    							tokenResolver.resolve(a16.getText(), element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.REQUIREMENT_GROUP__PARENT), result);
                    							Object resolvedObject = result.getResolvedToken();
                    							if (resolvedObject == null) {
                    								addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a16).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a16).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a16).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a16).getStopIndex());
                    							}
                    							String resolved = (String) resolvedObject;
                    							baserequirements.RequirementGroup proxy = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirementGroup();
                    							collectHiddenTokens(element);
                    							registerContextDependentProxy(new baserequirements.resource.baseRequirements.mopp.BaseRequirementsContextDependentURIFragmentFactory<baserequirements.RequirementGroup, baserequirements.RequirementGroup>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getRequirementGroupParentReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.REQUIREMENT_GROUP__PARENT), resolved, proxy);
                    							if (proxy != null) {
                    								Object value = proxy;
                    								element.eSet(element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.REQUIREMENT_GROUP__PARENT), value);
                    								completedElement(value, false);
                    							}
                    							collectHiddenTokens(element);
                    							retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_1_0_0_2_0_0_6_0_0_2, proxy, true);
                    							copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a16, element);
                    							copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a16, proxy);
                    						}
                    					}

                    }


                    if ( state.backtracking==0 ) {
                    					// expected elements (follow set)
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[58]);
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[59]);
                    				}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            			// expected elements (follow set)
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[60]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[61]);
            		}

            // BaseRequirements.g:1121:3: ( (a17= 'requirements' a18= ':' (a19_0= parse_baserequirements_Requirement ) ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==42) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // BaseRequirements.g:1122:4: (a17= 'requirements' a18= ':' (a19_0= parse_baserequirements_Requirement ) )
            	    {
            	    // BaseRequirements.g:1122:4: (a17= 'requirements' a18= ':' (a19_0= parse_baserequirements_Requirement ) )
            	    // BaseRequirements.g:1123:5: a17= 'requirements' a18= ':' (a19_0= parse_baserequirements_Requirement )
            	    {
            	    a17=(Token)match(input,42,FOLLOW_42_in_parse_baserequirements_RequirementGroup951); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    					if (element == null) {
            	    						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirementGroup();
            	    						startIncompleteElement(element);
            	    					}
            	    					collectHiddenTokens(element);
            	    					retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_1_0_0_2_0_0_7_0_0_0, null, true);
            	    					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a17, element);
            	    				}

            	    if ( state.backtracking==0 ) {
            	    					// expected elements (follow set)
            	    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[62]);
            	    				}

            	    a18=(Token)match(input,9,FOLLOW_9_in_parse_baserequirements_RequirementGroup974); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    					if (element == null) {
            	    						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirementGroup();
            	    						startIncompleteElement(element);
            	    					}
            	    					collectHiddenTokens(element);
            	    					retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_1_0_0_2_0_0_7_0_0_1, null, true);
            	    					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a18, element);
            	    				}

            	    if ( state.backtracking==0 ) {
            	    					// expected elements (follow set)
            	    					addExpectedElement(baserequirements.BaserequirementsPackage.eINSTANCE.getRequirementGroup(), baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[63]);
            	    				}

            	    // BaseRequirements.g:1151:5: (a19_0= parse_baserequirements_Requirement )
            	    // BaseRequirements.g:1152:6: a19_0= parse_baserequirements_Requirement
            	    {
            	    pushFollow(FOLLOW_parse_baserequirements_Requirement_in_parse_baserequirements_RequirementGroup1004);
            	    a19_0=parse_baserequirements_Requirement();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    						if (terminateParsing) {
            	    							throw new baserequirements.resource.baseRequirements.mopp.BaseRequirementsTerminateParsingException();
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
            	    							retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_1_0_0_2_0_0_7_0_0_2, a19_0, true);
            	    							copyLocalizationInfos(a19_0, element);
            	    						}
            	    					}

            	    }


            	    if ( state.backtracking==0 ) {
            	    					// expected elements (follow set)
            	    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[64]);
            	    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[65]);
            	    				}

            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            			// expected elements (follow set)
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[66]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[67]);
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[68]);
            	}

            a20=(Token)match(input,51,FOLLOW_51_in_parse_baserequirements_RequirementGroup1062); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirementGroup();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_1_0_0_3, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a20, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[69]);
            		addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[70]);
            		addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[71]);
            		addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[72]);
            		addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[73]);
            		addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[74]);
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
    // BaseRequirements.g:1213:1: parse_baserequirements_Requirement returns [baserequirements.Requirement element = null] : a0= 'Requirement' a1= '{' (a2= 'title' a3= ':' (a4= QUOTED_34_34 ) ( (a5= 'description' a6= ':' (a7= QUOTED_34_34 ) ) )? ( (a8= 'type' a9= ':' ( (a10= 'FUNCTIONAL' |a11= 'NONFUNCTIONAL' ) ) ) )? ( (a14= 'priority' a15= ':' ( (a16= 'HIGH' |a17= 'MEDIUM' |a18= 'LOW' ) ) ) )? ( (a21= 'author' a22= ':' (a23= QUOTED_34_34 ) ) )? ( (a24= 'created' a25= ':' (a26= TEXT ) ) )? ( (a27= 'id' a28= ':' (a29= QUOTED_34_34 ) ) )? ( (a30= 'state' a31= ':' ( (a32= 'NEW' |a33= 'REVIEWED' |a34= 'APPROVED' |a35= 'RESOLVED' ) ) ) )? ( (a38= 'resolution' a39= ':' ( (a40= 'INVALID' |a41= 'ACCEPTED' |a42= 'IMPLEMENTED' |a43= 'LATER' ) ) ) )? ( (a46= 'version' a47= ':' (a48_0= parse_baserequirements_Version ) ) )? ( (a49= 'comments' a50= ':' (a51_0= parse_baserequirements_Comment ) ) )* ( (a52= 'dependencies' a53= ':' (a54= TEXT ) ) )* ( (a55= 'parent' a56= ':' (a57= TEXT ) ) )? ( (a58= 'children' a59= ':' (a60_0= parse_baserequirements_Requirement ) ) )* ) a61= '}' ;
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

            // BaseRequirements.g:1216:2: (a0= 'Requirement' a1= '{' (a2= 'title' a3= ':' (a4= QUOTED_34_34 ) ( (a5= 'description' a6= ':' (a7= QUOTED_34_34 ) ) )? ( (a8= 'type' a9= ':' ( (a10= 'FUNCTIONAL' |a11= 'NONFUNCTIONAL' ) ) ) )? ( (a14= 'priority' a15= ':' ( (a16= 'HIGH' |a17= 'MEDIUM' |a18= 'LOW' ) ) ) )? ( (a21= 'author' a22= ':' (a23= QUOTED_34_34 ) ) )? ( (a24= 'created' a25= ':' (a26= TEXT ) ) )? ( (a27= 'id' a28= ':' (a29= QUOTED_34_34 ) ) )? ( (a30= 'state' a31= ':' ( (a32= 'NEW' |a33= 'REVIEWED' |a34= 'APPROVED' |a35= 'RESOLVED' ) ) ) )? ( (a38= 'resolution' a39= ':' ( (a40= 'INVALID' |a41= 'ACCEPTED' |a42= 'IMPLEMENTED' |a43= 'LATER' ) ) ) )? ( (a46= 'version' a47= ':' (a48_0= parse_baserequirements_Version ) ) )? ( (a49= 'comments' a50= ':' (a51_0= parse_baserequirements_Comment ) ) )* ( (a52= 'dependencies' a53= ':' (a54= TEXT ) ) )* ( (a55= 'parent' a56= ':' (a57= TEXT ) ) )? ( (a58= 'children' a59= ':' (a60_0= parse_baserequirements_Requirement ) ) )* ) a61= '}' )
            // BaseRequirements.g:1217:2: a0= 'Requirement' a1= '{' (a2= 'title' a3= ':' (a4= QUOTED_34_34 ) ( (a5= 'description' a6= ':' (a7= QUOTED_34_34 ) ) )? ( (a8= 'type' a9= ':' ( (a10= 'FUNCTIONAL' |a11= 'NONFUNCTIONAL' ) ) ) )? ( (a14= 'priority' a15= ':' ( (a16= 'HIGH' |a17= 'MEDIUM' |a18= 'LOW' ) ) ) )? ( (a21= 'author' a22= ':' (a23= QUOTED_34_34 ) ) )? ( (a24= 'created' a25= ':' (a26= TEXT ) ) )? ( (a27= 'id' a28= ':' (a29= QUOTED_34_34 ) ) )? ( (a30= 'state' a31= ':' ( (a32= 'NEW' |a33= 'REVIEWED' |a34= 'APPROVED' |a35= 'RESOLVED' ) ) ) )? ( (a38= 'resolution' a39= ':' ( (a40= 'INVALID' |a41= 'ACCEPTED' |a42= 'IMPLEMENTED' |a43= 'LATER' ) ) ) )? ( (a46= 'version' a47= ':' (a48_0= parse_baserequirements_Version ) ) )? ( (a49= 'comments' a50= ':' (a51_0= parse_baserequirements_Comment ) ) )* ( (a52= 'dependencies' a53= ':' (a54= TEXT ) ) )* ( (a55= 'parent' a56= ':' (a57= TEXT ) ) )? ( (a58= 'children' a59= ':' (a60_0= parse_baserequirements_Requirement ) ) )* ) a61= '}'
            {
            a0=(Token)match(input,25,FOLLOW_25_in_parse_baserequirements_Requirement1091); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[75]);
            	}

            a1=(Token)match(input,50,FOLLOW_50_in_parse_baserequirements_Requirement1105); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_1, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[76]);
            	}

            // BaseRequirements.g:1245:2: (a2= 'title' a3= ':' (a4= QUOTED_34_34 ) ( (a5= 'description' a6= ':' (a7= QUOTED_34_34 ) ) )? ( (a8= 'type' a9= ':' ( (a10= 'FUNCTIONAL' |a11= 'NONFUNCTIONAL' ) ) ) )? ( (a14= 'priority' a15= ':' ( (a16= 'HIGH' |a17= 'MEDIUM' |a18= 'LOW' ) ) ) )? ( (a21= 'author' a22= ':' (a23= QUOTED_34_34 ) ) )? ( (a24= 'created' a25= ':' (a26= TEXT ) ) )? ( (a27= 'id' a28= ':' (a29= QUOTED_34_34 ) ) )? ( (a30= 'state' a31= ':' ( (a32= 'NEW' |a33= 'REVIEWED' |a34= 'APPROVED' |a35= 'RESOLVED' ) ) ) )? ( (a38= 'resolution' a39= ':' ( (a40= 'INVALID' |a41= 'ACCEPTED' |a42= 'IMPLEMENTED' |a43= 'LATER' ) ) ) )? ( (a46= 'version' a47= ':' (a48_0= parse_baserequirements_Version ) ) )? ( (a49= 'comments' a50= ':' (a51_0= parse_baserequirements_Comment ) ) )* ( (a52= 'dependencies' a53= ':' (a54= TEXT ) ) )* ( (a55= 'parent' a56= ':' (a57= TEXT ) ) )? ( (a58= 'children' a59= ':' (a60_0= parse_baserequirements_Requirement ) ) )* )
            // BaseRequirements.g:1246:3: a2= 'title' a3= ':' (a4= QUOTED_34_34 ) ( (a5= 'description' a6= ':' (a7= QUOTED_34_34 ) ) )? ( (a8= 'type' a9= ':' ( (a10= 'FUNCTIONAL' |a11= 'NONFUNCTIONAL' ) ) ) )? ( (a14= 'priority' a15= ':' ( (a16= 'HIGH' |a17= 'MEDIUM' |a18= 'LOW' ) ) ) )? ( (a21= 'author' a22= ':' (a23= QUOTED_34_34 ) ) )? ( (a24= 'created' a25= ':' (a26= TEXT ) ) )? ( (a27= 'id' a28= ':' (a29= QUOTED_34_34 ) ) )? ( (a30= 'state' a31= ':' ( (a32= 'NEW' |a33= 'REVIEWED' |a34= 'APPROVED' |a35= 'RESOLVED' ) ) ) )? ( (a38= 'resolution' a39= ':' ( (a40= 'INVALID' |a41= 'ACCEPTED' |a42= 'IMPLEMENTED' |a43= 'LATER' ) ) ) )? ( (a46= 'version' a47= ':' (a48_0= parse_baserequirements_Version ) ) )? ( (a49= 'comments' a50= ':' (a51_0= parse_baserequirements_Comment ) ) )* ( (a52= 'dependencies' a53= ':' (a54= TEXT ) ) )* ( (a55= 'parent' a56= ':' (a57= TEXT ) ) )? ( (a58= 'children' a59= ':' (a60_0= parse_baserequirements_Requirement ) ) )*
            {
            a2=(Token)match(input,47,FOLLOW_47_in_parse_baserequirements_Requirement1123); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (element == null) {
            				element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
            				startIncompleteElement(element);
            			}
            			collectHiddenTokens(element);
            			retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_0, null, true);
            			copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
            		}

            if ( state.backtracking==0 ) {
            			// expected elements (follow set)
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[77]);
            		}

            a3=(Token)match(input,9,FOLLOW_9_in_parse_baserequirements_Requirement1140); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (element == null) {
            				element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
            				startIncompleteElement(element);
            			}
            			collectHiddenTokens(element);
            			retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_1, null, true);
            			copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
            		}

            if ( state.backtracking==0 ) {
            			// expected elements (follow set)
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[78]);
            		}

            // BaseRequirements.g:1274:3: (a4= QUOTED_34_34 )
            // BaseRequirements.g:1275:4: a4= QUOTED_34_34
            {
            a4=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_baserequirements_Requirement1162); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            				if (terminateParsing) {
            					throw new baserequirements.resource.baseRequirements.mopp.BaseRequirementsTerminateParsingException();
            				}
            				if (element == null) {
            					element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
            					startIncompleteElement(element);
            				}
            				if (a4 != null) {
            					baserequirements.resource.baseRequirements.IBaseRequirementsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
            					tokenResolver.setOptions(getOptions());
            					baserequirements.resource.baseRequirements.IBaseRequirementsTokenResolveResult result = getFreshTokenResolveResult();
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
            					retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_2, resolved, true);
            					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a4, element);
            				}
            			}

            }


            if ( state.backtracking==0 ) {
            			// expected elements (follow set)
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[79]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[80]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[81]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[82]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[83]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[84]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[85]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[86]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[87]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[88]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[89]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[90]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[91]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[92]);
            		}

            // BaseRequirements.g:1323:3: ( (a5= 'description' a6= ':' (a7= QUOTED_34_34 ) ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==34) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // BaseRequirements.g:1324:4: (a5= 'description' a6= ':' (a7= QUOTED_34_34 ) )
                    {
                    // BaseRequirements.g:1324:4: (a5= 'description' a6= ':' (a7= QUOTED_34_34 ) )
                    // BaseRequirements.g:1325:5: a5= 'description' a6= ':' (a7= QUOTED_34_34 )
                    {
                    a5=(Token)match(input,34,FOLLOW_34_in_parse_baserequirements_Requirement1200); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    					if (element == null) {
                    						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
                    						startIncompleteElement(element);
                    					}
                    					collectHiddenTokens(element);
                    					retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_3_0_0_0, null, true);
                    					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
                    				}

                    if ( state.backtracking==0 ) {
                    					// expected elements (follow set)
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[93]);
                    				}

                    a6=(Token)match(input,9,FOLLOW_9_in_parse_baserequirements_Requirement1223); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    					if (element == null) {
                    						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
                    						startIncompleteElement(element);
                    					}
                    					collectHiddenTokens(element);
                    					retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_3_0_0_1, null, true);
                    					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
                    				}

                    if ( state.backtracking==0 ) {
                    					// expected elements (follow set)
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[94]);
                    				}

                    // BaseRequirements.g:1353:5: (a7= QUOTED_34_34 )
                    // BaseRequirements.g:1354:6: a7= QUOTED_34_34
                    {
                    a7=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_baserequirements_Requirement1253); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    						if (terminateParsing) {
                    							throw new baserequirements.resource.baseRequirements.mopp.BaseRequirementsTerminateParsingException();
                    						}
                    						if (element == null) {
                    							element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
                    							startIncompleteElement(element);
                    						}
                    						if (a7 != null) {
                    							baserequirements.resource.baseRequirements.IBaseRequirementsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
                    							tokenResolver.setOptions(getOptions());
                    							baserequirements.resource.baseRequirements.IBaseRequirementsTokenResolveResult result = getFreshTokenResolveResult();
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
                    							retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_3_0_0_2, resolved, true);
                    							copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a7, element);
                    						}
                    					}

                    }


                    if ( state.backtracking==0 ) {
                    					// expected elements (follow set)
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[95]);
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[96]);
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[97]);
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[98]);
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[99]);
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[100]);
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[101]);
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[102]);
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[103]);
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[104]);
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[105]);
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[106]);
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[107]);
                    				}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            			// expected elements (follow set)
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[108]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[109]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[110]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[111]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[112]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[113]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[114]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[115]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[116]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[117]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[118]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[119]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[120]);
            		}

            // BaseRequirements.g:1420:3: ( (a8= 'type' a9= ':' ( (a10= 'FUNCTIONAL' |a11= 'NONFUNCTIONAL' ) ) ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==48) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // BaseRequirements.g:1421:4: (a8= 'type' a9= ':' ( (a10= 'FUNCTIONAL' |a11= 'NONFUNCTIONAL' ) ) )
                    {
                    // BaseRequirements.g:1421:4: (a8= 'type' a9= ':' ( (a10= 'FUNCTIONAL' |a11= 'NONFUNCTIONAL' ) ) )
                    // BaseRequirements.g:1422:5: a8= 'type' a9= ':' ( (a10= 'FUNCTIONAL' |a11= 'NONFUNCTIONAL' ) )
                    {
                    a8=(Token)match(input,48,FOLLOW_48_in_parse_baserequirements_Requirement1321); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    					if (element == null) {
                    						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
                    						startIncompleteElement(element);
                    					}
                    					collectHiddenTokens(element);
                    					retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_4_0_0_0, null, true);
                    					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a8, element);
                    				}

                    if ( state.backtracking==0 ) {
                    					// expected elements (follow set)
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[121]);
                    				}

                    a9=(Token)match(input,9,FOLLOW_9_in_parse_baserequirements_Requirement1344); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    					if (element == null) {
                    						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
                    						startIncompleteElement(element);
                    					}
                    					collectHiddenTokens(element);
                    					retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_4_0_0_1, null, true);
                    					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a9, element);
                    				}

                    if ( state.backtracking==0 ) {
                    					// expected elements (follow set)
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[122]);
                    				}

                    // BaseRequirements.g:1450:5: ( (a10= 'FUNCTIONAL' |a11= 'NONFUNCTIONAL' ) )
                    // BaseRequirements.g:1451:6: (a10= 'FUNCTIONAL' |a11= 'NONFUNCTIONAL' )
                    {
                    // BaseRequirements.g:1451:6: (a10= 'FUNCTIONAL' |a11= 'NONFUNCTIONAL' )
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0==13) ) {
                        alt8=1;
                    }
                    else if ( (LA8_0==22) ) {
                        alt8=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return element;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 8, 0, input);

                        throw nvae;

                    }
                    switch (alt8) {
                        case 1 :
                            // BaseRequirements.g:1452:7: a10= 'FUNCTIONAL'
                            {
                            a10=(Token)match(input,13,FOLLOW_13_in_parse_baserequirements_Requirement1382); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            							if (element == null) {
                            								element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
                            								startIncompleteElement(element);
                            							}
                            							collectHiddenTokens(element);
                            							retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_4_0_0_2, null, true);
                            							copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a10, element);
                            							// set value of enumeration attribute
                            							Object value = baserequirements.BaserequirementsPackage.eINSTANCE.getType().getEEnumLiteral(baserequirements.Type.FUNCTIONAL_VALUE).getInstance();
                            							element.eSet(element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.REQUIREMENT__TYPE), value);
                            							completedElement(value, false);
                            						}

                            }
                            break;
                        case 2 :
                            // BaseRequirements.g:1465:14: a11= 'NONFUNCTIONAL'
                            {
                            a11=(Token)match(input,22,FOLLOW_22_in_parse_baserequirements_Requirement1403); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            							if (element == null) {
                            								element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
                            								startIncompleteElement(element);
                            							}
                            							collectHiddenTokens(element);
                            							retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_4_0_0_2, null, true);
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
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[123]);
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[124]);
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[125]);
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[126]);
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[127]);
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[128]);
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[129]);
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[130]);
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[131]);
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[132]);
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[133]);
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[134]);
                    				}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            			// expected elements (follow set)
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[135]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[136]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[137]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[138]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[139]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[140]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[141]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[142]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[143]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[144]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[145]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[146]);
            		}

            // BaseRequirements.g:1514:3: ( (a14= 'priority' a15= ':' ( (a16= 'HIGH' |a17= 'MEDIUM' |a18= 'LOW' ) ) ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==41) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // BaseRequirements.g:1515:4: (a14= 'priority' a15= ':' ( (a16= 'HIGH' |a17= 'MEDIUM' |a18= 'LOW' ) ) )
                    {
                    // BaseRequirements.g:1515:4: (a14= 'priority' a15= ':' ( (a16= 'HIGH' |a17= 'MEDIUM' |a18= 'LOW' ) ) )
                    // BaseRequirements.g:1516:5: a14= 'priority' a15= ':' ( (a16= 'HIGH' |a17= 'MEDIUM' |a18= 'LOW' ) )
                    {
                    a14=(Token)match(input,41,FOLLOW_41_in_parse_baserequirements_Requirement1468); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    					if (element == null) {
                    						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
                    						startIncompleteElement(element);
                    					}
                    					collectHiddenTokens(element);
                    					retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_5_0_0_0, null, true);
                    					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a14, element);
                    				}

                    if ( state.backtracking==0 ) {
                    					// expected elements (follow set)
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[147]);
                    				}

                    a15=(Token)match(input,9,FOLLOW_9_in_parse_baserequirements_Requirement1491); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    					if (element == null) {
                    						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
                    						startIncompleteElement(element);
                    					}
                    					collectHiddenTokens(element);
                    					retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_5_0_0_1, null, true);
                    					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a15, element);
                    				}

                    if ( state.backtracking==0 ) {
                    					// expected elements (follow set)
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[148]);
                    				}

                    // BaseRequirements.g:1544:5: ( (a16= 'HIGH' |a17= 'MEDIUM' |a18= 'LOW' ) )
                    // BaseRequirements.g:1545:6: (a16= 'HIGH' |a17= 'MEDIUM' |a18= 'LOW' )
                    {
                    // BaseRequirements.g:1545:6: (a16= 'HIGH' |a17= 'MEDIUM' |a18= 'LOW' )
                    int alt10=3;
                    switch ( input.LA(1) ) {
                    case 14:
                        {
                        alt10=1;
                        }
                        break;
                    case 19:
                        {
                        alt10=2;
                        }
                        break;
                    case 18:
                        {
                        alt10=3;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return element;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 10, 0, input);

                        throw nvae;

                    }

                    switch (alt10) {
                        case 1 :
                            // BaseRequirements.g:1546:7: a16= 'HIGH'
                            {
                            a16=(Token)match(input,14,FOLLOW_14_in_parse_baserequirements_Requirement1529); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            							if (element == null) {
                            								element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
                            								startIncompleteElement(element);
                            							}
                            							collectHiddenTokens(element);
                            							retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_5_0_0_2, null, true);
                            							copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a16, element);
                            							// set value of enumeration attribute
                            							Object value = baserequirements.BaserequirementsPackage.eINSTANCE.getPriority().getEEnumLiteral(baserequirements.Priority.HIGH_VALUE).getInstance();
                            							element.eSet(element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.REQUIREMENT__PRIORITY), value);
                            							completedElement(value, false);
                            						}

                            }
                            break;
                        case 2 :
                            // BaseRequirements.g:1559:14: a17= 'MEDIUM'
                            {
                            a17=(Token)match(input,19,FOLLOW_19_in_parse_baserequirements_Requirement1550); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            							if (element == null) {
                            								element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
                            								startIncompleteElement(element);
                            							}
                            							collectHiddenTokens(element);
                            							retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_5_0_0_2, null, true);
                            							copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a17, element);
                            							// set value of enumeration attribute
                            							Object value = baserequirements.BaserequirementsPackage.eINSTANCE.getPriority().getEEnumLiteral(baserequirements.Priority.MEDIUM_VALUE).getInstance();
                            							element.eSet(element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.REQUIREMENT__PRIORITY), value);
                            							completedElement(value, false);
                            						}

                            }
                            break;
                        case 3 :
                            // BaseRequirements.g:1572:14: a18= 'LOW'
                            {
                            a18=(Token)match(input,18,FOLLOW_18_in_parse_baserequirements_Requirement1571); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            							if (element == null) {
                            								element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
                            								startIncompleteElement(element);
                            							}
                            							collectHiddenTokens(element);
                            							retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_5_0_0_2, null, true);
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
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[149]);
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[150]);
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[151]);
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[152]);
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[153]);
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[154]);
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[155]);
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[156]);
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[157]);
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[158]);
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[159]);
                    				}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            			// expected elements (follow set)
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[160]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[161]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[162]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[163]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[164]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[165]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[166]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[167]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[168]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[169]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[170]);
            		}

            // BaseRequirements.g:1619:3: ( (a21= 'author' a22= ':' (a23= QUOTED_34_34 ) ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==28) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // BaseRequirements.g:1620:4: (a21= 'author' a22= ':' (a23= QUOTED_34_34 ) )
                    {
                    // BaseRequirements.g:1620:4: (a21= 'author' a22= ':' (a23= QUOTED_34_34 ) )
                    // BaseRequirements.g:1621:5: a21= 'author' a22= ':' (a23= QUOTED_34_34 )
                    {
                    a21=(Token)match(input,28,FOLLOW_28_in_parse_baserequirements_Requirement1636); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    					if (element == null) {
                    						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
                    						startIncompleteElement(element);
                    					}
                    					collectHiddenTokens(element);
                    					retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_6_0_0_0, null, true);
                    					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a21, element);
                    				}

                    if ( state.backtracking==0 ) {
                    					// expected elements (follow set)
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[171]);
                    				}

                    a22=(Token)match(input,9,FOLLOW_9_in_parse_baserequirements_Requirement1659); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    					if (element == null) {
                    						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
                    						startIncompleteElement(element);
                    					}
                    					collectHiddenTokens(element);
                    					retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_6_0_0_1, null, true);
                    					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a22, element);
                    				}

                    if ( state.backtracking==0 ) {
                    					// expected elements (follow set)
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[172]);
                    				}

                    // BaseRequirements.g:1649:5: (a23= QUOTED_34_34 )
                    // BaseRequirements.g:1650:6: a23= QUOTED_34_34
                    {
                    a23=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_baserequirements_Requirement1689); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    						if (terminateParsing) {
                    							throw new baserequirements.resource.baseRequirements.mopp.BaseRequirementsTerminateParsingException();
                    						}
                    						if (element == null) {
                    							element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
                    							startIncompleteElement(element);
                    						}
                    						if (a23 != null) {
                    							baserequirements.resource.baseRequirements.IBaseRequirementsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
                    							tokenResolver.setOptions(getOptions());
                    							baserequirements.resource.baseRequirements.IBaseRequirementsTokenResolveResult result = getFreshTokenResolveResult();
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
                    							retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_6_0_0_2, resolved, true);
                    							copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a23, element);
                    						}
                    					}

                    }


                    if ( state.backtracking==0 ) {
                    					// expected elements (follow set)
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[173]);
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[174]);
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[175]);
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[176]);
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[177]);
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[178]);
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[179]);
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[180]);
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[181]);
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[182]);
                    				}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            			// expected elements (follow set)
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[183]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[184]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[185]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[186]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[187]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[188]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[189]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[190]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[191]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[192]);
            		}

            // BaseRequirements.g:1710:3: ( (a24= 'created' a25= ':' (a26= TEXT ) ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==32) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // BaseRequirements.g:1711:4: (a24= 'created' a25= ':' (a26= TEXT ) )
                    {
                    // BaseRequirements.g:1711:4: (a24= 'created' a25= ':' (a26= TEXT ) )
                    // BaseRequirements.g:1712:5: a24= 'created' a25= ':' (a26= TEXT )
                    {
                    a24=(Token)match(input,32,FOLLOW_32_in_parse_baserequirements_Requirement1757); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    					if (element == null) {
                    						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
                    						startIncompleteElement(element);
                    					}
                    					collectHiddenTokens(element);
                    					retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_7_0_0_0, null, true);
                    					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a24, element);
                    				}

                    if ( state.backtracking==0 ) {
                    					// expected elements (follow set)
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[193]);
                    				}

                    a25=(Token)match(input,9,FOLLOW_9_in_parse_baserequirements_Requirement1780); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    					if (element == null) {
                    						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
                    						startIncompleteElement(element);
                    					}
                    					collectHiddenTokens(element);
                    					retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_7_0_0_1, null, true);
                    					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a25, element);
                    				}

                    if ( state.backtracking==0 ) {
                    					// expected elements (follow set)
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[194]);
                    				}

                    // BaseRequirements.g:1740:5: (a26= TEXT )
                    // BaseRequirements.g:1741:6: a26= TEXT
                    {
                    a26=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_baserequirements_Requirement1810); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    						if (terminateParsing) {
                    							throw new baserequirements.resource.baseRequirements.mopp.BaseRequirementsTerminateParsingException();
                    						}
                    						if (element == null) {
                    							element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
                    							startIncompleteElement(element);
                    						}
                    						if (a26 != null) {
                    							baserequirements.resource.baseRequirements.IBaseRequirementsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
                    							tokenResolver.setOptions(getOptions());
                    							baserequirements.resource.baseRequirements.IBaseRequirementsTokenResolveResult result = getFreshTokenResolveResult();
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
                    							retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_7_0_0_2, resolved, true);
                    							copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a26, element);
                    						}
                    					}

                    }


                    if ( state.backtracking==0 ) {
                    					// expected elements (follow set)
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[195]);
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[196]);
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[197]);
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[198]);
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[199]);
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[200]);
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[201]);
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[202]);
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[203]);
                    				}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            			// expected elements (follow set)
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[204]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[205]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[206]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[207]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[208]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[209]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[210]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[211]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[212]);
            		}

            // BaseRequirements.g:1799:3: ( (a27= 'id' a28= ':' (a29= QUOTED_34_34 ) ) )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==36) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // BaseRequirements.g:1800:4: (a27= 'id' a28= ':' (a29= QUOTED_34_34 ) )
                    {
                    // BaseRequirements.g:1800:4: (a27= 'id' a28= ':' (a29= QUOTED_34_34 ) )
                    // BaseRequirements.g:1801:5: a27= 'id' a28= ':' (a29= QUOTED_34_34 )
                    {
                    a27=(Token)match(input,36,FOLLOW_36_in_parse_baserequirements_Requirement1878); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    					if (element == null) {
                    						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
                    						startIncompleteElement(element);
                    					}
                    					collectHiddenTokens(element);
                    					retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_8_0_0_0, null, true);
                    					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a27, element);
                    				}

                    if ( state.backtracking==0 ) {
                    					// expected elements (follow set)
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[213]);
                    				}

                    a28=(Token)match(input,9,FOLLOW_9_in_parse_baserequirements_Requirement1901); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    					if (element == null) {
                    						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
                    						startIncompleteElement(element);
                    					}
                    					collectHiddenTokens(element);
                    					retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_8_0_0_1, null, true);
                    					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a28, element);
                    				}

                    if ( state.backtracking==0 ) {
                    					// expected elements (follow set)
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[214]);
                    				}

                    // BaseRequirements.g:1829:5: (a29= QUOTED_34_34 )
                    // BaseRequirements.g:1830:6: a29= QUOTED_34_34
                    {
                    a29=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_baserequirements_Requirement1931); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    						if (terminateParsing) {
                    							throw new baserequirements.resource.baseRequirements.mopp.BaseRequirementsTerminateParsingException();
                    						}
                    						if (element == null) {
                    							element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
                    							startIncompleteElement(element);
                    						}
                    						if (a29 != null) {
                    							baserequirements.resource.baseRequirements.IBaseRequirementsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
                    							tokenResolver.setOptions(getOptions());
                    							baserequirements.resource.baseRequirements.IBaseRequirementsTokenResolveResult result = getFreshTokenResolveResult();
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
                    							retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_8_0_0_2, resolved, true);
                    							copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a29, element);
                    						}
                    					}

                    }


                    if ( state.backtracking==0 ) {
                    					// expected elements (follow set)
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[215]);
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[216]);
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[217]);
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[218]);
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[219]);
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[220]);
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[221]);
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[222]);
                    				}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            			// expected elements (follow set)
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[223]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[224]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[225]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[226]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[227]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[228]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[229]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[230]);
            		}

            // BaseRequirements.g:1886:3: ( (a30= 'state' a31= ':' ( (a32= 'NEW' |a33= 'REVIEWED' |a34= 'APPROVED' |a35= 'RESOLVED' ) ) ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==45) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // BaseRequirements.g:1887:4: (a30= 'state' a31= ':' ( (a32= 'NEW' |a33= 'REVIEWED' |a34= 'APPROVED' |a35= 'RESOLVED' ) ) )
                    {
                    // BaseRequirements.g:1887:4: (a30= 'state' a31= ':' ( (a32= 'NEW' |a33= 'REVIEWED' |a34= 'APPROVED' |a35= 'RESOLVED' ) ) )
                    // BaseRequirements.g:1888:5: a30= 'state' a31= ':' ( (a32= 'NEW' |a33= 'REVIEWED' |a34= 'APPROVED' |a35= 'RESOLVED' ) )
                    {
                    a30=(Token)match(input,45,FOLLOW_45_in_parse_baserequirements_Requirement1999); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    					if (element == null) {
                    						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
                    						startIncompleteElement(element);
                    					}
                    					collectHiddenTokens(element);
                    					retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_9_0_0_0, null, true);
                    					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a30, element);
                    				}

                    if ( state.backtracking==0 ) {
                    					// expected elements (follow set)
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[231]);
                    				}

                    a31=(Token)match(input,9,FOLLOW_9_in_parse_baserequirements_Requirement2022); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    					if (element == null) {
                    						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
                    						startIncompleteElement(element);
                    					}
                    					collectHiddenTokens(element);
                    					retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_9_0_0_1, null, true);
                    					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a31, element);
                    				}

                    if ( state.backtracking==0 ) {
                    					// expected elements (follow set)
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[232]);
                    				}

                    // BaseRequirements.g:1916:5: ( (a32= 'NEW' |a33= 'REVIEWED' |a34= 'APPROVED' |a35= 'RESOLVED' ) )
                    // BaseRequirements.g:1917:6: (a32= 'NEW' |a33= 'REVIEWED' |a34= 'APPROVED' |a35= 'RESOLVED' )
                    {
                    // BaseRequirements.g:1917:6: (a32= 'NEW' |a33= 'REVIEWED' |a34= 'APPROVED' |a35= 'RESOLVED' )
                    int alt15=4;
                    switch ( input.LA(1) ) {
                    case 21:
                        {
                        alt15=1;
                        }
                        break;
                    case 24:
                        {
                        alt15=2;
                        }
                        break;
                    case 11:
                        {
                        alt15=3;
                        }
                        break;
                    case 23:
                        {
                        alt15=4;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return element;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 15, 0, input);

                        throw nvae;

                    }

                    switch (alt15) {
                        case 1 :
                            // BaseRequirements.g:1918:7: a32= 'NEW'
                            {
                            a32=(Token)match(input,21,FOLLOW_21_in_parse_baserequirements_Requirement2060); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            							if (element == null) {
                            								element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
                            								startIncompleteElement(element);
                            							}
                            							collectHiddenTokens(element);
                            							retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_9_0_0_2, null, true);
                            							copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a32, element);
                            							// set value of enumeration attribute
                            							Object value = baserequirements.BaserequirementsPackage.eINSTANCE.getState().getEEnumLiteral(baserequirements.State.NEW_VALUE).getInstance();
                            							element.eSet(element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.REQUIREMENT__STATE), value);
                            							completedElement(value, false);
                            						}

                            }
                            break;
                        case 2 :
                            // BaseRequirements.g:1931:14: a33= 'REVIEWED'
                            {
                            a33=(Token)match(input,24,FOLLOW_24_in_parse_baserequirements_Requirement2081); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            							if (element == null) {
                            								element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
                            								startIncompleteElement(element);
                            							}
                            							collectHiddenTokens(element);
                            							retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_9_0_0_2, null, true);
                            							copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a33, element);
                            							// set value of enumeration attribute
                            							Object value = baserequirements.BaserequirementsPackage.eINSTANCE.getState().getEEnumLiteral(baserequirements.State.REVIEWED_VALUE).getInstance();
                            							element.eSet(element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.REQUIREMENT__STATE), value);
                            							completedElement(value, false);
                            						}

                            }
                            break;
                        case 3 :
                            // BaseRequirements.g:1944:14: a34= 'APPROVED'
                            {
                            a34=(Token)match(input,11,FOLLOW_11_in_parse_baserequirements_Requirement2102); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            							if (element == null) {
                            								element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
                            								startIncompleteElement(element);
                            							}
                            							collectHiddenTokens(element);
                            							retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_9_0_0_2, null, true);
                            							copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a34, element);
                            							// set value of enumeration attribute
                            							Object value = baserequirements.BaserequirementsPackage.eINSTANCE.getState().getEEnumLiteral(baserequirements.State.APPROVED_VALUE).getInstance();
                            							element.eSet(element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.REQUIREMENT__STATE), value);
                            							completedElement(value, false);
                            						}

                            }
                            break;
                        case 4 :
                            // BaseRequirements.g:1957:14: a35= 'RESOLVED'
                            {
                            a35=(Token)match(input,23,FOLLOW_23_in_parse_baserequirements_Requirement2123); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            							if (element == null) {
                            								element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
                            								startIncompleteElement(element);
                            							}
                            							collectHiddenTokens(element);
                            							retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_9_0_0_2, null, true);
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
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[233]);
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[234]);
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[235]);
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[236]);
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[237]);
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[238]);
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[239]);
                    				}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            			// expected elements (follow set)
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[240]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[241]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[242]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[243]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[244]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[245]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[246]);
            		}

            // BaseRequirements.g:1996:3: ( (a38= 'resolution' a39= ':' ( (a40= 'INVALID' |a41= 'ACCEPTED' |a42= 'IMPLEMENTED' |a43= 'LATER' ) ) ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==43) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // BaseRequirements.g:1997:4: (a38= 'resolution' a39= ':' ( (a40= 'INVALID' |a41= 'ACCEPTED' |a42= 'IMPLEMENTED' |a43= 'LATER' ) ) )
                    {
                    // BaseRequirements.g:1997:4: (a38= 'resolution' a39= ':' ( (a40= 'INVALID' |a41= 'ACCEPTED' |a42= 'IMPLEMENTED' |a43= 'LATER' ) ) )
                    // BaseRequirements.g:1998:5: a38= 'resolution' a39= ':' ( (a40= 'INVALID' |a41= 'ACCEPTED' |a42= 'IMPLEMENTED' |a43= 'LATER' ) )
                    {
                    a38=(Token)match(input,43,FOLLOW_43_in_parse_baserequirements_Requirement2188); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    					if (element == null) {
                    						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
                    						startIncompleteElement(element);
                    					}
                    					collectHiddenTokens(element);
                    					retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_10_0_0_0, null, true);
                    					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a38, element);
                    				}

                    if ( state.backtracking==0 ) {
                    					// expected elements (follow set)
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[247]);
                    				}

                    a39=(Token)match(input,9,FOLLOW_9_in_parse_baserequirements_Requirement2211); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    					if (element == null) {
                    						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
                    						startIncompleteElement(element);
                    					}
                    					collectHiddenTokens(element);
                    					retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_10_0_0_1, null, true);
                    					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a39, element);
                    				}

                    if ( state.backtracking==0 ) {
                    					// expected elements (follow set)
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[248]);
                    				}

                    // BaseRequirements.g:2026:5: ( (a40= 'INVALID' |a41= 'ACCEPTED' |a42= 'IMPLEMENTED' |a43= 'LATER' ) )
                    // BaseRequirements.g:2027:6: (a40= 'INVALID' |a41= 'ACCEPTED' |a42= 'IMPLEMENTED' |a43= 'LATER' )
                    {
                    // BaseRequirements.g:2027:6: (a40= 'INVALID' |a41= 'ACCEPTED' |a42= 'IMPLEMENTED' |a43= 'LATER' )
                    int alt17=4;
                    switch ( input.LA(1) ) {
                    case 16:
                        {
                        alt17=1;
                        }
                        break;
                    case 10:
                        {
                        alt17=2;
                        }
                        break;
                    case 15:
                        {
                        alt17=3;
                        }
                        break;
                    case 17:
                        {
                        alt17=4;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return element;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 17, 0, input);

                        throw nvae;

                    }

                    switch (alt17) {
                        case 1 :
                            // BaseRequirements.g:2028:7: a40= 'INVALID'
                            {
                            a40=(Token)match(input,16,FOLLOW_16_in_parse_baserequirements_Requirement2249); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            							if (element == null) {
                            								element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
                            								startIncompleteElement(element);
                            							}
                            							collectHiddenTokens(element);
                            							retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_10_0_0_2, null, true);
                            							copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a40, element);
                            							// set value of enumeration attribute
                            							Object value = baserequirements.BaserequirementsPackage.eINSTANCE.getResolution().getEEnumLiteral(baserequirements.Resolution.INVALID_VALUE).getInstance();
                            							element.eSet(element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.REQUIREMENT__RESOLUTION), value);
                            							completedElement(value, false);
                            						}

                            }
                            break;
                        case 2 :
                            // BaseRequirements.g:2041:14: a41= 'ACCEPTED'
                            {
                            a41=(Token)match(input,10,FOLLOW_10_in_parse_baserequirements_Requirement2270); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            							if (element == null) {
                            								element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
                            								startIncompleteElement(element);
                            							}
                            							collectHiddenTokens(element);
                            							retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_10_0_0_2, null, true);
                            							copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a41, element);
                            							// set value of enumeration attribute
                            							Object value = baserequirements.BaserequirementsPackage.eINSTANCE.getResolution().getEEnumLiteral(baserequirements.Resolution.ACCEPTED_VALUE).getInstance();
                            							element.eSet(element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.REQUIREMENT__RESOLUTION), value);
                            							completedElement(value, false);
                            						}

                            }
                            break;
                        case 3 :
                            // BaseRequirements.g:2054:14: a42= 'IMPLEMENTED'
                            {
                            a42=(Token)match(input,15,FOLLOW_15_in_parse_baserequirements_Requirement2291); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            							if (element == null) {
                            								element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
                            								startIncompleteElement(element);
                            							}
                            							collectHiddenTokens(element);
                            							retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_10_0_0_2, null, true);
                            							copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a42, element);
                            							// set value of enumeration attribute
                            							Object value = baserequirements.BaserequirementsPackage.eINSTANCE.getResolution().getEEnumLiteral(baserequirements.Resolution.IMPLEMENTED_VALUE).getInstance();
                            							element.eSet(element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.REQUIREMENT__RESOLUTION), value);
                            							completedElement(value, false);
                            						}

                            }
                            break;
                        case 4 :
                            // BaseRequirements.g:2067:14: a43= 'LATER'
                            {
                            a43=(Token)match(input,17,FOLLOW_17_in_parse_baserequirements_Requirement2312); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            							if (element == null) {
                            								element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
                            								startIncompleteElement(element);
                            							}
                            							collectHiddenTokens(element);
                            							retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_10_0_0_2, null, true);
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
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[249]);
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[250]);
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[251]);
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[252]);
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[253]);
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[254]);
                    				}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            			// expected elements (follow set)
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[255]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[256]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[257]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[258]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[259]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[260]);
            		}

            // BaseRequirements.g:2104:3: ( (a46= 'version' a47= ':' (a48_0= parse_baserequirements_Version ) ) )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==49) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // BaseRequirements.g:2105:4: (a46= 'version' a47= ':' (a48_0= parse_baserequirements_Version ) )
                    {
                    // BaseRequirements.g:2105:4: (a46= 'version' a47= ':' (a48_0= parse_baserequirements_Version ) )
                    // BaseRequirements.g:2106:5: a46= 'version' a47= ':' (a48_0= parse_baserequirements_Version )
                    {
                    a46=(Token)match(input,49,FOLLOW_49_in_parse_baserequirements_Requirement2377); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    					if (element == null) {
                    						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
                    						startIncompleteElement(element);
                    					}
                    					collectHiddenTokens(element);
                    					retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_11_0_0_0, null, true);
                    					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a46, element);
                    				}

                    if ( state.backtracking==0 ) {
                    					// expected elements (follow set)
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[261]);
                    				}

                    a47=(Token)match(input,9,FOLLOW_9_in_parse_baserequirements_Requirement2400); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    					if (element == null) {
                    						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
                    						startIncompleteElement(element);
                    					}
                    					collectHiddenTokens(element);
                    					retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_11_0_0_1, null, true);
                    					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a47, element);
                    				}

                    if ( state.backtracking==0 ) {
                    					// expected elements (follow set)
                    					addExpectedElement(baserequirements.BaserequirementsPackage.eINSTANCE.getRequirement(), baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[262]);
                    				}

                    // BaseRequirements.g:2134:5: (a48_0= parse_baserequirements_Version )
                    // BaseRequirements.g:2135:6: a48_0= parse_baserequirements_Version
                    {
                    pushFollow(FOLLOW_parse_baserequirements_Version_in_parse_baserequirements_Requirement2430);
                    a48_0=parse_baserequirements_Version();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    						if (terminateParsing) {
                    							throw new baserequirements.resource.baseRequirements.mopp.BaseRequirementsTerminateParsingException();
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
                    							retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_11_0_0_2, a48_0, true);
                    							copyLocalizationInfos(a48_0, element);
                    						}
                    					}

                    }


                    if ( state.backtracking==0 ) {
                    					// expected elements (follow set)
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[263]);
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[264]);
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[265]);
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[266]);
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[267]);
                    				}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            			// expected elements (follow set)
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[268]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[269]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[270]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[271]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[272]);
            		}

            // BaseRequirements.g:2175:3: ( (a49= 'comments' a50= ':' (a51_0= parse_baserequirements_Comment ) ) )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==31) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // BaseRequirements.g:2176:4: (a49= 'comments' a50= ':' (a51_0= parse_baserequirements_Comment ) )
            	    {
            	    // BaseRequirements.g:2176:4: (a49= 'comments' a50= ':' (a51_0= parse_baserequirements_Comment ) )
            	    // BaseRequirements.g:2177:5: a49= 'comments' a50= ':' (a51_0= parse_baserequirements_Comment )
            	    {
            	    a49=(Token)match(input,31,FOLLOW_31_in_parse_baserequirements_Requirement2492); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    					if (element == null) {
            	    						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
            	    						startIncompleteElement(element);
            	    					}
            	    					collectHiddenTokens(element);
            	    					retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_12_0_0_0, null, true);
            	    					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a49, element);
            	    				}

            	    if ( state.backtracking==0 ) {
            	    					// expected elements (follow set)
            	    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[273]);
            	    				}

            	    a50=(Token)match(input,9,FOLLOW_9_in_parse_baserequirements_Requirement2515); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    					if (element == null) {
            	    						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
            	    						startIncompleteElement(element);
            	    					}
            	    					collectHiddenTokens(element);
            	    					retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_12_0_0_1, null, true);
            	    					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a50, element);
            	    				}

            	    if ( state.backtracking==0 ) {
            	    					// expected elements (follow set)
            	    					addExpectedElement(baserequirements.BaserequirementsPackage.eINSTANCE.getRequirement(), baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[274]);
            	    				}

            	    // BaseRequirements.g:2205:5: (a51_0= parse_baserequirements_Comment )
            	    // BaseRequirements.g:2206:6: a51_0= parse_baserequirements_Comment
            	    {
            	    pushFollow(FOLLOW_parse_baserequirements_Comment_in_parse_baserequirements_Requirement2545);
            	    a51_0=parse_baserequirements_Comment();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    						if (terminateParsing) {
            	    							throw new baserequirements.resource.baseRequirements.mopp.BaseRequirementsTerminateParsingException();
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
            	    							retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_12_0_0_2, a51_0, true);
            	    							copyLocalizationInfos(a51_0, element);
            	    						}
            	    					}

            	    }


            	    if ( state.backtracking==0 ) {
            	    					// expected elements (follow set)
            	    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[275]);
            	    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[276]);
            	    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[277]);
            	    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[278]);
            	    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[279]);
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
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[280]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[281]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[282]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[283]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[284]);
            		}

            // BaseRequirements.g:2246:3: ( (a52= 'dependencies' a53= ':' (a54= TEXT ) ) )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==33) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // BaseRequirements.g:2247:4: (a52= 'dependencies' a53= ':' (a54= TEXT ) )
            	    {
            	    // BaseRequirements.g:2247:4: (a52= 'dependencies' a53= ':' (a54= TEXT ) )
            	    // BaseRequirements.g:2248:5: a52= 'dependencies' a53= ':' (a54= TEXT )
            	    {
            	    a52=(Token)match(input,33,FOLLOW_33_in_parse_baserequirements_Requirement2607); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    					if (element == null) {
            	    						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
            	    						startIncompleteElement(element);
            	    					}
            	    					collectHiddenTokens(element);
            	    					retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_13_0_0_0, null, true);
            	    					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a52, element);
            	    				}

            	    if ( state.backtracking==0 ) {
            	    					// expected elements (follow set)
            	    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[285]);
            	    				}

            	    a53=(Token)match(input,9,FOLLOW_9_in_parse_baserequirements_Requirement2630); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    					if (element == null) {
            	    						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
            	    						startIncompleteElement(element);
            	    					}
            	    					collectHiddenTokens(element);
            	    					retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_13_0_0_1, null, true);
            	    					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a53, element);
            	    				}

            	    if ( state.backtracking==0 ) {
            	    					// expected elements (follow set)
            	    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[286]);
            	    				}

            	    // BaseRequirements.g:2276:5: (a54= TEXT )
            	    // BaseRequirements.g:2277:6: a54= TEXT
            	    {
            	    a54=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_baserequirements_Requirement2660); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    						if (terminateParsing) {
            	    							throw new baserequirements.resource.baseRequirements.mopp.BaseRequirementsTerminateParsingException();
            	    						}
            	    						if (element == null) {
            	    							element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
            	    							startIncompleteElement(element);
            	    						}
            	    						if (a54 != null) {
            	    							baserequirements.resource.baseRequirements.IBaseRequirementsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            	    							tokenResolver.setOptions(getOptions());
            	    							baserequirements.resource.baseRequirements.IBaseRequirementsTokenResolveResult result = getFreshTokenResolveResult();
            	    							tokenResolver.resolve(a54.getText(), element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.REQUIREMENT__DEPENDENCIES), result);
            	    							Object resolvedObject = result.getResolvedToken();
            	    							if (resolvedObject == null) {
            	    								addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a54).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a54).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a54).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a54).getStopIndex());
            	    							}
            	    							String resolved = (String) resolvedObject;
            	    							baserequirements.Requirement proxy = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
            	    							collectHiddenTokens(element);
            	    							registerContextDependentProxy(new baserequirements.resource.baseRequirements.mopp.BaseRequirementsContextDependentURIFragmentFactory<baserequirements.Requirement, baserequirements.Requirement>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getRequirementDependenciesReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.REQUIREMENT__DEPENDENCIES), resolved, proxy);
            	    							if (proxy != null) {
            	    								Object value = proxy;
            	    								addObjectToList(element, baserequirements.BaserequirementsPackage.REQUIREMENT__DEPENDENCIES, value);
            	    								completedElement(value, false);
            	    							}
            	    							collectHiddenTokens(element);
            	    							retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_13_0_0_2, proxy, true);
            	    							copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a54, element);
            	    							copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a54, proxy);
            	    						}
            	    					}

            	    }


            	    if ( state.backtracking==0 ) {
            	    					// expected elements (follow set)
            	    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[287]);
            	    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[288]);
            	    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[289]);
            	    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[290]);
            	    				}

            	    }


            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            			// expected elements (follow set)
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[291]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[292]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[293]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[294]);
            		}

            // BaseRequirements.g:2329:3: ( (a55= 'parent' a56= ':' (a57= TEXT ) ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==40) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // BaseRequirements.g:2330:4: (a55= 'parent' a56= ':' (a57= TEXT ) )
                    {
                    // BaseRequirements.g:2330:4: (a55= 'parent' a56= ':' (a57= TEXT ) )
                    // BaseRequirements.g:2331:5: a55= 'parent' a56= ':' (a57= TEXT )
                    {
                    a55=(Token)match(input,40,FOLLOW_40_in_parse_baserequirements_Requirement2728); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    					if (element == null) {
                    						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
                    						startIncompleteElement(element);
                    					}
                    					collectHiddenTokens(element);
                    					retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_14_0_0_0, null, true);
                    					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a55, element);
                    				}

                    if ( state.backtracking==0 ) {
                    					// expected elements (follow set)
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[295]);
                    				}

                    a56=(Token)match(input,9,FOLLOW_9_in_parse_baserequirements_Requirement2751); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    					if (element == null) {
                    						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
                    						startIncompleteElement(element);
                    					}
                    					collectHiddenTokens(element);
                    					retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_14_0_0_1, null, true);
                    					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a56, element);
                    				}

                    if ( state.backtracking==0 ) {
                    					// expected elements (follow set)
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[296]);
                    				}

                    // BaseRequirements.g:2359:5: (a57= TEXT )
                    // BaseRequirements.g:2360:6: a57= TEXT
                    {
                    a57=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_baserequirements_Requirement2781); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    						if (terminateParsing) {
                    							throw new baserequirements.resource.baseRequirements.mopp.BaseRequirementsTerminateParsingException();
                    						}
                    						if (element == null) {
                    							element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
                    							startIncompleteElement(element);
                    						}
                    						if (a57 != null) {
                    							baserequirements.resource.baseRequirements.IBaseRequirementsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
                    							tokenResolver.setOptions(getOptions());
                    							baserequirements.resource.baseRequirements.IBaseRequirementsTokenResolveResult result = getFreshTokenResolveResult();
                    							tokenResolver.resolve(a57.getText(), element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.REQUIREMENT__PARENT), result);
                    							Object resolvedObject = result.getResolvedToken();
                    							if (resolvedObject == null) {
                    								addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a57).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a57).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a57).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a57).getStopIndex());
                    							}
                    							String resolved = (String) resolvedObject;
                    							baserequirements.Requirement proxy = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
                    							collectHiddenTokens(element);
                    							registerContextDependentProxy(new baserequirements.resource.baseRequirements.mopp.BaseRequirementsContextDependentURIFragmentFactory<baserequirements.Requirement, baserequirements.Requirement>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getRequirementParentReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.REQUIREMENT__PARENT), resolved, proxy);
                    							if (proxy != null) {
                    								Object value = proxy;
                    								element.eSet(element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.REQUIREMENT__PARENT), value);
                    								completedElement(value, false);
                    							}
                    							collectHiddenTokens(element);
                    							retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_14_0_0_2, proxy, true);
                    							copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a57, element);
                    							copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a57, proxy);
                    						}
                    					}

                    }


                    if ( state.backtracking==0 ) {
                    					// expected elements (follow set)
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[297]);
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[298]);
                    				}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            			// expected elements (follow set)
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[299]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[300]);
            		}

            // BaseRequirements.g:2408:3: ( (a58= 'children' a59= ':' (a60_0= parse_baserequirements_Requirement ) ) )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==30) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // BaseRequirements.g:2409:4: (a58= 'children' a59= ':' (a60_0= parse_baserequirements_Requirement ) )
            	    {
            	    // BaseRequirements.g:2409:4: (a58= 'children' a59= ':' (a60_0= parse_baserequirements_Requirement ) )
            	    // BaseRequirements.g:2410:5: a58= 'children' a59= ':' (a60_0= parse_baserequirements_Requirement )
            	    {
            	    a58=(Token)match(input,30,FOLLOW_30_in_parse_baserequirements_Requirement2849); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    					if (element == null) {
            	    						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
            	    						startIncompleteElement(element);
            	    					}
            	    					collectHiddenTokens(element);
            	    					retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_15_0_0_0, null, true);
            	    					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a58, element);
            	    				}

            	    if ( state.backtracking==0 ) {
            	    					// expected elements (follow set)
            	    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[301]);
            	    				}

            	    a59=(Token)match(input,9,FOLLOW_9_in_parse_baserequirements_Requirement2872); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    					if (element == null) {
            	    						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
            	    						startIncompleteElement(element);
            	    					}
            	    					collectHiddenTokens(element);
            	    					retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_15_0_0_1, null, true);
            	    					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a59, element);
            	    				}

            	    if ( state.backtracking==0 ) {
            	    					// expected elements (follow set)
            	    					addExpectedElement(baserequirements.BaserequirementsPackage.eINSTANCE.getRequirement(), baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[302]);
            	    				}

            	    // BaseRequirements.g:2438:5: (a60_0= parse_baserequirements_Requirement )
            	    // BaseRequirements.g:2439:6: a60_0= parse_baserequirements_Requirement
            	    {
            	    pushFollow(FOLLOW_parse_baserequirements_Requirement_in_parse_baserequirements_Requirement2902);
            	    a60_0=parse_baserequirements_Requirement();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    						if (terminateParsing) {
            	    							throw new baserequirements.resource.baseRequirements.mopp.BaseRequirementsTerminateParsingException();
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
            	    							retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_15_0_0_2, a60_0, true);
            	    							copyLocalizationInfos(a60_0, element);
            	    						}
            	    					}

            	    }


            	    if ( state.backtracking==0 ) {
            	    					// expected elements (follow set)
            	    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[303]);
            	    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[304]);
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
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[305]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[306]);
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[307]);
            	}

            a61=(Token)match(input,51,FOLLOW_51_in_parse_baserequirements_Requirement2960); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_3, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a61, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[308]);
            		addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[309]);
            		addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[310]);
            		addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[311]);
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
    // BaseRequirements.g:2498:1: parse_baserequirements_Version returns [baserequirements.Version element = null] : a0= 'Version' a1= '{' (a2= 'major' a3= ':' (a4= TEXT ) ( (a5= 'minor' a6= ':' (a7= TEXT ) ) )? ( (a8= 'service' a9= ':' (a10= TEXT ) ) )* ) a11= '}' ;
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

            // BaseRequirements.g:2501:2: (a0= 'Version' a1= '{' (a2= 'major' a3= ':' (a4= TEXT ) ( (a5= 'minor' a6= ':' (a7= TEXT ) ) )? ( (a8= 'service' a9= ':' (a10= TEXT ) ) )* ) a11= '}' )
            // BaseRequirements.g:2502:2: a0= 'Version' a1= '{' (a2= 'major' a3= ':' (a4= TEXT ) ( (a5= 'minor' a6= ':' (a7= TEXT ) ) )? ( (a8= 'service' a9= ':' (a10= TEXT ) ) )* ) a11= '}'
            {
            a0=(Token)match(input,27,FOLLOW_27_in_parse_baserequirements_Version2989); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = baserequirements.BaserequirementsFactory.eINSTANCE.createVersion();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_3_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[312]);
            	}

            a1=(Token)match(input,50,FOLLOW_50_in_parse_baserequirements_Version3003); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = baserequirements.BaserequirementsFactory.eINSTANCE.createVersion();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_3_0_0_1, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[313]);
            	}

            // BaseRequirements.g:2530:2: (a2= 'major' a3= ':' (a4= TEXT ) ( (a5= 'minor' a6= ':' (a7= TEXT ) ) )? ( (a8= 'service' a9= ':' (a10= TEXT ) ) )* )
            // BaseRequirements.g:2531:3: a2= 'major' a3= ':' (a4= TEXT ) ( (a5= 'minor' a6= ':' (a7= TEXT ) ) )? ( (a8= 'service' a9= ':' (a10= TEXT ) ) )*
            {
            a2=(Token)match(input,37,FOLLOW_37_in_parse_baserequirements_Version3021); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (element == null) {
            				element = baserequirements.BaserequirementsFactory.eINSTANCE.createVersion();
            				startIncompleteElement(element);
            			}
            			collectHiddenTokens(element);
            			retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_3_0_0_2_0_0_0, null, true);
            			copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
            		}

            if ( state.backtracking==0 ) {
            			// expected elements (follow set)
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[314]);
            		}

            a3=(Token)match(input,9,FOLLOW_9_in_parse_baserequirements_Version3038); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (element == null) {
            				element = baserequirements.BaserequirementsFactory.eINSTANCE.createVersion();
            				startIncompleteElement(element);
            			}
            			collectHiddenTokens(element);
            			retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_3_0_0_2_0_0_1, null, true);
            			copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
            		}

            if ( state.backtracking==0 ) {
            			// expected elements (follow set)
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[315]);
            		}

            // BaseRequirements.g:2559:3: (a4= TEXT )
            // BaseRequirements.g:2560:4: a4= TEXT
            {
            a4=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_baserequirements_Version3060); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            				if (terminateParsing) {
            					throw new baserequirements.resource.baseRequirements.mopp.BaseRequirementsTerminateParsingException();
            				}
            				if (element == null) {
            					element = baserequirements.BaserequirementsFactory.eINSTANCE.createVersion();
            					startIncompleteElement(element);
            				}
            				if (a4 != null) {
            					baserequirements.resource.baseRequirements.IBaseRequirementsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            					tokenResolver.setOptions(getOptions());
            					baserequirements.resource.baseRequirements.IBaseRequirementsTokenResolveResult result = getFreshTokenResolveResult();
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
            					retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_3_0_0_2_0_0_2, resolved, true);
            					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a4, element);
            				}
            			}

            }


            if ( state.backtracking==0 ) {
            			// expected elements (follow set)
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[316]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[317]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[318]);
            		}

            // BaseRequirements.g:2597:3: ( (a5= 'minor' a6= ':' (a7= TEXT ) ) )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==38) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // BaseRequirements.g:2598:4: (a5= 'minor' a6= ':' (a7= TEXT ) )
                    {
                    // BaseRequirements.g:2598:4: (a5= 'minor' a6= ':' (a7= TEXT ) )
                    // BaseRequirements.g:2599:5: a5= 'minor' a6= ':' (a7= TEXT )
                    {
                    a5=(Token)match(input,38,FOLLOW_38_in_parse_baserequirements_Version3098); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    					if (element == null) {
                    						element = baserequirements.BaserequirementsFactory.eINSTANCE.createVersion();
                    						startIncompleteElement(element);
                    					}
                    					collectHiddenTokens(element);
                    					retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_3_0_0_2_0_0_3_0_0_0, null, true);
                    					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
                    				}

                    if ( state.backtracking==0 ) {
                    					// expected elements (follow set)
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[319]);
                    				}

                    a6=(Token)match(input,9,FOLLOW_9_in_parse_baserequirements_Version3121); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    					if (element == null) {
                    						element = baserequirements.BaserequirementsFactory.eINSTANCE.createVersion();
                    						startIncompleteElement(element);
                    					}
                    					collectHiddenTokens(element);
                    					retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_3_0_0_2_0_0_3_0_0_1, null, true);
                    					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
                    				}

                    if ( state.backtracking==0 ) {
                    					// expected elements (follow set)
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[320]);
                    				}

                    // BaseRequirements.g:2627:5: (a7= TEXT )
                    // BaseRequirements.g:2628:6: a7= TEXT
                    {
                    a7=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_baserequirements_Version3151); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    						if (terminateParsing) {
                    							throw new baserequirements.resource.baseRequirements.mopp.BaseRequirementsTerminateParsingException();
                    						}
                    						if (element == null) {
                    							element = baserequirements.BaserequirementsFactory.eINSTANCE.createVersion();
                    							startIncompleteElement(element);
                    						}
                    						if (a7 != null) {
                    							baserequirements.resource.baseRequirements.IBaseRequirementsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
                    							tokenResolver.setOptions(getOptions());
                    							baserequirements.resource.baseRequirements.IBaseRequirementsTokenResolveResult result = getFreshTokenResolveResult();
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
                    							retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_3_0_0_2_0_0_3_0_0_2, resolved, true);
                    							copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a7, element);
                    						}
                    					}

                    }


                    if ( state.backtracking==0 ) {
                    					// expected elements (follow set)
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[321]);
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[322]);
                    				}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            			// expected elements (follow set)
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[323]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[324]);
            		}

            // BaseRequirements.g:2672:3: ( (a8= 'service' a9= ':' (a10= TEXT ) ) )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==44) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // BaseRequirements.g:2673:4: (a8= 'service' a9= ':' (a10= TEXT ) )
            	    {
            	    // BaseRequirements.g:2673:4: (a8= 'service' a9= ':' (a10= TEXT ) )
            	    // BaseRequirements.g:2674:5: a8= 'service' a9= ':' (a10= TEXT )
            	    {
            	    a8=(Token)match(input,44,FOLLOW_44_in_parse_baserequirements_Version3219); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    					if (element == null) {
            	    						element = baserequirements.BaserequirementsFactory.eINSTANCE.createVersion();
            	    						startIncompleteElement(element);
            	    					}
            	    					collectHiddenTokens(element);
            	    					retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_3_0_0_2_0_0_4_0_0_0, null, true);
            	    					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a8, element);
            	    				}

            	    if ( state.backtracking==0 ) {
            	    					// expected elements (follow set)
            	    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[325]);
            	    				}

            	    a9=(Token)match(input,9,FOLLOW_9_in_parse_baserequirements_Version3242); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    					if (element == null) {
            	    						element = baserequirements.BaserequirementsFactory.eINSTANCE.createVersion();
            	    						startIncompleteElement(element);
            	    					}
            	    					collectHiddenTokens(element);
            	    					retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_3_0_0_2_0_0_4_0_0_1, null, true);
            	    					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a9, element);
            	    				}

            	    if ( state.backtracking==0 ) {
            	    					// expected elements (follow set)
            	    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[326]);
            	    				}

            	    // BaseRequirements.g:2702:5: (a10= TEXT )
            	    // BaseRequirements.g:2703:6: a10= TEXT
            	    {
            	    a10=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_baserequirements_Version3272); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    						if (terminateParsing) {
            	    							throw new baserequirements.resource.baseRequirements.mopp.BaseRequirementsTerminateParsingException();
            	    						}
            	    						if (element == null) {
            	    							element = baserequirements.BaserequirementsFactory.eINSTANCE.createVersion();
            	    							startIncompleteElement(element);
            	    						}
            	    						if (a10 != null) {
            	    							baserequirements.resource.baseRequirements.IBaseRequirementsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            	    							tokenResolver.setOptions(getOptions());
            	    							baserequirements.resource.baseRequirements.IBaseRequirementsTokenResolveResult result = getFreshTokenResolveResult();
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
            	    							retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_3_0_0_2_0_0_4_0_0_2, resolved, true);
            	    							copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a10, element);
            	    						}
            	    					}

            	    }


            	    if ( state.backtracking==0 ) {
            	    					// expected elements (follow set)
            	    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[327]);
            	    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[328]);
            	    				}

            	    }


            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            			// expected elements (follow set)
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[329]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[330]);
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[331]);
            	}

            a11=(Token)match(input,51,FOLLOW_51_in_parse_baserequirements_Version3336); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = baserequirements.BaserequirementsFactory.eINSTANCE.createVersion();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_3_0_0_3, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a11, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[332]);
            		addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[333]);
            		addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[334]);
            		addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[335]);
            		addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[336]);
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
    // BaseRequirements.g:2773:1: parse_baserequirements_Comment returns [baserequirements.Comment element = null] : a0= 'Comment' a1= '{' (a2= 'subject' a3= ':' (a4= QUOTED_34_34 ) ( (a5= 'body' a6= ':' (a7= QUOTED_34_34 ) ) )? ( (a8= 'author' a9= ':' (a10= QUOTED_34_34 ) ) )? ( (a11= 'created' a12= ':' (a13= TEXT ) ) )? ( (a14= 'children' a15= ':' (a16_0= parse_baserequirements_Comment ) ) )* ) a17= '}' ;
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

            // BaseRequirements.g:2776:2: (a0= 'Comment' a1= '{' (a2= 'subject' a3= ':' (a4= QUOTED_34_34 ) ( (a5= 'body' a6= ':' (a7= QUOTED_34_34 ) ) )? ( (a8= 'author' a9= ':' (a10= QUOTED_34_34 ) ) )? ( (a11= 'created' a12= ':' (a13= TEXT ) ) )? ( (a14= 'children' a15= ':' (a16_0= parse_baserequirements_Comment ) ) )* ) a17= '}' )
            // BaseRequirements.g:2777:2: a0= 'Comment' a1= '{' (a2= 'subject' a3= ':' (a4= QUOTED_34_34 ) ( (a5= 'body' a6= ':' (a7= QUOTED_34_34 ) ) )? ( (a8= 'author' a9= ':' (a10= QUOTED_34_34 ) ) )? ( (a11= 'created' a12= ':' (a13= TEXT ) ) )? ( (a14= 'children' a15= ':' (a16_0= parse_baserequirements_Comment ) ) )* ) a17= '}'
            {
            a0=(Token)match(input,12,FOLLOW_12_in_parse_baserequirements_Comment3365); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = baserequirements.BaserequirementsFactory.eINSTANCE.createComment();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_4_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[337]);
            	}

            a1=(Token)match(input,50,FOLLOW_50_in_parse_baserequirements_Comment3379); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = baserequirements.BaserequirementsFactory.eINSTANCE.createComment();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_4_0_0_1, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[338]);
            	}

            // BaseRequirements.g:2805:2: (a2= 'subject' a3= ':' (a4= QUOTED_34_34 ) ( (a5= 'body' a6= ':' (a7= QUOTED_34_34 ) ) )? ( (a8= 'author' a9= ':' (a10= QUOTED_34_34 ) ) )? ( (a11= 'created' a12= ':' (a13= TEXT ) ) )? ( (a14= 'children' a15= ':' (a16_0= parse_baserequirements_Comment ) ) )* )
            // BaseRequirements.g:2806:3: a2= 'subject' a3= ':' (a4= QUOTED_34_34 ) ( (a5= 'body' a6= ':' (a7= QUOTED_34_34 ) ) )? ( (a8= 'author' a9= ':' (a10= QUOTED_34_34 ) ) )? ( (a11= 'created' a12= ':' (a13= TEXT ) ) )? ( (a14= 'children' a15= ':' (a16_0= parse_baserequirements_Comment ) ) )*
            {
            a2=(Token)match(input,46,FOLLOW_46_in_parse_baserequirements_Comment3397); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (element == null) {
            				element = baserequirements.BaserequirementsFactory.eINSTANCE.createComment();
            				startIncompleteElement(element);
            			}
            			collectHiddenTokens(element);
            			retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_4_0_0_2_0_0_0, null, true);
            			copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
            		}

            if ( state.backtracking==0 ) {
            			// expected elements (follow set)
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[339]);
            		}

            a3=(Token)match(input,9,FOLLOW_9_in_parse_baserequirements_Comment3414); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (element == null) {
            				element = baserequirements.BaserequirementsFactory.eINSTANCE.createComment();
            				startIncompleteElement(element);
            			}
            			collectHiddenTokens(element);
            			retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_4_0_0_2_0_0_1, null, true);
            			copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
            		}

            if ( state.backtracking==0 ) {
            			// expected elements (follow set)
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[340]);
            		}

            // BaseRequirements.g:2834:3: (a4= QUOTED_34_34 )
            // BaseRequirements.g:2835:4: a4= QUOTED_34_34
            {
            a4=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_baserequirements_Comment3436); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            				if (terminateParsing) {
            					throw new baserequirements.resource.baseRequirements.mopp.BaseRequirementsTerminateParsingException();
            				}
            				if (element == null) {
            					element = baserequirements.BaserequirementsFactory.eINSTANCE.createComment();
            					startIncompleteElement(element);
            				}
            				if (a4 != null) {
            					baserequirements.resource.baseRequirements.IBaseRequirementsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
            					tokenResolver.setOptions(getOptions());
            					baserequirements.resource.baseRequirements.IBaseRequirementsTokenResolveResult result = getFreshTokenResolveResult();
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
            					retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_4_0_0_2_0_0_2, resolved, true);
            					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a4, element);
            				}
            			}

            }


            if ( state.backtracking==0 ) {
            			// expected elements (follow set)
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[341]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[342]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[343]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[344]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[345]);
            		}

            // BaseRequirements.g:2874:3: ( (a5= 'body' a6= ':' (a7= QUOTED_34_34 ) ) )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==29) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // BaseRequirements.g:2875:4: (a5= 'body' a6= ':' (a7= QUOTED_34_34 ) )
                    {
                    // BaseRequirements.g:2875:4: (a5= 'body' a6= ':' (a7= QUOTED_34_34 ) )
                    // BaseRequirements.g:2876:5: a5= 'body' a6= ':' (a7= QUOTED_34_34 )
                    {
                    a5=(Token)match(input,29,FOLLOW_29_in_parse_baserequirements_Comment3474); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    					if (element == null) {
                    						element = baserequirements.BaserequirementsFactory.eINSTANCE.createComment();
                    						startIncompleteElement(element);
                    					}
                    					collectHiddenTokens(element);
                    					retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_4_0_0_2_0_0_3_0_0_0, null, true);
                    					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
                    				}

                    if ( state.backtracking==0 ) {
                    					// expected elements (follow set)
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[346]);
                    				}

                    a6=(Token)match(input,9,FOLLOW_9_in_parse_baserequirements_Comment3497); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    					if (element == null) {
                    						element = baserequirements.BaserequirementsFactory.eINSTANCE.createComment();
                    						startIncompleteElement(element);
                    					}
                    					collectHiddenTokens(element);
                    					retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_4_0_0_2_0_0_3_0_0_1, null, true);
                    					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
                    				}

                    if ( state.backtracking==0 ) {
                    					// expected elements (follow set)
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[347]);
                    				}

                    // BaseRequirements.g:2904:5: (a7= QUOTED_34_34 )
                    // BaseRequirements.g:2905:6: a7= QUOTED_34_34
                    {
                    a7=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_baserequirements_Comment3527); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    						if (terminateParsing) {
                    							throw new baserequirements.resource.baseRequirements.mopp.BaseRequirementsTerminateParsingException();
                    						}
                    						if (element == null) {
                    							element = baserequirements.BaserequirementsFactory.eINSTANCE.createComment();
                    							startIncompleteElement(element);
                    						}
                    						if (a7 != null) {
                    							baserequirements.resource.baseRequirements.IBaseRequirementsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
                    							tokenResolver.setOptions(getOptions());
                    							baserequirements.resource.baseRequirements.IBaseRequirementsTokenResolveResult result = getFreshTokenResolveResult();
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
                    							retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_4_0_0_2_0_0_3_0_0_2, resolved, true);
                    							copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a7, element);
                    						}
                    					}

                    }


                    if ( state.backtracking==0 ) {
                    					// expected elements (follow set)
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[348]);
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[349]);
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[350]);
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[351]);
                    				}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            			// expected elements (follow set)
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[352]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[353]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[354]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[355]);
            		}

            // BaseRequirements.g:2953:3: ( (a8= 'author' a9= ':' (a10= QUOTED_34_34 ) ) )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==28) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // BaseRequirements.g:2954:4: (a8= 'author' a9= ':' (a10= QUOTED_34_34 ) )
                    {
                    // BaseRequirements.g:2954:4: (a8= 'author' a9= ':' (a10= QUOTED_34_34 ) )
                    // BaseRequirements.g:2955:5: a8= 'author' a9= ':' (a10= QUOTED_34_34 )
                    {
                    a8=(Token)match(input,28,FOLLOW_28_in_parse_baserequirements_Comment3595); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    					if (element == null) {
                    						element = baserequirements.BaserequirementsFactory.eINSTANCE.createComment();
                    						startIncompleteElement(element);
                    					}
                    					collectHiddenTokens(element);
                    					retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_4_0_0_2_0_0_4_0_0_0, null, true);
                    					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a8, element);
                    				}

                    if ( state.backtracking==0 ) {
                    					// expected elements (follow set)
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[356]);
                    				}

                    a9=(Token)match(input,9,FOLLOW_9_in_parse_baserequirements_Comment3618); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    					if (element == null) {
                    						element = baserequirements.BaserequirementsFactory.eINSTANCE.createComment();
                    						startIncompleteElement(element);
                    					}
                    					collectHiddenTokens(element);
                    					retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_4_0_0_2_0_0_4_0_0_1, null, true);
                    					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a9, element);
                    				}

                    if ( state.backtracking==0 ) {
                    					// expected elements (follow set)
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[357]);
                    				}

                    // BaseRequirements.g:2983:5: (a10= QUOTED_34_34 )
                    // BaseRequirements.g:2984:6: a10= QUOTED_34_34
                    {
                    a10=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_baserequirements_Comment3648); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    						if (terminateParsing) {
                    							throw new baserequirements.resource.baseRequirements.mopp.BaseRequirementsTerminateParsingException();
                    						}
                    						if (element == null) {
                    							element = baserequirements.BaserequirementsFactory.eINSTANCE.createComment();
                    							startIncompleteElement(element);
                    						}
                    						if (a10 != null) {
                    							baserequirements.resource.baseRequirements.IBaseRequirementsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
                    							tokenResolver.setOptions(getOptions());
                    							baserequirements.resource.baseRequirements.IBaseRequirementsTokenResolveResult result = getFreshTokenResolveResult();
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
                    							retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_4_0_0_2_0_0_4_0_0_2, resolved, true);
                    							copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a10, element);
                    						}
                    					}

                    }


                    if ( state.backtracking==0 ) {
                    					// expected elements (follow set)
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[358]);
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[359]);
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[360]);
                    				}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            			// expected elements (follow set)
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[361]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[362]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[363]);
            		}

            // BaseRequirements.g:3030:3: ( (a11= 'created' a12= ':' (a13= TEXT ) ) )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==32) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // BaseRequirements.g:3031:4: (a11= 'created' a12= ':' (a13= TEXT ) )
                    {
                    // BaseRequirements.g:3031:4: (a11= 'created' a12= ':' (a13= TEXT ) )
                    // BaseRequirements.g:3032:5: a11= 'created' a12= ':' (a13= TEXT )
                    {
                    a11=(Token)match(input,32,FOLLOW_32_in_parse_baserequirements_Comment3716); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    					if (element == null) {
                    						element = baserequirements.BaserequirementsFactory.eINSTANCE.createComment();
                    						startIncompleteElement(element);
                    					}
                    					collectHiddenTokens(element);
                    					retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_4_0_0_2_0_0_5_0_0_0, null, true);
                    					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a11, element);
                    				}

                    if ( state.backtracking==0 ) {
                    					// expected elements (follow set)
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[364]);
                    				}

                    a12=(Token)match(input,9,FOLLOW_9_in_parse_baserequirements_Comment3739); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    					if (element == null) {
                    						element = baserequirements.BaserequirementsFactory.eINSTANCE.createComment();
                    						startIncompleteElement(element);
                    					}
                    					collectHiddenTokens(element);
                    					retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_4_0_0_2_0_0_5_0_0_1, null, true);
                    					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a12, element);
                    				}

                    if ( state.backtracking==0 ) {
                    					// expected elements (follow set)
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[365]);
                    				}

                    // BaseRequirements.g:3060:5: (a13= TEXT )
                    // BaseRequirements.g:3061:6: a13= TEXT
                    {
                    a13=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_baserequirements_Comment3769); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    						if (terminateParsing) {
                    							throw new baserequirements.resource.baseRequirements.mopp.BaseRequirementsTerminateParsingException();
                    						}
                    						if (element == null) {
                    							element = baserequirements.BaserequirementsFactory.eINSTANCE.createComment();
                    							startIncompleteElement(element);
                    						}
                    						if (a13 != null) {
                    							baserequirements.resource.baseRequirements.IBaseRequirementsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
                    							tokenResolver.setOptions(getOptions());
                    							baserequirements.resource.baseRequirements.IBaseRequirementsTokenResolveResult result = getFreshTokenResolveResult();
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
                    							retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_4_0_0_2_0_0_5_0_0_2, resolved, true);
                    							copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a13, element);
                    						}
                    					}

                    }


                    if ( state.backtracking==0 ) {
                    					// expected elements (follow set)
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[366]);
                    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[367]);
                    				}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            			// expected elements (follow set)
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[368]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[369]);
            		}

            // BaseRequirements.g:3105:3: ( (a14= 'children' a15= ':' (a16_0= parse_baserequirements_Comment ) ) )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==30) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // BaseRequirements.g:3106:4: (a14= 'children' a15= ':' (a16_0= parse_baserequirements_Comment ) )
            	    {
            	    // BaseRequirements.g:3106:4: (a14= 'children' a15= ':' (a16_0= parse_baserequirements_Comment ) )
            	    // BaseRequirements.g:3107:5: a14= 'children' a15= ':' (a16_0= parse_baserequirements_Comment )
            	    {
            	    a14=(Token)match(input,30,FOLLOW_30_in_parse_baserequirements_Comment3837); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    					if (element == null) {
            	    						element = baserequirements.BaserequirementsFactory.eINSTANCE.createComment();
            	    						startIncompleteElement(element);
            	    					}
            	    					collectHiddenTokens(element);
            	    					retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_4_0_0_2_0_0_6_0_0_0, null, true);
            	    					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a14, element);
            	    				}

            	    if ( state.backtracking==0 ) {
            	    					// expected elements (follow set)
            	    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[370]);
            	    				}

            	    a15=(Token)match(input,9,FOLLOW_9_in_parse_baserequirements_Comment3860); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    					if (element == null) {
            	    						element = baserequirements.BaserequirementsFactory.eINSTANCE.createComment();
            	    						startIncompleteElement(element);
            	    					}
            	    					collectHiddenTokens(element);
            	    					retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_4_0_0_2_0_0_6_0_0_1, null, true);
            	    					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a15, element);
            	    				}

            	    if ( state.backtracking==0 ) {
            	    					// expected elements (follow set)
            	    					addExpectedElement(baserequirements.BaserequirementsPackage.eINSTANCE.getComment(), baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[371]);
            	    				}

            	    // BaseRequirements.g:3135:5: (a16_0= parse_baserequirements_Comment )
            	    // BaseRequirements.g:3136:6: a16_0= parse_baserequirements_Comment
            	    {
            	    pushFollow(FOLLOW_parse_baserequirements_Comment_in_parse_baserequirements_Comment3890);
            	    a16_0=parse_baserequirements_Comment();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    						if (terminateParsing) {
            	    							throw new baserequirements.resource.baseRequirements.mopp.BaseRequirementsTerminateParsingException();
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
            	    							retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_4_0_0_2_0_0_6_0_0_2, a16_0, true);
            	    							copyLocalizationInfos(a16_0, element);
            	    						}
            	    					}

            	    }


            	    if ( state.backtracking==0 ) {
            	    					// expected elements (follow set)
            	    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[372]);
            	    					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[373]);
            	    				}

            	    }


            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            			// expected elements (follow set)
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[374]);
            			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[375]);
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[376]);
            	}

            a17=(Token)match(input,51,FOLLOW_51_in_parse_baserequirements_Comment3948); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = baserequirements.BaserequirementsFactory.eINSTANCE.createComment();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_4_0_0_3, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a17, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[377]);
            		addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[378]);
            		addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[379]);
            		addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[380]);
            		addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[381]);
            		addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[382]);
            		addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[383]);
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
    public static final BitSet FOLLOW_20_in_parse_baserequirements_Model115 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_50_in_parse_baserequirements_Model129 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_parse_baserequirements_Model147 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_parse_baserequirements_Model164 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_baserequirements_Model186 = new BitSet(new long[]{0x0008000800000000L});
    public static final BitSet FOLLOW_35_in_parse_baserequirements_Model224 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_parse_baserequirements_Model247 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_parse_baserequirements_RequirementGroup_in_parse_baserequirements_Model277 = new BitSet(new long[]{0x0008000800000000L});
    public static final BitSet FOLLOW_51_in_parse_baserequirements_Model335 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_parse_baserequirements_RequirementGroup364 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_50_in_parse_baserequirements_RequirementGroup378 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_parse_baserequirements_RequirementGroup396 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_parse_baserequirements_RequirementGroup413 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_baserequirements_RequirementGroup435 = new BitSet(new long[]{0x0008051440000000L});
    public static final BitSet FOLLOW_34_in_parse_baserequirements_RequirementGroup473 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_parse_baserequirements_RequirementGroup496 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_baserequirements_RequirementGroup526 = new BitSet(new long[]{0x0008051040000000L});
    public static final BitSet FOLLOW_36_in_parse_baserequirements_RequirementGroup594 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_parse_baserequirements_RequirementGroup617 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_baserequirements_RequirementGroup647 = new BitSet(new long[]{0x0008050040000000L});
    public static final BitSet FOLLOW_30_in_parse_baserequirements_RequirementGroup715 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_parse_baserequirements_RequirementGroup738 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_parse_baserequirements_RequirementGroup_in_parse_baserequirements_RequirementGroup768 = new BitSet(new long[]{0x0008050040000000L});
    public static final BitSet FOLLOW_40_in_parse_baserequirements_RequirementGroup830 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_parse_baserequirements_RequirementGroup853 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_TEXT_in_parse_baserequirements_RequirementGroup883 = new BitSet(new long[]{0x0008040000000000L});
    public static final BitSet FOLLOW_42_in_parse_baserequirements_RequirementGroup951 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_parse_baserequirements_RequirementGroup974 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_parse_baserequirements_Requirement_in_parse_baserequirements_RequirementGroup1004 = new BitSet(new long[]{0x0008040000000000L});
    public static final BitSet FOLLOW_51_in_parse_baserequirements_RequirementGroup1062 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_parse_baserequirements_Requirement1091 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_50_in_parse_baserequirements_Requirement1105 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_parse_baserequirements_Requirement1123 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_parse_baserequirements_Requirement1140 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_baserequirements_Requirement1162 = new BitSet(new long[]{0x000B2B17D0000000L});
    public static final BitSet FOLLOW_34_in_parse_baserequirements_Requirement1200 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_parse_baserequirements_Requirement1223 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_baserequirements_Requirement1253 = new BitSet(new long[]{0x000B2B13D0000000L});
    public static final BitSet FOLLOW_48_in_parse_baserequirements_Requirement1321 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_parse_baserequirements_Requirement1344 = new BitSet(new long[]{0x0000000000402000L});
    public static final BitSet FOLLOW_13_in_parse_baserequirements_Requirement1382 = new BitSet(new long[]{0x000A2B13D0000000L});
    public static final BitSet FOLLOW_22_in_parse_baserequirements_Requirement1403 = new BitSet(new long[]{0x000A2B13D0000000L});
    public static final BitSet FOLLOW_41_in_parse_baserequirements_Requirement1468 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_parse_baserequirements_Requirement1491 = new BitSet(new long[]{0x00000000000C4000L});
    public static final BitSet FOLLOW_14_in_parse_baserequirements_Requirement1529 = new BitSet(new long[]{0x000A2913D0000000L});
    public static final BitSet FOLLOW_19_in_parse_baserequirements_Requirement1550 = new BitSet(new long[]{0x000A2913D0000000L});
    public static final BitSet FOLLOW_18_in_parse_baserequirements_Requirement1571 = new BitSet(new long[]{0x000A2913D0000000L});
    public static final BitSet FOLLOW_28_in_parse_baserequirements_Requirement1636 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_parse_baserequirements_Requirement1659 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_baserequirements_Requirement1689 = new BitSet(new long[]{0x000A2913C0000000L});
    public static final BitSet FOLLOW_32_in_parse_baserequirements_Requirement1757 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_parse_baserequirements_Requirement1780 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_TEXT_in_parse_baserequirements_Requirement1810 = new BitSet(new long[]{0x000A2912C0000000L});
    public static final BitSet FOLLOW_36_in_parse_baserequirements_Requirement1878 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_parse_baserequirements_Requirement1901 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_baserequirements_Requirement1931 = new BitSet(new long[]{0x000A2902C0000000L});
    public static final BitSet FOLLOW_45_in_parse_baserequirements_Requirement1999 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_parse_baserequirements_Requirement2022 = new BitSet(new long[]{0x0000000001A00800L});
    public static final BitSet FOLLOW_21_in_parse_baserequirements_Requirement2060 = new BitSet(new long[]{0x000A0902C0000000L});
    public static final BitSet FOLLOW_24_in_parse_baserequirements_Requirement2081 = new BitSet(new long[]{0x000A0902C0000000L});
    public static final BitSet FOLLOW_11_in_parse_baserequirements_Requirement2102 = new BitSet(new long[]{0x000A0902C0000000L});
    public static final BitSet FOLLOW_23_in_parse_baserequirements_Requirement2123 = new BitSet(new long[]{0x000A0902C0000000L});
    public static final BitSet FOLLOW_43_in_parse_baserequirements_Requirement2188 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_parse_baserequirements_Requirement2211 = new BitSet(new long[]{0x0000000000038400L});
    public static final BitSet FOLLOW_16_in_parse_baserequirements_Requirement2249 = new BitSet(new long[]{0x000A0102C0000000L});
    public static final BitSet FOLLOW_10_in_parse_baserequirements_Requirement2270 = new BitSet(new long[]{0x000A0102C0000000L});
    public static final BitSet FOLLOW_15_in_parse_baserequirements_Requirement2291 = new BitSet(new long[]{0x000A0102C0000000L});
    public static final BitSet FOLLOW_17_in_parse_baserequirements_Requirement2312 = new BitSet(new long[]{0x000A0102C0000000L});
    public static final BitSet FOLLOW_49_in_parse_baserequirements_Requirement2377 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_parse_baserequirements_Requirement2400 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_parse_baserequirements_Version_in_parse_baserequirements_Requirement2430 = new BitSet(new long[]{0x00080102C0000000L});
    public static final BitSet FOLLOW_31_in_parse_baserequirements_Requirement2492 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_parse_baserequirements_Requirement2515 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_parse_baserequirements_Comment_in_parse_baserequirements_Requirement2545 = new BitSet(new long[]{0x00080102C0000000L});
    public static final BitSet FOLLOW_33_in_parse_baserequirements_Requirement2607 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_parse_baserequirements_Requirement2630 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_TEXT_in_parse_baserequirements_Requirement2660 = new BitSet(new long[]{0x0008010240000000L});
    public static final BitSet FOLLOW_40_in_parse_baserequirements_Requirement2728 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_parse_baserequirements_Requirement2751 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_TEXT_in_parse_baserequirements_Requirement2781 = new BitSet(new long[]{0x0008000040000000L});
    public static final BitSet FOLLOW_30_in_parse_baserequirements_Requirement2849 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_parse_baserequirements_Requirement2872 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_parse_baserequirements_Requirement_in_parse_baserequirements_Requirement2902 = new BitSet(new long[]{0x0008000040000000L});
    public static final BitSet FOLLOW_51_in_parse_baserequirements_Requirement2960 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_parse_baserequirements_Version2989 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_50_in_parse_baserequirements_Version3003 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_parse_baserequirements_Version3021 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_parse_baserequirements_Version3038 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_TEXT_in_parse_baserequirements_Version3060 = new BitSet(new long[]{0x0008104000000000L});
    public static final BitSet FOLLOW_38_in_parse_baserequirements_Version3098 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_parse_baserequirements_Version3121 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_TEXT_in_parse_baserequirements_Version3151 = new BitSet(new long[]{0x0008100000000000L});
    public static final BitSet FOLLOW_44_in_parse_baserequirements_Version3219 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_parse_baserequirements_Version3242 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_TEXT_in_parse_baserequirements_Version3272 = new BitSet(new long[]{0x0008100000000000L});
    public static final BitSet FOLLOW_51_in_parse_baserequirements_Version3336 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_parse_baserequirements_Comment3365 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_50_in_parse_baserequirements_Comment3379 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_46_in_parse_baserequirements_Comment3397 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_parse_baserequirements_Comment3414 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_baserequirements_Comment3436 = new BitSet(new long[]{0x0008000170000000L});
    public static final BitSet FOLLOW_29_in_parse_baserequirements_Comment3474 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_parse_baserequirements_Comment3497 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_baserequirements_Comment3527 = new BitSet(new long[]{0x0008000150000000L});
    public static final BitSet FOLLOW_28_in_parse_baserequirements_Comment3595 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_parse_baserequirements_Comment3618 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_baserequirements_Comment3648 = new BitSet(new long[]{0x0008000140000000L});
    public static final BitSet FOLLOW_32_in_parse_baserequirements_Comment3716 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_parse_baserequirements_Comment3739 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_TEXT_in_parse_baserequirements_Comment3769 = new BitSet(new long[]{0x0008000040000000L});
    public static final BitSet FOLLOW_30_in_parse_baserequirements_Comment3837 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_parse_baserequirements_Comment3860 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_parse_baserequirements_Comment_in_parse_baserequirements_Comment3890 = new BitSet(new long[]{0x0008000040000000L});
    public static final BitSet FOLLOW_51_in_parse_baserequirements_Comment3948 = new BitSet(new long[]{0x0000000000000002L});

}