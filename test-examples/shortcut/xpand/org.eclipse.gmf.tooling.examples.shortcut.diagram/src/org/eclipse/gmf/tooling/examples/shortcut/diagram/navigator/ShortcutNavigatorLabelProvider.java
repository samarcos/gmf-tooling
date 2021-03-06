package org.eclipse.gmf.tooling.examples.shortcut.diagram.navigator;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserOptions;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.examples.shortcut.diagram.edit.parts.DiagramEditPart;
import org.eclipse.gmf.tooling.examples.shortcut.diagram.edit.parts.DiagramLinkEditPart;
import org.eclipse.gmf.tooling.examples.shortcut.diagram.edit.parts.DiagramNodeEditPart;
import org.eclipse.gmf.tooling.examples.shortcut.diagram.edit.parts.DiagramNodeNameEditPart;
import org.eclipse.gmf.tooling.examples.shortcut.diagram.part.ShortcutDiagramEditorPlugin;
import org.eclipse.gmf.tooling.examples.shortcut.diagram.part.ShortcutVisualIDRegistry;
import org.eclipse.gmf.tooling.examples.shortcut.diagram.providers.ShortcutElementTypes;
import org.eclipse.gmf.tooling.examples.shortcut.diagram.providers.ShortcutParserProvider;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.ITreePathLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.ViewerLabel;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonLabelProvider;

/**
 * @generated
 */
public class ShortcutNavigatorLabelProvider extends LabelProvider implements ICommonLabelProvider, ITreePathLabelProvider {

	/**
	* @generated
	*/
	static {
		ShortcutDiagramEditorPlugin.getInstance().getImageRegistry().put("Navigator?UnknownElement", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
		ShortcutDiagramEditorPlugin.getInstance().getImageRegistry().put("Navigator?ImageNotFound", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
	}

	/**
	* @generated
	*/
	public void updateLabel(ViewerLabel label, TreePath elementPath) {
		Object element = elementPath.getLastSegment();
		if (element instanceof ShortcutNavigatorItem && !isOwnView(((ShortcutNavigatorItem) element).getView())) {
			return;
		}
		label.setText(getText(element));
		label.setImage(getImage(element));
	}

	/**
	* @generated
	*/
	public Image getImage(Object element) {
		if (element instanceof ShortcutNavigatorGroup) {
			ShortcutNavigatorGroup group = (ShortcutNavigatorGroup) element;
			return ShortcutDiagramEditorPlugin.getInstance().getBundledImage(group.getIcon());
		}

		if (element instanceof ShortcutNavigatorItem) {
			ShortcutNavigatorItem navigatorItem = (ShortcutNavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return super.getImage(element);
			}
			return getImage(navigatorItem.getView());
		}

		// Due to plugin.xml content will be called only for "own" views
		if (element instanceof IAdaptable) {
			View view = (View) ((IAdaptable) element).getAdapter(View.class);
			if (view != null && isOwnView(view)) {
				return getImage(view);
			}
		}

		return super.getImage(element);
	}

	/**
	* @generated
	*/
	public Image getImage(View view) {
		switch (ShortcutVisualIDRegistry.getVisualID(view)) {
		case DiagramEditPart.VISUAL_ID:
			return getImage("Navigator?Diagram?http://org.eclipse.gmf.tooling.examples.shortcut?Diagram", ShortcutElementTypes.Diagram_1000); //$NON-NLS-1$
		case DiagramNodeEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://org.eclipse.gmf.tooling.examples.shortcut?DiagramNode", ShortcutElementTypes.DiagramNode_2001); //$NON-NLS-1$
		case DiagramLinkEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://org.eclipse.gmf.tooling.examples.shortcut?DiagramLink", ShortcutElementTypes.DiagramLink_4001); //$NON-NLS-1$
		}
		return getImage("Navigator?UnknownElement", null); //$NON-NLS-1$
	}

	/**
	* @generated
	*/
	private Image getImage(String key, IElementType elementType) {
		ImageRegistry imageRegistry = ShortcutDiagramEditorPlugin.getInstance().getImageRegistry();
		Image image = imageRegistry.get(key);
		if (image == null && elementType != null && ShortcutElementTypes.isKnownElementType(elementType)) {
			image = ShortcutElementTypes.getImage(elementType);
			imageRegistry.put(key, image);
		}

		if (image == null) {
			image = imageRegistry.get("Navigator?ImageNotFound"); //$NON-NLS-1$
			imageRegistry.put(key, image);
		}
		return image;
	}

	/**
	* @generated
	*/
	public String getText(Object element) {
		if (element instanceof ShortcutNavigatorGroup) {
			ShortcutNavigatorGroup group = (ShortcutNavigatorGroup) element;
			return group.getGroupName();
		}

		if (element instanceof ShortcutNavigatorItem) {
			ShortcutNavigatorItem navigatorItem = (ShortcutNavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return null;
			}
			return getText(navigatorItem.getView());
		}

		// Due to plugin.xml content will be called only for "own" views
		if (element instanceof IAdaptable) {
			View view = (View) ((IAdaptable) element).getAdapter(View.class);
			if (view != null && isOwnView(view)) {
				return getText(view);
			}
		}

		return super.getText(element);
	}

	/**
	* @generated
	*/
	public String getText(View view) {
		if (view.getElement() != null && view.getElement().eIsProxy()) {
			return getUnresolvedDomainElementProxyText(view);
		}
		switch (ShortcutVisualIDRegistry.getVisualID(view)) {
		case DiagramEditPart.VISUAL_ID:
			return getDiagram_1000Text(view);
		case DiagramNodeEditPart.VISUAL_ID:
			return getDiagramNode_2001Text(view);
		case DiagramLinkEditPart.VISUAL_ID:
			return getDiagramLink_4001Text(view);
		}
		return getUnknownElementText(view);
	}

	/**
	* @generated
	*/
	private String getDiagram_1000Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	* @generated
	*/
	private String getDiagramNode_2001Text(View view) {
		IParser parser = ShortcutParserProvider.getParser(ShortcutElementTypes.DiagramNode_2001, view.getElement() != null ? view.getElement() : view,
				ShortcutVisualIDRegistry.getType(DiagramNodeNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			ShortcutDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getDiagramLink_4001Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	* @generated
	*/
	private String getUnknownElementText(View view) {
		return "<UnknownElement Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$  //$NON-NLS-2$
	}

	/**
	* @generated
	*/
	private String getUnresolvedDomainElementProxyText(View view) {
		return "<Unresolved domain element Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$  //$NON-NLS-2$
	}

	/**
	* @generated
	*/
	public void init(ICommonContentExtensionSite aConfig) {
	}

	/**
	* @generated
	*/
	public void restoreState(IMemento aMemento) {
	}

	/**
	* @generated
	*/
	public void saveState(IMemento aMemento) {
	}

	/**
	* @generated
	*/
	public String getDescription(Object anElement) {
		return null;
	}

	/**
	* @generated
	*/
	private boolean isOwnView(View view) {
		return DiagramEditPart.MODEL_ID.equals(ShortcutVisualIDRegistry.getModelID(view));
	}

}
