/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package baserequirements.resource.baseRequirements.mopp;

/**
 * A basic implementation of the
 * baserequirements.resource.baseRequirements.IBaseRequirementsURIMapping
 * interface that can map identifiers to URIs.
 * 
 * @param <ReferenceType> unused type parameter which is needed to implement
 * baserequirements.resource.baseRequirements.IBaseRequirementsURIMapping.
 */
public class BaseRequirementsURIMapping<ReferenceType> implements baserequirements.resource.baseRequirements.IBaseRequirementsURIMapping<ReferenceType> {
	
	private org.eclipse.emf.common.util.URI uri;
	private String identifier;
	private String warning;
	
	public BaseRequirementsURIMapping(String identifier, org.eclipse.emf.common.util.URI newIdentifier, String warning) {
		super();
		this.uri = newIdentifier;
		this.identifier = identifier;
		this.warning = warning;
	}
	
	public org.eclipse.emf.common.util.URI getTargetIdentifier() {
		return uri;
	}
	
	public String getIdentifier() {
		return identifier;
	}
	
	public String getWarning() {
		return warning;
	}
	
}
