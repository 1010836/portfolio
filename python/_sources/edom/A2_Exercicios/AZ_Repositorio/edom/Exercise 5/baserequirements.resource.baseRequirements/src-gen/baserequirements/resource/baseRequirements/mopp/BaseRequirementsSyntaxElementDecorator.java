/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package baserequirements.resource.baseRequirements.mopp;

public class BaseRequirementsSyntaxElementDecorator {
	
	/**
	 * the syntax element to be decorated
	 */
	private baserequirements.resource.baseRequirements.grammar.BaseRequirementsSyntaxElement decoratedElement;
	
	/**
	 * an array of child decorators (one decorator per child of the decorated syntax
	 * element
	 */
	private BaseRequirementsSyntaxElementDecorator[] childDecorators;
	
	/**
	 * a list of the indices that must be printed
	 */
	private java.util.List<Integer> indicesToPrint = new java.util.ArrayList<Integer>();
	
	public BaseRequirementsSyntaxElementDecorator(baserequirements.resource.baseRequirements.grammar.BaseRequirementsSyntaxElement decoratedElement, BaseRequirementsSyntaxElementDecorator[] childDecorators) {
		super();
		this.decoratedElement = decoratedElement;
		this.childDecorators = childDecorators;
	}
	
	public void addIndexToPrint(Integer index) {
		indicesToPrint.add(index);
	}
	
	public baserequirements.resource.baseRequirements.grammar.BaseRequirementsSyntaxElement getDecoratedElement() {
		return decoratedElement;
	}
	
	public BaseRequirementsSyntaxElementDecorator[] getChildDecorators() {
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
