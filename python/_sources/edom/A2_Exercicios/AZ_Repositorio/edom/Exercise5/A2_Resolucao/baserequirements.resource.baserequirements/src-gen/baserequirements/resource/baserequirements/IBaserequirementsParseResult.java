/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package baserequirements.resource.baserequirements;

/**
 * An interface used to access the result of parsing a document.
 */
public interface IBaserequirementsParseResult {
	
	/**
	 * Returns the root object of the document.
	 */
	public org.eclipse.emf.ecore.EObject getRoot();
	
	/**
	 * Returns a list of commands that must be executed after parsing the document.
	 */
	public java.util.Collection<baserequirements.resource.baserequirements.IBaserequirementsCommand<baserequirements.resource.baserequirements.IBaserequirementsTextResource>> getPostParseCommands();
	
}
