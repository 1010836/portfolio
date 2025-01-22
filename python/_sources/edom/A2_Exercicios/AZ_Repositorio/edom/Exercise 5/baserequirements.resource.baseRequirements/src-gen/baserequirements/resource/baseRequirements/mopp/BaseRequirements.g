grammar BaseRequirements;

options {
	superClass = BaseRequirementsANTLRParserBase;
	backtrack = true;
	memoize = true;
}

@lexer::header {
	package baserequirements.resource.baseRequirements.mopp;
}

@lexer::members {
	public java.util.List<org.antlr.runtime3_4_0.RecognitionException> lexerExceptions  = new java.util.ArrayList<org.antlr.runtime3_4_0.RecognitionException>();
	public java.util.List<Integer> lexerExceptionsPosition = new java.util.ArrayList<Integer>();
	
	public void reportError(org.antlr.runtime3_4_0.RecognitionException e) {
		lexerExceptions.add(e);
		lexerExceptionsPosition.add(((org.antlr.runtime3_4_0.ANTLRStringStream) input).index());
	}
}
@header{
	package baserequirements.resource.baseRequirements.mopp;
}

@members{
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
	
}

start returns [ org.eclipse.emf.ecore.EObject element = null]
:
	{
		// follow set for start rule(s)
		addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[0]);
		expectedElementsIndexOfLastCompleteElement = 0;
	}
	(
		c0 = parse_baserequirements_Model{ element = c0; }
	)
	EOF	{
		retrieveLayoutInformation(element, null, null, false);
	}
	
;

parse_baserequirements_Model returns [baserequirements.Model element = null]
@init{
}
:
	a0 = 'Model' {
		if (element == null) {
			element = baserequirements.BaserequirementsFactory.eINSTANCE.createModel();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_0_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[1]);
	}
	
	a1 = '{' {
		if (element == null) {
			element = baserequirements.BaserequirementsFactory.eINSTANCE.createModel();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_0_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[2]);
	}
	
	(
		a2 = 'title' {
			if (element == null) {
				element = baserequirements.BaserequirementsFactory.eINSTANCE.createModel();
				startIncompleteElement(element);
			}
			collectHiddenTokens(element);
			retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_0_0_0_2_0_0_0, null, true);
			copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
		}
		{
			// expected elements (follow set)
			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[3]);
		}
		
		a3 = ':' {
			if (element == null) {
				element = baserequirements.BaserequirementsFactory.eINSTANCE.createModel();
				startIncompleteElement(element);
			}
			collectHiddenTokens(element);
			retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_0_0_0_2_0_0_1, null, true);
			copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
		}
		{
			// expected elements (follow set)
			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[4]);
		}
		
		(
			a4 = QUOTED_34_34			
			{
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
		)
		{
			// expected elements (follow set)
			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[5]);
			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[6]);
		}
		
		(
			(
				a5 = 'groups' {
					if (element == null) {
						element = baserequirements.BaserequirementsFactory.eINSTANCE.createModel();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_0_0_0_2_0_0_3_0_0_0, null, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[7]);
				}
				
				a6 = ':' {
					if (element == null) {
						element = baserequirements.BaserequirementsFactory.eINSTANCE.createModel();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_0_0_0_2_0_0_3_0_0_1, null, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(baserequirements.BaserequirementsPackage.eINSTANCE.getModel(), baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[8]);
				}
				
				(
					a7_0 = parse_baserequirements_RequirementGroup					{
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
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[9]);
					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[10]);
				}
				
			)
			
		)*		{
			// expected elements (follow set)
			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[11]);
			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[12]);
		}
		
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[13]);
	}
	
	a8 = '}' {
		if (element == null) {
			element = baserequirements.BaserequirementsFactory.eINSTANCE.createModel();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_0_0_0_3, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a8, element);
	}
	{
		// expected elements (follow set)
	}
	
;

