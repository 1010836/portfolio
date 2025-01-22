/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package baserequirements.resource.baseRequirements.mopp;

public class BaseRequirementsMetaInformation implements baserequirements.resource.baseRequirements.IBaseRequirementsMetaInformation {
	
	public String getSyntaxName() {
		return "baseRequirements";
	}
	
	public String getURI() {
		return "http://org/eclipse/dsl/baseRequirements";
	}
	
	public baserequirements.resource.baseRequirements.IBaseRequirementsTextScanner createLexer() {
		return new baserequirements.resource.baseRequirements.mopp.BaseRequirementsAntlrScanner(new baserequirements.resource.baseRequirements.mopp.BaseRequirementsLexer());
	}
	
	public baserequirements.resource.baseRequirements.IBaseRequirementsTextParser createParser(java.io.InputStream inputStream, String encoding) {
		return new baserequirements.resource.baseRequirements.mopp.BaseRequirementsParser().createInstance(inputStream, encoding);
	}
	
	public baserequirements.resource.baseRequirements.IBaseRequirementsTextPrinter createPrinter(java.io.OutputStream outputStream, baserequirements.resource.baseRequirements.IBaseRequirementsTextResource resource) {
		return new baserequirements.resource.baseRequirements.mopp.BaseRequirementsPrinter2(outputStream, resource);
	}
	
	public org.eclipse.emf.ecore.EClass[] getClassesWithSyntax() {
		return new baserequirements.resource.baseRequirements.mopp.BaseRequirementsSyntaxCoverageInformationProvider().getClassesWithSyntax();
	}
	
	public org.eclipse.emf.ecore.EClass[] getStartSymbols() {
		return new baserequirements.resource.baseRequirements.mopp.BaseRequirementsSyntaxCoverageInformationProvider().getStartSymbols();
	}
	
	public baserequirements.resource.baseRequirements.IBaseRequirementsReferenceResolverSwitch getReferenceResolverSwitch() {
		return new baserequirements.resource.baseRequirements.mopp.BaseRequirementsReferenceResolverSwitch();
	}
	
	public baserequirements.resource.baseRequirements.IBaseRequirementsTokenResolverFactory getTokenResolverFactory() {
		return new baserequirements.resource.baseRequirements.mopp.BaseRequirementsTokenResolverFactory();
	}
	
	public String getPathToCSDefinition() {
		return "ex5emftext/metamodels/baseRequirements.cs";
	}
	
	public String[] getTokenNames() {
		return baserequirements.resource.baseRequirements.mopp.BaseRequirementsParser.tokenNames;
	}
	
	public baserequirements.resource.baseRequirements.IBaseRequirementsTokenStyle getDefaultTokenStyle(String tokenName) {
		return new baserequirements.resource.baseRequirements.mopp.BaseRequirementsTokenStyleInformationProvider().getDefaultTokenStyle(tokenName);
	}
	
	public java.util.Collection<baserequirements.resource.baseRequirements.IBaseRequirementsBracketPair> getBracketPairs() {
		return new baserequirements.resource.baseRequirements.mopp.BaseRequirementsBracketInformationProvider().getBracketPairs();
	}
	
	public org.eclipse.emf.ecore.EClass[] getFoldableClasses() {
		return new baserequirements.resource.baseRequirements.mopp.BaseRequirementsFoldingInformationProvider().getFoldableClasses();
	}
	
	public org.eclipse.emf.ecore.resource.Resource.Factory createResourceFactory() {
		return new baserequirements.resource.baseRequirements.mopp.BaseRequirementsResourceFactory();
	}
	
	public baserequirements.resource.baseRequirements.mopp.BaseRequirementsNewFileContentProvider getNewFileContentProvider() {
		return new baserequirements.resource.baseRequirements.mopp.BaseRequirementsNewFileContentProvider();
	}
	
	public void registerResourceFactory() {
		org.eclipse.emf.ecore.resource.Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(getSyntaxName(), new baserequirements.resource.baseRequirements.mopp.BaseRequirementsResourceFactory());
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
		return "baserequirements.resource.baseRequirements.ui.launchConfigurationType";
	}
	
	public baserequirements.resource.baseRequirements.IBaseRequirementsNameProvider createNameProvider() {
		return new baserequirements.resource.baseRequirements.analysis.BaseRequirementsDefaultNameProvider();
	}
	
	public String[] getSyntaxHighlightableTokenNames() {
		baserequirements.resource.baseRequirements.mopp.BaseRequirementsAntlrTokenHelper tokenHelper = new baserequirements.resource.baseRequirements.mopp.BaseRequirementsAntlrTokenHelper();
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
		highlightableTokens.add(baserequirements.resource.baseRequirements.mopp.BaseRequirementsTokenStyleInformationProvider.TASK_ITEM_TOKEN_NAME);
		return highlightableTokens.toArray(new String[highlightableTokens.size()]);
	}
	
}
