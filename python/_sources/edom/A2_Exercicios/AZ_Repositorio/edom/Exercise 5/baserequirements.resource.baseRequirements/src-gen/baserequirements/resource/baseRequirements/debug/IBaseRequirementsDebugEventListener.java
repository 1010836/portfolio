/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package baserequirements.resource.baseRequirements.debug;

public interface IBaseRequirementsDebugEventListener {
	
	/**
	 * Notification that the given event occurred in the while debugging.
	 */
	public void handleMessage(baserequirements.resource.baseRequirements.debug.BaseRequirementsDebugMessage message);
}
