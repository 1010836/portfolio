/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package baserequirements.resource.baseRequirements.mopp;

/**
 * A representation for a range in a document where a structural feature (e.g., a
 * reference) is expected.
 */
public class BaseRequirementsExpectedStructuralFeature extends baserequirements.resource.baseRequirements.mopp.BaseRequirementsAbstractExpectedElement {
	
	private baserequirements.resource.baseRequirements.grammar.BaseRequirementsPlaceholder placeholder;
	
	public BaseRequirementsExpectedStructuralFeature(baserequirements.resource.baseRequirements.grammar.BaseRequirementsPlaceholder placeholder) {
		super(placeholder.getMetaclass());
		this.placeholder = placeholder;
	}
	
	public org.eclipse.emf.ecore.EStructuralFeature getFeature() {
		return placeholder.getFeature();
	}
	
	/**
	 * Returns the expected placeholder.
	 */
	public baserequirements.resource.baseRequirements.grammar.BaseRequirementsSyntaxElement getSymtaxElement() {
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
		if (o instanceof BaseRequirementsExpectedStructuralFeature) {
			return getFeature().equals(((BaseRequirementsExpectedStructuralFeature) o).getFeature());
		}
		return false;
	}
	@Override	
	public int hashCode() {
		return getFeature().hashCode();
	}
	
}
