/**
 */
package tools.vitruv.domains.java.echange.feature.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import tools.vitruv.domains.java.echange.feature.FeatureFactory;
import tools.vitruv.domains.java.echange.feature.FeaturePackage;
import tools.vitruv.domains.java.echange.feature.JavaFeatureEChange;

import tools.vitruv.domains.java.echange.feature.attribute.impl.AttributePackageImpl;

import tools.vitruv.domains.java.echange.feature.reference.impl.ReferencePackageImpl;

import tools.vitruv.framework.change.echange.EChangePackage;

import tools.vitruv.framework.change.echange.eobject.EobjectPackage;

import tools.vitruv.framework.change.echange.feature.attribute.AttributePackage;

import tools.vitruv.framework.change.echange.feature.list.ListPackage;

import tools.vitruv.framework.change.echange.feature.reference.ReferencePackage;

import tools.vitruv.framework.change.echange.feature.single.SinglePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class FeaturePackageImpl extends EPackageImpl implements FeaturePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass javaFeatureEChangeEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see tools.vitruv.domains.java.echange.feature.FeaturePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private FeaturePackageImpl() {
		super(eNS_URI, FeatureFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link FeaturePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static FeaturePackage init() {
		if (isInited) return (FeaturePackage)EPackage.Registry.INSTANCE.getEPackage(FeaturePackage.eNS_URI);

		// Obtain or create and register package
		FeaturePackageImpl theFeaturePackage = (FeaturePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof FeaturePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new FeaturePackageImpl());

		isInited = true;

		// Initialize simple dependencies
		AttributePackage.eINSTANCE.eClass();
		tools.vitruv.framework.change.echange.feature.FeaturePackage.eINSTANCE.eClass();
		EChangePackage.eINSTANCE.eClass();
		ListPackage.eINSTANCE.eClass();
		SinglePackage.eINSTANCE.eClass();
		ReferencePackage.eINSTANCE.eClass();
		EobjectPackage.eINSTANCE.eClass();
		EcorePackage.eINSTANCE.eClass();
		tools.vitruv.framework.uuid.UuidPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		AttributePackageImpl theAttributePackage_1 = (AttributePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(tools.vitruv.domains.java.echange.feature.attribute.AttributePackage.eNS_URI) instanceof AttributePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(tools.vitruv.domains.java.echange.feature.attribute.AttributePackage.eNS_URI) : tools.vitruv.domains.java.echange.feature.attribute.AttributePackage.eINSTANCE);
		ReferencePackageImpl theReferencePackage_1 = (ReferencePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(tools.vitruv.domains.java.echange.feature.reference.ReferencePackage.eNS_URI) instanceof ReferencePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(tools.vitruv.domains.java.echange.feature.reference.ReferencePackage.eNS_URI) : tools.vitruv.domains.java.echange.feature.reference.ReferencePackage.eINSTANCE);

		// Create package meta-data objects
		theFeaturePackage.createPackageContents();
		theAttributePackage_1.createPackageContents();
		theReferencePackage_1.createPackageContents();

		// Initialize created meta-data
		theFeaturePackage.initializePackageContents();
		theAttributePackage_1.initializePackageContents();
		theReferencePackage_1.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theFeaturePackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(FeaturePackage.eNS_URI, theFeaturePackage);
		return theFeaturePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJavaFeatureEChange() {
		return javaFeatureEChangeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJavaFeatureEChange_OldAffectedEObject() {
		return (EReference)javaFeatureEChangeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureFactory getFeatureFactory() {
		return (FeatureFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		javaFeatureEChangeEClass = createEClass(JAVA_FEATURE_ECHANGE);
		createEReference(javaFeatureEChangeEClass, JAVA_FEATURE_ECHANGE__OLD_AFFECTED_EOBJECT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);
		tools.vitruv.framework.change.echange.feature.FeaturePackage theFeaturePackage_1 = (tools.vitruv.framework.change.echange.feature.FeaturePackage)EPackage.Registry.INSTANCE.getEPackage(tools.vitruv.framework.change.echange.feature.FeaturePackage.eNS_URI);

		// Create type parameters
		ETypeParameter javaFeatureEChangeEClass_A = addETypeParameter(javaFeatureEChangeEClass, "A");
		ETypeParameter javaFeatureEChangeEClass_F = addETypeParameter(javaFeatureEChangeEClass, "F");

		// Set bounds for type parameters
		EGenericType g1 = createEGenericType(theEcorePackage.getEObject());
		javaFeatureEChangeEClass_A.getEBounds().add(g1);
		g1 = createEGenericType(theEcorePackage.getEStructuralFeature());
		javaFeatureEChangeEClass_F.getEBounds().add(g1);

		// Add supertypes to classes
		g1 = createEGenericType(theFeaturePackage_1.getFeatureEChange());
		EGenericType g2 = createEGenericType(javaFeatureEChangeEClass_A);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(javaFeatureEChangeEClass_F);
		g1.getETypeArguments().add(g2);
		javaFeatureEChangeEClass.getEGenericSuperTypes().add(g1);

		// Initialize classes, features, and operations; add parameters
		initEClass(javaFeatureEChangeEClass, JavaFeatureEChange.class, "JavaFeatureEChange", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		g1 = createEGenericType(javaFeatureEChangeEClass_A);
		initEReference(getJavaFeatureEChange_OldAffectedEObject(), g1, null, "oldAffectedEObject", null, 1, 1, JavaFeatureEChange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //FeaturePackageImpl
