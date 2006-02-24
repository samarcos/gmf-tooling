package org.eclipse.gmf.ecore.edit.parts;

import org.eclipse.draw2d.BorderLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.gmf.runtime.draw2d.ui.internal.figures.ImageFigureEx;
import org.eclipse.draw2d.Figure;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;

import org.eclipse.gef.commands.Command;

import org.eclipse.gmf.ecore.edit.policies.EClassCanonicalEditPolicy;
import org.eclipse.gmf.ecore.edit.policies.EClassGraphicalNodeEditPolicy;
import org.eclipse.gmf.ecore.edit.policies.EClassItemSemanticEditPolicy;

import org.eclipse.gmf.ecore.editor.EcoreDiagramEditorPlugin;

import org.eclipse.gmf.ecore.providers.EcoreElementTypes;
import org.eclipse.gmf.ecore.providers.EcoreSemanticHints;

import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;

import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;

import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;

import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;

import org.eclipse.gmf.runtime.emf.type.core.IElementType;

/**
 * @generated
 */
public class EClassEditPart extends ShapeNodeEditPart {

	/**
	 * @generated
	 */
	protected IFigure contentPane;

	/**
	 * @generated
	 */
	public EClassEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		installEditPolicy(EditPolicyRoles.CREATION_ROLE, new CreationEditPolicy() {

			public Command getCommand(Request request) {
				if (understandsRequest(request)) {
					if (request instanceof CreateViewAndElementRequest) {
						CreateElementRequestAdapter adapter = ((CreateViewAndElementRequest) request).getViewAndElementDescriptor().getCreateElementRequestAdapter();
						IElementType type = (IElementType) adapter.getAdapter(IElementType.class);
						if (type == EcoreElementTypes.EAttribute_2001) {
							EditPart compartmentEditPart = getChildBySemanticHint(EcoreSemanticHints.EClass_1001Compartments.ATTRIBUTES_5001);
							return compartmentEditPart == null ? null : compartmentEditPart.getCommand(request);
						}
						if (type == EcoreElementTypes.EOperation_2002) {
							EditPart compartmentEditPart = getChildBySemanticHint(EcoreSemanticHints.EClass_1001Compartments.OPERATIONS_5002);
							return compartmentEditPart == null ? null : compartmentEditPart.getCommand(request);
						}
						if (type == EcoreElementTypes.EAnnotation_2003) {
							EditPart compartmentEditPart = getChildBySemanticHint(EcoreSemanticHints.EClass_1001Compartments.CLASS_ANNOTATIONS_5003);
							return compartmentEditPart == null ? null : compartmentEditPart.getCommand(request);
						}
					}
					return super.getCommand(request);
				}
				return null;
			}
		});
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new EClassItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new EClassGraphicalNodeEditPolicy());
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE, new EClassCanonicalEditPolicy());
	}

	/**
	 * @generated
	 */
	protected IFigure createNodeShape() {
		return new NamedNodeRectangle();
	}

	/**
	 * @generated
	 */
	protected NodeFigure createNodePlate() {
		return new DefaultSizeNodeFigure(getMapMode().DPtoLP(40), getMapMode().DPtoLP(40));
	}

	/**
	 * Creates figure for this edit part.
	 * 
	 * Body of this method does not depend on settings in generation model
	 * so you may safely remove <i>generated</i> tag and modify it.
	 * 
	 * @generated
	 */
	protected NodeFigure createNodeFigure() {
		NodeFigure figure = createNodePlate();
		figure.setLayoutManager(new StackLayout());
		IFigure shape = createNodeShape();
		figure.add(shape);
		if (shape.getLayoutManager() == null) {
			shape.setLayoutManager(new StackLayout());
		}

		IFigure shapeContents = new Figure();
		shape.add(shapeContents);
		shapeContents.setLayoutManager(new BorderLayout());
		addContentPane(shapeContents);
		decorateShape(shapeContents);

		return figure;
	}

	/**
	 * @generated
	 */
	private void decorateShape(IFigure shapeContents) {
		View view = (View) getModel();
		EAnnotation annotation = view.getEAnnotation("Shortcutted"); //$NON-NLS-1$
		if (annotation == null) {
			return;
		}

		Figure decorationPane = new Figure();
		decorationPane.setLayoutManager(new BorderLayout());
		shapeContents.add(decorationPane, BorderLayout.BOTTOM);

		ImageFigureEx imageFigure = new ImageFigureEx(EcoreDiagramEditorPlugin.getInstance().getBundledImage("icons/shortcut.gif"));
		decorationPane.add(imageFigure, BorderLayout.RIGHT);
	}

	/**
	 * @generated
	 */
	protected void addContentPane(IFigure shape) {
		contentPane = new Figure();
		shape.add(contentPane, BorderLayout.CENTER);
		ConstrainedToolbarLayout layout = new ConstrainedToolbarLayout();
		layout.setSpacing(getMapMode().DPtoLP(5));
		contentPane.setLayoutManager(layout);
	}

	/**
	 * @generated
	 */
	public IFigure getContentPane() {
		if (contentPane != null) {
			return contentPane;
		}
		return super.getContentPane();
	}

	/**
	 * @generated
	 */
	public EditPart getPrimaryChildEditPart() {
		return getChildBySemanticHint(EcoreSemanticHints.EClass_1001Labels.ECLASSNAME_4004_TEXT);
	}

	/**
	 * @generated
	 */
	public class NamedNodeRectangle extends org.eclipse.draw2d.RectangleFigure {

		/**
		 * @generated
		 */
		public NamedNodeRectangle() {

			org.eclipse.draw2d.IFigure childNamedNode_NameLabelFigure = createFigureNamedNode_NameLabelFigure();
			setFigureNamedNode_NameLabelFigure(childNamedNode_NameLabelFigure);
			add(childNamedNode_NameLabelFigure);

		}

		private org.eclipse.draw2d.IFigure fNamedNode_NameLabelFigure;

		/**
		 * @generated
		 */
		public org.eclipse.draw2d.IFigure getFigureNamedNode_NameLabelFigure() {
			return fNamedNode_NameLabelFigure;
		}

		/**
		 * @generated
		 */
		protected void setFigureNamedNode_NameLabelFigure(org.eclipse.draw2d.IFigure figure) {
			fNamedNode_NameLabelFigure = figure;
		}

		/**
		 * @generated
		 */
		private org.eclipse.draw2d.IFigure createFigureNamedNode_NameLabelFigure() {
			org.eclipse.draw2d.Label rv = new org.eclipse.draw2d.Label();

			return rv;
		}

	}

}
