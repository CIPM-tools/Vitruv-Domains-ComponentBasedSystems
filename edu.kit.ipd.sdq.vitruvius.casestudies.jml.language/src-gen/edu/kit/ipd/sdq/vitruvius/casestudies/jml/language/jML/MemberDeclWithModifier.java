/**
 */
package edu.kit.ipd.sdq.vitruvius.casestudies.jml.language.jML;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Member Decl With Modifier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.kit.ipd.sdq.vitruvius.casestudies.jml.language.jML.MemberDeclWithModifier#getJmlModifiers <em>Jml Modifiers</em>}</li>
 *   <li>{@link edu.kit.ipd.sdq.vitruvius.casestudies.jml.language.jML.MemberDeclWithModifier#getMemberdecl <em>Memberdecl</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.kit.ipd.sdq.vitruvius.casestudies.jml.language.jML.JMLPackage#getMemberDeclWithModifier()
 * @model
 * @generated
 */
public interface MemberDeclWithModifier extends Modifiable
{
  /**
   * Returns the value of the '<em><b>Jml Modifiers</b></em>' containment reference list.
   * The list contents are of type {@link edu.kit.ipd.sdq.vitruvius.casestudies.jml.language.jML.JMLMemberModifier}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Jml Modifiers</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Jml Modifiers</em>' containment reference list.
   * @see edu.kit.ipd.sdq.vitruvius.casestudies.jml.language.jML.JMLPackage#getMemberDeclWithModifier_JmlModifiers()
   * @model containment="true"
   * @generated
   */
  EList<JMLMemberModifier> getJmlModifiers();

  /**
   * Returns the value of the '<em><b>Memberdecl</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Memberdecl</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Memberdecl</em>' containment reference.
   * @see #setMemberdecl(MemberDecl)
   * @see edu.kit.ipd.sdq.vitruvius.casestudies.jml.language.jML.JMLPackage#getMemberDeclWithModifier_Memberdecl()
   * @model containment="true"
   * @generated
   */
  MemberDecl getMemberdecl();

  /**
   * Sets the value of the '{@link edu.kit.ipd.sdq.vitruvius.casestudies.jml.language.jML.MemberDeclWithModifier#getMemberdecl <em>Memberdecl</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Memberdecl</em>' containment reference.
   * @see #getMemberdecl()
   * @generated
   */
  void setMemberdecl(MemberDecl value);

} // MemberDeclWithModifier
