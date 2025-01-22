/*******************************************************************************
 * 2017, All rights reserved.
 *******************************************************************************/

// Start of user code (user defined imports)

// End of user code

/**
 * Description of Room.
 * 
 * @author p0
 */
public class Room {
	/**
	 * Description of the property id.
	 */
	public String id = "";

	/**
	 * Description of the property number.
	 */
	public String number = "";

	/**
	 * Description of the property building.
	 */
	public String building = "";

	/**
	 * Description of the property floor.
	 */
	public String floor = "";

	// Start of user code (user defined attributes for Room)

	// End of user code

	/**
	 * The constructor.
	 */
	public Room() {
		// Start of user code constructor for Room)
		super();
		// End of user code
	}

	// Start of user code (user defined methods for Room)

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
	 * Returns number.
	 * @return number 
	 */
	public String getNumber() {
		return this.number;
	}

	/**
	 * Sets a value to attribute number. 
	 * @param newNumber 
	 */
	public void setNumber(String newNumber) {
		this.number = newNumber;
	}

	/**
	 * Returns building.
	 * @return building 
	 */
	public String getBuilding() {
		return this.building;
	}

	/**
	 * Sets a value to attribute building. 
	 * @param newBuilding 
	 */
	public void setBuilding(String newBuilding) {
		this.building = newBuilding;
	}

	/**
	 * Returns floor.
	 * @return floor 
	 */
	public String getFloor() {
		return this.floor;
	}

	/**
	 * Sets a value to attribute floor. 
	 * @param newFloor 
	 */
	public void setFloor(String newFloor) {
		this.floor = newFloor;
	}

}
