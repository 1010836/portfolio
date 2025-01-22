/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package entity.resource.entity.mopp;

public class EntityReferenceResolverSwitch implements entity.resource.entity.IEntityReferenceResolverSwitch {
	
	/**
	 * This map stores a copy of the options the were set for loading the resource.
	 */
	private java.util.Map<Object, Object> options;
	
	protected entity.resource.entity.analysis.RelationRelEntityReferenceResolver relationRelEntityReferenceResolver = new entity.resource.entity.analysis.RelationRelEntityReferenceResolver();
	
	public entity.resource.entity.IEntityReferenceResolver<entity.Relation, entity.Entity> getRelationRelEntityReferenceResolver() {
		return getResolverChain(entity.EntityPackage.eINSTANCE.getRelation_RelEntity(), relationRelEntityReferenceResolver);
	}
	
	public void setOptions(java.util.Map<?, ?> options) {
		if (options != null) {
			this.options = new java.util.LinkedHashMap<Object, Object>();
			this.options.putAll(options);
		}
		relationRelEntityReferenceResolver.setOptions(options);
	}
	
	public void resolveFuzzy(String identifier, org.eclipse.emf.ecore.EObject container, org.eclipse.emf.ecore.EReference reference, int position, entity.resource.entity.IEntityReferenceResolveResult<org.eclipse.emf.ecore.EObject> result) {
		if (container == null) {
			return;
		}
		if (entity.EntityPackage.eINSTANCE.getRelation().isInstance(container)) {
			EntityFuzzyResolveResult<entity.Entity> frr = new EntityFuzzyResolveResult<entity.Entity>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("RelEntity")) {
				relationRelEntityReferenceResolver.resolve(identifier, (entity.Relation) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
	}
	
	public entity.resource.entity.IEntityReferenceResolver<? extends org.eclipse.emf.ecore.EObject, ? extends org.eclipse.emf.ecore.EObject> getResolver(org.eclipse.emf.ecore.EStructuralFeature reference) {
		if (reference == entity.EntityPackage.eINSTANCE.getRelation_RelEntity()) {
			return getResolverChain(reference, relationRelEntityReferenceResolver);
		}
		return null;
	}
	
	@SuppressWarnings({"rawtypes", "unchecked"})	
	public <ContainerType extends org.eclipse.emf.ecore.EObject, ReferenceType extends org.eclipse.emf.ecore.EObject> entity.resource.entity.IEntityReferenceResolver<ContainerType, ReferenceType> getResolverChain(org.eclipse.emf.ecore.EStructuralFeature reference, entity.resource.entity.IEntityReferenceResolver<ContainerType, ReferenceType> originalResolver) {
		if (options == null) {
			return originalResolver;
		}
		Object value = options.get(entity.resource.entity.IEntityOptions.ADDITIONAL_REFERENCE_RESOLVERS);
		if (value == null) {
			return originalResolver;
		}
		if (!(value instanceof java.util.Map)) {
			// send this to the error log
			new entity.resource.entity.util.EntityRuntimeUtil().logWarning("Found value with invalid type for option " + entity.resource.entity.IEntityOptions.ADDITIONAL_REFERENCE_RESOLVERS + " (expected " + java.util.Map.class.getName() + ", but was " + value.getClass().getName() + ")", null);
			return originalResolver;
		}
		java.util.Map<?,?> resolverMap = (java.util.Map<?,?>) value;
		Object resolverValue = resolverMap.get(reference);
		if (resolverValue == null) {
			return originalResolver;
		}
		if (resolverValue instanceof entity.resource.entity.IEntityReferenceResolver) {
			entity.resource.entity.IEntityReferenceResolver replacingResolver = (entity.resource.entity.IEntityReferenceResolver) resolverValue;
			if (replacingResolver instanceof entity.resource.entity.IEntityDelegatingReferenceResolver) {
				// pass original resolver to the replacing one
				((entity.resource.entity.IEntityDelegatingReferenceResolver) replacingResolver).setDelegate(originalResolver);
			}
			return replacingResolver;
		} else if (resolverValue instanceof java.util.Collection) {
			java.util.Collection replacingResolvers = (java.util.Collection) resolverValue;
			entity.resource.entity.IEntityReferenceResolver replacingResolver = originalResolver;
			for (Object next : replacingResolvers) {
				if (next instanceof entity.resource.entity.IEntityReferenceCache) {
					entity.resource.entity.IEntityReferenceResolver nextResolver = (entity.resource.entity.IEntityReferenceResolver) next;
					if (nextResolver instanceof entity.resource.entity.IEntityDelegatingReferenceResolver) {
						// pass original resolver to the replacing one
						((entity.resource.entity.IEntityDelegatingReferenceResolver) nextResolver).setDelegate(replacingResolver);
					}
					replacingResolver = nextResolver;
				} else {
					// The collection contains a non-resolver. Send a warning to the error log.
					new entity.resource.entity.util.EntityRuntimeUtil().logWarning("Found value with invalid type in value map for option " + entity.resource.entity.IEntityOptions.ADDITIONAL_REFERENCE_RESOLVERS + " (expected " + entity.resource.entity.IEntityDelegatingReferenceResolver.class.getName() + ", but was " + next.getClass().getName() + ")", null);
				}
			}
			return replacingResolver;
		} else {
			// The value for the option ADDITIONAL_REFERENCE_RESOLVERS has an unknown type.
			new entity.resource.entity.util.EntityRuntimeUtil().logWarning("Found value with invalid type in value map for option " + entity.resource.entity.IEntityOptions.ADDITIONAL_REFERENCE_RESOLVERS + " (expected " + entity.resource.entity.IEntityDelegatingReferenceResolver.class.getName() + ", but was " + resolverValue.getClass().getName() + ")", null);
			return originalResolver;
		}
	}
	
}
