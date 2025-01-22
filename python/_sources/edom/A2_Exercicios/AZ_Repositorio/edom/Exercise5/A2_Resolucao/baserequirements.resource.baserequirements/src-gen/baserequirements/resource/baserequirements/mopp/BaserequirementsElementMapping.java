/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package baserequirements.resource.baserequirements.mopp;

/**
 * A basic implementation of the
 * baserequirements.resource.baserequirements.IBaserequirementsElementMapping
 * interface.
 * 
 * @param <ReferenceType> the type of the reference that can be mapped to
 */
public class BaserequirementsElementMapping<ReferenceType> implements baserequirements.resource.baserequirements.IBaserequirementsElementMapping<ReferenceType> {
	
	private final ReferenceType target;
	private String identifier;
	private String warning;
	
	public BaserequirementsElementMapping(String identifier, ReferenceType target, String warning) {
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
