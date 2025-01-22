/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package entity.resource.entity.mopp;

/**
 * An Excpetion to represent invalid content types for parser instances.
 * 
 * @see entity.resource.entity.IEntityOptions.RESOURCE_CONTENT_TYPE
 */
public class EntityUnexpectedContentTypeException extends org.antlr.runtime3_4_0.RecognitionException {
	
	private static final long serialVersionUID = 4791359811519433999L;
	
	private Object contentType = null;
	
	public  EntityUnexpectedContentTypeException(Object contentType) {
		this.contentType = contentType;
	}
	
	public Object getContentType() {
		return contentType;
	}
	
}
