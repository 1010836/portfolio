/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package baserequirements.resource.baseRequirements.ui;

public class BaseRequirementsOutlinePageActionProvider {
	
	public java.util.List<org.eclipse.jface.action.IAction> getActions(baserequirements.resource.baseRequirements.ui.BaseRequirementsOutlinePageTreeViewer treeViewer) {
		// To add custom actions to the outline view, set the
		// 'overrideOutlinePageActionProvider' option to <code>false</code> and modify
		// this method.
		java.util.List<org.eclipse.jface.action.IAction> defaultActions = new java.util.ArrayList<org.eclipse.jface.action.IAction>();
		defaultActions.add(new baserequirements.resource.baseRequirements.ui.BaseRequirementsOutlinePageLinkWithEditorAction(treeViewer));
		defaultActions.add(new baserequirements.resource.baseRequirements.ui.BaseRequirementsOutlinePageCollapseAllAction(treeViewer));
		defaultActions.add(new baserequirements.resource.baseRequirements.ui.BaseRequirementsOutlinePageExpandAllAction(treeViewer));
		defaultActions.add(new baserequirements.resource.baseRequirements.ui.BaseRequirementsOutlinePageAutoExpandAction(treeViewer));
		defaultActions.add(new baserequirements.resource.baseRequirements.ui.BaseRequirementsOutlinePageLexicalSortingAction(treeViewer));
		defaultActions.add(new baserequirements.resource.baseRequirements.ui.BaseRequirementsOutlinePageTypeSortingAction(treeViewer));
		return defaultActions;
	}
	
}
