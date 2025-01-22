/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package baserequirements.resource.baserequirements.debug;

public interface IBaserequirementsDebugEventListener {
	
	/**
	 * Notification that the given event occurred in the while debugging.
	 */
	public void handleMessage(baserequirements.resource.baserequirements.debug.BaserequirementsDebugMessage message);
}
