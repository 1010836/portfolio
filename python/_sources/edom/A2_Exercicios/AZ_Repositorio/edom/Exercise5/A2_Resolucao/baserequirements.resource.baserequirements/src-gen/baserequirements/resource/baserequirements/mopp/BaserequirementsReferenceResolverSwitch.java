/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package baserequirements.resource.baserequirements.mopp;

public class BaserequirementsReferenceResolverSwitch implements baserequirements.resource.baserequirements.IBaserequirementsReferenceResolverSwitch {
	
	/**
	 * This map stores a copy of the options the were set for loading the resource.
	 */
	private java.util.Map<Object, Object> options;
	
	protected baserequirements.resource.baserequirements.analysis.RequirementGroupParentReferenceResolver requirementGroupParentReferenceResolver = new baserequirements.resource.baserequirements.analysis.RequirementGroupParentReferenceResolver();
	protected baserequirements.resource.baserequirements.analysis.RequirementDependenciesReferenceResolver requirementDependenciesReferenceResolver = new baserequirements.resource.baserequirements.analysis.RequirementDependenciesReferenceResolver();
	protected baserequirements.resource.baserequirements.analysis.RequirementParentReferenceResolver requirementParentReferenceResolver = new baserequirements.resource.baserequirements.analysis.RequirementParentReferenceResolver();
	
	public baserequirements.resource.baserequirements.IBaserequirementsReferenceResolver<baserequirements.RequirementGroup, baserequirements.RequirementGroup> getRequirementGroupParentReferenceResolver() {
		return getResolverChain(baserequirements.BaserequirementsPackage.eINSTANCE.getRequirementGroup_Parent(), requirementGroupParentReferenceResolver);
	}
	
	public baserequirements.resource.baserequirements.IBaserequirementsReferenceResolver<baserequirements.Requirement, baserequirements.Requirement> getRequirementDependenciesReferenceResolver() {
		return getResolverChain(baserequirements.BaserequirementsPackage.eINSTANCE.getRequirement_Dependencies(), requirementDependenciesReferenceResolver);
	}
	
	public baserequirements.resource.baserequirements.IBaserequirementsReferenceResolver<baserequirements.Requirement, baserequirements.Requirement> getRequirementParentReferenceResolver() {
		return getResolverChain(baserequirements.BaserequirementsPackage.eINSTANCE.getRequirement_Parent(), requirementParentReferenceResolver);
	}
	
	public void setOptions(java.util.Map<?, ?> options) {
		if (options != null) {
			this.options = new java.util.LinkedHashMap<Object, Object>();
			this.options.putAll(options);
		}
		requirementGroupParentReferenceResolver.setOptions(options);
		requirementDependenciesReferenceResolver.setOptions(options);
		requirementParentReferenceResolver.setOptions(options);
	}
	
