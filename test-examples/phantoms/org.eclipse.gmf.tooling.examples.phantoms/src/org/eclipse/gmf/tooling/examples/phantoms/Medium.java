/**
 */
package org.eclipse.gmf.tooling.examples.phantoms;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Medium</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmf.tooling.examples.phantoms.Medium#getChildren <em>Children</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmf.tooling.examples.phantoms.PhantomsPackage#getMedium()
 * @model
 * @generated
 */
public interface Medium extends RootChild {
	/**
	 * Returns the value of the '<em><b>Children</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.gmf.tooling.examples.phantoms.MediumParent}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Children</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Children</em>' containment reference list.
	 * @see org.eclipse.gmf.tooling.examples.phantoms.PhantomsPackage#getMedium_Children()
	 * @model containment="true"
	 * @generated
	 */
	EList<MediumParent> getChildren();

} // Medium
