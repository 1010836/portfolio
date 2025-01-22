/**
 */
package baserequirements;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Requirement Group</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link baserequirements.RequirementGroup#getName <em>Name</em>}</li>
 *   <li>{@link baserequirements.RequirementGroup#getDescription <em>Description</em>}</li>
 *   <li>{@link baserequirements.RequirementGroup#getId <em>Id</em>}</li>
 *   <li>{@link baserequirements.RequirementGroup#getChildren <em>Children</em>}</li>
 *   <li>{@link baserequirements.RequirementGroup#getParent <em>Parent</em>}</li>
 *   <li>{@link baserequirements.RequirementGroup#getRequirements <em>Requirements</em>}</li>
 * </ul>
 *
 * @see baserequirements.BaserequirementsPackage#getRequirementGroup()
 * @model
 * @generated
 */
public interface RequirementGroup extends EObject {
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
	 * @see baserequirements.BaserequirementsPackage#getRequirementGroup_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link baserequirements.RequirementGroup#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see baserequirements.BaserequirementsPackage#getRequirementGroup_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link baserequirements.RequirementGroup#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see baserequirements.BaserequirementsPackage#getRequirementGroup_Id()
	 * @model
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link baserequirements.RequirementGroup#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Children</b></em>' containment reference list.
	 * The list contents are of type {@link baserequirements.RequirementGroup}.
	 * It is bidirectional and its opposite is '{@link baserequirements.RequirementGroup#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Children</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Children</em>' containment reference list.
	 * @see baserequirements.BaserequirementsPackage#getRequirementGroup_Children()
	 * @see baserequirements.RequirementGroup#getParent
	 * @model opposite="parent" containment="true"
	 * @generated
	 */
	EList<RequirementGroup> getChildren();

	/**
	 * Returns the value of the '<em><b>Parent</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link baserequirements.RequirementGroup#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' container reference.
	 * @see #setParent(RequirementGroup)
	 * @see baserequirements.BaserequirementsPackage#getRequirementGroup_Parent()
	 * @see baserequirements.RequirementGroup#getChildren
	 * @model opposite="children" transient="false"
	 * @generated
	 */
	RequirementGroup getParent();

	/**
	 * Sets the value of the '{@link baserequirements.RequirementGroup#getParent <em>Parent</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' container reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(RequirementGroup value);

	/**
	 * Returns the value of the '<em><b>Requirements</b></em>' containment reference list.
	 * The list contents are of type {@link baserequirements.Requirement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Requirements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Requirements</em>' containment reference list.
	 * @see baserequirements.BaserequirementsPackage#getRequirementGroup_Requirements()
	 * @model containment="true"
	 * @generated
	 */
	EList<Requirement> getRequirements();

} // RequirementGroup
