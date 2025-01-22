/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package baserequirements.resource.baserequirements.ui;

public class BaserequirementsOutlinePageActionProvider {
	
	public java.util.List<org.eclipse.jface.action.IAction> getActions(baserequirements.resource.baserequirements.ui.BaserequirementsOutlinePageTreeViewer treeViewer) {
		// To add custom actions to the outline view, set the
		// 'overrideOutlinePageActionProvider' option to <code>false</code> and modify
		// this method.
		java.util.List<org.eclipse.jface.action.IAction> defaultActions = new java.util.ArrayList<org.eclipse.jface.action.IAction>();
		defaultActions.add(new baserequirements.resource.baserequirements.ui.BaserequirementsOutlinePageLinkWithEditorAction(treeViewer));
		defaultActions.add(new baserequirements.resource.baserequirements.ui.BaserequirementsOutlinePageCollapseAllAction(treeViewer));
		defaultActions.add(new baserequirements.resource.baserequirements.ui.BaserequirementsOutlinePageExpandAllAction(treeViewer));
		defaultActions.add(new baserequirements.resource.baserequirements.ui.BaserequirementsOutlinePageAutoExpandAction(treeViewer));
		defaultActions.add(new baserequirements.resource.baserequirements.ui.BaserequirementsOutlinePageLexicalSortingAction(treeViewer));
		defaultActions.add(new baserequirements.resource.baserequirements.ui.BaserequirementsOutlinePageTypeSortingAction(treeViewer));
		return defaultActions;
	}
	
}
