/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package baserequirements.resource.baserequirements.grammar;

/**
 * A class to represent a keyword in the grammar.
 */
public class BaserequirementsKeyword extends baserequirements.resource.baserequirements.grammar.BaserequirementsSyntaxElement {
	
	private final String value;
	
	public BaserequirementsKeyword(String value, baserequirements.resource.baserequirements.grammar.BaserequirementsCardinality cardinality) {
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
