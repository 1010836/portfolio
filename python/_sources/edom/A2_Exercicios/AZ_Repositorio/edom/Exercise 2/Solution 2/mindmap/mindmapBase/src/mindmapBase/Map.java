/**
 */
package mindmapBase;

import java.util.Date;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Map</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link mindmapBase.Map#getTitle <em>Title</em>}</li>
 *   <li>{@link mindmapBase.Map#getCreated <em>Created</em>}</li>
 *   <li>{@link mindmapBase.Map#getElements <em>Elements</em>}</li>
 *   <li>{@link mindmapBase.Map#getRootTopics <em>Root Topics</em>}</li>
 * </ul>
 *
 * @see mindmapBase.MindmapBasePackage#getMap()
 * @model
 * @generated
 */
public interface Map extends EObject {
	/**
	 * Returns the value of the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Title</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Title</em>' attribute.
	 * @see #setTitle(String)
	 * @see mindmapBase.MindmapBasePackage#getMap_Title()
	 * @model
	 * @generated
	 */
	String getTitle();

	/**
	 * Sets the value of the '{@link mindmapBase.Map#getTitle <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Title</em>' attribute.
	 * @see #getTitle()
	 * @generated
	 */
	void setTitle(String value);

	/**
	 * Returns the value of the '<em><b>Created</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Created</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Created</em>' attribute.
	 * @see #setCreated(Date)
	 * @see mindmapBase.MindmapBasePackage#getMap_Created()
	 * @model
	 * @generated
	 */
	Date getCreated();

	/**
	 * Sets the value of the '{@link mindmapBase.Map#getCreated <em>Created</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Created</em>' attribute.
	 * @see #getCreated()
	 * @generated
	 */
	void setCreated(Date value);

	/**
	 * Returns the value of the '<em><b>Elements</b></em>' containment reference list.
	 * The list contents are of type {@link mindmapBase.MapElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Elements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Elements</em>' containment reference list.
	 * @see mindmapBase.MindmapBasePackage#getMap_Elements()
	 * @model containment="true"
	 * @generated
	 */
	EList<MapElement> getElements();

	/**
	 * Returns the value of the '<em><b>Root Topics</b></em>' reference list.
	 * The list contents are of type {@link mindmapBase.Topic}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Root Topics</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Root Topics</em>' reference list.
	 * @see mindmapBase.MindmapBasePackage#getMap_RootTopics()
	 * @model transient="true" volatile="true" derived="true"
	 * @generated
	 */
	EList<Topic> getRootTopics();

} // Map
