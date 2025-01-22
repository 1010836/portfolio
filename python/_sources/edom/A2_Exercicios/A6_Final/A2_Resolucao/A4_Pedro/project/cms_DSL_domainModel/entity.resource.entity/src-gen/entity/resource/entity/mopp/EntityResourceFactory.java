/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package entity.resource.entity.mopp;

public class EntityResourceFactory implements org.eclipse.emf.ecore.resource.Resource.Factory {
	
	public EntityResourceFactory() {
		super();
	}
	
	public org.eclipse.emf.ecore.resource.Resource createResource(org.eclipse.emf.common.util.URI uri) {
		return new entity.resource.entity.mopp.EntityResource(uri);
	}
	
}
