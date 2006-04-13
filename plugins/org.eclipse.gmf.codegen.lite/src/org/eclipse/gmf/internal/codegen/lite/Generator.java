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

import java.lang.ref.SoftReference;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.codegen.gmfgen.GMFGenPackage;
import org.eclipse.gmf.codegen.gmfgen.GenCompartment;
import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator;
import org.eclipse.gmf.codegen.gmfgen.GenLink;
import org.eclipse.gmf.codegen.gmfgen.GenLinkLabel;
import org.eclipse.gmf.codegen.gmfgen.GenNode;
import org.eclipse.gmf.codegen.gmfgen.GenNodeLabel;
import org.eclipse.gmf.common.UnexpectedBehaviourException;
import org.eclipse.gmf.common.codegen.GeneratorBase;

/**
 * Invokes JET templates to populate diagram editor project.
 * 
 * @author artem
 */
public class Generator extends GeneratorBase implements Runnable {

	private final GenEditorGenerator myEditorGen; 

	private final GenDiagram myDiagram;

	private final CodegenEmitters myEmitters;

	private static Map/*<URI, SoftReference>*/ myCachedURI2EmitterMap = new HashMap();

	public Generator(GenEditorGenerator genModel) {
		myDiagram = genModel.getDiagram();
		myEditorGen = genModel;
		URI resourceURI = myEditorGen.eResource().getURI();
		if (myEditorGen.isDynamicTemplates()) {
			myCachedURI2EmitterMap.remove(resourceURI);
		}
		CodegenEmitters old = myCachedURI2EmitterMap.containsKey(resourceURI) ? (CodegenEmitters) ((SoftReference) myCachedURI2EmitterMap.get(resourceURI)).get() : null;
		if (old == null) {
			myEmitters = new CodegenEmitters(!myEditorGen.isDynamicTemplates(), myEditorGen.getTemplateDirectory());
			if (!myEditorGen.isDynamicTemplates()) {
				myCachedURI2EmitterMap.put(resourceURI, new SoftReference(myEmitters));
			}
		} else {
			myEmitters = old;
		}
	}

	protected URL getJMergeControlFile() {
		return myEmitters.getJMergeControlFile();
	}
	
	protected void customRun() throws InterruptedException, UnexpectedBehaviourException {
		initializeEditorProject(myDiagram.getEditorGen().getPlugin().getID(), createReferencedProjectsList());

		doGenerateFile(myEmitters.getManifestGenerator(), new Path("META-INF/MANIFEST.MF"), myEditorGen.getPlugin());
		doGenerateFile(myEmitters.getBuildPropertiesGenerator(), new Path("build.properties"), myEditorGen.getPlugin());
		doGenerateFile(myEmitters.getPluginXML(), new Path("plugin.xml"), myEditorGen.getPlugin());
		doGenerateFile(myEmitters.getPluginPropertiesGenerator(), new Path("plugin.properties"), myEditorGen.getPlugin());

		doGenerateJavaClass(myEmitters.getCreationWizardGenerator(), myDiagram.getCreationWizardQualifiedClassName(), myDiagram);
		doGenerateJavaClass(myEmitters.getCreationWizardPageGenerator(), myDiagram.getCreationWizardPageQualifiedClassName(), myDiagram);
		doGenerateJavaClass(myEmitters.getPluginGenerator(), myEditorGen.getPlugin().getActivatorQualifiedClassName(), myEditorGen.getPlugin());

		doGenerateJavaClass(myEmitters.getActionBarContributorGenerator(), myEditorGen.getEditor().getActionBarContributorQualifiedClassName(), myEditorGen.getEditor());
		doGenerateJavaClass(myEmitters.getDiagramEditorUtilGenerator(), myDiagram.getDiagramEditorUtilQualifiedClassName(), myDiagram);
		doGenerateJavaClass(myEmitters.getEditorGenerator(), myEditorGen.getEditor().getQualifiedClassName(), myEditorGen.getEditor());
		doGenerateJavaClass(myEmitters.getPropertySourceProviderGenerator(), myDiagram.getPropertyProviderQualifiedClassName(), myDiagram);
		if (myDiagram.getPalette() != null) {
			doGenerateJavaClass(myEmitters.getPaletteFactoryGenerator(), myDiagram.getPalette().getFactoryQualifiedClassName(), myDiagram);
		}
		doGenerateJavaClass(myEmitters.getUpdatableEditPartGenerator(), myDiagram.getEditPartsPackageName(), "IUpdatableEditPart", myDiagram); // XXX: should be customizable
		doGenerateJavaClass(myEmitters.getEditPartFactoryGenerator(), myDiagram.getEditPartFactoryQualifiedClassName(), myDiagram);
		doGenerateJavaClass(myEmitters.getDiagramEditPartGenerator(), myDiagram.getEditPartQualifiedClassName(), myDiagram);

		for (Iterator it = myDiagram.getAllNodes().iterator(); it.hasNext(); ) {
			final GenNode next = (GenNode) it.next();
			if (!next.isListContainerEntry()) {
				doGenerateJavaClass(myEmitters.getNodeEditPartGenerator(), next.getEditPartQualifiedClassName(), next);
				for (Iterator it2 = next.getLabels().iterator(); it2.hasNext();) {
					final GenNodeLabel label = (GenNodeLabel) it2.next();
					doGenerateJavaClass(myEmitters.getNodeLabelEditPartGenerator(), label.getEditPartQualifiedClassName(), label);
					doGenerateJavaClass(myEmitters.getLabelViewFactoryGenerator(), label.getNotationViewFactoryQualifiedClassName(), label);
				}
				doGenerateJavaClass(myEmitters.getNodeViewFactoryGenerator(), next.getNotationViewFactoryQualifiedClassName(), next);
			} else {
				doGenerateJavaClass(myEmitters.getChildNodeEditPartGenerator(), next.getEditPartQualifiedClassName(), next);
				doGenerateJavaClass(myEmitters.getLabelViewFactoryGenerator(), next.getNotationViewFactoryQualifiedClassName(), next);
			}
		}
		doGenerateJavaClass(myEmitters.getAbstractParserGenerator(),myDiagram.getAbstractParserQualifiedClassName(), myDiagram);
		for (Iterator it = myDiagram.getLinks().iterator(); it.hasNext();) {
			final GenLink next = (GenLink) it.next();
			doGenerateJavaClass(myEmitters.getLinkEditPartGenerator(), next.getEditPartQualifiedClassName(), next);
			for (Iterator it2 = next.getLabels().iterator(); it2.hasNext();) {
				final GenLinkLabel label = (GenLinkLabel) it2.next();
				doGenerateJavaClass(myEmitters.getLinkLabelEditPartGenerator(), label.getEditPartQualifiedClassName(), label);
				doGenerateJavaClass(myEmitters.getLabelViewFactoryGenerator(), label.getNotationViewFactoryQualifiedClassName(), label);
			}
			doGenerateJavaClass(myEmitters.getLinkViewFactoryGenerator(), next.getNotationViewFactoryQualifiedClassName(), next);
		}
		for (Iterator it = myDiagram.getCompartments().iterator(); it.hasNext(); ) {
			final GenCompartment next = (GenCompartment) it.next();
			doGenerateJavaClass(myEmitters.getCompartmentEditPartGenerator(), next.getEditPartQualifiedClassName(), next);
			doGenerateJavaClass(myEmitters.getCompartmentViewFactoryGenerator(), next.getNotationViewFactoryQualifiedClassName(), next);
		}
		doGenerateJavaClass(myEmitters.getDiagramViewFactoryGenerator(), myDiagram.getNotationViewFactoryQualifiedClassName(), myDiagram);
		doGenerateJavaClass(myEmitters.getDomainElementInitializerGenerator(), myDiagram.getNotationViewFactoriesPackageName(), "DomainElementInitializer",myDiagram); // XXX: allow customization!
		doGenerateJavaClass(myEmitters.getVisualIDRegistryGenerator(), myDiagram.getVisualIDRegistryQualifiedClassName(), myDiagram);
	}

