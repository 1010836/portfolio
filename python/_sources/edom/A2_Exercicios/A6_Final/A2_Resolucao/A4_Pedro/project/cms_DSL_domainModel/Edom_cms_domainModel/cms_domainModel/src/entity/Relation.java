/**
 */
package entity;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Relation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link entity.Relation#getName <em>Name</em>}</li>
 *   <li>{@link entity.Relation#getType <em>Type</em>}</li>
 *   <li>{@link entity.Relation#getRelEntity <em>Rel Entity</em>}</li>
 * </ul>
 *
 * @see entity.EntityPackage#getRelation()
 * @model
 * @generated
 */
public interface Relation extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see entity.EntityPackage#getRelation_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link entity.Relation#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link entity.RelationType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see entity.RelationType
	 * @see #setType(RelationType)
	 * @see entity.EntityPackage#getRelation_Type()
	 * @model required="true"
	 * @generated
	 */
	RelationType getType();

	/**
	 * Sets the value of the '{@link entity.Relation#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see entity.RelationType
	 * @see #getType()
	 * @generated
	 */
	void setType(RelationType value);

	/**
	 * Returns the value of the '<em><b>Rel Entity</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rel Entity</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rel Entity</em>' reference.
	 * @see #setRelEntity(Entity)
	 * @see entity.EntityPackage#getRelation_RelEntity()
	 * @model required="true"
	 * @generated
	 */
	Entity getRelEntity();

	/**
	 * Sets the value of the '{@link entity.Relation#getRelEntity <em>Rel Entity</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rel Entity</em>' reference.
	 * @see #getRelEntity()
	 * @generated
	 */
	void setRelEntity(Entity value);

} // Relation
