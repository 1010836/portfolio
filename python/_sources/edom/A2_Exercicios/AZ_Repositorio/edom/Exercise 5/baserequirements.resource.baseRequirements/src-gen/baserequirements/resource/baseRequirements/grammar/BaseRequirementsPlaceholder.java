/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package baserequirements.resource.baseRequirements.grammar;

/**
 * A class to represent placeholders in a grammar.
 */
public class BaseRequirementsPlaceholder extends baserequirements.resource.baseRequirements.grammar.BaseRequirementsTerminal {
	
	private final String tokenName;
	
	public BaseRequirementsPlaceholder(org.eclipse.emf.ecore.EStructuralFeature feature, String tokenName, baserequirements.resource.baseRequirements.grammar.BaseRequirementsCardinality cardinality, int mandatoryOccurencesAfter) {
		super(feature, cardinality, mandatoryOccurencesAfter);
		this.tokenName = tokenName;
	}
	
	public String getTokenName() {
		return tokenName;
	}
	
}
