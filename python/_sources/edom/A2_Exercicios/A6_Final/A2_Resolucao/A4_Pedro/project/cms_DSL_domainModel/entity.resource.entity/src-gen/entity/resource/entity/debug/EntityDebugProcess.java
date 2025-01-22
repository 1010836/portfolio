/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package entity.resource.entity.debug;

public class EntityDebugProcess extends entity.resource.entity.debug.EntityDebugElement implements org.eclipse.debug.core.model.IProcess, entity.resource.entity.debug.IEntityDebugEventListener {
	
	private org.eclipse.debug.core.ILaunch launch;
	
	private boolean terminated = false;
	
	public EntityDebugProcess(org.eclipse.debug.core.ILaunch launch) {
		super(launch.getDebugTarget());
		this.launch = launch;
	}
	
	public boolean canTerminate() {
		return !terminated;
	}
	
	public boolean isTerminated() {
		return terminated;
	}
	
	public void terminate() throws org.eclipse.debug.core.DebugException {
		terminated = true;
	}
	
	public String getLabel() {
		return null;
	}
	
	public org.eclipse.debug.core.ILaunch getLaunch() {
		return launch;
	}
	
	public org.eclipse.debug.core.model.IStreamsProxy getStreamsProxy() {
		return null;
	}
	
	public void setAttribute(String key, String value) {
	}
	
	public String getAttribute(String key) {
		return null;
	}
	
	public int getExitValue() throws org.eclipse.debug.core.DebugException {
		return 0;
	}
	
	public void handleMessage(entity.resource.entity.debug.EntityDebugMessage message) {
		if (message.hasType(entity.resource.entity.debug.EEntityDebugMessageTypes.TERMINATED)) {
			terminated = true;
		} else {
			// ignore other events
		}
	}
	
}
