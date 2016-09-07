/**
 * generated by Xtext 2.10.0
 */
package tools.vitruvius.dsls.response.responseLanguage.impl;

import tools.vitruvius.dsls.mirbase.mirBase.MetamodelReference;

import tools.vitruvius.dsls.response.responseLanguage.ExplicitRoutine;
import tools.vitruvius.dsls.response.responseLanguage.Response;
import tools.vitruvius.dsls.response.responseLanguage.ResponseLanguagePackage;
import tools.vitruvius.dsls.response.responseLanguage.ResponsesSegment;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Responses Segment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link tools.vitruvius.dsls.response.responseLanguage.impl.ResponsesSegmentImpl#getFromMetamodel <em>From Metamodel</em>}</li>
 *   <li>{@link tools.vitruvius.dsls.response.responseLanguage.impl.ResponsesSegmentImpl#getToMetamodel <em>To Metamodel</em>}</li>
 *   <li>{@link tools.vitruvius.dsls.response.responseLanguage.impl.ResponsesSegmentImpl#getName <em>Name</em>}</li>
 *   <li>{@link tools.vitruvius.dsls.response.responseLanguage.impl.ResponsesSegmentImpl#getResponses <em>Responses</em>}</li>
 *   <li>{@link tools.vitruvius.dsls.response.responseLanguage.impl.ResponsesSegmentImpl#getRoutines <em>Routines</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ResponsesSegmentImpl extends MinimalEObjectImpl.Container implements ResponsesSegment
{
  /**
   * The cached value of the '{@link #getFromMetamodel() <em>From Metamodel</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFromMetamodel()
   * @generated
   * @ordered
   */
  protected MetamodelReference fromMetamodel;

  /**
   * The cached value of the '{@link #getToMetamodel() <em>To Metamodel</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getToMetamodel()
   * @generated
   * @ordered
   */
  protected MetamodelReference toMetamodel;

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
   * The cached value of the '{@link #getResponses() <em>Responses</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getResponses()
   * @generated
   * @ordered
   */
  protected EList<Response> responses;

  /**
   * The cached value of the '{@link #getRoutines() <em>Routines</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRoutines()
   * @generated
   * @ordered
   */
  protected EList<ExplicitRoutine> routines;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ResponsesSegmentImpl()
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
    return ResponseLanguagePackage.Literals.RESPONSES_SEGMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MetamodelReference getFromMetamodel()
  {
    return fromMetamodel;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetFromMetamodel(MetamodelReference newFromMetamodel, NotificationChain msgs)
  {
    MetamodelReference oldFromMetamodel = fromMetamodel;
    fromMetamodel = newFromMetamodel;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ResponseLanguagePackage.RESPONSES_SEGMENT__FROM_METAMODEL, oldFromMetamodel, newFromMetamodel);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFromMetamodel(MetamodelReference newFromMetamodel)
  {
    if (newFromMetamodel != fromMetamodel)
    {
      NotificationChain msgs = null;
      if (fromMetamodel != null)
        msgs = ((InternalEObject)fromMetamodel).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ResponseLanguagePackage.RESPONSES_SEGMENT__FROM_METAMODEL, null, msgs);
      if (newFromMetamodel != null)
        msgs = ((InternalEObject)newFromMetamodel).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ResponseLanguagePackage.RESPONSES_SEGMENT__FROM_METAMODEL, null, msgs);
      msgs = basicSetFromMetamodel(newFromMetamodel, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ResponseLanguagePackage.RESPONSES_SEGMENT__FROM_METAMODEL, newFromMetamodel, newFromMetamodel));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MetamodelReference getToMetamodel()
  {
    return toMetamodel;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetToMetamodel(MetamodelReference newToMetamodel, NotificationChain msgs)
  {
    MetamodelReference oldToMetamodel = toMetamodel;
    toMetamodel = newToMetamodel;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ResponseLanguagePackage.RESPONSES_SEGMENT__TO_METAMODEL, oldToMetamodel, newToMetamodel);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setToMetamodel(MetamodelReference newToMetamodel)
  {
    if (newToMetamodel != toMetamodel)
    {
      NotificationChain msgs = null;
      if (toMetamodel != null)
        msgs = ((InternalEObject)toMetamodel).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ResponseLanguagePackage.RESPONSES_SEGMENT__TO_METAMODEL, null, msgs);
      if (newToMetamodel != null)
        msgs = ((InternalEObject)newToMetamodel).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ResponseLanguagePackage.RESPONSES_SEGMENT__TO_METAMODEL, null, msgs);
      msgs = basicSetToMetamodel(newToMetamodel, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ResponseLanguagePackage.RESPONSES_SEGMENT__TO_METAMODEL, newToMetamodel, newToMetamodel));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ResponseLanguagePackage.RESPONSES_SEGMENT__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Response> getResponses()
  {
    if (responses == null)
    {
      responses = new EObjectContainmentWithInverseEList<Response>(Response.class, this, ResponseLanguagePackage.RESPONSES_SEGMENT__RESPONSES, ResponseLanguagePackage.RESPONSE__RESPONSES_SEGMENT);
    }
    return responses;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ExplicitRoutine> getRoutines()
  {
    if (routines == null)
    {
      routines = new EObjectContainmentWithInverseEList<ExplicitRoutine>(ExplicitRoutine.class, this, ResponseLanguagePackage.RESPONSES_SEGMENT__ROUTINES, ResponseLanguagePackage.EXPLICIT_ROUTINE__RESPONSES_SEGMENT);
    }
    return routines;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case ResponseLanguagePackage.RESPONSES_SEGMENT__RESPONSES:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getResponses()).basicAdd(otherEnd, msgs);
      case ResponseLanguagePackage.RESPONSES_SEGMENT__ROUTINES:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getRoutines()).basicAdd(otherEnd, msgs);
    }
    return super.eInverseAdd(otherEnd, featureID, msgs);
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
      case ResponseLanguagePackage.RESPONSES_SEGMENT__FROM_METAMODEL:
        return basicSetFromMetamodel(null, msgs);
      case ResponseLanguagePackage.RESPONSES_SEGMENT__TO_METAMODEL:
        return basicSetToMetamodel(null, msgs);
      case ResponseLanguagePackage.RESPONSES_SEGMENT__RESPONSES:
        return ((InternalEList<?>)getResponses()).basicRemove(otherEnd, msgs);
      case ResponseLanguagePackage.RESPONSES_SEGMENT__ROUTINES:
        return ((InternalEList<?>)getRoutines()).basicRemove(otherEnd, msgs);
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
      case ResponseLanguagePackage.RESPONSES_SEGMENT__FROM_METAMODEL:
        return getFromMetamodel();
      case ResponseLanguagePackage.RESPONSES_SEGMENT__TO_METAMODEL:
        return getToMetamodel();
      case ResponseLanguagePackage.RESPONSES_SEGMENT__NAME:
        return getName();
      case ResponseLanguagePackage.RESPONSES_SEGMENT__RESPONSES:
        return getResponses();
      case ResponseLanguagePackage.RESPONSES_SEGMENT__ROUTINES:
        return getRoutines();
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
      case ResponseLanguagePackage.RESPONSES_SEGMENT__FROM_METAMODEL:
        setFromMetamodel((MetamodelReference)newValue);
        return;
      case ResponseLanguagePackage.RESPONSES_SEGMENT__TO_METAMODEL:
        setToMetamodel((MetamodelReference)newValue);
        return;
      case ResponseLanguagePackage.RESPONSES_SEGMENT__NAME:
        setName((String)newValue);
        return;
      case ResponseLanguagePackage.RESPONSES_SEGMENT__RESPONSES:
        getResponses().clear();
        getResponses().addAll((Collection<? extends Response>)newValue);
        return;
      case ResponseLanguagePackage.RESPONSES_SEGMENT__ROUTINES:
        getRoutines().clear();
        getRoutines().addAll((Collection<? extends ExplicitRoutine>)newValue);
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
      case ResponseLanguagePackage.RESPONSES_SEGMENT__FROM_METAMODEL:
        setFromMetamodel((MetamodelReference)null);
        return;
      case ResponseLanguagePackage.RESPONSES_SEGMENT__TO_METAMODEL:
        setToMetamodel((MetamodelReference)null);
        return;
      case ResponseLanguagePackage.RESPONSES_SEGMENT__NAME:
        setName(NAME_EDEFAULT);
        return;
      case ResponseLanguagePackage.RESPONSES_SEGMENT__RESPONSES:
        getResponses().clear();
        return;
      case ResponseLanguagePackage.RESPONSES_SEGMENT__ROUTINES:
        getRoutines().clear();
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
      case ResponseLanguagePackage.RESPONSES_SEGMENT__FROM_METAMODEL:
        return fromMetamodel != null;
      case ResponseLanguagePackage.RESPONSES_SEGMENT__TO_METAMODEL:
        return toMetamodel != null;
      case ResponseLanguagePackage.RESPONSES_SEGMENT__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case ResponseLanguagePackage.RESPONSES_SEGMENT__RESPONSES:
        return responses != null && !responses.isEmpty();
      case ResponseLanguagePackage.RESPONSES_SEGMENT__ROUTINES:
        return routines != null && !routines.isEmpty();
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //ResponsesSegmentImpl
