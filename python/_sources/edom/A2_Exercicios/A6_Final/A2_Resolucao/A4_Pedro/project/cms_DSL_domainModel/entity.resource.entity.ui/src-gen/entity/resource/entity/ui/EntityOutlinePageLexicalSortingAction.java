/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package entity.resource.entity.ui;

public class EntityOutlinePageLexicalSortingAction extends entity.resource.entity.ui.AbstractEntityOutlinePageAction {
	
	public EntityOutlinePageLexicalSortingAction(entity.resource.entity.ui.EntityOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Sort alphabetically", org.eclipse.jface.action.IAction.AS_CHECK_BOX);
		initialize("icons/sort_lexically_icon.gif");
	}
	
	public void runInternal(boolean on) {
		getTreeViewerComparator().setSortLexically(on);
		getTreeViewer().refresh();
	}
	
}
