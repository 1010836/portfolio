/**
 */
package basemindmap;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Relationship</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link basemindmap.Relationship#getType <em>Type</em>}</li>
 *   <li>{@link basemindmap.Relationship#getSource <em>Source</em>}</li>
 *   <li>{@link basemindmap.Relationship#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @see basemindmap.BasemindmapPackage#getRelationship()
 * @model
 * @generated
 */
public interface Relationship extends MapElement {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link basemindmap.Type}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see basemindmap.Type
	 * @see #setType(Type)
	 * @see basemindmap.BasemindmapPackage#getRelationship_Type()
	 * @model
	 * @generated
	 */
	Type getType();

	/**
	 * Sets the value of the '{@link basemindmap.Relationship#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see basemindmap.Type
	 * @see #getType()
	 * @generated
	 */
	void setType(Type value);

	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(Topic)
	 * @see basemindmap.BasemindmapPackage#getRelationship_Source()
	 * @model required="true"
	 * @generated
	 */
	Topic getSource();

	/**
	 * Sets the value of the '{@link basemindmap.Relationship#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(Topic value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(Topic)
	 * @see basemindmap.BasemindmapPackage#getRelationship_Target()
	 * @model required="true"
	 * @generated
	 */
	Topic getTarget();

	/**
	 * Sets the value of the '{@link basemindmap.Relationship#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(Topic value);

} // Relationship
