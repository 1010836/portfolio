/**
 */
package basemindmap;

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
 *   <li>{@link basemindmap.Map#getTitle <em>Title</em>}</li>
 *   <li>{@link basemindmap.Map#getCreated <em>Created</em>}</li>
 *   <li>{@link basemindmap.Map#getElements <em>Elements</em>}</li>
 * </ul>
 *
 * @see basemindmap.BasemindmapPackage#getMap()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='mustHaveTitle'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot mustHaveTitle='not title.oclIsUndefined()'"
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
	 * @see basemindmap.BasemindmapPackage#getMap_Title()
	 * @model
	 * @generated
	 */
	String getTitle();

	/**
	 * Sets the value of the '{@link basemindmap.Map#getTitle <em>Title</em>}' attribute.
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
	 * @see basemindmap.BasemindmapPackage#getMap_Created()
	 * @model
	 * @generated
	 */
	Date getCreated();

	/**
	 * Sets the value of the '{@link basemindmap.Map#getCreated <em>Created</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Created</em>' attribute.
	 * @see #getCreated()
	 * @generated
	 */
	void setCreated(Date value);

	/**
	 * Returns the value of the '<em><b>Elements</b></em>' containment reference list.
	 * The list contents are of type {@link basemindmap.MapElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Elements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Elements</em>' containment reference list.
	 * @see basemindmap.BasemindmapPackage#getMap_Elements()
	 * @model containment="true"
	 * @generated
	 */
	EList<MapElement> getElements();

} // Map
