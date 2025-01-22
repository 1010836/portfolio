/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package baserequirements.resource.baseRequirements.ui;

/**
 * A class which can be overridden to customize code completion proposals.
 */
public class BaseRequirementsProposalPostProcessor {
	
	public java.util.List<baserequirements.resource.baseRequirements.ui.BaseRequirementsCompletionProposal> process(java.util.List<baserequirements.resource.baseRequirements.ui.BaseRequirementsCompletionProposal> proposals) {
		// the default implementation does returns the proposals as they are
		return proposals;
	}
	
}
