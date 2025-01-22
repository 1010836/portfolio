/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package baserequirements.resource.baseRequirements.mopp;

/**
 * A basic implementation of the
 * baserequirements.resource.baseRequirements.IBaseRequirementsElementMapping
 * interface.
 * 
 * @param <ReferenceType> the type of the reference that can be mapped to
 */
public class BaseRequirementsElementMapping<ReferenceType> implements baserequirements.resource.baseRequirements.IBaseRequirementsElementMapping<ReferenceType> {
	
	private final ReferenceType target;
	private String identifier;
	private String warning;
	
	public BaseRequirementsElementMapping(String identifier, ReferenceType target, String warning) {
		super();
		this.target = target;
		this.identifier = identifier;
		this.warning = warning;
	}
	
	public ReferenceType getTargetElement() {
		return target;
	}
	
	public String getIdentifier() {
		return identifier;
	}
	
	public String getWarning() {
		return warning;
	}
	
}
