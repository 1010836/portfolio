/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package entity.resource.entity.grammar;

/**
 * A class to represent a rules in the grammar.
 */
public class EntityRule extends entity.resource.entity.grammar.EntitySyntaxElement {
	
	private final org.eclipse.emf.ecore.EClass metaclass;
	
	public EntityRule(org.eclipse.emf.ecore.EClass metaclass, entity.resource.entity.grammar.EntityChoice choice, entity.resource.entity.grammar.EntityCardinality cardinality) {
		super(cardinality, new entity.resource.entity.grammar.EntitySyntaxElement[] {choice});
		this.metaclass = metaclass;
	}
	
	public org.eclipse.emf.ecore.EClass getMetaclass() {
		return metaclass;
	}
	
	public entity.resource.entity.grammar.EntityChoice getDefinition() {
		return (entity.resource.entity.grammar.EntityChoice) getChildren()[0];
	}
	
}

