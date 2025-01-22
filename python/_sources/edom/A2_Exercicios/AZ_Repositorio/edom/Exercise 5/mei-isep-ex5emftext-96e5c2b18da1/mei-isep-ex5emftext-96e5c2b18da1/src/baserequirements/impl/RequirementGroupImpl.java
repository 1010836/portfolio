/**
 */
package baserequirements.impl;

import baserequirements.BaserequirementsPackage;
import baserequirements.Requirement;
import baserequirements.RequirementGroup;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Requirement Group</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link baserequirements.impl.RequirementGroupImpl#getName <em>Name</em>}</li>
 *   <li>{@link baserequirements.impl.RequirementGroupImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link baserequirements.impl.RequirementGroupImpl#getId <em>Id</em>}</li>
 *   <li>{@link baserequirements.impl.RequirementGroupImpl#getChildren <em>Children</em>}</li>
 *   <li>{@link baserequirements.impl.RequirementGroupImpl#getParent <em>Parent</em>}</li>
 *   <li>{@link baserequirements.impl.RequirementGroupImpl#getRequirements <em>Requirements</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RequirementGroupImpl extends MinimalEObjectImpl.Container implements RequirementGroup {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

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
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * The cached value of the '{@link #getChildren() <em>Children</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChildren()
	 * @generated
	 * @ordered
	 */
	protected EList<RequirementGroup> children;

	/**
	 * The cached value of the '{@link #getRequirements() <em>Requirements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequirements()
	 * @generated
	 * @ordered
	 */
	protected EList<Requirement> requirements;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RequirementGroupImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BaserequirementsPackage.Literals.REQUIREMENT_GROUP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BaserequirementsPackage.REQUIREMENT_GROUP__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, BaserequirementsPackage.REQUIREMENT_GROUP__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BaserequirementsPackage.REQUIREMENT_GROUP__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<RequirementGroup> getChildren() {
		if (children == null) {
			children = new EObjectContainmentWithInverseEList<RequirementGroup>(RequirementGroup.class, this, BaserequirementsPackage.REQUIREMENT_GROUP__CHILDREN, BaserequirementsPackage.REQUIREMENT_GROUP__PARENT);
		}
		return children;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RequirementGroup getParent() {
		if (eContainerFeatureID() != BaserequirementsPackage.REQUIREMENT_GROUP__PARENT) return null;
		return (RequirementGroup)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParent(RequirementGroup newParent, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newParent, BaserequirementsPackage.REQUIREMENT_GROUP__PARENT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParent(RequirementGroup newParent) {
		if (newParent != eInternalContainer() || (eContainerFeatureID() != BaserequirementsPackage.REQUIREMENT_GROUP__PARENT && newParent != null)) {
			if (EcoreUtil.isAncestor(this, newParent))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParent != null)
				msgs = ((InternalEObject)newParent).eInverseAdd(this, BaserequirementsPackage.REQUIREMENT_GROUP__CHILDREN, RequirementGroup.class, msgs);
			msgs = basicSetParent(newParent, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BaserequirementsPackage.REQUIREMENT_GROUP__PARENT, newParent, newParent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Requirement> getRequirements() {
		if (requirements == null) {
			requirements = new EObjectContainmentEList<Requirement>(Requirement.class, this, BaserequirementsPackage.REQUIREMENT_GROUP__REQUIREMENTS);
		}
		return requirements;
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
			case BaserequirementsPackage.REQUIREMENT_GROUP__CHILDREN:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getChildren()).basicAdd(otherEnd, msgs);
			case BaserequirementsPackage.REQUIREMENT_GROUP__PARENT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetParent((RequirementGroup)otherEnd, msgs);
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
			case BaserequirementsPackage.REQUIREMENT_GROUP__CHILDREN:
				return ((InternalEList<?>)getChildren()).basicRemove(otherEnd, msgs);
			case BaserequirementsPackage.REQUIREMENT_GROUP__PARENT:
				return basicSetParent(null, msgs);
			case BaserequirementsPackage.REQUIREMENT_GROUP__REQUIREMENTS:
				return ((InternalEList<?>)getRequirements()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case BaserequirementsPackage.REQUIREMENT_GROUP__PARENT:
				return eInternalContainer().eInverseRemove(this, BaserequirementsPackage.REQUIREMENT_GROUP__CHILDREN, RequirementGroup.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BaserequirementsPackage.REQUIREMENT_GROUP__NAME:
				return getName();
			case BaserequirementsPackage.REQUIREMENT_GROUP__DESCRIPTION:
				return getDescription();
			case BaserequirementsPackage.REQUIREMENT_GROUP__ID:
				return getId();
			case BaserequirementsPackage.REQUIREMENT_GROUP__CHILDREN:
				return getChildren();
			case BaserequirementsPackage.REQUIREMENT_GROUP__PARENT:
				return getParent();
			case BaserequirementsPackage.REQUIREMENT_GROUP__REQUIREMENTS:
				return getRequirements();
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
			case BaserequirementsPackage.REQUIREMENT_GROUP__NAME:
				setName((String)newValue);
				return;
			case BaserequirementsPackage.REQUIREMENT_GROUP__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case BaserequirementsPackage.REQUIREMENT_GROUP__ID:
				setId((String)newValue);
				return;
			case BaserequirementsPackage.REQUIREMENT_GROUP__CHILDREN:
				getChildren().clear();
				getChildren().addAll((Collection<? extends RequirementGroup>)newValue);
				return;
			case BaserequirementsPackage.REQUIREMENT_GROUP__PARENT:
				setParent((RequirementGroup)newValue);
				return;
			case BaserequirementsPackage.REQUIREMENT_GROUP__REQUIREMENTS:
				getRequirements().clear();
				getRequirements().addAll((Collection<? extends Requirement>)newValue);
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
			case BaserequirementsPackage.REQUIREMENT_GROUP__NAME:
				setName(NAME_EDEFAULT);
				return;
			case BaserequirementsPackage.REQUIREMENT_GROUP__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case BaserequirementsPackage.REQUIREMENT_GROUP__ID:
				setId(ID_EDEFAULT);
				return;
			case BaserequirementsPackage.REQUIREMENT_GROUP__CHILDREN:
				getChildren().clear();
				return;
			case BaserequirementsPackage.REQUIREMENT_GROUP__PARENT:
				setParent((RequirementGroup)null);
				return;
			case BaserequirementsPackage.REQUIREMENT_GROUP__REQUIREMENTS:
				getRequirements().clear();
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
			case BaserequirementsPackage.REQUIREMENT_GROUP__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case BaserequirementsPackage.REQUIREMENT_GROUP__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case BaserequirementsPackage.REQUIREMENT_GROUP__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case BaserequirementsPackage.REQUIREMENT_GROUP__CHILDREN:
				return children != null && !children.isEmpty();
			case BaserequirementsPackage.REQUIREMENT_GROUP__PARENT:
				return getParent() != null;
			case BaserequirementsPackage.REQUIREMENT_GROUP__REQUIREMENTS:
				return requirements != null && !requirements.isEmpty();
		}
		return super.eIsSet(featureID);
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
		result.append(" (name: ");
		result.append(name);
		result.append(", description: ");
		result.append(description);
		result.append(", id: ");
		result.append(id);
		result.append(')');
		return result.toString();
	}

} //RequirementGroupImpl
