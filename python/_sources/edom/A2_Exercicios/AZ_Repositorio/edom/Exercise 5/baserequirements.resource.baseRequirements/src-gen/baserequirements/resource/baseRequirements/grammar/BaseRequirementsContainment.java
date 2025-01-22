/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package baserequirements.resource.baseRequirements.grammar;

public class BaseRequirementsContainment extends baserequirements.resource.baseRequirements.grammar.BaseRequirementsTerminal {
	
	private final org.eclipse.emf.ecore.EClass[] allowedTypes;
	
	public BaseRequirementsContainment(org.eclipse.emf.ecore.EStructuralFeature feature, baserequirements.resource.baseRequirements.grammar.BaseRequirementsCardinality cardinality, org.eclipse.emf.ecore.EClass[] allowedTypes, int mandatoryOccurencesAfter) {
		super(feature, cardinality, mandatoryOccurencesAfter);
		this.allowedTypes = allowedTypes;
	}
	
	public org.eclipse.emf.ecore.EClass[] getAllowedTypes() {
		return allowedTypes;
	}
	
	public String toString() {
		String typeRestrictions = null;
		if (allowedTypes != null && allowedTypes.length > 0) {
			typeRestrictions = baserequirements.resource.baseRequirements.util.BaseRequirementsStringUtil.explode(allowedTypes, ", ", new baserequirements.resource.baseRequirements.IBaseRequirementsFunction1<String, org.eclipse.emf.ecore.EClass>() {
				public String execute(org.eclipse.emf.ecore.EClass eClass) {
					return eClass.getName();
				}
			});
		}
		return getFeature().getName() + (typeRestrictions == null ? "" : "[" + typeRestrictions + "]");
	}
	
}
