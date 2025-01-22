/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package entity.resource.entity.mopp;

/**
 * A representation for a range in a document where a boolean attribute is
 * expected.
 */
public class EntityExpectedBooleanTerminal extends entity.resource.entity.mopp.EntityAbstractExpectedElement {
	
	private entity.resource.entity.grammar.EntityBooleanTerminal booleanTerminal;
	
	public EntityExpectedBooleanTerminal(entity.resource.entity.grammar.EntityBooleanTerminal booleanTerminal) {
		super(booleanTerminal.getMetaclass());
		this.booleanTerminal = booleanTerminal;
	}
	
	public entity.resource.entity.grammar.EntityBooleanTerminal getBooleanTerminal() {
		return booleanTerminal;
	}
	
	/**
	 * Returns the expected boolean terminal.
	 */
	public entity.resource.entity.grammar.EntitySyntaxElement getSymtaxElement() {
		return booleanTerminal;
	}
	
	private org.eclipse.emf.ecore.EStructuralFeature getFeature() {
		return booleanTerminal.getFeature();
	}
	
	public String toString() {
		return "EFeature " + getFeature().getEContainingClass().getName() + "." + getFeature().getName();
	}
	
	public boolean equals(Object o) {
		if (o instanceof EntityExpectedBooleanTerminal) {
			return getFeature().equals(((EntityExpectedBooleanTerminal) o).getFeature());
		}
		return false;
	}
	
	@Override	
	public int hashCode() {
		return getFeature().hashCode();
	}
	
	public java.util.Set<String> getTokenNames() {
		// BooleanTerminals are associated with two or one token(s)
		java.util.Set<String> tokenNames = new java.util.LinkedHashSet<String>(2);
		String trueLiteral = booleanTerminal.getTrueLiteral();
		if (!"".equals(trueLiteral)) {
			tokenNames.add("'" + trueLiteral + "'");
		}
		String falseLiteral = booleanTerminal.getFalseLiteral();
		if (!"".equals(falseLiteral)) {
			tokenNames.add("'" + falseLiteral + "'");
		}
		return tokenNames;
	}
	
}
