/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package entity.resource.entity.mopp;

public class EntityParseResult implements entity.resource.entity.IEntityParseResult {
	
	private org.eclipse.emf.ecore.EObject root;
	private java.util.Collection<entity.resource.entity.IEntityCommand<entity.resource.entity.IEntityTextResource>> commands = new java.util.ArrayList<entity.resource.entity.IEntityCommand<entity.resource.entity.IEntityTextResource>>();
	
	public EntityParseResult() {
		super();
	}
	
	public void setRoot(org.eclipse.emf.ecore.EObject root) {
		this.root = root;
	}
	
	public org.eclipse.emf.ecore.EObject getRoot() {
		return root;
	}
	
	public java.util.Collection<entity.resource.entity.IEntityCommand<entity.resource.entity.IEntityTextResource>> getPostParseCommands() {
		return commands;
	}
	
}
