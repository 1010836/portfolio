/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package baserequirements.resource.baseRequirements.analysis;

public class BaseRequirementsQUOTED_34_34TokenResolver implements baserequirements.resource.baseRequirements.IBaseRequirementsTokenResolver {
	
	private baserequirements.resource.baseRequirements.analysis.BaseRequirementsDefaultTokenResolver defaultTokenResolver = new baserequirements.resource.baseRequirements.analysis.BaseRequirementsDefaultTokenResolver(true);
	
	public String deResolve(Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		// By default token de-resolving is delegated to the DefaultTokenResolver.
		String result = defaultTokenResolver.deResolve(value, feature, container, "\"", "\"", null);
		return result;
	}
	
	public void resolve(String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, baserequirements.resource.baseRequirements.IBaseRequirementsTokenResolveResult result) {
		// By default token resolving is delegated to the DefaultTokenResolver.
		defaultTokenResolver.resolve(lexem, feature, result, "\"", "\"", null);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
