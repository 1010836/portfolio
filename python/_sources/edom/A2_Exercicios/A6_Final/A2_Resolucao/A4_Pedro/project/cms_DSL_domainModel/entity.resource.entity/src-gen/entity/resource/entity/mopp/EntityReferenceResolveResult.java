/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package entity.resource.entity.mopp;

/**
 * A basic implementation of the
 * entity.resource.entity.IEntityReferenceResolveResult interface that collects
 * mappings in a list.
 * 
 * @param <ReferenceType> the type of the references that can be contained in this
 * result
 */
public class EntityReferenceResolveResult<ReferenceType> implements entity.resource.entity.IEntityReferenceResolveResult<ReferenceType> {
	
	private java.util.Collection<entity.resource.entity.IEntityReferenceMapping<ReferenceType>> mappings;
	private String errorMessage;
	private boolean resolveFuzzy;
	private java.util.Set<entity.resource.entity.IEntityQuickFix> quickFixes;
	
	public EntityReferenceResolveResult(boolean resolveFuzzy) {
		super();
		this.resolveFuzzy = resolveFuzzy;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
	
	public java.util.Collection<entity.resource.entity.IEntityQuickFix> getQuickFixes() {
		if (quickFixes == null) {
			quickFixes = new java.util.LinkedHashSet<entity.resource.entity.IEntityQuickFix>();
		}
		return java.util.Collections.unmodifiableSet(quickFixes);
	}
	
	public void addQuickFix(entity.resource.entity.IEntityQuickFix quickFix) {
		if (quickFixes == null) {
			quickFixes = new java.util.LinkedHashSet<entity.resource.entity.IEntityQuickFix>();
		}
		quickFixes.add(quickFix);
	}
	
	public java.util.Collection<entity.resource.entity.IEntityReferenceMapping<ReferenceType>> getMappings() {
		return mappings;
	}
	
	public boolean wasResolved() {
		return mappings != null;
	}
	
	public boolean wasResolvedMultiple() {
		return mappings != null && mappings.size() > 1;
	}
	
	public boolean wasResolvedUniquely() {
		return mappings != null && mappings.size() == 1;
	}
	
	public void setErrorMessage(String message) {
		errorMessage = message;
	}
	
	public void addMapping(String identifier, ReferenceType target) {
		if (!resolveFuzzy && target == null) {
			throw new IllegalArgumentException("Mapping references to null is only allowed for fuzzy resolution.");
		}
		addMapping(identifier, target, null);
	}
	
	public void addMapping(String identifier, ReferenceType target, String warning) {
		if (mappings == null) {
			mappings = new java.util.ArrayList<entity.resource.entity.IEntityReferenceMapping<ReferenceType>>(1);
		}
		mappings.add(new entity.resource.entity.mopp.EntityElementMapping<ReferenceType>(identifier, target, warning));
		errorMessage = null;
	}
	
	public void addMapping(String identifier, org.eclipse.emf.common.util.URI uri) {
		addMapping(identifier, uri, null);
	}
	
	public void addMapping(String identifier, org.eclipse.emf.common.util.URI uri, String warning) {
		if (mappings == null) {
			mappings = new java.util.ArrayList<entity.resource.entity.IEntityReferenceMapping<ReferenceType>>(1);
		}
		mappings.add(new entity.resource.entity.mopp.EntityURIMapping<ReferenceType>(identifier, uri, warning));
	}
}
