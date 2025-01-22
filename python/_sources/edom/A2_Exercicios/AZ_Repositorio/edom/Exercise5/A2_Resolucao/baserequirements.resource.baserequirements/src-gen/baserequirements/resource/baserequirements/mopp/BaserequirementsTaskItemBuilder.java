/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package baserequirements.resource.baserequirements.mopp;

/**
 * The BaserequirementsTaskItemBuilder is used to find task items in text
 * documents. The current implementation uses the generated lexer and the
 * TaskItemDetector to detect task items. This class is called by the
 * BuilderAdapter, which runs both this builder and the default builder that is
 * intended to be customized.
 */
public class BaserequirementsTaskItemBuilder {
	
	public void build(org.eclipse.core.resources.IFile resource, org.eclipse.emf.ecore.resource.ResourceSet resourceSet, org.eclipse.core.runtime.IProgressMonitor monitor) {
		monitor.setTaskName("Searching for task items");
		new baserequirements.resource.baserequirements.mopp.BaserequirementsMarkerHelper().removeAllMarkers(resource, org.eclipse.core.resources.IMarker.TASK);
		if (isInBinFolder(resource)) {
			return;
		}
		java.util.List<baserequirements.resource.baserequirements.mopp.BaserequirementsTaskItem> taskItems = new java.util.ArrayList<baserequirements.resource.baserequirements.mopp.BaserequirementsTaskItem>();
		baserequirements.resource.baserequirements.mopp.BaserequirementsTaskItemDetector taskItemDetector = new baserequirements.resource.baserequirements.mopp.BaserequirementsTaskItemDetector();
		try {
			java.io.InputStream inputStream = resource.getContents();
			String content = baserequirements.resource.baserequirements.util.BaserequirementsStreamUtil.getContent(inputStream);
			baserequirements.resource.baserequirements.IBaserequirementsTextScanner lexer = new baserequirements.resource.baserequirements.mopp.BaserequirementsMetaInformation().createLexer();
			lexer.setText(content);
			
			baserequirements.resource.baserequirements.IBaserequirementsTextToken nextToken = lexer.getNextToken();
			while (nextToken != null) {
				String text = nextToken.getText();
				taskItems.addAll(taskItemDetector.findTaskItems(text, nextToken.getLine(), nextToken.getOffset()));
				nextToken = lexer.getNextToken();
			}
		} catch (java.io.IOException e) {
			baserequirements.resource.baserequirements.mopp.BaserequirementsPlugin.logError("Exception while searching for task items", e);
		} catch (org.eclipse.core.runtime.CoreException e) {
			baserequirements.resource.baserequirements.mopp.BaserequirementsPlugin.logError("Exception while searching for task items", e);
		}
		
		for (baserequirements.resource.baserequirements.mopp.BaserequirementsTaskItem taskItem : taskItems) {
			java.util.Map<String, Object> markerAttributes = new java.util.LinkedHashMap<String, Object>();
			markerAttributes.put(org.eclipse.core.resources.IMarker.USER_EDITABLE, false);
			markerAttributes.put(org.eclipse.core.resources.IMarker.DONE, false);
			markerAttributes.put(org.eclipse.core.resources.IMarker.LINE_NUMBER, taskItem.getLine());
			markerAttributes.put(org.eclipse.core.resources.IMarker.CHAR_START, taskItem.getCharStart());
			markerAttributes.put(org.eclipse.core.resources.IMarker.CHAR_END, taskItem.getCharEnd());
			markerAttributes.put(org.eclipse.core.resources.IMarker.MESSAGE, taskItem.getMessage());
			new baserequirements.resource.baserequirements.mopp.BaserequirementsMarkerHelper().createMarker(resource, org.eclipse.core.resources.IMarker.TASK, markerAttributes);
		}
	}
	
	public String getBuilderMarkerId() {
		return org.eclipse.core.resources.IMarker.TASK;
	}
	
	public boolean isInBinFolder(org.eclipse.core.resources.IFile resource) {
		org.eclipse.core.resources.IContainer parent = resource.getParent();
		while (parent != null) {
			if ("bin".equals(parent.getName())) {
				return true;
			}
			parent = parent.getParent();
		}
		return false;
	}
	
}
