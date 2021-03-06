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
package org.eclipse.gmf.tooling.simplemap.model.triggers.parent;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.gmfgraph.ChildAccess;
import org.eclipse.gmf.gmfgraph.Compartment;
import org.eclipse.gmf.gmfgraph.Connection;
import org.eclipse.gmf.gmfgraph.DecorationFigure;
import org.eclipse.gmf.gmfgraph.DiagramElement;
import org.eclipse.gmf.gmfgraph.Figure;
import org.eclipse.gmf.gmfgraph.FigureDescriptor;
import org.eclipse.gmf.gmfgraph.Node;
import org.eclipse.gmf.gmfgraph.PolylineConnection;
import org.eclipse.gmf.mappings.CompartmentMapping;
import org.eclipse.gmf.mappings.LabelMapping;
import org.eclipse.gmf.mappings.LinkMapping;
import org.eclipse.gmf.mappings.NodeMapping;
import org.eclipse.gmf.mappings.NodeReference;
import org.eclipse.gmf.tooldef.AbstractTool;
import org.eclipse.gmf.tooling.simplemap.model.triggers.AbstractTrigger;
import org.eclipse.gmf.tooling.simplemap.simplemappings.SimpleChildNode;
import org.eclipse.gmf.tooling.simplemap.simplemappings.SimpleChildReference;
import org.eclipse.gmf.tooling.simplemap.simplemappings.SimpleCompartment;
import org.eclipse.gmf.tooling.simplemap.simplemappings.SimpleLinkMapping;
import org.eclipse.gmf.tooling.simplemap.simplemappings.SimpleNode;
import org.eclipse.gmf.tooling.simplemap.simplemappings.SimpleSubNode;

public class RemoveChildNodeTrigger extends AbstractTrigger {

	private List<SimpleChildNode> removedNodes = new ArrayList<SimpleChildNode>();

	public RemoveChildNodeTrigger(TransactionalEditingDomain domain, SimpleChildNode removedNode) {
		super(domain);

		this.removedNodes.add(removedNode);
	}

	public RemoveChildNodeTrigger(TransactionalEditingDomain domain, List<SimpleChildNode> removedNodes) {
		super(domain);

		this.removedNodes.addAll(removedNodes);
	}

	@Override
	public void executeTrigger() {

		for (SimpleChildNode removedNode : removedNodes)
			removeChildNode(removedNode);
	}

	private void removeChildNode(SimpleChildNode removedNode) {
		if (removedNode instanceof SimpleChildReference)
			removeSimpleChildReference((SimpleChildReference) removedNode);

		if (removedNode instanceof SimpleNode)
			removeSimpleNode((SimpleNode) removedNode);

		if (removedNode instanceof SimpleCompartment)
			removeCompartment((SimpleCompartment) removedNode);

		if (removedNode instanceof SimpleLinkMapping)
			removeLinkMapping((SimpleLinkMapping) removedNode);

	}

	private void removeSimpleNode(SimpleNode removedNode) {
		if (removedNode instanceof SimpleSubNode)
			for (SimpleChildNode childNode : ((SimpleSubNode) removedNode).getChildren())
				removeChildNode(childNode);

		NodeReference nodeReferenceToRemove = removedNode.getNodeReference();

		if (nodeReferenceToRemove != null && nodeReferenceToRemove.eIsProxy())
			nodeReferenceToRemove = (NodeReference) EcoreUtil.resolve(nodeReferenceToRemove, getDomain().getResourceSet());

		AbstractTool toolToRemove = null;

		NodeMapping nodeMappingToRemove = null;

		if (nodeReferenceToRemove != null && nodeReferenceToRemove.getChild() != null) {
			nodeMappingToRemove = nodeReferenceToRemove.getChild();

			toolToRemove = nodeMappingToRemove.getTool();
		}

		List<DiagramElement> diagramElementsToRemove = collectDiagramElementsToRemove(removedNode);

		List<FigureDescriptor> figureDescToRemove = new ArrayList<FigureDescriptor>();

		for (DiagramElement diagramElement : diagramElementsToRemove)
			if (diagramElement.getFigure() != null)
				figureDescToRemove.add(diagramElement.getFigure());

		for (FigureDescriptor figDesc : figureDescToRemove)
			EcoreUtil.delete(figDesc);

		for (DiagramElement diagramElement : diagramElementsToRemove)
			EcoreUtil.delete(diagramElement);

		if (toolToRemove != null && canRemove(toolToRemove))
			EcoreUtil.delete(toolToRemove);

		if (nodeMappingToRemove != null)
			EcoreUtil.delete(nodeMappingToRemove);

		if (nodeReferenceToRemove != null)
			EcoreUtil.delete(nodeReferenceToRemove);
	}

	private void removeSimpleChildReference(SimpleChildReference removedNode) {
		NodeReference nodeReferenceToRemove = removedNode.getNodeReference();

		if (nodeReferenceToRemove != null && nodeReferenceToRemove.eIsProxy())
			nodeReferenceToRemove = (NodeReference) EcoreUtil.resolve(nodeReferenceToRemove, getDomain().getResourceSet());

		if (nodeReferenceToRemove != null)
			EcoreUtil.delete(nodeReferenceToRemove);
	}

