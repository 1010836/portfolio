/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package entity.resource.entity.grammar;

public class EntityChoice extends entity.resource.entity.grammar.EntitySyntaxElement {
	
	public EntityChoice(entity.resource.entity.grammar.EntityCardinality cardinality, entity.resource.entity.grammar.EntitySyntaxElement... choices) {
		super(cardinality, choices);
	}
	
	public String toString() {
		return entity.resource.entity.util.EntityStringUtil.explode(getChildren(), "|");
	}
	
}
