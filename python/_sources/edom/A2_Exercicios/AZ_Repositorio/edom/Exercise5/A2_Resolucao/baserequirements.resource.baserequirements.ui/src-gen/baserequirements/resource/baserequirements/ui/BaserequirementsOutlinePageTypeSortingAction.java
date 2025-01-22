/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package baserequirements.resource.baserequirements.ui;

public class BaserequirementsOutlinePageTypeSortingAction extends baserequirements.resource.baserequirements.ui.AbstractBaserequirementsOutlinePageAction {
	
	public BaserequirementsOutlinePageTypeSortingAction(baserequirements.resource.baserequirements.ui.BaserequirementsOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Group types", org.eclipse.jface.action.IAction.AS_CHECK_BOX);
		initialize("icons/group_types_icon.gif");
	}
	
	public void runInternal(boolean on) {
		getTreeViewerComparator().setGroupTypes(on);
		getTreeViewer().refresh();
	}
	
}
