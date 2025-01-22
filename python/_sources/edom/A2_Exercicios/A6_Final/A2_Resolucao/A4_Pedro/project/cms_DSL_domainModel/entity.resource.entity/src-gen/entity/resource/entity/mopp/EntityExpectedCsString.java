/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package entity.resource.entity.mopp;

/**
 * A representation for a range in a document where a keyword (i.e., a static
 * string) is expected.
 */
public class EntityExpectedCsString extends entity.resource.entity.mopp.EntityAbstractExpectedElement {
	
	private entity.resource.entity.grammar.EntityKeyword keyword;
	
	public EntityExpectedCsString(entity.resource.entity.grammar.EntityKeyword keyword) {
		super(keyword.getMetaclass());
		this.keyword = keyword;
	}
	
	public String getValue() {
		return keyword.getValue();
	}
	
	/**
	 * Returns the expected keyword.
	 */
	public entity.resource.entity.grammar.EntitySyntaxElement getSymtaxElement() {
		return keyword;
	}
	
	public java.util.Set<String> getTokenNames() {
		return java.util.Collections.singleton("'" + getValue() + "'");
	}
	
	public String toString() {
		return "CsString \"" + getValue() + "\"";
	}
	
	public boolean equals(Object o) {
		if (o instanceof EntityExpectedCsString) {
			return getValue().equals(((EntityExpectedCsString) o).getValue());
		}
		return false;
	}
	
	@Override	
	public int hashCode() {
		return getValue().hashCode();
	}
	
}
