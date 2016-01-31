/**
 */
package edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.feature.impl;

import edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.feature.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class FeatureFactoryImpl extends EFactoryImpl implements FeatureFactory {
    /**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static FeatureFactory init() {
        try {
            FeatureFactory theFeatureFactory = (FeatureFactory)EPackage.Registry.INSTANCE.getEFactory(FeaturePackage.eNS_URI);
            if (theFeatureFactory != null) {
                return theFeatureFactory;
            }
        }
        catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new FeatureFactoryImpl();
    }

    /**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public FeatureFactoryImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EObject create(EClass eClass) {
        switch (eClass.getClassifierID()) {
            case FeaturePackage.UNSET_EATTRIBUTE: return createUnsetEAttribute();
            case FeaturePackage.UNSET_EREFERENCE: return createUnsetEReference();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public <T extends Object> UnsetEAttribute<T> createUnsetEAttribute() {
        UnsetEAttributeImpl<T> unsetEAttribute = new UnsetEAttributeImpl<T>();
        return unsetEAttribute;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public <T extends EObject> UnsetEReference<T> createUnsetEReference() {
        UnsetEReferenceImpl<T> unsetEReference = new UnsetEReferenceImpl<T>();
        return unsetEReference;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public FeaturePackage getFeaturePackage() {
        return (FeaturePackage)getEPackage();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
    @Deprecated
    public static FeaturePackage getPackage() {
        return FeaturePackage.eINSTANCE;
    }

} //FeatureFactoryImpl
