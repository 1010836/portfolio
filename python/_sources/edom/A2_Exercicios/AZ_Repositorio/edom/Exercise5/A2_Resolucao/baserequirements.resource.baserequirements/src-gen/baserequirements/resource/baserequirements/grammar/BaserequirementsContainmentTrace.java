/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package baserequirements.resource.baserequirements.grammar;

/**
 * A BaserequirementsContainmentTrace represents a specific path to a structural
 * feature by navigating over a set of a structural feature from a start class.
 * BaserequirementsContainmentTraces are used during code completion to
 * reconstruct containment trees that are not created by the parser, for example,
 * if the first character of the contained object has not been typed yet.
 */
public class BaserequirementsContainmentTrace {
	
	/**
	 * The class where the trace starts.
	 */
	private org.eclipse.emf.ecore.EClass startClass;
	
	/**
	 * The path of contained features.
	 */
	private baserequirements.resource.baserequirements.mopp.BaserequirementsContainedFeature[] path;
	
	public BaserequirementsContainmentTrace(org.eclipse.emf.ecore.EClass startClass, baserequirements.resource.baserequirements.mopp.BaserequirementsContainedFeature[] path) {
		super();
		// Verify arguments
		if (startClass != null) {
			if (path.length > 0) {
				org.eclipse.emf.ecore.EStructuralFeature feature = path[path.length - 1].getFeature();
				if (!startClass.getEAllStructuralFeatures().contains(feature)) {
					throw new RuntimeException("Metaclass " + startClass.getName() + " must contain feature " + feature.getName());
				}
			}
		}
		this.startClass = startClass;
		this.path = path;
	}
	
	public org.eclipse.emf.ecore.EClass getStartClass() {
		return startClass;
	}
	
	public baserequirements.resource.baserequirements.mopp.BaserequirementsContainedFeature[] getPath() {
		return path;
	}
	
	public String toString() {
		return (startClass == null ? "null" : startClass.getName()) + "->" + baserequirements.resource.baserequirements.util.BaserequirementsStringUtil.explode(path, "->");
	}
	
}
