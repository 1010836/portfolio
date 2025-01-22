/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package entity.resource.entity.mopp;

public class EntityMetaInformation implements entity.resource.entity.IEntityMetaInformation {
	
	public String getSyntaxName() {
		return "entity";
	}
	
	public String getURI() {
		return "http://org/eclipse/dsl/entity";
	}
	
	public entity.resource.entity.IEntityTextScanner createLexer() {
		return new entity.resource.entity.mopp.EntityAntlrScanner(new entity.resource.entity.mopp.EntityLexer());
	}
	
	public entity.resource.entity.IEntityTextParser createParser(java.io.InputStream inputStream, String encoding) {
		return new entity.resource.entity.mopp.EntityParser().createInstance(inputStream, encoding);
	}
	
	public entity.resource.entity.IEntityTextPrinter createPrinter(java.io.OutputStream outputStream, entity.resource.entity.IEntityTextResource resource) {
		return new entity.resource.entity.mopp.EntityPrinter2(outputStream, resource);
	}
	
	public org.eclipse.emf.ecore.EClass[] getClassesWithSyntax() {
		return new entity.resource.entity.mopp.EntitySyntaxCoverageInformationProvider().getClassesWithSyntax();
	}
	
	public org.eclipse.emf.ecore.EClass[] getStartSymbols() {
		return new entity.resource.entity.mopp.EntitySyntaxCoverageInformationProvider().getStartSymbols();
	}
	
	public entity.resource.entity.IEntityReferenceResolverSwitch getReferenceResolverSwitch() {
		return new entity.resource.entity.mopp.EntityReferenceResolverSwitch();
	}
	
	public entity.resource.entity.IEntityTokenResolverFactory getTokenResolverFactory() {
		return new entity.resource.entity.mopp.EntityTokenResolverFactory();
	}
	
	public String getPathToCSDefinition() {
		return "ex5emftext/metamodels/entity.cs";
	}
	
	public String[] getTokenNames() {
		return entity.resource.entity.mopp.EntityParser.tokenNames;
	}
	
	public entity.resource.entity.IEntityTokenStyle getDefaultTokenStyle(String tokenName) {
		return new entity.resource.entity.mopp.EntityTokenStyleInformationProvider().getDefaultTokenStyle(tokenName);
	}
	
	public java.util.Collection<entity.resource.entity.IEntityBracketPair> getBracketPairs() {
		return new entity.resource.entity.mopp.EntityBracketInformationProvider().getBracketPairs();
	}
	
	public org.eclipse.emf.ecore.EClass[] getFoldableClasses() {
		return new entity.resource.entity.mopp.EntityFoldingInformationProvider().getFoldableClasses();
	}
	
	public org.eclipse.emf.ecore.resource.Resource.Factory createResourceFactory() {
		return new entity.resource.entity.mopp.EntityResourceFactory();
	}
	
	public entity.resource.entity.mopp.EntityNewFileContentProvider getNewFileContentProvider() {
		return new entity.resource.entity.mopp.EntityNewFileContentProvider();
	}
	
	public void registerResourceFactory() {
		org.eclipse.emf.ecore.resource.Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(getSyntaxName(), new entity.resource.entity.mopp.EntityResourceFactory());
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
		return "entity.resource.entity.ui.launchConfigurationType";
	}
	
	public entity.resource.entity.IEntityNameProvider createNameProvider() {
		return new entity.resource.entity.analysis.EntityDefaultNameProvider();
	}
	
	public String[] getSyntaxHighlightableTokenNames() {
		entity.resource.entity.mopp.EntityAntlrTokenHelper tokenHelper = new entity.resource.entity.mopp.EntityAntlrTokenHelper();
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
		highlightableTokens.add(entity.resource.entity.mopp.EntityTokenStyleInformationProvider.TASK_ITEM_TOKEN_NAME);
		return highlightableTokens.toArray(new String[highlightableTokens.size()]);
	}
	
}
