grammar Entity;

options {
	superClass = EntityANTLRParserBase;
	backtrack = true;
	memoize = true;
}

@lexer::header {
	package entity.resource.entity.mopp;
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
	package entity.resource.entity.mopp;
}

@members{
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
	
}

start returns [ org.eclipse.emf.ecore.EObject element = null]
:
	{
		// follow set for start rule(s)
		addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[0]);
		expectedElementsIndexOfLastCompleteElement = 0;
	}
	(
		c0 = parse_entity_Model{ element = c0; }
	)
	EOF	{
		retrieveLayoutInformation(element, null, null, false);
	}
	
;

parse_entity_Model returns [entity.Model element = null]
@init{
}
:
	a0 = 'Model' {
		if (element == null) {
			element = entity.EntityFactory.eINSTANCE.createModel();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, entity.resource.entity.grammar.EntityGrammarInformationProvider.ENTITY_0_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[1]);
	}
	
	a1 = '{' {
		if (element == null) {
			element = entity.EntityFactory.eINSTANCE.createModel();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, entity.resource.entity.grammar.EntityGrammarInformationProvider.ENTITY_0_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[2]);
	}
	
	(
		a2 = 'Title' {
			if (element == null) {
				element = entity.EntityFactory.eINSTANCE.createModel();
				startIncompleteElement(element);
			}
			collectHiddenTokens(element);
			retrieveLayoutInformation(element, entity.resource.entity.grammar.EntityGrammarInformationProvider.ENTITY_0_0_0_2_0_0_0, null, true);
			copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
		}
		{
			// expected elements (follow set)
			addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[3]);
		}
		
		a3 = ':' {
			if (element == null) {
				element = entity.EntityFactory.eINSTANCE.createModel();
				startIncompleteElement(element);
			}
			collectHiddenTokens(element);
			retrieveLayoutInformation(element, entity.resource.entity.grammar.EntityGrammarInformationProvider.ENTITY_0_0_0_2_0_0_1, null, true);
			copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
		}
		{
			// expected elements (follow set)
			addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[4]);
		}
		
		(
			a4 = QUOTED_34_34			
			{
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
		)
		{
			// expected elements (follow set)
			addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[5]);
			addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[6]);
		}
		
		(
			(
				a5 = 'has entities' {
					if (element == null) {
						element = entity.EntityFactory.eINSTANCE.createModel();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, entity.resource.entity.grammar.EntityGrammarInformationProvider.ENTITY_0_0_0_2_0_0_3_0_0_0, null, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[7]);
				}
				
				a6 = ':' {
					if (element == null) {
						element = entity.EntityFactory.eINSTANCE.createModel();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, entity.resource.entity.grammar.EntityGrammarInformationProvider.ENTITY_0_0_0_2_0_0_3_0_0_1, null, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(entity.EntityPackage.eINSTANCE.getModel(), entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[8]);
				}
				
				(
					a7_0 = parse_entity_Entity					{
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
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[9]);
					addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[10]);
				}
				
			)
			
		)*		{
			// expected elements (follow set)
			addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[11]);
			addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[12]);
		}
		
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[13]);
	}
	
	a8 = '}' {
		if (element == null) {
			element = entity.EntityFactory.eINSTANCE.createModel();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, entity.resource.entity.grammar.EntityGrammarInformationProvider.ENTITY_0_0_0_3, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a8, element);
	}
	{
		// expected elements (follow set)
	}
	
;

