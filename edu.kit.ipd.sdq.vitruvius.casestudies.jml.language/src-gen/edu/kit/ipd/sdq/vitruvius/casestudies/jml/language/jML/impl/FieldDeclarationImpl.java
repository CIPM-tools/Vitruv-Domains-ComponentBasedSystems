/**
 */
package edu.kit.ipd.sdq.vitruvius.casestudies.jml.language.jML.impl;

import edu.kit.ipd.sdq.vitruvius.casestudies.jml.language.jML.FieldDeclaration;
import edu.kit.ipd.sdq.vitruvius.casestudies.jml.language.jML.JMLPackage;
import edu.kit.ipd.sdq.vitruvius.casestudies.jml.language.jML.VariableDeclarator;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Field Declaration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.kit.ipd.sdq.vitruvius.casestudies.jml.language.jML.impl.FieldDeclarationImpl#getVariabledeclarator <em>Variabledeclarator</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FieldDeclarationImpl extends MinimalEObjectImpl.Container implements FieldDeclaration
{
  /**
   * The cached value of the '{@link #getVariabledeclarator() <em>Variabledeclarator</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVariabledeclarator()
   * @generated
   * @ordered
   */
  protected EList<VariableDeclarator> variabledeclarator;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected FieldDeclarationImpl()
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
    return JMLPackage.Literals.FIELD_DECLARATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<VariableDeclarator> getVariabledeclarator()
  {
    if (variabledeclarator == null)
    {
      variabledeclarator = new EObjectContainmentEList<VariableDeclarator>(VariableDeclarator.class, this, JMLPackage.FIELD_DECLARATION__VARIABLEDECLARATOR);
    }
    return variabledeclarator;
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
      case JMLPackage.FIELD_DECLARATION__VARIABLEDECLARATOR:
        return ((InternalEList<?>)getVariabledeclarator()).basicRemove(otherEnd, msgs);
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
      case JMLPackage.FIELD_DECLARATION__VARIABLEDECLARATOR:
        return getVariabledeclarator();
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
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case JMLPackage.FIELD_DECLARATION__VARIABLEDECLARATOR:
        getVariabledeclarator().clear();
        getVariabledeclarator().addAll((Collection<? extends VariableDeclarator>)newValue);
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
      case JMLPackage.FIELD_DECLARATION__VARIABLEDECLARATOR:
        getVariabledeclarator().clear();
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
      case JMLPackage.FIELD_DECLARATION__VARIABLEDECLARATOR:
        return variabledeclarator != null && !variabledeclarator.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //FieldDeclarationImpl
