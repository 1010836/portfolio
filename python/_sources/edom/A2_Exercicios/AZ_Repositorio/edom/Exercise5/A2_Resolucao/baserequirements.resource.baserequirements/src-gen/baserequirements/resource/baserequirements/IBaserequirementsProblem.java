/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package baserequirements.resource.baserequirements;

public interface IBaserequirementsProblem {
	public String getMessage();
	public baserequirements.resource.baserequirements.BaserequirementsEProblemSeverity getSeverity();
	public baserequirements.resource.baserequirements.BaserequirementsEProblemType getType();
	public java.util.Collection<baserequirements.resource.baserequirements.IBaserequirementsQuickFix> getQuickFixes();
}
