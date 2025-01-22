grammar Baserequirements;

options {
	superClass = BaserequirementsANTLRParserBase;
	backtrack = true;
	memoize = true;
}

@lexer::header {
	package baserequirements.resource.baserequirements.mopp;
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
	package baserequirements.resource.baserequirements.mopp;
}

@members{
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
	
}

start returns [ org.eclipse.emf.ecore.EObject element = null]
:
	{
		// follow set for start rule(s)
		addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[0]);
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
		retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_0_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[1]);
	}
	
	a1 = '{' {
		if (element == null) {
			element = baserequirements.BaserequirementsFactory.eINSTANCE.createModel();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_0_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[2]);
	}
	
	(
		a2 = 'title' {
			if (element == null) {
				element = baserequirements.BaserequirementsFactory.eINSTANCE.createModel();
				startIncompleteElement(element);
			}
			collectHiddenTokens(element);
			retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_0_0_0_2_0_0_0, null, true);
			copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
		}
		{
			// expected elements (follow set)
			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[3]);
		}
		
		a3 = ':' {
			if (element == null) {
				element = baserequirements.BaserequirementsFactory.eINSTANCE.createModel();
				startIncompleteElement(element);
			}
			collectHiddenTokens(element);
			retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_0_0_0_2_0_0_1, null, true);
			copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
		}
		{
			// expected elements (follow set)
			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[4]);
		}
		
		(
			a4 = QUOTED_34_34			
			{
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
		)
		{
			// expected elements (follow set)
			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[5]);
			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[6]);
		}
		
		(
			(
				a5 = 'groups' {
					if (element == null) {
						element = baserequirements.BaserequirementsFactory.eINSTANCE.createModel();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_0_0_0_2_0_0_3_0_0_0, null, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[7]);
				}
				
				a6 = ':' {
					if (element == null) {
						element = baserequirements.BaserequirementsFactory.eINSTANCE.createModel();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_0_0_0_2_0_0_3_0_0_1, null, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(baserequirements.BaserequirementsPackage.eINSTANCE.getModel(), baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[8]);
				}
				
				(
					a7_0 = parse_baserequirements_RequirementGroup					{
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
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[9]);
					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[10]);
				}
				
			)
			
		)*		{
			// expected elements (follow set)
			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[11]);
			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[12]);
		}
		
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[13]);
	}
	
	a8 = '}' {
		if (element == null) {
			element = baserequirements.BaserequirementsFactory.eINSTANCE.createModel();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_0_0_0_3, null, true);
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
		retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_1_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[14]);
	}
	
	a1 = '{' {
		if (element == null) {
			element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirementGroup();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_1_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[15]);
	}
	
	(
		a2 = 'name' {
			if (element == null) {
				element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirementGroup();
				startIncompleteElement(element);
			}
			collectHiddenTokens(element);
			retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_1_0_0_2_0_0_0, null, true);
			copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
		}
		{
			// expected elements (follow set)
			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[16]);
		}
		
		a3 = ':' {
			if (element == null) {
				element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirementGroup();
				startIncompleteElement(element);
			}
			collectHiddenTokens(element);
			retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_1_0_0_2_0_0_1, null, true);
			copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
		}
		{
			// expected elements (follow set)
			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[17]);
		}
		
		(
			a4 = QUOTED_34_34			
			{
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
		)
		{
			// expected elements (follow set)
			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[18]);
			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[19]);
		}
		
		(
			(
				a5 = 'description' {
					if (element == null) {
						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirementGroup();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_1_0_0_2_0_0_3_0_0_0, null, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[20]);
				}
				
				a6 = ':' {
					if (element == null) {
						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirementGroup();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_1_0_0_2_0_0_3_0_0_1, null, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[21]);
				}
				
				(
					a7 = QUOTED_34_34					
					{
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
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[22]);
				}
				
			)
			
		)?		{
			// expected elements (follow set)
			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[23]);
		}
		
		(
			a8 = 'id' {
				if (element == null) {
					element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirementGroup();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_1_0_0_2_0_0_4_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a8, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[24]);
			}
			
			a9 = ':' {
				if (element == null) {
					element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirementGroup();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_1_0_0_2_0_0_4_0_0_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a9, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[25]);
			}
			
			(
				a10 = QUOTED_34_34				
				{
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
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[26]);
				addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[27]);
				addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[28]);
				addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[29]);
			}
			
		)
		{
			// expected elements (follow set)
			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[30]);
			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[31]);
			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[32]);
			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[33]);
		}
		
		(
			(
				a11 = 'children' {
					if (element == null) {
						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirementGroup();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_1_0_0_2_0_0_5_0_0_0, null, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a11, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[34]);
				}
				
				a12 = ':' {
					if (element == null) {
						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirementGroup();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_1_0_0_2_0_0_5_0_0_1, null, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a12, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(baserequirements.BaserequirementsPackage.eINSTANCE.getRequirementGroup(), baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[35]);
				}
				
				(
					a13_0 = parse_baserequirements_RequirementGroup					{
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
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[36]);
					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[37]);
					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[38]);
					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[39]);
				}
				
			)
			
		)*		{
			// expected elements (follow set)
			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[40]);
			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[41]);
			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[42]);
			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[43]);
		}
		
		(
			(
				a14 = 'parent' {
					if (element == null) {
						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirementGroup();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_1_0_0_2_0_0_6_0_0_0, null, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a14, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[44]);
				}
				
				a15 = ':' {
					if (element == null) {
						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirementGroup();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_1_0_0_2_0_0_6_0_0_1, null, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a15, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[45]);
				}
				
				(
					a16 = TEXT					
					{
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
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[46]);
					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[47]);
				}
				
			)
			
		)?		{
			// expected elements (follow set)
			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[48]);
			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[49]);
		}
		
		(
			(
				a17 = 'requirements' {
					if (element == null) {
						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirementGroup();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_1_0_0_2_0_0_7_0_0_0, null, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a17, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[50]);
				}
				
				a18 = ':' {
					if (element == null) {
						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirementGroup();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_1_0_0_2_0_0_7_0_0_1, null, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a18, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(baserequirements.BaserequirementsPackage.eINSTANCE.getRequirementGroup(), baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[51]);
				}
				
				(
					a19_0 = parse_baserequirements_Requirement					{
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
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[52]);
					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[53]);
				}
				
			)
			
		)*		{
			// expected elements (follow set)
			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[54]);
			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[55]);
		}
		
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[56]);
	}
	
	a20 = '}' {
		if (element == null) {
			element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirementGroup();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_1_0_0_3, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a20, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[57]);
		addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[58]);
		addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[59]);
		addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[60]);
		addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[61]);
		addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[62]);
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
		retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[63]);
	}
	
	a1 = '{' {
		if (element == null) {
			element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[64]);
	}
	
	(
		a2 = 'title' {
			if (element == null) {
				element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
				startIncompleteElement(element);
			}
			collectHiddenTokens(element);
			retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_0, null, true);
			copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
		}
		{
			// expected elements (follow set)
			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[65]);
		}
		
		a3 = ':' {
			if (element == null) {
				element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
				startIncompleteElement(element);
			}
			collectHiddenTokens(element);
			retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_1, null, true);
			copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
		}
		{
			// expected elements (follow set)
			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[66]);
		}
		
		(
			a4 = QUOTED_34_34			
			{
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
		)
		{
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
		
		(
			(
				a5 = 'description' {
					if (element == null) {
						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_3_0_0_0, null, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[81]);
				}
				
				a6 = ':' {
					if (element == null) {
						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_3_0_0_1, null, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[82]);
				}
				
				(
					a7 = QUOTED_34_34					
					{
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
				)
				{
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
				
			)
			
		)?		{
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
		
		(
			(
				a8 = 'type' {
					if (element == null) {
						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_4_0_0_0, null, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a8, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[109]);
				}
				
				a9 = ':' {
					if (element == null) {
						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_4_0_0_1, null, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a9, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[110]);
				}
				
				(
					(
						a10 = 'FUNCTIONAL' {
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
						|						a11 = 'NONFUNCTIONAL' {
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
					)
				)
				{
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
				
			)
			
		)?		{
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
		
		(
			(
				a14 = 'priority' {
					if (element == null) {
						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_5_0_0_0, null, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a14, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[135]);
				}
				
				a15 = ':' {
					if (element == null) {
						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_5_0_0_1, null, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a15, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[136]);
				}
				
				(
					(
						a16 = 'HIGH' {
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
						|						a17 = 'MEDIUM' {
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
						|						a18 = 'LOW' {
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
					)
				)
				{
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
				
			)
			
		)?		{
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
		
		(
			(
				a21 = 'author' {
					if (element == null) {
						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_6_0_0_0, null, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a21, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[159]);
				}
				
				a22 = ':' {
					if (element == null) {
						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_6_0_0_1, null, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a22, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[160]);
				}
				
				(
					a23 = QUOTED_34_34					
					{
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
				)
				{
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
				
			)
			
		)?		{
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
		
		(
			(
				a24 = 'created' {
					if (element == null) {
						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_7_0_0_0, null, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a24, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[181]);
				}
				
				a25 = ':' {
					if (element == null) {
						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_7_0_0_1, null, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a25, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[182]);
				}
				
				(
					a26 = TEXT					
					{
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
				)
				{
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
				
			)
			
		)?		{
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
		
		(
			(
				a27 = 'id' {
					if (element == null) {
						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_8_0_0_0, null, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a27, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[201]);
				}
				
				a28 = ':' {
					if (element == null) {
						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_8_0_0_1, null, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a28, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[202]);
				}
				
				(
					a29 = QUOTED_34_34					
					{
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
				)
				{
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
				
			)
			
		)?		{
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
		
		(
			(
				a30 = 'state' {
					if (element == null) {
						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_9_0_0_0, null, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a30, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[219]);
				}
				
				a31 = ':' {
					if (element == null) {
						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_9_0_0_1, null, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a31, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[220]);
				}
				
				(
					(
						a32 = 'NEW' {
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
						|						a33 = 'REVIEWED' {
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
						|						a34 = 'APPROVED' {
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
						|						a35 = 'RESOLVED' {
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
					)
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[221]);
					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[222]);
					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[223]);
					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[224]);
					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[225]);
					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[226]);
					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[227]);
				}
				
			)
			
		)?		{
			// expected elements (follow set)
			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[228]);
			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[229]);
			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[230]);
			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[231]);
			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[232]);
			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[233]);
			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[234]);
		}
		
		(
			(
				a38 = 'resolution' {
					if (element == null) {
						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_10_0_0_0, null, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a38, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[235]);
				}
				
				a39 = ':' {
					if (element == null) {
						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_10_0_0_1, null, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a39, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[236]);
				}
				
				(
					(
						a40 = 'INVALID' {
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
						|						a41 = 'ACCEPTED' {
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
						|						a42 = 'IMPLEMENTED' {
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
						|						a43 = 'LATER' {
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
					)
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[237]);
					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[238]);
					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[239]);
					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[240]);
					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[241]);
					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[242]);
				}
				
			)
			
		)?		{
			// expected elements (follow set)
			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[243]);
			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[244]);
			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[245]);
			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[246]);
			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[247]);
			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[248]);
		}
		
		(
			(
				a46 = 'version' {
					if (element == null) {
						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_11_0_0_0, null, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a46, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[249]);
				}
				
				a47 = ':' {
					if (element == null) {
						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_11_0_0_1, null, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a47, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(baserequirements.BaserequirementsPackage.eINSTANCE.getRequirement(), baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[250]);
				}
				
				(
					a48_0 = parse_baserequirements_Version					{
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
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[251]);
					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[252]);
					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[253]);
					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[254]);
					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[255]);
				}
				
			)
			
		)?		{
			// expected elements (follow set)
			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[256]);
			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[257]);
			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[258]);
			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[259]);
			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[260]);
		}
		
		(
			(
				a49 = 'comments' {
					if (element == null) {
						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_12_0_0_0, null, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a49, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[261]);
				}
				
				a50 = ':' {
					if (element == null) {
						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_12_0_0_1, null, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a50, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(baserequirements.BaserequirementsPackage.eINSTANCE.getRequirement(), baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[262]);
				}
				
				(
					a51_0 = parse_baserequirements_Comment					{
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
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[263]);
					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[264]);
					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[265]);
					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[266]);
					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[267]);
				}
				
			)
			
		)*		{
			// expected elements (follow set)
			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[268]);
			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[269]);
			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[270]);
			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[271]);
			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[272]);
		}
		
		(
			(
				a52 = 'dependencies' {
					if (element == null) {
						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_13_0_0_0, null, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a52, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[273]);
				}
				
				a53 = ':' {
					if (element == null) {
						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_13_0_0_1, null, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a53, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[274]);
				}
				
				(
					a54 = TEXT					
					{
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
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[275]);
					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[276]);
					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[277]);
					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[278]);
				}
				
			)
			
		)*		{
			// expected elements (follow set)
			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[279]);
			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[280]);
			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[281]);
			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[282]);
		}
		
		(
			(
				a55 = 'parent' {
					if (element == null) {
						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_14_0_0_0, null, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a55, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[283]);
				}
				
				a56 = ':' {
					if (element == null) {
						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_14_0_0_1, null, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a56, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[284]);
				}
				
				(
					a57 = TEXT					
					{
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
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[285]);
					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[286]);
				}
				
			)
			
		)?		{
			// expected elements (follow set)
			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[287]);
			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[288]);
		}
		
		(
			(
				a58 = 'children' {
					if (element == null) {
						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_15_0_0_0, null, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a58, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[289]);
				}
				
				a59 = ':' {
					if (element == null) {
						element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_2_0_0_15_0_0_1, null, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a59, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(baserequirements.BaserequirementsPackage.eINSTANCE.getRequirement(), baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[290]);
				}
				
				(
					a60_0 = parse_baserequirements_Requirement					{
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
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[291]);
					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[292]);
				}
				
			)
			
		)*		{
			// expected elements (follow set)
			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[293]);
			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[294]);
		}
		
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[295]);
	}
	
	a61 = '}' {
		if (element == null) {
			element = baserequirements.BaserequirementsFactory.eINSTANCE.createRequirement();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_2_0_0_3, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a61, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[296]);
		addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[297]);
		addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[298]);
		addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[299]);
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
		retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_3_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[300]);
	}
	
	a1 = '{' {
		if (element == null) {
			element = baserequirements.BaserequirementsFactory.eINSTANCE.createVersion();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_3_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[301]);
	}
	
	(
		a2 = 'major' {
			if (element == null) {
				element = baserequirements.BaserequirementsFactory.eINSTANCE.createVersion();
				startIncompleteElement(element);
			}
			collectHiddenTokens(element);
			retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_3_0_0_2_0_0_0, null, true);
			copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
		}
		{
			// expected elements (follow set)
			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[302]);
		}
		
		a3 = ':' {
			if (element == null) {
				element = baserequirements.BaserequirementsFactory.eINSTANCE.createVersion();
				startIncompleteElement(element);
			}
			collectHiddenTokens(element);
			retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_3_0_0_2_0_0_1, null, true);
			copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
		}
		{
			// expected elements (follow set)
			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[303]);
		}
		
		(
			a4 = TEXT			
			{
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
		)
		{
			// expected elements (follow set)
			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[304]);
		}
		
		(
			a5 = 'minor' {
				if (element == null) {
					element = baserequirements.BaserequirementsFactory.eINSTANCE.createVersion();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_3_0_0_2_0_0_3_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[305]);
			}
			
			a6 = ':' {
				if (element == null) {
					element = baserequirements.BaserequirementsFactory.eINSTANCE.createVersion();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_3_0_0_2_0_0_3_0_0_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[306]);
			}
			
			(
				a7 = TEXT				
				{
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
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[307]);
			}
			
		)
		{
			// expected elements (follow set)
			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[308]);
		}
		
		(
			a8 = 'service' {
				if (element == null) {
					element = baserequirements.BaserequirementsFactory.eINSTANCE.createVersion();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_3_0_0_2_0_0_4_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a8, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[309]);
			}
			
			a9 = ':' {
				if (element == null) {
					element = baserequirements.BaserequirementsFactory.eINSTANCE.createVersion();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_3_0_0_2_0_0_4_0_0_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a9, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[310]);
			}
			
			(
				a10 = TEXT				
				{
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
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[311]);
			}
			
		)
		{
			// expected elements (follow set)
			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[312]);
		}
		
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[313]);
	}
	
	a11 = '}' {
		if (element == null) {
			element = baserequirements.BaserequirementsFactory.eINSTANCE.createVersion();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_3_0_0_3, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a11, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[314]);
		addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[315]);
		addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[316]);
		addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[317]);
		addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[318]);
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
		retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_4_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[319]);
	}
	
	a1 = '{' {
		if (element == null) {
			element = baserequirements.BaserequirementsFactory.eINSTANCE.createComment();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_4_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[320]);
	}
	
	(
		a2 = 'subject' {
			if (element == null) {
				element = baserequirements.BaserequirementsFactory.eINSTANCE.createComment();
				startIncompleteElement(element);
			}
			collectHiddenTokens(element);
			retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_4_0_0_2_0_0_0, null, true);
			copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
		}
		{
			// expected elements (follow set)
			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[321]);
		}
		
		a3 = ':' {
			if (element == null) {
				element = baserequirements.BaserequirementsFactory.eINSTANCE.createComment();
				startIncompleteElement(element);
			}
			collectHiddenTokens(element);
			retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_4_0_0_2_0_0_1, null, true);
			copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
		}
		{
			// expected elements (follow set)
			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[322]);
		}
		
		(
			a4 = QUOTED_34_34			
			{
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
		)
		{
			// expected elements (follow set)
			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[323]);
		}
		
		(
			a5 = 'body' {
				if (element == null) {
					element = baserequirements.BaserequirementsFactory.eINSTANCE.createComment();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_4_0_0_2_0_0_3_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[324]);
			}
			
			a6 = ':' {
				if (element == null) {
					element = baserequirements.BaserequirementsFactory.eINSTANCE.createComment();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_4_0_0_2_0_0_3_0_0_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[325]);
			}
			
			(
				a7 = QUOTED_34_34				
				{
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
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[326]);
			}
			
		)
		{
			// expected elements (follow set)
			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[327]);
		}
		
		(
			a8 = 'author' {
				if (element == null) {
					element = baserequirements.BaserequirementsFactory.eINSTANCE.createComment();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_4_0_0_2_0_0_4_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a8, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[328]);
			}
			
			a9 = ':' {
				if (element == null) {
					element = baserequirements.BaserequirementsFactory.eINSTANCE.createComment();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_4_0_0_2_0_0_4_0_0_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a9, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[329]);
			}
			
			(
				a10 = QUOTED_34_34				
				{
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
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[330]);
			}
			
		)
		{
			// expected elements (follow set)
			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[331]);
		}
		
		(
			a11 = 'created' {
				if (element == null) {
					element = baserequirements.BaserequirementsFactory.eINSTANCE.createComment();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_4_0_0_2_0_0_5_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a11, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[332]);
			}
			
			a12 = ':' {
				if (element == null) {
					element = baserequirements.BaserequirementsFactory.eINSTANCE.createComment();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_4_0_0_2_0_0_5_0_0_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a12, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[333]);
			}
			
			(
				a13 = TEXT				
				{
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
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[334]);
				addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[335]);
			}
			
		)
		{
			// expected elements (follow set)
			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[336]);
			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[337]);
		}
		
		(
			(
				a14 = 'children' {
					if (element == null) {
						element = baserequirements.BaserequirementsFactory.eINSTANCE.createComment();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_4_0_0_2_0_0_6_0_0_0, null, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a14, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[338]);
				}
				
				a15 = ':' {
					if (element == null) {
						element = baserequirements.BaserequirementsFactory.eINSTANCE.createComment();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_4_0_0_2_0_0_6_0_0_1, null, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a15, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(baserequirements.BaserequirementsPackage.eINSTANCE.getComment(), baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[339]);
				}
				
				(
					a16_0 = parse_baserequirements_Comment					{
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
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[340]);
					addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[341]);
				}
				
			)
			
		)*		{
			// expected elements (follow set)
			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[342]);
			addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[343]);
		}
		
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[344]);
	}
	
	a17 = '}' {
		if (element == null) {
			element = baserequirements.BaserequirementsFactory.eINSTANCE.createComment();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, baserequirements.resource.baserequirements.grammar.BaserequirementsGrammarInformationProvider.BASEREQUIREMENTS_4_0_0_3, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a17, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[345]);
		addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[346]);
		addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[347]);
		addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[348]);
		addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[349]);
		addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[350]);
		addExpectedElement(null, baserequirements.resource.baserequirements.mopp.BaserequirementsExpectationConstants.EXPECTATIONS[351]);
	}
	
;

COMMENT:
	('//'(~('\n'|'\r'|'\uffff'))*)
	{ _channel = 99; }
;
FLOAT:
	(('-')?(('1'..'9') ('0'..'9')* | '0') '.' ('0'..'9')+ )
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

