/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package entity.resource.entity.mopp;

/**
 * A basic implementation of the entity.resource.entity.IEntityURIMapping
 * interface that can map identifiers to URIs.
 * 
 * @param <ReferenceType> unused type parameter which is needed to implement
 * entity.resource.entity.IEntityURIMapping.
 */
public class EntityURIMapping<ReferenceType> implements entity.resource.entity.IEntityURIMapping<ReferenceType> {
	
	private org.eclipse.emf.common.util.URI uri;
	private String identifier;
	private String warning;
	
	public EntityURIMapping(String identifier, org.eclipse.emf.common.util.URI newIdentifier, String warning) {
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
