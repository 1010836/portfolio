/**
 */
package mindmap.impl;

import mindmap.Map;
import mindmap.MapElement;
import mindmap.MindmapFactory;
import mindmap.MindmapPackage;
import mindmap.Priority;
import mindmap.Relationship;
import mindmap.Topic;
import mindmap.Type;

import mindmap.util.MindmapValidator;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MindmapPackageImpl extends EPackageImpl implements MindmapPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mapElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mapEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass topicEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass relationshipEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum typeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum priorityEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see mindmap.MindmapPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private MindmapPackageImpl() {
		super(eNS_URI, MindmapFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link MindmapPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static MindmapPackage init() {
		if (isInited) return (MindmapPackage)EPackage.Registry.INSTANCE.getEPackage(MindmapPackage.eNS_URI);

		// Obtain or create and register package
		MindmapPackageImpl theMindmapPackage = (MindmapPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof MindmapPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new MindmapPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theMindmapPackage.createPackageContents();

		// Initialize created meta-data
		theMindmapPackage.initializePackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put
			(theMindmapPackage, 
			 new EValidator.Descriptor() {
				 public EValidator getEValidator() {
					 return MindmapValidator.INSTANCE;
				 }
			 });

		// Mark meta-data to indicate it can't be changed
		theMindmapPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(MindmapPackage.eNS_URI, theMindmapPackage);
		return theMindmapPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMapElement() {
		return mapElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMapElement_Name() {
		return (EAttribute)mapElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMap() {
		return mapEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMap_Title() {
		return (EAttribute)mapEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMap_Created() {
		return (EAttribute)mapEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMap_Elements() {
		return (EReference)mapEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMap_RootTopics() {
		return (EReference)mapEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTopic() {
		return topicEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTopic_Description() {
		return (EAttribute)topicEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTopic_Start() {
		return (EAttribute)topicEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTopic_End() {
		return (EAttribute)topicEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTopic_Priority() {
		return (EAttribute)topicEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTopic_Subtopics() {
		return (EReference)topicEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTopic_Parent() {
		return (EReference)topicEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTopic__AllSubtopics() {
		return topicEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRelationship() {
		return relationshipEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRelationship_Source() {
		return (EReference)relationshipEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRelationship_Type() {
		return (EAttribute)relationshipEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRelationship_Target() {
		return (EReference)relationshipEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getType() {
		return typeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getPriority() {
		return priorityEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MindmapFactory getMindmapFactory() {
		return (MindmapFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		mapElementEClass = createEClass(MAP_ELEMENT);
		createEAttribute(mapElementEClass, MAP_ELEMENT__NAME);

		mapEClass = createEClass(MAP);
		createEAttribute(mapEClass, MAP__TITLE);
		createEAttribute(mapEClass, MAP__CREATED);
		createEReference(mapEClass, MAP__ELEMENTS);
		createEReference(mapEClass, MAP__ROOT_TOPICS);

		topicEClass = createEClass(TOPIC);
		createEAttribute(topicEClass, TOPIC__DESCRIPTION);
		createEAttribute(topicEClass, TOPIC__START);
		createEAttribute(topicEClass, TOPIC__END);
		createEAttribute(topicEClass, TOPIC__PRIORITY);
		createEReference(topicEClass, TOPIC__SUBTOPICS);
		createEReference(topicEClass, TOPIC__PARENT);
		createEOperation(topicEClass, TOPIC___ALL_SUBTOPICS);

		relationshipEClass = createEClass(RELATIONSHIP);
		createEReference(relationshipEClass, RELATIONSHIP__SOURCE);
		createEAttribute(relationshipEClass, RELATIONSHIP__TYPE);
		createEReference(relationshipEClass, RELATIONSHIP__TARGET);

		// Create enums
		typeEEnum = createEEnum(TYPE);
		priorityEEnum = createEEnum(PRIORITY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		topicEClass.getESuperTypes().add(this.getMapElement());
		relationshipEClass.getESuperTypes().add(this.getMapElement());

		// Initialize classes, features, and operations; add parameters
		initEClass(mapElementEClass, MapElement.class, "MapElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMapElement_Name(), ecorePackage.getEString(), "name", null, 0, 1, MapElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mapEClass, Map.class, "Map", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMap_Title(), ecorePackage.getEString(), "title", null, 0, 1, Map.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMap_Created(), ecorePackage.getEDate(), "created", null, 0, 1, Map.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMap_Elements(), this.getMapElement(), null, "elements", null, 0, -1, Map.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMap_RootTopics(), this.getTopic(), null, "rootTopics", null, 0, -1, Map.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(topicEClass, Topic.class, "Topic", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTopic_Description(), ecorePackage.getEString(), "description", null, 0, 1, Topic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTopic_Start(), ecorePackage.getEDate(), "start", null, 0, 1, Topic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTopic_End(), ecorePackage.getEDate(), "end", null, 0, 1, Topic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTopic_Priority(), this.getPriority(), "priority", "LOW", 0, 1, Topic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTopic_Subtopics(), this.getTopic(), this.getTopic_Parent(), "subtopics", null, 0, -1, Topic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTopic_Parent(), this.getTopic(), this.getTopic_Subtopics(), "parent", null, 0, 1, Topic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getTopic__AllSubtopics(), this.getTopic(), "allSubtopics", 0, -1, IS_UNIQUE, !IS_ORDERED);

		initEClass(relationshipEClass, Relationship.class, "Relationship", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRelationship_Source(), this.getTopic(), null, "source", null, 1, 1, Relationship.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRelationship_Type(), this.getType(), "type", "DEPENDENCY", 0, 1, Relationship.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelationship_Target(), this.getTopic(), null, "target", null, 1, 1, Relationship.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(typeEEnum, Type.class, "Type");
		addEEnumLiteral(typeEEnum, Type.DEPENDENCY);
		addEEnumLiteral(typeEEnum, Type.INCLUDE);
		addEEnumLiteral(typeEEnum, Type.EXTEND);

		initEEnum(priorityEEnum, Priority.class, "Priority");
		addEEnumLiteral(priorityEEnum, Priority.HIGH);
		addEEnumLiteral(priorityEEnum, Priority.MEDIUM);
		addEEnumLiteral(priorityEEnum, Priority.LOW);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/OCL/Import
		createImportAnnotations();
		// http://www.eclipse.org/emf/2002/Ecore
		createEcoreAnnotations();
		// http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot
		createPivotAnnotations();
		// http://www.eclipse.org/OCL/Collection
		createCollectionAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/OCL/Import</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createImportAnnotations() {
		String source = "http://www.eclipse.org/OCL/Import";	
		addAnnotation
		  (this, 
		   source, 
		   new String[] {
			 "ecore", "http://www.eclipse.org/emf/2002/Ecore"
		   });
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createEcoreAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/Ecore";	
		addAnnotation
		  (this, 
		   source, 
		   new String[] {
			 "invocationDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
			 "settingDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
			 "validationDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot"
		   });	
		addAnnotation
		  (mapEClass, 
		   source, 
		   new String[] {
			 "constraints", "mustHaveTitle"
		   });	
		addAnnotation
		  (topicEClass, 
		   source, 
		   new String[] {
			 "constraints", "EndAfterStart"
		   });
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createPivotAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot";	
		addAnnotation
		  (mapEClass, 
		   source, 
		   new String[] {
			 "mustHaveTitle", "not title.oclIsUndefined()"
		   });	
		addAnnotation
		  (getMap_RootTopics(), 
		   source, 
		   new String[] {
			 "derivation", "let topics : Set(mindmap::Topic) =\n\t\t\tself.elements->select(oclIsKindOf(mindmap::Topic))->\n\t\t\tcollect(oclAsType(mindmap::Topic))->asSet() in\n\t\t\ttopics->asOrderedSet()->\n\t\t\tsymmetricDifference(topics.subtopics->asSet())->asOrderedSet()"
		   });	
		addAnnotation
		  (topicEClass, 
		   source, 
		   new String[] {
			 "EndAfterStart", "self.end >= self.start"
		   });	
		addAnnotation
		  (getTopic__AllSubtopics(), 
		   source, 
		   new String[] {
			 "body", "self->closure(subtopics)"
		   });
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/OCL/Collection</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createCollectionAnnotations() {
		String source = "http://www.eclipse.org/OCL/Collection";	
		addAnnotation
		  (getMap_RootTopics(), 
		   source, 
		   new String[] {
			 "nullFree", "false"
		   });	
		addAnnotation
		  (getTopic__AllSubtopics(), 
		   source, 
		   new String[] {
			 "nullFree", "false"
		   });
	}

} //MindmapPackageImpl
