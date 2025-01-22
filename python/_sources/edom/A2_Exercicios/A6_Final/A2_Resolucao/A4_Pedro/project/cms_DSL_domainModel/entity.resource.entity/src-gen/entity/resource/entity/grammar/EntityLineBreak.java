/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package entity.resource.entity.grammar;

public class EntityLineBreak extends entity.resource.entity.grammar.EntityFormattingElement {
	
	private final int tabs;
	
	public EntityLineBreak(entity.resource.entity.grammar.EntityCardinality cardinality, int tabs) {
		super(cardinality);
		this.tabs = tabs;
	}
	
	public int getTabs() {
		return tabs;
	}
	
	public String toString() {
		return "!" + getTabs();
	}
	
}
