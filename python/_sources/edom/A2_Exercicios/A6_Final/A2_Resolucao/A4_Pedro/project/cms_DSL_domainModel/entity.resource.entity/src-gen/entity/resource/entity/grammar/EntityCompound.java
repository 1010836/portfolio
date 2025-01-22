/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package entity.resource.entity.grammar;

public class EntityCompound extends entity.resource.entity.grammar.EntitySyntaxElement {
	
	public EntityCompound(entity.resource.entity.grammar.EntityChoice choice, entity.resource.entity.grammar.EntityCardinality cardinality) {
		super(cardinality, new entity.resource.entity.grammar.EntitySyntaxElement[] {choice});
	}
	
	public String toString() {
		return "(" + getChildren()[0] + ")";
	}
	
}
