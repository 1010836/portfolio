/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package baserequirements.resource.baserequirements.grammar;

/**
 * The abstract super class for all elements of a grammar. This class provides
 * methods to traverse the grammar rules.
 */
public abstract class BaserequirementsSyntaxElement {
	
	private BaserequirementsSyntaxElement[] children;
	private BaserequirementsSyntaxElement parent;
	private baserequirements.resource.baserequirements.grammar.BaserequirementsCardinality cardinality;
	
	public BaserequirementsSyntaxElement(baserequirements.resource.baserequirements.grammar.BaserequirementsCardinality cardinality, BaserequirementsSyntaxElement[] children) {
		this.cardinality = cardinality;
		this.children = children;
		if (this.children != null) {
			for (BaserequirementsSyntaxElement child : this.children) {
				child.setParent(this);
			}
		}
	}
	
	/**
	 * Sets the parent of this syntax element. This method must be invoked at most
	 * once.
	 */
	public void setParent(BaserequirementsSyntaxElement parent) {
		assert this.parent == null;
		this.parent = parent;
	}
	
	/**
	 * Returns the parent of this syntax element. This parent is determined by the
	 * containment hierarchy in the CS model.
	 */
	public BaserequirementsSyntaxElement getParent() {
		return parent;
	}
	
	public BaserequirementsSyntaxElement[] getChildren() {
		if (children == null) {
			return new BaserequirementsSyntaxElement[0];
		}
		return children;
	}
	
	public org.eclipse.emf.ecore.EClass getMetaclass() {
		return parent.getMetaclass();
	}
	
	public baserequirements.resource.baserequirements.grammar.BaserequirementsCardinality getCardinality() {
		return cardinality;
	}
	
}
