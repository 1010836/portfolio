/**
 */
package PlantUML;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Use Case</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link PlantUML.UseCase#getName <em>Name</em>}</li>
 *   <li>{@link PlantUML.UseCase#getLongName <em>Long Name</em>}</li>
 * </ul>
 *
 * @see PlantUML.PlantUMLPackage#getUseCase()
 * @model
 * @generated
 */
public interface UseCase extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * The default value is <code>"Default name"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see PlantUML.PlantUMLPackage#getUseCase_Name()
	 * @model default="Default name" unique="false" ordered="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link PlantUML.UseCase#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Long Name</b></em>' attribute.
	 * The default value is <code>"Default long name"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Long Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Long Name</em>' attribute.
	 * @see #setLongName(String)
	 * @see PlantUML.PlantUMLPackage#getUseCase_LongName()
	 * @model default="Default long name" unique="false" ordered="false"
	 * @generated
	 */
	String getLongName();

	/**
	 * Sets the value of the '{@link PlantUML.UseCase#getLongName <em>Long Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Long Name</em>' attribute.
	 * @see #getLongName()
	 * @generated
	 */
	void setLongName(String value);

} // UseCase
