/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package baserequirements.resource.baserequirements.mopp;

/**
 * A FuzzyResolveResult is an implementation of the
 * IBaserequirementsReferenceResolveResult interface that delegates all method
 * calls to a given IBaserequirementsReferenceResolveResult with ReferenceType
 * EObject. It is used by reference resolver switches to collect results from
 * different reference resolvers in a type safe manner.
 * 
 * @param <ReferenceType> the type of the reference that is resolved
 */
public class BaserequirementsFuzzyResolveResult<ReferenceType extends org.eclipse.emf.ecore.EObject> implements baserequirements.resource.baserequirements.IBaserequirementsReferenceResolveResult<ReferenceType> {
	
	private baserequirements.resource.baserequirements.IBaserequirementsReferenceResolveResult<org.eclipse.emf.ecore.EObject> delegate;
	
	public BaserequirementsFuzzyResolveResult(baserequirements.resource.baserequirements.IBaserequirementsReferenceResolveResult<org.eclipse.emf.ecore.EObject> delegate) {
		this.delegate = delegate;
	}
	
	public String getErrorMessage() {
		return delegate.getErrorMessage();
	}
	
	public java.util.Collection<baserequirements.resource.baserequirements.IBaserequirementsReferenceMapping<ReferenceType>> getMappings() {
		return null;
	}
	
	public boolean wasResolved() {
		return delegate.wasResolved();
	}
	
	public boolean wasResolvedMultiple() {
		return delegate.wasResolvedMultiple();
	}
	
	public boolean wasResolvedUniquely() {
		return delegate.wasResolvedUniquely();
	}
	
	public void setErrorMessage(String message) {
		delegate.setErrorMessage(message);
	}
	
	public void addMapping(String identifier, ReferenceType target) {
		delegate.addMapping(identifier, (org.eclipse.emf.ecore.EObject) target);
	}
	
	public void addMapping(String identifier, org.eclipse.emf.common.util.URI uri) {
		delegate.addMapping(identifier, uri);
	}
	
	public void addMapping(String identifier, ReferenceType target, String warning) {
		delegate.addMapping(identifier, (org.eclipse.emf.ecore.EObject) target, warning);
	}
	
	public void addMapping(String identifier, org.eclipse.emf.common.util.URI uri, String warning) {
		delegate.addMapping(identifier, uri, warning);
	}
	
	public java.util.Collection<baserequirements.resource.baserequirements.IBaserequirementsQuickFix> getQuickFixes() {
		return delegate.getQuickFixes();
	}
	
	public void addQuickFix(baserequirements.resource.baserequirements.IBaserequirementsQuickFix quickFix) {
		delegate.addQuickFix(quickFix);
	}
	
}
