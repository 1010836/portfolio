/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package baserequirements.resource.baseRequirements.mopp;

/**
 * A basic implementation of the
 * baserequirements.resource.baseRequirements.IBaseRequirementsReferenceResolveResu
 * lt interface that collects mappings in a list.
 * 
 * @param <ReferenceType> the type of the references that can be contained in this
 * result
 */
public class BaseRequirementsReferenceResolveResult<ReferenceType> implements baserequirements.resource.baseRequirements.IBaseRequirementsReferenceResolveResult<ReferenceType> {
	
	private java.util.Collection<baserequirements.resource.baseRequirements.IBaseRequirementsReferenceMapping<ReferenceType>> mappings;
	private String errorMessage;
	private boolean resolveFuzzy;
	private java.util.Set<baserequirements.resource.baseRequirements.IBaseRequirementsQuickFix> quickFixes;
	
	public BaseRequirementsReferenceResolveResult(boolean resolveFuzzy) {
		super();
		this.resolveFuzzy = resolveFuzzy;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
	
	public java.util.Collection<baserequirements.resource.baseRequirements.IBaseRequirementsQuickFix> getQuickFixes() {
		if (quickFixes == null) {
			quickFixes = new java.util.LinkedHashSet<baserequirements.resource.baseRequirements.IBaseRequirementsQuickFix>();
		}
		return java.util.Collections.unmodifiableSet(quickFixes);
	}
	
	public void addQuickFix(baserequirements.resource.baseRequirements.IBaseRequirementsQuickFix quickFix) {
		if (quickFixes == null) {
			quickFixes = new java.util.LinkedHashSet<baserequirements.resource.baseRequirements.IBaseRequirementsQuickFix>();
		}
		quickFixes.add(quickFix);
	}
	
	public java.util.Collection<baserequirements.resource.baseRequirements.IBaseRequirementsReferenceMapping<ReferenceType>> getMappings() {
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
			mappings = new java.util.ArrayList<baserequirements.resource.baseRequirements.IBaseRequirementsReferenceMapping<ReferenceType>>(1);
		}
		mappings.add(new baserequirements.resource.baseRequirements.mopp.BaseRequirementsElementMapping<ReferenceType>(identifier, target, warning));
		errorMessage = null;
	}
	
	public void addMapping(String identifier, org.eclipse.emf.common.util.URI uri) {
		addMapping(identifier, uri, null);
	}
	
	public void addMapping(String identifier, org.eclipse.emf.common.util.URI uri, String warning) {
		if (mappings == null) {
			mappings = new java.util.ArrayList<baserequirements.resource.baseRequirements.IBaseRequirementsReferenceMapping<ReferenceType>>(1);
		}
		mappings.add(new baserequirements.resource.baseRequirements.mopp.BaseRequirementsURIMapping<ReferenceType>(identifier, uri, warning));
	}
}
