/**
 */
package edu.kit.ipd.sdq.vitruvius.casestudies.jml.language.jML;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Annotation Type Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.kit.ipd.sdq.vitruvius.casestudies.jml.language.jML.AnnotationTypeDeclaration#getIdentifier <em>Identifier</em>}</li>
 *   <li>{@link edu.kit.ipd.sdq.vitruvius.casestudies.jml.language.jML.AnnotationTypeDeclaration#getAnnotationtypeelementdeclaration <em>Annotationtypeelementdeclaration</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.kit.ipd.sdq.vitruvius.casestudies.jml.language.jML.JMLPackage#getAnnotationTypeDeclaration()
 * @model
 * @generated
 */
public interface AnnotationTypeDeclaration extends InterfaceDeclaration, AnnotationTypeElementRest
{
  /**
   * Returns the value of the '<em><b>Identifier</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Identifier</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Identifier</em>' attribute.
   * @see #setIdentifier(String)
   * @see edu.kit.ipd.sdq.vitruvius.casestudies.jml.language.jML.JMLPackage#getAnnotationTypeDeclaration_Identifier()
   * @model
   * @generated
   */
  String getIdentifier();

  /**
   * Sets the value of the '{@link edu.kit.ipd.sdq.vitruvius.casestudies.jml.language.jML.AnnotationTypeDeclaration#getIdentifier <em>Identifier</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Identifier</em>' attribute.
   * @see #getIdentifier()
   * @generated
   */
  void setIdentifier(String value);

  /**
   * Returns the value of the '<em><b>Annotationtypeelementdeclaration</b></em>' containment reference list.
   * The list contents are of type {@link edu.kit.ipd.sdq.vitruvius.casestudies.jml.language.jML.AnnotationTypeElementDeclaration}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Annotationtypeelementdeclaration</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Annotationtypeelementdeclaration</em>' containment reference list.
   * @see edu.kit.ipd.sdq.vitruvius.casestudies.jml.language.jML.JMLPackage#getAnnotationTypeDeclaration_Annotationtypeelementdeclaration()
   * @model containment="true"
   * @generated
   */
  EList<AnnotationTypeElementDeclaration> getAnnotationtypeelementdeclaration();

} // AnnotationTypeDeclaration
