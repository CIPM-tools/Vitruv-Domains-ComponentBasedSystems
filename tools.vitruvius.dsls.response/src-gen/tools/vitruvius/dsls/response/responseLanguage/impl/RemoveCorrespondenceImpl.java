/**
 * generated by Xtext 2.10.0
 */
package tools.vitruvius.dsls.response.responseLanguage.impl;

import tools.vitruvius.dsls.response.responseLanguage.ExistingElementReference;
import tools.vitruvius.dsls.response.responseLanguage.RemoveCorrespondence;
import tools.vitruvius.dsls.response.responseLanguage.ResponseLanguagePackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Remove Correspondence</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link tools.vitruvius.dsls.response.responseLanguage.impl.RemoveCorrespondenceImpl#getFirstElement <em>First Element</em>}</li>
 *   <li>{@link tools.vitruvius.dsls.response.responseLanguage.impl.RemoveCorrespondenceImpl#getSecondElement <em>Second Element</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RemoveCorrespondenceImpl extends MinimalEObjectImpl.Container implements RemoveCorrespondence
{
  /**
   * The cached value of the '{@link #getFirstElement() <em>First Element</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFirstElement()
   * @generated
   * @ordered
   */
  protected ExistingElementReference firstElement;

  /**
   * The cached value of the '{@link #getSecondElement() <em>Second Element</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSecondElement()
   * @generated
   * @ordered
   */
  protected ExistingElementReference secondElement;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected RemoveCorrespondenceImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return ResponseLanguagePackage.Literals.REMOVE_CORRESPONDENCE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExistingElementReference getFirstElement()
  {
    return firstElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetFirstElement(ExistingElementReference newFirstElement, NotificationChain msgs)
  {
    ExistingElementReference oldFirstElement = firstElement;
    firstElement = newFirstElement;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ResponseLanguagePackage.REMOVE_CORRESPONDENCE__FIRST_ELEMENT, oldFirstElement, newFirstElement);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFirstElement(ExistingElementReference newFirstElement)
  {
    if (newFirstElement != firstElement)
    {
      NotificationChain msgs = null;
      if (firstElement != null)
        msgs = ((InternalEObject)firstElement).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ResponseLanguagePackage.REMOVE_CORRESPONDENCE__FIRST_ELEMENT, null, msgs);
      if (newFirstElement != null)
        msgs = ((InternalEObject)newFirstElement).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ResponseLanguagePackage.REMOVE_CORRESPONDENCE__FIRST_ELEMENT, null, msgs);
      msgs = basicSetFirstElement(newFirstElement, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ResponseLanguagePackage.REMOVE_CORRESPONDENCE__FIRST_ELEMENT, newFirstElement, newFirstElement));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExistingElementReference getSecondElement()
  {
    return secondElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSecondElement(ExistingElementReference newSecondElement, NotificationChain msgs)
  {
    ExistingElementReference oldSecondElement = secondElement;
    secondElement = newSecondElement;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ResponseLanguagePackage.REMOVE_CORRESPONDENCE__SECOND_ELEMENT, oldSecondElement, newSecondElement);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSecondElement(ExistingElementReference newSecondElement)
  {
    if (newSecondElement != secondElement)
    {
      NotificationChain msgs = null;
      if (secondElement != null)
        msgs = ((InternalEObject)secondElement).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ResponseLanguagePackage.REMOVE_CORRESPONDENCE__SECOND_ELEMENT, null, msgs);
      if (newSecondElement != null)
        msgs = ((InternalEObject)newSecondElement).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ResponseLanguagePackage.REMOVE_CORRESPONDENCE__SECOND_ELEMENT, null, msgs);
      msgs = basicSetSecondElement(newSecondElement, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ResponseLanguagePackage.REMOVE_CORRESPONDENCE__SECOND_ELEMENT, newSecondElement, newSecondElement));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case ResponseLanguagePackage.REMOVE_CORRESPONDENCE__FIRST_ELEMENT:
        return basicSetFirstElement(null, msgs);
      case ResponseLanguagePackage.REMOVE_CORRESPONDENCE__SECOND_ELEMENT:
        return basicSetSecondElement(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case ResponseLanguagePackage.REMOVE_CORRESPONDENCE__FIRST_ELEMENT:
        return getFirstElement();
      case ResponseLanguagePackage.REMOVE_CORRESPONDENCE__SECOND_ELEMENT:
        return getSecondElement();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case ResponseLanguagePackage.REMOVE_CORRESPONDENCE__FIRST_ELEMENT:
        setFirstElement((ExistingElementReference)newValue);
        return;
      case ResponseLanguagePackage.REMOVE_CORRESPONDENCE__SECOND_ELEMENT:
        setSecondElement((ExistingElementReference)newValue);
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
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case ResponseLanguagePackage.REMOVE_CORRESPONDENCE__FIRST_ELEMENT:
        setFirstElement((ExistingElementReference)null);
        return;
      case ResponseLanguagePackage.REMOVE_CORRESPONDENCE__SECOND_ELEMENT:
        setSecondElement((ExistingElementReference)null);
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
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case ResponseLanguagePackage.REMOVE_CORRESPONDENCE__FIRST_ELEMENT:
        return firstElement != null;
      case ResponseLanguagePackage.REMOVE_CORRESPONDENCE__SECOND_ELEMENT:
        return secondElement != null;
    }
    return super.eIsSet(featureID);
  }

} //RemoveCorrespondenceImpl
