/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package baserequirements.resource.baserequirements.grammar;

public class BaserequirementsWhiteSpace extends baserequirements.resource.baserequirements.grammar.BaserequirementsFormattingElement {
	
	private final int amount;
	
	public BaserequirementsWhiteSpace(int amount, baserequirements.resource.baserequirements.grammar.BaserequirementsCardinality cardinality) {
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
