/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package baserequirements.resource.baseRequirements.mopp;

/**
 * An implementation of the ResolveResult interface that delegates all method
 * calls to another ResolveResult. Client may subclass this class to easily create
 * custom ResolveResults.
 * 
 * @param <ReferenceType> the type of the references that can be contained in this
 * result
 */
public class BaseRequirementsDelegatingResolveResult<ReferenceType> implements baserequirements.resource.baseRequirements.IBaseRequirementsReferenceResolveResult<ReferenceType> {
	
	private baserequirements.resource.baseRequirements.IBaseRequirementsReferenceResolveResult<ReferenceType> delegate;
	
	public BaseRequirementsDelegatingResolveResult(baserequirements.resource.baseRequirements.IBaseRequirementsReferenceResolveResult<ReferenceType> delegate) {
		this.delegate = delegate;
	}
	
	public String getErrorMessage() {
		return delegate.getErrorMessage();
	}
	
	public java.util.Collection<baserequirements.resource.baseRequirements.IBaseRequirementsReferenceMapping<ReferenceType>> getMappings() {
		return delegate.getMappings();
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
		delegate.addMapping(identifier, target);
	}
	
	public void addMapping(String identifier, org.eclipse.emf.common.util.URI uri) {
		delegate.addMapping(identifier, uri);
	}
	
	public void addMapping(String identifier, ReferenceType target, String warning) {
		delegate.addMapping(identifier, target, warning);
	}
	
	public void addMapping(String identifier, org.eclipse.emf.common.util.URI uri, String warning) {
		delegate.addMapping(identifier, uri, warning);
	}
	
	public java.util.Collection<baserequirements.resource.baseRequirements.IBaseRequirementsQuickFix> getQuickFixes() {
		return delegate.getQuickFixes();
	}
	
	public void addQuickFix(baserequirements.resource.baseRequirements.IBaseRequirementsQuickFix quickFix) {
		delegate.addQuickFix(quickFix);
	}
	
}
