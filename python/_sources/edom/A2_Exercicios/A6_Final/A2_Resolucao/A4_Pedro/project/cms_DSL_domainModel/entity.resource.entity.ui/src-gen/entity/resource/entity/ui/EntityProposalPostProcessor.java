/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package entity.resource.entity.ui;

/**
 * A class which can be overridden to customize code completion proposals.
 */
public class EntityProposalPostProcessor {
	
	public java.util.List<entity.resource.entity.ui.EntityCompletionProposal> process(java.util.List<entity.resource.entity.ui.EntityCompletionProposal> proposals) {
		// the default implementation does returns the proposals as they are
		return proposals;
	}
	
}
