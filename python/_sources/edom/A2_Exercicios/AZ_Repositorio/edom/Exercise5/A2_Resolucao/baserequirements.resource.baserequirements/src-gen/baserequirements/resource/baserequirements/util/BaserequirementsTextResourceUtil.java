/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package baserequirements.resource.baserequirements.util;

/**
 * Class BaserequirementsTextResourceUtil can be used to perform common tasks on
 * text resources, such as loading and saving resources, as well as, checking them
 * for errors. This class is deprecated and has been replaced by
 * baserequirements.resource.baserequirements.util.BaserequirementsResourceUtil.
 */
public class BaserequirementsTextResourceUtil {
	
	/**
	 * Use
	 * baserequirements.resource.baserequirements.util.BaserequirementsResourceUtil.get
	 * Resource() instead.
	 */
	@Deprecated	
	public static baserequirements.resource.baserequirements.mopp.BaserequirementsResource getResource(org.eclipse.core.resources.IFile file) {
		return new baserequirements.resource.baserequirements.util.BaserequirementsEclipseProxy().getResource(file);
	}
	
	/**
	 * Use
	 * baserequirements.resource.baserequirements.util.BaserequirementsResourceUtil.get
	 * Resource() instead.
	 */
	@Deprecated	
	public static baserequirements.resource.baserequirements.mopp.BaserequirementsResource getResource(java.io.File file, java.util.Map<?,?> options) {
		return baserequirements.resource.baserequirements.util.BaserequirementsResourceUtil.getResource(file, options);
	}
	
	/**
	 * Use
	 * baserequirements.resource.baserequirements.util.BaserequirementsResourceUtil.get
	 * Resource() instead.
	 */
	@Deprecated	
	public static baserequirements.resource.baserequirements.mopp.BaserequirementsResource getResource(org.eclipse.emf.common.util.URI uri) {
		return baserequirements.resource.baserequirements.util.BaserequirementsResourceUtil.getResource(uri);
	}
	
	/**
	 * Use
	 * baserequirements.resource.baserequirements.util.BaserequirementsResourceUtil.get
	 * Resource() instead.
	 */
	@Deprecated	
	public static baserequirements.resource.baserequirements.mopp.BaserequirementsResource getResource(org.eclipse.emf.common.util.URI uri, java.util.Map<?,?> options) {
		return baserequirements.resource.baserequirements.util.BaserequirementsResourceUtil.getResource(uri, options);
	}
	
}
