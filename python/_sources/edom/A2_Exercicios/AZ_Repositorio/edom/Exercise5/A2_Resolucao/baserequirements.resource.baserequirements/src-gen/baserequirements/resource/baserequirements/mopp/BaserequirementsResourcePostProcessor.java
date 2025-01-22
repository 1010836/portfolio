/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package baserequirements.resource.baserequirements.mopp;

public class BaserequirementsResourcePostProcessor implements baserequirements.resource.baserequirements.IBaserequirementsResourcePostProcessor {
	
	public void process(baserequirements.resource.baserequirements.mopp.BaserequirementsResource resource) {
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
