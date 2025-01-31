/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package baserequirements.resource.baseRequirements;

/**
 * An interface used to access the result of parsing a document.
 */
public interface IBaseRequirementsParseResult {
	
	/**
	 * Returns the root object of the document.
	 */
	public org.eclipse.emf.ecore.EObject getRoot();
	
	/**
	 * Returns a list of commands that must be executed after parsing the document.
	 */
	public java.util.Collection<baserequirements.resource.baseRequirements.IBaseRequirementsCommand<baserequirements.resource.baseRequirements.IBaseRequirementsTextResource>> getPostParseCommands();
	
}
