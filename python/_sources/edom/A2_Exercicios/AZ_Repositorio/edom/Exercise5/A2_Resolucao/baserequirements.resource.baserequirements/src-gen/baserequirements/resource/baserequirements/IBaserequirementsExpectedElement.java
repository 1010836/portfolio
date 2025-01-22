/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package baserequirements.resource.baserequirements;

/**
 * An element that is expected at a given position in a resource stream.
 */
public interface IBaserequirementsExpectedElement {
	
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
	public baserequirements.resource.baserequirements.grammar.BaserequirementsSyntaxElement getSymtaxElement();
	
	/**
	 * Adds an element that is a valid follower for this element.
	 */
	public void addFollower(baserequirements.resource.baserequirements.IBaserequirementsExpectedElement follower, baserequirements.resource.baserequirements.mopp.BaserequirementsContainedFeature[] path);
	
	/**
	 * Returns all valid followers for this element. Each follower is represented by a
	 * pair of an expected elements and the containment trace that leads from the
	 * current element to the follower.
	 */
	public java.util.Collection<baserequirements.resource.baserequirements.util.BaserequirementsPair<baserequirements.resource.baserequirements.IBaserequirementsExpectedElement, baserequirements.resource.baserequirements.mopp.BaserequirementsContainedFeature[]>> getFollowers();
	
}
