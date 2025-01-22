/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package entity.resource.entity.util;

/**
 * Class EntityTextResourceUtil can be used to perform common tasks on text
 * resources, such as loading and saving resources, as well as, checking them for
 * errors. This class is deprecated and has been replaced by
 * entity.resource.entity.util.EntityResourceUtil.
 */
public class EntityTextResourceUtil {
	
	/**
	 * Use entity.resource.entity.util.EntityResourceUtil.getResource() instead.
	 */
	@Deprecated	
	public static entity.resource.entity.mopp.EntityResource getResource(org.eclipse.core.resources.IFile file) {
		return new entity.resource.entity.util.EntityEclipseProxy().getResource(file);
	}
	
	/**
	 * Use entity.resource.entity.util.EntityResourceUtil.getResource() instead.
	 */
	@Deprecated	
	public static entity.resource.entity.mopp.EntityResource getResource(java.io.File file, java.util.Map<?,?> options) {
		return entity.resource.entity.util.EntityResourceUtil.getResource(file, options);
	}
	
	/**
	 * Use entity.resource.entity.util.EntityResourceUtil.getResource() instead.
	 */
	@Deprecated	
	public static entity.resource.entity.mopp.EntityResource getResource(org.eclipse.emf.common.util.URI uri) {
		return entity.resource.entity.util.EntityResourceUtil.getResource(uri);
	}
	
	/**
	 * Use entity.resource.entity.util.EntityResourceUtil.getResource() instead.
	 */
	@Deprecated	
	public static entity.resource.entity.mopp.EntityResource getResource(org.eclipse.emf.common.util.URI uri, java.util.Map<?,?> options) {
		return entity.resource.entity.util.EntityResourceUtil.getResource(uri, options);
	}
	
}
