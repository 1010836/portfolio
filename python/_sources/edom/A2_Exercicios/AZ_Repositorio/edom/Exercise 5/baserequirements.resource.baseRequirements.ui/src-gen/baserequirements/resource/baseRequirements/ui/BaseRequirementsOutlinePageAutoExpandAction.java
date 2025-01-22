/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package baserequirements.resource.baseRequirements.ui;

public class BaseRequirementsOutlinePageAutoExpandAction extends baserequirements.resource.baseRequirements.ui.AbstractBaseRequirementsOutlinePageAction {
	
	public BaseRequirementsOutlinePageAutoExpandAction(baserequirements.resource.baseRequirements.ui.BaseRequirementsOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Auto expand", org.eclipse.jface.action.IAction.AS_CHECK_BOX);
		initialize("icons/auto_expand_icon.gif");
	}
	
	public void runInternal(boolean on) {
		getTreeViewer().setAutoExpand(on);
		getTreeViewer().refresh();
	}
	
}
