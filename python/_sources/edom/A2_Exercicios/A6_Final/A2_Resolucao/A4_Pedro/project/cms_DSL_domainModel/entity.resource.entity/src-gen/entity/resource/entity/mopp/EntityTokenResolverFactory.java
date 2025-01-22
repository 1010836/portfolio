/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package entity.resource.entity.mopp;

/**
 * The EntityTokenResolverFactory class provides access to all generated token
 * resolvers. By giving the name of a defined token, the corresponding resolve can
 * be obtained. Despite the fact that this class is called TokenResolverFactory is
 * does NOT create new token resolvers whenever a client calls methods to obtain a
 * resolver. Rather, this class maintains a map of all resolvers and creates each
 * resolver at most once.
 */
public class EntityTokenResolverFactory implements entity.resource.entity.IEntityTokenResolverFactory {
	
	private java.util.Map<String, entity.resource.entity.IEntityTokenResolver> tokenName2TokenResolver;
	private java.util.Map<String, entity.resource.entity.IEntityTokenResolver> featureName2CollectInTokenResolver;
	private static entity.resource.entity.IEntityTokenResolver defaultResolver = new entity.resource.entity.analysis.EntityDefaultTokenResolver();
	
	public EntityTokenResolverFactory() {
		tokenName2TokenResolver = new java.util.LinkedHashMap<String, entity.resource.entity.IEntityTokenResolver>();
		featureName2CollectInTokenResolver = new java.util.LinkedHashMap<String, entity.resource.entity.IEntityTokenResolver>();
		registerTokenResolver("TEXT", new entity.resource.entity.analysis.EntityTEXTTokenResolver());
		registerTokenResolver("QUOTED_34_34", new entity.resource.entity.analysis.EntityQUOTED_34_34TokenResolver());
	}
	
	public entity.resource.entity.IEntityTokenResolver createTokenResolver(String tokenName) {
		return internalCreateResolver(tokenName2TokenResolver, tokenName);
	}
	
	public entity.resource.entity.IEntityTokenResolver createCollectInTokenResolver(String featureName) {
		return internalCreateResolver(featureName2CollectInTokenResolver, featureName);
	}
	
	protected boolean registerTokenResolver(String tokenName, entity.resource.entity.IEntityTokenResolver resolver){
		return internalRegisterTokenResolver(tokenName2TokenResolver, tokenName, resolver);
	}
	
	protected boolean registerCollectInTokenResolver(String featureName, entity.resource.entity.IEntityTokenResolver resolver){
		return internalRegisterTokenResolver(featureName2CollectInTokenResolver, featureName, resolver);
	}
	
	protected entity.resource.entity.IEntityTokenResolver deRegisterTokenResolver(String tokenName){
		return tokenName2TokenResolver.remove(tokenName);
	}
	
	private entity.resource.entity.IEntityTokenResolver internalCreateResolver(java.util.Map<String, entity.resource.entity.IEntityTokenResolver> resolverMap, String key) {
		if (resolverMap.containsKey(key)){
			return resolverMap.get(key);
		} else {
			return defaultResolver;
		}
	}
	
	private boolean internalRegisterTokenResolver(java.util.Map<String, entity.resource.entity.IEntityTokenResolver> resolverMap, String key, entity.resource.entity.IEntityTokenResolver resolver) {
		if (!resolverMap.containsKey(key)) {
			resolverMap.put(key,resolver);
			return true;
		}
		return false;
	}
	
}
