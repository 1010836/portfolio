/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package baserequirements.resource.baserequirements.grammar;

/**
 * A class to represent placeholders in a grammar.
 */
public class BaserequirementsPlaceholder extends baserequirements.resource.baserequirements.grammar.BaserequirementsTerminal {
	
	private final String tokenName;
	
	public BaserequirementsPlaceholder(org.eclipse.emf.ecore.EStructuralFeature feature, String tokenName, baserequirements.resource.baserequirements.grammar.BaserequirementsCardinality cardinality, int mandatoryOccurencesAfter) {
		super(feature, cardinality, mandatoryOccurencesAfter);
		this.tokenName = tokenName;
	}
	
	public String getTokenName() {
		return tokenName;
	}
	
}
