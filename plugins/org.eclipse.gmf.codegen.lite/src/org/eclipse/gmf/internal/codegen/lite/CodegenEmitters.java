/*
 * Copyright (c) 2005 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Artem Tikhomirov (Borland) - initial API and implementation
 */
package org.eclipse.gmf.internal.codegen.lite;

import java.net.URL;

import org.eclipse.emf.codegen.jet.JETCompiler;
import org.eclipse.emf.codegen.jet.JETEmitter;
import org.eclipse.emf.codegen.jet.JETException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.gmf.common.UnexpectedBehaviourException;
import org.eclipse.gmf.common.codegen.GIFEmitter;
import org.eclipse.gmf.internal.codegen.dispatch.EmitterFactory;
import org.eclipse.gmf.internal.codegen.dispatch.NoSuchTemplateException;
import org.eclipse.gmf.internal.codegen.dispatch.StaticTemplateRegistry;

import org.eclipse.gmf.codegen.templates.lite.editor.ActionBarContributorGenerator;
import org.eclipse.gmf.codegen.templates.lite.editor.BuildPropertiesGenerator;
import org.eclipse.gmf.codegen.templates.lite.editor.CreationWizardGenerator;
import org.eclipse.gmf.codegen.templates.lite.editor.CreationWizardPageGenerator;
import org.eclipse.gmf.codegen.templates.lite.editor.DiagramEditorUtilGenerator;
import org.eclipse.gmf.codegen.templates.lite.editor.EditorGenerator;
import org.eclipse.gmf.codegen.templates.lite.editor.ManifestGenerator;
import org.eclipse.gmf.codegen.templates.lite.editor.PaletteFactoryGenerator;
import org.eclipse.gmf.codegen.templates.lite.editor.PluginGenerator;
import org.eclipse.gmf.codegen.templates.lite.editor.PluginPropertiesGenerator;
import org.eclipse.gmf.codegen.templates.lite.editor.PluginXML;
import org.eclipse.gmf.codegen.templates.lite.editor.VisualIDRegistryGenerator;
import org.eclipse.gmf.codegen.templates.lite.parts.ChildNodeEditPartGenerator;
import org.eclipse.gmf.codegen.templates.lite.parts.CompartmentEditPartGenerator;
import org.eclipse.gmf.codegen.templates.lite.parts.DiagramEditPartGenerator;
import org.eclipse.gmf.codegen.templates.lite.parts.EditPartFactoryGenerator;
import org.eclipse.gmf.codegen.templates.lite.parts.LinkEditPartGenerator;
import org.eclipse.gmf.codegen.templates.lite.parts.LinkLabelEditPartGenerator;
import org.eclipse.gmf.codegen.templates.lite.parts.NodeEditPartGenerator;
import org.eclipse.gmf.codegen.templates.lite.parts.NodeLabelEditPartGenerator;
import org.eclipse.gmf.codegen.templates.lite.parts.UpdatableEditPartGenerator;
import org.eclipse.gmf.codegen.templates.lite.providers.AbstractParserGenerator;
import org.eclipse.gmf.codegen.templates.lite.providers.CompartmentViewFactoryGenerator;
import org.eclipse.gmf.codegen.templates.lite.providers.DiagramViewFactoryGenerator;
import org.eclipse.gmf.codegen.templates.lite.providers.DomainElementInitializerGenerator;
import org.eclipse.gmf.codegen.templates.lite.providers.LabelViewFactoryGenerator;
import org.eclipse.gmf.codegen.templates.lite.providers.LinkViewFactoryGenerator;
import org.eclipse.gmf.codegen.templates.lite.providers.NodeViewFactoryGenerator;
import org.eclipse.gmf.codegen.templates.lite.providers.PropertySourceProviderGenerator;
import org.osgi.framework.Bundle;

/**
 * Provides JET templates.
 * FIXME Merge with {@link org.eclipse.gmf.codegen.util.CodegenEmitters}
 * 
 * @author artem
 */
public class CodegenEmitters {

	private final EmitterFactory myFactory;

	private final String[] myTemplatePath;

	private static StaticTemplateRegistry myRegistry;

	public CodegenEmitters(boolean usePrecompiled, String templateDirectory) {
		myRegistry = initRegistry();
		String[] variables = new String[] { "org.eclipse.emf.codegen", "org.eclipse.emf.codegen.ecore", "org.eclipse.emf.common", "org.eclipse.emf.ecore", "org.eclipse.gmf.common",
				"org.eclipse.gmf.codegen" };
		myTemplatePath = new String[] {
				usePrecompiled ? null : templateDirectory != null && templateDirectory.indexOf(":") == -1 ? URI.createPlatformResourceURI(templateDirectory).toString() : templateDirectory,
				getTemplatesBundle().getEntry("/templates/").toString() };
		myFactory = new EmitterFactory(getTemplatePath(), myRegistry, usePrecompiled, variables, true);
	}

