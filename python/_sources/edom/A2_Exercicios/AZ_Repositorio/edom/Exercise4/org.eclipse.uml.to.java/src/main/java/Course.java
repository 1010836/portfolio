/*******************************************************************************
 * 2017, All rights reserved.
 *******************************************************************************/

// Start of user code (user defined imports)

// End of user code

/**
 * Description of Course.
 * 
 * @author p0
 */
public class Course {
	/**
	 * Description of the property id.
	 */
	public String id = "";

	/**
	 * Description of the property designation.
	 */
	public String designation = "";

	/**
	 * Description of the property planOfStudyId.
	 */
	public String planOfStudyId = "";

	// Start of user code (user defined attributes for Course)

	// End of user code

	/**
	 * The constructor.
	 */
	public Course() {
		// Start of user code constructor for Course)
		super();
		// End of user code
	}

	// Start of user code (user defined methods for Course)

	// End of user code
	/**
	 * Returns id.
	 * @return id 
	 */
	public String getId() {
		return this.id;
	}

	/**
	 * Sets a value to attribute id. 
	 * @param newId 
	 */
	public void setId(String newId) {
		this.id = newId;
	}

	/**
	 * Returns designation.
	 * @return designation 
	 */
	public String getDesignation() {
		return this.designation;
	}

	/**
	 * Sets a value to attribute designation. 
	 * @param newDesignation 
	 */
	public void setDesignation(String newDesignation) {
		this.designation = newDesignation;
	}

	/**
	 * Returns planOfStudyId.
	 * @return planOfStudyId 
	 */
	public String getPlanOfStudyId() {
		return this.planOfStudyId;
	}

	/**
	 * Sets a value to attribute planOfStudyId. 
	 * @param newPlanOfStudyId 
	 */
	public void setPlanOfStudyId(String newPlanOfStudyId) {
		this.planOfStudyId = newPlanOfStudyId;
	}

}
