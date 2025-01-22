/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package entity.resource.entity.ui;

/**
 * A provider for annotation models.
 */
public interface IEntityAnnotationModelProvider {
	
	/**
	 * Returns the annotation model.
	 */
	public org.eclipse.jface.text.source.IAnnotationModel getAnnotationModel();
	
}
