/*
 *  Copyright (c) 2006, 2007 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 */
package org.eclipse.gmf.examples.taipan.gmf.editor.part;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.edit.provider.IWrapperItemProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

/**
 * Wizard page that allows to select element from model.
 * 
 * @generated
 */
public class ModelElementSelectionPage extends WizardPage {

	/**
	 * @generated
	 */
	protected EObject selectedModelElement;

	/**
	 * @generated
	 */
	private TreeViewer modelVewer;

	/**
	 * @generated
	 */
	public ModelElementSelectionPage(String pageName) {
		super(pageName);
	}

	/**
	 * @generated
	 */
	public EObject getModelElement() {
		return selectedModelElement;
	}

	/**
	 * @generated
	 */
	public void setModelElement(EObject modelElement) {
		selectedModelElement = modelElement;
		if (modelVewer != null) {
			if (selectedModelElement != null) {
				modelVewer.setInput(selectedModelElement.eResource());
				modelVewer.setSelection(new StructuredSelection(selectedModelElement));
			} else {
				modelVewer.setInput(null);
			}
			setPageComplete(validatePage());
		}
	}

	/**
	 * @generated
	 */
	public void createControl(Composite parent) {
		initializeDialogUnits(parent);

		Composite plate = new Composite(parent, SWT.NONE);
		plate.setLayoutData(new GridData(GridData.FILL_BOTH));
		GridLayout layout = new GridLayout();
		layout.marginWidth = 0;
		plate.setLayout(layout);
		setControl(plate);

		Label label = new Label(plate, SWT.NONE);
		label.setText(getSelectionTitle());
		label.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING));

		modelVewer = new TreeViewer(plate, SWT.SINGLE | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
		GridData layoutData = new GridData(GridData.FILL_BOTH);
		layoutData.heightHint = 300;
		layoutData.widthHint = 300;
		modelVewer.getTree().setLayoutData(layoutData);
		modelVewer.setContentProvider(new AdapterFactoryContentProvider(TaiPanDiagramEditorPlugin.getInstance().getItemProvidersAdapterFactory()));
		modelVewer.setLabelProvider(new AdapterFactoryLabelProvider(TaiPanDiagramEditorPlugin.getInstance().getItemProvidersAdapterFactory()));
		if (selectedModelElement != null) {
			modelVewer.setInput(selectedModelElement.eResource());
			modelVewer.setSelection(new StructuredSelection(selectedModelElement));
		}
		modelVewer.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				ModelElementSelectionPage.this.updateSelection((IStructuredSelection) event.getSelection());
			}
		});

		setPageComplete(validatePage());
	}

	/**
	 * Override to provide custom model element description.
	 * 
	 * @generated
	 */
	protected String getSelectionTitle() {
		return "Select model element:";
	}

	/**
	 * @generated
	 */
	protected void updateSelection(IStructuredSelection selection) {
		selectedModelElement = null;
		if (selection.size() == 1) {
			Object selectedElement = selection.getFirstElement();
			if (selectedElement instanceof IWrapperItemProvider) {
				selectedElement = ((IWrapperItemProvider) selectedElement).getValue();
			}
			if (selectedElement instanceof FeatureMap.Entry) {
				selectedElement = ((FeatureMap.Entry) selectedElement).getValue();
			}
			if (selectedElement instanceof EObject) {
				selectedModelElement = (EObject) selectedElement;
			}
		}
		setPageComplete(validatePage());
	}

	/**
	 * Override to provide specific validation of the selected model element.
	 * 
	 * @generated
	 */
	protected boolean validatePage() {
		return true;
	}
}
