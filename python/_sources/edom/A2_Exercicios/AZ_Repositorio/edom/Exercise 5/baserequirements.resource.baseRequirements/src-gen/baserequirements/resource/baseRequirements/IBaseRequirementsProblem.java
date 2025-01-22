/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package baserequirements.resource.baseRequirements;

public interface IBaseRequirementsProblem {
	public String getMessage();
	public baserequirements.resource.baseRequirements.BaseRequirementsEProblemSeverity getSeverity();
	public baserequirements.resource.baseRequirements.BaseRequirementsEProblemType getType();
	public java.util.Collection<baserequirements.resource.baseRequirements.IBaseRequirementsQuickFix> getQuickFixes();
}