parse_entity_Entity returns [entity.Entity element = null]
@init{
}
:
	a0 = 'Entity' {
		if (element == null) {
			element = entity.EntityFactory.eINSTANCE.createEntity();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, entity.resource.entity.grammar.EntityGrammarInformationProvider.ENTITY_1_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[14]);
	}
	
	a1 = '{' {
		if (element == null) {
			element = entity.EntityFactory.eINSTANCE.createEntity();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, entity.resource.entity.grammar.EntityGrammarInformationProvider.ENTITY_1_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[15]);
	}
	
	(
		a2 = 'Name' {
			if (element == null) {
				element = entity.EntityFactory.eINSTANCE.createEntity();
				startIncompleteElement(element);
			}
			collectHiddenTokens(element);
			retrieveLayoutInformation(element, entity.resource.entity.grammar.EntityGrammarInformationProvider.ENTITY_1_0_0_2_0_0_0, null, true);
			copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
		}
		{
			// expected elements (follow set)
			addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[16]);
		}
		
		a3 = ':' {
			if (element == null) {
				element = entity.EntityFactory.eINSTANCE.createEntity();
				startIncompleteElement(element);
			}
			collectHiddenTokens(element);
			retrieveLayoutInformation(element, entity.resource.entity.grammar.EntityGrammarInformationProvider.ENTITY_1_0_0_2_0_0_1, null, true);
			copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
		}
		{
			// expected elements (follow set)
			addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[17]);
		}
		
		(
			a4 = QUOTED_34_34			
			{
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
		)
		{
			// expected elements (follow set)
			addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[18]);
			addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[19]);
			addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[20]);
		}
		
		(
			(
				a5 = 'attributes' {
					if (element == null) {
						element = entity.EntityFactory.eINSTANCE.createEntity();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, entity.resource.entity.grammar.EntityGrammarInformationProvider.ENTITY_1_0_0_2_0_0_3_0_0_0, null, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[21]);
				}
				
				a6 = ':' {
					if (element == null) {
						element = entity.EntityFactory.eINSTANCE.createEntity();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, entity.resource.entity.grammar.EntityGrammarInformationProvider.ENTITY_1_0_0_2_0_0_3_0_0_1, null, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(entity.EntityPackage.eINSTANCE.getEntity(), entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[22]);
				}
				
				(
					a7_0 = parse_entity_Attribute					{
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
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[23]);
					addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[24]);
					addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[25]);
				}
				
			)
			
		)*		{
			// expected elements (follow set)
			addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[26]);
			addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[27]);
			addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[28]);
		}
		
		(
			(
				a8 = 'relations' {
					if (element == null) {
						element = entity.EntityFactory.eINSTANCE.createEntity();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, entity.resource.entity.grammar.EntityGrammarInformationProvider.ENTITY_1_0_0_2_0_0_4_0_0_0, null, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a8, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[29]);
				}
				
				a9 = ':' {
					if (element == null) {
						element = entity.EntityFactory.eINSTANCE.createEntity();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, entity.resource.entity.grammar.EntityGrammarInformationProvider.ENTITY_1_0_0_2_0_0_4_0_0_1, null, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a9, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(entity.EntityPackage.eINSTANCE.getEntity(), entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[30]);
				}
				
				(
					a10_0 = parse_entity_Relation					{
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
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[31]);
					addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[32]);
				}
				
			)
			
		)*		{
			// expected elements (follow set)
			addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[33]);
			addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[34]);
		}
		
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[35]);
	}
	
	a11 = '}' {
		if (element == null) {
			element = entity.EntityFactory.eINSTANCE.createEntity();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, entity.resource.entity.grammar.EntityGrammarInformationProvider.ENTITY_1_0_0_3, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a11, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[36]);
		addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[37]);
	}
	
;

parse_entity_Attribute returns [entity.Attribute element = null]
@init{
}
:
	a0 = 'Attribute' {
		if (element == null) {
			element = entity.EntityFactory.eINSTANCE.createAttribute();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, entity.resource.entity.grammar.EntityGrammarInformationProvider.ENTITY_2_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[38]);
	}
	
	a1 = '{' {
		if (element == null) {
			element = entity.EntityFactory.eINSTANCE.createAttribute();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, entity.resource.entity.grammar.EntityGrammarInformationProvider.ENTITY_2_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[39]);
	}
	
	(
		a2 = 'Name' {
			if (element == null) {
				element = entity.EntityFactory.eINSTANCE.createAttribute();
				startIncompleteElement(element);
			}
			collectHiddenTokens(element);
			retrieveLayoutInformation(element, entity.resource.entity.grammar.EntityGrammarInformationProvider.ENTITY_2_0_0_2_0_0_0, null, true);
			copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
		}
		{
			// expected elements (follow set)
			addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[40]);
		}
		
		a3 = ':' {
			if (element == null) {
				element = entity.EntityFactory.eINSTANCE.createAttribute();
				startIncompleteElement(element);
			}
			collectHiddenTokens(element);
			retrieveLayoutInformation(element, entity.resource.entity.grammar.EntityGrammarInformationProvider.ENTITY_2_0_0_2_0_0_1, null, true);
			copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
		}
		{
			// expected elements (follow set)
			addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[41]);
		}
		
		(
			a4 = QUOTED_34_34			
			{
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
		)
		{
			// expected elements (follow set)
			addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[42]);
			addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[43]);
		}
		
		(
			(
				a5 = 'Type' {
					if (element == null) {
						element = entity.EntityFactory.eINSTANCE.createAttribute();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, entity.resource.entity.grammar.EntityGrammarInformationProvider.ENTITY_2_0_0_2_0_0_3_0_0_0, null, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[44]);
				}
				
				a6 = ':' {
					if (element == null) {
						element = entity.EntityFactory.eINSTANCE.createAttribute();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, entity.resource.entity.grammar.EntityGrammarInformationProvider.ENTITY_2_0_0_2_0_0_3_0_0_1, null, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[45]);
				}
				
				(
					(
						a7 = 'String' {
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
						|						a8 = 'Float' {
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
						|						a9 = 'Integer' {
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
						|						a10 = 'Boolean' {
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
					)
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[46]);
					addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[47]);
				}
				
			)
			
		)*		{
			// expected elements (follow set)
			addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[48]);
			addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[49]);
		}
		
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[50]);
	}
	
	a13 = '}' {
		if (element == null) {
			element = entity.EntityFactory.eINSTANCE.createAttribute();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, entity.resource.entity.grammar.EntityGrammarInformationProvider.ENTITY_2_0_0_3, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a13, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[51]);
		addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[52]);
		addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[53]);
	}
	