	private static StaticTemplateRegistry initRegistry() {
		final StaticTemplateRegistry tr = new StaticTemplateRegistry(CodegenEmitters.class.getClassLoader());
		put(tr, "/providers/CompartmentViewFactory.javajet", CompartmentViewFactoryGenerator.class);
		put(tr, "/providers/DiagramViewFactory.javajet", DiagramViewFactoryGenerator.class);
		put(tr, "/providers/LabelViewFactory.javajet", LabelViewFactoryGenerator.class);
		put(tr, "/providers/LinkViewFactory.javajet", LinkViewFactoryGenerator.class);
		put(tr, "/providers/NodeViewFactory.javajet", NodeViewFactoryGenerator.class);
		put(tr, "/parts/CompartmentEditPart.javajet", CompartmentEditPartGenerator.class);
		put(tr, "/editor/CreationWizard.javajet", CreationWizardGenerator.class);
		put(tr, "/editor/CreationWizardPage.javajet", CreationWizardPageGenerator.class);
		put(tr, "/editor/DiagramEditorUtil.javajet", DiagramEditorUtilGenerator.class);
		// put(tr, "/editor/MatchingStrategy.javajet",
		// MatchingStrategyGenerator.class);
		put(tr, "/editor/PaletteFactory.javajet", PaletteFactoryGenerator.class);
		put(tr, "/editor/VisualIDRegistry.javajet", VisualIDRegistryGenerator.class);
		put(tr, "/parts/DiagramEditPart.javajet", DiagramEditPartGenerator.class);
		put(tr, "/parts/EditPartFactory.javajet", EditPartFactoryGenerator.class);
		put(tr, "/parts/IUpdatableEditPart.javajet", UpdatableEditPartGenerator.class);
		put(tr, "/providers/AbstractParser.javajet", AbstractParserGenerator.class);
		put(tr, "/providers/DomainElementInitializer.javajet", DomainElementInitializerGenerator.class);
		put(tr, "/providers/PropertySourceProvider.javajet", PropertySourceProviderGenerator.class);
		put(tr, "/editor/ActionBarContributor.javajet", ActionBarContributorGenerator.class);
		put(tr, "/editor/Editor.javajet", EditorGenerator.class);
		put(tr, "/parts/LinkEditPart.javajet", LinkEditPartGenerator.class);
		put(tr, "/parts/LinkLabelEditPart.javajet", LinkLabelEditPartGenerator.class);
		put(tr, "/parts/ChildNodeEditPart.javajet", ChildNodeEditPartGenerator.class);
		put(tr, "/parts/NodeEditPart.javajet", NodeEditPartGenerator.class);
		put(tr, "/parts/NodeLabelEditPart.javajet", NodeLabelEditPartGenerator.class);
		put(tr, "/editor/Plugin.javajet", PluginGenerator.class);
		// put(tr, "/editor/ModelCreationFactory.javajet", ModelCreationFactoryGenerator.class);
		put(tr, "/editor/manifest.mfjet", ManifestGenerator.class);
		put(tr, "/editor/build.propertiesjet", BuildPropertiesGenerator.class);
		put(tr, "/editor/plugin.xmljet", PluginXML.class);
		put(tr, "/editor/plugin.propertiesjet", PluginPropertiesGenerator.class);
		return tr;
	}

	public JETEmitter getCompartmentViewFactoryGenerator() throws UnexpectedBehaviourException {
		return retrieve(CompartmentViewFactoryGenerator.class);
	}

	public JETEmitter getDiagramViewFactoryGenerator() throws UnexpectedBehaviourException {
		return retrieve(DiagramViewFactoryGenerator.class);
	}

	public JETEmitter getLabelViewFactoryGenerator() throws UnexpectedBehaviourException {
		return retrieve(LabelViewFactoryGenerator.class);
	}

	public JETEmitter getLinkViewFactoryGenerator() throws UnexpectedBehaviourException {
		return retrieve(LinkViewFactoryGenerator.class);
	}

	public JETEmitter getNodeViewFactoryGenerator() throws UnexpectedBehaviourException {
		return retrieve(NodeViewFactoryGenerator.class);
	}

	public JETEmitter getAbstractParserGenerator() throws UnexpectedBehaviourException {
		return retrieve(AbstractParserGenerator.class);
	}

	public JETEmitter getDomainElementInitializerGenerator() throws UnexpectedBehaviourException {
		return retrieve(DomainElementInitializerGenerator.class);
	}

