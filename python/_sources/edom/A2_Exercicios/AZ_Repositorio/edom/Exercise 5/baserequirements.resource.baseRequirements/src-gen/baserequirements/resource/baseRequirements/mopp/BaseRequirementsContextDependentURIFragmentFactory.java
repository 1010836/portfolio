/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package baserequirements.resource.baseRequirements.mopp;

/**
 * A factory for ContextDependentURIFragments. Given a feasible reference
 * resolver, this factory returns a matching fragment that used the resolver to
 * resolver proxy objects.
 * 
 * @param <ContainerType> the type of the class containing the reference to be
 * resolved
 * @param <ReferenceType> the type of the reference to be resolved
 */
public class BaseRequirementsContextDependentURIFragmentFactory<ContainerType extends org.eclipse.emf.ecore.EObject, ReferenceType extends org.eclipse.emf.ecore.EObject>  implements baserequirements.resource.baseRequirements.IBaseRequirementsContextDependentURIFragmentFactory<ContainerType, ReferenceType> {
	
	private final baserequirements.resource.baseRequirements.IBaseRequirementsReferenceResolver<ContainerType, ReferenceType> resolver;
	
	public BaseRequirementsContextDependentURIFragmentFactory(baserequirements.resource.baseRequirements.IBaseRequirementsReferenceResolver<ContainerType, ReferenceType> resolver) {
		this.resolver = resolver;
	}
	
	public baserequirements.resource.baseRequirements.IBaseRequirementsContextDependentURIFragment<?> create(String identifier, ContainerType container, org.eclipse.emf.ecore.EReference reference, int positionInReference, org.eclipse.emf.ecore.EObject proxy) {
		
		return new baserequirements.resource.baseRequirements.mopp.BaseRequirementsContextDependentURIFragment<ContainerType, ReferenceType>(identifier, container, reference, positionInReference, proxy) {
			public baserequirements.resource.baseRequirements.IBaseRequirementsReferenceResolver<ContainerType, ReferenceType> getResolver() {
				return resolver;
			}
		};
	}
}
