/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package baserequirements.resource.baserequirements.mopp;

public class BaserequirementsMetaInformation implements baserequirements.resource.baserequirements.IBaserequirementsMetaInformation {
	
	public String getSyntaxName() {
		return "baserequirements";
	}
	
	public String getURI() {
		return "http://org/eclipse/dsl/baseRequirements";
	}
	
	public baserequirements.resource.baserequirements.IBaserequirementsTextScanner createLexer() {
		return new baserequirements.resource.baserequirements.mopp.BaserequirementsAntlrScanner(new baserequirements.resource.baserequirements.mopp.BaserequirementsLexer());
	}
	
	public baserequirements.resource.baserequirements.IBaserequirementsTextParser createParser(java.io.InputStream inputStream, String encoding) {
		return new baserequirements.resource.baserequirements.mopp.BaserequirementsParser().createInstance(inputStream, encoding);
	}
	
	public baserequirements.resource.baserequirements.IBaserequirementsTextPrinter createPrinter(java.io.OutputStream outputStream, baserequirements.resource.baserequirements.IBaserequirementsTextResource resource) {
		return new baserequirements.resource.baserequirements.mopp.BaserequirementsPrinter2(outputStream, resource);
	}
	
	public org.eclipse.emf.ecore.EClass[] getClassesWithSyntax() {
		return new baserequirements.resource.baserequirements.mopp.BaserequirementsSyntaxCoverageInformationProvider().getClassesWithSyntax();
	}
	
	public org.eclipse.emf.ecore.EClass[] getStartSymbols() {
		return new baserequirements.resource.baserequirements.mopp.BaserequirementsSyntaxCoverageInformationProvider().getStartSymbols();
	}
	
	public baserequirements.resource.baserequirements.IBaserequirementsReferenceResolverSwitch getReferenceResolverSwitch() {
		return new baserequirements.resource.baserequirements.mopp.BaserequirementsReferenceResolverSwitch();
	}
	
	public baserequirements.resource.baserequirements.IBaserequirementsTokenResolverFactory getTokenResolverFactory() {
		return new baserequirements.resource.baserequirements.mopp.BaserequirementsTokenResolverFactory();
	}
	
	public String getPathToCSDefinition() {
		return "Exercise5/mm/baseRequirements.cs";
	}
	
	public String[] getTokenNames() {
		return baserequirements.resource.baserequirements.mopp.BaserequirementsParser.tokenNames;
	}
	
	public baserequirements.resource.baserequirements.IBaserequirementsTokenStyle getDefaultTokenStyle(String tokenName) {
		return new baserequirements.resource.baserequirements.mopp.BaserequirementsTokenStyleInformationProvider().getDefaultTokenStyle(tokenName);
	}
	
	public java.util.Collection<baserequirements.resource.baserequirements.IBaserequirementsBracketPair> getBracketPairs() {
		return new baserequirements.resource.baserequirements.mopp.BaserequirementsBracketInformationProvider().getBracketPairs();
	}
	
	public org.eclipse.emf.ecore.EClass[] getFoldableClasses() {
		return new baserequirements.resource.baserequirements.mopp.BaserequirementsFoldingInformationProvider().getFoldableClasses();
	}
	
	public org.eclipse.emf.ecore.resource.Resource.Factory createResourceFactory() {
		return new baserequirements.resource.baserequirements.mopp.BaserequirementsResourceFactory();
	}
	
	public baserequirements.resource.baserequirements.mopp.BaserequirementsNewFileContentProvider getNewFileContentProvider() {
		return new baserequirements.resource.baserequirements.mopp.BaserequirementsNewFileContentProvider();
	}
	
	public void registerResourceFactory() {
		org.eclipse.emf.ecore.resource.Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(getSyntaxName(), new baserequirements.resource.baserequirements.mopp.BaserequirementsResourceFactory());
	}
	
	/**
	 * Returns the key of the option that can be used to register a preprocessor that
	 * is used as a pipe when loading resources. This key is language-specific. To
	 * register one preprocessor for multiple resource types, it must be registered
	 * individually using all keys.
	 */
	public String getInputStreamPreprocessorProviderOptionKey() {
		return getSyntaxName() + "_" + "INPUT_STREAM_PREPROCESSOR_PROVIDER";
	}
	
	/**
	 * Returns the key of the option that can be used to register a post-processors
	 * that are invoked after loading resources. This key is language-specific. To
	 * register one post-processor for multiple resource types, it must be registered
	 * individually using all keys.
	 */
	public String getResourcePostProcessorProviderOptionKey() {
		return getSyntaxName() + "_" + "RESOURCE_POSTPROCESSOR_PROVIDER";
	}
	
	public String getLaunchConfigurationType() {
		return "baserequirements.resource.baserequirements.ui.launchConfigurationType";
	}
	
	public baserequirements.resource.baserequirements.IBaserequirementsNameProvider createNameProvider() {
		return new baserequirements.resource.baserequirements.analysis.BaserequirementsDefaultNameProvider();
	}
	
	public String[] getSyntaxHighlightableTokenNames() {
		baserequirements.resource.baserequirements.mopp.BaserequirementsAntlrTokenHelper tokenHelper = new baserequirements.resource.baserequirements.mopp.BaserequirementsAntlrTokenHelper();
		java.util.List<String> highlightableTokens = new java.util.ArrayList<String>();
		String[] parserTokenNames = getTokenNames();
		for (int i = 0; i < parserTokenNames.length; i++) {
			// If ANTLR is used we need to normalize the token names
			if (!tokenHelper.canBeUsedForSyntaxHighlighting(i)) {
				continue;
			}
			String tokenName = tokenHelper.getTokenName(parserTokenNames, i);
			if (tokenName == null) {
				continue;
			}
			highlightableTokens.add(tokenName);
		}
		highlightableTokens.add(baserequirements.resource.baserequirements.mopp.BaserequirementsTokenStyleInformationProvider.TASK_ITEM_TOKEN_NAME);
		return highlightableTokens.toArray(new String[highlightableTokens.size()]);
	}
	
}
