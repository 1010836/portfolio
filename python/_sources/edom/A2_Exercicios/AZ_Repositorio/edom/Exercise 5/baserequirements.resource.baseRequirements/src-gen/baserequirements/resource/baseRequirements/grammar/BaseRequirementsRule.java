/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package baserequirements.resource.baseRequirements.grammar;

/**
 * A class to represent a rules in the grammar.
 */
public class BaseRequirementsRule extends baserequirements.resource.baseRequirements.grammar.BaseRequirementsSyntaxElement {
	
	private final org.eclipse.emf.ecore.EClass metaclass;
	
	public BaseRequirementsRule(org.eclipse.emf.ecore.EClass metaclass, baserequirements.resource.baseRequirements.grammar.BaseRequirementsChoice choice, baserequirements.resource.baseRequirements.grammar.BaseRequirementsCardinality cardinality) {
		super(cardinality, new baserequirements.resource.baseRequirements.grammar.BaseRequirementsSyntaxElement[] {choice});
		this.metaclass = metaclass;
	}
	
	public org.eclipse.emf.ecore.EClass getMetaclass() {
		return metaclass;
	}
	
	public baserequirements.resource.baseRequirements.grammar.BaseRequirementsChoice getDefinition() {
		return (baserequirements.resource.baseRequirements.grammar.BaseRequirementsChoice) getChildren()[0];
	}
	
}

