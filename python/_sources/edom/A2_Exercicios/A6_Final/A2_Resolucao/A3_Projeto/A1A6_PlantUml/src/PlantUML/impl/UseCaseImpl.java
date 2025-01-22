/**
 */
package PlantUML.impl;

import PlantUML.PlantUMLPackage;
import PlantUML.UseCase;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Use Case</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link PlantUML.impl.UseCaseImpl#getName <em>Name</em>}</li>
 *   <li>{@link PlantUML.impl.UseCaseImpl#getLongName <em>Long Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class UseCaseImpl extends MinimalEObjectImpl.Container implements UseCase {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = "Default name";

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
	 * The default value of the '{@link #getLongName() <em>Long Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLongName()
	 * @generated
	 * @ordered
	 */
	protected static final String LONG_NAME_EDEFAULT = "Default long name";

	/**
	 * The cached value of the '{@link #getLongName() <em>Long Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLongName()
	 * @generated
	 * @ordered
	 */
	protected String longName = LONG_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UseCaseImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PlantUMLPackage.Literals.USE_CASE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, PlantUMLPackage.USE_CASE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLongName() {
		return longName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLongName(String newLongName) {
		String oldLongName = longName;
		longName = newLongName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PlantUMLPackage.USE_CASE__LONG_NAME, oldLongName, longName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PlantUMLPackage.USE_CASE__NAME:
				return getName();
			case PlantUMLPackage.USE_CASE__LONG_NAME:
				return getLongName();
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
			case PlantUMLPackage.USE_CASE__NAME:
				setName((String)newValue);
				return;
			case PlantUMLPackage.USE_CASE__LONG_NAME:
				setLongName((String)newValue);
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
			case PlantUMLPackage.USE_CASE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PlantUMLPackage.USE_CASE__LONG_NAME:
				setLongName(LONG_NAME_EDEFAULT);
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
			case PlantUMLPackage.USE_CASE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PlantUMLPackage.USE_CASE__LONG_NAME:
				return LONG_NAME_EDEFAULT == null ? longName != null : !LONG_NAME_EDEFAULT.equals(longName);
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
		result.append(", longName: ");
		result.append(longName);
		result.append(')');
		return result.toString();
	}

} //UseCaseImpl
