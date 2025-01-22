/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package baserequirements.resource.baseRequirements.mopp;

/**
 * Abstract super class for all expected elements. Provides methods to add
 * followers.
 */
public abstract class BaseRequirementsAbstractExpectedElement implements baserequirements.resource.baseRequirements.IBaseRequirementsExpectedElement {
	
	private org.eclipse.emf.ecore.EClass ruleMetaclass;
	
	private java.util.Set<baserequirements.resource.baseRequirements.util.BaseRequirementsPair<baserequirements.resource.baseRequirements.IBaseRequirementsExpectedElement, baserequirements.resource.baseRequirements.mopp.BaseRequirementsContainedFeature[]>> followers = new java.util.LinkedHashSet<baserequirements.resource.baseRequirements.util.BaseRequirementsPair<baserequirements.resource.baseRequirements.IBaseRequirementsExpectedElement, baserequirements.resource.baseRequirements.mopp.BaseRequirementsContainedFeature[]>>();
	
	public BaseRequirementsAbstractExpectedElement(org.eclipse.emf.ecore.EClass ruleMetaclass) {
		super();
		this.ruleMetaclass = ruleMetaclass;
	}
	
	public org.eclipse.emf.ecore.EClass getRuleMetaclass() {
		return ruleMetaclass;
	}
	
	public void addFollower(baserequirements.resource.baseRequirements.IBaseRequirementsExpectedElement follower, baserequirements.resource.baseRequirements.mopp.BaseRequirementsContainedFeature[] path) {
		followers.add(new baserequirements.resource.baseRequirements.util.BaseRequirementsPair<baserequirements.resource.baseRequirements.IBaseRequirementsExpectedElement, baserequirements.resource.baseRequirements.mopp.BaseRequirementsContainedFeature[]>(follower, path));
	}
	
	public java.util.Collection<baserequirements.resource.baseRequirements.util.BaseRequirementsPair<baserequirements.resource.baseRequirements.IBaseRequirementsExpectedElement, baserequirements.resource.baseRequirements.mopp.BaseRequirementsContainedFeature[]>> getFollowers() {
		return followers;
	}
	
}
