/*
 * Copyright (c) 2006 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Michael Golubev (Borland) - initial API and implementation
 */
package org.eclipse.gmf.internal.graphdef.codegen.ui;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.MessageFormat;
import java.util.Collections;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.jar.Manifest;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.gmf.gmfgraph.Figure;
import org.eclipse.gmf.gmfgraph.FigureGallery;
import org.eclipse.gmf.gmfgraph.util.RuntimeFQNSwitch;
import org.eclipse.gmf.graphdef.codegen.StandaloneGenerator;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.osgi.util.ManifestElement;
import org.eclipse.pde.core.plugin.IPluginImport;
import org.eclipse.pde.core.plugin.IPluginModel;
import org.eclipse.pde.core.plugin.IPluginReference;
import org.eclipse.pde.ui.IFieldData;
import org.eclipse.pde.ui.templates.OptionTemplateSection;
import org.eclipse.pde.ui.templates.TemplateOption;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleException;
import org.osgi.framework.Constants;

public class ConverterSection extends OptionTemplateSection {
	private static final String MY_PLUGIN_ID = "org.eclipse.gmf.graphdef.codegen.ui";
	private static final String SECTION_ID = "org.eclipse.gmf.graphdef.codegen.ui.ConverterSection";
	private static final int THE_ONLY_PAGE_INDEX = 0;
	
	public static final String OPTION_MAIN_PACKAGE_NAME = SECTION_ID + ".mainPackageName";
	public static final String OPTION_NEEDS_MAP_MODE = SECTION_ID + ".needsMapMode";
	public static final String OPTION_INPUT_RESOURCE_FULL_PATH = SECTION_ID + ".inputResource";
	public static final String OPTION_OUTPUT_RESOURCE_FULL_PATH = SECTION_ID + ".outputResource";
	
	private TemplateOption myPackageNameOption;
	private FileNameOption myInputPathOption;
	private FileNameOption myOutputGalleryPathOption;
	private final CachedInputValidationState myCachedInputValidationState;
	private ManifestElement[] myRequiredBundles;
	
	public ConverterSection(){
		setPageCount(THE_ONLY_PAGE_INDEX + 1);
		myPackageNameOption = addOption(OPTION_MAIN_PACKAGE_NAME, "Generate figures package", null, THE_ONLY_PAGE_INDEX);
		myInputPathOption = addFileNameOption(false, OPTION_INPUT_RESOURCE_FULL_PATH, "Input GMFGraph instance", "", THE_ONLY_PAGE_INDEX);
		myOutputGalleryPathOption = addFileNameOption(true, OPTION_OUTPUT_RESOURCE_FULL_PATH, "Create Figure Gallery", "", THE_ONLY_PAGE_INDEX);
		myOutputGalleryPathOption.setRequired(false);
		addOption(OPTION_NEEDS_MAP_MODE, "Use IMapMode", false, THE_ONLY_PAGE_INDEX);
		myCachedInputValidationState = new CachedInputValidationState();
	}
	
	public void addPages(Wizard wizard) {
		super.addPages(wizard);
		WizardPage page = createPage(THE_ONLY_PAGE_INDEX);
		page.setDescription("ConverterSection.description");
		page.setTitle("ConverterSection.title");
		wizard.addPage(page);
		markPagesAdded();
		validateOptions(myPackageNameOption);
		validateOptions(myInputPathOption);
		validateOptions(myOutputGalleryPathOption);
	}

	public IPluginReference[] getDependencies(String schemaVersion) {
		// no explicit dependencies
		return new IPluginReference[0];
	}

