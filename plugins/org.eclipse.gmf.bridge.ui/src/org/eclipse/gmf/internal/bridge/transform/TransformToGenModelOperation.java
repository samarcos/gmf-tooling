/**
 * Copyright (c) 2006 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alexander Fedorov (Borland) - initial API and implementation
 */
package org.eclipse.gmf.internal.bridge.transform;

import java.io.IOException;
import java.net.URL;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator;
import org.eclipse.gmf.gmfgraph.util.FigureQualifiedNameSwitch;
import org.eclipse.gmf.gmfgraph.util.RuntimeFQNSwitch;
import org.eclipse.gmf.gmfgraph.util.RuntimeLiteFQNSwitch;
import org.eclipse.gmf.graphdef.codegen.MapModeCodeGenStrategy;
import org.eclipse.gmf.internal.bridge.VisualIdentifierDispenser;
import org.eclipse.gmf.internal.bridge.genmodel.BasicDiagramRunTimeModelHelper;
import org.eclipse.gmf.internal.bridge.genmodel.DiagramGenModelTransformer;
import org.eclipse.gmf.internal.bridge.genmodel.DiagramRunTimeModelHelper;
import org.eclipse.gmf.internal.bridge.genmodel.GenModelProducer;
import org.eclipse.gmf.internal.bridge.genmodel.InnerClassViewmapProducer;
import org.eclipse.gmf.internal.bridge.genmodel.ViewmapProducer;
import org.eclipse.gmf.internal.bridge.naming.gen.GenModelNamingMediatorImpl;
import org.eclipse.gmf.internal.bridge.ui.Plugin;
import org.eclipse.gmf.internal.common.migrate.ModelLoadHelper;
import org.eclipse.gmf.internal.common.reconcile.Reconciler;
import org.eclipse.gmf.internal.util.GMFGenConfig;
import org.eclipse.gmf.mappings.Mapping;


public class TransformToGenModelOperation {
	
	private URI myGMFGenModelURI;
	private TransformOptions myOptions;
	private Mapping myMapping;
	private GenModelDetector myGMDetector;
	private GenModel myGenModel;
	
	private IStatus myLoadMapmodelStatus = Status.CANCEL_STATUS;
	private IStatus myStaleGenmodelStatus = Status.CANCEL_STATUS;
	
	public TransformToGenModelOperation() {
		this.myOptions = new TransformOptions();
	}

	public TransformOptions getOptions() {
		return myOptions;
	}
	
	public URI getGenURI() {
		return this.myGMFGenModelURI;
	}

	public void setGenURI(URI gmfGen) {
		this.myGMFGenModelURI = gmfGen;
	}

	public GenModel getGenModel() {
		return this.myGenModel;
	}

	Mapping getMapping() {
		return this.myMapping;
	}
	
	private void setMapping(Mapping m, IStatus loadStatus) {
		this.myMapping = m;
		this.myLoadMapmodelStatus = loadStatus;
		myGMDetector = (m != null) ? new GenModelDetector(m) : null;
		myGenModel = null;
	}
	
	public GenModelDetector getGenModelDetector() {
		return myGMDetector;
	}
	
	public IStatus getLoadMappingStatus() {
		return this.myLoadMapmodelStatus;
	}
	
	public IStatus getStaleGenmodelStatus() {
		return this.myStaleGenmodelStatus;
	}

	public Mapping loadMappingModel(ResourceSet rs, URI uri, IProgressMonitor pm) throws CoreException {
		Mapping content = null;
		IStatus status = Status.CANCEL_STATUS;
		IProgressMonitor monitor = null;
		try {
			checkResourceSet(rs);
			if (uri == null) {
				throw new IllegalArgumentException(Messages.TransformToGenModelOperation_e_null_map_uri);
			}
			monitor = (pm != null) ? new SubProgressMonitor(pm, 1, SubProgressMonitor.PREPEND_MAIN_LABEL_TO_SUBTASK) : new NullProgressMonitor(); 
			String cancelMessage = Messages.TransformToGenModelOperation_e_map_load_cancelled;
			monitor.beginTask("", 100); //$NON-NLS-1$
			subTask(monitor, 0, Messages.TransformToGenModelOperation_task_load, cancelMessage);
			ModelLoadHelper loadHelper = new ModelLoadHelper(rs, uri);
			status = loadHelper.getStatus();
			if (!status.isOK()) {
				throw new CoreException(status);
			}
			subTask(monitor, 20, Messages.TransformToGenModelOperation_task_validate, cancelMessage);
			EObject root = loadHelper.getContentsRoot();
			if (!(root instanceof Mapping)) {
				String msg = MessageFormat.format(Messages.TransformToGenModelOperation_e_wrong_root_element, root.getClass().getName());
				status = Plugin.createError(msg, null);
				throw new CoreException(status);
			}
			content = (Mapping) loadHelper.getContentsRoot();
			Diagnostic mapIsValid = ValidationHelper.validate(content, true, monitor);
			monitor.worked(60);
			status = getFirst(mapIsValid);
			if (Diagnostic.CANCEL == status.getSeverity()) {
				throw new CoreException(Plugin.createCancel(cancelMessage));
			} else if(Diagnostic.ERROR == status.getSeverity()) {
				throw new CoreException(status);
			} else {
				return content;
			}
		} catch (CoreException e) {
			throw e;
		} catch (Exception e) {
			IStatus error = Plugin.createError(Messages.TransformToGenModelOperation_e_load_mapping_model, e);
			throw new CoreException(error);
		} finally {
			setMapping(content, status);
			if (monitor != null) {
				monitor.done();
			}
		}
	}
	
