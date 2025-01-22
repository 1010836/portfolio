/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package baserequirements.resource.baserequirements.grammar;

public class BaserequirementsSequence extends baserequirements.resource.baserequirements.grammar.BaserequirementsSyntaxElement {
	
	public BaserequirementsSequence(baserequirements.resource.baserequirements.grammar.BaserequirementsCardinality cardinality, baserequirements.resource.baserequirements.grammar.BaserequirementsSyntaxElement... elements) {
		super(cardinality, elements);
	}
	
	public String toString() {
		return baserequirements.resource.baserequirements.util.BaserequirementsStringUtil.explode(getChildren(), " ");
	}
	
}
