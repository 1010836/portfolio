/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package baserequirements.resource.baseRequirements.grammar;

public class BaseRequirementsChoice extends baserequirements.resource.baseRequirements.grammar.BaseRequirementsSyntaxElement {
	
	public BaseRequirementsChoice(baserequirements.resource.baseRequirements.grammar.BaseRequirementsCardinality cardinality, baserequirements.resource.baseRequirements.grammar.BaseRequirementsSyntaxElement... choices) {
		super(cardinality, choices);
	}
	
	public String toString() {
		return baserequirements.resource.baseRequirements.util.BaseRequirementsStringUtil.explode(getChildren(), "|");
	}
	
}
