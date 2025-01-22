/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package baserequirements.resource.baseRequirements.mopp;

public class BaseRequirementsSyntaxCoverageInformationProvider {
	
	public org.eclipse.emf.ecore.EClass[] getClassesWithSyntax() {
		return new org.eclipse.emf.ecore.EClass[] {
			baserequirements.BaserequirementsPackage.eINSTANCE.getModel(),
			baserequirements.BaserequirementsPackage.eINSTANCE.getRequirementGroup(),
			baserequirements.BaserequirementsPackage.eINSTANCE.getRequirement(),
			baserequirements.BaserequirementsPackage.eINSTANCE.getVersion(),
			baserequirements.BaserequirementsPackage.eINSTANCE.getComment(),
		};
	}
	
	public org.eclipse.emf.ecore.EClass[] getStartSymbols() {
		return new org.eclipse.emf.ecore.EClass[] {
			baserequirements.BaserequirementsPackage.eINSTANCE.getModel(),
		};
	}
	
}
