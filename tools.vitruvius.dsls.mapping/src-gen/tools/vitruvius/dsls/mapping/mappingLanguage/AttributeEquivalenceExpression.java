/**
 * generated by Xtext 2.9.2
 */
package tools.vitruvius.dsls.mapping.mappingLanguage;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute Equivalence Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link tools.vitruvius.dsls.mapping.mappingLanguage.AttributeEquivalenceExpression#getLeft <em>Left</em>}</li>
 *   <li>{@link tools.vitruvius.dsls.mapping.mappingLanguage.AttributeEquivalenceExpression#getRight <em>Right</em>}</li>
 * </ul>
 *
 * @see tools.vitruvius.dsls.mapping.mappingLanguage.MappingLanguagePackage#getAttributeEquivalenceExpression()
 * @model
 * @generated
 */
public interface AttributeEquivalenceExpression extends ConstraintExpression
{
  /**
   * Returns the value of the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Left</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Left</em>' containment reference.
   * @see #setLeft(FeatureOfContextVariable)
   * @see tools.vitruvius.dsls.mapping.mappingLanguage.MappingLanguagePackage#getAttributeEquivalenceExpression_Left()
   * @model containment="true"
   * @generated
   */
  FeatureOfContextVariable getLeft();

  /**
   * Sets the value of the '{@link tools.vitruvius.dsls.mapping.mappingLanguage.AttributeEquivalenceExpression#getLeft <em>Left</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Left</em>' containment reference.
   * @see #getLeft()
   * @generated
   */
  void setLeft(FeatureOfContextVariable value);

  /**
   * Returns the value of the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Right</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Right</em>' containment reference.
   * @see #setRight(FeatureOfContextVariable)
   * @see tools.vitruvius.dsls.mapping.mappingLanguage.MappingLanguagePackage#getAttributeEquivalenceExpression_Right()
   * @model containment="true"
   * @generated
   */
  FeatureOfContextVariable getRight();

  /**
   * Sets the value of the '{@link tools.vitruvius.dsls.mapping.mappingLanguage.AttributeEquivalenceExpression#getRight <em>Right</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Right</em>' containment reference.
   * @see #getRight()
   * @generated
   */
  void setRight(FeatureOfContextVariable value);

} // AttributeEquivalenceExpression
