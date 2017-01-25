/**
 */
package tools.vitruv.domains.java.echange.feature.attribute.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import tools.vitruv.domains.java.echange.feature.FeaturePackage;

import tools.vitruv.domains.java.echange.feature.attribute.AttributeFactory;
import tools.vitruv.domains.java.echange.feature.attribute.AttributePackage;
import tools.vitruv.domains.java.echange.feature.attribute.JavaInsertEAttributeValue;
import tools.vitruv.domains.java.echange.feature.attribute.JavaRemoveEAttributeValue;
import tools.vitruv.domains.java.echange.feature.attribute.JavaReplaceSingleValuedEAttribute;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AttributePackageImpl extends EPackageImpl implements AttributePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass javaInsertEAttributeValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass javaRemoveEAttributeValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass javaReplaceSingleValuedEAttributeEClass = null;

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
	 * @see tools.vitruv.domains.java.echange.feature.attribute.AttributePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private AttributePackageImpl() {
		super(eNS_URI, AttributeFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link AttributePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static AttributePackage init() {
		if (isInited) return (AttributePackage)EPackage.Registry.INSTANCE.getEPackage(AttributePackage.eNS_URI);

		// Obtain or create and register package
		AttributePackageImpl theAttributePackage = (AttributePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof AttributePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new AttributePackageImpl());

		isInited = true;

		// Initialize simple dependencies
		tools.vitruv.framework.change.echange.feature.attribute.AttributePackage.eINSTANCE.eClass();
		FeaturePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theAttributePackage.createPackageContents();

		// Initialize created meta-data
		theAttributePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theAttributePackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(AttributePackage.eNS_URI, theAttributePackage);
		return theAttributePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJavaInsertEAttributeValue() {
		return javaInsertEAttributeValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJavaRemoveEAttributeValue() {
		return javaRemoveEAttributeValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJavaReplaceSingleValuedEAttribute() {
		return javaReplaceSingleValuedEAttributeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttributeFactory getAttributeFactory() {
		return (AttributeFactory)getEFactoryInstance();
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
		javaInsertEAttributeValueEClass = createEClass(JAVA_INSERT_EATTRIBUTE_VALUE);

		javaRemoveEAttributeValueEClass = createEClass(JAVA_REMOVE_EATTRIBUTE_VALUE);

		javaReplaceSingleValuedEAttributeEClass = createEClass(JAVA_REPLACE_SINGLE_VALUED_EATTRIBUTE);
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
		tools.vitruv.framework.change.echange.feature.attribute.AttributePackage theAttributePackage_1 = (tools.vitruv.framework.change.echange.feature.attribute.AttributePackage)EPackage.Registry.INSTANCE.getEPackage(tools.vitruv.framework.change.echange.feature.attribute.AttributePackage.eNS_URI);
		FeaturePackage theFeaturePackage = (FeaturePackage)EPackage.Registry.INSTANCE.getEPackage(FeaturePackage.eNS_URI);

		// Create type parameters
		ETypeParameter javaInsertEAttributeValueEClass_A = addETypeParameter(javaInsertEAttributeValueEClass, "A");
		ETypeParameter javaInsertEAttributeValueEClass_T = addETypeParameter(javaInsertEAttributeValueEClass, "T");
		ETypeParameter javaRemoveEAttributeValueEClass_A = addETypeParameter(javaRemoveEAttributeValueEClass, "A");
		ETypeParameter javaRemoveEAttributeValueEClass_T = addETypeParameter(javaRemoveEAttributeValueEClass, "T");
		ETypeParameter javaReplaceSingleValuedEAttributeEClass_A = addETypeParameter(javaReplaceSingleValuedEAttributeEClass, "A");
		ETypeParameter javaReplaceSingleValuedEAttributeEClass_T = addETypeParameter(javaReplaceSingleValuedEAttributeEClass, "T");

		// Set bounds for type parameters
		EGenericType g1 = createEGenericType(theEcorePackage.getEObject());
		javaInsertEAttributeValueEClass_A.getEBounds().add(g1);
		g1 = createEGenericType(theEcorePackage.getEJavaObject());
		javaInsertEAttributeValueEClass_T.getEBounds().add(g1);
		g1 = createEGenericType(theEcorePackage.getEObject());
		javaRemoveEAttributeValueEClass_A.getEBounds().add(g1);
		g1 = createEGenericType(theEcorePackage.getEJavaObject());
		javaRemoveEAttributeValueEClass_T.getEBounds().add(g1);
		g1 = createEGenericType(theEcorePackage.getEObject());
		javaReplaceSingleValuedEAttributeEClass_A.getEBounds().add(g1);
		g1 = createEGenericType(theEcorePackage.getEJavaObject());
		javaReplaceSingleValuedEAttributeEClass_T.getEBounds().add(g1);

		// Add supertypes to classes
		g1 = createEGenericType(theAttributePackage_1.getInsertEAttributeValue());
		EGenericType g2 = createEGenericType(javaInsertEAttributeValueEClass_A);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(javaInsertEAttributeValueEClass_T);
		g1.getETypeArguments().add(g2);
		javaInsertEAttributeValueEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theFeaturePackage.getJavaFeatureEChange());
		g2 = createEGenericType(javaInsertEAttributeValueEClass_A);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theEcorePackage.getEAttribute());
		g1.getETypeArguments().add(g2);
		javaInsertEAttributeValueEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theAttributePackage_1.getRemoveEAttributeValue());
		g2 = createEGenericType(javaRemoveEAttributeValueEClass_A);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(javaRemoveEAttributeValueEClass_T);
		g1.getETypeArguments().add(g2);
		javaRemoveEAttributeValueEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theFeaturePackage.getJavaFeatureEChange());
		g2 = createEGenericType(javaRemoveEAttributeValueEClass_A);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theEcorePackage.getEAttribute());
		g1.getETypeArguments().add(g2);
		javaRemoveEAttributeValueEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theAttributePackage_1.getReplaceSingleValuedEAttribute());
		g2 = createEGenericType(javaReplaceSingleValuedEAttributeEClass_A);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(javaReplaceSingleValuedEAttributeEClass_T);
		g1.getETypeArguments().add(g2);
		javaReplaceSingleValuedEAttributeEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theFeaturePackage.getJavaFeatureEChange());
		g2 = createEGenericType(javaReplaceSingleValuedEAttributeEClass_A);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theEcorePackage.getEAttribute());
		g1.getETypeArguments().add(g2);
		javaReplaceSingleValuedEAttributeEClass.getEGenericSuperTypes().add(g1);

		// Initialize classes, features, and operations; add parameters
		initEClass(javaInsertEAttributeValueEClass, JavaInsertEAttributeValue.class, "JavaInsertEAttributeValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(javaRemoveEAttributeValueEClass, JavaRemoveEAttributeValue.class, "JavaRemoveEAttributeValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(javaReplaceSingleValuedEAttributeEClass, JavaReplaceSingleValuedEAttribute.class, "JavaReplaceSingleValuedEAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //AttributePackageImpl
