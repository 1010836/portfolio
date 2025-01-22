/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package baserequirements.resource.baseRequirements.debug;

public class BaseRequirementsSourceLookupParticipant extends org.eclipse.debug.core.sourcelookup.AbstractSourceLookupParticipant {
	
	public String getSourceName(Object object) throws org.eclipse.core.runtime.CoreException {
		if (object instanceof baserequirements.resource.baseRequirements.debug.BaseRequirementsStackFrame) {
			baserequirements.resource.baseRequirements.debug.BaseRequirementsStackFrame frame = (baserequirements.resource.baseRequirements.debug.BaseRequirementsStackFrame) object;
			return frame.getResourceURI();
		}
		return null;
	}
	
}
