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
package org.eclipse.gmf.tests.setup;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import junit.framework.Assert;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.generator.GenBaseGeneratorAdapter;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.gmf.internal.common.codegen.GeneratorBase;
import org.eclipse.gmf.tests.CompileUtil;
import org.eclipse.gmf.tests.Plugin;
import org.eclipse.gmf.tests.setup.GeneratorConfiguration;

/**
 * Generates and (by default) compiles gmf plugins.
 * @author artem
 */
public class GenProjectBaseSetup {
	private final Set projectsToInit = new LinkedHashSet(); 
	private CompileUtil compileUtil;
	private GeneratorConfiguration myGeneratorFactory;

	public GenProjectBaseSetup(GeneratorConfiguration generatorFactory) {
		myGeneratorFactory = generatorFactory;
	}

	public void generateAndCompile(RuntimeWorkspaceSetup rtWorkspace, DiaGenSource diaGenSource) throws Exception {
		rtWorkspace.ensureJava14();

		projectsToInit.clear(); // just in case
		compileUtil = new CompileUtil();
		final GenDiagram d = diaGenSource.getGenDiagram();
		final GenModel domainGenModel = d.getEditorGen().getDomainGenModel();
		domainGenModel.setCanGenerate(true);
		org.eclipse.emf.codegen.ecore.generator.Generator gen = new org.eclipse.emf.codegen.ecore.generator.Generator();
        gen.setInput(domainGenModel);
        gen.generate(domainGenModel, GenBaseGeneratorAdapter.MODEL_PROJECT_TYPE, new BasicMonitor());
		projectsToInit.add(domainGenModel.getModelPluginID());
        gen.generate(domainGenModel, GenBaseGeneratorAdapter.EDIT_PROJECT_TYPE, new BasicMonitor());
		projectsToInit.add(domainGenModel.getEditPluginID());
		
		GeneratorBase generator = myGeneratorFactory.createGenerator(d);
		generator.run();
		hookGeneratorStatus(generator.getRunStatus());
		final String gmfEditorId = d.getEditorGen().getPlugin().getID();
		rtWorkspace.updateClassPath(ResourcesPlugin.getWorkspace().getRoot().getProject(gmfEditorId));
		
		projectsToInit.add(gmfEditorId);
		for (Iterator it = projectsToInit.iterator(); it.hasNext();) {
			String pluginID = (String) it.next();
			IProject p = ResourcesPlugin.getWorkspace().getRoot().getProject(pluginID);
			hookProjectBuild(p);
		}
		compileUtil = null;
	}

	public List/*<String>*/ getGeneratedProjectNames() {
		return Collections.unmodifiableList(new LinkedList(projectsToInit));
	}

	protected void hookProjectBuild(IProject p) throws Exception {
		IStatus s = compileUtil.build(p);
		if (!s.isOK()) {
			Plugin.logError(s.getMessage());
			Assert.fail(s.getMessage());
		}
	}

	protected void hookGeneratorStatus(IStatus generatorStatus) {
		if (!generatorStatus.isOK()) {
			Plugin.getInstance().getLog().log(generatorStatus);
		}
		if (generatorStatus.getSeverity() == IStatus.ERROR) {
			Assert.fail("GMF editor generation produced errors:" + generatorStatus.getMessage()); //$NON-NLS-1$
		}
	}
}
