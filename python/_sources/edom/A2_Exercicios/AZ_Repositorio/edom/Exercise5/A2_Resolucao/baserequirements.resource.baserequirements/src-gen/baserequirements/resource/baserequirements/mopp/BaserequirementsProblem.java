/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package baserequirements.resource.baserequirements.mopp;

public class BaserequirementsProblem implements baserequirements.resource.baserequirements.IBaserequirementsProblem {
	
	private String message;
	private baserequirements.resource.baserequirements.BaserequirementsEProblemType type;
	private baserequirements.resource.baserequirements.BaserequirementsEProblemSeverity severity;
	private java.util.Collection<baserequirements.resource.baserequirements.IBaserequirementsQuickFix> quickFixes;
	
	public BaserequirementsProblem(String message, baserequirements.resource.baserequirements.BaserequirementsEProblemType type, baserequirements.resource.baserequirements.BaserequirementsEProblemSeverity severity) {
		this(message, type, severity, java.util.Collections.<baserequirements.resource.baserequirements.IBaserequirementsQuickFix>emptySet());
	}
	
	public BaserequirementsProblem(String message, baserequirements.resource.baserequirements.BaserequirementsEProblemType type, baserequirements.resource.baserequirements.BaserequirementsEProblemSeverity severity, baserequirements.resource.baserequirements.IBaserequirementsQuickFix quickFix) {
		this(message, type, severity, java.util.Collections.singleton(quickFix));
	}
	
	public BaserequirementsProblem(String message, baserequirements.resource.baserequirements.BaserequirementsEProblemType type, baserequirements.resource.baserequirements.BaserequirementsEProblemSeverity severity, java.util.Collection<baserequirements.resource.baserequirements.IBaserequirementsQuickFix> quickFixes) {
		super();
		this.message = message;
		this.type = type;
		this.severity = severity;
		this.quickFixes = new java.util.LinkedHashSet<baserequirements.resource.baserequirements.IBaserequirementsQuickFix>();
		this.quickFixes.addAll(quickFixes);
	}
	
	public baserequirements.resource.baserequirements.BaserequirementsEProblemType getType() {
		return type;
	}
	
	public baserequirements.resource.baserequirements.BaserequirementsEProblemSeverity getSeverity() {
		return severity;
	}
	
	public String getMessage() {
		return message;
	}
	
	public java.util.Collection<baserequirements.resource.baserequirements.IBaserequirementsQuickFix> getQuickFixes() {
		return quickFixes;
	}
	
}