	public void resolveFuzzy(String identifier, org.eclipse.emf.ecore.EObject container, org.eclipse.emf.ecore.EReference reference, int position, baserequirements.resource.baserequirements.IBaserequirementsReferenceResolveResult<org.eclipse.emf.ecore.EObject> result) {
		if (container == null) {
			return;
		}
		if (baserequirements.BaserequirementsPackage.eINSTANCE.getRequirementGroup().isInstance(container)) {
			BaserequirementsFuzzyResolveResult<baserequirements.RequirementGroup> frr = new BaserequirementsFuzzyResolveResult<baserequirements.RequirementGroup>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("parent")) {
				requirementGroupParentReferenceResolver.resolve(identifier, (baserequirements.RequirementGroup) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (baserequirements.BaserequirementsPackage.eINSTANCE.getRequirement().isInstance(container)) {
			BaserequirementsFuzzyResolveResult<baserequirements.Requirement> frr = new BaserequirementsFuzzyResolveResult<baserequirements.Requirement>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("dependencies")) {
				requirementDependenciesReferenceResolver.resolve(identifier, (baserequirements.Requirement) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (baserequirements.BaserequirementsPackage.eINSTANCE.getRequirement().isInstance(container)) {
			BaserequirementsFuzzyResolveResult<baserequirements.Requirement> frr = new BaserequirementsFuzzyResolveResult<baserequirements.Requirement>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("parent")) {
				requirementParentReferenceResolver.resolve(identifier, (baserequirements.Requirement) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
	}
	
	public baserequirements.resource.baserequirements.IBaserequirementsReferenceResolver<? extends org.eclipse.emf.ecore.EObject, ? extends org.eclipse.emf.ecore.EObject> getResolver(org.eclipse.emf.ecore.EStructuralFeature reference) {
		if (reference == baserequirements.BaserequirementsPackage.eINSTANCE.getRequirementGroup_Parent()) {
			return getResolverChain(reference, requirementGroupParentReferenceResolver);
		}
		if (reference == baserequirements.BaserequirementsPackage.eINSTANCE.getRequirement_Dependencies()) {
			return getResolverChain(reference, requirementDependenciesReferenceResolver);
		}
		if (reference == baserequirements.BaserequirementsPackage.eINSTANCE.getRequirement_Parent()) {
			return getResolverChain(reference, requirementParentReferenceResolver);
		}
		return null;
	}
	
	@SuppressWarnings({"rawtypes", "unchecked"})	
	public <ContainerType extends org.eclipse.emf.ecore.EObject, ReferenceType extends org.eclipse.emf.ecore.EObject> baserequirements.resource.baserequirements.IBaserequirementsReferenceResolver<ContainerType, ReferenceType> getResolverChain(org.eclipse.emf.ecore.EStructuralFeature reference, baserequirements.resource.baserequirements.IBaserequirementsReferenceResolver<ContainerType, ReferenceType> originalResolver) {
		if (options == null) {
			return originalResolver;
		}
		Object value = options.get(baserequirements.resource.baserequirements.IBaserequirementsOptions.ADDITIONAL_REFERENCE_RESOLVERS);
		if (value == null) {
			return originalResolver;
		}
		if (!(value instanceof java.util.Map)) {
			// send this to the error log
			new baserequirements.resource.baserequirements.util.BaserequirementsRuntimeUtil().logWarning("Found value with invalid type for option " + baserequirements.resource.baserequirements.IBaserequirementsOptions.ADDITIONAL_REFERENCE_RESOLVERS + " (expected " + java.util.Map.class.getName() + ", but was " + value.getClass().getName() + ")", null);
			return originalResolver;
		}
		java.util.Map<?,?> resolverMap = (java.util.Map<?,?>) value;
		Object resolverValue = resolverMap.get(reference);
		if (resolverValue == null) {
			return originalResolver;
		}
		if (resolverValue instanceof baserequirements.resource.baserequirements.IBaserequirementsReferenceResolver) {
			baserequirements.resource.baserequirements.IBaserequirementsReferenceResolver replacingResolver = (baserequirements.resource.baserequirements.IBaserequirementsReferenceResolver) resolverValue;
			if (replacingResolver instanceof baserequirements.resource.baserequirements.IBaserequirementsDelegatingReferenceResolver) {
				// pass original resolver to the replacing one
				((baserequirements.resource.baserequirements.IBaserequirementsDelegatingReferenceResolver) replacingResolver).setDelegate(originalResolver);
			}
			return replacingResolver;
		} else if (resolverValue instanceof java.util.Collection) {
			java.util.Collection replacingResolvers = (java.util.Collection) resolverValue;
			baserequirements.resource.baserequirements.IBaserequirementsReferenceResolver replacingResolver = originalResolver;
			for (Object next : replacingResolvers) {
				if (next instanceof baserequirements.resource.baserequirements.IBaserequirementsReferenceCache) {
					baserequirements.resource.baserequirements.IBaserequirementsReferenceResolver nextResolver = (baserequirements.resource.baserequirements.IBaserequirementsReferenceResolver) next;
					if (nextResolver instanceof baserequirements.resource.baserequirements.IBaserequirementsDelegatingReferenceResolver) {
						// pass original resolver to the replacing one
						((baserequirements.resource.baserequirements.IBaserequirementsDelegatingReferenceResolver) nextResolver).setDelegate(replacingResolver);
					}
					replacingResolver = nextResolver;
				} else {
					// The collection contains a non-resolver. Send a warning to the error log.
					new baserequirements.resource.baserequirements.util.BaserequirementsRuntimeUtil().logWarning("Found value with invalid type in value map for option " + baserequirements.resource.baserequirements.IBaserequirementsOptions.ADDITIONAL_REFERENCE_RESOLVERS + " (expected " + baserequirements.resource.baserequirements.IBaserequirementsDelegatingReferenceResolver.class.getName() + ", but was " + next.getClass().getName() + ")", null);
				}
			}
			return replacingResolver;
		} else {
			// The value for the option ADDITIONAL_REFERENCE_RESOLVERS has an unknown type.
			new baserequirements.resource.baserequirements.util.BaserequirementsRuntimeUtil().logWarning("Found value with invalid type in value map for option " + baserequirements.resource.baserequirements.IBaserequirementsOptions.ADDITIONAL_REFERENCE_RESOLVERS + " (expected " + baserequirements.resource.baserequirements.IBaserequirementsDelegatingReferenceResolver.class.getName() + ", but was " + resolverValue.getClass().getName() + ")", null);
			return originalResolver;
		}
	}
	
}
