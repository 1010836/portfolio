/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package baserequirements.resource.baserequirements.mopp;

public class BaserequirementsResourceFactory implements org.eclipse.emf.ecore.resource.Resource.Factory {
	
	public BaserequirementsResourceFactory() {
		super();
	}
	
	public org.eclipse.emf.ecore.resource.Resource createResource(org.eclipse.emf.common.util.URI uri) {
		return new baserequirements.resource.baserequirements.mopp.BaserequirementsResource(uri);
	}
	
}
