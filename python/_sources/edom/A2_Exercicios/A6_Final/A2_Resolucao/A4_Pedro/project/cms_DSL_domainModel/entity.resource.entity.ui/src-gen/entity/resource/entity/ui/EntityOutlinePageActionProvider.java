/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package entity.resource.entity.ui;

public class EntityOutlinePageActionProvider {
	
	public java.util.List<org.eclipse.jface.action.IAction> getActions(entity.resource.entity.ui.EntityOutlinePageTreeViewer treeViewer) {
		// To add custom actions to the outline view, set the
		// 'overrideOutlinePageActionProvider' option to <code>false</code> and modify
		// this method.
		java.util.List<org.eclipse.jface.action.IAction> defaultActions = new java.util.ArrayList<org.eclipse.jface.action.IAction>();
		defaultActions.add(new entity.resource.entity.ui.EntityOutlinePageLinkWithEditorAction(treeViewer));
		defaultActions.add(new entity.resource.entity.ui.EntityOutlinePageCollapseAllAction(treeViewer));
		defaultActions.add(new entity.resource.entity.ui.EntityOutlinePageExpandAllAction(treeViewer));
		defaultActions.add(new entity.resource.entity.ui.EntityOutlinePageAutoExpandAction(treeViewer));
		defaultActions.add(new entity.resource.entity.ui.EntityOutlinePageLexicalSortingAction(treeViewer));
		defaultActions.add(new entity.resource.entity.ui.EntityOutlinePageTypeSortingAction(treeViewer));
		return defaultActions;
	}
	
}