	public JETEmitter getPropertySourceProviderGenerator() throws UnexpectedBehaviourException {
		return retrieve(PropertySourceProviderGenerator.class);
	}

	public JETEmitter getCompartmentEditPartGenerator() throws UnexpectedBehaviourException {
		return retrieve(CompartmentEditPartGenerator.class);
	}

	public JETEmitter getDiagramEditPartGenerator() throws UnexpectedBehaviourException {
		return retrieve(DiagramEditPartGenerator.class);
	}

	public JETEmitter getEditPartFactoryGenerator() throws UnexpectedBehaviourException {
		return retrieve(EditPartFactoryGenerator.class);
	}

	public JETEmitter getUpdatableEditPartGenerator() throws UnexpectedBehaviourException {
		return retrieve(UpdatableEditPartGenerator.class);
	}

	public JETEmitter getLinkEditPartGenerator() throws UnexpectedBehaviourException {
		return retrieve(LinkEditPartGenerator.class);
	}

	public JETEmitter getLinkLabelEditPartGenerator() throws UnexpectedBehaviourException {
		return retrieve(LinkLabelEditPartGenerator.class);
	}

	public JETEmitter getChildNodeEditPartGenerator() throws UnexpectedBehaviourException {
		return retrieve(ChildNodeEditPartGenerator.class);
	}

	public JETEmitter getNodeEditPartGenerator() throws UnexpectedBehaviourException {
		return retrieve(NodeEditPartGenerator.class);
	}

	public JETEmitter getNodeLabelEditPartGenerator() throws UnexpectedBehaviourException {
		return retrieve(NodeLabelEditPartGenerator.class);
	}

	public JETEmitter getPluginGenerator() throws UnexpectedBehaviourException {
		return retrieve(PluginGenerator.class);
	}

	public JETEmitter getActionBarContributorGenerator() throws UnexpectedBehaviourException {
		return retrieve(ActionBarContributorGenerator.class);
	}

	public JETEmitter getEditorGenerator() throws UnexpectedBehaviourException {
		return retrieve(EditorGenerator.class);
	}

	public JETEmitter getCreationWizardGenerator() throws UnexpectedBehaviourException {
		return retrieve(CreationWizardGenerator.class);
	}

	public JETEmitter getCreationWizardPageGenerator() throws UnexpectedBehaviourException {
		return retrieve(CreationWizardPageGenerator.class);
	}

	public JETEmitter getDiagramEditorUtilGenerator() throws UnexpectedBehaviourException {
		return retrieve(DiagramEditorUtilGenerator.class);
	}

	public JETEmitter getPaletteFactoryGenerator() throws UnexpectedBehaviourException {
		return retrieve(PaletteFactoryGenerator.class);
	}

	public JETEmitter getVisualIDRegistryGenerator() throws UnexpectedBehaviourException {
		return retrieve(VisualIDRegistryGenerator.class);
	}

	public JETEmitter getManifestGenerator() throws UnexpectedBehaviourException {
		return retrieve(ManifestGenerator.class);
	}

	public JETEmitter getBuildPropertiesGenerator() throws UnexpectedBehaviourException {
		return retrieve(BuildPropertiesGenerator.class);
	}

	public JETEmitter getPluginXML() throws UnexpectedBehaviourException {
		return retrieve(PluginXML.class);
	}

	public JETEmitter getPluginPropertiesGenerator() throws UnexpectedBehaviourException {
		return retrieve(PluginPropertiesGenerator.class);
	}

	/**
	 * @see #retrieve(Class)
	 */
	private static void put(StaticTemplateRegistry tr, String path, Class precompiledTemplate) {
		tr.put(precompiledTemplate, path, precompiledTemplate);
	}

	/**
	 * depends on {@link #put(StaticTemplateRegistry, String, Class) } impl -
	 * class object of precompiled template serves as a key
	 */
	private JETEmitter retrieve(Class key) throws UnexpectedBehaviourException {
		try {
			return myFactory.acquireEmitter(key);
		} catch (NoSuchTemplateException ex) {
			throw new UnexpectedBehaviourException(ex.getMessage(), ex);
		}
	}

	private String[] getTemplatePath() {
		return myTemplatePath;
	}

	private static Bundle getTemplatesBundle() {
		return Activator.getDefault();
	}

	public URL getJMergeControlFile() {
		return getTemplatesBundle().getEntry("/templates/emf-merge.xml");
	}

	public GIFEmitter getShortcutImageEmitter() throws JETException {
		String templateLocation = JETCompiler.find(getTemplatePath(), "/editor/shortcut.gif");
		if (templateLocation == null) {
			throw new JETException("shortcut image template not found");
		}
		return new GIFEmitter(templateLocation);
	}
}
