/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package entity.resource.entity.mopp;

/**
 * A factory for ContextDependentURIFragments. Given a feasible reference
 * resolver, this factory returns a matching fragment that used the resolver to
 * resolver proxy objects.
 * 
 * @param <ContainerType> the type of the class containing the reference to be
 * resolved
 * @param <ReferenceType> the type of the reference to be resolved
 */
public class EntityContextDependentURIFragmentFactory<ContainerType extends org.eclipse.emf.ecore.EObject, ReferenceType extends org.eclipse.emf.ecore.EObject>  implements entity.resource.entity.IEntityContextDependentURIFragmentFactory<ContainerType, ReferenceType> {
	
	private final entity.resource.entity.IEntityReferenceResolver<ContainerType, ReferenceType> resolver;
	
	public EntityContextDependentURIFragmentFactory(entity.resource.entity.IEntityReferenceResolver<ContainerType, ReferenceType> resolver) {
		this.resolver = resolver;
	}
	
	public entity.resource.entity.IEntityContextDependentURIFragment<?> create(String identifier, ContainerType container, org.eclipse.emf.ecore.EReference reference, int positionInReference, org.eclipse.emf.ecore.EObject proxy) {
		
		return new entity.resource.entity.mopp.EntityContextDependentURIFragment<ContainerType, ReferenceType>(identifier, container, reference, positionInReference, proxy) {
			public entity.resource.entity.IEntityReferenceResolver<ContainerType, ReferenceType> getResolver() {
				return resolver;
			}
		};
	}
}
