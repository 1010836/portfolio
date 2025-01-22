/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package entity.resource.entity;

/**
 * An interface used to access the result of parsing a document.
 */
public interface IEntityParseResult {
	
	/**
	 * Returns the root object of the document.
	 */
	public org.eclipse.emf.ecore.EObject getRoot();
	
	/**
	 * Returns a list of commands that must be executed after parsing the document.
	 */
	public java.util.Collection<entity.resource.entity.IEntityCommand<entity.resource.entity.IEntityTextResource>> getPostParseCommands();
	
}
