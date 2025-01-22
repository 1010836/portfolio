/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package baserequirements.resource.baserequirements.grammar;

public class BaserequirementsLineBreak extends baserequirements.resource.baserequirements.grammar.BaserequirementsFormattingElement {
	
	private final int tabs;
	
	public BaserequirementsLineBreak(baserequirements.resource.baserequirements.grammar.BaserequirementsCardinality cardinality, int tabs) {
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
