/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package baserequirements.resource.baserequirements.ui;

public class BaserequirementsOutlinePageLexicalSortingAction extends baserequirements.resource.baserequirements.ui.AbstractBaserequirementsOutlinePageAction {
	
	public BaserequirementsOutlinePageLexicalSortingAction(baserequirements.resource.baserequirements.ui.BaserequirementsOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Sort alphabetically", org.eclipse.jface.action.IAction.AS_CHECK_BOX);
		initialize("icons/sort_lexically_icon.gif");
	}
	
	public void runInternal(boolean on) {
		getTreeViewerComparator().setSortLexically(on);
		getTreeViewer().refresh();
	}
	
}
