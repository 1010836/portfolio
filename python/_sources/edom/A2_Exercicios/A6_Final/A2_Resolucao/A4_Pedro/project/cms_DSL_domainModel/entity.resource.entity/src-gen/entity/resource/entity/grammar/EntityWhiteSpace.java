/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package entity.resource.entity.grammar;

public class EntityWhiteSpace extends entity.resource.entity.grammar.EntityFormattingElement {
	
	private final int amount;
	
	public EntityWhiteSpace(int amount, entity.resource.entity.grammar.EntityCardinality cardinality) {
		super(cardinality);
		this.amount = amount;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public String toString() {
		return "#" + getAmount();
	}
	
}
