/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package baserequirements.resource.baseRequirements.mopp;

public class BaseRequirementsResourceFactory implements org.eclipse.emf.ecore.resource.Resource.Factory {
	
	public BaseRequirementsResourceFactory() {
		super();
	}
	
	public org.eclipse.emf.ecore.resource.Resource createResource(org.eclipse.emf.common.util.URI uri) {
		return new baserequirements.resource.baseRequirements.mopp.BaseRequirementsResource(uri);
	}
	
}
