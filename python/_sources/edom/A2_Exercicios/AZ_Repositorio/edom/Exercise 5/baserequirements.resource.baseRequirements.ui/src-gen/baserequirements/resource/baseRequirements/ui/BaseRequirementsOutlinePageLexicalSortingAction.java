/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package baserequirements.resource.baseRequirements.ui;

public class BaseRequirementsOutlinePageLexicalSortingAction extends baserequirements.resource.baseRequirements.ui.AbstractBaseRequirementsOutlinePageAction {
	
	public BaseRequirementsOutlinePageLexicalSortingAction(baserequirements.resource.baseRequirements.ui.BaseRequirementsOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Sort alphabetically", org.eclipse.jface.action.IAction.AS_CHECK_BOX);
		initialize("icons/sort_lexically_icon.gif");
	}
	
	public void runInternal(boolean on) {
		getTreeViewerComparator().setSortLexically(on);
		getTreeViewer().refresh();
	}
	
}
