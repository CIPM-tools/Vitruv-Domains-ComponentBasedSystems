/**
 */
package edu.kit.ipd.sdq.vitruvius.casestudies.jml.language.jML;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enum Constants</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.kit.ipd.sdq.vitruvius.casestudies.jml.language.jML.EnumConstants#getEnumconstant <em>Enumconstant</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.kit.ipd.sdq.vitruvius.casestudies.jml.language.jML.JMLPackage#getEnumConstants()
 * @model
 * @generated
 */
public interface EnumConstants extends EObject
{
  /**
   * Returns the value of the '<em><b>Enumconstant</b></em>' containment reference list.
   * The list contents are of type {@link edu.kit.ipd.sdq.vitruvius.casestudies.jml.language.jML.EnumConstant}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Enumconstant</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Enumconstant</em>' containment reference list.
   * @see edu.kit.ipd.sdq.vitruvius.casestudies.jml.language.jML.JMLPackage#getEnumConstants_Enumconstant()
   * @model containment="true"
   * @generated
   */
  EList<EnumConstant> getEnumconstant();

} // EnumConstants
