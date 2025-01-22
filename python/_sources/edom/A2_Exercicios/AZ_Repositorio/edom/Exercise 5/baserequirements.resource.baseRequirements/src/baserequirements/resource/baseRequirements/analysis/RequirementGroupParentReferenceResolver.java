/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package baserequirements.resource.baseRequirements.analysis;

public class RequirementGroupParentReferenceResolver implements baserequirements.resource.baseRequirements.IBaseRequirementsReferenceResolver<baserequirements.RequirementGroup, baserequirements.RequirementGroup> {
	
	private baserequirements.resource.baseRequirements.analysis.BaseRequirementsDefaultResolverDelegate<baserequirements.RequirementGroup, baserequirements.RequirementGroup> delegate = new baserequirements.resource.baseRequirements.analysis.BaseRequirementsDefaultResolverDelegate<baserequirements.RequirementGroup, baserequirements.RequirementGroup>();
	
	public void resolve(String identifier, baserequirements.RequirementGroup container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final baserequirements.resource.baseRequirements.IBaseRequirementsReferenceResolveResult<baserequirements.RequirementGroup> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public String deResolve(baserequirements.RequirementGroup element, baserequirements.RequirementGroup container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
