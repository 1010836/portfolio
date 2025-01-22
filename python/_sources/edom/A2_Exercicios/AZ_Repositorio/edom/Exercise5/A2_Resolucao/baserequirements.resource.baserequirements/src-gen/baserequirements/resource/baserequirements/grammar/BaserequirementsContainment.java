/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package baserequirements.resource.baserequirements.grammar;

public class BaserequirementsContainment extends baserequirements.resource.baserequirements.grammar.BaserequirementsTerminal {
	
	private final org.eclipse.emf.ecore.EClass[] allowedTypes;
	
	public BaserequirementsContainment(org.eclipse.emf.ecore.EStructuralFeature feature, baserequirements.resource.baserequirements.grammar.BaserequirementsCardinality cardinality, org.eclipse.emf.ecore.EClass[] allowedTypes, int mandatoryOccurencesAfter) {
		super(feature, cardinality, mandatoryOccurencesAfter);
		this.allowedTypes = allowedTypes;
	}
	
	public org.eclipse.emf.ecore.EClass[] getAllowedTypes() {
		return allowedTypes;
	}
	
	public String toString() {
		String typeRestrictions = null;
		if (allowedTypes != null && allowedTypes.length > 0) {
			typeRestrictions = baserequirements.resource.baserequirements.util.BaserequirementsStringUtil.explode(allowedTypes, ", ", new baserequirements.resource.baserequirements.IBaserequirementsFunction1<String, org.eclipse.emf.ecore.EClass>() {
				public String execute(org.eclipse.emf.ecore.EClass eClass) {
					return eClass.getName();
				}
			});
		}
		return getFeature().getName() + (typeRestrictions == null ? "" : "[" + typeRestrictions + "]");
	}
	
}
