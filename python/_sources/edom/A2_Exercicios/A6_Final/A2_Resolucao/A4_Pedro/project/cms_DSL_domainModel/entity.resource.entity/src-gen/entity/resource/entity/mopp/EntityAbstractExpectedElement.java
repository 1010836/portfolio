/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package entity.resource.entity.mopp;

/**
 * Abstract super class for all expected elements. Provides methods to add
 * followers.
 */
public abstract class EntityAbstractExpectedElement implements entity.resource.entity.IEntityExpectedElement {
	
	private org.eclipse.emf.ecore.EClass ruleMetaclass;
	
	private java.util.Set<entity.resource.entity.util.EntityPair<entity.resource.entity.IEntityExpectedElement, entity.resource.entity.mopp.EntityContainedFeature[]>> followers = new java.util.LinkedHashSet<entity.resource.entity.util.EntityPair<entity.resource.entity.IEntityExpectedElement, entity.resource.entity.mopp.EntityContainedFeature[]>>();
	
	public EntityAbstractExpectedElement(org.eclipse.emf.ecore.EClass ruleMetaclass) {
		super();
		this.ruleMetaclass = ruleMetaclass;
	}
	
	public org.eclipse.emf.ecore.EClass getRuleMetaclass() {
		return ruleMetaclass;
	}
	
	public void addFollower(entity.resource.entity.IEntityExpectedElement follower, entity.resource.entity.mopp.EntityContainedFeature[] path) {
		followers.add(new entity.resource.entity.util.EntityPair<entity.resource.entity.IEntityExpectedElement, entity.resource.entity.mopp.EntityContainedFeature[]>(follower, path));
	}
	
	public java.util.Collection<entity.resource.entity.util.EntityPair<entity.resource.entity.IEntityExpectedElement, entity.resource.entity.mopp.EntityContainedFeature[]>> getFollowers() {
		return followers;
	}
	
}
