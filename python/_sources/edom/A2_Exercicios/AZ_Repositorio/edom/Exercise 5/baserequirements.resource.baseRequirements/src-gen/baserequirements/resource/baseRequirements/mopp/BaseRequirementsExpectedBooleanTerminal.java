/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package baserequirements.resource.baseRequirements.mopp;

/**
 * A representation for a range in a document where a boolean attribute is
 * expected.
 */
public class BaseRequirementsExpectedBooleanTerminal extends baserequirements.resource.baseRequirements.mopp.BaseRequirementsAbstractExpectedElement {
	
	private baserequirements.resource.baseRequirements.grammar.BaseRequirementsBooleanTerminal booleanTerminal;
	
	public BaseRequirementsExpectedBooleanTerminal(baserequirements.resource.baseRequirements.grammar.BaseRequirementsBooleanTerminal booleanTerminal) {
		super(booleanTerminal.getMetaclass());
		this.booleanTerminal = booleanTerminal;
	}
	
	public baserequirements.resource.baseRequirements.grammar.BaseRequirementsBooleanTerminal getBooleanTerminal() {
		return booleanTerminal;
	}
	
	/**
	 * Returns the expected boolean terminal.
	 */
	public baserequirements.resource.baseRequirements.grammar.BaseRequirementsSyntaxElement getSymtaxElement() {
		return booleanTerminal;
	}
	
	private org.eclipse.emf.ecore.EStructuralFeature getFeature() {
		return booleanTerminal.getFeature();
	}
	
	public String toString() {
		return "EFeature " + getFeature().getEContainingClass().getName() + "." + getFeature().getName();
	}
	
	public boolean equals(Object o) {
		if (o instanceof BaseRequirementsExpectedBooleanTerminal) {
			return getFeature().equals(((BaseRequirementsExpectedBooleanTerminal) o).getFeature());
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