parse_baserequirements_RequirementGroup returns [baserequirements.RequirementGroup element = null]
@init{
}
:
	a0 = 'RequirementGroup' {
		if (element == null) {
			element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirementGroup();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_1_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[14]);
	}
	
	a1 = '{' {
		if (element == null) {
			element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirementGroup();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_1_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[15]);
	}
	
	(
		a2 = 'name' {
			if (element == null) {
				element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirementGroup();
				startIncompleteElement(element);
			}
			collectHiddenTokens(element);
			retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_1_0_0_2_0_0_0, null, true);
			copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
		}
		{
			// expected elements (follow set)
			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[16]);
		}
		
		a3 = ':' {
			if (element == null) {
				element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirementGroup();
				startIncompleteElement(element);
			}
			collectHiddenTokens(element);
			retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_1_0_0_2_0_0_1, null, true);
			copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
		}
		{
			// expected elements (follow set)
			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[17]);
		}
		
		(
			a4 = QUOTED_34_34			
			{
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
		)
		{
			// expected elements (follow set)
			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[18]);
			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[19]);
			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[20]);
			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[21]);
			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[22]);
			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[23]);
		}
		
		(
			(
				a5 = 'description' {
					if (element == null) {
						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirementGroup();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_1_0_0_2_0_0_3_0_0_0, null, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[24]);
				}
				
				a6 = ':' {
					if (element == null) {
						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirementGroup();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_1_0_0_2_0_0_3_0_0_1, null, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[25]);
				}
				
				(
					a7 = QUOTED_34_34					
					{
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
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[26]);
					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[27]);
					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[28]);
					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[29]);
					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[30]);
				}
				
			)
			
		)?		{
			// expected elements (follow set)
			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[31]);
			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[32]);
			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[33]);
			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[34]);
			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[35]);
		}
		
		(
			(
				a8 = 'id' {
					if (element == null) {
						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirementGroup();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_1_0_0_2_0_0_4_0_0_0, null, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a8, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[36]);
				}
				
				a9 = ':' {
					if (element == null) {
						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirementGroup();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_1_0_0_2_0_0_4_0_0_1, null, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a9, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[37]);
				}
				
				(
					a10 = QUOTED_34_34					
					{
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
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[38]);
					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[39]);
					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[40]);
					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[41]);
				}
				
			)
			
		)?		{
			// expected elements (follow set)
			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[42]);
			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[43]);
			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[44]);
			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[45]);
		}
		
		(
			(
				a11 = 'children' {
					if (element == null) {
						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirementGroup();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_1_0_0_2_0_0_5_0_0_0, null, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a11, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[46]);
				}
				
				a12 = ':' {
					if (element == null) {
						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirementGroup();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_1_0_0_2_0_0_5_0_0_1, null, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a12, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(baserequirements.BaserequirementsPackage.eINSTANCE.getRequirementGroup(), baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[47]);
				}
				
				(
					a13_0 = parse_baserequirements_RequirementGroup					{
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
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[48]);
					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[49]);
					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[50]);
					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[51]);
				}
				
			)
			
		)*		{
			// expected elements (follow set)
			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[52]);
			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[53]);
			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[54]);
			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[55]);
		}
		
		(
			(
				a14 = 'parent' {
					if (element == null) {
						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirementGroup();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_1_0_0_2_0_0_6_0_0_0, null, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a14, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[56]);
				}
				
				a15 = ':' {
					if (element == null) {
						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirementGroup();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_1_0_0_2_0_0_6_0_0_1, null, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a15, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[57]);
				}
				
				(
					a16 = TEXT					
					{
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
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[58]);
					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[59]);
				}
				
			)
			
		)?		{
			// expected elements (follow set)
			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[60]);
			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[61]);
		}
		
		(
			(
				a17 = 'requirements' {
					if (element == null) {
						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirementGroup();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_1_0_0_2_0_0_7_0_0_0, null, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a17, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[62]);
				}
				
				a18 = ':' {
					if (element == null) {
						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirementGroup();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_1_0_0_2_0_0_7_0_0_1, null, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a18, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(baserequirements.BaserequirementsPackage.eINSTANCE.getRequirementGroup(), baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[63]);
				}
				
				(
					a19_0 = parse_baserequirements_Requirement					{
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
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[64]);
					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[65]);
				}
				
			)
			
		)*		{
			// expected elements (follow set)
			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[66]);
			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[67]);
		}
		
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[68]);
	}
	
	a20 = '}' {
		if (element == null) {
			element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirementGroup();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_1_0_0_3, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a20, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[69]);
		addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[70]);
		addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[71]);
		addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[72]);
		addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[73]);
		addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[74]);
	}
	
