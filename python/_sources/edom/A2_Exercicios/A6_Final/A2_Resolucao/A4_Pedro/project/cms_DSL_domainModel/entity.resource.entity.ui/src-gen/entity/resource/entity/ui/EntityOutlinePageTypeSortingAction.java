/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package entity.resource.entity.ui;

public class EntityOutlinePageTypeSortingAction extends entity.resource.entity.ui.AbstractEntityOutlinePageAction {
	
	public EntityOutlinePageTypeSortingAction(entity.resource.entity.ui.EntityOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Group types", org.eclipse.jface.action.IAction.AS_CHECK_BOX);
		initialize("icons/group_types_icon.gif");
	}
	
	public void runInternal(boolean on) {
		getTreeViewerComparator().setGroupTypes(on);
		getTreeViewer().refresh();
	}
	
}
