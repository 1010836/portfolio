/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package entity.resource.entity.mopp;

public class EntityAntlrScanner implements entity.resource.entity.IEntityTextScanner {
	
	private org.antlr.runtime3_4_0.Lexer antlrLexer;
	
	public EntityAntlrScanner(org.antlr.runtime3_4_0.Lexer antlrLexer) {
		this.antlrLexer = antlrLexer;
	}
	
	public entity.resource.entity.IEntityTextToken getNextToken() {
		if (antlrLexer.getCharStream() == null) {
			return null;
		}
		final org.antlr.runtime3_4_0.Token current = antlrLexer.nextToken();
		if (current == null || current.getType() < 0) {
			return null;
		}
		entity.resource.entity.IEntityTextToken result = new entity.resource.entity.mopp.EntityANTLRTextToken(current);
		return result;
	}
	
	public void setText(String text) {
		antlrLexer.setCharStream(new org.antlr.runtime3_4_0.ANTLRStringStream(text));
	}
	
}
