/**
 */
package edu.kit.ipd.sdq.vitruvius.framework.meta.correspondence.impl;

import edu.kit.ipd.sdq.vitruvius.framework.meta.correspondence.CorrespondencePackage;
import edu.kit.ipd.sdq.vitruvius.framework.meta.correspondence.SameTypeCorrespondence;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Same Type Correspondence</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.kit.ipd.sdq.vitruvius.framework.meta.correspondence.impl.SameTypeCorrespondenceImpl#getElementATUID <em>Element ATUID</em>}</li>
 *   <li>{@link edu.kit.ipd.sdq.vitruvius.framework.meta.correspondence.impl.SameTypeCorrespondenceImpl#getElementBTUID <em>Element BTUID</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class SameTypeCorrespondenceImpl extends CorrespondenceImpl implements SameTypeCorrespondence {
	/**
	 * The default value of the '{@link #getElementATUID() <em>Element ATUID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElementATUID()
	 * @generated
	 * @ordered
	 */
	protected static final String ELEMENT_ATUID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getElementATUID() <em>Element ATUID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElementATUID()
	 * @generated
	 * @ordered
	 */
	protected String elementATUID = ELEMENT_ATUID_EDEFAULT;

	/**
	 * The default value of the '{@link #getElementBTUID() <em>Element BTUID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElementBTUID()
	 * @generated
	 * @ordered
	 */
	protected static final String ELEMENT_BTUID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getElementBTUID() <em>Element BTUID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElementBTUID()
	 * @generated
	 * @ordered
	 */
	protected String elementBTUID = ELEMENT_BTUID_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SameTypeCorrespondenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CorrespondencePackage.Literals.SAME_TYPE_CORRESPONDENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getElementATUID() {
		return elementATUID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setElementATUID(String newElementATUID) {
		String oldElementATUID = elementATUID;
		elementATUID = newElementATUID;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorrespondencePackage.SAME_TYPE_CORRESPONDENCE__ELEMENT_ATUID, oldElementATUID, elementATUID));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getElementBTUID() {
		return elementBTUID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setElementBTUID(String newElementBTUID) {
		String oldElementBTUID = elementBTUID;
		elementBTUID = newElementBTUID;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorrespondencePackage.SAME_TYPE_CORRESPONDENCE__ELEMENT_BTUID, oldElementBTUID, elementBTUID));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CorrespondencePackage.SAME_TYPE_CORRESPONDENCE__ELEMENT_ATUID:
				return getElementATUID();
			case CorrespondencePackage.SAME_TYPE_CORRESPONDENCE__ELEMENT_BTUID:
				return getElementBTUID();
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
			case CorrespondencePackage.SAME_TYPE_CORRESPONDENCE__ELEMENT_ATUID:
				setElementATUID((String)newValue);
				return;
			case CorrespondencePackage.SAME_TYPE_CORRESPONDENCE__ELEMENT_BTUID:
				setElementBTUID((String)newValue);
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
			case CorrespondencePackage.SAME_TYPE_CORRESPONDENCE__ELEMENT_ATUID:
				setElementATUID(ELEMENT_ATUID_EDEFAULT);
				return;
			case CorrespondencePackage.SAME_TYPE_CORRESPONDENCE__ELEMENT_BTUID:
				setElementBTUID(ELEMENT_BTUID_EDEFAULT);
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
			case CorrespondencePackage.SAME_TYPE_CORRESPONDENCE__ELEMENT_ATUID:
				return ELEMENT_ATUID_EDEFAULT == null ? elementATUID != null : !ELEMENT_ATUID_EDEFAULT.equals(elementATUID);
			case CorrespondencePackage.SAME_TYPE_CORRESPONDENCE__ELEMENT_BTUID:
				return ELEMENT_BTUID_EDEFAULT == null ? elementBTUID != null : !ELEMENT_BTUID_EDEFAULT.equals(elementBTUID);
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
		result.append(" (elementATUID: ");
		result.append(elementATUID);
		result.append(", elementBTUID: ");
		result.append(elementBTUID);
		result.append(')');
		return result.toString();
	}

} //SameTypeCorrespondenceImpl
