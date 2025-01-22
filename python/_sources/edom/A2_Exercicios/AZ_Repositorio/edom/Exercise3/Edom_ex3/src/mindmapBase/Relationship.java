/**
 */
package mindmapBase;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Relationship</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link mindmapBase.Relationship#getType <em>Type</em>}</li>
 *   <li>{@link mindmapBase.Relationship#getSource <em>Source</em>}</li>
 *   <li>{@link mindmapBase.Relationship#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @see mindmapBase.MindmapBasePackage#getRelationship()
 * @model
 * @generated
 */
public interface Relationship extends MapElement {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link mindmapBase.Type}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see mindmapBase.Type
	 * @see #setType(Type)
	 * @see mindmapBase.MindmapBasePackage#getRelationship_Type()
	 * @model
	 * @generated
	 */
	Type getType();

	/**
	 * Sets the value of the '{@link mindmapBase.Relationship#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see mindmapBase.Type
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
	 * @see mindmapBase.MindmapBasePackage#getRelationship_Source()
	 * @model required="true"
	 * @generated
	 */
	Topic getSource();

	/**
	 * Sets the value of the '{@link mindmapBase.Relationship#getSource <em>Source</em>}' reference.
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
	 * @see mindmapBase.MindmapBasePackage#getRelationship_Target()
	 * @model required="true"
	 * @generated
	 */
	Topic getTarget();

	/**
	 * Sets the value of the '{@link mindmapBase.Relationship#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(Topic value);

} // Relationship
