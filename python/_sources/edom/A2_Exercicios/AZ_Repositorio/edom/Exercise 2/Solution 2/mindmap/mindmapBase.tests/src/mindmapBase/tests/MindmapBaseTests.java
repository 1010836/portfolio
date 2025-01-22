/**
 */
package mindmapBase.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test suite for the '<em><b>mindmapBase</b></em>' package.
 * <!-- end-user-doc -->
 * @generated
 */
public class MindmapBaseTests extends TestSuite {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(suite());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Test suite() {
		TestSuite suite = new MindmapBaseTests("mindmapBase Tests");
		suite.addTestSuite(MapTest.class);
		suite.addTestSuite(TopicTest.class);
		return suite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MindmapBaseTests(String name) {
		super(name);
	}

} //MindmapBaseTests
