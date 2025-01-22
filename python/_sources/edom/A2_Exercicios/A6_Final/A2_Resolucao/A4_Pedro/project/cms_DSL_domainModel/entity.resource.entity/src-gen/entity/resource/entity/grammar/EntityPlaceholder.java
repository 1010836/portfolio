/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package entity.resource.entity.grammar;

/**
 * A class to represent placeholders in a grammar.
 */
public class EntityPlaceholder extends entity.resource.entity.grammar.EntityTerminal {
	
	private final String tokenName;
	
	public EntityPlaceholder(org.eclipse.emf.ecore.EStructuralFeature feature, String tokenName, entity.resource.entity.grammar.EntityCardinality cardinality, int mandatoryOccurencesAfter) {
		super(feature, cardinality, mandatoryOccurencesAfter);
		this.tokenName = tokenName;
	}
	
	public String getTokenName() {
		return tokenName;
	}
	
}
