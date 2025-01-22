/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package baserequirements.resource.baserequirements.mopp;

/**
 * A factory for ContextDependentURIFragments. Given a feasible reference
 * resolver, this factory returns a matching fragment that used the resolver to
 * resolver proxy objects.
 * 
 * @param <ContainerType> the type of the class containing the reference to be
 * resolved
 * @param <ReferenceType> the type of the reference to be resolved
 */
public class BaserequirementsContextDependentURIFragmentFactory<ContainerType extends org.eclipse.emf.ecore.EObject, ReferenceType extends org.eclipse.emf.ecore.EObject>  implements baserequirements.resource.baserequirements.IBaserequirementsContextDependentURIFragmentFactory<ContainerType, ReferenceType> {
	
	private final baserequirements.resource.baserequirements.IBaserequirementsReferenceResolver<ContainerType, ReferenceType> resolver;
	
	public BaserequirementsContextDependentURIFragmentFactory(baserequirements.resource.baserequirements.IBaserequirementsReferenceResolver<ContainerType, ReferenceType> resolver) {
		this.resolver = resolver;
	}
	
	public baserequirements.resource.baserequirements.IBaserequirementsContextDependentURIFragment<?> create(String identifier, ContainerType container, org.eclipse.emf.ecore.EReference reference, int positionInReference, org.eclipse.emf.ecore.EObject proxy) {
		
		return new baserequirements.resource.baserequirements.mopp.BaserequirementsContextDependentURIFragment<ContainerType, ReferenceType>(identifier, container, reference, positionInReference, proxy) {
			public baserequirements.resource.baserequirements.IBaserequirementsReferenceResolver<ContainerType, ReferenceType> getResolver() {
				return resolver;
			}
		};
	}
}
