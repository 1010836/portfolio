/**
 */
package PlantUML;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see PlantUML.PlantUMLPackage
 * @generated
 */
public interface PlantUMLFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PlantUMLFactory eINSTANCE = PlantUML.impl.PlantUMLFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Modelo</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Modelo</em>'.
	 * @generated
	 */
	Modelo createModelo();

	/**
	 * Returns a new object of class '<em>Use Case</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Use Case</em>'.
	 * @generated
	 */
	UseCase createUseCase();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	PlantUMLPackage getPlantUMLPackage();

} //PlantUMLFactory
