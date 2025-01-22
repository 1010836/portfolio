/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package baserequirements.resource.baseRequirements.mopp;

public class BaseRequirementsAntlrScanner implements baserequirements.resource.baseRequirements.IBaseRequirementsTextScanner {
	
	private org.antlr.runtime3_4_0.Lexer antlrLexer;
	
	public BaseRequirementsAntlrScanner(org.antlr.runtime3_4_0.Lexer antlrLexer) {
		this.antlrLexer = antlrLexer;
	}
	
	public baserequirements.resource.baseRequirements.IBaseRequirementsTextToken getNextToken() {
		if (antlrLexer.getCharStream() == null) {
			return null;
		}
		final org.antlr.runtime3_4_0.Token current = antlrLexer.nextToken();
		if (current == null || current.getType() < 0) {
			return null;
		}
		baserequirements.resource.baseRequirements.IBaseRequirementsTextToken result = new baserequirements.resource.baseRequirements.mopp.BaseRequirementsANTLRTextToken(current);
		return result;
	}
	
	public void setText(String text) {
		antlrLexer.setCharStream(new org.antlr.runtime3_4_0.ANTLRStringStream(text));
	}
	
}