	protected void setupProgressMonitor() {
		Counter c = new Counter();
		c.curiousAbout(GMFGenPackage.eINSTANCE.getGenNode());
		c.curiousAbout(GMFGenPackage.eINSTANCE.getGenCompartment());
		c.curiousAbout(GMFGenPackage.eINSTANCE.getGenLink());
		c.curiousAbout(GMFGenPackage.eINSTANCE.getGenNodeLabel());
		c.curiousAbout(GMFGenPackage.eINSTANCE.getGenLinkLabel());
		c.count(myDiagram);
		int total = 2 * c.getCount(GMFGenPackage.eINSTANCE.getGenNode());
		total += 2 * c.getCount(GMFGenPackage.eINSTANCE.getGenCompartment());
		total += 2 * c.getCount(GMFGenPackage.eINSTANCE.getGenLink());
		total += 2 * c.getCount(GMFGenPackage.eINSTANCE.getGenNodeLabel());
		total += 2 * c.getCount(GMFGenPackage.eINSTANCE.getGenLinkLabel());
		total++; // init
		total += 4; // text files
		total += 15; // out-of-cycle doGenerateJava... <- genDiagram + genEditor
		setupProgressMonitor("Generation in progress...", total);
	}

	protected final List createReferencedProjectsList() {
		return Collections.EMPTY_LIST;
	}

	private static final class Counter {
		private final List/*<EClass>*/ myAttractions = new ArrayList();
		private int[] myHits;
		
		public void curiousAbout(EClass eClass) {
			myAttractions.add(eClass);
		}

		public void count(EObject start) {
			myHits = new int[myAttractions.size()];
			final EClass[] attractions = (EClass[]) myAttractions.toArray(new EClass[myAttractions.size()]);
			doCount(start.eClass(), attractions);
			for (Iterator it = start.eAllContents(); it.hasNext(); ) {
				EObject next = (EObject) it.next();
				doCount(next.eClass(), attractions);
			}
		}

		private void doCount(EClass eClass, EClass[] attractions) {
			for (int i = 0; i < attractions.length; i++) {
				if (attractions[i].isSuperTypeOf(eClass)) {
					myHits[i]++;
				}
			}
		}

		public int getCount(EClass eClass) {
			int index = myAttractions.indexOf(eClass);
			if (index == -1) {
				throw new IllegalArgumentException("No class " + eClass + " was previously registered with curiousAbout(EClass)");
			}
			return myHits[index];
		}
	}
}
