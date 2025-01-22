/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package baserequirements.resource.baseRequirements.grammar;

public class BaseRequirementsCompound extends baserequirements.resource.baseRequirements.grammar.BaseRequirementsSyntaxElement {
	
	public BaseRequirementsCompound(baserequirements.resource.baseRequirements.grammar.BaseRequirementsChoice choice, baserequirements.resource.baseRequirements.grammar.BaseRequirementsCardinality cardinality) {
		super(cardinality, new baserequirements.resource.baseRequirements.grammar.BaseRequirementsSyntaxElement[] {choice});
	}
	
	public String toString() {
		return "(" + getChildren()[0] + ")";
	}
	
}
