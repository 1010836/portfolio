/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package entity.resource.entity.ui;

public class EntityOutlinePageAutoExpandAction extends entity.resource.entity.ui.AbstractEntityOutlinePageAction {
	
	public EntityOutlinePageAutoExpandAction(entity.resource.entity.ui.EntityOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Auto expand", org.eclipse.jface.action.IAction.AS_CHECK_BOX);
		initialize("icons/auto_expand_icon.gif");
	}
	
	public void runInternal(boolean on) {
		getTreeViewer().setAutoExpand(on);
		getTreeViewer().refresh();
	}
	
}
