/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package baserequirements.resource.baseRequirements.grammar;

/**
 * A class to represent a keyword in the grammar.
 */
public class BaseRequirementsKeyword extends baserequirements.resource.baseRequirements.grammar.BaseRequirementsSyntaxElement {
	
	private final String value;
	
	public BaseRequirementsKeyword(String value, baserequirements.resource.baseRequirements.grammar.BaseRequirementsCardinality cardinality) {
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
