/**
 * Copyright (c) 2010-2012 ISBAN S.L
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 * 		Ruben De Dios (ISBAN S.L)
 * 		Andrez Alvarez Mattos (ISBAN S.L)
 */
package org.eclipse.gmf.tooling.simplemap.simplemappings.impl;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.gmf.gmfgraph.DiagramLabel;
import org.eclipse.gmf.gmfgraph.Figure;
import org.eclipse.gmf.gmfgraph.Node;
import org.eclipse.gmf.mappings.NodeReference;
import org.eclipse.gmf.tooldef.AbstractTool;
import org.eclipse.gmf.tooling.simplemap.simplemappings.SimpleMapping;
import org.eclipse.gmf.tooling.simplemap.simplemappings.SimpleMappingElementWithFigure;
import org.eclipse.gmf.tooling.simplemap.simplemappings.SimpleNode;
import org.eclipse.gmf.tooling.simplemap.simplemappings.SimpleNodeReference;
import org.eclipse.gmf.tooling.simplemap.simplemappings.SimpleParentNode;
import org.eclipse.gmf.tooling.simplemap.simplemappings.SimplemappingsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Simple Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.gmf.tooling.simplemap.simplemappings.impl.SimpleNodeImpl#getParentNode <em>Parent Node</em>}</li>
 *   <li>{@link org.eclipse.gmf.tooling.simplemap.simplemappings.impl.SimpleNodeImpl#getParentMapping <em>Parent Mapping</em>}</li>
 *   <li>{@link org.eclipse.gmf.tooling.simplemap.simplemappings.impl.SimpleNodeImpl#getParent <em>Parent</em>}</li>
 *   <li>{@link org.eclipse.gmf.tooling.simplemap.simplemappings.impl.SimpleNodeImpl#getParentMetaElement <em>Parent Meta Element</em>}</li>
 *   <li>{@link org.eclipse.gmf.tooling.simplemap.simplemappings.impl.SimpleNodeImpl#getNodeFigure <em>Node Figure</em>}</li>
 *   <li>{@link org.eclipse.gmf.tooling.simplemap.simplemappings.impl.SimpleNodeImpl#getLabelFigure <em>Label Figure</em>}</li>
 *   <li>{@link org.eclipse.gmf.tooling.simplemap.simplemappings.impl.SimpleNodeImpl#getNodeReference <em>Node Reference</em>}</li>
 *   <li>{@link org.eclipse.gmf.tooling.simplemap.simplemappings.impl.SimpleNodeImpl#getContainmentFeature <em>Containment Feature</em>}</li>
 *   <li>{@link org.eclipse.gmf.tooling.simplemap.simplemappings.impl.SimpleNodeImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.gmf.tooling.simplemap.simplemappings.impl.SimpleNodeImpl#getTool <em>Tool</em>}</li>
 *   <li>{@link org.eclipse.gmf.tooling.simplemap.simplemappings.impl.SimpleNodeImpl#getLabelAttributes <em>Label Attributes</em>}</li>
 *   <li>{@link org.eclipse.gmf.tooling.simplemap.simplemappings.impl.SimpleNodeImpl#getDiagramNode <em>Diagram Node</em>}</li>
 *   <li>{@link org.eclipse.gmf.tooling.simplemap.simplemappings.impl.SimpleNodeImpl#getDiagramLabel <em>Diagram Label</em>}</li>
 *   <li>{@link org.eclipse.gmf.tooling.simplemap.simplemappings.impl.SimpleNodeImpl#getDomainMetaElement <em>Domain Meta Element</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SimpleNodeImpl extends EObjectImpl implements SimpleNode {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SimpleNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SimplemappingsPackage.Literals.SIMPLE_NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount() {
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimpleParentNode getParentNode() {
		return (SimpleParentNode) eGet(SimplemappingsPackage.Literals.SIMPLE_CHILD_NODE__PARENT_NODE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentNode(SimpleParentNode newParentNode) {
		eSet(SimplemappingsPackage.Literals.SIMPLE_CHILD_NODE__PARENT_NODE, newParentNode);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimpleMapping getParentMapping() {
		return (SimpleMapping) eGet(SimplemappingsPackage.Literals.SIMPLE_CHILD_NODE__PARENT_MAPPING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentMapping(SimpleMapping newParentMapping) {
		eSet(SimplemappingsPackage.Literals.SIMPLE_CHILD_NODE__PARENT_MAPPING, newParentMapping);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimpleNode getParent() {
		return (SimpleNode) eGet(SimplemappingsPackage.Literals.SIMPLE_CHILD_NODE__PARENT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParent(SimpleNode newParent) {
		eSet(SimplemappingsPackage.Literals.SIMPLE_CHILD_NODE__PARENT, newParent);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDomainMetaElement() {
		return (EClass) eGet(SimplemappingsPackage.Literals.SIMPLE_NODE__DOMAIN_META_ELEMENT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDomainMetaElement(EClass newDomainMetaElement) {
		eSet(SimplemappingsPackage.Literals.SIMPLE_NODE__DOMAIN_META_ELEMENT, newDomainMetaElement);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == SimpleMappingElementWithFigure.class) {
			switch (derivedFeatureID) {
			case SimplemappingsPackage.SIMPLE_NODE__NODE_FIGURE:
				return SimplemappingsPackage.SIMPLE_MAPPING_ELEMENT_WITH_FIGURE__NODE_FIGURE;
			case SimplemappingsPackage.SIMPLE_NODE__LABEL_FIGURE:
				return SimplemappingsPackage.SIMPLE_MAPPING_ELEMENT_WITH_FIGURE__LABEL_FIGURE;
			default:
				return -1;
			}
		}
		if (baseClass == SimpleNodeReference.class) {
			switch (derivedFeatureID) {
			case SimplemappingsPackage.SIMPLE_NODE__NODE_REFERENCE:
				return SimplemappingsPackage.SIMPLE_NODE_REFERENCE__NODE_REFERENCE;
			case SimplemappingsPackage.SIMPLE_NODE__CONTAINMENT_FEATURE:
				return SimplemappingsPackage.SIMPLE_NODE_REFERENCE__CONTAINMENT_FEATURE;
			case SimplemappingsPackage.SIMPLE_NODE__NAME:
				return SimplemappingsPackage.SIMPLE_NODE_REFERENCE__NAME;
			default:
				return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == SimpleMappingElementWithFigure.class) {
			switch (baseFeatureID) {
			case SimplemappingsPackage.SIMPLE_MAPPING_ELEMENT_WITH_FIGURE__NODE_FIGURE:
				return SimplemappingsPackage.SIMPLE_NODE__NODE_FIGURE;
			case SimplemappingsPackage.SIMPLE_MAPPING_ELEMENT_WITH_FIGURE__LABEL_FIGURE:
				return SimplemappingsPackage.SIMPLE_NODE__LABEL_FIGURE;
			default:
				return -1;
			}
		}
		if (baseClass == SimpleNodeReference.class) {
			switch (baseFeatureID) {
			case SimplemappingsPackage.SIMPLE_NODE_REFERENCE__NODE_REFERENCE:
				return SimplemappingsPackage.SIMPLE_NODE__NODE_REFERENCE;
			case SimplemappingsPackage.SIMPLE_NODE_REFERENCE__CONTAINMENT_FEATURE:
				return SimplemappingsPackage.SIMPLE_NODE__CONTAINMENT_FEATURE;
			case SimplemappingsPackage.SIMPLE_NODE_REFERENCE__NAME:
				return SimplemappingsPackage.SIMPLE_NODE__NAME;
			default:
				return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NodeReference getNodeReference() {
		return (NodeReference) eGet(SimplemappingsPackage.Literals.SIMPLE_NODE_REFERENCE__NODE_REFERENCE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNodeReference(NodeReference newNodeReference) {
		eSet(SimplemappingsPackage.Literals.SIMPLE_NODE_REFERENCE__NODE_REFERENCE, newNodeReference);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getContainmentFeature() {
		return (EReference) eGet(SimplemappingsPackage.Literals.SIMPLE_NODE_REFERENCE__CONTAINMENT_FEATURE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContainmentFeature(EReference newContainmentFeature) {
		eSet(SimplemappingsPackage.Literals.SIMPLE_NODE_REFERENCE__CONTAINMENT_FEATURE, newContainmentFeature);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return (String) eGet(SimplemappingsPackage.Literals.SIMPLE_NODE_REFERENCE__NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		eSet(SimplemappingsPackage.Literals.SIMPLE_NODE_REFERENCE__NAME, newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParentMetaElement() {
		return (EClass) eGet(SimplemappingsPackage.Literals.SIMPLE_CHILD_NODE__PARENT_META_ELEMENT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentMetaElement(EClass newParentMetaElement) {
		eSet(SimplemappingsPackage.Literals.SIMPLE_CHILD_NODE__PARENT_META_ELEMENT, newParentMetaElement);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractTool getTool() {
		return (AbstractTool) eGet(SimplemappingsPackage.Literals.SIMPLE_NODE__TOOL, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTool() {
		return eIsSet(SimplemappingsPackage.Literals.SIMPLE_NODE__TOOL);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<EAttribute> getLabelAttributes() {
		return (EList<EAttribute>) eGet(SimplemappingsPackage.Literals.SIMPLE_NODE__LABEL_ATTRIBUTES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node getDiagramNode() {
		return (Node) eGet(SimplemappingsPackage.Literals.SIMPLE_NODE__DIAGRAM_NODE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDiagramNode() {
		return eIsSet(SimplemappingsPackage.Literals.SIMPLE_NODE__DIAGRAM_NODE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DiagramLabel getDiagramLabel() {
		return (DiagramLabel) eGet(SimplemappingsPackage.Literals.SIMPLE_NODE__DIAGRAM_LABEL, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDiagramLabel() {
		return eIsSet(SimplemappingsPackage.Literals.SIMPLE_NODE__DIAGRAM_LABEL);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Figure getNodeFigure() {
		return (Figure) eGet(SimplemappingsPackage.Literals.SIMPLE_MAPPING_ELEMENT_WITH_FIGURE__NODE_FIGURE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNodeFigure(Figure newNodeFigure) {
		eSet(SimplemappingsPackage.Literals.SIMPLE_MAPPING_ELEMENT_WITH_FIGURE__NODE_FIGURE, newNodeFigure);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Figure getLabelFigure() {
		return (Figure) eGet(SimplemappingsPackage.Literals.SIMPLE_MAPPING_ELEMENT_WITH_FIGURE__LABEL_FIGURE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLabelFigure(Figure newLabelFigure) {
		eSet(SimplemappingsPackage.Literals.SIMPLE_MAPPING_ELEMENT_WITH_FIGURE__LABEL_FIGURE, newLabelFigure);
	}

} //SimpleNodeImpl
