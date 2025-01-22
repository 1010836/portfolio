/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package baserequirements.resource.baseRequirements.grammar;

public class BaseRequirementsLineBreak extends baserequirements.resource.baseRequirements.grammar.BaseRequirementsFormattingElement {
	
	private final int tabs;
	
	public BaseRequirementsLineBreak(baserequirements.resource.baseRequirements.grammar.BaseRequirementsCardinality cardinality, int tabs) {
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
