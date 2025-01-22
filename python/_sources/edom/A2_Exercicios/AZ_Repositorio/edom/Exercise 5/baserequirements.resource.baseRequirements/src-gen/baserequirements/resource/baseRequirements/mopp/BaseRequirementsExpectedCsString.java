/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package baserequirements.resource.baseRequirements.mopp;

/**
 * A representation for a range in a document where a keyword (i.e., a static
 * string) is expected.
 */
public class BaseRequirementsExpectedCsString extends baserequirements.resource.baseRequirements.mopp.BaseRequirementsAbstractExpectedElement {
	
	private baserequirements.resource.baseRequirements.grammar.BaseRequirementsKeyword keyword;
	
	public BaseRequirementsExpectedCsString(baserequirements.resource.baseRequirements.grammar.BaseRequirementsKeyword keyword) {
		super(keyword.getMetaclass());
		this.keyword = keyword;
	}
	
	public String getValue() {
		return keyword.getValue();
	}
	
	/**
	 * Returns the expected keyword.
	 */
	public baserequirements.resource.baseRequirements.grammar.BaseRequirementsSyntaxElement getSymtaxElement() {
		return keyword;
	}
	
	public java.util.Set<String> getTokenNames() {
		return java.util.Collections.singleton("'" + getValue() + "'");
	}
	
	public String toString() {
		return "CsString \"" + getValue() + "\"";
	}
	
	public boolean equals(Object o) {
		if (o instanceof BaseRequirementsExpectedCsString) {
			return getValue().equals(((BaseRequirementsExpectedCsString) o).getValue());
		}
		return false;
	}
	
	@Override	
	public int hashCode() {
		return getValue().hashCode();
	}
	
}
