/**
 */
package entity.impl;

import entity.Entity;
import entity.EntityPackage;
import entity.Relation;
import entity.RelationType;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Relation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link entity.impl.RelationImpl#getName <em>Name</em>}</li>
 *   <li>{@link entity.impl.RelationImpl#getType <em>Type</em>}</li>
 *   <li>{@link entity.impl.RelationImpl#getRelEntity <em>Rel Entity</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RelationImpl extends MinimalEObjectImpl.Container implements Relation {
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
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final RelationType TYPE_EDEFAULT = RelationType.ONE;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected RelationType type = TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getRelEntity() <em>Rel Entity</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelEntity()
	 * @generated
	 * @ordered
	 */
	protected Entity relEntity;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RelationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EntityPackage.Literals.RELATION;
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
			eNotify(new ENotificationImpl(this, Notification.SET, EntityPackage.RELATION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelationType getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(RelationType newType) {
		RelationType oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EntityPackage.RELATION__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Entity getRelEntity() {
		if (relEntity != null && relEntity.eIsProxy()) {
			InternalEObject oldRelEntity = (InternalEObject)relEntity;
			relEntity = (Entity)eResolveProxy(oldRelEntity);
			if (relEntity != oldRelEntity) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EntityPackage.RELATION__REL_ENTITY, oldRelEntity, relEntity));
			}
		}
		return relEntity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Entity basicGetRelEntity() {
		return relEntity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRelEntity(Entity newRelEntity) {
		Entity oldRelEntity = relEntity;
		relEntity = newRelEntity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EntityPackage.RELATION__REL_ENTITY, oldRelEntity, relEntity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EntityPackage.RELATION__NAME:
				return getName();
			case EntityPackage.RELATION__TYPE:
				return getType();
			case EntityPackage.RELATION__REL_ENTITY:
				if (resolve) return getRelEntity();
				return basicGetRelEntity();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EntityPackage.RELATION__NAME:
				setName((String)newValue);
				return;
			case EntityPackage.RELATION__TYPE:
				setType((RelationType)newValue);
				return;
			case EntityPackage.RELATION__REL_ENTITY:
				setRelEntity((Entity)newValue);
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
			case EntityPackage.RELATION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case EntityPackage.RELATION__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case EntityPackage.RELATION__REL_ENTITY:
				setRelEntity((Entity)null);
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
			case EntityPackage.RELATION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case EntityPackage.RELATION__TYPE:
				return type != TYPE_EDEFAULT;
			case EntityPackage.RELATION__REL_ENTITY:
				return relEntity != null;
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
		result.append(" (Name: ");
		result.append(name);
		result.append(", Type: ");
		result.append(type);
		result.append(')');
		return result.toString();
	}

} //RelationImpl
