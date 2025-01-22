/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package baserequirements.resource.baserequirements.mopp;

/**
 * A representation for a range in a document where a structural feature (e.g., a
 * reference) is expected.
 */
public class BaserequirementsExpectedStructuralFeature extends baserequirements.resource.baserequirements.mopp.BaserequirementsAbstractExpectedElement {
	
	private baserequirements.resource.baserequirements.grammar.BaserequirementsPlaceholder placeholder;
	
	public BaserequirementsExpectedStructuralFeature(baserequirements.resource.baserequirements.grammar.BaserequirementsPlaceholder placeholder) {
		super(placeholder.getMetaclass());
		this.placeholder = placeholder;
	}
	
	public org.eclipse.emf.ecore.EStructuralFeature getFeature() {
		return placeholder.getFeature();
	}
	
	/**
	 * Returns the expected placeholder.
	 */
	public baserequirements.resource.baserequirements.grammar.BaserequirementsSyntaxElement getSymtaxElement() {
		return placeholder;
	}
	
	public String getTokenName() {
		return placeholder.getTokenName();
	}
	
	public java.util.Set<String> getTokenNames() {
		return java.util.Collections.singleton(getTokenName());
	}
	
	public String toString() {
		return "EFeature " + getFeature().getEContainingClass().getName() + "." + getFeature().getName();
	}
	
	public boolean equals(Object o) {
		if (o instanceof BaserequirementsExpectedStructuralFeature) {
			return getFeature().equals(((BaserequirementsExpectedStructuralFeature) o).getFeature());
		}
		return false;
	}
	@Override	
	public int hashCode() {
		return getFeature().hashCode();
	}
	
}
