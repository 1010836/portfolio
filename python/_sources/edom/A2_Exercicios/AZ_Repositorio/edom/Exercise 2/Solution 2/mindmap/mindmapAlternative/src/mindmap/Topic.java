/**
 */
package mindmap;

import java.util.Date;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Topic</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link mindmap.Topic#getDescription <em>Description</em>}</li>
 *   <li>{@link mindmap.Topic#getStart <em>Start</em>}</li>
 *   <li>{@link mindmap.Topic#getEnd <em>End</em>}</li>
 *   <li>{@link mindmap.Topic#getLinks <em>Links</em>}</li>
 *   <li>{@link mindmap.Topic#getPriority <em>Priority</em>}</li>
 *   <li>{@link mindmap.Topic#getSubtopics <em>Subtopics</em>}</li>
 * </ul>
 *
 * @see mindmap.MindmapPackage#getTopic()
 * @model
 * @generated
 */
public interface Topic extends EObject {
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
	 * @see mindmap.MindmapPackage#getTopic_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link mindmap.Topic#getDescription <em>Description</em>}' attribute.
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
	 * @see mindmap.MindmapPackage#getTopic_Start()
	 * @model
	 * @generated
	 */
	Date getStart();

	/**
	 * Sets the value of the '{@link mindmap.Topic#getStart <em>Start</em>}' attribute.
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
	 * @see mindmap.MindmapPackage#getTopic_End()
	 * @model
	 * @generated
	 */
	Date getEnd();

	/**
	 * Sets the value of the '{@link mindmap.Topic#getEnd <em>End</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End</em>' attribute.
	 * @see #getEnd()
	 * @generated
	 */
	void setEnd(Date value);

	/**
	 * Returns the value of the '<em><b>Links</b></em>' containment reference list.
	 * The list contents are of type {@link mindmap.Link}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Links</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Links</em>' containment reference list.
	 * @see mindmap.MindmapPackage#getTopic_Links()
	 * @model containment="true"
	 * @generated
	 */
	EList<Link> getLinks();

	/**
	 * Returns the value of the '<em><b>Priority</b></em>' attribute.
	 * The default value is <code>"HIGH"</code>.
	 * The literals are from the enumeration {@link mindmap.Priority}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Priority</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Priority</em>' attribute.
	 * @see mindmap.Priority
	 * @see #setPriority(Priority)
	 * @see mindmap.MindmapPackage#getTopic_Priority()
	 * @model default="HIGH"
	 * @generated
	 */
	Priority getPriority();

	/**
	 * Sets the value of the '{@link mindmap.Topic#getPriority <em>Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Priority</em>' attribute.
	 * @see mindmap.Priority
	 * @see #getPriority()
	 * @generated
	 */
	void setPriority(Priority value);

	/**
	 * Returns the value of the '<em><b>Subtopics</b></em>' containment reference list.
	 * The list contents are of type {@link mindmap.Topic}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Subtopics</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Subtopics</em>' containment reference list.
	 * @see mindmap.MindmapPackage#getTopic_Subtopics()
	 * @model containment="true"
	 * @generated
	 */
	EList<Topic> getSubtopics();

} // Topic
