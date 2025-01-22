/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package baserequirements.resource.baserequirements;

/**
 * An interface for factories to create instances of
 * baserequirements.resource.baserequirements.IBaserequirementsContextDependentURIF
 * ragment.
 * 
 * @param <ContainerType> the type of the class containing the reference to be
 * resolved
 * @param <ReferenceType> the type of the reference to be resolved
 */
public interface IBaserequirementsContextDependentURIFragmentFactory<ContainerType extends org.eclipse.emf.ecore.EObject, ReferenceType extends org.eclipse.emf.ecore.EObject> {
	
	/**
	 * Create a new instance of the
	 * baserequirements.resource.baserequirements.IBaserequirementsContextDependentURIF
	 * ragment interface.
	 * 
	 * @param identifier the identifier that references an Object
	 * @param container the object that contains the reference
	 * @param reference the reference itself
	 * @param positionInReference the position of the identifier (if the reference is
	 * multiple)
	 * @param proxy the proxy that will be resolved later to the actual EObject
	 * 
	 * @return the new instance of
	 * baserequirements.resource.baserequirements.IBaserequirementsContextDependentURIF
	 * ragment
	 */
	public baserequirements.resource.baserequirements.IBaserequirementsContextDependentURIFragment<?> create(String identifier, ContainerType container, org.eclipse.emf.ecore.EReference reference, int positionInReference, org.eclipse.emf.ecore.EObject proxy);
}