;

parse_entity_Relation returns [entity.Relation element = null]
@init{
}
:
	a0 = 'Relation' {
		if (element == null) {
			element = entity.EntityFactory.eINSTANCE.createRelation();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, entity.resource.entity.grammar.EntityGrammarInformationProvider.ENTITY_3_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[54]);
	}
	
	a1 = '{' {
		if (element == null) {
			element = entity.EntityFactory.eINSTANCE.createRelation();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, entity.resource.entity.grammar.EntityGrammarInformationProvider.ENTITY_3_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[55]);
	}
	
	(
		a2 = 'Name' {
			if (element == null) {
				element = entity.EntityFactory.eINSTANCE.createRelation();
				startIncompleteElement(element);
			}
			collectHiddenTokens(element);
			retrieveLayoutInformation(element, entity.resource.entity.grammar.EntityGrammarInformationProvider.ENTITY_3_0_0_2_0_0_0, null, true);
			copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
		}
		{
			// expected elements (follow set)
			addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[56]);
		}
		
		a3 = ':' {
			if (element == null) {
				element = entity.EntityFactory.eINSTANCE.createRelation();
				startIncompleteElement(element);
			}
			collectHiddenTokens(element);
			retrieveLayoutInformation(element, entity.resource.entity.grammar.EntityGrammarInformationProvider.ENTITY_3_0_0_2_0_0_1, null, true);
			copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
		}
		{
			// expected elements (follow set)
			addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[57]);
		}
		
		(
			a4 = QUOTED_34_34			
			{
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
		)
		{
			// expected elements (follow set)
			addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[58]);
		}
		
		a5 = 'Type' {
			if (element == null) {
				element = entity.EntityFactory.eINSTANCE.createRelation();
				startIncompleteElement(element);
			}
			collectHiddenTokens(element);
			retrieveLayoutInformation(element, entity.resource.entity.grammar.EntityGrammarInformationProvider.ENTITY_3_0_0_2_0_0_3, null, true);
			copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
		}
		{
			// expected elements (follow set)
			addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[59]);
		}
		
		a6 = ':' {
			if (element == null) {
				element = entity.EntityFactory.eINSTANCE.createRelation();
				startIncompleteElement(element);
			}
			collectHiddenTokens(element);
			retrieveLayoutInformation(element, entity.resource.entity.grammar.EntityGrammarInformationProvider.ENTITY_3_0_0_2_0_0_4, null, true);
			copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
		}
		{
			// expected elements (follow set)
			addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[60]);
		}
		
		(
			(
				a7 = 'one' {
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
				|				a8 = 'many' {
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
			)
		)
		{
			// expected elements (follow set)
			addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[61]);
			addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[62]);
		}
		
		(
			(
				a11 = 'RelEntity' {
					if (element == null) {
						element = entity.EntityFactory.eINSTANCE.createRelation();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, entity.resource.entity.grammar.EntityGrammarInformationProvider.ENTITY_3_0_0_2_0_0_6_0_0_0, null, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a11, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[63]);
				}
				
				a12 = ':' {
					if (element == null) {
						element = entity.EntityFactory.eINSTANCE.createRelation();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, entity.resource.entity.grammar.EntityGrammarInformationProvider.ENTITY_3_0_0_2_0_0_6_0_0_1, null, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a12, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[64]);
				}
				
				(
					a13 = TEXT					
					{
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
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[65]);
					addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[66]);
				}
				
			)
			
		)*		{
			// expected elements (follow set)
			addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[67]);
			addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[68]);
		}
		
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[69]);
	}
	
	a14 = '}' {
		if (element == null) {
			element = entity.EntityFactory.eINSTANCE.createRelation();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, entity.resource.entity.grammar.EntityGrammarInformationProvider.ENTITY_3_0_0_3, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a14, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[70]);
		addExpectedElement(null, entity.resource.entity.mopp.EntityExpectationConstants.EXPECTATIONS[71]);
	}
	
;

COMMENT:
	('//'(~('\n'|'\r'|'\uffff'))*)
	{ _channel = 99; }
;
INTEGER:
	(('-')?('1'..'9')('0'..'9')*|'0')
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