	private List<DiagramElement> collectDiagramElementsToRemove(SimpleNode removedNode) {
		List<DiagramElement> diagramElementsToRemove = new ArrayList<DiagramElement>();

		NodeReference nodeReferenceToRemove = removedNode.getNodeReference();

		if (nodeReferenceToRemove == null)
			return diagramElementsToRemove;

		if (nodeReferenceToRemove.eIsProxy())
			nodeReferenceToRemove = (NodeReference) EcoreUtil.resolve(nodeReferenceToRemove, getDomain().getResourceSet());

		NodeMapping nodeMapping = nodeReferenceToRemove.getChild();

		if (nodeMapping != null) {
			Node nodeToRemove = nodeMapping.getDiagramNode();

			if (nodeToRemove != null && canRemove(nodeToRemove))
				diagramElementsToRemove.add(nodeToRemove);

			for (LabelMapping labelMapping : nodeMapping.getLabelMappings())
				if (labelMapping.getDiagramLabel() != null && canRemove(labelMapping.getDiagramLabel()))
					diagramElementsToRemove.add(labelMapping.getDiagramLabel());
		}

		return diagramElementsToRemove;
	}

	private List<DiagramElement> collectDiagramElementsToRemove(SimpleLinkMapping removedLinkMapping) {
		List<DiagramElement> diagramElementsToRemove = new ArrayList<DiagramElement>();

		LinkMapping linkMapping = removedLinkMapping.getLinkMapping();

		if (linkMapping != null) {
			Connection connectionToRemove = linkMapping.getDiagramLink();

			if (connectionToRemove != null && canRemove(connectionToRemove))
				diagramElementsToRemove.add(connectionToRemove);

			for (LabelMapping labelMapping : linkMapping.getLabelMappings())
				if (labelMapping.getDiagramLabel() != null && canRemove(labelMapping.getDiagramLabel()))
					diagramElementsToRemove.add(labelMapping.getDiagramLabel());
		}

		return diagramElementsToRemove;
	}

	private void removeCompartment(SimpleCompartment removedCompartment) {
		for (SimpleChildNode childNode : removedCompartment.getChildren())
			removeChildNode(childNode);

		CompartmentMapping compartmentMappingToRemove = removedCompartment.getCompartmentMapping();

		if (compartmentMappingToRemove.eIsProxy())
			compartmentMappingToRemove = (CompartmentMapping) EcoreUtil.resolve(compartmentMappingToRemove, getDomain().getResourceSet());

		Compartment compartmentToRemove = compartmentMappingToRemove != null ? compartmentMappingToRemove.getCompartment() : null;

		if (compartmentToRemove != null && canRemove(compartmentToRemove)) {
			FigureDescriptor labelFigDesToRemove = compartmentToRemove != null ? compartmentToRemove.getFigure() : null;
			ChildAccess accessorToRemove = compartmentToRemove != null ? compartmentToRemove.getAccessor() : null;

			if (labelFigDesToRemove != null && canRemove(labelFigDesToRemove))
				EcoreUtil.delete(labelFigDesToRemove);

			if (accessorToRemove != null && canRemove(accessorToRemove)) {
				Figure compartmentFigDesToRemove = accessorToRemove != null ? accessorToRemove.getFigure() : null;

				if (compartmentFigDesToRemove != null)
					EcoreUtil.delete(compartmentFigDesToRemove);

				EcoreUtil.delete(accessorToRemove);
			}

			EcoreUtil.delete(compartmentToRemove);

		}

		if (compartmentMappingToRemove != null)
			EcoreUtil.delete(compartmentMappingToRemove);
	}

	private void removeLinkMapping(SimpleLinkMapping removedLinkMapping) {
		AbstractTool toolToRemove = removedLinkMapping.getTool();

		LinkMapping linkMappingToRemove = removedLinkMapping.getLinkMapping();

		List<DiagramElement> diagramElementsToRemove = collectDiagramElementsToRemove(removedLinkMapping);

		List<FigureDescriptor> figureDescToRemove = new ArrayList<FigureDescriptor>();

		DecorationFigure targetDecorationToRemove = null;
		DecorationFigure sourceDecorationToRemove = null;

		for (DiagramElement diagramElement : diagramElementsToRemove)
			if (diagramElement.getFigure() != null) {
				figureDescToRemove.add(diagramElement.getFigure());
				if (diagramElement.getFigure().getActualFigure() instanceof PolylineConnection) {
					targetDecorationToRemove = ((PolylineConnection) diagramElement.getFigure().getActualFigure()).getTargetDecoration();
					sourceDecorationToRemove = ((PolylineConnection) diagramElement.getFigure().getActualFigure()).getSourceDecoration();
				}
			}

		for (FigureDescriptor figDesc : figureDescToRemove)
			EcoreUtil.delete(figDesc);

		for (DiagramElement diagramElement : diagramElementsToRemove)
			EcoreUtil.delete(diagramElement);

		if (toolToRemove != null && canRemove(toolToRemove))
			EcoreUtil.delete(toolToRemove);

		if (linkMappingToRemove != null)
			EcoreUtil.delete(linkMappingToRemove);

		if (targetDecorationToRemove != null)
			EcoreUtil.delete(targetDecorationToRemove);

		if (sourceDecorationToRemove != null)
			EcoreUtil.delete(sourceDecorationToRemove);

	}

}
