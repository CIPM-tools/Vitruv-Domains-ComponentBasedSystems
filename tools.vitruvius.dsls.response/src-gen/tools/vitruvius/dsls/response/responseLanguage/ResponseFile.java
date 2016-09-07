/**
 * generated by Xtext 2.10.0
 */
package tools.vitruvius.dsls.response.responseLanguage;

import tools.vitruvius.dsls.mirbase.mirBase.MirBaseFile;

import org.eclipse.emf.common.util.EList;

import org.eclipse.xtext.xtype.XImportSection;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Response File</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link tools.vitruvius.dsls.response.responseLanguage.ResponseFile#getNamespaceImports <em>Namespace Imports</em>}</li>
 *   <li>{@link tools.vitruvius.dsls.response.responseLanguage.ResponseFile#getResponsesSegments <em>Responses Segments</em>}</li>
 * </ul>
 *
 * @see tools.vitruvius.dsls.response.responseLanguage.ResponseLanguagePackage#getResponseFile()
 * @model
 * @generated
 */
public interface ResponseFile extends MirBaseFile
{
  /**
   * Returns the value of the '<em><b>Namespace Imports</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Namespace Imports</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Namespace Imports</em>' containment reference.
   * @see #setNamespaceImports(XImportSection)
   * @see tools.vitruvius.dsls.response.responseLanguage.ResponseLanguagePackage#getResponseFile_NamespaceImports()
   * @model containment="true"
   * @generated
   */
  XImportSection getNamespaceImports();

  /**
   * Sets the value of the '{@link tools.vitruvius.dsls.response.responseLanguage.ResponseFile#getNamespaceImports <em>Namespace Imports</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Namespace Imports</em>' containment reference.
   * @see #getNamespaceImports()
   * @generated
   */
  void setNamespaceImports(XImportSection value);

  /**
   * Returns the value of the '<em><b>Responses Segments</b></em>' containment reference list.
   * The list contents are of type {@link tools.vitruvius.dsls.response.responseLanguage.ResponsesSegment}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Responses Segments</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Responses Segments</em>' containment reference list.
   * @see tools.vitruvius.dsls.response.responseLanguage.ResponseLanguagePackage#getResponseFile_ResponsesSegments()
   * @model containment="true"
   * @generated
   */
  EList<ResponsesSegment> getResponsesSegments();

} // ResponseFile
