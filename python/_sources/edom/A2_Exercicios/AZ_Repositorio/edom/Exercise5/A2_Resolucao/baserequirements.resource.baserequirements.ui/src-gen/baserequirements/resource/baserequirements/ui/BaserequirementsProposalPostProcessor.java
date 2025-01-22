/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package baserequirements.resource.baserequirements.ui;

/**
 * A class which can be overridden to customize code completion proposals.
 */
public class BaserequirementsProposalPostProcessor {
	
	public java.util.List<baserequirements.resource.baserequirements.ui.BaserequirementsCompletionProposal> process(java.util.List<baserequirements.resource.baserequirements.ui.BaserequirementsCompletionProposal> proposals) {
		// the default implementation does returns the proposals as they are
		return proposals;
	}
	
}
