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
package org.eclipse.gmf.graphdef.editor.providers;

import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.gmfgraph.GMFGraphPackage;
import org.eclipse.gmf.graphdef.editor.edit.parts.CanvasEditPart;
import org.eclipse.gmf.graphdef.editor.edit.parts.ChildAccessEditPart;
import org.eclipse.gmf.graphdef.editor.edit.parts.CompartmentAccessorEditPart;
import org.eclipse.gmf.graphdef.editor.edit.parts.CompartmentEditPart;
import org.eclipse.gmf.graphdef.editor.edit.parts.ConnectionEditPart;
import org.eclipse.gmf.graphdef.editor.edit.parts.DiagramElementFigureEditPart;
import org.eclipse.gmf.graphdef.editor.edit.parts.DiagramLabelAccessorEditPart;
import org.eclipse.gmf.graphdef.editor.edit.parts.DiagramLabelEditPart;
import org.eclipse.gmf.graphdef.editor.edit.parts.Ellipse2EditPart;
import org.eclipse.gmf.graphdef.editor.edit.parts.Ellipse3EditPart;
import org.eclipse.gmf.graphdef.editor.edit.parts.EllipseEditPart;
import org.eclipse.gmf.graphdef.editor.edit.parts.FigureDescriptorEditPart;
import org.eclipse.gmf.graphdef.editor.edit.parts.FigureGalleryEditPart;
import org.eclipse.gmf.graphdef.editor.edit.parts.Label2EditPart;
import org.eclipse.gmf.graphdef.editor.edit.parts.Label3EditPart;
import org.eclipse.gmf.graphdef.editor.edit.parts.LabelEditPart;
import org.eclipse.gmf.graphdef.editor.edit.parts.NodeContentPaneEditPart;
import org.eclipse.gmf.graphdef.editor.edit.parts.NodeEditPart;
import org.eclipse.gmf.graphdef.editor.edit.parts.PointEditPart;
import org.eclipse.gmf.graphdef.editor.edit.parts.Polygon2EditPart;
import org.eclipse.gmf.graphdef.editor.edit.parts.Polygon3EditPart;
import org.eclipse.gmf.graphdef.editor.edit.parts.PolygonEditPart;
import org.eclipse.gmf.graphdef.editor.edit.parts.Polyline2EditPart;
import org.eclipse.gmf.graphdef.editor.edit.parts.Polyline3EditPart;
import org.eclipse.gmf.graphdef.editor.edit.parts.PolylineEditPart;
import org.eclipse.gmf.graphdef.editor.edit.parts.Rectangle2EditPart;
import org.eclipse.gmf.graphdef.editor.edit.parts.Rectangle3EditPart;
import org.eclipse.gmf.graphdef.editor.edit.parts.RectangleEditPart;
import org.eclipse.gmf.graphdef.editor.edit.parts.RoundedRectangle2EditPart;
import org.eclipse.gmf.graphdef.editor.edit.parts.RoundedRectangle3EditPart;
import org.eclipse.gmf.graphdef.editor.edit.parts.RoundedRectangleEditPart;
import org.eclipse.gmf.graphdef.editor.part.GMFGraphDiagramEditorPlugin;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;

/**
 * @generated
 */
public class GMFGraphElementTypes extends ElementInitializers {

	/**
	 * @generated
	 */
	private GMFGraphElementTypes() {
	}

	/**
	 * @generated
	 */
	private static Map elements;

	/**
	 * @generated
	 */
	private static ImageRegistry imageRegistry;

	/**
	 * @generated
	 */
	private static Set KNOWN_ELEMENT_TYPES;

