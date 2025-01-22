/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package entity.resource.entity.ui;

public class EntityAnnotationModel extends org.eclipse.ui.texteditor.ResourceMarkerAnnotationModel {
	
	public EntityAnnotationModel(org.eclipse.core.resources.IResource resource) {
		super(resource);
	}
	
	protected org.eclipse.ui.texteditor.MarkerAnnotation createMarkerAnnotation(org.eclipse.core.resources.IMarker marker) {
		return new entity.resource.entity.ui.EntityMarkerAnnotation(marker);
	}
	
}
