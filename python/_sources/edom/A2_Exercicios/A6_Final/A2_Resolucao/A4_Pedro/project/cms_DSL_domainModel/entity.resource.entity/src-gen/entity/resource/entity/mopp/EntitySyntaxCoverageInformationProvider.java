/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package entity.resource.entity.mopp;

public class EntitySyntaxCoverageInformationProvider {
	
	public org.eclipse.emf.ecore.EClass[] getClassesWithSyntax() {
		return new org.eclipse.emf.ecore.EClass[] {
			entity.EntityPackage.eINSTANCE.getModel(),
			entity.EntityPackage.eINSTANCE.getEntity(),
			entity.EntityPackage.eINSTANCE.getAttribute(),
			entity.EntityPackage.eINSTANCE.getRelation(),
		};
	}
	
	public org.eclipse.emf.ecore.EClass[] getStartSymbols() {
		return new org.eclipse.emf.ecore.EClass[] {
			entity.EntityPackage.eINSTANCE.getModel(),
		};
	}
	
}
