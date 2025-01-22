/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package baserequirements.resource.baserequirements.mopp;

public class BaserequirementsBracketInformationProvider {
	
	public class BracketPair implements baserequirements.resource.baserequirements.IBaserequirementsBracketPair {
		
		private String opening;
		private String closing;
		private boolean closingEnabledInside;
		
		public BracketPair(String opening, String closing, boolean closingEnabledInside) {
			super();
			this.opening = opening;
			this.closing = closing;
			this.closingEnabledInside = closingEnabledInside;
		}
		
		public String getOpeningBracket() {
			return opening;
		}
		
		public String getClosingBracket() {
			return closing;
		}
		
		public boolean isClosingEnabledInside() {
			return closingEnabledInside;
		}
	}
	
	public java.util.Collection<baserequirements.resource.baserequirements.IBaserequirementsBracketPair> getBracketPairs() {
		java.util.Collection<baserequirements.resource.baserequirements.IBaserequirementsBracketPair> result = new java.util.ArrayList<baserequirements.resource.baserequirements.IBaserequirementsBracketPair>();
		result.add(new BracketPair("{", "}", true));
		result.add(new BracketPair("\"", "\"", false));
		return result;
	}
	
}
