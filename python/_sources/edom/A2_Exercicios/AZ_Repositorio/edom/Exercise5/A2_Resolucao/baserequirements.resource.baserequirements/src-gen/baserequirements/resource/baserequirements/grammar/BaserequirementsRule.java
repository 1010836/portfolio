/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package baserequirements.resource.baserequirements.grammar;

/**
 * A class to represent a rules in the grammar.
 */
public class BaserequirementsRule extends baserequirements.resource.baserequirements.grammar.BaserequirementsSyntaxElement {
	
	private final org.eclipse.emf.ecore.EClass metaclass;
	
	public BaserequirementsRule(org.eclipse.emf.ecore.EClass metaclass, baserequirements.resource.baserequirements.grammar.BaserequirementsChoice choice, baserequirements.resource.baserequirements.grammar.BaserequirementsCardinality cardinality) {
		super(cardinality, new baserequirements.resource.baserequirements.grammar.BaserequirementsSyntaxElement[] {choice});
		this.metaclass = metaclass;
	}
	
	public org.eclipse.emf.ecore.EClass getMetaclass() {
		return metaclass;
	}
	
	public baserequirements.resource.baserequirements.grammar.BaserequirementsChoice getDefinition() {
		return (baserequirements.resource.baserequirements.grammar.BaserequirementsChoice) getChildren()[0];
	}
	
}

