/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package baserequirements.resource.baserequirements.mopp;

/**
 * The BaserequirementsTokenResolverFactory class provides access to all generated
 * token resolvers. By giving the name of a defined token, the corresponding
 * resolve can be obtained. Despite the fact that this class is called
 * TokenResolverFactory is does NOT create new token resolvers whenever a client
 * calls methods to obtain a resolver. Rather, this class maintains a map of all
 * resolvers and creates each resolver at most once.
 */
public class BaserequirementsTokenResolverFactory implements baserequirements.resource.baserequirements.IBaserequirementsTokenResolverFactory {
	
	private java.util.Map<String, baserequirements.resource.baserequirements.IBaserequirementsTokenResolver> tokenName2TokenResolver;
	private java.util.Map<String, baserequirements.resource.baserequirements.IBaserequirementsTokenResolver> featureName2CollectInTokenResolver;
	private static baserequirements.resource.baserequirements.IBaserequirementsTokenResolver defaultResolver = new baserequirements.resource.baserequirements.analysis.BaserequirementsDefaultTokenResolver();
	
	public BaserequirementsTokenResolverFactory() {
		tokenName2TokenResolver = new java.util.LinkedHashMap<String, baserequirements.resource.baserequirements.IBaserequirementsTokenResolver>();
		featureName2CollectInTokenResolver = new java.util.LinkedHashMap<String, baserequirements.resource.baserequirements.IBaserequirementsTokenResolver>();
		registerTokenResolver("TEXT", new baserequirements.resource.baserequirements.analysis.BaserequirementsTEXTTokenResolver());
		registerTokenResolver("QUOTED_34_34", new baserequirements.resource.baserequirements.analysis.BaserequirementsQUOTED_34_34TokenResolver());
	}
	
	public baserequirements.resource.baserequirements.IBaserequirementsTokenResolver createTokenResolver(String tokenName) {
		return internalCreateResolver(tokenName2TokenResolver, tokenName);
	}
	
	public baserequirements.resource.baserequirements.IBaserequirementsTokenResolver createCollectInTokenResolver(String featureName) {
		return internalCreateResolver(featureName2CollectInTokenResolver, featureName);
	}
	
	protected boolean registerTokenResolver(String tokenName, baserequirements.resource.baserequirements.IBaserequirementsTokenResolver resolver){
		return internalRegisterTokenResolver(tokenName2TokenResolver, tokenName, resolver);
	}
	
	protected boolean registerCollectInTokenResolver(String featureName, baserequirements.resource.baserequirements.IBaserequirementsTokenResolver resolver){
		return internalRegisterTokenResolver(featureName2CollectInTokenResolver, featureName, resolver);
	}
	
	protected baserequirements.resource.baserequirements.IBaserequirementsTokenResolver deRegisterTokenResolver(String tokenName){
		return tokenName2TokenResolver.remove(tokenName);
	}
	
	private baserequirements.resource.baserequirements.IBaserequirementsTokenResolver internalCreateResolver(java.util.Map<String, baserequirements.resource.baserequirements.IBaserequirementsTokenResolver> resolverMap, String key) {
		if (resolverMap.containsKey(key)){
			return resolverMap.get(key);
		} else {
			return defaultResolver;
		}
	}
	
	private boolean internalRegisterTokenResolver(java.util.Map<String, baserequirements.resource.baserequirements.IBaserequirementsTokenResolver> resolverMap, String key, baserequirements.resource.baserequirements.IBaserequirementsTokenResolver resolver) {
		if (!resolverMap.containsKey(key)) {
			resolverMap.put(key,resolver);
			return true;
		}
		return false;
	}
	
}
