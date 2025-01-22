/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package entity.resource.entity.analysis;

public class RelationRelEntityReferenceResolver implements entity.resource.entity.IEntityReferenceResolver<entity.Relation, entity.Entity> {
	
	private entity.resource.entity.analysis.EntityDefaultResolverDelegate<entity.Relation, entity.Entity> delegate = new entity.resource.entity.analysis.EntityDefaultResolverDelegate<entity.Relation, entity.Entity>();
	
	public void resolve(String identifier, entity.Relation container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final entity.resource.entity.IEntityReferenceResolveResult<entity.Entity> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public String deResolve(entity.Entity element, entity.Relation container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
