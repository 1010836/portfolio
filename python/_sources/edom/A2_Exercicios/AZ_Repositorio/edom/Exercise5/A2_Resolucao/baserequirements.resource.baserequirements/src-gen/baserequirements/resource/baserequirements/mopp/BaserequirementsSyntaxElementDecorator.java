/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package baserequirements.resource.baserequirements.mopp;

public class BaserequirementsSyntaxElementDecorator {
	
	/**
	 * the syntax element to be decorated
	 */
	private baserequirements.resource.baserequirements.grammar.BaserequirementsSyntaxElement decoratedElement;
	
	/**
	 * an array of child decorators (one decorator per child of the decorated syntax
	 * element
	 */
	private BaserequirementsSyntaxElementDecorator[] childDecorators;
	
	/**
	 * a list of the indices that must be printed
	 */
	private java.util.List<Integer> indicesToPrint = new java.util.ArrayList<Integer>();
	
	public BaserequirementsSyntaxElementDecorator(baserequirements.resource.baserequirements.grammar.BaserequirementsSyntaxElement decoratedElement, BaserequirementsSyntaxElementDecorator[] childDecorators) {
		super();
		this.decoratedElement = decoratedElement;
		this.childDecorators = childDecorators;
	}
	
	public void addIndexToPrint(Integer index) {
		indicesToPrint.add(index);
	}
	
	public baserequirements.resource.baserequirements.grammar.BaserequirementsSyntaxElement getDecoratedElement() {
		return decoratedElement;
	}
	
	public BaserequirementsSyntaxElementDecorator[] getChildDecorators() {
		return childDecorators;
	}
	
	public Integer getNextIndexToPrint() {
		if (indicesToPrint.size() == 0) {
			return null;
		}
		return indicesToPrint.remove(0);
	}
	
	public String toString() {
		return "" + getDecoratedElement();
	}
	
}
