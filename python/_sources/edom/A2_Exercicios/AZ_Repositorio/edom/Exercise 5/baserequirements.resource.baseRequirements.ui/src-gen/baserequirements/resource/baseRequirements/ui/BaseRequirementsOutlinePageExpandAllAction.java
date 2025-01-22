/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package baserequirements.resource.baseRequirements.ui;

public class BaseRequirementsOutlinePageExpandAllAction extends baserequirements.resource.baseRequirements.ui.AbstractBaseRequirementsOutlinePageAction {
	
	public BaseRequirementsOutlinePageExpandAllAction(baserequirements.resource.baseRequirements.ui.BaseRequirementsOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Expand all", org.eclipse.jface.action.IAction.AS_PUSH_BUTTON);
		initialize("icons/expand_all_icon.gif");
	}
	
	public void runInternal(boolean on) {
		if (on) {
			getTreeViewer().expandAll();
		}
	}
	
	public boolean keepState() {
		return false;
	}
	
}
