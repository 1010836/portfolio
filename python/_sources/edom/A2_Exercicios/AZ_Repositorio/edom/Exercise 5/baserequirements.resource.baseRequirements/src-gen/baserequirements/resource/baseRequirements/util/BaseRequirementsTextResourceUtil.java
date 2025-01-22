/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package baserequirements.resource.baseRequirements.util;

/**
 * Class BaseRequirementsTextResourceUtil can be used to perform common tasks on
 * text resources, such as loading and saving resources, as well as, checking them
 * for errors. This class is deprecated and has been replaced by
 * baserequirements.resource.baseRequirements.util.BaseRequirementsResourceUtil.
 */
public class BaseRequirementsTextResourceUtil {
	
	/**
	 * Use
	 * baserequirements.resource.baseRequirements.util.BaseRequirementsResourceUtil.get
	 * Resource() instead.
	 */
	@Deprecated	
	public static baserequirements.resource.baseRequirements.mopp.BaseRequirementsResource getResource(org.eclipse.core.resources.IFile file) {
		return new baserequirements.resource.baseRequirements.util.BaseRequirementsEclipseProxy().getResource(file);
	}
	
	/**
	 * Use
	 * baserequirements.resource.baseRequirements.util.BaseRequirementsResourceUtil.get
	 * Resource() instead.
	 */
	@Deprecated	
	public static baserequirements.resource.baseRequirements.mopp.BaseRequirementsResource getResource(java.io.File file, java.util.Map<?,?> options) {
		return baserequirements.resource.baseRequirements.util.BaseRequirementsResourceUtil.getResource(file, options);
	}
	
	/**
	 * Use
	 * baserequirements.resource.baseRequirements.util.BaseRequirementsResourceUtil.get
	 * Resource() instead.
	 */
	@Deprecated	
	public static baserequirements.resource.baseRequirements.mopp.BaseRequirementsResource getResource(org.eclipse.emf.common.util.URI uri) {
		return baserequirements.resource.baseRequirements.util.BaseRequirementsResourceUtil.getResource(uri);
	}
	
	/**
	 * Use
	 * baserequirements.resource.baseRequirements.util.BaseRequirementsResourceUtil.get
	 * Resource() instead.
	 */
	@Deprecated	
	public static baserequirements.resource.baseRequirements.mopp.BaseRequirementsResource getResource(org.eclipse.emf.common.util.URI uri, java.util.Map<?,?> options) {
		return baserequirements.resource.baseRequirements.util.BaseRequirementsResourceUtil.getResource(uri, options);
	}
	
}
