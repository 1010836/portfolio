/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package baserequirements.resource.baseRequirements.grammar;

public class BaseRequirementsSequence extends baserequirements.resource.baseRequirements.grammar.BaseRequirementsSyntaxElement {
	
	public BaseRequirementsSequence(baserequirements.resource.baseRequirements.grammar.BaseRequirementsCardinality cardinality, baserequirements.resource.baseRequirements.grammar.BaseRequirementsSyntaxElement... elements) {
		super(cardinality, elements);
	}
	
	public String toString() {
		return baserequirements.resource.baseRequirements.util.BaseRequirementsStringUtil.explode(getChildren(), " ");
	}
	
}
