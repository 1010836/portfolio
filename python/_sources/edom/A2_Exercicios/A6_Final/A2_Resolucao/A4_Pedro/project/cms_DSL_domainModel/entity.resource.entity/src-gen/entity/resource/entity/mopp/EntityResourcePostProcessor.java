/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package entity.resource.entity.mopp;

public class EntityResourcePostProcessor implements entity.resource.entity.IEntityResourcePostProcessor {
	
	public void process(entity.resource.entity.mopp.EntityResource resource) {
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
