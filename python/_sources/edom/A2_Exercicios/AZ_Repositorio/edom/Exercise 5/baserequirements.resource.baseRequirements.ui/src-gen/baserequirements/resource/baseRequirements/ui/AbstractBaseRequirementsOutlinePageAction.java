/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package baserequirements.resource.baseRequirements.ui;

public abstract class AbstractBaseRequirementsOutlinePageAction extends org.eclipse.jface.action.Action {
	
	private String preferenceKey = this.getClass().getSimpleName() + ".isChecked";
	
	private baserequirements.resource.baseRequirements.ui.BaseRequirementsOutlinePageTreeViewer treeViewer;
	
	public AbstractBaseRequirementsOutlinePageAction(baserequirements.resource.baseRequirements.ui.BaseRequirementsOutlinePageTreeViewer treeViewer, String text, int style) {
		super(text, style);
		this.treeViewer = treeViewer;
	}
	
	public void initialize(String imagePath) {
		org.eclipse.jface.resource.ImageDescriptor descriptor = baserequirements.resource.baseRequirements.ui.BaseRequirementsImageProvider.INSTANCE.getImageDescriptor(imagePath);
		setDisabledImageDescriptor(descriptor);
		setImageDescriptor(descriptor);
		setHoverImageDescriptor(descriptor);
		boolean checked = baserequirements.resource.baseRequirements.ui.BaseRequirementsUIPlugin.getDefault().getPreferenceStore().getBoolean(preferenceKey);
		valueChanged(checked, false);
	}
	
	@Override	
	public void run() {
		if (keepState()) {
			valueChanged(isChecked(), true);
		} else {
			runBusy(true);
		}
	}
	
	public void runBusy(final boolean on) {
		org.eclipse.swt.custom.BusyIndicator.showWhile(org.eclipse.swt.widgets.Display.getCurrent(), new Runnable() {
			public void run() {
				runInternal(on);
			}
		});
	}
	
	public abstract void runInternal(boolean on);
	
	private void valueChanged(boolean on, boolean store) {
		setChecked(on);
		runBusy(on);
		if (store) {
			baserequirements.resource.baseRequirements.ui.BaseRequirementsUIPlugin.getDefault().getPreferenceStore().setValue(preferenceKey, on);
		}
	}
	
	public boolean keepState() {
		return true;
	}
	
	public baserequirements.resource.baseRequirements.ui.BaseRequirementsOutlinePageTreeViewer getTreeViewer() {
		return treeViewer;
	}
	
	public baserequirements.resource.baseRequirements.ui.BaseRequirementsOutlinePageTreeViewerComparator getTreeViewerComparator() {
		return (baserequirements.resource.baseRequirements.ui.BaseRequirementsOutlinePageTreeViewerComparator) treeViewer.getComparator();
	}
	
}