	protected void generateFiles(IProgressMonitor monitor) throws CoreException {
		Resource resource = loadResource(myInputPathOption.getText());
		FigureGallery[] figures = findFigures(resource);
		assert figures.length == 1 : "FIXME update generator to support multiple galleries"; 
		StandaloneGenerator.Config config = new StandaloneGeneratorConfigAdapter(this);
		StandaloneGenerator generator = new StandaloneGenerator(figures[0], config, new RuntimeFQNSwitch());
		generator.setSkipPluginStructure(false);
		try {
			generator.run(new SubProgressMonitor(monitor, 1));
			readRequiredBundles();
			// XXX readBuildProperties() and use getNewFiles to propagate
			// XXX readPluginProperties(), use ??? 
		} catch (InterruptedException e) {
			String message = e.getMessage();
			if (message == null){
				message = "Interrupted";
			}
			throw new CoreException(new Status(IStatus.ERROR, MY_PLUGIN_ID, 0, message, e)); 
		} catch (IOException ex) {
			// perhaps, don't need to treat this as error? 
			throw new CoreException(new Status(IStatus.ERROR, MY_PLUGIN_ID, 0, "Failed to read generated manifest.mf", ex));
		} finally {
			resource.unload();
		}
		if (!generator.getRunStatus().isOK()){
			throw new CoreException(generator.getRunStatus());
		}
		createFigureGallery(generator.getGenerationInfo());
	}
	
	private void createFigureGallery(StandaloneGenerator.GenerationInfo info) throws CoreException {
		if (!myOutputGalleryPathOption.isEmpty()){
			String path = myOutputGalleryPathOption.getText();
			Resource galleryResource = new ResourceSetImpl().createResource(URI.createFileURI(path));
			galleryResource.getContents().add(new StandaloneGalleryConverter().convertFigureGallery(info));
			try {
				galleryResource.save(null);
			} catch (IOException e) {
				throw new CoreException(new Status(//
						IStatus.ERROR, MY_PLUGIN_ID, 0, e.getMessage(), e
				));
			}
		}
	}
	
	private void readRequiredBundles() throws CoreException, IOException {
		try {
			IFile f = findGeneratedManifest();
			if (f == null || !f.exists()) {
				// fail - we do expect manifest to be there?
				return;
			}
			InputStream is = f.getContents(); 
			String requiredBundles = new Manifest(is).getMainAttributes().getValue(Constants.REQUIRE_BUNDLE);
			is.close();
			myRequiredBundles = ManifestElement.parseHeader(Constants.REQUIRE_BUNDLE, requiredBundles);
		} catch (BundleException ex) {
			throw new IOException(ex.getMessage());
		}
	}

	private IFile findGeneratedManifest() {
		return (IFile) project.findMember(new Path("META-INF/MANIFEST.MF"));
	}

	private FigureGallery[] findFigures(Resource resource) {
		return new FigureFinder().findFigures(resource);
	}

	public String getPluginActivatorClassFQN(){
		return model instanceof IPluginModel ? ((IPluginModel)model).getPlugin().getClassName() : null;
	}
	
	public String getPluginFriendlyName(){
		return model.getPluginBase().getName();
	}
	
	public String getPluginID(){
		return model.getPluginBase().getId();
	}
	
	public String getPluginProviderName() {
		return model.getPluginBase().getProviderName();
	}

	protected URL getInstallURL() {
		return getContributingBundle().getEntry("/");
	}

	public String getSectionId() {
		return SECTION_ID;
	}

	public void validateOptions(TemplateOption changed) {
		if (OPTION_NEEDS_MAP_MODE.equals(changed)){
			//does not affect state
			return;
		}
		if (!validatePackageName()){
			return;
		}
		if (!validateInputPath()){
			return;
		}
		if (!validateOutputGalleryPath()){
			return;
		}
		resetPageState();
	}

	public boolean isDependentOnParentWizard() {
		return true;
	}

	protected void initializeFields(IFieldData data) {
		super.initializeFields(data);
		String packageName = getFormattedPackageName(data.getId());
		initializeOption(OPTION_MAIN_PACKAGE_NAME, packageName);
	}

	protected ResourceBundle getPluginResourceBundle() {
		return Platform.getResourceBundle(getContributingBundle());
	}

	protected void updateModel(IProgressMonitor monitor) throws CoreException {
		if (myRequiredBundles == null) {
			return;
		}
		for (int i = 0; i < myRequiredBundles.length; i++) {
			// take first component, ignore any attributes or directives 
			addImport(myRequiredBundles[i].getValueComponents()[0]);
		}
	}
	
	private void addImport(String importedPluginId) throws CoreException {
		IPluginImport pluginImport = model.getPluginFactory().createImport();
		pluginImport.setId(importedPluginId);
		model.getPluginBase().add(pluginImport);
	}

