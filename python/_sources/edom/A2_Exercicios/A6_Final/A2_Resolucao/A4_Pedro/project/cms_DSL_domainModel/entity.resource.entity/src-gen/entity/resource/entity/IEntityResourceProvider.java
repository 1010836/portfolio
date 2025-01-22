/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package entity.resource.entity;

/**
 * Implementors of this interface provide an EMF resource.
 */
public interface IEntityResourceProvider {
	
	/**
	 * Returns the resource.
	 */
	public entity.resource.entity.IEntityTextResource getResource();
	
}
