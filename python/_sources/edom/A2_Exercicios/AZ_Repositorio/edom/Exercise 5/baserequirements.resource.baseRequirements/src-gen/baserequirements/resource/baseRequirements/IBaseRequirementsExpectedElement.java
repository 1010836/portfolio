/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package baserequirements.resource.baseRequirements;

/**
 * An element that is expected at a given position in a resource stream.
 */
public interface IBaseRequirementsExpectedElement {
	
	/**
	 * Returns the names of all tokens that are expected at the given position.
	 */
	public java.util.Set<String> getTokenNames();
	
	/**
	 * Returns the metaclass of the rule that contains the expected element.
	 */
	public org.eclipse.emf.ecore.EClass getRuleMetaclass();
	
	/**
	 * Returns the syntax element that is expected.
	 */
	public baserequirements.resource.baseRequirements.grammar.BaseRequirementsSyntaxElement getSymtaxElement();
	
	/**
	 * Adds an element that is a valid follower for this element.
	 */
	public void addFollower(baserequirements.resource.baseRequirements.IBaseRequirementsExpectedElement follower, baserequirements.resource.baseRequirements.mopp.BaseRequirementsContainedFeature[] path);
	
	/**
	 * Returns all valid followers for this element. Each follower is represented by a
	 * pair of an expected elements and the containment trace that leads from the
	 * current element to the follower.
	 */
	public java.util.Collection<baserequirements.resource.baseRequirements.util.BaseRequirementsPair<baserequirements.resource.baseRequirements.IBaseRequirementsExpectedElement, baserequirements.resource.baseRequirements.mopp.BaseRequirementsContainedFeature[]>> getFollowers();
	
}
