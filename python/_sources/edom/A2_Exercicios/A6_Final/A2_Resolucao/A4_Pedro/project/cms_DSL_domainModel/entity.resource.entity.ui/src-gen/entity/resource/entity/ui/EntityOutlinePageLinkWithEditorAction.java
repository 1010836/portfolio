/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package entity.resource.entity.ui;

public class EntityOutlinePageLinkWithEditorAction extends entity.resource.entity.ui.AbstractEntityOutlinePageAction {
	
	public EntityOutlinePageLinkWithEditorAction(entity.resource.entity.ui.EntityOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Link with Editor", org.eclipse.jface.action.IAction.AS_CHECK_BOX);
		initialize("icons/link_with_editor_icon.gif");
	}
	
	public void runInternal(boolean on) {
		getTreeViewer().setLinkWithEditor(on);
	}
	
}
