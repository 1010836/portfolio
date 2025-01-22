/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package baserequirements.resource.baseRequirements.ui;

public class BaseRequirementsUIMetaInformation extends baserequirements.resource.baseRequirements.mopp.BaseRequirementsMetaInformation {
	
	public baserequirements.resource.baseRequirements.IBaseRequirementsHoverTextProvider getHoverTextProvider() {
		return new baserequirements.resource.baseRequirements.ui.BaseRequirementsHoverTextProvider();
	}
	
	public baserequirements.resource.baseRequirements.ui.BaseRequirementsImageProvider getImageProvider() {
		return baserequirements.resource.baseRequirements.ui.BaseRequirementsImageProvider.INSTANCE;
	}
	
	public baserequirements.resource.baseRequirements.ui.BaseRequirementsColorManager createColorManager() {
		return new baserequirements.resource.baseRequirements.ui.BaseRequirementsColorManager();
	}
	
	/**
	 * @deprecated this method is only provided to preserve API compatibility. Use
	 * createTokenScanner(baserequirements.resource.baseRequirements.IBaseRequirementsT
	 * extResource,
	 * baserequirements.resource.baseRequirements.ui.BaseRequirementsColorManager)
	 * instead.
	 */
	public baserequirements.resource.baseRequirements.ui.BaseRequirementsTokenScanner createTokenScanner(baserequirements.resource.baseRequirements.ui.BaseRequirementsColorManager colorManager) {
		return createTokenScanner(null, colorManager);
	}
	
	public baserequirements.resource.baseRequirements.ui.BaseRequirementsTokenScanner createTokenScanner(baserequirements.resource.baseRequirements.IBaseRequirementsTextResource resource, baserequirements.resource.baseRequirements.ui.BaseRequirementsColorManager colorManager) {
		return new baserequirements.resource.baseRequirements.ui.BaseRequirementsTokenScanner(resource, colorManager);
	}
	
	public baserequirements.resource.baseRequirements.ui.BaseRequirementsCodeCompletionHelper createCodeCompletionHelper() {
		return new baserequirements.resource.baseRequirements.ui.BaseRequirementsCodeCompletionHelper();
	}
	
}
