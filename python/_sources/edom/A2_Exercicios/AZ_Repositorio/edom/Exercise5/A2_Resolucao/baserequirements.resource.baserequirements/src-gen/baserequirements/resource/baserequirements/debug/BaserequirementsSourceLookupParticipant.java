/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package baserequirements.resource.baserequirements.debug;

public class BaserequirementsSourceLookupParticipant extends org.eclipse.debug.core.sourcelookup.AbstractSourceLookupParticipant {
	
	public String getSourceName(Object object) throws org.eclipse.core.runtime.CoreException {
		if (object instanceof baserequirements.resource.baserequirements.debug.BaserequirementsStackFrame) {
			baserequirements.resource.baserequirements.debug.BaserequirementsStackFrame frame = (baserequirements.resource.baserequirements.debug.BaserequirementsStackFrame) object;
			return frame.getResourceURI();
		}
		return null;
	}
	
}
