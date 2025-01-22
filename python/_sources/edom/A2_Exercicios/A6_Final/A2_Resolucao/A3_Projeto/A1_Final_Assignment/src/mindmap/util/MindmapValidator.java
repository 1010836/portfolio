/**
 */
package mindmap.util;

import java.util.Map;

import mindmap.*;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see mindmap.MindmapPackage
 * @generated
 */
public class MindmapValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final MindmapValidator INSTANCE = new MindmapValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "mindmap";

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 0;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MindmapValidator() {
		super();
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EPackage getEPackage() {
	  return MindmapPackage.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresponding classifier of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
		switch (classifierID) {
			case MindmapPackage.MAP_ELEMENT:
				return validateMapElement((MapElement)value, diagnostics, context);
			case MindmapPackage.MAP:
				return validateMap((mindmap.Map)value, diagnostics, context);
			case MindmapPackage.TOPIC:
				return validateTopic((Topic)value, diagnostics, context);
			case MindmapPackage.RELATIONSHIP:
				return validateRelationship((Relationship)value, diagnostics, context);
			case MindmapPackage.TYPE:
				return validateType((Type)value, diagnostics, context);
			case MindmapPackage.PRIORITY:
				return validatePriority((Priority)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMapElement(MapElement mapElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(mapElement, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMap(mindmap.Map map, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(map, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(map, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(map, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(map, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(map, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(map, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(map, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(map, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(map, diagnostics, context);
		if (result || diagnostics != null) result &= validateMap_mustHaveTitle(map, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the mustHaveTitle constraint of '<em>Map</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String MAP__MUST_HAVE_TITLE__EEXPRESSION = "not title.oclIsUndefined()";

	/**
	 * Validates the mustHaveTitle constraint of '<em>Map</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMap_mustHaveTitle(mindmap.Map map, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(MindmapPackage.Literals.MAP,
				 map,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "mustHaveTitle",
				 MAP__MUST_HAVE_TITLE__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTopic(Topic topic, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(topic, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(topic, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(topic, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(topic, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(topic, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(topic, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(topic, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(topic, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(topic, diagnostics, context);
		if (result || diagnostics != null) result &= validateTopic_EndAfterStart(topic, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the EndAfterStart constraint of '<em>Topic</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String TOPIC__END_AFTER_START__EEXPRESSION = "self.end >= self.start";

	/**
	 * Validates the EndAfterStart constraint of '<em>Topic</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTopic_EndAfterStart(Topic topic, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(MindmapPackage.Literals.TOPIC,
				 topic,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "EndAfterStart",
				 TOPIC__END_AFTER_START__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRelationship(Relationship relationship, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(relationship, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateType(Type type, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePriority(Priority priority, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		// TODO
		// Specialize this to return a resource locator for messages specific to this validator.
		// Ensure that you remove @generated or mark it @generated NOT
		return super.getResourceLocator();
	}

} //MindmapValidator
