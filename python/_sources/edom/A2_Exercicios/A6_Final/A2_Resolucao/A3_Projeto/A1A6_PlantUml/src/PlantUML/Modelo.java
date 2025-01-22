/**
 */
package PlantUML;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Modelo</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link PlantUML.Modelo#getName <em>Name</em>}</li>
 *   <li>{@link PlantUML.Modelo#getElement <em>Element</em>}</li>
 * </ul>
 *
 * @see PlantUML.PlantUMLPackage#getModelo()
 * @model
 * @generated
 */
public interface Modelo extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute list.
	 * @see PlantUML.PlantUMLPackage#getModelo_Name()
	 * @model default="Model n\u00ba 1" unique="false" id="true" ordered="false"
	 * @generated
	 */
	EList<String> getName();

	/**
	 * Returns the value of the '<em><b>Element</b></em>' containment reference list.
	 * The list contents are of type {@link PlantUML.UseCase}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element</em>' containment reference list.
	 * @see PlantUML.PlantUMLPackage#getModelo_Element()
	 * @model containment="true"
	 * @generated
	 */
	EList<UseCase> getElement();

} // Modelo
