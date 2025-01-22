/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package entity.resource.entity.grammar;

public class EntityContainment extends entity.resource.entity.grammar.EntityTerminal {
	
	private final org.eclipse.emf.ecore.EClass[] allowedTypes;
	
	public EntityContainment(org.eclipse.emf.ecore.EStructuralFeature feature, entity.resource.entity.grammar.EntityCardinality cardinality, org.eclipse.emf.ecore.EClass[] allowedTypes, int mandatoryOccurencesAfter) {
		super(feature, cardinality, mandatoryOccurencesAfter);
		this.allowedTypes = allowedTypes;
	}
	
	public org.eclipse.emf.ecore.EClass[] getAllowedTypes() {
		return allowedTypes;
	}
	
	public String toString() {
		String typeRestrictions = null;
		if (allowedTypes != null && allowedTypes.length > 0) {
			typeRestrictions = entity.resource.entity.util.EntityStringUtil.explode(allowedTypes, ", ", new entity.resource.entity.IEntityFunction1<String, org.eclipse.emf.ecore.EClass>() {
				public String execute(org.eclipse.emf.ecore.EClass eClass) {
					return eClass.getName();
				}
			});
		}
		return getFeature().getName() + (typeRestrictions == null ? "" : "[" + typeRestrictions + "]");
	}
	
}
