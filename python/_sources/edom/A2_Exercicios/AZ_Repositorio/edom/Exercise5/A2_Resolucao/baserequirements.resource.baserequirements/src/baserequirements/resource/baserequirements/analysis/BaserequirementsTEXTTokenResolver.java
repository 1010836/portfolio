/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package baserequirements.resource.baserequirements.analysis;

public class BaserequirementsTEXTTokenResolver implements baserequirements.resource.baserequirements.IBaserequirementsTokenResolver {
	
	private baserequirements.resource.baserequirements.analysis.BaserequirementsDefaultTokenResolver defaultTokenResolver = new baserequirements.resource.baserequirements.analysis.BaserequirementsDefaultTokenResolver(true);
	
	public String deResolve(Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		// By default token de-resolving is delegated to the DefaultTokenResolver.
		String result = defaultTokenResolver.deResolve(value, feature, container, null, null, null);
		return result;
	}
	
	public void resolve(String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, baserequirements.resource.baserequirements.IBaserequirementsTokenResolveResult result) {
		// By default token resolving is delegated to the DefaultTokenResolver.
		defaultTokenResolver.resolve(lexem, feature, result, null, null, null);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