	/**
	 * @generated
	 */
	public static final IElementType Canvas_1000 = getElementType("org.eclipse.gmf.graphdef.editor.Canvas_1000"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Compartment_2005 = getElementType("org.eclipse.gmf.graphdef.editor.Compartment_2005"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Node_2006 = getElementType("org.eclipse.gmf.graphdef.editor.Node_2006"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Connection_2007 = getElementType("org.eclipse.gmf.graphdef.editor.Connection_2007"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType FigureGallery_2008 = getElementType("org.eclipse.gmf.graphdef.editor.FigureGallery_2008"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType DiagramLabel_2009 = getElementType("org.eclipse.gmf.graphdef.editor.DiagramLabel_2009"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType FigureDescriptor_3009 = getElementType("org.eclipse.gmf.graphdef.editor.FigureDescriptor_3009"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Rectangle_3010 = getElementType("org.eclipse.gmf.graphdef.editor.Rectangle_3010"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Rectangle_3011 = getElementType("org.eclipse.gmf.graphdef.editor.Rectangle_3011"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Ellipse_3012 = getElementType("org.eclipse.gmf.graphdef.editor.Ellipse_3012"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType RoundedRectangle_3013 = getElementType("org.eclipse.gmf.graphdef.editor.RoundedRectangle_3013"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Polyline_3014 = getElementType("org.eclipse.gmf.graphdef.editor.Polyline_3014"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Point_3022 = getElementType("org.eclipse.gmf.graphdef.editor.Point_3022"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Polygon_3023 = getElementType("org.eclipse.gmf.graphdef.editor.Polygon_3023"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Label_3026 = getElementType("org.eclipse.gmf.graphdef.editor.Label_3026"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Ellipse_3015 = getElementType("org.eclipse.gmf.graphdef.editor.Ellipse_3015"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType RoundedRectangle_3016 = getElementType("org.eclipse.gmf.graphdef.editor.RoundedRectangle_3016"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Polyline_3017 = getElementType("org.eclipse.gmf.graphdef.editor.Polyline_3017"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Polygon_3024 = getElementType("org.eclipse.gmf.graphdef.editor.Polygon_3024"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Label_3027 = getElementType("org.eclipse.gmf.graphdef.editor.Label_3027"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Rectangle_3018 = getElementType("org.eclipse.gmf.graphdef.editor.Rectangle_3018"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Ellipse_3019 = getElementType("org.eclipse.gmf.graphdef.editor.Ellipse_3019"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType RoundedRectangle_3020 = getElementType("org.eclipse.gmf.graphdef.editor.RoundedRectangle_3020"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Polyline_3021 = getElementType("org.eclipse.gmf.graphdef.editor.Polyline_3021"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Polygon_3025 = getElementType("org.eclipse.gmf.graphdef.editor.Polygon_3025"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Label_3028 = getElementType("org.eclipse.gmf.graphdef.editor.Label_3028"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ChildAccess_4002 = getElementType("org.eclipse.gmf.graphdef.editor.ChildAccess_4002"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType CompartmentAccessor_4003 = getElementType("org.eclipse.gmf.graphdef.editor.CompartmentAccessor_4003"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType DiagramLabelAccessor_4004 = getElementType("org.eclipse.gmf.graphdef.editor.DiagramLabelAccessor_4004"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType NodeContentPane_4006 = getElementType("org.eclipse.gmf.graphdef.editor.NodeContentPane_4006"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType DiagramElementFigure_4005 = getElementType("org.eclipse.gmf.graphdef.editor.DiagramElementFigure_4005"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	private static ImageRegistry getImageRegistry() {
		if (imageRegistry == null) {
			imageRegistry = new ImageRegistry();
		}
		return imageRegistry;
	}

	/**
	 * @generated
	 */
	private static String getImageRegistryKey(ENamedElement element) {
		return element.getName();
	}

	/**
	 * @generated
	 */
	private static ImageDescriptor getProvidedImageDescriptor(ENamedElement element) {
		if (element instanceof EStructuralFeature) {
			EStructuralFeature feature = ((EStructuralFeature) element);
			EClass eContainingClass = feature.getEContainingClass();
			EClassifier eType = feature.getEType();
			if (eContainingClass != null && !eContainingClass.isAbstract()) {
				element = eContainingClass;
			} else if (eType instanceof EClass && !((EClass) eType).isAbstract()) {
				element = eType;
			}
		}
		if (element instanceof EClass) {
			EClass eClass = (EClass) element;
			if (!eClass.isAbstract()) {
				return GMFGraphDiagramEditorPlugin.getInstance().getItemImageDescriptor(eClass.getEPackage().getEFactoryInstance().create(eClass));
			}
		}
		// TODO : support structural features
		return null;
	}

	/**
	 * @generated
	 */
	public static ImageDescriptor getImageDescriptor(ENamedElement element) {
		String key = getImageRegistryKey(element);
		ImageDescriptor imageDescriptor = getImageRegistry().getDescriptor(key);
		if (imageDescriptor == null) {
			imageDescriptor = getProvidedImageDescriptor(element);
			if (imageDescriptor == null) {
				imageDescriptor = ImageDescriptor.getMissingImageDescriptor();
			}
			getImageRegistry().put(key, imageDescriptor);
		}
		return imageDescriptor;
	}

	/**
	 * @generated
	 */
	public static Image getImage(ENamedElement element) {
		String key = getImageRegistryKey(element);
		Image image = getImageRegistry().get(key);
		if (image == null) {
			ImageDescriptor imageDescriptor = getProvidedImageDescriptor(element);
			if (imageDescriptor == null) {
				imageDescriptor = ImageDescriptor.getMissingImageDescriptor();
			}
			getImageRegistry().put(key, imageDescriptor);
			image = getImageRegistry().get(key);
		}
		return image;
	}

	/**
	 * @generated
	 */
	public static ImageDescriptor getImageDescriptor(IAdaptable hint) {
		ENamedElement element = getElement(hint);
		if (element == null) {
			return null;
		}
		return getImageDescriptor(element);
	}

	/**
	 * @generated
	 */
	public static Image getImage(IAdaptable hint) {
		ENamedElement element = getElement(hint);
		if (element == null) {
			return null;
		}
		return getImage(element);
	}

	/**
	 * Returns 'type' of the ecore object associated with the hint.
	 * 
	 * @generated
	 */
	public static ENamedElement getElement(IAdaptable hint) {
		Object type = hint.getAdapter(IElementType.class);
		if (elements == null) {
			elements = new IdentityHashMap();

			elements.put(Canvas_1000, GMFGraphPackage.eINSTANCE.getCanvas());

			elements.put(Compartment_2005, GMFGraphPackage.eINSTANCE.getCompartment());

			elements.put(Node_2006, GMFGraphPackage.eINSTANCE.getNode());

			elements.put(Connection_2007, GMFGraphPackage.eINSTANCE.getConnection());

			elements.put(FigureGallery_2008, GMFGraphPackage.eINSTANCE.getFigureGallery());

			elements.put(DiagramLabel_2009, GMFGraphPackage.eINSTANCE.getDiagramLabel());

			elements.put(FigureDescriptor_3009, GMFGraphPackage.eINSTANCE.getFigureDescriptor());

			elements.put(Rectangle_3010, GMFGraphPackage.eINSTANCE.getRectangle());

			elements.put(Rectangle_3011, GMFGraphPackage.eINSTANCE.getRectangle());

			elements.put(Ellipse_3012, GMFGraphPackage.eINSTANCE.getEllipse());

			elements.put(RoundedRectangle_3013, GMFGraphPackage.eINSTANCE.getRoundedRectangle());

			elements.put(Polyline_3014, GMFGraphPackage.eINSTANCE.getPolyline());

			elements.put(Point_3022, GMFGraphPackage.eINSTANCE.getPoint());

			elements.put(Polygon_3023, GMFGraphPackage.eINSTANCE.getPolygon());

			elements.put(Label_3026, GMFGraphPackage.eINSTANCE.getLabel());

			elements.put(Ellipse_3015, GMFGraphPackage.eINSTANCE.getEllipse());

			elements.put(RoundedRectangle_3016, GMFGraphPackage.eINSTANCE.getRoundedRectangle());

			elements.put(Polyline_3017, GMFGraphPackage.eINSTANCE.getPolyline());

			elements.put(Polygon_3024, GMFGraphPackage.eINSTANCE.getPolygon());

			elements.put(Label_3027, GMFGraphPackage.eINSTANCE.getLabel());

			elements.put(Rectangle_3018, GMFGraphPackage.eINSTANCE.getRectangle());

			elements.put(Ellipse_3019, GMFGraphPackage.eINSTANCE.getEllipse());

			elements.put(RoundedRectangle_3020, GMFGraphPackage.eINSTANCE.getRoundedRectangle());

			elements.put(Polyline_3021, GMFGraphPackage.eINSTANCE.getPolyline());

			elements.put(Polygon_3025, GMFGraphPackage.eINSTANCE.getPolygon());

			elements.put(Label_3028, GMFGraphPackage.eINSTANCE.getLabel());

			elements.put(ChildAccess_4002, GMFGraphPackage.eINSTANCE.getChildAccess());

			elements.put(CompartmentAccessor_4003, GMFGraphPackage.eINSTANCE.getCompartment_Accessor());

			elements.put(DiagramLabelAccessor_4004, GMFGraphPackage.eINSTANCE.getDiagramLabel_Accessor());

			elements.put(NodeContentPane_4006, GMFGraphPackage.eINSTANCE.getNode_ContentPane());

			elements.put(DiagramElementFigure_4005, GMFGraphPackage.eINSTANCE.getDiagramElement_Figure());
		}
		return (ENamedElement) elements.get(type);
	}

	/**
	 * @generated
	 */
	private static IElementType getElementType(String id) {
		return ElementTypeRegistry.getInstance().getType(id);
	}

	/**
	 * @generated
	 */
	public static boolean isKnownElementType(IElementType elementType) {
		if (KNOWN_ELEMENT_TYPES == null) {
			KNOWN_ELEMENT_TYPES = new HashSet();
			KNOWN_ELEMENT_TYPES.add(Canvas_1000);
			KNOWN_ELEMENT_TYPES.add(Compartment_2005);
			KNOWN_ELEMENT_TYPES.add(Node_2006);
			KNOWN_ELEMENT_TYPES.add(Connection_2007);
			KNOWN_ELEMENT_TYPES.add(FigureGallery_2008);
			KNOWN_ELEMENT_TYPES.add(DiagramLabel_2009);
			KNOWN_ELEMENT_TYPES.add(FigureDescriptor_3009);
			KNOWN_ELEMENT_TYPES.add(Rectangle_3010);
			KNOWN_ELEMENT_TYPES.add(Rectangle_3011);
			KNOWN_ELEMENT_TYPES.add(Ellipse_3012);
			KNOWN_ELEMENT_TYPES.add(RoundedRectangle_3013);
			KNOWN_ELEMENT_TYPES.add(Polyline_3014);
			KNOWN_ELEMENT_TYPES.add(Point_3022);
			KNOWN_ELEMENT_TYPES.add(Polygon_3023);
			KNOWN_ELEMENT_TYPES.add(Label_3026);
			KNOWN_ELEMENT_TYPES.add(Ellipse_3015);
			KNOWN_ELEMENT_TYPES.add(RoundedRectangle_3016);
			KNOWN_ELEMENT_TYPES.add(Polyline_3017);
			KNOWN_ELEMENT_TYPES.add(Polygon_3024);
			KNOWN_ELEMENT_TYPES.add(Label_3027);
			KNOWN_ELEMENT_TYPES.add(Rectangle_3018);
			KNOWN_ELEMENT_TYPES.add(Ellipse_3019);
			KNOWN_ELEMENT_TYPES.add(RoundedRectangle_3020);
			KNOWN_ELEMENT_TYPES.add(Polyline_3021);
			KNOWN_ELEMENT_TYPES.add(Polygon_3025);
			KNOWN_ELEMENT_TYPES.add(Label_3028);
			KNOWN_ELEMENT_TYPES.add(ChildAccess_4002);
			KNOWN_ELEMENT_TYPES.add(CompartmentAccessor_4003);
			KNOWN_ELEMENT_TYPES.add(DiagramLabelAccessor_4004);
			KNOWN_ELEMENT_TYPES.add(NodeContentPane_4006);
			KNOWN_ELEMENT_TYPES.add(DiagramElementFigure_4005);
		}
		return KNOWN_ELEMENT_TYPES.contains(elementType);
	}

	/**
	 * @generated
	 */
	public static IElementType getElementType(int visualID) {
		switch (visualID) {
		case CanvasEditPart.VISUAL_ID:
			return Canvas_1000;
		case CompartmentEditPart.VISUAL_ID:
			return Compartment_2005;
		case NodeEditPart.VISUAL_ID:
			return Node_2006;
		case ConnectionEditPart.VISUAL_ID:
			return Connection_2007;
		case FigureGalleryEditPart.VISUAL_ID:
			return FigureGallery_2008;
		case DiagramLabelEditPart.VISUAL_ID:
			return DiagramLabel_2009;
		case FigureDescriptorEditPart.VISUAL_ID:
			return FigureDescriptor_3009;
		case RectangleEditPart.VISUAL_ID:
			return Rectangle_3010;
		case Rectangle2EditPart.VISUAL_ID:
			return Rectangle_3011;
		case EllipseEditPart.VISUAL_ID:
			return Ellipse_3012;
		case RoundedRectangleEditPart.VISUAL_ID:
			return RoundedRectangle_3013;
		case PolylineEditPart.VISUAL_ID:
			return Polyline_3014;
		case PointEditPart.VISUAL_ID:
			return Point_3022;
		case PolygonEditPart.VISUAL_ID:
			return Polygon_3023;
		case LabelEditPart.VISUAL_ID:
			return Label_3026;
		case Ellipse2EditPart.VISUAL_ID:
			return Ellipse_3015;
		case RoundedRectangle2EditPart.VISUAL_ID:
			return RoundedRectangle_3016;
		case Polyline2EditPart.VISUAL_ID:
			return Polyline_3017;
		case Polygon2EditPart.VISUAL_ID:
			return Polygon_3024;
		case Label2EditPart.VISUAL_ID:
			return Label_3027;
		case Rectangle3EditPart.VISUAL_ID:
			return Rectangle_3018;
		case Ellipse3EditPart.VISUAL_ID:
			return Ellipse_3019;
		case RoundedRectangle3EditPart.VISUAL_ID:
			return RoundedRectangle_3020;
		case Polyline3EditPart.VISUAL_ID:
			return Polyline_3021;
		case Polygon3EditPart.VISUAL_ID:
			return Polygon_3025;
		case Label3EditPart.VISUAL_ID:
			return Label_3028;
		case ChildAccessEditPart.VISUAL_ID:
			return ChildAccess_4002;
		case CompartmentAccessorEditPart.VISUAL_ID:
			return CompartmentAccessor_4003;
		case DiagramLabelAccessorEditPart.VISUAL_ID:
			return DiagramLabelAccessor_4004;
		case NodeContentPaneEditPart.VISUAL_ID:
			return NodeContentPane_4006;
		case DiagramElementFigureEditPart.VISUAL_ID:
			return DiagramElementFigure_4005;
		}
		return null;
	}

}
