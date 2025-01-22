/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package baserequirements.resource.baseRequirements.ui;

public class BaseRequirementsOutlinePageTypeSortingAction extends baserequirements.resource.baseRequirements.ui.AbstractBaseRequirementsOutlinePageAction {
	
	public BaseRequirementsOutlinePageTypeSortingAction(baserequirements.resource.baseRequirements.ui.BaseRequirementsOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Group types", org.eclipse.jface.action.IAction.AS_CHECK_BOX);
		initialize("icons/group_types_icon.gif");
	}
	
	public void runInternal(boolean on) {
		getTreeViewerComparator().setGroupTypes(on);
		getTreeViewer().refresh();
	}
	
}
