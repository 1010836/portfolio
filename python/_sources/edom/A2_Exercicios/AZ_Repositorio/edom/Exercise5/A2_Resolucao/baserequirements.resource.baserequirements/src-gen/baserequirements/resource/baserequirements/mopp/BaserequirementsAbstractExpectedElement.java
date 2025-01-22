/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package baserequirements.resource.baserequirements.mopp;

/**
 * Abstract super class for all expected elements. Provides methods to add
 * followers.
 */
public abstract class BaserequirementsAbstractExpectedElement implements baserequirements.resource.baserequirements.IBaserequirementsExpectedElement {
	
	private org.eclipse.emf.ecore.EClass ruleMetaclass;
	
	private java.util.Set<baserequirements.resource.baserequirements.util.BaserequirementsPair<baserequirements.resource.baserequirements.IBaserequirementsExpectedElement, baserequirements.resource.baserequirements.mopp.BaserequirementsContainedFeature[]>> followers = new java.util.LinkedHashSet<baserequirements.resource.baserequirements.util.BaserequirementsPair<baserequirements.resource.baserequirements.IBaserequirementsExpectedElement, baserequirements.resource.baserequirements.mopp.BaserequirementsContainedFeature[]>>();
	
	public BaserequirementsAbstractExpectedElement(org.eclipse.emf.ecore.EClass ruleMetaclass) {
		super();
		this.ruleMetaclass = ruleMetaclass;
	}
	
	public org.eclipse.emf.ecore.EClass getRuleMetaclass() {
		return ruleMetaclass;
	}
	
	public void addFollower(baserequirements.resource.baserequirements.IBaserequirementsExpectedElement follower, baserequirements.resource.baserequirements.mopp.BaserequirementsContainedFeature[] path) {
		followers.add(new baserequirements.resource.baserequirements.util.BaserequirementsPair<baserequirements.resource.baserequirements.IBaserequirementsExpectedElement, baserequirements.resource.baserequirements.mopp.BaserequirementsContainedFeature[]>(follower, path));
	}
	
	public java.util.Collection<baserequirements.resource.baserequirements.util.BaserequirementsPair<baserequirements.resource.baserequirements.IBaserequirementsExpectedElement, baserequirements.resource.baserequirements.mopp.BaserequirementsContainedFeature[]>> getFollowers() {
		return followers;
	}
	
}
