/*
 *  Copyright (c) 2006, 2009 Borland Software Corporation and others.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Borland Software Corporation - initial API and implementation
 */
package org.eclipse.gmf.graphdef.editor.part;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.graphdef.editor.providers.GMFGraphElementTypes;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeConnectionTool;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeCreationTool;

/**
 * @generated
 */
public class GMFGraphPaletteFactory {

	/**
	 * @generated
	 */
	public void fillPalette(PaletteRoot paletteRoot) {
		paletteRoot.add(createDiagramElements1Group());
		paletteRoot.add(createFigures2Group());
	}

	/**
	 * Creates "Diagram Elements" palette tool group
	 * @generated
	 */
	private PaletteContainer createDiagramElements1Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(Messages.DiagramElements1Group_title);
		paletteContainer.setId("createDiagramElements1Group"); //$NON-NLS-1$
		paletteContainer.setDescription(Messages.DiagramElements1Group_desc);
		paletteContainer.add(createNode1CreationTool());
		paletteContainer.add(createCompartment2CreationTool());
		paletteContainer.add(createConnection3CreationTool());
		paletteContainer.add(createFigureLink4CreationTool());
		paletteContainer.add(createNestedFigureLink5CreationTool());
		paletteContainer.add(createChildAccessLink6CreationTool());
		paletteContainer.add(createLabel7CreationTool());
		return paletteContainer;
	}

	/**
	 * Creates "Figures" palette tool group
	 * @generated
	 */
	private PaletteContainer createFigures2Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(Messages.Figures2Group_title);
		paletteContainer.setId("createFigures2Group"); //$NON-NLS-1$
		paletteContainer.setDescription(Messages.Figures2Group_desc);
		paletteContainer.add(createFigureGallery1CreationTool());
		paletteContainer.add(createFigureDescriptor2CreationTool());
		paletteContainer.add(createRectangle3CreationTool());
		paletteContainer.add(createEllipse4CreationTool());
		paletteContainer.add(createRoundedRectangle5CreationTool());
		paletteContainer.add(createPolyline6CreationTool());
		paletteContainer.add(createPolylinePoint7CreationTool());
		paletteContainer.add(createPolygon8CreationTool());
		paletteContainer.add(createLabelFigure9CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createNode1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(GMFGraphElementTypes.Node_2006);
		NodeToolEntry entry = new NodeToolEntry(Messages.Node1CreationTool_title, Messages.Node1CreationTool_desc, types);
		entry.setId("createNode1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(GMFGraphElementTypes.getImageDescriptor(GMFGraphElementTypes.Node_2006));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createCompartment2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(GMFGraphElementTypes.Compartment_2005);
		NodeToolEntry entry = new NodeToolEntry(Messages.Compartment2CreationTool_title, Messages.Compartment2CreationTool_desc, types);
		entry.setId("createCompartment2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(GMFGraphElementTypes.getImageDescriptor(GMFGraphElementTypes.Compartment_2005));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createConnection3CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(GMFGraphElementTypes.Connection_2007);
		NodeToolEntry entry = new NodeToolEntry(Messages.Connection3CreationTool_title, Messages.Connection3CreationTool_desc, types);
		entry.setId("createConnection3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(GMFGraphElementTypes.getImageDescriptor(GMFGraphElementTypes.Connection_2007));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createFigureLink4CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(GMFGraphElementTypes.DiagramElementFigure_4005);
		LinkToolEntry entry = new LinkToolEntry(Messages.FigureLink4CreationTool_title, Messages.FigureLink4CreationTool_desc, types);
		entry.setId("createFigureLink4CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(GMFGraphElementTypes.getImageDescriptor(GMFGraphElementTypes.DiagramElementFigure_4005));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createNestedFigureLink5CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(GMFGraphElementTypes.ChildAccess_4002);
		LinkToolEntry entry = new LinkToolEntry(Messages.NestedFigureLink5CreationTool_title, Messages.NestedFigureLink5CreationTool_desc, types);
		entry.setId("createNestedFigureLink5CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(GMFGraphElementTypes.getImageDescriptor(GMFGraphElementTypes.ChildAccess_4002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createChildAccessLink6CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(3);
		types.add(GMFGraphElementTypes.CompartmentAccessor_4003);
		types.add(GMFGraphElementTypes.DiagramLabelAccessor_4004);
		types.add(GMFGraphElementTypes.NodeContentPane_4006);
		LinkToolEntry entry = new LinkToolEntry(Messages.ChildAccessLink6CreationTool_title, Messages.ChildAccessLink6CreationTool_desc, types);
		entry.setId("createChildAccessLink6CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(GMFGraphElementTypes.getImageDescriptor(GMFGraphElementTypes.CompartmentAccessor_4003));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createLabel7CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(GMFGraphElementTypes.DiagramLabel_2009);
		NodeToolEntry entry = new NodeToolEntry(Messages.Label7CreationTool_title, Messages.Label7CreationTool_desc, types);
		entry.setId("createLabel7CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(GMFGraphElementTypes.getImageDescriptor(GMFGraphElementTypes.DiagramLabel_2009));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createFigureGallery1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(GMFGraphElementTypes.FigureGallery_2008);
		NodeToolEntry entry = new NodeToolEntry(Messages.FigureGallery1CreationTool_title, Messages.FigureGallery1CreationTool_desc, types);
		entry.setId("createFigureGallery1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(GMFGraphElementTypes.getImageDescriptor(GMFGraphElementTypes.FigureGallery_2008));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createFigureDescriptor2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(GMFGraphElementTypes.FigureDescriptor_3009);
		NodeToolEntry entry = new NodeToolEntry(Messages.FigureDescriptor2CreationTool_title, Messages.FigureDescriptor2CreationTool_desc, types);
		entry.setId("createFigureDescriptor2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(GMFGraphElementTypes.getImageDescriptor(GMFGraphElementTypes.FigureDescriptor_3009));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createRectangle3CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(3);
		types.add(GMFGraphElementTypes.Rectangle_3010);
		types.add(GMFGraphElementTypes.Rectangle_3011);
		types.add(GMFGraphElementTypes.Rectangle_3018);
		NodeToolEntry entry = new NodeToolEntry(Messages.Rectangle3CreationTool_title, Messages.Rectangle3CreationTool_desc, types);
		entry.setId("createRectangle3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(GMFGraphElementTypes.getImageDescriptor(GMFGraphElementTypes.Rectangle_3010));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createEllipse4CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(3);
		types.add(GMFGraphElementTypes.Ellipse_3012);
		types.add(GMFGraphElementTypes.Ellipse_3015);
		types.add(GMFGraphElementTypes.Ellipse_3019);
		NodeToolEntry entry = new NodeToolEntry(Messages.Ellipse4CreationTool_title, Messages.Ellipse4CreationTool_desc, types);
		entry.setId("createEllipse4CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(GMFGraphElementTypes.getImageDescriptor(GMFGraphElementTypes.Ellipse_3012));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createRoundedRectangle5CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(3);
		types.add(GMFGraphElementTypes.RoundedRectangle_3013);
		types.add(GMFGraphElementTypes.RoundedRectangle_3016);
		types.add(GMFGraphElementTypes.RoundedRectangle_3020);
		NodeToolEntry entry = new NodeToolEntry(Messages.RoundedRectangle5CreationTool_title, Messages.RoundedRectangle5CreationTool_desc, types);
		entry.setId("createRoundedRectangle5CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(GMFGraphElementTypes.getImageDescriptor(GMFGraphElementTypes.RoundedRectangle_3013));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createPolyline6CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(3);
		types.add(GMFGraphElementTypes.Polyline_3014);
		types.add(GMFGraphElementTypes.Polyline_3017);
		types.add(GMFGraphElementTypes.Polyline_3021);
		NodeToolEntry entry = new NodeToolEntry(Messages.Polyline6CreationTool_title, Messages.Polyline6CreationTool_desc, types);
		entry.setId("createPolyline6CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(GMFGraphElementTypes.getImageDescriptor(GMFGraphElementTypes.Polyline_3014));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createPolylinePoint7CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(GMFGraphElementTypes.Point_3022);
		NodeToolEntry entry = new NodeToolEntry(Messages.PolylinePoint7CreationTool_title, Messages.PolylinePoint7CreationTool_desc, types);
		entry.setId("createPolylinePoint7CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(GMFGraphElementTypes.getImageDescriptor(GMFGraphElementTypes.Point_3022));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createPolygon8CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(3);
		types.add(GMFGraphElementTypes.Polygon_3023);
		types.add(GMFGraphElementTypes.Polygon_3024);
		types.add(GMFGraphElementTypes.Polygon_3025);
		NodeToolEntry entry = new NodeToolEntry(Messages.Polygon8CreationTool_title, Messages.Polygon8CreationTool_desc, types);
		entry.setId("createPolygon8CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(GMFGraphElementTypes.getImageDescriptor(GMFGraphElementTypes.Polygon_3023));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createLabelFigure9CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(3);
		types.add(GMFGraphElementTypes.Label_3026);
		types.add(GMFGraphElementTypes.Label_3027);
		types.add(GMFGraphElementTypes.Label_3028);
		NodeToolEntry entry = new NodeToolEntry(Messages.LabelFigure9CreationTool_title, Messages.LabelFigure9CreationTool_desc, types);
		entry.setId("createLabelFigure9CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(GMFGraphElementTypes.getImageDescriptor(GMFGraphElementTypes.Label_3026));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private static class NodeToolEntry extends ToolEntry {

		/**
		 * @generated
		 */
		private final List elementTypes;

		/**
		 * @generated
		 */
		private NodeToolEntry(String title, String description, List elementTypes) {
			super(title, description, null, null);
			this.elementTypes = elementTypes;
		}

		/**
		 * @generated
		 */
		public Tool createTool() {
			Tool tool = new UnspecifiedTypeCreationTool(elementTypes);
			tool.setProperties(getToolProperties());
			return tool;
		}
	}

	/**
	 * @generated
	 */
	private static class LinkToolEntry extends ToolEntry {

		/**
		 * @generated
		 */
		private final List relationshipTypes;

		/**
		 * @generated
		 */
		private LinkToolEntry(String title, String description, List relationshipTypes) {
			super(title, description, null, null);
			this.relationshipTypes = relationshipTypes;
		}

		/**
		 * @generated
		 */
		public Tool createTool() {
			Tool tool = new UnspecifiedTypeConnectionTool(relationshipTypes);
			tool.setProperties(getToolProperties());
			return tool;
		}
	}
}
