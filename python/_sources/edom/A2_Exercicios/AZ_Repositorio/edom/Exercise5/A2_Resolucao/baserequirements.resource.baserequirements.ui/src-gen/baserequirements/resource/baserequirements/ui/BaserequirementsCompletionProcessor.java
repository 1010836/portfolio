/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package baserequirements.resource.baserequirements.ui;

public class BaserequirementsCompletionProcessor implements org.eclipse.jface.text.contentassist.IContentAssistProcessor {
	
	private baserequirements.resource.baserequirements.IBaserequirementsResourceProvider resourceProvider;
	private baserequirements.resource.baserequirements.ui.IBaserequirementsBracketHandlerProvider bracketHandlerProvider;
	
	public BaserequirementsCompletionProcessor(baserequirements.resource.baserequirements.IBaserequirementsResourceProvider resourceProvider, baserequirements.resource.baserequirements.ui.IBaserequirementsBracketHandlerProvider bracketHandlerProvider) {
		this.resourceProvider = resourceProvider;
		this.bracketHandlerProvider = bracketHandlerProvider;
	}
	
	public org.eclipse.jface.text.contentassist.ICompletionProposal[] computeCompletionProposals(org.eclipse.jface.text.ITextViewer viewer, int offset) {
		baserequirements.resource.baserequirements.IBaserequirementsTextResource textResource = resourceProvider.getResource();
		if (textResource == null) {
			return new org.eclipse.jface.text.contentassist.ICompletionProposal[0];
		}
		String content = viewer.getDocument().get();
		baserequirements.resource.baserequirements.ui.BaserequirementsCodeCompletionHelper helper = new baserequirements.resource.baserequirements.ui.BaserequirementsCodeCompletionHelper();
		baserequirements.resource.baserequirements.ui.BaserequirementsCompletionProposal[] computedProposals = helper.computeCompletionProposals(textResource, content, offset);
		
		// call completion proposal post processor to allow for customizing the proposals
		baserequirements.resource.baserequirements.ui.BaserequirementsProposalPostProcessor proposalPostProcessor = new baserequirements.resource.baserequirements.ui.BaserequirementsProposalPostProcessor();
		java.util.List<baserequirements.resource.baserequirements.ui.BaserequirementsCompletionProposal> computedProposalList = java.util.Arrays.asList(computedProposals);
		java.util.List<baserequirements.resource.baserequirements.ui.BaserequirementsCompletionProposal> extendedProposalList = proposalPostProcessor.process(computedProposalList);
		if (extendedProposalList == null) {
			extendedProposalList = java.util.Collections.emptyList();
		}
		java.util.List<baserequirements.resource.baserequirements.ui.BaserequirementsCompletionProposal> finalProposalList = new java.util.ArrayList<baserequirements.resource.baserequirements.ui.BaserequirementsCompletionProposal>();
		for (baserequirements.resource.baserequirements.ui.BaserequirementsCompletionProposal proposal : extendedProposalList) {
			if (proposal.getMatchesPrefix()) {
				finalProposalList.add(proposal);
			}
		}
		org.eclipse.jface.text.contentassist.ICompletionProposal[] result = new org.eclipse.jface.text.contentassist.ICompletionProposal[finalProposalList.size()];
		int i = 0;
		for (baserequirements.resource.baserequirements.ui.BaserequirementsCompletionProposal proposal : finalProposalList) {
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
			baserequirements.resource.baserequirements.ui.IBaserequirementsBracketHandler bracketHandler = bracketHandlerProvider.getBracketHandler();
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
