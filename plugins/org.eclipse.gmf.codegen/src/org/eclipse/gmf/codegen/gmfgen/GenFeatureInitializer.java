/**
 * <copyright>
 * </copyright>
 *
 * $Id: GenFeatureInitializer.java,v 1.3 2007/09/07 18:16:49 dstadnik Exp $
 */
package org.eclipse.gmf.codegen.gmfgen;

import java.util.List;

import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Gen Feature Initializer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmf.codegen.gmfgen.GenFeatureInitializer#getFeature <em>Feature</em>}</li>
 *   <li>{@link org.eclipse.gmf.codegen.gmfgen.GenFeatureInitializer#getFeatureSeqInitializer <em>Feature Seq Initializer</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmf.codegen.gmfgen.GMFGenPackage#getGenFeatureInitializer()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface GenFeatureInitializer extends EObject {
	/**
	 * Returns the value of the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The feature for which is to be initialized by this initializer
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Feature</em>' reference.
	 * @see #setFeature(GenFeature)
	 * @see org.eclipse.gmf.codegen.gmfgen.GMFGenPackage#getGenFeatureInitializer_Feature()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/gmf/2005/constraints ocl='feature <> null implies not featureSeqInitializer.initializers->exists(i| i <> self and i.feature = self.feature)' description='The feature is already initialized by another \'GenFeatureInitializer\' in the sequence'"
	 *        annotation="http://www.eclipse.org/gmf/2005/constraints ocl='feature <> null implies feature.ecoreFeature.eContainingClass.isSuperTypeOf(featureSeqInitializer.elementClass.ecoreClass)' description='The \'feature\' of \'GenFeatureInitializer\' must be available in \'Meta Class\' of the initialized element'"
	 * @generated
	 */
	GenFeature getFeature();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.codegen.gmfgen.GenFeatureInitializer#getFeature <em>Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Feature</em>' reference.
	 * @see #getFeature()
	 * @generated
	 */
	void setFeature(GenFeature value);

	/**
	 * Returns the value of the '<em><b>Feature Seq Initializer</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.gmf.codegen.gmfgen.GenFeatureSeqInitializer#getInitializers <em>Initializers</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature Seq Initializer</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature Seq Initializer</em>' container reference.
	 * @see org.eclipse.gmf.codegen.gmfgen.GMFGenPackage#getGenFeatureInitializer_FeatureSeqInitializer()
	 * @see org.eclipse.gmf.codegen.gmfgen.GenFeatureSeqInitializer#getInitializers
	 * @model opposite="initializers" required="true" transient="false" changeable="false"
	 * @generated
	 */
	GenFeatureSeqInitializer getFeatureSeqInitializer();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Gets the qualified name of the package interface which contains the given feature meta object
	 * <!-- end-model-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	String getFeatureQualifiedPackageInterfaceName();

	List<GenFeatureSeqInitializer> getAllFeatureSeqInitializers();	

} // GenFeatureInitializer
