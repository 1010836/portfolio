/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package baserequirements.resource.baseRequirements;

/**
 * Implementors of this interface can provide a post-processor for text resources.
 */
public interface IBaseRequirementsResourcePostProcessorProvider {
	
	/**
	 * Returns the processor that shall be called after text resource are successfully
	 * parsed.
	 */
	public baserequirements.resource.baseRequirements.IBaseRequirementsResourcePostProcessor getResourcePostProcessor();
	
}
