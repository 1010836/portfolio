/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package baserequirements.resource.baseRequirements.grammar;

public class BaseRequirementsWhiteSpace extends baserequirements.resource.baseRequirements.grammar.BaseRequirementsFormattingElement {
	
	private final int amount;
	
	public BaseRequirementsWhiteSpace(int amount, baserequirements.resource.baseRequirements.grammar.BaseRequirementsCardinality cardinality) {
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
