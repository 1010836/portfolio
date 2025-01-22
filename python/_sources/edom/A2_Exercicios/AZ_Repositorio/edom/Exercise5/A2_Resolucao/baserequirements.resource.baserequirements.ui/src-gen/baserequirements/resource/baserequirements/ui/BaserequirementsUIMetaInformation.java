/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package baserequirements.resource.baserequirements.ui;

public class BaserequirementsUIMetaInformation extends baserequirements.resource.baserequirements.mopp.BaserequirementsMetaInformation {
	
	public baserequirements.resource.baserequirements.IBaserequirementsHoverTextProvider getHoverTextProvider() {
		return new baserequirements.resource.baserequirements.ui.BaserequirementsHoverTextProvider();
	}
	
	public baserequirements.resource.baserequirements.ui.BaserequirementsImageProvider getImageProvider() {
		return baserequirements.resource.baserequirements.ui.BaserequirementsImageProvider.INSTANCE;
	}
	
	public baserequirements.resource.baserequirements.ui.BaserequirementsColorManager createColorManager() {
		return new baserequirements.resource.baserequirements.ui.BaserequirementsColorManager();
	}
	
	/**
	 * @deprecated this method is only provided to preserve API compatibility. Use
	 * createTokenScanner(baserequirements.resource.baserequirements.IBaserequirementsT
	 * extResource,
	 * baserequirements.resource.baserequirements.ui.BaserequirementsColorManager)
	 * instead.
	 */
	public baserequirements.resource.baserequirements.ui.BaserequirementsTokenScanner createTokenScanner(baserequirements.resource.baserequirements.ui.BaserequirementsColorManager colorManager) {
		return createTokenScanner(null, colorManager);
	}
	
	public baserequirements.resource.baserequirements.ui.BaserequirementsTokenScanner createTokenScanner(baserequirements.resource.baserequirements.IBaserequirementsTextResource resource, baserequirements.resource.baserequirements.ui.BaserequirementsColorManager colorManager) {
		return new baserequirements.resource.baserequirements.ui.BaserequirementsTokenScanner(resource, colorManager);
	}
	
	public baserequirements.resource.baserequirements.ui.BaserequirementsCodeCompletionHelper createCodeCompletionHelper() {
		return new baserequirements.resource.baserequirements.ui.BaserequirementsCodeCompletionHelper();
	}
	
}
