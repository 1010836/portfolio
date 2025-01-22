/**
 */
package mindmapBase;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
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
 * @see mindmapBase.MindmapBaseFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/OCL/Import ecore='http://www.eclipse.org/emf/2002/Ecore#/'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore invocationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot' settingDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot' validationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot'"
 * @generated
 */
public interface MindmapBasePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "mindmapBase";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.example.org/mindmapBase";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "mindmapBase";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MindmapBasePackage eINSTANCE = mindmapBase.impl.MindmapBasePackageImpl.init();

	/**
	 * The meta object id for the '{@link mindmapBase.impl.MapImpl <em>Map</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mindmapBase.impl.MapImpl
	 * @see mindmapBase.impl.MindmapBasePackageImpl#getMap()
	 * @generated
	 */
	int MAP = 0;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP__TITLE = 0;

	/**
	 * The feature id for the '<em><b>Created</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP__CREATED = 1;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP__ELEMENTS = 2;

	/**
	 * The feature id for the '<em><b>Root Topics</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP__ROOT_TOPICS = 3;

	/**
	 * The number of structural features of the '<em>Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link mindmapBase.impl.MapElementImpl <em>Map Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mindmapBase.impl.MapElementImpl
	 * @see mindmapBase.impl.MindmapBasePackageImpl#getMapElement()
	 * @generated
	 */
	int MAP_ELEMENT = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_ELEMENT__NAME = 0;

	/**
	 * The number of structural features of the '<em>Map Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Map Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link mindmapBase.impl.RelationshipImpl <em>Relationship</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mindmapBase.impl.RelationshipImpl
	 * @see mindmapBase.impl.MindmapBasePackageImpl#getRelationship()
	 * @generated
	 */
	int RELATIONSHIP = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP__NAME = MAP_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP__TYPE = MAP_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP__SOURCE = MAP_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP__TARGET = MAP_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Relationship</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP_FEATURE_COUNT = MAP_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Relationship</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP_OPERATION_COUNT = MAP_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link mindmapBase.impl.TopicImpl <em>Topic</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mindmapBase.impl.TopicImpl
	 * @see mindmapBase.impl.MindmapBasePackageImpl#getTopic()
	 * @generated
	 */
	int TOPIC = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPIC__NAME = MAP_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPIC__DESCRIPTION = MAP_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPIC__START = MAP_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPIC__END = MAP_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPIC__PRIORITY = MAP_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPIC__PARENT = MAP_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Subtopics</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPIC__SUBTOPICS = MAP_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Topic</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPIC_FEATURE_COUNT = MAP_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The operation id for the '<em>All Sub Topics</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPIC___ALL_SUB_TOPICS = MAP_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Topic</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPIC_OPERATION_COUNT = MAP_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link mindmapBase.Priority <em>Priority</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mindmapBase.Priority
	 * @see mindmapBase.impl.MindmapBasePackageImpl#getPriority()
	 * @generated
	 */
	int PRIORITY = 4;

	/**
	 * The meta object id for the '{@link mindmapBase.Type <em>Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mindmapBase.Type
	 * @see mindmapBase.impl.MindmapBasePackageImpl#getType()
	 * @generated
	 */
	int TYPE = 5;


	/**
	 * Returns the meta object for class '{@link mindmapBase.Map <em>Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Map</em>'.
	 * @see mindmapBase.Map
	 * @generated
	 */
	EClass getMap();

	/**
	 * Returns the meta object for the attribute '{@link mindmapBase.Map#getTitle <em>Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Title</em>'.
	 * @see mindmapBase.Map#getTitle()
	 * @see #getMap()
	 * @generated
	 */
	EAttribute getMap_Title();

	/**
	 * Returns the meta object for the attribute '{@link mindmapBase.Map#getCreated <em>Created</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Created</em>'.
	 * @see mindmapBase.Map#getCreated()
	 * @see #getMap()
	 * @generated
	 */
	EAttribute getMap_Created();

	/**
	 * Returns the meta object for the containment reference list '{@link mindmapBase.Map#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Elements</em>'.
	 * @see mindmapBase.Map#getElements()
	 * @see #getMap()
	 * @generated
	 */
	EReference getMap_Elements();

	/**
	 * Returns the meta object for the reference list '{@link mindmapBase.Map#getRootTopics <em>Root Topics</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Root Topics</em>'.
	 * @see mindmapBase.Map#getRootTopics()
	 * @see #getMap()
	 * @generated
	 */
	EReference getMap_RootTopics();

	/**
	 * Returns the meta object for class '{@link mindmapBase.Relationship <em>Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Relationship</em>'.
	 * @see mindmapBase.Relationship
	 * @generated
	 */
	EClass getRelationship();

	/**
	 * Returns the meta object for the attribute '{@link mindmapBase.Relationship#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see mindmapBase.Relationship#getType()
	 * @see #getRelationship()
	 * @generated
	 */
	EAttribute getRelationship_Type();

	/**
	 * Returns the meta object for the reference '{@link mindmapBase.Relationship#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see mindmapBase.Relationship#getSource()
	 * @see #getRelationship()
	 * @generated
	 */
	EReference getRelationship_Source();

	/**
	 * Returns the meta object for the reference '{@link mindmapBase.Relationship#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see mindmapBase.Relationship#getTarget()
	 * @see #getRelationship()
	 * @generated
	 */
	EReference getRelationship_Target();

	/**
	 * Returns the meta object for class '{@link mindmapBase.Topic <em>Topic</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Topic</em>'.
	 * @see mindmapBase.Topic
	 * @generated
	 */
	EClass getTopic();

	/**
	 * Returns the meta object for the attribute '{@link mindmapBase.Topic#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see mindmapBase.Topic#getDescription()
	 * @see #getTopic()
	 * @generated
	 */
	EAttribute getTopic_Description();

	/**
	 * Returns the meta object for the attribute '{@link mindmapBase.Topic#getStart <em>Start</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start</em>'.
	 * @see mindmapBase.Topic#getStart()
	 * @see #getTopic()
	 * @generated
	 */
	EAttribute getTopic_Start();

	/**
	 * Returns the meta object for the attribute '{@link mindmapBase.Topic#getEnd <em>End</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>End</em>'.
	 * @see mindmapBase.Topic#getEnd()
	 * @see #getTopic()
	 * @generated
	 */
	EAttribute getTopic_End();

	/**
	 * Returns the meta object for the attribute '{@link mindmapBase.Topic#getPriority <em>Priority</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Priority</em>'.
	 * @see mindmapBase.Topic#getPriority()
	 * @see #getTopic()
	 * @generated
	 */
	EAttribute getTopic_Priority();

	/**
	 * Returns the meta object for the reference '{@link mindmapBase.Topic#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parent</em>'.
	 * @see mindmapBase.Topic#getParent()
	 * @see #getTopic()
	 * @generated
	 */
	EReference getTopic_Parent();

	/**
	 * Returns the meta object for the reference list '{@link mindmapBase.Topic#getSubtopics <em>Subtopics</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Subtopics</em>'.
	 * @see mindmapBase.Topic#getSubtopics()
	 * @see #getTopic()
	 * @generated
	 */
	EReference getTopic_Subtopics();

	/**
	 * Returns the meta object for the '{@link mindmapBase.Topic#allSubTopics() <em>All Sub Topics</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>All Sub Topics</em>' operation.
	 * @see mindmapBase.Topic#allSubTopics()
	 * @generated
	 */
	EOperation getTopic__AllSubTopics();

	/**
	 * Returns the meta object for class '{@link mindmapBase.MapElement <em>Map Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Map Element</em>'.
	 * @see mindmapBase.MapElement
	 * @generated
	 */
	EClass getMapElement();

	/**
	 * Returns the meta object for the attribute '{@link mindmapBase.MapElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see mindmapBase.MapElement#getName()
	 * @see #getMapElement()
	 * @generated
	 */
	EAttribute getMapElement_Name();

	/**
	 * Returns the meta object for enum '{@link mindmapBase.Priority <em>Priority</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Priority</em>'.
	 * @see mindmapBase.Priority
	 * @generated
	 */
	EEnum getPriority();

	/**
	 * Returns the meta object for enum '{@link mindmapBase.Type <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Type</em>'.
	 * @see mindmapBase.Type
	 * @generated
	 */
	EEnum getType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	MindmapBaseFactory getMindmapBaseFactory();

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
		 * The meta object literal for the '{@link mindmapBase.impl.MapImpl <em>Map</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mindmapBase.impl.MapImpl
		 * @see mindmapBase.impl.MindmapBasePackageImpl#getMap()
		 * @generated
		 */
		EClass MAP = eINSTANCE.getMap();

		/**
		 * The meta object literal for the '<em><b>Title</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAP__TITLE = eINSTANCE.getMap_Title();

		/**
		 * The meta object literal for the '<em><b>Created</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAP__CREATED = eINSTANCE.getMap_Created();

		/**
		 * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAP__ELEMENTS = eINSTANCE.getMap_Elements();

		/**
		 * The meta object literal for the '<em><b>Root Topics</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAP__ROOT_TOPICS = eINSTANCE.getMap_RootTopics();

		/**
		 * The meta object literal for the '{@link mindmapBase.impl.RelationshipImpl <em>Relationship</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mindmapBase.impl.RelationshipImpl
		 * @see mindmapBase.impl.MindmapBasePackageImpl#getRelationship()
		 * @generated
		 */
		EClass RELATIONSHIP = eINSTANCE.getRelationship();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RELATIONSHIP__TYPE = eINSTANCE.getRelationship_Type();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATIONSHIP__SOURCE = eINSTANCE.getRelationship_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATIONSHIP__TARGET = eINSTANCE.getRelationship_Target();

		/**
		 * The meta object literal for the '{@link mindmapBase.impl.TopicImpl <em>Topic</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mindmapBase.impl.TopicImpl
		 * @see mindmapBase.impl.MindmapBasePackageImpl#getTopic()
		 * @generated
		 */
		EClass TOPIC = eINSTANCE.getTopic();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TOPIC__DESCRIPTION = eINSTANCE.getTopic_Description();

		/**
		 * The meta object literal for the '<em><b>Start</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TOPIC__START = eINSTANCE.getTopic_Start();

		/**
		 * The meta object literal for the '<em><b>End</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TOPIC__END = eINSTANCE.getTopic_End();

		/**
		 * The meta object literal for the '<em><b>Priority</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TOPIC__PRIORITY = eINSTANCE.getTopic_Priority();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TOPIC__PARENT = eINSTANCE.getTopic_Parent();

		/**
		 * The meta object literal for the '<em><b>Subtopics</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TOPIC__SUBTOPICS = eINSTANCE.getTopic_Subtopics();

		/**
		 * The meta object literal for the '<em><b>All Sub Topics</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TOPIC___ALL_SUB_TOPICS = eINSTANCE.getTopic__AllSubTopics();

		/**
		 * The meta object literal for the '{@link mindmapBase.impl.MapElementImpl <em>Map Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mindmapBase.impl.MapElementImpl
		 * @see mindmapBase.impl.MindmapBasePackageImpl#getMapElement()
		 * @generated
		 */
		EClass MAP_ELEMENT = eINSTANCE.getMapElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAP_ELEMENT__NAME = eINSTANCE.getMapElement_Name();

		/**
		 * The meta object literal for the '{@link mindmapBase.Priority <em>Priority</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mindmapBase.Priority
		 * @see mindmapBase.impl.MindmapBasePackageImpl#getPriority()
		 * @generated
		 */
		EEnum PRIORITY = eINSTANCE.getPriority();

		/**
		 * The meta object literal for the '{@link mindmapBase.Type <em>Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mindmapBase.Type
		 * @see mindmapBase.impl.MindmapBasePackageImpl#getType()
		 * @generated
		 */
		EEnum TYPE = eINSTANCE.getType();

	}

} //MindmapBasePackage
