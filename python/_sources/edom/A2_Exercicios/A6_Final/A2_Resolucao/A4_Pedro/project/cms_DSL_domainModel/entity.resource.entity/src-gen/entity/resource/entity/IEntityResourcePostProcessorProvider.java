/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package entity.resource.entity;

/**
 * Implementors of this interface can provide a post-processor for text resources.
 */
public interface IEntityResourcePostProcessorProvider {
	
	/**
	 * Returns the processor that shall be called after text resource are successfully
	 * parsed.
	 */
	public entity.resource.entity.IEntityResourcePostProcessor getResourcePostProcessor();
	
}
