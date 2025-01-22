/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package baserequirements.resource.baserequirements.mopp;

public class BaserequirementsAntlrScanner implements baserequirements.resource.baserequirements.IBaserequirementsTextScanner {
	
	private org.antlr.runtime3_4_0.Lexer antlrLexer;
	
	public BaserequirementsAntlrScanner(org.antlr.runtime3_4_0.Lexer antlrLexer) {
		this.antlrLexer = antlrLexer;
	}
	
	public baserequirements.resource.baserequirements.IBaserequirementsTextToken getNextToken() {
		if (antlrLexer.getCharStream() == null) {
			return null;
		}
		final org.antlr.runtime3_4_0.Token current = antlrLexer.nextToken();
		if (current == null || current.getType() < 0) {
			return null;
		}
		baserequirements.resource.baserequirements.IBaserequirementsTextToken result = new baserequirements.resource.baserequirements.mopp.BaserequirementsANTLRTextToken(current);
		return result;
	}
	
	public void setText(String text) {
		antlrLexer.setCharStream(new org.antlr.runtime3_4_0.ANTLRStringStream(text));
	}
	
}
