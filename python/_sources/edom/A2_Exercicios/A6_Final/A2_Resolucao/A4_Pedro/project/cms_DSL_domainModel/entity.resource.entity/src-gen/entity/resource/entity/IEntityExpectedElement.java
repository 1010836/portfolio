/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package entity.resource.entity;

/**
 * An element that is expected at a given position in a resource stream.
 */
public interface IEntityExpectedElement {
	
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
	public entity.resource.entity.grammar.EntitySyntaxElement getSymtaxElement();
	
	/**
	 * Adds an element that is a valid follower for this element.
	 */
	public void addFollower(entity.resource.entity.IEntityExpectedElement follower, entity.resource.entity.mopp.EntityContainedFeature[] path);
	
	/**
	 * Returns all valid followers for this element. Each follower is represented by a
	 * pair of an expected elements and the containment trace that leads from the
	 * current element to the follower.
	 */
	public java.util.Collection<entity.resource.entity.util.EntityPair<entity.resource.entity.IEntityExpectedElement, entity.resource.entity.mopp.EntityContainedFeature[]>> getFollowers();
	
}
