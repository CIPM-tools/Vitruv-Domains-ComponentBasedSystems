/**
 */
package edu.kit.ipd.sdq.vitruvius.casestudies.jml.language.jML;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Basic For Loop Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.kit.ipd.sdq.vitruvius.casestudies.jml.language.jML.BasicForLoopExpression#getInitExpressions <em>Init Expressions</em>}</li>
 *   <li>{@link edu.kit.ipd.sdq.vitruvius.casestudies.jml.language.jML.BasicForLoopExpression#getExpression <em>Expression</em>}</li>
 *   <li>{@link edu.kit.ipd.sdq.vitruvius.casestudies.jml.language.jML.BasicForLoopExpression#getUpdateExpressions <em>Update Expressions</em>}</li>
 *   <li>{@link edu.kit.ipd.sdq.vitruvius.casestudies.jml.language.jML.BasicForLoopExpression#getEachExpression <em>Each Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.kit.ipd.sdq.vitruvius.casestudies.jml.language.jML.JMLPackage#getBasicForLoopExpression()
 * @model
 * @generated
 */
public interface BasicForLoopExpression extends Expression
{
  /**
   * Returns the value of the '<em><b>Init Expressions</b></em>' containment reference list.
   * The list contents are of type {@link edu.kit.ipd.sdq.vitruvius.casestudies.jml.language.jML.Expression}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Init Expressions</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Init Expressions</em>' containment reference list.
   * @see edu.kit.ipd.sdq.vitruvius.casestudies.jml.language.jML.JMLPackage#getBasicForLoopExpression_InitExpressions()
   * @model containment="true"
   * @generated
   */
  EList<Expression> getInitExpressions();

  /**
   * Returns the value of the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Expression</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Expression</em>' containment reference.
   * @see #setExpression(Expression)
   * @see edu.kit.ipd.sdq.vitruvius.casestudies.jml.language.jML.JMLPackage#getBasicForLoopExpression_Expression()
   * @model containment="true"
   * @generated
   */
  Expression getExpression();

  /**
   * Sets the value of the '{@link edu.kit.ipd.sdq.vitruvius.casestudies.jml.language.jML.BasicForLoopExpression#getExpression <em>Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expression</em>' containment reference.
   * @see #getExpression()
   * @generated
   */
  void setExpression(Expression value);

  /**
   * Returns the value of the '<em><b>Update Expressions</b></em>' containment reference list.
   * The list contents are of type {@link edu.kit.ipd.sdq.vitruvius.casestudies.jml.language.jML.Expression}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Update Expressions</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Update Expressions</em>' containment reference list.
   * @see edu.kit.ipd.sdq.vitruvius.casestudies.jml.language.jML.JMLPackage#getBasicForLoopExpression_UpdateExpressions()
   * @model containment="true"
   * @generated
   */
  EList<Expression> getUpdateExpressions();

  /**
   * Returns the value of the '<em><b>Each Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Each Expression</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Each Expression</em>' containment reference.
   * @see #setEachExpression(Expression)
   * @see edu.kit.ipd.sdq.vitruvius.casestudies.jml.language.jML.JMLPackage#getBasicForLoopExpression_EachExpression()
   * @model containment="true"
   * @generated
   */
  Expression getEachExpression();

  /**
   * Sets the value of the '{@link edu.kit.ipd.sdq.vitruvius.casestudies.jml.language.jML.BasicForLoopExpression#getEachExpression <em>Each Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Each Expression</em>' containment reference.
   * @see #getEachExpression()
   * @generated
   */
  void setEachExpression(Expression value);

} // BasicForLoopExpression
