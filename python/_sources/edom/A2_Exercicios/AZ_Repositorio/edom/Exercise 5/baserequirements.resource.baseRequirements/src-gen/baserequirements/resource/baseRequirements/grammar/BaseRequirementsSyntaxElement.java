/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package baserequirements.resource.baseRequirements.grammar;

/**
 * The abstract super class for all elements of a grammar. This class provides
 * methods to traverse the grammar rules.
 */
public abstract class BaseRequirementsSyntaxElement {
	
	private BaseRequirementsSyntaxElement[] children;
	private BaseRequirementsSyntaxElement parent;
	private baserequirements.resource.baseRequirements.grammar.BaseRequirementsCardinality cardinality;
	
	public BaseRequirementsSyntaxElement(baserequirements.resource.baseRequirements.grammar.BaseRequirementsCardinality cardinality, BaseRequirementsSyntaxElement[] children) {
		this.cardinality = cardinality;
		this.children = children;
		if (this.children != null) {
			for (BaseRequirementsSyntaxElement child : this.children) {
				child.setParent(this);
			}
		}
	}
	
	/**
	 * Sets the parent of this syntax element. This method must be invoked at most
	 * once.
	 */
	public void setParent(BaseRequirementsSyntaxElement parent) {
		assert this.parent == null;
		this.parent = parent;
	}
	
	/**
	 * Returns the parent of this syntax element. This parent is determined by the
	 * containment hierarchy in the CS model.
	 */
	public BaseRequirementsSyntaxElement getParent() {
		return parent;
	}
	
	public BaseRequirementsSyntaxElement[] getChildren() {
		if (children == null) {
			return new BaseRequirementsSyntaxElement[0];
		}
		return children;
	}
	
	public org.eclipse.emf.ecore.EClass getMetaclass() {
		return parent.getMetaclass();
	}
	
	public baserequirements.resource.baseRequirements.grammar.BaseRequirementsCardinality getCardinality() {
		return cardinality;
	}
	
}
