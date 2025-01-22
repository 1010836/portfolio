/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package entity.resource.entity.debug;

public interface IEntityDebugEventListener {
	
	/**
	 * Notification that the given event occurred in the while debugging.
	 */
	public void handleMessage(entity.resource.entity.debug.EntityDebugMessage message);
}
