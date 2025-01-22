/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package entity.resource.entity.mopp;

/**
 * This class provides sets of values for attributes. It is used by the code
 * completion processor.
 */
public class EntityAttributeValueProvider {
	
	public Object[] getDefaultValues(org.eclipse.emf.ecore.EAttribute attribute) {
		String typeName = attribute.getEType().getName();
		if ("EString".equals(typeName)) {
			return new Object[] {"some" + entity.resource.entity.util.EntityStringUtil.capitalize(attribute.getName())};
		}
		if ("EBoolean".equals(typeName)) {
			return new Object[] {Boolean.TRUE, Boolean.FALSE};
		}
		return new Object[] {attribute.getDefaultValue()};
	}
	
}
