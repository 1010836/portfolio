/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package baserequirements.resource.baserequirements.grammar;

public class BaserequirementsCompound extends baserequirements.resource.baserequirements.grammar.BaserequirementsSyntaxElement {
	
	public BaserequirementsCompound(baserequirements.resource.baserequirements.grammar.BaserequirementsChoice choice, baserequirements.resource.baserequirements.grammar.BaserequirementsCardinality cardinality) {
		super(cardinality, new baserequirements.resource.baserequirements.grammar.BaserequirementsSyntaxElement[] {choice});
	}
	
	public String toString() {
		return "(" + getChildren()[0] + ")";
	}
	
}
