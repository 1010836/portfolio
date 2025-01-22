/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package entity.resource.entity.grammar;

/**
 * The abstract super class for all elements of a grammar. This class provides
 * methods to traverse the grammar rules.
 */
public abstract class EntitySyntaxElement {
	
	private EntitySyntaxElement[] children;
	private EntitySyntaxElement parent;
	private entity.resource.entity.grammar.EntityCardinality cardinality;
	
	public EntitySyntaxElement(entity.resource.entity.grammar.EntityCardinality cardinality, EntitySyntaxElement[] children) {
		this.cardinality = cardinality;
		this.children = children;
		if (this.children != null) {
			for (EntitySyntaxElement child : this.children) {
				child.setParent(this);
			}
		}
	}
	
	/**
	 * Sets the parent of this syntax element. This method must be invoked at most
	 * once.
	 */
	public void setParent(EntitySyntaxElement parent) {
		assert this.parent == null;
		this.parent = parent;
	}
	
	/**
	 * Returns the parent of this syntax element. This parent is determined by the
	 * containment hierarchy in the CS model.
	 */
	public EntitySyntaxElement getParent() {
		return parent;
	}
	
	public EntitySyntaxElement[] getChildren() {
		if (children == null) {
			return new EntitySyntaxElement[0];
		}
		return children;
	}
	
	public org.eclipse.emf.ecore.EClass getMetaclass() {
		return parent.getMetaclass();
	}
	
	public entity.resource.entity.grammar.EntityCardinality getCardinality() {
		return cardinality;
	}
	
}
