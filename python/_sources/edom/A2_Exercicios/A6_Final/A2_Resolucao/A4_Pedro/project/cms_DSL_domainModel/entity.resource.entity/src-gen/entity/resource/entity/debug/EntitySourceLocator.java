/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package entity.resource.entity.debug;

public class EntitySourceLocator extends org.eclipse.debug.core.sourcelookup.AbstractSourceLookupDirector {
	
	public void initializeParticipants() {
		addParticipants(new org.eclipse.debug.core.sourcelookup.ISourceLookupParticipant[]{new entity.resource.entity.debug.EntitySourceLookupParticipant()});
	}
	
}
