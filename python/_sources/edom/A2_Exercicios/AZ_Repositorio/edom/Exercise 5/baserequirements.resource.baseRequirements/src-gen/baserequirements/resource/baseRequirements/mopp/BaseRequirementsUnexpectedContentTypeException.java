/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package baserequirements.resource.baseRequirements.mopp;

/**
 * An Excpetion to represent invalid content types for parser instances.
 * 
 * @see
 * baserequirements.resource.baseRequirements.IBaseRequirementsOptions.RESOURCE_CON
 * TENT_TYPE
 */
public class BaseRequirementsUnexpectedContentTypeException extends org.antlr.runtime3_4_0.RecognitionException {
	
	private static final long serialVersionUID = 4791359811519433999L;
	
	private Object contentType = null;
	
	public  BaseRequirementsUnexpectedContentTypeException(Object contentType) {
		this.contentType = contentType;
	}
	
	public Object getContentType() {
		return contentType;
	}
	
}
