/**
 */
package requirements.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import requirements.RequirementGroup;
import requirements.RequirementsFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Requirement Group</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class RequirementGroupTest extends TestCase {

	/**
	 * The fixture for this Requirement Group test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RequirementGroup fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(RequirementGroupTest.class);
	}

	/**
	 * Constructs a new Requirement Group test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RequirementGroupTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Requirement Group test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(RequirementGroup fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Requirement Group test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RequirementGroup getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(RequirementsFactory.eINSTANCE.createRequirementGroup());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

} //RequirementGroupTest
