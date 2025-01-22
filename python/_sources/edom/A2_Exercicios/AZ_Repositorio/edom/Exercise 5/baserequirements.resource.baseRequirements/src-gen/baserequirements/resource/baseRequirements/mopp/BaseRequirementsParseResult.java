/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package baserequirements.resource.baseRequirements.mopp;

public class BaseRequirementsParseResult implements baserequirements.resource.baseRequirements.IBaseRequirementsParseResult {
	
	private org.eclipse.emf.ecore.EObject root;
	private java.util.Collection<baserequirements.resource.baseRequirements.IBaseRequirementsCommand<baserequirements.resource.baseRequirements.IBaseRequirementsTextResource>> commands = new java.util.ArrayList<baserequirements.resource.baseRequirements.IBaseRequirementsCommand<baserequirements.resource.baseRequirements.IBaseRequirementsTextResource>>();
	
	public BaseRequirementsParseResult() {
		super();
	}
	
	public void setRoot(org.eclipse.emf.ecore.EObject root) {
		this.root = root;
	}
	
	public org.eclipse.emf.ecore.EObject getRoot() {
		return root;
	}
	
	public java.util.Collection<baserequirements.resource.baseRequirements.IBaseRequirementsCommand<baserequirements.resource.baseRequirements.IBaseRequirementsTextResource>> getPostParseCommands() {
		return commands;
	}
	
}
