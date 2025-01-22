/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package baserequirements.resource.baserequirements.ui;

public class BaserequirementsOutlinePageCollapseAllAction extends baserequirements.resource.baserequirements.ui.AbstractBaserequirementsOutlinePageAction {
	
	public BaserequirementsOutlinePageCollapseAllAction(baserequirements.resource.baserequirements.ui.BaserequirementsOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Collapse all", org.eclipse.jface.action.IAction.AS_PUSH_BUTTON);
		initialize("icons/collapse_all_icon.gif");
	}
	
	public void runInternal(boolean on) {
		if (on) {
			getTreeViewer().collapseAll();
		}
	}
	
	public boolean keepState() {
		return false;
	}
	
}
