/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package baserequirements.resource.baserequirements.mopp;

/**
 * A representation for a range in a document where a keyword (i.e., a static
 * string) is expected.
 */
public class BaserequirementsExpectedCsString extends baserequirements.resource.baserequirements.mopp.BaserequirementsAbstractExpectedElement {
	
	private baserequirements.resource.baserequirements.grammar.BaserequirementsKeyword keyword;
	
	public BaserequirementsExpectedCsString(baserequirements.resource.baserequirements.grammar.BaserequirementsKeyword keyword) {
		super(keyword.getMetaclass());
		this.keyword = keyword;
	}
	
	public String getValue() {
		return keyword.getValue();
	}
	
	/**
	 * Returns the expected keyword.
	 */
	public baserequirements.resource.baserequirements.grammar.BaserequirementsSyntaxElement getSymtaxElement() {
		return keyword;
	}
	
	public java.util.Set<String> getTokenNames() {
		return java.util.Collections.singleton("'" + getValue() + "'");
	}
	
	public String toString() {
		return "CsString \"" + getValue() + "\"";
	}
	
	public boolean equals(Object o) {
		if (o instanceof BaserequirementsExpectedCsString) {
			return getValue().equals(((BaserequirementsExpectedCsString) o).getValue());
		}
		return false;
	}
	
	@Override	
	public int hashCode() {
		return getValue().hashCode();
	}
	
}
