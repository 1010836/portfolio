/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package entity.resource.entity.ui;

public class EntityOutlinePageExpandAllAction extends entity.resource.entity.ui.AbstractEntityOutlinePageAction {
	
	public EntityOutlinePageExpandAllAction(entity.resource.entity.ui.EntityOutlinePageTreeViewer treeViewer) {
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
