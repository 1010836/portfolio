/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package baserequirements.resource.baseRequirements.ui;

public class BaseRequirementsCompletionProcessor implements org.eclipse.jface.text.contentassist.IContentAssistProcessor {
	
	private baserequirements.resource.baseRequirements.IBaseRequirementsResourceProvider resourceProvider;
	private baserequirements.resource.baseRequirements.ui.IBaseRequirementsBracketHandlerProvider bracketHandlerProvider;
	
	public BaseRequirementsCompletionProcessor(baserequirements.resource.baseRequirements.IBaseRequirementsResourceProvider resourceProvider, baserequirements.resource.baseRequirements.ui.IBaseRequirementsBracketHandlerProvider bracketHandlerProvider) {
		this.resourceProvider = resourceProvider;
		this.bracketHandlerProvider = bracketHandlerProvider;
	}
	
	public org.eclipse.jface.text.contentassist.ICompletionProposal[] computeCompletionProposals(org.eclipse.jface.text.ITextViewer viewer, int offset) {
		baserequirements.resource.baseRequirements.IBaseRequirementsTextResource textResource = resourceProvider.getResource();
		if (textResource == null) {
			return new org.eclipse.jface.text.contentassist.ICompletionProposal[0];
		}
		String content = viewer.getDocument().get();
		baserequirements.resource.baseRequirements.ui.BaseRequirementsCodeCompletionHelper helper = new baserequirements.resource.baseRequirements.ui.BaseRequirementsCodeCompletionHelper();
		baserequirements.resource.baseRequirements.ui.BaseRequirementsCompletionProposal[] computedProposals = helper.computeCompletionProposals(textResource, content, offset);
		
		// call completion proposal post processor to allow for customizing the proposals
		baserequirements.resource.baseRequirements.ui.BaseRequirementsProposalPostProcessor proposalPostProcessor = new baserequirements.resource.baseRequirements.ui.BaseRequirementsProposalPostProcessor();
		java.util.List<baserequirements.resource.baseRequirements.ui.BaseRequirementsCompletionProposal> computedProposalList = java.util.Arrays.asList(computedProposals);
		java.util.List<baserequirements.resource.baseRequirements.ui.BaseRequirementsCompletionProposal> extendedProposalList = proposalPostProcessor.process(computedProposalList);
		if (extendedProposalList == null) {
			extendedProposalList = java.util.Collections.emptyList();
		}
		java.util.List<baserequirements.resource.baseRequirements.ui.BaseRequirementsCompletionProposal> finalProposalList = new java.util.ArrayList<baserequirements.resource.baseRequirements.ui.BaseRequirementsCompletionProposal>();
		for (baserequirements.resource.baseRequirements.ui.BaseRequirementsCompletionProposal proposal : extendedProposalList) {
			if (proposal.getMatchesPrefix()) {
				finalProposalList.add(proposal);
			}
		}
		org.eclipse.jface.text.contentassist.ICompletionProposal[] result = new org.eclipse.jface.text.contentassist.ICompletionProposal[finalProposalList.size()];
		int i = 0;
		for (baserequirements.resource.baseRequirements.ui.BaseRequirementsCompletionProposal proposal : finalProposalList) {
			String proposalString = proposal.getInsertString();
			String displayString = proposal.getDisplayString();
			String prefix = proposal.getPrefix();
			org.eclipse.swt.graphics.Image image = proposal.getImage();
			org.eclipse.jface.text.contentassist.IContextInformation info;
			info = new org.eclipse.jface.text.contentassist.ContextInformation(image, proposalString, proposalString);
			int begin = offset - prefix.length();
			int replacementLength = prefix.length();
			// if a closing bracket was automatically inserted right before, we enlarge the
			// replacement length in order to overwrite the bracket.
			baserequirements.resource.baseRequirements.ui.IBaseRequirementsBracketHandler bracketHandler = bracketHandlerProvider.getBracketHandler();
			String closingBracket = bracketHandler.getClosingBracket();
			if (bracketHandler.addedClosingBracket() && proposalString.endsWith(closingBracket)) {
				replacementLength += closingBracket.length();
			}
			result[i++] = new org.eclipse.jface.text.contentassist.CompletionProposal(proposalString, begin, replacementLength, proposalString.length(), image, displayString, info, proposalString);
		}
		return result;
	}
	
	public org.eclipse.jface.text.contentassist.IContextInformation[] computeContextInformation(org.eclipse.jface.text.ITextViewer viewer, int offset) {
		return null;
	}
	
	public char[] getCompletionProposalAutoActivationCharacters() {
		return null;
	}
	
	public char[] getContextInformationAutoActivationCharacters() {
		return null;
	}
	
	public org.eclipse.jface.text.contentassist.IContextInformationValidator getContextInformationValidator() {
		return null;
	}
	
	public String getErrorMessage() {
		return null;
	}
}