	public GenModel findGenmodel(ResourceSet rs) throws CoreException {
		try {
			checkResourceSet(rs);
			checkMapping();
			GenModelDetector gmd = getGenModelDetector();
			IStatus detect = gmd.detect();
			if (detect.isOK()) {
				GenModel genModel = gmd.get(rs);
				this.myGenModel = genModel;
				return genModel;
			}
			throw new CoreException(detect);
		} catch (Exception e) {
			IStatus error = Plugin.createError(Messages.TransformToGenModelOperation_e_mapping_invalid, e);
			throw new CoreException(error);
		}
	}

	public GenModel loadGenModel(ResourceSet rs, URI uri, IProgressMonitor pm) throws CoreException {
		IProgressMonitor monitor = null;
		try {
			checkResourceSet(rs);
			checkMapping();
			monitor = (pm != null) ? new SubProgressMonitor(pm, 1, SubProgressMonitor.PREPEND_MAIN_LABEL_TO_SUBTASK) : new NullProgressMonitor(); 
			String cancelMessage = Messages.TransformToGenModelOperation_e_genmodel_load_cancelled;
			monitor.beginTask("", 100); //$NON-NLS-1$
			monitor.subTask(Messages.TransformToGenModelOperation_task_detect);
			GenModelDetector gmd = getGenModelDetector();
			IStatus status = Status.OK_STATUS;
			if (uri == null) {
				status = gmd.detect();
			} else {
				status = gmd.advise(uri); 
			}
			if (!status.isOK()) {
				throw new CoreException(status);
			}
			subTask(monitor, 30, Messages.TransformToGenModelOperation_task_load, cancelMessage);
			GenModel genModel = gmd.get(rs);
			if (genModel == null) {
				if (uri == null) {
					this.myStaleGenmodelStatus = Status.CANCEL_STATUS;
					this.myGenModel = null;
					return null;
				}
				IStatus notFound = Plugin.createError(Messages.GenModelDetector_e_not_found, null);
				throw new CoreException(notFound);
			}
			subTask(monitor, 40, Messages.TransformToGenModelOperation_task_validate, cancelMessage);
			StaleGenModelDetector staleDetector = new StaleGenModelDetector(genModel);
			IStatus stale = staleDetector.detect();
			this.myGenModel = genModel;
			this.myStaleGenmodelStatus = stale;
			return genModel;

		} catch (CoreException e) {
			throw e;
		} catch (Exception e) {
			IStatus error = Plugin.createError(Messages.TransformToGenModelOperation_e_genmodel_load, e);
			throw new CoreException(error);
		} finally {
			if (monitor != null) {
				monitor.done();
			}
		}
	}
	
	public IStatus executeTransformation(ResourceSet rs, IProgressMonitor pm) {
		IProgressMonitor monitor = null;
		try {
			checkResourceSet(rs);
			if (getGenURI() == null) {
				throw new IllegalStateException(Messages.TransformToGenModelOperation_e_null_gmfgen_uri);
			}
			checkMapping();
			monitor = (pm != null) ? new SubProgressMonitor(pm, 1, SubProgressMonitor.PREPEND_MAIN_LABEL_TO_SUBTASK) : new NullProgressMonitor(); 
			monitor.beginTask("", 100); //$NON-NLS-1$
			if (monitor.isCanceled()) {
				return Status.CANCEL_STATUS;
			}
			final DiagramRunTimeModelHelper drtModelHelper = detectRunTimeModel();
			final ViewmapProducer viewmapProducer = detectTransformationOptions();
			final VisualIdentifierDispenserProvider idDispenser = getVisualIdDispenser();
			idDispenser.acquire();

			GenModelProducer t = createGenModelProducer(getGenModel(), drtModelHelper, viewmapProducer, idDispenser.get());

			monitor.subTask(Messages.TransformToGenModelOperation_task_generate);
			GenEditorGenerator genEditor = t.process(getMapping(), new SubProgressMonitor(monitor, 20));
			if (monitor.isCanceled()) {
				return Status.CANCEL_STATUS;
			}
			monitor.subTask(Messages.TransformToGenModelOperation_task_reconcile);
			if (Plugin.needsReconcile()) {
				reconcile(rs, genEditor);
			}
			monitor.worked(20);
			if (monitor.isCanceled()) {
				return Status.CANCEL_STATUS;
			}
			monitor.subTask(Messages.TransformToGenModelOperation_task_save);
			save(rs, genEditor);
			monitor.worked(20);
			if (monitor.isCanceled()) {
				return Status.CANCEL_STATUS;
			}
			monitor.subTask(Messages.TransformToGenModelOperation_task_validate);
			IStatus validate = validate(genEditor, monitor);
			if (IStatus.CANCEL != validate.getSeverity()) {
				idDispenser.release();
			}
			return validate;
			
		} catch (Exception ex) {
			return Plugin.createError(ex.getMessage(), ex);
		} finally {
			if (monitor != null) {
				monitor.done();
			}
		}
	}

