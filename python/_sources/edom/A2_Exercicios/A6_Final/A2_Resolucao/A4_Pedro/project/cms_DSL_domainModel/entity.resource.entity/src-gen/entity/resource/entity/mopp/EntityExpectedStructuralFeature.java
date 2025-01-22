/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package entity.resource.entity.mopp;

/**
 * A representation for a range in a document where a structural feature (e.g., a
 * reference) is expected.
 */
public class EntityExpectedStructuralFeature extends entity.resource.entity.mopp.EntityAbstractExpectedElement {
	
	private entity.resource.entity.grammar.EntityPlaceholder placeholder;
	
	public EntityExpectedStructuralFeature(entity.resource.entity.grammar.EntityPlaceholder placeholder) {
		super(placeholder.getMetaclass());
		this.placeholder = placeholder;
	}
	
	public org.eclipse.emf.ecore.EStructuralFeature getFeature() {
		return placeholder.getFeature();
	}
	
	/**
	 * Returns the expected placeholder.
	 */
	public entity.resource.entity.grammar.EntitySyntaxElement getSymtaxElement() {
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
		if (o instanceof EntityExpectedStructuralFeature) {
			return getFeature().equals(((EntityExpectedStructuralFeature) o).getFeature());
		}
		return false;
	}
	@Override	
	public int hashCode() {
		return getFeature().hashCode();
	}
	
}
