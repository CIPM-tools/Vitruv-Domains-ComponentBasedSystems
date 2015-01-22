/**
 */
package edu.kit.ipd.sdq.vitruvius.casestudies.jml.language.jML;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Specified Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.kit.ipd.sdq.vitruvius.casestudies.jml.language.jML.JMLSpecifiedElement#getJmlTypeSpecifications <em>Jml Type Specifications</em>}</li>
 *   <li>{@link edu.kit.ipd.sdq.vitruvius.casestudies.jml.language.jML.JMLSpecifiedElement#getJmlSpecifications <em>Jml Specifications</em>}</li>
 *   <li>{@link edu.kit.ipd.sdq.vitruvius.casestudies.jml.language.jML.JMLSpecifiedElement#getElement <em>Element</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.kit.ipd.sdq.vitruvius.casestudies.jml.language.jML.JMLPackage#getJMLSpecifiedElement()
 * @model
 * @generated
 */
public interface JMLSpecifiedElement extends ClassBodyDeclaration
{
  /**
   * Returns the value of the '<em><b>Jml Type Specifications</b></em>' containment reference list.
   * The list contents are of type {@link edu.kit.ipd.sdq.vitruvius.casestudies.jml.language.jML.JMLTypeExpressionWithModifier}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Jml Type Specifications</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Jml Type Specifications</em>' containment reference list.
   * @see edu.kit.ipd.sdq.vitruvius.casestudies.jml.language.jML.JMLPackage#getJMLSpecifiedElement_JmlTypeSpecifications()
   * @model containment="true"
   * @generated
   */
  EList<JMLTypeExpressionWithModifier> getJmlTypeSpecifications();

  /**
   * Returns the value of the '<em><b>Jml Specifications</b></em>' containment reference list.
   * The list contents are of type {@link edu.kit.ipd.sdq.vitruvius.casestudies.jml.language.jML.JMLMethodSpecificationWithModifier}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Jml Specifications</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Jml Specifications</em>' containment reference list.
   * @see edu.kit.ipd.sdq.vitruvius.casestudies.jml.language.jML.JMLPackage#getJMLSpecifiedElement_JmlSpecifications()
   * @model containment="true"
   * @generated
   */
  EList<JMLMethodSpecificationWithModifier> getJmlSpecifications();

  /**
   * Returns the value of the '<em><b>Element</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Element</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Element</em>' containment reference.
   * @see #setElement(MemberDeclWithModifierRegular)
   * @see edu.kit.ipd.sdq.vitruvius.casestudies.jml.language.jML.JMLPackage#getJMLSpecifiedElement_Element()
   * @model containment="true"
   * @generated
   */
  MemberDeclWithModifierRegular getElement();

  /**
   * Sets the value of the '{@link edu.kit.ipd.sdq.vitruvius.casestudies.jml.language.jML.JMLSpecifiedElement#getElement <em>Element</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Element</em>' containment reference.
   * @see #getElement()
   * @generated
   */
  void setElement(MemberDeclWithModifierRegular value);

} // JMLSpecifiedElement
