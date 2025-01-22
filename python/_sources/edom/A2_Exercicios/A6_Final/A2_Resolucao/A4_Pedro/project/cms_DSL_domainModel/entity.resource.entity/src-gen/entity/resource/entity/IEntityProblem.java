/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package entity.resource.entity;

public interface IEntityProblem {
	public String getMessage();
	public entity.resource.entity.EntityEProblemSeverity getSeverity();
	public entity.resource.entity.EntityEProblemType getType();
	public java.util.Collection<entity.resource.entity.IEntityQuickFix> getQuickFixes();
}
