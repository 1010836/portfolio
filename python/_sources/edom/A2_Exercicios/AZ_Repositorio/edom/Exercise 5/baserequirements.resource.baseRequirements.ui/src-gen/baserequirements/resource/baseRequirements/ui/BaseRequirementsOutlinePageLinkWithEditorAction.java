/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package baserequirements.resource.baseRequirements.ui;

public class BaseRequirementsOutlinePageLinkWithEditorAction extends baserequirements.resource.baseRequirements.ui.AbstractBaseRequirementsOutlinePageAction {
	
	public BaseRequirementsOutlinePageLinkWithEditorAction(baserequirements.resource.baseRequirements.ui.BaseRequirementsOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Link with Editor", org.eclipse.jface.action.IAction.AS_CHECK_BOX);
		initialize("icons/link_with_editor_icon.gif");
	}
	
	public void runInternal(boolean on) {
		getTreeViewer().setLinkWithEditor(on);
	}
	
}
