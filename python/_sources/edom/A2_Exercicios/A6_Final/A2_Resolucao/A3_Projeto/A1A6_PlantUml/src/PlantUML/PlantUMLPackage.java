/**
 */
package PlantUML;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see PlantUML.PlantUMLFactory
 * @model kind="package"
 * @generated
 */
public interface PlantUMLPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "PlantUML";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "PlantUML";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "PlantUML";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PlantUMLPackage eINSTANCE = PlantUML.impl.PlantUMLPackageImpl.init();

	/**
	 * The meta object id for the '{@link PlantUML.impl.ModeloImpl <em>Modelo</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see PlantUML.impl.ModeloImpl
	 * @see PlantUML.impl.PlantUMLPackageImpl#getModelo()
	 * @generated
	 */
	int MODELO = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODELO__NAME = 0;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODELO__ELEMENT = 1;

	/**
	 * The number of structural features of the '<em>Modelo</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODELO_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Modelo</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODELO_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link PlantUML.impl.UseCaseImpl <em>Use Case</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see PlantUML.impl.UseCaseImpl
	 * @see PlantUML.impl.PlantUMLPackageImpl#getUseCase()
	 * @generated
	 */
	int USE_CASE = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Long Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE__LONG_NAME = 1;

	/**
	 * The number of structural features of the '<em>Use Case</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Use Case</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link PlantUML.Modelo <em>Modelo</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Modelo</em>'.
	 * @see PlantUML.Modelo
	 * @generated
	 */
	EClass getModelo();

	/**
	 * Returns the meta object for the attribute list '{@link PlantUML.Modelo#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Name</em>'.
	 * @see PlantUML.Modelo#getName()
	 * @see #getModelo()
	 * @generated
	 */
	EAttribute getModelo_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link PlantUML.Modelo#getElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Element</em>'.
	 * @see PlantUML.Modelo#getElement()
	 * @see #getModelo()
	 * @generated
	 */
	EReference getModelo_Element();

	/**
	 * Returns the meta object for class '{@link PlantUML.UseCase <em>Use Case</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Use Case</em>'.
	 * @see PlantUML.UseCase
	 * @generated
	 */
	EClass getUseCase();

	/**
	 * Returns the meta object for the attribute '{@link PlantUML.UseCase#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see PlantUML.UseCase#getName()
	 * @see #getUseCase()
	 * @generated
	 */
	EAttribute getUseCase_Name();

	/**
	 * Returns the meta object for the attribute '{@link PlantUML.UseCase#getLongName <em>Long Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Long Name</em>'.
	 * @see PlantUML.UseCase#getLongName()
	 * @see #getUseCase()
	 * @generated
	 */
	EAttribute getUseCase_LongName();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	PlantUMLFactory getPlantUMLFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link PlantUML.impl.ModeloImpl <em>Modelo</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see PlantUML.impl.ModeloImpl
		 * @see PlantUML.impl.PlantUMLPackageImpl#getModelo()
		 * @generated
		 */
		EClass MODELO = eINSTANCE.getModelo();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODELO__NAME = eINSTANCE.getModelo_Name();

		/**
		 * The meta object literal for the '<em><b>Element</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODELO__ELEMENT = eINSTANCE.getModelo_Element();

		/**
		 * The meta object literal for the '{@link PlantUML.impl.UseCaseImpl <em>Use Case</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see PlantUML.impl.UseCaseImpl
		 * @see PlantUML.impl.PlantUMLPackageImpl#getUseCase()
		 * @generated
		 */
		EClass USE_CASE = eINSTANCE.getUseCase();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USE_CASE__NAME = eINSTANCE.getUseCase_Name();

		/**
		 * The meta object literal for the '<em><b>Long Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USE_CASE__LONG_NAME = eINSTANCE.getUseCase_LongName();

	}

} //PlantUMLPackage
