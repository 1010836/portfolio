/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package baserequirements.resource.baseRequirements.mopp;

public class BaseRequirementsBracketInformationProvider {
	
	public class BracketPair implements baserequirements.resource.baseRequirements.IBaseRequirementsBracketPair {
		
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
	
	public java.util.Collection<baserequirements.resource.baseRequirements.IBaseRequirementsBracketPair> getBracketPairs() {
		java.util.Collection<baserequirements.resource.baseRequirements.IBaseRequirementsBracketPair> result = new java.util.ArrayList<baserequirements.resource.baseRequirements.IBaseRequirementsBracketPair>();
		result.add(new BracketPair("{", "}", true));
		result.add(new BracketPair("\"", "\"", false));
		return result;
	}
	
}
