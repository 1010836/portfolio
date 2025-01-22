/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package entity.resource.entity;

/**
 * A simple interface for commands that can be executed and that return
 * information about the success of their execution.
 */
public interface IEntityCommand<ContextType> {
	
	public boolean execute(ContextType context);
}
