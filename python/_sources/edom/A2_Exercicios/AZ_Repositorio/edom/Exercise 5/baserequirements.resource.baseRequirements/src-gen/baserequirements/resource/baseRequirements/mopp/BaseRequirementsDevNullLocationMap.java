/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package baserequirements.resource.baseRequirements.mopp;

/**
 * An inactive implementation of the ILocationMap interface. That is used if the
 * baserequirements.resource.baseRequirements.IBaseRequirementsOptions.DISABLE_LOCA
 * TION_MAP option is set.
 */
public class BaseRequirementsDevNullLocationMap implements baserequirements.resource.baseRequirements.IBaseRequirementsLocationMap {
	
	public void setLine(org.eclipse.emf.ecore.EObject element, int line) {
	}
	
	public int getLine(org.eclipse.emf.ecore.EObject element) {
		return -1;
	}
	
	public void setColumn(org.eclipse.emf.ecore.EObject element, int column) {
	}
	
	public int getColumn(org.eclipse.emf.ecore.EObject element) {
		return -1;
	}
	
	public void setCharStart(org.eclipse.emf.ecore.EObject element, int charStart) {
	}
	
	public int getCharStart(org.eclipse.emf.ecore.EObject element) {
		return -1;
	}
	
	public void setCharEnd(org.eclipse.emf.ecore.EObject element, int charEnd) {
	}
	
	public int getCharEnd(org.eclipse.emf.ecore.EObject element) {
		return -1;
	}
	
	public java.util.List<org.eclipse.emf.ecore.EObject> getElementsAt(final int documentOffset) {
		return java.util.Collections.<org.eclipse.emf.ecore.EObject>emptyList();
	}
	
	public java.util.List<org.eclipse.emf.ecore.EObject> getElementsBetween(final int startOffset, final int endOffset) {
		return java.util.Collections.<org.eclipse.emf.ecore.EObject>emptyList();
	}
	
}
