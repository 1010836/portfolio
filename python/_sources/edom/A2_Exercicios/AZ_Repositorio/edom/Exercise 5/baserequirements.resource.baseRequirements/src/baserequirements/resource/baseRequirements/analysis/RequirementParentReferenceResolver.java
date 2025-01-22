/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package baserequirements.resource.baseRequirements.analysis;

public class RequirementParentReferenceResolver implements baserequirements.resource.baseRequirements.IBaseRequirementsReferenceResolver<baserequirements.Requirement, baserequirements.Requirement> {
	
	private baserequirements.resource.baseRequirements.analysis.BaseRequirementsDefaultResolverDelegate<baserequirements.Requirement, baserequirements.Requirement> delegate = new baserequirements.resource.baseRequirements.analysis.BaseRequirementsDefaultResolverDelegate<baserequirements.Requirement, baserequirements.Requirement>();
	
	public void resolve(String identifier, baserequirements.Requirement container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final baserequirements.resource.baseRequirements.IBaseRequirementsReferenceResolveResult<baserequirements.Requirement> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public String deResolve(baserequirements.Requirement element, baserequirements.Requirement container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
