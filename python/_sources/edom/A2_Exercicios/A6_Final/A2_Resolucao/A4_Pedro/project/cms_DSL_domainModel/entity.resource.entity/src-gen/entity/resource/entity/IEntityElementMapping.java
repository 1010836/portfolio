/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package entity.resource.entity;

/**
 * A mapping from an identifier to an EObject.
 * 
 * @param <ReferenceType> the type of the reference this mapping points to.
 */
public interface IEntityElementMapping<ReferenceType> extends entity.resource.entity.IEntityReferenceMapping<ReferenceType> {
	
	/**
	 * Returns the target object the identifier is mapped to.
	 */
	public ReferenceType getTargetElement();
}
