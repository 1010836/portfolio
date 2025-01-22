/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package entity.resource.entity.ui;

public class EntityHoverTextProvider implements entity.resource.entity.IEntityHoverTextProvider {
	
	private entity.resource.entity.ui.EntityDefaultHoverTextProvider defaultProvider = new entity.resource.entity.ui.EntityDefaultHoverTextProvider();
	
	public String getHoverText(org.eclipse.emf.ecore.EObject container, org.eclipse.emf.ecore.EObject referencedObject) {
		// Set option overrideHoverTextProvider to false and customize this method to
		// obtain custom hover texts.
		return defaultProvider.getHoverText(referencedObject);
	}
	
	public String getHoverText(org.eclipse.emf.ecore.EObject object) {
		// Set option overrideHoverTextProvider to false and customize this method to
		// obtain custom hover texts.
		return defaultProvider.getHoverText(object);
	}
	
}
