/**
 */
package tools.vitruv.framework.change.echange.compound;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;

import tools.vitruv.framework.change.echange.AtomicEChange;

import tools.vitruv.framework.change.echange.feature.attribute.SubtractiveAttributeEChange;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Explicit Unset EAttribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * EChange which unsets a single or many valued attribute.
 * <!-- end-model-doc -->
 *
 *
 * @see tools.vitruv.framework.change.echange.compound.CompoundPackage#getExplicitUnsetEAttribute()
 * @model TBounds="org.eclipse.emf.ecore.EJavaObject"
 * @generated
 */
public interface ExplicitUnsetEAttribute<A extends EObject, T extends Object> extends CompoundSubtraction<T, SubtractiveAttributeEChange<A, T>>, ExplicitUnsetEFeature<A, EAttribute> {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='final &lt;%org.eclipse.emf.common.util.BasicEList%&gt;&lt;&lt;%tools.vitruv.framework.change.echange.AtomicEChange%&gt;&gt; result = new &lt;%org.eclipse.emf.common.util.BasicEList%&gt;&lt;&lt;%tools.vitruv.framework.change.echange.AtomicEChange%&gt;&gt;();\n&lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%tools.vitruv.framework.change.echange.feature.attribute.SubtractiveAttributeEChange%&gt;&lt;A, T&gt;&gt; _subtractiveChanges = this.getSubtractiveChanges();\nresult.addAll(_subtractiveChanges);\nreturn result;'"
	 * @generated
	 */
	EList<AtomicEChange> getAtomicChanges();

} // ExplicitUnsetEAttribute
