/**
 */
package edu.kit.ipd.sdq.vitruvius.casestudies.jml.language.jML;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Specification Only Element With Modifier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.kit.ipd.sdq.vitruvius.casestudies.jml.language.jML.JMLSpecificationOnlyElementWithModifier#getModifier <em>Modifier</em>}</li>
 *   <li>{@link edu.kit.ipd.sdq.vitruvius.casestudies.jml.language.jML.JMLSpecificationOnlyElementWithModifier#getElement <em>Element</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.kit.ipd.sdq.vitruvius.casestudies.jml.language.jML.JMLPackage#getJMLSpecificationOnlyElementWithModifier()
 * @model
 * @generated
 */
public interface JMLSpecificationOnlyElementWithModifier extends EObject
{
  /**
   * Returns the value of the '<em><b>Modifier</b></em>' containment reference list.
   * The list contents are of type {@link edu.kit.ipd.sdq.vitruvius.casestudies.jml.language.jML.VisiblityModifier}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Modifier</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Modifier</em>' containment reference list.
   * @see edu.kit.ipd.sdq.vitruvius.casestudies.jml.language.jML.JMLPackage#getJMLSpecificationOnlyElementWithModifier_Modifier()
   * @model containment="true"
   * @generated
   */
  EList<VisiblityModifier> getModifier();

  /**
   * Returns the value of the '<em><b>Element</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Element</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Element</em>' containment reference.
   * @see #setElement(JMLSpecificationOnlyElement)
   * @see edu.kit.ipd.sdq.vitruvius.casestudies.jml.language.jML.JMLPackage#getJMLSpecificationOnlyElementWithModifier_Element()
   * @model containment="true"
   * @generated
   */
  JMLSpecificationOnlyElement getElement();

  /**
   * Sets the value of the '{@link edu.kit.ipd.sdq.vitruvius.casestudies.jml.language.jML.JMLSpecificationOnlyElementWithModifier#getElement <em>Element</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Element</em>' containment reference.
   * @see #getElement()
   * @generated
   */
  void setElement(JMLSpecificationOnlyElement value);

} // JMLSpecificationOnlyElementWithModifier
