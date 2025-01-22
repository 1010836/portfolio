/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package entity.resource.entity.ui;

public class EntityOutlinePageCollapseAllAction extends entity.resource.entity.ui.AbstractEntityOutlinePageAction {
	
	public EntityOutlinePageCollapseAllAction(entity.resource.entity.ui.EntityOutlinePageTreeViewer treeViewer) {
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
