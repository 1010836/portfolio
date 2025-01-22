/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package entity.resource.entity.mopp;

public class EntityBracketInformationProvider {
	
	public class BracketPair implements entity.resource.entity.IEntityBracketPair {
		
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
	
	public java.util.Collection<entity.resource.entity.IEntityBracketPair> getBracketPairs() {
		java.util.Collection<entity.resource.entity.IEntityBracketPair> result = new java.util.ArrayList<entity.resource.entity.IEntityBracketPair>();
		result.add(new BracketPair("{", "}", true));
		result.add(new BracketPair("\"", "\"", false));
		return result;
	}
	
}
