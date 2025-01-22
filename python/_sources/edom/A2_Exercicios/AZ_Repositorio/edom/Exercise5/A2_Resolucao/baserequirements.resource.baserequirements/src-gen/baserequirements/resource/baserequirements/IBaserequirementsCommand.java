/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package baserequirements.resource.baserequirements;

/**
 * A simple interface for commands that can be executed and that return
 * information about the success of their execution.
 */
public interface IBaserequirementsCommand<ContextType> {
	
	public boolean execute(ContextType context);
}
