/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package baserequirements.resource.baserequirements;

/**
 * Implementors of this interface can provide a post-processor for text resources.
 */
public interface IBaserequirementsResourcePostProcessorProvider {
	
	/**
	 * Returns the processor that shall be called after text resource are successfully
	 * parsed.
	 */
	public baserequirements.resource.baserequirements.IBaserequirementsResourcePostProcessor getResourcePostProcessor();
	
}
