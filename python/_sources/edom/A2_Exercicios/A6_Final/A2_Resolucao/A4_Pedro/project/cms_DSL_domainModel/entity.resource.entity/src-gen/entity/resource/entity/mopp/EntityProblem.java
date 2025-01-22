/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package entity.resource.entity.mopp;

public class EntityProblem implements entity.resource.entity.IEntityProblem {
	
	private String message;
	private entity.resource.entity.EntityEProblemType type;
	private entity.resource.entity.EntityEProblemSeverity severity;
	private java.util.Collection<entity.resource.entity.IEntityQuickFix> quickFixes;
	
	public EntityProblem(String message, entity.resource.entity.EntityEProblemType type, entity.resource.entity.EntityEProblemSeverity severity) {
		this(message, type, severity, java.util.Collections.<entity.resource.entity.IEntityQuickFix>emptySet());
	}
	
	public EntityProblem(String message, entity.resource.entity.EntityEProblemType type, entity.resource.entity.EntityEProblemSeverity severity, entity.resource.entity.IEntityQuickFix quickFix) {
		this(message, type, severity, java.util.Collections.singleton(quickFix));
	}
	
	public EntityProblem(String message, entity.resource.entity.EntityEProblemType type, entity.resource.entity.EntityEProblemSeverity severity, java.util.Collection<entity.resource.entity.IEntityQuickFix> quickFixes) {
		super();
		this.message = message;
		this.type = type;
		this.severity = severity;
		this.quickFixes = new java.util.LinkedHashSet<entity.resource.entity.IEntityQuickFix>();
		this.quickFixes.addAll(quickFixes);
	}
	
	public entity.resource.entity.EntityEProblemType getType() {
		return type;
	}
	
	public entity.resource.entity.EntityEProblemSeverity getSeverity() {
		return severity;
	}
	
	public String getMessage() {
		return message;
	}
	
	public java.util.Collection<entity.resource.entity.IEntityQuickFix> getQuickFixes() {
		return quickFixes;
	}
	
}
