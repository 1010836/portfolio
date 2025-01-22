/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package baserequirements.resource.baseRequirements.mopp;

public class BaseRequirementsResourcePostProcessor implements baserequirements.resource.baseRequirements.IBaseRequirementsResourcePostProcessor {
	
	public void process(baserequirements.resource.baseRequirements.mopp.BaseRequirementsResource resource) {
		// Set the overrideResourcePostProcessor option to false to customize resource
		// post processing.
	}
	
	public void terminate() {
		// To signal termination to the process() method, setting a boolean field is
		// recommended. Depending on the value of this field process() can stop its
		// computation. However, this is only required for computation intensive
		// post-processors.
	}
	
}
