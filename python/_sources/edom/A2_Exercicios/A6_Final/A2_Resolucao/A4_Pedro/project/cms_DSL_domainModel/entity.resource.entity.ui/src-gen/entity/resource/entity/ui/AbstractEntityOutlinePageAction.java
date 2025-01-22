/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package entity.resource.entity.ui;

public abstract class AbstractEntityOutlinePageAction extends org.eclipse.jface.action.Action {
	
	private String preferenceKey = this.getClass().getSimpleName() + ".isChecked";
	
	private entity.resource.entity.ui.EntityOutlinePageTreeViewer treeViewer;
	
	public AbstractEntityOutlinePageAction(entity.resource.entity.ui.EntityOutlinePageTreeViewer treeViewer, String text, int style) {
		super(text, style);
		this.treeViewer = treeViewer;
	}
	
	public void initialize(String imagePath) {
		org.eclipse.jface.resource.ImageDescriptor descriptor = entity.resource.entity.ui.EntityImageProvider.INSTANCE.getImageDescriptor(imagePath);
		setDisabledImageDescriptor(descriptor);
		setImageDescriptor(descriptor);
		setHoverImageDescriptor(descriptor);
		boolean checked = entity.resource.entity.ui.EntityUIPlugin.getDefault().getPreferenceStore().getBoolean(preferenceKey);
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
			entity.resource.entity.ui.EntityUIPlugin.getDefault().getPreferenceStore().setValue(preferenceKey, on);
		}
	}
	
	public boolean keepState() {
		return true;
	}
	
	public entity.resource.entity.ui.EntityOutlinePageTreeViewer getTreeViewer() {
		return treeViewer;
	}
	
	public entity.resource.entity.ui.EntityOutlinePageTreeViewerComparator getTreeViewerComparator() {
		return (entity.resource.entity.ui.EntityOutlinePageTreeViewerComparator) treeViewer.getComparator();
	}
	
}
