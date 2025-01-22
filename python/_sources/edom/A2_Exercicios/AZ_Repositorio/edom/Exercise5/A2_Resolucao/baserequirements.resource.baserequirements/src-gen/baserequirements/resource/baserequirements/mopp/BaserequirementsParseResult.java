/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package baserequirements.resource.baserequirements.mopp;

public class BaserequirementsParseResult implements baserequirements.resource.baserequirements.IBaserequirementsParseResult {
	
	private org.eclipse.emf.ecore.EObject root;
	private java.util.Collection<baserequirements.resource.baserequirements.IBaserequirementsCommand<baserequirements.resource.baserequirements.IBaserequirementsTextResource>> commands = new java.util.ArrayList<baserequirements.resource.baserequirements.IBaserequirementsCommand<baserequirements.resource.baserequirements.IBaserequirementsTextResource>>();
	
	public BaserequirementsParseResult() {
		super();
	}
	
	public void setRoot(org.eclipse.emf.ecore.EObject root) {
		this.root = root;
	}
	
	public org.eclipse.emf.ecore.EObject getRoot() {
		return root;
	}
	
	public java.util.Collection<baserequirements.resource.baserequirements.IBaserequirementsCommand<baserequirements.resource.baserequirements.IBaserequirementsTextResource>> getPostParseCommands() {
		return commands;
	}
	
}
