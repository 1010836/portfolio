/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package baserequirements.resource.baserequirements.mopp;

/**
 * A basic implementation of the
 * baserequirements.resource.baserequirements.IBaserequirementsReferenceResolveResu
 * lt interface that collects mappings in a list.
 * 
 * @param <ReferenceType> the type of the references that can be contained in this
 * result
 */
public class BaserequirementsReferenceResolveResult<ReferenceType> implements baserequirements.resource.baserequirements.IBaserequirementsReferenceResolveResult<ReferenceType> {
	
	private java.util.Collection<baserequirements.resource.baserequirements.IBaserequirementsReferenceMapping<ReferenceType>> mappings;
	private String errorMessage;
	private boolean resolveFuzzy;
	private java.util.Set<baserequirements.resource.baserequirements.IBaserequirementsQuickFix> quickFixes;
	
	public BaserequirementsReferenceResolveResult(boolean resolveFuzzy) {
		super();
		this.resolveFuzzy = resolveFuzzy;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
	
	public java.util.Collection<baserequirements.resource.baserequirements.IBaserequirementsQuickFix> getQuickFixes() {
		if (quickFixes == null) {
			quickFixes = new java.util.LinkedHashSet<baserequirements.resource.baserequirements.IBaserequirementsQuickFix>();
		}
		return java.util.Collections.unmodifiableSet(quickFixes);
	}
	
	public void addQuickFix(baserequirements.resource.baserequirements.IBaserequirementsQuickFix quickFix) {
		if (quickFixes == null) {
			quickFixes = new java.util.LinkedHashSet<baserequirements.resource.baserequirements.IBaserequirementsQuickFix>();
		}
		quickFixes.add(quickFix);
	}
	
	public java.util.Collection<baserequirements.resource.baserequirements.IBaserequirementsReferenceMapping<ReferenceType>> getMappings() {
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
			mappings = new java.util.ArrayList<baserequirements.resource.baserequirements.IBaserequirementsReferenceMapping<ReferenceType>>(1);
		}
		mappings.add(new baserequirements.resource.baserequirements.mopp.BaserequirementsElementMapping<ReferenceType>(identifier, target, warning));
		errorMessage = null;
	}
	
	public void addMapping(String identifier, org.eclipse.emf.common.util.URI uri) {
		addMapping(identifier, uri, null);
	}
	
	public void addMapping(String identifier, org.eclipse.emf.common.util.URI uri, String warning) {
		if (mappings == null) {
			mappings = new java.util.ArrayList<baserequirements.resource.baserequirements.IBaserequirementsReferenceMapping<ReferenceType>>(1);
		}
		mappings.add(new baserequirements.resource.baserequirements.mopp.BaserequirementsURIMapping<ReferenceType>(identifier, uri, warning));
	}
}