	private void checkResourceSet(ResourceSet rs) {
		if (rs == null) {
			throw new IllegalArgumentException(Messages.TransformToGenModelOperation_e_null_resource_set);
		}
	}

	private void checkMapping() {
		if (getMapping() == null) {
			throw new IllegalStateException(Messages.TransformToGenModelOperation_e_null_mapping);
		}
	}
	
	private IStatus getFirst(Diagnostic d) {
		if (d == null) {
			return Status.OK_STATUS;
		}
		List<Diagnostic> children = d.getChildren();
		if (children.isEmpty()) {
			return BasicDiagnostic.toIStatus(d);
		} else {
			return BasicDiagnostic.toIStatus(children.get(0));
		}
	}
	
	private DiagramRunTimeModelHelper detectRunTimeModel() {
		return new BasicDiagramRunTimeModelHelper();
	}

	private ViewmapProducer detectTransformationOptions() {
		FigureQualifiedNameSwitch fSwitch = getOptions().getUseRuntimeFigures() ? new RuntimeFQNSwitch() : new RuntimeLiteFQNSwitch();
		MapModeCodeGenStrategy mmStrategy = getOptions().getUseMapMode() ? MapModeCodeGenStrategy.DYNAMIC : MapModeCodeGenStrategy.STATIC;
		URL dynamicFigureTemplates = getOptions().getFigureTemplatesPath();
		return new InnerClassViewmapProducer(fSwitch, mmStrategy, dynamicFigureTemplates == null ? null : new URL[] {dynamicFigureTemplates});
	}

	private VisualIdentifierDispenserProvider getVisualIdDispenser() {
		return new VisualIdentifierDispenserProvider(getGenURI());
	}

	private GenModelProducer createGenModelProducer(GenModel domainGenModel, final DiagramRunTimeModelHelper drtModelHelper, final ViewmapProducer viewmapProducer, final VisualIdentifierDispenser idDespenser) {
		final DiagramGenModelTransformer t = new DiagramGenModelTransformer(drtModelHelper, new GenModelNamingMediatorImpl(), viewmapProducer, idDespenser, getOptions().getGenerateRCP());
		if (domainGenModel != null) {
			t.setEMFGenModel(domainGenModel);
		}
		return new GenModelProducer() {

			public GenEditorGenerator process(Mapping mapping, IProgressMonitor progress) {
				progress.beginTask(null, 1);
				try {
					t.transform(mapping);
					return t.getResult();
				} finally {
					progress.done();
				}
			}
		};
	}

	private void reconcile(ResourceSet rs, GenEditorGenerator genBurdern) {
		GenEditorGenerator old = null;
		Resource resource = null;
		try {
			resource = rs.getResource(getGenURI(), true);
			List<EObject> contents = resource.getContents();
			if (!contents.isEmpty() && contents.get(0) instanceof GenEditorGenerator) {
				old = (GenEditorGenerator) contents.get(0);
			}
			if (old != null) {
				new Reconciler(new GMFGenConfig()).reconcileTree(genBurdern, old);
			}
		} catch (RuntimeException e) {
			old = null;
		} finally {
			if (resource != null) {
				resource.unload();
			}
		}
	}

	private void save(ResourceSet rs, GenEditorGenerator genBurdern) throws IOException {
		Resource dgmmRes = rs.createResource(getGenURI());
		dgmmRes.getContents().add(genBurdern);
		dgmmRes.save(getSaveOptions());
	}

	private Map<?,?> getSaveOptions() {
		HashMap<String, Object> saveOptions = new HashMap<String, Object>();
		saveOptions.put(XMLResource.OPTION_ENCODING, "UTF-8"); //$NON-NLS-1$
		return saveOptions;
	}

	private IStatus validate(GenEditorGenerator genBurdern, IProgressMonitor monitor) {
		Diagnostic d = ValidationHelper.validate(genBurdern, true, monitor);
		return getFirst(d);
	}
	
	private static void subTask(IProgressMonitor monitor, int ticks, String name, String cancelMessage) throws CoreException{
		if (monitor == null) {
			return;
		}
		if (monitor.isCanceled()) {
			IStatus cancel = Plugin.createCancel(cancelMessage);
			throw new CoreException(cancel);
		}
		if (ticks > 0) {
			monitor.worked(ticks);
		}
		if (name != null) {
			monitor.subTask(name);
		}
	}
}
