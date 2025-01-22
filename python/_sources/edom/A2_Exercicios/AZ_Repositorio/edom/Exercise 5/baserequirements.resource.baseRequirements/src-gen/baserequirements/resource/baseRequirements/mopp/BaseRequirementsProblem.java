/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package baserequirements.resource.baseRequirements.mopp;

public class BaseRequirementsProblem implements baserequirements.resource.baseRequirements.IBaseRequirementsProblem {
	
	private String message;
	private baserequirements.resource.baseRequirements.BaseRequirementsEProblemType type;
	private baserequirements.resource.baseRequirements.BaseRequirementsEProblemSeverity severity;
	private java.util.Collection<baserequirements.resource.baseRequirements.IBaseRequirementsQuickFix> quickFixes;
	
	public BaseRequirementsProblem(String message, baserequirements.resource.baseRequirements.BaseRequirementsEProblemType type, baserequirements.resource.baseRequirements.BaseRequirementsEProblemSeverity severity) {
		this(message, type, severity, java.util.Collections.<baserequirements.resource.baseRequirements.IBaseRequirementsQuickFix>emptySet());
	}
	
	public BaseRequirementsProblem(String message, baserequirements.resource.baseRequirements.BaseRequirementsEProblemType type, baserequirements.resource.baseRequirements.BaseRequirementsEProblemSeverity severity, baserequirements.resource.baseRequirements.IBaseRequirementsQuickFix quickFix) {
		this(message, type, severity, java.util.Collections.singleton(quickFix));
	}
	
	public BaseRequirementsProblem(String message, baserequirements.resource.baseRequirements.BaseRequirementsEProblemType type, baserequirements.resource.baseRequirements.BaseRequirementsEProblemSeverity severity, java.util.Collection<baserequirements.resource.baseRequirements.IBaseRequirementsQuickFix> quickFixes) {
		super();
		this.message = message;
		this.type = type;
		this.severity = severity;
		this.quickFixes = new java.util.LinkedHashSet<baserequirements.resource.baseRequirements.IBaseRequirementsQuickFix>();
		this.quickFixes.addAll(quickFixes);
	}
	
	public baserequirements.resource.baseRequirements.BaseRequirementsEProblemType getType() {
		return type;
	}
	
	public baserequirements.resource.baseRequirements.BaseRequirementsEProblemSeverity getSeverity() {
		return severity;
	}
	
	public String getMessage() {
		return message;
	}
	
	public java.util.Collection<baserequirements.resource.baseRequirements.IBaseRequirementsQuickFix> getQuickFixes() {
		return quickFixes;
	}
	
}
