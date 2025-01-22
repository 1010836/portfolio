/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package baserequirements.resource.baserequirements.ui;

public class BaserequirementsOutlinePageAutoExpandAction extends baserequirements.resource.baserequirements.ui.AbstractBaserequirementsOutlinePageAction {
	
	public BaserequirementsOutlinePageAutoExpandAction(baserequirements.resource.baserequirements.ui.BaserequirementsOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Auto expand", org.eclipse.jface.action.IAction.AS_CHECK_BOX);
		initialize("icons/auto_expand_icon.gif");
	}
	
	public void runInternal(boolean on) {
		getTreeViewer().setAutoExpand(on);
		getTreeViewer().refresh();
	}
	
}
