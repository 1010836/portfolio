/**
 */
package mindmapBase.impl;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;
import java.util.Date;

import mindmapBase.MindmapBasePackage;
import mindmapBase.Priority;
import mindmapBase.Topic;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.WrappedException;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Topic</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link mindmapBase.impl.TopicImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link mindmapBase.impl.TopicImpl#getStart <em>Start</em>}</li>
 *   <li>{@link mindmapBase.impl.TopicImpl#getEnd <em>End</em>}</li>
 *   <li>{@link mindmapBase.impl.TopicImpl#getPriority <em>Priority</em>}</li>
 *   <li>{@link mindmapBase.impl.TopicImpl#getParent <em>Parent</em>}</li>
 *   <li>{@link mindmapBase.impl.TopicImpl#getSubtopics <em>Subtopics</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TopicImpl extends MapElementImpl implements Topic {
	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getStart() <em>Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStart()
	 * @generated
	 * @ordered
	 */
	protected static final Date START_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStart() <em>Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStart()
	 * @generated
	 * @ordered
	 */
	protected Date start = START_EDEFAULT;

	/**
	 * The default value of the '{@link #getEnd() <em>End</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnd()
	 * @generated
	 * @ordered
	 */
	protected static final Date END_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEnd() <em>End</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnd()
	 * @generated
	 * @ordered
	 */
	protected Date end = END_EDEFAULT;

	/**
	 * The default value of the '{@link #getPriority() <em>Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPriority()
	 * @generated
	 * @ordered
	 */
	protected static final Priority PRIORITY_EDEFAULT = Priority.LOW;

	/**
	 * The cached value of the '{@link #getPriority() <em>Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPriority()
	 * @generated
	 * @ordered
	 */
	protected Priority priority = PRIORITY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getParent() <em>Parent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParent()
	 * @generated
	 * @ordered
	 */
	protected Topic parent;

	/**
	 * The cached value of the '{@link #getSubtopics() <em>Subtopics</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubtopics()
	 * @generated
	 * @ordered
	 */
	protected EList<Topic> subtopics;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TopicImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MindmapBasePackage.Literals.TOPIC;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MindmapBasePackage.TOPIC__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getStart() {
		return start;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStart(Date newStart) {
		Date oldStart = start;
		start = newStart;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MindmapBasePackage.TOPIC__START, oldStart, start));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getEnd() {
		return end;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnd(Date newEnd) {
		Date oldEnd = end;
		end = newEnd;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MindmapBasePackage.TOPIC__END, oldEnd, end));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Priority getPriority() {
		return priority;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPriority(Priority newPriority) {
		Priority oldPriority = priority;
		priority = newPriority == null ? PRIORITY_EDEFAULT : newPriority;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MindmapBasePackage.TOPIC__PRIORITY, oldPriority, priority));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Topic getParent() {
		if (parent != null && parent.eIsProxy()) {
			InternalEObject oldParent = (InternalEObject)parent;
			parent = (Topic)eResolveProxy(oldParent);
			if (parent != oldParent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MindmapBasePackage.TOPIC__PARENT, oldParent, parent));
			}
		}
		return parent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Topic basicGetParent() {
		return parent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParent(Topic newParent, NotificationChain msgs) {
		Topic oldParent = parent;
		parent = newParent;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MindmapBasePackage.TOPIC__PARENT, oldParent, newParent);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParent(Topic newParent) {
		if (newParent != parent) {
			NotificationChain msgs = null;
			if (parent != null)
				msgs = ((InternalEObject)parent).eInverseRemove(this, MindmapBasePackage.TOPIC__SUBTOPICS, Topic.class, msgs);
			if (newParent != null)
				msgs = ((InternalEObject)newParent).eInverseAdd(this, MindmapBasePackage.TOPIC__SUBTOPICS, Topic.class, msgs);
			msgs = basicSetParent(newParent, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MindmapBasePackage.TOPIC__PARENT, newParent, newParent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Topic> getSubtopics() {
		if (subtopics == null) {
			subtopics = new EObjectWithInverseResolvingEList<Topic>(Topic.class, this, MindmapBasePackage.TOPIC__SUBTOPICS, MindmapBasePackage.TOPIC__PARENT);
		}
		return subtopics;
	}

	/**
	 * The cached invocation delegate for the '{@link #allSubTopics() <em>All Sub Topics</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #allSubTopics()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate ALL_SUB_TOPICS__EINVOCATION_DELEGATE = ((EOperation.Internal)MindmapBasePackage.Literals.TOPIC___ALL_SUB_TOPICS).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Topic> allSubTopics() {
		try {
			return (EList<Topic>)ALL_SUB_TOPICS__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MindmapBasePackage.TOPIC__PARENT:
				if (parent != null)
					msgs = ((InternalEObject)parent).eInverseRemove(this, MindmapBasePackage.TOPIC__SUBTOPICS, Topic.class, msgs);
				return basicSetParent((Topic)otherEnd, msgs);
			case MindmapBasePackage.TOPIC__SUBTOPICS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSubtopics()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MindmapBasePackage.TOPIC__PARENT:
				return basicSetParent(null, msgs);
			case MindmapBasePackage.TOPIC__SUBTOPICS:
				return ((InternalEList<?>)getSubtopics()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MindmapBasePackage.TOPIC__DESCRIPTION:
				return getDescription();
			case MindmapBasePackage.TOPIC__START:
				return getStart();
			case MindmapBasePackage.TOPIC__END:
				return getEnd();
			case MindmapBasePackage.TOPIC__PRIORITY:
				return getPriority();
			case MindmapBasePackage.TOPIC__PARENT:
				if (resolve) return getParent();
				return basicGetParent();
			case MindmapBasePackage.TOPIC__SUBTOPICS:
				return getSubtopics();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MindmapBasePackage.TOPIC__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case MindmapBasePackage.TOPIC__START:
				setStart((Date)newValue);
				return;
			case MindmapBasePackage.TOPIC__END:
				setEnd((Date)newValue);
				return;
			case MindmapBasePackage.TOPIC__PRIORITY:
				setPriority((Priority)newValue);
				return;
			case MindmapBasePackage.TOPIC__PARENT:
				setParent((Topic)newValue);
				return;
			case MindmapBasePackage.TOPIC__SUBTOPICS:
				getSubtopics().clear();
				getSubtopics().addAll((Collection<? extends Topic>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case MindmapBasePackage.TOPIC__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case MindmapBasePackage.TOPIC__START:
				setStart(START_EDEFAULT);
				return;
			case MindmapBasePackage.TOPIC__END:
				setEnd(END_EDEFAULT);
				return;
			case MindmapBasePackage.TOPIC__PRIORITY:
				setPriority(PRIORITY_EDEFAULT);
				return;
			case MindmapBasePackage.TOPIC__PARENT:
				setParent((Topic)null);
				return;
			case MindmapBasePackage.TOPIC__SUBTOPICS:
				getSubtopics().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case MindmapBasePackage.TOPIC__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case MindmapBasePackage.TOPIC__START:
				return START_EDEFAULT == null ? start != null : !START_EDEFAULT.equals(start);
			case MindmapBasePackage.TOPIC__END:
				return END_EDEFAULT == null ? end != null : !END_EDEFAULT.equals(end);
			case MindmapBasePackage.TOPIC__PRIORITY:
				return priority != PRIORITY_EDEFAULT;
			case MindmapBasePackage.TOPIC__PARENT:
				return parent != null;
			case MindmapBasePackage.TOPIC__SUBTOPICS:
				return subtopics != null && !subtopics.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case MindmapBasePackage.TOPIC___ALL_SUB_TOPICS:
				return allSubTopics();
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (description: ");
		result.append(description);
		result.append(", start: ");
		result.append(start);
		result.append(", end: ");
		result.append(end);
		result.append(", priority: ");
		result.append(priority);
		result.append(')');
		return result.toString();
	}

} //TopicImpl
