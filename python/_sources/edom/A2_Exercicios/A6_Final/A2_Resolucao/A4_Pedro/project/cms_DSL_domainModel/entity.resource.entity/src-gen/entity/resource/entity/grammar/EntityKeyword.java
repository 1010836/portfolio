/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package entity.resource.entity.grammar;

/**
 * A class to represent a keyword in the grammar.
 */
public class EntityKeyword extends entity.resource.entity.grammar.EntitySyntaxElement {
	
	private final String value;
	
	public EntityKeyword(String value, entity.resource.entity.grammar.EntityCardinality cardinality) {
		super(cardinality, null);
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
	public String toString() {
		return value;
	}
	
}
