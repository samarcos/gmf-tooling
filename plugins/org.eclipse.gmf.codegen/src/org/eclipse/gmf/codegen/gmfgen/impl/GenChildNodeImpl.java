/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmf.codegen.gmfgen.impl;

import java.util.Collection;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.gmf.codegen.gmfgen.CompartmentLayoutKind;
import org.eclipse.gmf.codegen.gmfgen.CompartmentPlacementKind;
import org.eclipse.gmf.codegen.gmfgen.GMFGenPackage;
import org.eclipse.gmf.codegen.gmfgen.GenChildContainer;
import org.eclipse.gmf.codegen.gmfgen.GenChildNode;
import org.eclipse.gmf.codegen.gmfgen.GenCompartment;
import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.gmf.codegen.gmfgen.GenNode;
import org.eclipse.gmf.codegen.gmfgen.TypeModelFacet;
import org.eclipse.gmf.codegen.gmfgen.Viewmap;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Gen Child Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.gmf.codegen.gmfgen.impl.GenChildNodeImpl#getContainer <em>Container</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GenChildNodeImpl extends GenNodeImpl implements GenChildNode {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GenChildNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return GMFGenPackage.eINSTANCE.getGenChildNode();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenChildContainer getContainer() {
		if (eContainerFeatureID != GMFGenPackage.GEN_CHILD_NODE__CONTAINER) return null;
		return (GenChildContainer)eContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isListContainerEntry() {
		if (getContainer() instanceof GenNode) {
			return ((GenNode) getContainer()).getChildContainersPlacement() == CompartmentPlacementKind.TOOLBAR_LITERAL;
		}
		if (getContainer() instanceof GenCompartment) {
			return ((GenCompartment) getContainer()).getLayoutKind() == CompartmentLayoutKind.TOOLBAR_LITERAL;
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
		if (featureID >= 0) {
			switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
				case GMFGenPackage.GEN_CHILD_NODE__CHILD_NODES:
					return ((InternalEList)getChildNodes()).basicAdd(otherEnd, msgs);
				case GMFGenPackage.GEN_CHILD_NODE__DIAGRAM:
					if (eContainer != null)
						msgs = eBasicRemoveFromContainer(msgs);
					return eBasicSetContainer(otherEnd, GMFGenPackage.GEN_CHILD_NODE__DIAGRAM, msgs);
				case GMFGenPackage.GEN_CHILD_NODE__LABELS:
					return ((InternalEList)getLabels()).basicAdd(otherEnd, msgs);
				case GMFGenPackage.GEN_CHILD_NODE__COMPARTMENTS:
					return ((InternalEList)getCompartments()).basicAdd(otherEnd, msgs);
				case GMFGenPackage.GEN_CHILD_NODE__CONTAINER:
					if (eContainer != null)
						msgs = eBasicRemoveFromContainer(msgs);
					return eBasicSetContainer(otherEnd, GMFGenPackage.GEN_CHILD_NODE__CONTAINER, msgs);
				default:
					return eDynamicInverseAdd(otherEnd, featureID, baseClass, msgs);
			}
		}
		if (eContainer != null)
			msgs = eBasicRemoveFromContainer(msgs);
		return eBasicSetContainer(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
		if (featureID >= 0) {
			switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
				case GMFGenPackage.GEN_CHILD_NODE__VIEWMAP:
					return basicSetViewmap(null, msgs);
				case GMFGenPackage.GEN_CHILD_NODE__CHILD_NODES:
					return ((InternalEList)getChildNodes()).basicRemove(otherEnd, msgs);
				case GMFGenPackage.GEN_CHILD_NODE__DIAGRAM:
					return eBasicSetContainer(null, GMFGenPackage.GEN_CHILD_NODE__DIAGRAM, msgs);
				case GMFGenPackage.GEN_CHILD_NODE__MODEL_FACET:
					return basicSetModelFacet(null, msgs);
				case GMFGenPackage.GEN_CHILD_NODE__LABELS:
					return ((InternalEList)getLabels()).basicRemove(otherEnd, msgs);
				case GMFGenPackage.GEN_CHILD_NODE__COMPARTMENTS:
					return ((InternalEList)getCompartments()).basicRemove(otherEnd, msgs);
				case GMFGenPackage.GEN_CHILD_NODE__CONTAINER:
					return eBasicSetContainer(null, GMFGenPackage.GEN_CHILD_NODE__CONTAINER, msgs);
				default:
					return eDynamicInverseRemove(otherEnd, featureID, baseClass, msgs);
			}
		}
		return eBasicSetContainer(null, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eBasicRemoveFromContainer(NotificationChain msgs) {
		if (eContainerFeatureID >= 0) {
			switch (eContainerFeatureID) {
				case GMFGenPackage.GEN_CHILD_NODE__DIAGRAM:
					return eContainer.eInverseRemove(this, GMFGenPackage.GEN_DIAGRAM__NODES, GenDiagram.class, msgs);
				case GMFGenPackage.GEN_CHILD_NODE__CONTAINER:
					return eContainer.eInverseRemove(this, GMFGenPackage.GEN_CHILD_CONTAINER__CHILD_NODES, GenChildContainer.class, msgs);
				default:
					return eDynamicBasicRemoveFromContainer(msgs);
			}
		}
		return eContainer.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - eContainerFeatureID, null, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(EStructuralFeature eFeature, boolean resolve) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case GMFGenPackage.GEN_CHILD_NODE__DIAGRAM_RUN_TIME_CLASS:
				if (resolve) return getDiagramRunTimeClass();
				return basicGetDiagramRunTimeClass();
			case GMFGenPackage.GEN_CHILD_NODE__VISUAL_ID:
				return new Integer(getVisualID());
			case GMFGenPackage.GEN_CHILD_NODE__EDIT_PART_CLASS_NAME:
				return getEditPartClassName();
			case GMFGenPackage.GEN_CHILD_NODE__ITEM_SEMANTIC_EDIT_POLICY_CLASS_NAME:
				return getItemSemanticEditPolicyClassName();
			case GMFGenPackage.GEN_CHILD_NODE__NOTATION_VIEW_FACTORY_CLASS_NAME:
				return getNotationViewFactoryClassName();
			case GMFGenPackage.GEN_CHILD_NODE__VIEWMAP:
				return getViewmap();
			case GMFGenPackage.GEN_CHILD_NODE__CHILD_NODES:
				return getChildNodes();
			case GMFGenPackage.GEN_CHILD_NODE__CANONICAL_EDIT_POLICY_CLASS_NAME:
				return getCanonicalEditPolicyClassName();
			case GMFGenPackage.GEN_CHILD_NODE__DIAGRAM:
				return getDiagram();
			case GMFGenPackage.GEN_CHILD_NODE__MODEL_FACET:
				return getModelFacet();
			case GMFGenPackage.GEN_CHILD_NODE__LABELS:
				return getLabels();
			case GMFGenPackage.GEN_CHILD_NODE__COMPARTMENTS:
				return getCompartments();
			case GMFGenPackage.GEN_CHILD_NODE__CHILD_CONTAINERS_PLACEMENT:
				return getChildContainersPlacement();
			case GMFGenPackage.GEN_CHILD_NODE__EXPLICIT_CONTENT_PANE:
				return isExplicitContentPane() ? Boolean.TRUE : Boolean.FALSE;
			case GMFGenPackage.GEN_CHILD_NODE__GRAPHICAL_NODE_EDIT_POLICY_CLASS_NAME:
				return getGraphicalNodeEditPolicyClassName();
			case GMFGenPackage.GEN_CHILD_NODE__CONTAINER:
				return getContainer();
		}
		return eDynamicGet(eFeature, resolve);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(EStructuralFeature eFeature, Object newValue) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case GMFGenPackage.GEN_CHILD_NODE__DIAGRAM_RUN_TIME_CLASS:
				setDiagramRunTimeClass((GenClass)newValue);
				return;
			case GMFGenPackage.GEN_CHILD_NODE__VISUAL_ID:
				setVisualID(((Integer)newValue).intValue());
				return;
			case GMFGenPackage.GEN_CHILD_NODE__EDIT_PART_CLASS_NAME:
				setEditPartClassName((String)newValue);
				return;
			case GMFGenPackage.GEN_CHILD_NODE__ITEM_SEMANTIC_EDIT_POLICY_CLASS_NAME:
				setItemSemanticEditPolicyClassName((String)newValue);
				return;
			case GMFGenPackage.GEN_CHILD_NODE__NOTATION_VIEW_FACTORY_CLASS_NAME:
				setNotationViewFactoryClassName((String)newValue);
				return;
			case GMFGenPackage.GEN_CHILD_NODE__VIEWMAP:
				setViewmap((Viewmap)newValue);
				return;
			case GMFGenPackage.GEN_CHILD_NODE__CHILD_NODES:
				getChildNodes().clear();
				getChildNodes().addAll((Collection)newValue);
				return;
			case GMFGenPackage.GEN_CHILD_NODE__CANONICAL_EDIT_POLICY_CLASS_NAME:
				setCanonicalEditPolicyClassName((String)newValue);
				return;
			case GMFGenPackage.GEN_CHILD_NODE__MODEL_FACET:
				setModelFacet((TypeModelFacet)newValue);
				return;
			case GMFGenPackage.GEN_CHILD_NODE__LABELS:
				getLabels().clear();
				getLabels().addAll((Collection)newValue);
				return;
			case GMFGenPackage.GEN_CHILD_NODE__COMPARTMENTS:
				getCompartments().clear();
				getCompartments().addAll((Collection)newValue);
				return;
			case GMFGenPackage.GEN_CHILD_NODE__CHILD_CONTAINERS_PLACEMENT:
				setChildContainersPlacement((CompartmentPlacementKind)newValue);
				return;
			case GMFGenPackage.GEN_CHILD_NODE__EXPLICIT_CONTENT_PANE:
				setExplicitContentPane(((Boolean)newValue).booleanValue());
				return;
			case GMFGenPackage.GEN_CHILD_NODE__GRAPHICAL_NODE_EDIT_POLICY_CLASS_NAME:
				setGraphicalNodeEditPolicyClassName((String)newValue);
				return;
		}
		eDynamicSet(eFeature, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(EStructuralFeature eFeature) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case GMFGenPackage.GEN_CHILD_NODE__DIAGRAM_RUN_TIME_CLASS:
				setDiagramRunTimeClass((GenClass)null);
				return;
			case GMFGenPackage.GEN_CHILD_NODE__VISUAL_ID:
				setVisualID(VISUAL_ID_EDEFAULT);
				return;
			case GMFGenPackage.GEN_CHILD_NODE__EDIT_PART_CLASS_NAME:
				setEditPartClassName(EDIT_PART_CLASS_NAME_EDEFAULT);
				return;
			case GMFGenPackage.GEN_CHILD_NODE__ITEM_SEMANTIC_EDIT_POLICY_CLASS_NAME:
				setItemSemanticEditPolicyClassName(ITEM_SEMANTIC_EDIT_POLICY_CLASS_NAME_EDEFAULT);
				return;
			case GMFGenPackage.GEN_CHILD_NODE__NOTATION_VIEW_FACTORY_CLASS_NAME:
				setNotationViewFactoryClassName(NOTATION_VIEW_FACTORY_CLASS_NAME_EDEFAULT);
				return;
			case GMFGenPackage.GEN_CHILD_NODE__VIEWMAP:
				setViewmap((Viewmap)null);
				return;
			case GMFGenPackage.GEN_CHILD_NODE__CHILD_NODES:
				getChildNodes().clear();
				return;
			case GMFGenPackage.GEN_CHILD_NODE__CANONICAL_EDIT_POLICY_CLASS_NAME:
				setCanonicalEditPolicyClassName(CANONICAL_EDIT_POLICY_CLASS_NAME_EDEFAULT);
				return;
			case GMFGenPackage.GEN_CHILD_NODE__MODEL_FACET:
				setModelFacet((TypeModelFacet)null);
				return;
			case GMFGenPackage.GEN_CHILD_NODE__LABELS:
				getLabels().clear();
				return;
			case GMFGenPackage.GEN_CHILD_NODE__COMPARTMENTS:
				getCompartments().clear();
				return;
			case GMFGenPackage.GEN_CHILD_NODE__CHILD_CONTAINERS_PLACEMENT:
				setChildContainersPlacement(CHILD_CONTAINERS_PLACEMENT_EDEFAULT);
				return;
			case GMFGenPackage.GEN_CHILD_NODE__EXPLICIT_CONTENT_PANE:
				setExplicitContentPane(EXPLICIT_CONTENT_PANE_EDEFAULT);
				return;
			case GMFGenPackage.GEN_CHILD_NODE__GRAPHICAL_NODE_EDIT_POLICY_CLASS_NAME:
				setGraphicalNodeEditPolicyClassName(GRAPHICAL_NODE_EDIT_POLICY_CLASS_NAME_EDEFAULT);
				return;
		}
		eDynamicUnset(eFeature);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(EStructuralFeature eFeature) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case GMFGenPackage.GEN_CHILD_NODE__DIAGRAM_RUN_TIME_CLASS:
				return diagramRunTimeClass != null;
			case GMFGenPackage.GEN_CHILD_NODE__VISUAL_ID:
				return visualID != VISUAL_ID_EDEFAULT;
			case GMFGenPackage.GEN_CHILD_NODE__EDIT_PART_CLASS_NAME:
				return EDIT_PART_CLASS_NAME_EDEFAULT == null ? editPartClassName != null : !EDIT_PART_CLASS_NAME_EDEFAULT.equals(editPartClassName);
			case GMFGenPackage.GEN_CHILD_NODE__ITEM_SEMANTIC_EDIT_POLICY_CLASS_NAME:
				return ITEM_SEMANTIC_EDIT_POLICY_CLASS_NAME_EDEFAULT == null ? itemSemanticEditPolicyClassName != null : !ITEM_SEMANTIC_EDIT_POLICY_CLASS_NAME_EDEFAULT.equals(itemSemanticEditPolicyClassName);
			case GMFGenPackage.GEN_CHILD_NODE__NOTATION_VIEW_FACTORY_CLASS_NAME:
				return NOTATION_VIEW_FACTORY_CLASS_NAME_EDEFAULT == null ? notationViewFactoryClassName != null : !NOTATION_VIEW_FACTORY_CLASS_NAME_EDEFAULT.equals(notationViewFactoryClassName);
			case GMFGenPackage.GEN_CHILD_NODE__VIEWMAP:
				return viewmap != null;
			case GMFGenPackage.GEN_CHILD_NODE__CHILD_NODES:
				return childNodes != null && !childNodes.isEmpty();
			case GMFGenPackage.GEN_CHILD_NODE__CANONICAL_EDIT_POLICY_CLASS_NAME:
				return CANONICAL_EDIT_POLICY_CLASS_NAME_EDEFAULT == null ? canonicalEditPolicyClassName != null : !CANONICAL_EDIT_POLICY_CLASS_NAME_EDEFAULT.equals(canonicalEditPolicyClassName);
			case GMFGenPackage.GEN_CHILD_NODE__DIAGRAM:
				return getDiagram() != null;
			case GMFGenPackage.GEN_CHILD_NODE__MODEL_FACET:
				return modelFacet != null;
			case GMFGenPackage.GEN_CHILD_NODE__LABELS:
				return labels != null && !labels.isEmpty();
			case GMFGenPackage.GEN_CHILD_NODE__COMPARTMENTS:
				return compartments != null && !compartments.isEmpty();
			case GMFGenPackage.GEN_CHILD_NODE__CHILD_CONTAINERS_PLACEMENT:
				return childContainersPlacement != CHILD_CONTAINERS_PLACEMENT_EDEFAULT;
			case GMFGenPackage.GEN_CHILD_NODE__EXPLICIT_CONTENT_PANE:
				return explicitContentPane != EXPLICIT_CONTENT_PANE_EDEFAULT;
			case GMFGenPackage.GEN_CHILD_NODE__GRAPHICAL_NODE_EDIT_POLICY_CLASS_NAME:
				return GRAPHICAL_NODE_EDIT_POLICY_CLASS_NAME_EDEFAULT == null ? graphicalNodeEditPolicyClassName != null : !GRAPHICAL_NODE_EDIT_POLICY_CLASS_NAME_EDEFAULT.equals(graphicalNodeEditPolicyClassName);
			case GMFGenPackage.GEN_CHILD_NODE__CONTAINER:
				return getContainer() != null;
		}
		return eDynamicIsSet(eFeature);
	}

	public GenDiagram getDiagram() {
		return getContainer().getDiagram();
	}

	public String getClassNameSuffux() {
		return "ChildNode";
	}
} //GenChildNodeImpl