;

parse_baserequirements_Requirement returns [baserequirements.Requirement element = null]
@init{
}
:
	a0 = 'Requirement' {
		if (element == null) {
			element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[75]);
	}
	
	a1 = '{' {
		if (element == null) {
			element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[76]);
	}
	
	(
		a2 = 'title' {
			if (element == null) {
				element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
				startIncompleteElement(element);
			}
			collectHiddenTokens(element);
			retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_0, null, true);
			copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
		}
		{
			// expected elements (follow set)
			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[77]);
		}
		
		a3 = ':' {
			if (element == null) {
				element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
				startIncompleteElement(element);
			}
			collectHiddenTokens(element);
			retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_1, null, true);
			copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
		}
		{
			// expected elements (follow set)
			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[78]);
		}
		
		(
			a4 = QUOTED_34_34			
			{
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
		)
		{
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
		
		(
			(
				a5 = 'description' {
					if (element == null) {
						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_3_0_0_0, null, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[93]);
				}
				
				a6 = ':' {
					if (element == null) {
						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_3_0_0_1, null, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[94]);
				}
				
				(
					a7 = QUOTED_34_34					
					{
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
				)
				{
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
				
			)
			
		)?		{
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
		
		(
			(
				a8 = 'type' {
					if (element == null) {
						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_4_0_0_0, null, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a8, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[121]);
				}
				
				a9 = ':' {
					if (element == null) {
						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_4_0_0_1, null, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a9, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[122]);
				}
				
				(
					(
						a10 = 'FUNCTIONAL' {
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
						|						a11 = 'NONFUNCTIONAL' {
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
					)
				)
				{
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
				
			)
			
		)?		{
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
		
		(
			(
				a14 = 'priority' {
					if (element == null) {
						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_5_0_0_0, null, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a14, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[147]);
				}
				
				a15 = ':' {
					if (element == null) {
						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_5_0_0_1, null, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a15, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[148]);
				}
				
				(
					(
						a16 = 'HIGH' {
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
						|						a17 = 'MEDIUM' {
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
						|						a18 = 'LOW' {
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
					)
				)
				{
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
				
			)
			
		)?		{
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
		
		(
			(
				a21 = 'author' {
					if (element == null) {
						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_6_0_0_0, null, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a21, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[171]);
				}
				
				a22 = ':' {
					if (element == null) {
						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_6_0_0_1, null, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a22, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[172]);
				}
				
				(
					a23 = QUOTED_34_34					
					{
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
				)
				{
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
				
			)
			
		)?		{
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
		
		(
			(
				a24 = 'created' {
					if (element == null) {
						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_7_0_0_0, null, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a24, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[193]);
				}
				
				a25 = ':' {
					if (element == null) {
						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_7_0_0_1, null, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a25, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[194]);
				}
				
				(
					a26 = TEXT					
					{
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
				)
				{
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
				
			)
			
		)?		{
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
		
		(
			(
				a27 = 'id' {
					if (element == null) {
						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_8_0_0_0, null, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a27, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[213]);
				}
				
				a28 = ':' {
					if (element == null) {
						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_8_0_0_1, null, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a28, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[214]);
				}
				
				(
					a29 = QUOTED_34_34					
					{
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
				)
				{
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
				
			)
			
		)?		{
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
		
		(
			(
				a30 = 'state' {
					if (element == null) {
						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_9_0_0_0, null, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a30, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[231]);
				}
				
				a31 = ':' {
					if (element == null) {
						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_9_0_0_1, null, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a31, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[232]);
				}
				
				(
					(
						a32 = 'NEW' {
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
						|						a33 = 'REVIEWED' {
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
						|						a34 = 'APPROVED' {
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
						|						a35 = 'RESOLVED' {
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
					)
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[233]);
					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[234]);
					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[235]);
					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[236]);
					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[237]);
					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[238]);
					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[239]);
				}
				
			)
			
		)?		{
			// expected elements (follow set)
			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[240]);
			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[241]);
			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[242]);
			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[243]);
			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[244]);
			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[245]);
			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[246]);
		}
		
		(
			(
				a38 = 'resolution' {
					if (element == null) {
						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_10_0_0_0, null, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a38, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[247]);
				}
				
				a39 = ':' {
					if (element == null) {
						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_10_0_0_1, null, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a39, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[248]);
				}
				
				(
					(
						a40 = 'INVALID' {
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
						|						a41 = 'ACCEPTED' {
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
						|						a42 = 'IMPLEMENTED' {
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
						|						a43 = 'LATER' {
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
					)
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[249]);
					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[250]);
					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[251]);
					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[252]);
					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[253]);
					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[254]);
				}
				
			)
			
		)?		{
			// expected elements (follow set)
			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[255]);
			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[256]);
			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[257]);
			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[258]);
			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[259]);
			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[260]);
		}
		
		(
			(
				a46 = 'version' {
					if (element == null) {
						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_11_0_0_0, null, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a46, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[261]);
				}
				
				a47 = ':' {
					if (element == null) {
						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_11_0_0_1, null, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a47, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(baserequirements.BaserequirementsPackage.eINSTANCE.getRequirement(), baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[262]);
				}
				
				(
					a48_0 = parse_baserequirements_Version					{
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
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[263]);
					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[264]);
					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[265]);
					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[266]);
					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[267]);
				}
				
			)
			
		)?		{
			// expected elements (follow set)
			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[268]);
			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[269]);
			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[270]);
			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[271]);
			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[272]);
		}
		
		(
			(
				a49 = 'comments' {
					if (element == null) {
						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_12_0_0_0, null, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a49, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[273]);
				}
				
				a50 = ':' {
					if (element == null) {
						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_12_0_0_1, null, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a50, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(baserequirements.BaserequirementsPackage.eINSTANCE.getRequirement(), baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[274]);
				}
				
				(
					a51_0 = parse_baserequirements_Comment					{
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
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[275]);
					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[276]);
					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[277]);
					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[278]);
					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[279]);
				}
				
			)
			
		)*		{
			// expected elements (follow set)
			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[280]);
			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[281]);
			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[282]);
			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[283]);
			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[284]);
		}
		
		(
			(
				a52 = 'dependencies' {
					if (element == null) {
						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_13_0_0_0, null, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a52, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[285]);
				}
				
				a53 = ':' {
					if (element == null) {
						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_13_0_0_1, null, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a53, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[286]);
				}
				
				(
					a54 = TEXT					
					{
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
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[287]);
					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[288]);
					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[289]);
					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[290]);
				}
				
			)
			
		)*		{
			// expected elements (follow set)
			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[291]);
			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[292]);
			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[293]);
			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[294]);
		}
		
		(
			(
				a55 = 'parent' {
					if (element == null) {
						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_14_0_0_0, null, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a55, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[295]);
				}
				
				a56 = ':' {
					if (element == null) {
						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_14_0_0_1, null, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a56, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[296]);
				}
				
				(
					a57 = TEXT					
					{
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
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[297]);
					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[298]);
				}
				
			)
			
		)?		{
			// expected elements (follow set)
			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[299]);
			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[300]);
		}
		
		(
			(
				a58 = 'children' {
					if (element == null) {
						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_15_0_0_0, null, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a58, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[301]);
				}
				
				a59 = ':' {
					if (element == null) {
						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_15_0_0_1, null, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a59, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(baserequirements.BaserequirementsPackage.eINSTANCE.getRequirement(), baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[302]);
				}
				
				(
					a60_0 = parse_baserequirements_Requirement					{
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
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[303]);
					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[304]);
				}
				
			)
			
		)*		{
			// expected elements (follow set)
			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[305]);
			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[306]);
		}
		
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[307]);
	}
	
	a61 = '}' {
		if (element == null) {
			element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_3, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a61, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[308]);
		addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[309]);
		addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[310]);
		addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[311]);
	}
	
