/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package entity.resource.entity.grammar;

public class EntitySequence extends entity.resource.entity.grammar.EntitySyntaxElement {
	
	public EntitySequence(entity.resource.entity.grammar.EntityCardinality cardinality, entity.resource.entity.grammar.EntitySyntaxElement... elements) {
		super(cardinality, elements);
	}
	
	public String toString() {
		return entity.resource.entity.util.EntityStringUtil.explode(getChildren(), " ");
	}
	
}
