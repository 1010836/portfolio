/**
 */
package requirements;

import java.util.Date;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Requirement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link requirements.Requirement#getTitle <em>Title</em>}</li>
 *   <li>{@link requirements.Requirement#getDescription <em>Description</em>}</li>
 *   <li>{@link requirements.Requirement#getType <em>Type</em>}</li>
 *   <li>{@link requirements.Requirement#getPriority <em>Priority</em>}</li>
 *   <li>{@link requirements.Requirement#getAuthor <em>Author</em>}</li>
 *   <li>{@link requirements.Requirement#getCreated <em>Created</em>}</li>
 *   <li>{@link requirements.Requirement#getId <em>Id</em>}</li>
 *   <li>{@link requirements.Requirement#getState <em>State</em>}</li>
 *   <li>{@link requirements.Requirement#getResolution <em>Resolution</em>}</li>
 *   <li>{@link requirements.Requirement#getVersion <em>Version</em>}</li>
 *   <li>{@link requirements.Requirement#getComment <em>Comment</em>}</li>
 *   <li>{@link requirements.Requirement#getDependencies <em>Dependencies</em>}</li>
 *   <li>{@link requirements.Requirement#getChildren <em>Children</em>}</li>
 *   <li>{@link requirements.Requirement#getParent <em>Parent</em>}</li>
 * </ul>
 *
 * @see requirements.RequirementsPackage#getRequirement()
 * @model
 * @generated
 */
public interface Requirement extends EObject {
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
	 * @see requirements.RequirementsPackage#getRequirement_Title()
	 * @model
	 * @generated
	 */
	String getTitle();

	/**
	 * Sets the value of the '{@link requirements.Requirement#getTitle <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Title</em>' attribute.
	 * @see #getTitle()
	 * @generated
	 */
	void setTitle(String value);

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
	 * @see requirements.RequirementsPackage#getRequirement_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link requirements.Requirement#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The default value is <code>"FUNCTIONAL"</code>.
	 * The literals are from the enumeration {@link requirements.Type}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see requirements.Type
	 * @see #setType(Type)
	 * @see requirements.RequirementsPackage#getRequirement_Type()
	 * @model default="FUNCTIONAL"
	 * @generated
	 */
	Type getType();

	/**
	 * Sets the value of the '{@link requirements.Requirement#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see requirements.Type
	 * @see #getType()
	 * @generated
	 */
	void setType(Type value);

	/**
	 * Returns the value of the '<em><b>Priority</b></em>' attribute.
	 * The default value is <code>"HIGH"</code>.
	 * The literals are from the enumeration {@link requirements.Priority}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Priority</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Priority</em>' attribute.
	 * @see requirements.Priority
	 * @see #setPriority(Priority)
	 * @see requirements.RequirementsPackage#getRequirement_Priority()
	 * @model default="HIGH"
	 * @generated
	 */
	Priority getPriority();

	/**
	 * Sets the value of the '{@link requirements.Requirement#getPriority <em>Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Priority</em>' attribute.
	 * @see requirements.Priority
	 * @see #getPriority()
	 * @generated
	 */
	void setPriority(Priority value);

	/**
	 * Returns the value of the '<em><b>Author</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Author</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Author</em>' attribute.
	 * @see #setAuthor(String)
	 * @see requirements.RequirementsPackage#getRequirement_Author()
	 * @model
	 * @generated
	 */
	String getAuthor();

	/**
	 * Sets the value of the '{@link requirements.Requirement#getAuthor <em>Author</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Author</em>' attribute.
	 * @see #getAuthor()
	 * @generated
	 */
	void setAuthor(String value);

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
	 * @see requirements.RequirementsPackage#getRequirement_Created()
	 * @model
	 * @generated
	 */
	Date getCreated();

	/**
	 * Sets the value of the '{@link requirements.Requirement#getCreated <em>Created</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Created</em>' attribute.
	 * @see #getCreated()
	 * @generated
	 */
	void setCreated(Date value);

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see requirements.RequirementsPackage#getRequirement_Id()
	 * @model
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link requirements.Requirement#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>State</b></em>' attribute.
	 * The default value is <code>"NEW"</code>.
	 * The literals are from the enumeration {@link requirements.State}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>State</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>State</em>' attribute.
	 * @see requirements.State
	 * @see #setState(State)
	 * @see requirements.RequirementsPackage#getRequirement_State()
	 * @model default="NEW"
	 * @generated
	 */
	State getState();

	/**
	 * Sets the value of the '{@link requirements.Requirement#getState <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>State</em>' attribute.
	 * @see requirements.State
	 * @see #getState()
	 * @generated
	 */
	void setState(State value);

	/**
	 * Returns the value of the '<em><b>Resolution</b></em>' attribute.
	 * The default value is <code>"INVALID"</code>.
	 * The literals are from the enumeration {@link requirements.Resolution}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resolution</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resolution</em>' attribute.
	 * @see requirements.Resolution
	 * @see #setResolution(Resolution)
	 * @see requirements.RequirementsPackage#getRequirement_Resolution()
	 * @model default="INVALID"
	 * @generated
	 */
	Resolution getResolution();

	/**
	 * Sets the value of the '{@link requirements.Requirement#getResolution <em>Resolution</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resolution</em>' attribute.
	 * @see requirements.Resolution
	 * @see #getResolution()
	 * @generated
	 */
	void setResolution(Resolution value);

	/**
	 * Returns the value of the '<em><b>Version</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Version</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Version</em>' containment reference.
	 * @see #setVersion(Version)
	 * @see requirements.RequirementsPackage#getRequirement_Version()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Version getVersion();

	/**
	 * Sets the value of the '{@link requirements.Requirement#getVersion <em>Version</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Version</em>' containment reference.
	 * @see #getVersion()
	 * @generated
	 */
	void setVersion(Version value);

	/**
	 * Returns the value of the '<em><b>Comment</b></em>' containment reference list.
	 * The list contents are of type {@link requirements.Comment}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Comment</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Comment</em>' containment reference list.
	 * @see requirements.RequirementsPackage#getRequirement_Comment()
	 * @model containment="true"
	 * @generated
	 */
	EList<Comment> getComment();

	/**
	 * Returns the value of the '<em><b>Dependencies</b></em>' reference list.
	 * The list contents are of type {@link requirements.Requirement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dependencies</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dependencies</em>' reference list.
	 * @see requirements.RequirementsPackage#getRequirement_Dependencies()
	 * @model
	 * @generated
	 */
	EList<Requirement> getDependencies();

	/**
	 * Returns the value of the '<em><b>Children</b></em>' containment reference list.
	 * The list contents are of type {@link requirements.Requirement}.
	 * It is bidirectional and its opposite is '{@link requirements.Requirement#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Children</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Children</em>' containment reference list.
	 * @see requirements.RequirementsPackage#getRequirement_Children()
	 * @see requirements.Requirement#getParent
	 * @model opposite="parent" containment="true"
	 * @generated
	 */
	EList<Requirement> getChildren();

	/**
	 * Returns the value of the '<em><b>Parent</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link requirements.Requirement#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' container reference.
	 * @see #setParent(Requirement)
	 * @see requirements.RequirementsPackage#getRequirement_Parent()
	 * @see requirements.Requirement#getChildren
	 * @model opposite="children" transient="false"
	 * @generated
	 */
	Requirement getParent();

	/**
	 * Sets the value of the '{@link requirements.Requirement#getParent <em>Parent</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' container reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(Requirement value);

} // Requirement
