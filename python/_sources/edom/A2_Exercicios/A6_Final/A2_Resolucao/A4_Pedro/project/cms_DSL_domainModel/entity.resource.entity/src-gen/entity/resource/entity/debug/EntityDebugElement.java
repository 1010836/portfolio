/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package entity.resource.entity.debug;

public abstract class EntityDebugElement extends org.eclipse.debug.core.model.DebugElement {
	
	/**
	 * Constructs a new debug element in the given target.
	 */
	public EntityDebugElement(org.eclipse.debug.core.model.IDebugTarget target) {
		super(target);
	}
	
	public String getModelIdentifier() {
		return entity.resource.entity.mopp.EntityPlugin.DEBUG_MODEL_ID;
	}
	
	/**
	 * Returns the breakpoint manager.
	 * 
	 * @return the breakpoint manager
	 */
	protected org.eclipse.debug.core.IBreakpointManager getBreakpointManager() {
		return org.eclipse.debug.core.DebugPlugin.getDefault().getBreakpointManager();
	}
	
}
