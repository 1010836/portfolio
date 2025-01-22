/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package entity.resource.entity.ui;

public class EntityUIMetaInformation extends entity.resource.entity.mopp.EntityMetaInformation {
	
	public entity.resource.entity.IEntityHoverTextProvider getHoverTextProvider() {
		return new entity.resource.entity.ui.EntityHoverTextProvider();
	}
	
	public entity.resource.entity.ui.EntityImageProvider getImageProvider() {
		return entity.resource.entity.ui.EntityImageProvider.INSTANCE;
	}
	
	public entity.resource.entity.ui.EntityColorManager createColorManager() {
		return new entity.resource.entity.ui.EntityColorManager();
	}
	
	/**
	 * @deprecated this method is only provided to preserve API compatibility. Use
	 * createTokenScanner(entity.resource.entity.IEntityTextResource,
	 * entity.resource.entity.ui.EntityColorManager) instead.
	 */
	public entity.resource.entity.ui.EntityTokenScanner createTokenScanner(entity.resource.entity.ui.EntityColorManager colorManager) {
		return createTokenScanner(null, colorManager);
	}
	
	public entity.resource.entity.ui.EntityTokenScanner createTokenScanner(entity.resource.entity.IEntityTextResource resource, entity.resource.entity.ui.EntityColorManager colorManager) {
		return new entity.resource.entity.ui.EntityTokenScanner(resource, colorManager);
	}
	
	public entity.resource.entity.ui.EntityCodeCompletionHelper createCodeCompletionHelper() {
		return new entity.resource.entity.ui.EntityCodeCompletionHelper();
	}
	
}
