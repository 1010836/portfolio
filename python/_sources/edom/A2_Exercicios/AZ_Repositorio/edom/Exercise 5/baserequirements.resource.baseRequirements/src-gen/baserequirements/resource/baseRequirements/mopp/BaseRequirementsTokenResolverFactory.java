/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package baserequirements.resource.baseRequirements.mopp;

/**
 * The BaseRequirementsTokenResolverFactory class provides access to all generated
 * token resolvers. By giving the name of a defined token, the corresponding
 * resolve can be obtained. Despite the fact that this class is called
 * TokenResolverFactory is does NOT create new token resolvers whenever a client
 * calls methods to obtain a resolver. Rather, this class maintains a map of all
 * resolvers and creates each resolver at most once.
 */
public class BaseRequirementsTokenResolverFactory implements baserequirements.resource.baseRequirements.IBaseRequirementsTokenResolverFactory {
	
	private java.util.Map<String, baserequirements.resource.baseRequirements.IBaseRequirementsTokenResolver> tokenName2TokenResolver;
	private java.util.Map<String, baserequirements.resource.baseRequirements.IBaseRequirementsTokenResolver> featureName2CollectInTokenResolver;
	private static baserequirements.resource.baseRequirements.IBaseRequirementsTokenResolver defaultResolver = new baserequirements.resource.baseRequirements.analysis.BaseRequirementsDefaultTokenResolver();
	
	public BaseRequirementsTokenResolverFactory() {
		tokenName2TokenResolver = new java.util.LinkedHashMap<String, baserequirements.resource.baseRequirements.IBaseRequirementsTokenResolver>();
		featureName2CollectInTokenResolver = new java.util.LinkedHashMap<String, baserequirements.resource.baseRequirements.IBaseRequirementsTokenResolver>();
		registerTokenResolver("TEXT", new baserequirements.resource.baseRequirements.analysis.BaseRequirementsTEXTTokenResolver());
		registerTokenResolver("QUOTED_34_34", new baserequirements.resource.baseRequirements.analysis.BaseRequirementsQUOTED_34_34TokenResolver());
	}
	
	public baserequirements.resource.baseRequirements.IBaseRequirementsTokenResolver createTokenResolver(String tokenName) {
		return internalCreateResolver(tokenName2TokenResolver, tokenName);
	}
	
	public baserequirements.resource.baseRequirements.IBaseRequirementsTokenResolver createCollectInTokenResolver(String featureName) {
		return internalCreateResolver(featureName2CollectInTokenResolver, featureName);
	}
	
	protected boolean registerTokenResolver(String tokenName, baserequirements.resource.baseRequirements.IBaseRequirementsTokenResolver resolver){
		return internalRegisterTokenResolver(tokenName2TokenResolver, tokenName, resolver);
	}
	
	protected boolean registerCollectInTokenResolver(String featureName, baserequirements.resource.baseRequirements.IBaseRequirementsTokenResolver resolver){
		return internalRegisterTokenResolver(featureName2CollectInTokenResolver, featureName, resolver);
	}
	
	protected baserequirements.resource.baseRequirements.IBaseRequirementsTokenResolver deRegisterTokenResolver(String tokenName){
		return tokenName2TokenResolver.remove(tokenName);
	}
	
	private baserequirements.resource.baseRequirements.IBaseRequirementsTokenResolver internalCreateResolver(java.util.Map<String, baserequirements.resource.baseRequirements.IBaseRequirementsTokenResolver> resolverMap, String key) {
		if (resolverMap.containsKey(key)){
			return resolverMap.get(key);
		} else {
			return defaultResolver;
		}
	}
	
	private boolean internalRegisterTokenResolver(java.util.Map<String, baserequirements.resource.baseRequirements.IBaseRequirementsTokenResolver> resolverMap, String key, baserequirements.resource.baseRequirements.IBaseRequirementsTokenResolver resolver) {
		if (!resolverMap.containsKey(key)) {
			resolverMap.put(key,resolver);
			return true;
		}
		return false;
	}
	
}
