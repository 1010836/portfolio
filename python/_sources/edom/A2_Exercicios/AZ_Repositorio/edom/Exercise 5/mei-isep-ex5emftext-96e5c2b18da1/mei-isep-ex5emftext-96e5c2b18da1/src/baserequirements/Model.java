/**
 */
package baserequirements;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link baserequirements.Model#getTitle <em>Title</em>}</li>
 *   <li>{@link baserequirements.Model#getGroups <em>Groups</em>}</li>
 * </ul>
 *
 * @see baserequirements.BaserequirementsPackage#getModel()
 * @model
 * @generated
 */
public interface Model extends EObject {
	/**
	 * Returns the value of the '<em><b>Title</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Title</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Title</em>' attribute list.
	 * @see baserequirements.BaserequirementsPackage#getModel_Title()
	 * @model
	 * @generated
	 */
	EList<String> getTitle();

	/**
	 * Returns the value of the '<em><b>Groups</b></em>' containment reference list.
	 * The list contents are of type {@link baserequirements.RequirementGroup}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Groups</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Groups</em>' containment reference list.
	 * @see baserequirements.BaserequirementsPackage#getModel_Groups()
	 * @model containment="true"
	 * @generated
	 */
	EList<RequirementGroup> getGroups();

} // Model