;

parse_baserequirements_Version returns [baserequirements.Version element = null]
@init{
}
:
	a0 = 'Version' {
		if (element == null) {
			element = baserequirements.BaserequirementsFactory.eINSTANCE.createVersion();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_3_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[312]);
	}
	
	a1 = '{' {
		if (element == null) {
			element = baserequirements.BaserequirementsFactory.eINSTANCE.createVersion();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_3_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[313]);
	}
	
	(
		a2 = 'major' {
			if (element == null) {
				element = baserequirements.BaserequirementsFactory.eINSTANCE.createVersion();
				startIncompleteElement(element);
			}
			collectHiddenTokens(element);
			retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_3_0_0_2_0_0_0, null, true);
			copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
		}
		{
			// expected elements (follow set)
			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[314]);
		}
		
		a3 = ':' {
			if (element == null) {
				element = baserequirements.BaserequirementsFactory.eINSTANCE.createVersion();
				startIncompleteElement(element);
			}
			collectHiddenTokens(element);
			retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_3_0_0_2_0_0_1, null, true);
			copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
		}
		{
			// expected elements (follow set)
			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[315]);
		}
		
		(
			a4 = TEXT			
			{
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
		)
		{
			// expected elements (follow set)
			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[316]);
			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[317]);
			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[318]);
		}
		
		(
			(
				a5 = 'minor' {
					if (element == null) {
						element = baserequirements.BaserequirementsFactory.eINSTANCE.createVersion();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_3_0_0_2_0_0_3_0_0_0, null, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[319]);
				}
				
				a6 = ':' {
					if (element == null) {
						element = baserequirements.BaserequirementsFactory.eINSTANCE.createVersion();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_3_0_0_2_0_0_3_0_0_1, null, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[320]);
				}
				
				(
					a7 = TEXT					
					{
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
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[321]);
					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[322]);
				}
				
			)
			
		)?		{
			// expected elements (follow set)
			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[323]);
			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[324]);
		}
		
		(
			(
				a8 = 'service' {
					if (element == null) {
						element = baserequirements.BaserequirementsFactory.eINSTANCE.createVersion();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_3_0_0_2_0_0_4_0_0_0, null, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a8, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[325]);
				}
				
				a9 = ':' {
					if (element == null) {
						element = baserequirements.BaserequirementsFactory.eINSTANCE.createVersion();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_3_0_0_2_0_0_4_0_0_1, null, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a9, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[326]);
				}
				
				(
					a10 = TEXT					
					{
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
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[327]);
					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[328]);
				}
				
			)
			
		)*		{
			// expected elements (follow set)
			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[329]);
			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[330]);
		}
		
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[331]);
	}
	
	a11 = '}' {
		if (element == null) {
			element = baserequirements.BaserequirementsFactory.eINSTANCE.createVersion();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_3_0_0_3, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a11, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[332]);
		addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[333]);
		addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[334]);
		addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[335]);
		addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[336]);
	}
	
