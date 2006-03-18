package org.eclipse.gmf.codegen.templates.editor;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.common.codegen.*;
import org.eclipse.emf.codegen.ecore.genmodel.*;

public class DiagramEditorUtilGenerator
{
  protected static String nl;
  public static synchronized DiagramEditorUtilGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    DiagramEditorUtilGenerator result = new DiagramEditorUtilGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "/*" + NL + " * ";
  protected final String TEXT_3 = NL + " */";
  protected final String TEXT_4 = NL + NL + "import java.io.IOException;" + NL + "import java.io.InputStream;" + NL + "import java.lang.reflect.InvocationTargetException;" + NL + "import java.util.ArrayList;" + NL + "import java.util.Collections;" + NL + "import java.util.List;" + NL + "" + NL + "import org.eclipse.core.commands.ExecutionException;" + NL + "import org.eclipse.core.commands.operations.OperationHistoryFactory;" + NL + "import org.eclipse.core.resources.IFile;" + NL + "import org.eclipse.core.runtime.IAdaptable;" + NL + "import org.eclipse.core.runtime.IPath;" + NL + "import org.eclipse.core.runtime.IProgressMonitor;" + NL + "import org.eclipse.core.runtime.Path;" + NL + "import org.eclipse.core.runtime.SubProgressMonitor;" + NL + "import org.eclipse.emf.common.util.URI;" + NL + "import org.eclipse.emf.ecore.EObject;" + NL + "import org.eclipse.emf.ecore.resource.Resource;" + NL + "import org.eclipse.emf.ecore.resource.ResourceSet;" + NL + "import org.eclipse.gmf.runtime.common.core.command.CommandResult;" + NL + "import org.eclipse.gmf.runtime.diagram.core.services.ViewService;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.resources.editor.ide.util.IDEEditorUtil;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.resources.editor.util.DiagramFileCreator;" + NL + "import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;" + NL + "import org.eclipse.gmf.runtime.emf.core.GMFEditingDomainFactory;" + NL + "import org.eclipse.gmf.runtime.notation.Diagram;" + NL + "import org.eclipse.jface.operation.IRunnableContext;" + NL + "import org.eclipse.jface.operation.IRunnableWithProgress;" + NL + "import org.eclipse.swt.widgets.Shell;" + NL + "import org.eclipse.ui.IWorkbenchWindow;" + NL + "import org.eclipse.emf.transaction.TransactionalEditingDomain;";
  protected final String TEXT_5 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_6 = " extends IDEEditorUtil {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static final IFile createAndOpenDiagram(DiagramFileCreator diagramFileCreator, IPath containerPath, String fileName, InputStream initialContents, String kind, IWorkbenchWindow window, IProgressMonitor progressMonitor, boolean openEditor, boolean saveDiagram) {" + NL + "\t\tIFile diagramFile = ";
  protected final String TEXT_7 = ".createNewDiagramFile(diagramFileCreator, containerPath, fileName, initialContents, kind, window.getShell(), progressMonitor);" + NL + "\t\tif (diagramFile != null && openEditor) {" + NL + "\t\t\tIDEEditorUtil.openDiagram(diagramFile, window, saveDiagram, progressMonitor);" + NL + "\t\t}" + NL + "\t\treturn diagramFile;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * <p>" + NL + "\t * This method should be called within a workspace modify operation since it creates resources." + NL + "\t * </p>" + NL + "\t * @generated" + NL + "\t * @return the created file resource, or <code>null</code> if the file was not created" + NL + "\t */" + NL + "\tpublic static final IFile createNewDiagramFile(DiagramFileCreator diagramFileCreator, IPath containerFullPath, String fileName, InputStream initialContents, String kind, Shell shell, IProgressMonitor progressMonitor) {" + NL + "\t\tTransactionalEditingDomain editingDomain = GMFEditingDomainFactory.INSTANCE.createEditingDomain();" + NL + "\t\tResourceSet resourceSet = editingDomain.getResourceSet();" + NL + "\t\tprogressMonitor.beginTask(\"Creating diagram and model files\", 2); //$NON-NLS-1$" + NL + "\t\tfinal IProgressMonitor subProgressMonitor = new SubProgressMonitor(progressMonitor, 1);" + NL + "\t\tfinal IFile diagramFile = diagramFileCreator.createNewFile(containerFullPath, fileName, initialContents, shell, new IRunnableContext() {" + NL + "\t\t\tpublic void run(boolean fork, boolean cancelable, IRunnableWithProgress runnable) throws InvocationTargetException, InterruptedException {" + NL + "\t\t\t\trunnable.run(subProgressMonitor);" + NL + "\t\t\t}" + NL + "\t\t});" + NL + "\t\tfinal Resource diagramResource = resourceSet.createResource(URI.createPlatformResourceURI(diagramFile.getFullPath().toString()));" + NL + "\t\tList affectedFiles = new ArrayList();" + NL + "\t\taffectedFiles.add(diagramFile);" + NL + "\t\t";
  protected final String TEXT_8 = NL + "\t\tIPath modelFileRelativePath = diagramFile.getFullPath().removeFileExtension().addFileExtension(\"";
  protected final String TEXT_9 = "\"); //$NON-NLS-1$" + NL + "\t\tIFile modelFile = diagramFile.getParent().getFile(new Path(modelFileRelativePath.lastSegment()));" + NL + "\t\tfinal Resource modelResource = resourceSet.createResource(URI.createPlatformResourceURI(modelFile.getFullPath().toString()));" + NL + "\t\taffectedFiles.add(modelFile);" + NL + "\t\t";
  protected final String TEXT_10 = NL + "\t\tfinal String kindParam = kind;" + NL + "\t\tAbstractTransactionalCommand command = new AbstractTransactionalCommand(editingDomain, \"Creating diagram and model\", affectedFiles) { //$NON-NLS-1$" + NL + "\t\t\tprotected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {";
  protected final String TEXT_11 = NL + "\t\t\t\tEObject model = ";
  protected final String TEXT_12 = ".";
  protected final String TEXT_13 = ".create(";
  protected final String TEXT_14 = ".eINSTANCE.get";
  protected final String TEXT_15 = "());";
  protected final String TEXT_16 = NL + "\t\t\t\tmodelResource.getContents().add(model);";
  protected final String TEXT_17 = NL + "\t\t\t\tdiagramResource.getContents().add(model);";
  protected final String TEXT_18 = NL + "\t\t\t\tDiagram diagram = ViewService.createDiagram(";
  protected final String TEXT_19 = NL + "\t\t\t\tmodel, ";
  protected final String TEXT_20 = NL + "\t\t\t\tkindParam, ";
  protected final String TEXT_21 = ".DIAGRAM_PREFERENCES_HINT);" + NL + "\t\t\t\tif (diagram != null) {" + NL + "\t\t\t\t\tdiagramResource.getContents().add(diagram);" + NL + "\t\t\t\t\tdiagram.setName(diagramFile.getName());";
  protected final String TEXT_22 = NL + "\t\t\t\t\tdiagram.setElement(model);";
  protected final String TEXT_23 = NL + "\t\t\t\t}" + NL + "\t\t\t\treturn CommandResult.newOKCommandResult();" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t\t" + NL + "\t\ttry {" + NL + "\t\t\tOperationHistoryFactory.getOperationHistory().execute(command, new SubProgressMonitor(progressMonitor, 1), null);" + NL + "\t\t} catch (ExecutionException e) {" + NL + "\t\t\t";
  protected final String TEXT_24 = ".getInstance().logError(\"Unable to create model and diagram\", e); //$NON-NLS-1$" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\ttry {";
  protected final String TEXT_25 = NL + "\t\t\tmodelResource.save(Collections.EMPTY_MAP);";
  protected final String TEXT_26 = NL + "\t\t\tdiagramResource.save(Collections.EMPTY_MAP);" + NL + "\t\t} catch (IOException e) {" + NL + "\t\t\t";
  protected final String TEXT_27 = ".getInstance().logError(\"Unable to store model and diagram resources\", e); //$NON-NLS-1$" + NL + "\t\t}\t" + NL + "" + NL + "\t\treturn diagramFile;" + NL + "\t}" + NL + "}";
  protected final String TEXT_28 = NL;

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    
final GenDiagram genDiagram = (GenDiagram) ((Object[]) argument)[0];
final GenEditorGenerator editorGen = genDiagram.getEditorGen();
final ImportAssistant importManager = (ImportAssistant) ((Object[]) argument)[1];

    stringBuffer.append(TEXT_1);
    
String copyrightText = genDiagram.getEditorGen().getCopyrightText();
if (copyrightText != null && copyrightText.trim().length() > 0) {

    stringBuffer.append(TEXT_2);
    stringBuffer.append(copyrightText.replaceAll("\n", "\n * "));
    stringBuffer.append(TEXT_3);
    }
    importManager.emitPackageStatement(stringBuffer);
    stringBuffer.append(TEXT_4);
    importManager.markImportLocation(stringBuffer);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(genDiagram.getDiagramEditorUtilClassName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(genDiagram.getDiagramEditorUtilClassName());
    stringBuffer.append(TEXT_7);
    
final boolean standaloneDomainModel = !editorGen.isSameFileForDiagramAndModel() && genDiagram.getDomainDiagramElement() != null;
if (standaloneDomainModel) {

    stringBuffer.append(TEXT_8);
    stringBuffer.append(editorGen.getDomainFileExtension());
    stringBuffer.append(TEXT_9);
    }
    stringBuffer.append(TEXT_10);
    
if (genDiagram.getDomainDiagramElement() != null) {
	GenPackage domainGenPackage = genDiagram.getDomainDiagramElement().getGenPackage();

    stringBuffer.append(TEXT_11);
    stringBuffer.append(importManager.getImportedName(domainGenPackage.getQualifiedFactoryInterfaceName()));
    stringBuffer.append(TEXT_12);
    stringBuffer.append(domainGenPackage.getFactoryInstanceName());
    stringBuffer.append(TEXT_13);
    stringBuffer.append(genDiagram.getMetaPackageName(importManager));
    stringBuffer.append(TEXT_14);
    stringBuffer.append(genDiagram.getDomainDiagramElement().getClassifierAccessorName());
    stringBuffer.append(TEXT_15);
    	if (standaloneDomainModel) {
    stringBuffer.append(TEXT_16);
    	} else {
    stringBuffer.append(TEXT_17);
    
	}
}

    stringBuffer.append(TEXT_18);
    if (genDiagram.getDomainDiagramElement() != null) {
    stringBuffer.append(TEXT_19);
    }
    stringBuffer.append(TEXT_20);
    stringBuffer.append(genDiagram.getEditorGen().getPlugin().getActivatorClassName());
    stringBuffer.append(TEXT_21);
    if (genDiagram.getDomainDiagramElement() != null) {
    stringBuffer.append(TEXT_22);
    }
    stringBuffer.append(TEXT_23);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorGen().getPlugin().getActivatorQualifiedClassName()));
    stringBuffer.append(TEXT_24);
    if (standaloneDomainModel) {
    stringBuffer.append(TEXT_25);
    }
    stringBuffer.append(TEXT_26);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorGen().getPlugin().getActivatorQualifiedClassName()));
    stringBuffer.append(TEXT_27);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_28);
    return stringBuffer.toString();
  }
}
