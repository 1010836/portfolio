/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package baserequirements.resource.baseRequirements;

/**
 * A simple interface for commands that can be executed and that return
 * information about the success of their execution.
 */
public interface IBaseRequirementsCommand<ContextType> {
	
	public boolean execute(ContextType context);
}
