/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package baserequirements.resource.baserequirements.grammar;

public class BaserequirementsChoice extends baserequirements.resource.baserequirements.grammar.BaserequirementsSyntaxElement {
	
	public BaserequirementsChoice(baserequirements.resource.baserequirements.grammar.BaserequirementsCardinality cardinality, baserequirements.resource.baserequirements.grammar.BaserequirementsSyntaxElement... choices) {
		super(cardinality, choices);
	}
	
	public String toString() {
		return baserequirements.resource.baserequirements.util.BaserequirementsStringUtil.explode(getChildren(), "|");
	}
	
}
