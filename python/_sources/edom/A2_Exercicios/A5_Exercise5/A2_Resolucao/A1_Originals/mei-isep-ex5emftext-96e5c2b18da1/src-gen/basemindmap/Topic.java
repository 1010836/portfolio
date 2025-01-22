/**
 */
package basemindmap;

import java.util.Date;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Topic</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link basemindmap.Topic#getDescription <em>Description</em>}</li>
 *   <li>{@link basemindmap.Topic#getStart <em>Start</em>}</li>
 *   <li>{@link basemindmap.Topic#getEnd <em>End</em>}</li>
 *   <li>{@link basemindmap.Topic#getPriority <em>Priority</em>}</li>
 *   <li>{@link basemindmap.Topic#getParent <em>Parent</em>}</li>
 *   <li>{@link basemindmap.Topic#getSubtopics <em>Subtopics</em>}</li>
 * </ul>
 *
 * @see basemindmap.BasemindmapPackage#getTopic()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='EndAfterStart'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot EndAfterStart='self.end &gt; self.start'"
 * @generated
 */
public interface Topic extends MapElement {
	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see basemindmap.BasemindmapPackage#getTopic_Description()
	 * @model id="true"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link basemindmap.Topic#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start</em>' attribute.
	 * @see #setStart(Date)
	 * @see basemindmap.BasemindmapPackage#getTopic_Start()
	 * @model
	 * @generated
	 */
	Date getStart();

	/**
	 * Sets the value of the '{@link basemindmap.Topic#getStart <em>Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start</em>' attribute.
	 * @see #getStart()
	 * @generated
	 */
	void setStart(Date value);

	/**
	 * Returns the value of the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>End</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End</em>' attribute.
	 * @see #setEnd(Date)
	 * @see basemindmap.BasemindmapPackage#getTopic_End()
	 * @model
	 * @generated
	 */
	Date getEnd();

	/**
	 * Sets the value of the '{@link basemindmap.Topic#getEnd <em>End</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End</em>' attribute.
	 * @see #getEnd()
	 * @generated
	 */
	void setEnd(Date value);

	/**
	 * Returns the value of the '<em><b>Priority</b></em>' attribute.
	 * The literals are from the enumeration {@link basemindmap.Priority}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Priority</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Priority</em>' attribute.
	 * @see basemindmap.Priority
	 * @see #setPriority(Priority)
	 * @see basemindmap.BasemindmapPackage#getTopic_Priority()
	 * @model
	 * @generated
	 */
	Priority getPriority();

	/**
	 * Sets the value of the '{@link basemindmap.Topic#getPriority <em>Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Priority</em>' attribute.
	 * @see basemindmap.Priority
	 * @see #getPriority()
	 * @generated
	 */
	void setPriority(Priority value);

	/**
	 * Returns the value of the '<em><b>Parent</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link basemindmap.Topic#getSubtopics <em>Subtopics</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' reference.
	 * @see #setParent(Topic)
	 * @see basemindmap.BasemindmapPackage#getTopic_Parent()
	 * @see basemindmap.Topic#getSubtopics
	 * @model opposite="subtopics"
	 * @generated
	 */
	Topic getParent();

	/**
	 * Sets the value of the '{@link basemindmap.Topic#getParent <em>Parent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(Topic value);

	/**
	 * Returns the value of the '<em><b>Subtopics</b></em>' reference list.
	 * The list contents are of type {@link basemindmap.Topic}.
	 * It is bidirectional and its opposite is '{@link basemindmap.Topic#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Subtopics</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Subtopics</em>' reference list.
	 * @see basemindmap.BasemindmapPackage#getTopic_Subtopics()
	 * @see basemindmap.Topic#getParent
	 * @model opposite="parent" ordered="false"
	 * @generated
	 */
	EList<Topic> getSubtopics();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self-&gt;closure(subtopics)'"
	 * @generated
	 */
	EList<Topic> allSubTopics();

} // Topic