	public String[] getNewFiles() {
		return new String[0];
	}

	public String getUsedExtensionPoint() {
		return null;
	}
	
	private Bundle getContributingBundle(){
		return Platform.getBundle(MY_PLUGIN_ID);
	}
	
	/**
	 * Stolen from PDETemplateSection, which can not be reused due to export limitations.
	 */
	private String getFormattedPackageName(String id){
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < id.length(); i++) {
			char ch = id.charAt(i);
			if (buffer.length() == 0) {
				if (Character.isJavaIdentifierStart(ch))
					buffer.append(Character.toLowerCase(ch));
			} else {
				if (Character.isJavaIdentifierPart(ch) || ch == '.')
					buffer.append(ch);
			}
		}
		return buffer.toString().toLowerCase(Locale.ENGLISH);
	}

	private FileNameOption addFileNameOption(boolean saveNotLoad, String name, String label, String value, int pageIndex) {
		FileNameOption result = new FileNameOption(this, name, label, new String[] {"*.gmfgraph"});
		result.setSaveNotLoad(saveNotLoad);
		registerOption(result, value, pageIndex);
		return result;
	}
	
	private boolean validatePackageName(){
		boolean isValid = !myPackageNameOption.isEmpty();
		if (!isValid){
			flagMissingRequiredOption(myPackageNameOption);
		}
		return isValid;
	}
	
	private boolean validateInputPath() {
		if (myInputPathOption.isEmpty()){
			flagMissingRequiredOption(myInputPathOption);
			return false;
		}
		String path = myInputPathOption.getText();
		myCachedInputValidationState.updateInput(path);
		if (!myCachedInputValidationState.isValid()){
			getTheOnlyPage().setPageComplete(false);
			getTheOnlyPage().setErrorMessage(myCachedInputValidationState.getErrorMessage());
			return false;
		}
		return true;
	}
	
	private boolean validateOutputGalleryPath() {
		if (myOutputGalleryPathOption.isEmpty()){
			//optional -- ok
			return true;
		}
		String path = myOutputGalleryPathOption.getText();
		try {
			URI.createFileURI(path);
		} catch (IllegalArgumentException e){
			String message = MessageFormat.format("Path {0} is invalid", new Object[] {path});
			getTheOnlyPage().setPageComplete(false);
			getTheOnlyPage().setErrorMessage(message);
			return false;
		}
		return true;
	}

	private WizardPage getTheOnlyPage() {
		return getPage(THE_ONLY_PAGE_INDEX);
	}
	
	private static Resource loadResource(String path){
		Resource resource = new ResourceSetImpl().createResource(URI.createFileURI(path));
		try {
			resource.load(Collections.EMPTY_MAP);
			return resource;
		} catch (IOException e) {
			return null;
		}
	}
	
	private static class CachedInputValidationState {
		private String myCachedPath;
		private boolean myCachedIsValid;
		private String myCachedErrorMessage;
		
		public void updateInput(String path){
			if (myCachedPath == null || !myCachedPath.equals(path)){
				myCachedIsValid = validateInputPath(path); 
			}
		}
		
		public boolean isValid(){
			return myCachedIsValid;
		}
		
		public String getErrorMessage(){
			return myCachedErrorMessage;
		}
		
		private boolean hasAtLeastOneFigure(Resource resource){
			for (TreeIterator contents = resource.getAllContents(); contents.hasNext();){
				EObject next = (EObject) contents.next();
				if (next instanceof Figure){
					return true;
				}
			}
			return false;
		}
		
		private boolean validateInputPath(String path) {
			myCachedErrorMessage = null;
			if (path == null || !new File(path).exists()){
				myCachedErrorMessage = MessageFormat.format("Can not find file {0}", new Object[] {path});
				return false;
			}
			
			Resource resource = loadResource(path);
			boolean isValid = resource != null && hasAtLeastOneFigure(resource);
			if (resource != null){
				resource.unload();
			}
			if (!isValid){
				myCachedErrorMessage = MessageFormat.format("File {0} does not contain any figure definitions", new Object[] {path});
				return false;
			}
			return true;
		}

	}
}
