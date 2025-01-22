/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package entity.resource.entity.debug;

public class EntitySourceLookupParticipant extends org.eclipse.debug.core.sourcelookup.AbstractSourceLookupParticipant {
	
	public String getSourceName(Object object) throws org.eclipse.core.runtime.CoreException {
		if (object instanceof entity.resource.entity.debug.EntityStackFrame) {
			entity.resource.entity.debug.EntityStackFrame frame = (entity.resource.entity.debug.EntityStackFrame) object;
			return frame.getResourceURI();
		}
		return null;
	}
	
}
