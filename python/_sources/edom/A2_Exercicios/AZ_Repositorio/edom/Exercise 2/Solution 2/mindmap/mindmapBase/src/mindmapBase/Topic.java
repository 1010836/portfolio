/**
 */
package mindmapBase;

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
 *   <li>{@link mindmapBase.Topic#getDescription <em>Description</em>}</li>
 *   <li>{@link mindmapBase.Topic#getStart <em>Start</em>}</li>
 *   <li>{@link mindmapBase.Topic#getEnd <em>End</em>}</li>
 *   <li>{@link mindmapBase.Topic#getPriority <em>Priority</em>}</li>
 *   <li>{@link mindmapBase.Topic#getParent <em>Parent</em>}</li>
 *   <li>{@link mindmapBase.Topic#getSubtopics <em>Subtopics</em>}</li>
 * </ul>
 *
 * @see mindmapBase.MindmapBasePackage#getTopic()
 * @model
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
	 * @see mindmapBase.MindmapBasePackage#getTopic_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link mindmapBase.Topic#getDescription <em>Description</em>}' attribute.
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
	 * @see mindmapBase.MindmapBasePackage#getTopic_Start()
	 * @model
	 * @generated
	 */
	Date getStart();

	/**
	 * Sets the value of the '{@link mindmapBase.Topic#getStart <em>Start</em>}' attribute.
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
	 * @see mindmapBase.MindmapBasePackage#getTopic_End()
	 * @model
	 * @generated
	 */
	Date getEnd();

	/**
	 * Sets the value of the '{@link mindmapBase.Topic#getEnd <em>End</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End</em>' attribute.
	 * @see #getEnd()
	 * @generated
	 */
	void setEnd(Date value);

	/**
	 * Returns the value of the '<em><b>Priority</b></em>' attribute.
	 * The default value is <code>"LOW"</code>.
	 * The literals are from the enumeration {@link mindmapBase.Priority}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Priority</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Priority</em>' attribute.
	 * @see mindmapBase.Priority
	 * @see #setPriority(Priority)
	 * @see mindmapBase.MindmapBasePackage#getTopic_Priority()
	 * @model default="LOW"
	 * @generated
	 */
	Priority getPriority();

	/**
	 * Sets the value of the '{@link mindmapBase.Topic#getPriority <em>Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Priority</em>' attribute.
	 * @see mindmapBase.Priority
	 * @see #getPriority()
	 * @generated
	 */
	void setPriority(Priority value);

	/**
	 * Returns the value of the '<em><b>Parent</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link mindmapBase.Topic#getSubtopics <em>Subtopics</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' reference.
	 * @see #setParent(Topic)
	 * @see mindmapBase.MindmapBasePackage#getTopic_Parent()
	 * @see mindmapBase.Topic#getSubtopics
	 * @model opposite="subtopics"
	 * @generated
	 */
	Topic getParent();

	/**
	 * Sets the value of the '{@link mindmapBase.Topic#getParent <em>Parent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(Topic value);

	/**
	 * Returns the value of the '<em><b>Subtopics</b></em>' reference list.
	 * The list contents are of type {@link mindmapBase.Topic}.
	 * It is bidirectional and its opposite is '{@link mindmapBase.Topic#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Subtopics</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Subtopics</em>' reference list.
	 * @see mindmapBase.MindmapBasePackage#getTopic_Subtopics()
	 * @see mindmapBase.Topic#getParent
	 * @model opposite="parent"
	 * @generated
	 */
	EList<Topic> getSubtopics();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false"
	 * @generated
	 */
	EList<Topic> allSubTopics();

} // Topic
