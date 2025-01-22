/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package baserequirements.resource.baseRequirements;

/**
 * A delegating reference resolver is an extension of a normal reference resolver
 * that can be configured with another resolver that it may delegate method calls
 * to. This interface can be implemented by additional resolvers to customize
 * resolving using the load option ADDITIONAL_REFERENCE_RESOLVERS.
 * 
 * @see baserequirements.resource.baseRequirements.IBaseRequirementsOptions
 */
public interface IBaseRequirementsDelegatingReferenceResolver<ContainerType extends org.eclipse.emf.ecore.EObject, ReferenceType extends org.eclipse.emf.ecore.EObject> extends baserequirements.resource.baseRequirements.IBaseRequirementsReferenceResolver<ContainerType, ReferenceType> {
	
	/**
	 * Sets the delegate for this resolver.
	 */
	public void setDelegate(baserequirements.resource.baseRequirements.IBaseRequirementsReferenceResolver<ContainerType, ReferenceType> delegate);
	
}