;

parse_baserequirements_Comment returns [baserequirements.Comment element = null]
@init{
}
:
	a0 = 'Comment' {
		if (element == null) {
			element = baserequirements.BaserequirementsFactory.eINSTANCE.createComment();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_4_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[337]);
	}
	
	a1 = '{' {
		if (element == null) {
			element = baserequirements.BaserequirementsFactory.eINSTANCE.createComment();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_4_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[338]);
	}
	
	(
		a2 = 'subject' {
			if (element == null) {
				element = baserequirements.BaserequirementsFactory.eINSTANCE.createComment();
				startIncompleteElement(element);
			}
			collectHiddenTokens(element);
			retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_4_0_0_2_0_0_0, null, true);
			copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
		}
		{
			// expected elements (follow set)
			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[339]);
		}
		
		a3 = ':' {
			if (element == null) {
				element = baserequirements.BaserequirementsFactory.eINSTANCE.createComment();
				startIncompleteElement(element);
			}
			collectHiddenTokens(element);
			retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_4_0_0_2_0_0_1, null, true);
			copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
		}
		{
			// expected elements (follow set)
			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[340]);
		}
		
		(
			a4 = QUOTED_34_34			
			{
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
		)
		{
			// expected elements (follow set)
			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[341]);
			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[342]);
			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[343]);
			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[344]);
			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[345]);
		}
		
		(
			(
				a5 = 'body' {
					if (element == null) {
						element = baserequirements.BaserequirementsFactory.eINSTANCE.createComment();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_4_0_0_2_0_0_3_0_0_0, null, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[346]);
				}
				
				a6 = ':' {
					if (element == null) {
						element = baserequirements.BaserequirementsFactory.eINSTANCE.createComment();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_4_0_0_2_0_0_3_0_0_1, null, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[347]);
				}
				
				(
					a7 = QUOTED_34_34					
					{
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
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[348]);
					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[349]);
					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[350]);
					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[351]);
				}
				
			)
			
		)?		{
			// expected elements (follow set)
			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[352]);
			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[353]);
			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[354]);
			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[355]);
		}
		
		(
			(
				a8 = 'author' {
					if (element == null) {
						element = baserequirements.BaserequirementsFactory.eINSTANCE.createComment();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_4_0_0_2_0_0_4_0_0_0, null, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a8, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[356]);
				}
				
				a9 = ':' {
					if (element == null) {
						element = baserequirements.BaserequirementsFactory.eINSTANCE.createComment();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_4_0_0_2_0_0_4_0_0_1, null, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a9, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[357]);
				}
				
				(
					a10 = QUOTED_34_34					
					{
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
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[358]);
					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[359]);
					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[360]);
				}
				
			)
			
		)?		{
			// expected elements (follow set)
			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[361]);
			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[362]);
			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[363]);
		}
		
		(
			(
				a11 = 'created' {
					if (element == null) {
						element = baserequirements.BaserequirementsFactory.eINSTANCE.createComment();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_4_0_0_2_0_0_5_0_0_0, null, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a11, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[364]);
				}
				
				a12 = ':' {
					if (element == null) {
						element = baserequirements.BaserequirementsFactory.eINSTANCE.createComment();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_4_0_0_2_0_0_5_0_0_1, null, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a12, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[365]);
				}
				
				(
					a13 = TEXT					
					{
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
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[366]);
					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[367]);
				}
				
			)
			
		)?		{
			// expected elements (follow set)
			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[368]);
			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[369]);
		}
		
		(
			(
				a14 = 'children' {
					if (element == null) {
						element = baserequirements.BaserequirementsFactory.eINSTANCE.createComment();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_4_0_0_2_0_0_6_0_0_0, null, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a14, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[370]);
				}
				
				a15 = ':' {
					if (element == null) {
						element = baserequirements.BaserequirementsFactory.eINSTANCE.createComment();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_4_0_0_2_0_0_6_0_0_1, null, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a15, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(baserequirements.BaserequirementsPackage.eINSTANCE.getComment(), baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[371]);
				}
				
				(
					a16_0 = parse_baserequirements_Comment					{
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
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[372]);
					addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[373]);
				}
				
			)
			
		)*		{
			// expected elements (follow set)
			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[374]);
			addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[375]);
		}
		
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[376]);
	}
	
	a17 = '}' {
		if (element == null) {
			element = baserequirements.BaserequirementsFactory.eINSTANCE.createComment();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, baserequirements.resource.baseRequirements.grammar.BaseRequirementsGrammarInformationProvider.BASEREQUIREMENTS_4_0_0_3, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a17, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[377]);
		addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[378]);
		addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[379]);
		addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[380]);
		addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[381]);
		addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[382]);
		addExpectedElement(null, baserequirements.resource.baseRequirements.mopp.BaseRequirementsExpectationConstants.EXPECTATIONS[383]);
	}
	
;

COMMENT:
	('//'(~('\n'|'\r'|'\uffff'))*)
	{ _channel = 99; }
;
TEXT:
	(('A'..'Z' | 'a'..'z' | '0'..'9' | '_' | '-' )+)
;
WHITESPACE:
	((' ' | '\t' | '\f'))
	{ _channel = 99; }
;
LINEBREAK:
	(('\r\n' | '\r' | '\n'))
	{ _channel = 99; }
;
QUOTED_34_34:
	(('"')(~('"'))*('"'))
;

