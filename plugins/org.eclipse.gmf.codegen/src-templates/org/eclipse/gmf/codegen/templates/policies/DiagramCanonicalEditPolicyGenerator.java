package org.eclipse.gmf.codegen.templates.policies;

import java.util.*;
import org.eclipse.emf.codegen.ecore.genmodel.*;
import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.common.codegen.*;

public class DiagramCanonicalEditPolicyGenerator {
 
  protected static String nl;
  public static synchronized DiagramCanonicalEditPolicyGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    DiagramCanonicalEditPolicyGenerator result = new DiagramCanonicalEditPolicyGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "/*" + NL + " *";
  protected final String TEXT_3 = NL + " */";
  protected final String TEXT_4 = NL + NL + "import java.util.List;" + NL + "import java.util.Collection;" + NL + "import org.eclipse.gmf.runtime.notation.Edge;" + NL + "import org.eclipse.emf.ecore.EObject;";
  protected final String TEXT_5 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_6 = " extends ";
  protected final String TEXT_7 = " {" + NL + "\t";
  protected final String TEXT_8 = NL;
  protected final String TEXT_9 = "/**" + NL + " * @generated" + NL + " */" + NL + "protected ";
  protected final String TEXT_10 = " getSemanticChildrenList() {";
  protected final String TEXT_11 = NL + "\t";
  protected final String TEXT_12 = " result = new ";
  protected final String TEXT_13 = "();" + NL + "\t";
  protected final String TEXT_14 = " modelObject = ((";
  protected final String TEXT_15 = ") getHost().getModel()).getElement();" + NL + "\t";
  protected final String TEXT_16 = " viewObject = (";
  protected final String TEXT_17 = ") getHost().getModel();";
  protected final String TEXT_18 = NL;
  protected final String TEXT_19 = "\t";
  protected final String TEXT_20 = " nextValue;" + NL + "\tint nodeVID;";
  protected final String TEXT_21 = "\tfor (";
  protected final String TEXT_22 = " values = ";
  protected final String TEXT_23 = ".iterator(); values.hasNext();) {" + NL + "\t\tnextValue = (";
  protected final String TEXT_24 = ") values.next();";
  protected final String TEXT_25 = NL + "\tnextValue = ";
  protected final String TEXT_26 = ";";
  protected final String TEXT_27 = NL + "\tnodeVID = ";
  protected final String TEXT_28 = ".getNodeVisualID(viewObject, nextValue);";
  protected final String TEXT_29 = NL + "\tswitch (nodeVID) {";
  protected final String TEXT_30 = NL + "\tcase ";
  protected final String TEXT_31 = ".VISUAL_ID: {";
  protected final String TEXT_32 = NL + "\tif (";
  protected final String TEXT_33 = ".VISUAL_ID == nodeVID) {";
  protected final String TEXT_34 = NL + "\t\tresult.add(nextValue);";
  protected final String TEXT_35 = NL;
  protected final String TEXT_36 = "\t\tbreak;";
  protected final String TEXT_37 = "\t}";
  protected final String TEXT_38 = NL + "\t}";
  protected final String TEXT_39 = NL + "\t}";
  protected final String TEXT_40 = NL + "\treturn result;";
  protected final String TEXT_41 = NL + "\treturn ";
  protected final String TEXT_42 = ".EMPTY_LIST;";
  protected final String TEXT_43 = NL + "}" + NL + "" + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "protected boolean shouldDeleteView(";
  protected final String TEXT_44 = " view) {" + NL + "\tif (view.getEAnnotation(\"Shortcut\") != null) { //$NON-NLS-1$" + NL + "\t\treturn view.isSetElement() && (view.getElement() == null || view.getElement().eIsProxy());" + NL + "\t}" + NL + "\t" + NL + "\tint nodeVID = ";
  protected final String TEXT_45 = ".getVisualID(view);" + NL + "\tswitch (nodeVID) {\t";
  protected final String TEXT_46 = NL + "\tcase ";
  protected final String TEXT_47 = ".VISUAL_ID:";
  protected final String TEXT_48 = NL + "\t\treturn true;" + NL + "\t}" + NL + "\treturn false;" + NL + "}" + NL + "" + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "protected String getDefaultFactoryHint() {" + NL + "\treturn null;" + NL + "}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected List getSemanticConnectionsList() {" + NL + "\t\treturn ";
  protected final String TEXT_49 = ".EMPTY_LIST;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected EObject getSourceElement(EObject relationship) {" + NL + "\t\treturn null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected EObject getTargetElement(EObject relationship) {" + NL + "\t\treturn null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected boolean shouldIncludeConnection(Edge connector, Collection children) {" + NL + "\t\treturn false;" + NL + "\t}" + NL;
  protected final String TEXT_50 = NL;
  protected final String TEXT_51 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshSemantic() {" + NL + "\t\t";
  protected final String TEXT_52 = " createdViews = new ";
  protected final String TEXT_53 = "();" + NL + "\t\tcreatedViews.addAll(refreshSemanticChildren());";
  protected final String TEXT_54 = NL + "\t\tcreatedViews.addAll(refreshPhantoms());";
  protected final String TEXT_55 = NL + "\t\t";
  protected final String TEXT_56 = " createdConnectionViews = new ";
  protected final String TEXT_57 = "();" + NL + "\t\tcreatedConnectionViews.addAll(refreshSemanticConnections());" + NL + "\t\tcreatedConnectionViews.addAll(refreshConnections());" + NL + "" + NL + "\t\tif (createdViews.size() > 1) {" + NL + "\t\t\t// perform a layout of the container" + NL + "\t\t\t";
  protected final String TEXT_58 = " layoutCmd = new ";
  protected final String TEXT_59 = "(host().getEditingDomain(), createdViews, host());" + NL + "\t\t\texecuteCommand(new ";
  protected final String TEXT_60 = "(layoutCmd));" + NL + "\t\t}" + NL + "" + NL + "\t\tcreatedViews.addAll(createdConnectionViews);" + NL + "\t\tmakeViewsImmutable(createdViews);" + NL + "\t}";
  protected final String TEXT_61 = NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_62 = " refreshPhantoms() {" + NL + "\t\t";
  protected final String TEXT_63 = " phantomNodes = new ";
  protected final String TEXT_64 = "();" + NL + "\t\t";
  protected final String TEXT_65 = " diagramModelObject = ((";
  protected final String TEXT_66 = ") getHost().getModel()).getElement();" + NL + "\t\t";
  protected final String TEXT_67 = " diagram = getDiagram();";
  protected final String TEXT_68 = NL;
  protected final String TEXT_69 = " resource = diagramModelObject.eResource();" + NL + "for (";
  protected final String TEXT_70 = " it = resource.getContents().iterator(); it.hasNext();) {" + NL + "\t";
  protected final String TEXT_71 = " nextResourceObject = (";
  protected final String TEXT_72 = ") it.next();" + NL + "\tif (nextResourceObject == diagramModelObject) {" + NL + "\t\tcontinue;" + NL + "\t}" + NL + "\tint nodeVID = ";
  protected final String TEXT_73 = ".getNodeVisualID(diagram, nextResourceObject);" + NL + "\tswitch (nodeVID) {";
  protected final String TEXT_74 = NL + "\tcase ";
  protected final String TEXT_75 = ".VISUAL_ID: {" + NL + "\t\t\tphantomNodes.add(nextResourceObject);";
  protected final String TEXT_76 = NL;
  protected final String TEXT_77 = "\t\tbreak;" + NL + "\t}";
  protected final String TEXT_78 = "\t}" + NL + "}";
  protected final String TEXT_79 = NL;
  protected final String TEXT_80 = NL;
  protected final String TEXT_81 = "for (";
  protected final String TEXT_82 = " diagramNodes = getDiagram().getChildren().iterator(); diagramNodes.hasNext();) {" + NL + "\t";
  protected final String TEXT_83 = " nextView = (";
  protected final String TEXT_84 = ") diagramNodes.next();" + NL + "\t";
  protected final String TEXT_85 = " nextViewElement = nextView.getElement();" + NL + "\tif (phantomNodes.contains(nextViewElement)) {" + NL + "\t\tphantomNodes.remove(nextViewElement);" + NL + "\t}\t" + NL + "}" + NL + "\t\treturn createPhantomNodes(phantomNodes);" + NL + "\t}" + NL;
  protected final String TEXT_86 = NL;
  protected final String TEXT_87 = "/**" + NL + " * @generated" + NL + " */" + NL + "private ";
  protected final String TEXT_88 = " createPhantomNodes(";
  protected final String TEXT_89 = " nodes) {" + NL + "\tif (nodes.isEmpty()) {" + NL + "\t\treturn ";
  protected final String TEXT_90 = ".EMPTY_LIST;" + NL + "\t}" + NL + "\t";
  protected final String TEXT_91 = " descriptors = new ";
  protected final String TEXT_92 = "();" + NL + "\tfor (";
  protected final String TEXT_93 = " elements = nodes.iterator(); elements.hasNext();) {" + NL + "\t\t";
  protected final String TEXT_94 = " element = (";
  protected final String TEXT_95 = ")elements.next();" + NL + "\t\t";
  protected final String TEXT_96 = ".ViewDescriptor descriptor = getViewDescriptor(element);" + NL + "\t\tdescriptors.add(descriptor);" + NL + "\t}" + NL + "\t";
  protected final String TEXT_97 = " diagram = getDiagram();" + NL + "\t";
  protected final String TEXT_98 = " diagramEditPart = getDiagramEditPart();" + NL + "\t" + NL + "\t";
  protected final String TEXT_99 = " request = getCreateViewRequest(descriptors);" + NL + "\t";
  protected final String TEXT_100 = " cmd = diagramEditPart.getCommand(request);" + NL + "\tif (cmd == null) {" + NL + "\t\t";
  protected final String TEXT_101 = " cc = new ";
  protected final String TEXT_102 = "(";
  protected final String TEXT_103 = ".AddCommand_Label);" + NL + "\t\tfor (";
  protected final String TEXT_104 = " descriptorsIterator = descriptors.iterator(); descriptorsIterator.hasNext();) {" + NL + "\t\t\t";
  protected final String TEXT_105 = ".ViewDescriptor descriptor = (";
  protected final String TEXT_106 = ".ViewDescriptor) descriptorsIterator.next();" + NL + "\t\t\t";
  protected final String TEXT_107 = " createCommand = new ";
  protected final String TEXT_108 = "(((";
  protected final String TEXT_109 = ") getHost()).getEditingDomain(), descriptor, diagram);" + NL + "\t\t\tcc.compose(createCommand);" + NL + "\t\t}" + NL + "\t\tcmd = new ";
  protected final String TEXT_110 = "(cc);" + NL + "\t}\t" + NL + "\t" + NL + "\t";
  protected final String TEXT_111 = " adapters = ";
  protected final String TEXT_112 = ".EMPTY_LIST;" + NL + "\tif ( cmd != null && cmd.canExecute() ) {" + NL + "\t\t";
  protected final String TEXT_113 = ".makeMutable(new ";
  protected final String TEXT_114 = "(((";
  protected final String TEXT_115 = ") diagramEditPart).getNotationView())).execute();" + NL + "\t\texecuteCommand(cmd);" + NL + "\t\tadapters = (";
  protected final String TEXT_116 = ") request.getNewObject();" + NL + "\t}" + NL + "\tdiagramEditPart.refresh();" + NL + "\treturn adapters;" + NL + "}" + NL + "" + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "private ";
  protected final String TEXT_117 = " getDiagramEditPart() {" + NL + "\treturn (";
  protected final String TEXT_118 = ") getHost().getViewer().getEditPartRegistry().get(getDiagram());" + NL + "}";
  protected final String TEXT_119 = NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_120 = " myLinkDescriptors = new ";
  protected final String TEXT_121 = "();" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_122 = " myEObject2ViewMap = new ";
  protected final String TEXT_123 = "();" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_124 = " refreshConnections() {" + NL + "\t\ttry {" + NL + "\t\t\tcollectAllLinks(getDiagram());" + NL + "\t\t\t";
  protected final String TEXT_125 = " existingLinks = new ";
  protected final String TEXT_126 = "(getDiagram().getEdges());" + NL + "\t\t\tfor (";
  protected final String TEXT_127 = " diagramLinks = existingLinks.iterator(); diagramLinks.hasNext();) {" + NL + "\t\t\t\tEdge nextDiagramLink = (Edge) diagramLinks.next();" + NL + "\t\t\t\t";
  protected final String TEXT_128 = " diagramLinkObject = nextDiagramLink.getElement();" + NL + "\t\t\t\t";
  protected final String TEXT_129 = " diagramLinkSrc = nextDiagramLink.getSource().getElement();" + NL + "\t\t\t\t";
  protected final String TEXT_130 = " diagramLinkDst = nextDiagramLink.getTarget().getElement();" + NL + "\t\t\t\tint diagramLinkVisualID = ";
  protected final String TEXT_131 = ".getVisualID(nextDiagramLink);" + NL + "\t\t\t\tfor (";
  protected final String TEXT_132 = " modelLinkDescriptors = myLinkDescriptors.iterator(); modelLinkDescriptors.hasNext();) {" + NL + "\t\t\t\t\tLinkDescriptor nextLinkDescriptor = (LinkDescriptor) modelLinkDescriptors.next();" + NL + "\t\t\t\t\tif (diagramLinkObject == nextLinkDescriptor.getLinkElement() && diagramLinkSrc == nextLinkDescriptor.getSource() && diagramLinkDst == nextLinkDescriptor.getDestination() && diagramLinkVisualID == nextLinkDescriptor.getVisualID()) {" + NL + "\t\t\t\t\t\tdiagramLinks.remove();" + NL + "\t\t\t\t\t\tmodelLinkDescriptors.remove();" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\tdeleteViews(existingLinks.iterator());" + NL + "\t\t\treturn createConnections(myLinkDescriptors);" + NL + "\t\t} finally {" + NL + "\t\t\tmyLinkDescriptors.clear();" + NL + "\t\t\tmyEObject2ViewMap.clear();" + NL + "\t\t}" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate void collectAllLinks(";
  protected final String TEXT_133 = " view) {" + NL + "\t\t";
  protected final String TEXT_134 = " modelElement = view.getElement();" + NL + "\t\tint diagramElementVisualID = ";
  protected final String TEXT_135 = ".getVisualID(view);" + NL + "\t\tswitch (diagramElementVisualID) {";
  protected final String TEXT_136 = NL + "\t\tcase ";
  protected final String TEXT_137 = ".VISUAL_ID:";
  protected final String TEXT_138 = " { myEObject2ViewMap.put(modelElement, view);" + NL + "\t\t\tstoreLinks(modelElement, getDiagram());" + NL + "\t\t}" + NL + "\t\tdefault: {" + NL + "\t\t}" + NL + "\t\tfor (";
  protected final String TEXT_139 = " children = view.getChildren().iterator(); children.hasNext();) {" + NL + "\t\t\t";
  protected final String TEXT_140 = " childView = (";
  protected final String TEXT_141 = ") children.next();" + NL + "\t\t\tcollectAllLinks(childView);" + NL + "\t\t}" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_142 = " createConnections(";
  protected final String TEXT_143 = " linkDescriptors) {" + NL + "\t\tif (linkDescriptors.isEmpty()) {" + NL + "\t\t\treturn ";
  protected final String TEXT_144 = ".EMPTY_LIST;" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_145 = " adapters = new ";
  protected final String TEXT_146 = "();" + NL + "\t\tfor (";
  protected final String TEXT_147 = " linkDescriptorsIterator = linkDescriptors.iterator(); linkDescriptorsIterator.hasNext();) {" + NL + "\t\t\tfinal LinkDescriptor nextLinkDescriptor = (LinkDescriptor) linkDescriptorsIterator.next();" + NL + "\t\t\t";
  protected final String TEXT_148 = " sourceEditPart = getEditPartFor(nextLinkDescriptor.getSource());" + NL + "\t\t\t";
  protected final String TEXT_149 = " targetEditPart = getEditPartFor(nextLinkDescriptor.getDestination());" + NL + "\t\t\tif (sourceEditPart == null || targetEditPart == null) {" + NL + "\t\t\t\tcontinue;" + NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_150 = ".ConnectionViewDescriptor descriptor = new ";
  protected final String TEXT_151 = ".ConnectionViewDescriptor(nextLinkDescriptor.getSemanticAdapter(), null, ";
  protected final String TEXT_152 = ".APPEND, false, ((";
  protected final String TEXT_153 = ") getHost()).getDiagramPreferencesHint());" + NL + "\t\t\t";
  protected final String TEXT_154 = " ccr = new ";
  protected final String TEXT_155 = "(descriptor);" + NL + "\t\t\tccr.setType(";
  protected final String TEXT_156 = ".REQ_CONNECTION_START);" + NL + "\t\t\tccr.setSourceEditPart(sourceEditPart);" + NL + "\t\t\tsourceEditPart.getCommand(ccr);" + NL + "\t\t\tccr.setTargetEditPart(targetEditPart);" + NL + "\t\t\tccr.setType(";
  protected final String TEXT_157 = ".REQ_CONNECTION_END);" + NL + "\t\t\t";
  protected final String TEXT_158 = " cmd = targetEditPart.getCommand(ccr);" + NL + "\t\t\tif (cmd != null && cmd.canExecute()) {" + NL + "\t\t\t\texecuteCommand(cmd);" + NL + "\t\t\t\t";
  protected final String TEXT_159 = " viewAdapter = (";
  protected final String TEXT_160 = ") ccr.getNewObject();" + NL + "\t\t\t\tif (viewAdapter != null) {" + NL + "\t\t\t\t\tadapters.add(viewAdapter);" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\treturn adapters;" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_161 = " getEditPartFor(";
  protected final String TEXT_162 = " modelElement) {" + NL + "\t\t";
  protected final String TEXT_163 = " view = (";
  protected final String TEXT_164 = ") myEObject2ViewMap.get(modelElement);" + NL + "\t\tif (view != null) {" + NL + "\t\t\treturn (";
  protected final String TEXT_165 = ") getHost().getViewer().getEditPartRegistry().get(view);" + NL + "\t\t}" + NL + "\t\treturn null;" + NL + "\t}" + NL + "\t";
  protected final String TEXT_166 = NL;
  protected final String TEXT_167 = "/**" + NL + " *@generated" + NL + " */" + NL + "private void storeLinks(";
  protected final String TEXT_168 = " container, ";
  protected final String TEXT_169 = " diagram) {" + NL + "\t";
  protected final String TEXT_170 = " containerMetaclass = container.eClass();" + NL + "\tstoreFeatureModelFacetLinks(container, containerMetaclass, diagram);" + NL + "\tstoreTypeModelFacetLinks(container, containerMetaclass);" + NL + "}" + NL + "\t" + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "private void storeTypeModelFacetLinks(";
  protected final String TEXT_171 = " container, ";
  protected final String TEXT_172 = " containerMetaclass) {\t";
  protected final String TEXT_173 = NL + "\tstoreTypeModelFacetLinks_";
  protected final String TEXT_174 = "_";
  protected final String TEXT_175 = "(container, containerMetaclass);";
  protected final String TEXT_176 = NL + "}" + NL;
  protected final String TEXT_177 = "\t\t" + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "private void storeTypeModelFacetLinks_";
  protected final String TEXT_178 = "_";
  protected final String TEXT_179 = "(";
  protected final String TEXT_180 = " container, ";
  protected final String TEXT_181 = " containerMetaclass) {" + NL + "\tif (";
  protected final String TEXT_182 = ".eINSTANCE.get";
  protected final String TEXT_183 = "().isSuperTypeOf(containerMetaclass)) {";
  protected final String TEXT_184 = "\t\t" + NL + "\t\tfor (";
  protected final String TEXT_185 = " values = ";
  protected final String TEXT_186 = ".iterator(); values.hasNext();) {" + NL + "\t\t\t";
  protected final String TEXT_187 = " nextValue = ((";
  protected final String TEXT_188 = ") values.next());";
  protected final String TEXT_189 = NL + "\t\t";
  protected final String TEXT_190 = " nextValue = (";
  protected final String TEXT_191 = ") ";
  protected final String TEXT_192 = ";";
  protected final String TEXT_193 = NL + "\t\tint linkVID = ";
  protected final String TEXT_194 = ".getLinkWithClassVisualID(nextValue);" + NL + "\t\tif (";
  protected final String TEXT_195 = ".VISUAL_ID == linkVID) {" + NL + "\t\t\tObject structuralFeatureResult = ";
  protected final String TEXT_196 = ";";
  protected final String TEXT_197 = NL + "\t\t\t";
  protected final String TEXT_198 = " targets = (";
  protected final String TEXT_199 = ") structuralFeatureResult;" + NL + "\t\t\tstructuralFeatureResult = targets.size() == 1 ? targets.get(0) : null;";
  protected final String TEXT_200 = "\t\t\t\t" + NL + "\t\t\tif (structuralFeatureResult instanceof ";
  protected final String TEXT_201 = ") {" + NL + "\t\t\t\t";
  protected final String TEXT_202 = " dst = (";
  protected final String TEXT_203 = ") structuralFeatureResult;";
  protected final String TEXT_204 = NL + "\t\t\t\tstructuralFeatureResult = ";
  protected final String TEXT_205 = ";";
  protected final String TEXT_206 = NL + "\t\t\t\t";
  protected final String TEXT_207 = " sources = (";
  protected final String TEXT_208 = ") structuralFeatureResult;" + NL + "\t\t\t\tstructuralFeatureResult = sources.size() == 1 ? sources.get(0) : null;";
  protected final String TEXT_209 = "\t\t\t\t" + NL + "\t\t\t\tif (structuralFeatureResult instanceof ";
  protected final String TEXT_210 = ") {" + NL + "\t\t\t\t\t";
  protected final String TEXT_211 = " src = (";
  protected final String TEXT_212 = ") structuralFeatureResult;" + NL + "\t\t\t\t\tmyLinkDescriptors.add(new LinkDescriptor(src, dst, nextValue, ";
  protected final String TEXT_213 = ".";
  protected final String TEXT_214 = ", linkVID));" + NL + "\t\t\t\t}";
  protected final String TEXT_215 = NL + "\t\t\t\t";
  protected final String TEXT_216 = " src = container;" + NL + "\t\t\t\tmyLinkDescriptors.add(new LinkDescriptor(src, dst, nextValue, ";
  protected final String TEXT_217 = ".";
  protected final String TEXT_218 = ", linkVID));";
  protected final String TEXT_219 = NL + "\t\t\t}" + NL + "\t\t}";
  protected final String TEXT_220 = NL + "\t\t}";
  protected final String TEXT_221 = NL + "\t}" + NL + "}";
  protected final String TEXT_222 = NL + NL + "/**" + NL + " *@generated" + NL + " */" + NL + "private void storeFeatureModelFacetLinks(";
  protected final String TEXT_223 = " container, ";
  protected final String TEXT_224 = " containerMetaclass, ";
  protected final String TEXT_225 = " diagram) {";
  protected final String TEXT_226 = NL;
  protected final String TEXT_227 = "\tif (";
  protected final String TEXT_228 = ".eINSTANCE.get";
  protected final String TEXT_229 = "().isSuperTypeOf(containerMetaclass)) {";
  protected final String TEXT_230 = NL + "\t\tfor (";
  protected final String TEXT_231 = " destinations = ";
  protected final String TEXT_232 = ".iterator(); destinations.hasNext();) {" + NL + "\t\t\t";
  protected final String TEXT_233 = " nextDestination = (";
  protected final String TEXT_234 = ") destinations.next();";
  protected final String TEXT_235 = NL + "\t\t";
  protected final String TEXT_236 = " nextDestination = (";
  protected final String TEXT_237 = ") ";
  protected final String TEXT_238 = ";";
  protected final String TEXT_239 = NL + "\t\tif (";
  protected final String TEXT_240 = ".VISUAL_ID == ";
  protected final String TEXT_241 = ".getNodeVisualID(diagram, nextDestination)) {";
  protected final String TEXT_242 = NL + "\t\tmyLinkDescriptors.add(new LinkDescriptor(container, nextDestination, ";
  protected final String TEXT_243 = ".";
  protected final String TEXT_244 = ", ";
  protected final String TEXT_245 = ".VISUAL_ID));";
  protected final String TEXT_246 = NL + "\t\t";
  protected final String TEXT_247 = " nextNode = org.eclipse.gmf.runtime.diagram.core.services.ViewService.createNode(diagram, nextDestination, ";
  protected final String TEXT_248 = ".getType(";
  protected final String TEXT_249 = ".VISUAL_ID), ";
  protected final String TEXT_250 = ".DIAGRAM_PREFERENCES_HINT);" + NL + "\t\tmyEObject2NodeMap.put(nextDestination, nextNode);" + NL + "\t\tcreate";
  protected final String TEXT_251 = "Children(nextNode, nextDestination);";
  protected final String TEXT_252 = NL;
  protected final String TEXT_253 = NL + "\t\t}";
  protected final String TEXT_254 = NL + "\t\t}";
  protected final String TEXT_255 = NL + "\t}";
  protected final String TEXT_256 = NL;
  protected final String TEXT_257 = "\tif (";
  protected final String TEXT_258 = ".eINSTANCE.get";
  protected final String TEXT_259 = "().isSuperTypeOf(containerMetaclass)) {";
  protected final String TEXT_260 = NL + "\t\tfor (";
  protected final String TEXT_261 = " destinations = ";
  protected final String TEXT_262 = ".iterator(); destinations.hasNext();) {" + NL + "\t\t\t";
  protected final String TEXT_263 = " nextDestination = (";
  protected final String TEXT_264 = ") destinations.next();";
  protected final String TEXT_265 = NL + "\t\t";
  protected final String TEXT_266 = " nextDestination = (";
  protected final String TEXT_267 = ") ";
  protected final String TEXT_268 = ";";
  protected final String TEXT_269 = NL + "\t\tif (";
  protected final String TEXT_270 = ".VISUAL_ID == ";
  protected final String TEXT_271 = ".getNodeVisualID(diagram, nextDestination)) {";
  protected final String TEXT_272 = NL + "\t\tmyLinkDescriptors.add(new LinkDescriptor(container, nextDestination, ";
  protected final String TEXT_273 = ".";
  protected final String TEXT_274 = ", ";
  protected final String TEXT_275 = ".VISUAL_ID));";
  protected final String TEXT_276 = NL;
  protected final String TEXT_277 = NL + "\t\t}";
  protected final String TEXT_278 = NL + "\t\t}";
  protected final String TEXT_279 = NL + "\t}";
  protected final String TEXT_280 = NL + "}" + NL + "\t";
  protected final String TEXT_281 = NL;
  protected final String TEXT_282 = "/**" + NL + " * @generated" + NL + " */" + NL + "private ";
  protected final String TEXT_283 = " getDiagram() {" + NL + "\treturn ((";
  protected final String TEXT_284 = ") getHost().getModel()).getDiagram();" + NL + "}" + NL;
  protected final String TEXT_285 = NL;
  protected final String TEXT_286 = "/**" + NL + " * @generated" + NL + " */" + NL + "private class LinkDescriptor {" + NL + "\t" + NL + "\t/**" + NL + "   \t * @generated" + NL + "     */" + NL + "\tprivate ";
  protected final String TEXT_287 = " mySource;" + NL + "\t\t" + NL + "\t/**" + NL + "   \t * @generated" + NL + "     */" + NL + "\tprivate ";
  protected final String TEXT_288 = " myDestination;" + NL + "\t" + NL + "\t/**" + NL + "   \t * @generated" + NL + "     */" + NL + "\tprivate ";
  protected final String TEXT_289 = " myLinkElement;" + NL + "\t" + NL + "\t/**" + NL + "   \t * @generated" + NL + "     */" + NL + "\tprivate int myVisualID;" + NL + "\t\t" + NL + "\t/**" + NL + "   \t * @generated" + NL + "     */" + NL + "\tprivate ";
  protected final String TEXT_290 = " mySemanticAdapter;" + NL + "\t\t" + NL + "\t/**" + NL + "   \t * @generated" + NL + "     */" + NL + "\tprotected LinkDescriptor(";
  protected final String TEXT_291 = " source, ";
  protected final String TEXT_292 = " destination, ";
  protected final String TEXT_293 = " linkElement, ";
  protected final String TEXT_294 = " elementType, int linkVID) {" + NL + "\t\tthis(source, destination, linkVID);" + NL + "\t\tmyLinkElement = linkElement;" + NL + "\t\tfinal ";
  protected final String TEXT_295 = " elementTypeCopy = elementType;" + NL + "\t\tmySemanticAdapter = new ";
  protected final String TEXT_296 = "(linkElement) {" + NL + "\t\t\tpublic Object getAdapter(Class adapter) {" + NL + "\t\t\t\tif (";
  protected final String TEXT_297 = ".class.equals(adapter)) {" + NL + "\t\t\t\t\treturn elementTypeCopy;" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn super.getAdapter(adapter);" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "   \t * @generated" + NL + "     */" + NL + "\tprotected LinkDescriptor(";
  protected final String TEXT_298 = " source, ";
  protected final String TEXT_299 = " destination, ";
  protected final String TEXT_300 = " elementType, int linkVID) {" + NL + "\t\tthis(source, destination, linkVID);" + NL + "\t\tmyLinkElement = null;" + NL + "\t\tfinal ";
  protected final String TEXT_301 = " elementTypeCopy = elementType;" + NL + "\t\tmySemanticAdapter = new ";
  protected final String TEXT_302 = "() {" + NL + "\t\t\tpublic Object getAdapter(Class adapter) {" + NL + "\t\t\t\tif (";
  protected final String TEXT_303 = ".class.equals(adapter)) {" + NL + "\t\t\t\t\treturn elementTypeCopy;" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn null;" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t}" + NL + "\t\t" + NL + "\t/**" + NL + "   \t * @generated" + NL + "     */" + NL + "\tprivate LinkDescriptor(";
  protected final String TEXT_304 = " source, ";
  protected final String TEXT_305 = " destination, int linkVID) {" + NL + "\t\tmySource = source;" + NL + "\t\tmyDestination = destination;" + NL + "\t\tmyVisualID = linkVID;" + NL + "\t}" + NL + "\t\t" + NL + "\t/**" + NL + "   \t * @generated" + NL + "     */" + NL + "\tprotected ";
  protected final String TEXT_306 = " getSource() {" + NL + "\t\treturn mySource;" + NL + "\t}" + NL + "\t\t" + NL + "\t/**" + NL + "   \t * @generated" + NL + "     */" + NL + "\tprotected ";
  protected final String TEXT_307 = " getDestination() {" + NL + "\t\treturn myDestination;" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "   \t * @generated" + NL + "     */" + NL + "\tprotected ";
  protected final String TEXT_308 = " getLinkElement() {" + NL + "\t\treturn myLinkElement;" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "   \t * @generated" + NL + "     */" + NL + "\tprotected int getVisualID() {" + NL + "\t\treturn myVisualID;" + NL + "\t}" + NL + "\t\t" + NL + "\t/**" + NL + "   \t * @generated" + NL + "     */" + NL + "\tprotected ";
  protected final String TEXT_309 = " getSemanticAdapter() {" + NL + "\t\treturn mySemanticAdapter;" + NL + "\t}" + NL + "}" + NL + "" + NL + "}";
  protected final String TEXT_310 = NL;

	protected final String getFeatureValueGetter(String containerName, GenFeature feature, boolean isContainerEObject, ImportAssistant importManager) {
		StringBuffer result = new StringBuffer();
		if (feature.getGenClass().isExternalInterface()) {
// Using EMF reflective method to access feature value
			result.append("((");
			if (feature.isListType()) {
				result.append(importManager.getImportedName("java.util.Collection"));
			} else {
				if (feature.getTypeGenClass() != null) {
					result.append(importManager.getImportedName(feature.getTypeGenClass().getQualifiedInterfaceName()));
				} else {
					// EDataType
					result.append(importManager.getImportedName(feature.getTypeGenClassifier().getEcoreClassifier().getInstanceClassName()));
				}

			}
			result.append(")");
			if (!isContainerEObject) {
// Casting container to EObject - ExternalIntarfce could be not an instance of EObject
				result.append("((");
				result.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
				result.append(")");
			}
			result.append(containerName);
			if (!isContainerEObject) {
				result.append(")");
			}
			result.append(".eGet(");
			result.append(importManager.getImportedName(feature.getGenPackage().getQualifiedPackageInterfaceName()));
			result.append(".eINSTANCE.get");
			result.append(feature.getFeatureAccessorName());
			result.append("()))");
		} else {
			if (isContainerEObject) {
// Casting container to the typed interface
				result.append("((");
				result.append(importManager.getImportedName(feature.getGenClass().getQualifiedInterfaceName()));
				result.append(")");
			}
			result.append(containerName);
			if (isContainerEObject) {
				result.append(")");
			}
			result.append(".");
			result.append(feature.getGetAccessor());
			result.append("()");
		}
		return result.toString();
	}
	
	protected final String getFeatureValueSetterPrefix(String containerName, GenFeature feature, boolean isContainerEObject, ImportAssistant importManager) {
		StringBuffer result = new StringBuffer();
		if (feature.getGenClass().isExternalInterface()) {
// Using EMF reflective method to access feature value
			if (!isContainerEObject) {
// Casting container to EObject - ExternalIntarfce could be not an instance of EObject
				result.append("((");
				result.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
				result.append(")");
			}
			result.append(containerName);
			if (!isContainerEObject) {
				result.append(")");
			}
			result.append(".eSet(");
			result.append(importManager.getImportedName(feature.getGenPackage().getQualifiedPackageInterfaceName()));
			result.append(".eINSTANCE.get");
			result.append(feature.getFeatureAccessorName());
			result.append("(), ");
		} else {
			if (isContainerEObject) {
// Casting container to the typed interface
				result.append("((");
				result.append(importManager.getImportedName(feature.getGenClass().getQualifiedInterfaceName()));
				result.append(")");
			}
			result.append(containerName);
			if (isContainerEObject) {
				result.append(")");
			}
			if (feature.isListType()) {
				result.append(".");
				result.append(feature.getGetAccessor());
				result.append("().add(");
			} else {
				result.append(".set");
				result.append(feature.getAccessorName());
				result.append("(");
			}
		}
		return result.toString();
	}
 
	protected final String getMetaClassAccessor(GenClass genClass, ImportAssistant importManager) {
		StringBuffer buf = new StringBuffer();
		buf.append(importManager.getImportedName(genClass.getGenPackage().getQualifiedPackageInterfaceName()))
			.append(".eINSTANCE.get") //$NON-NLS-1$
			.append(genClass.getName())
			.append("()"); //$NON-NLS-1$
		return buf.toString();
	} 
 
	public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
/*
	This template should be called only for non-design diagrams (domainDiagramElement != null) 
	because *CanonicalEditPolicy responsible for dealing with semantic model 
	elements and meaningless (should not be generated) for pure design diagrams.  
*/

final GenDiagram genDiagram = (GenDiagram) ((Object[]) argument)[0];
final ImportAssistant importManager = (ImportAssistant) ((Object[]) argument)[1];

    stringBuffer.append(TEXT_1);
    
String copyrightText = genDiagram.getEditorGen().getCopyrightText();
if (copyrightText != null && copyrightText.trim().length() > 0) {

    stringBuffer.append(TEXT_2);
    stringBuffer.append(copyrightText.replaceAll("\n", "\n *"));
    stringBuffer.append(TEXT_3);
    }
    importManager.emitPackageStatement(stringBuffer);
    stringBuffer.append(TEXT_4);
    importManager.markImportLocation(stringBuffer);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(genDiagram.getCanonicalEditPolicyClassName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalConnectionEditPolicy"));
    stringBuffer.append(TEXT_7);
    List genNodes = genDiagram.getTopLevelNodes();
    stringBuffer.append(TEXT_8);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_10);
    if (genNodes.size() > 0) {
    stringBuffer.append(TEXT_11);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_12);
    stringBuffer.append(importManager.getImportedName("java.util.LinkedList"));
    stringBuffer.append(TEXT_13);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_14);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_15);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_16);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_17);
    stringBuffer.append(TEXT_18);
    
Map genFeature2genNodeMap = new LinkedHashMap();
for (int nodeIndex = 0; nodeIndex < genNodes.size(); nodeIndex++) {
	GenNode nextNode = (GenNode) genNodes.get(nodeIndex);
	TypeModelFacet typeModelFacet = nextNode.getModelFacet();
	if (typeModelFacet.isPhantomElement()) {
		// Skipping top-level phantoms
		continue;
	}
	GenFeature childMetaFeature = typeModelFacet.getChildMetaFeature();
	if (!genFeature2genNodeMap.containsKey(childMetaFeature)) {
		genFeature2genNodeMap.put(childMetaFeature, new ArrayList());
	}
	((Collection) genFeature2genNodeMap.get(childMetaFeature)).add(nextNode);
}

Set entrySet = genFeature2genNodeMap.entrySet();
if (entrySet.size() > 0) {

    stringBuffer.append(TEXT_19);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_20);
    
}

for (Iterator entries = entrySet.iterator(); entries.hasNext();) {
	Map.Entry nextEntry = (Map.Entry) entries.next();
	GenFeature childMetaFeature = (GenFeature) nextEntry.getKey();
	Collection genNodesCollection = (Collection) nextEntry.getValue();
	if (childMetaFeature.isListType()) {

    stringBuffer.append(TEXT_21);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_22);
    stringBuffer.append(getFeatureValueGetter("modelObject", childMetaFeature, true, importManager));
    stringBuffer.append(TEXT_23);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_24);
    	} else {
    stringBuffer.append(TEXT_25);
    stringBuffer.append(getFeatureValueGetter("modelObject", childMetaFeature, true, importManager));
    stringBuffer.append(TEXT_26);
    	}
    stringBuffer.append(TEXT_27);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_28);
    	boolean generateSwitch = genNodesCollection.size() != 1;
	if (generateSwitch) {
    stringBuffer.append(TEXT_29);
    	}
	
	for (Iterator genNodesIterator = genNodesCollection.iterator(); genNodesIterator.hasNext();) {
		GenNode nextNode = (GenNode) genNodesIterator.next();
		if (generateSwitch) {
    stringBuffer.append(TEXT_30);
    stringBuffer.append(importManager.getImportedName(nextNode.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_31);
    		} else {
    stringBuffer.append(TEXT_32);
    stringBuffer.append(importManager.getImportedName(nextNode.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_33);
    		}
    stringBuffer.append(TEXT_34);
    stringBuffer.append(TEXT_35);
    		if (generateSwitch) {
    stringBuffer.append(TEXT_36);
    		}
    stringBuffer.append(TEXT_37);
    	}
	if (generateSwitch) {
    stringBuffer.append(TEXT_38);
    	}
	if (childMetaFeature.isListType()) {
    stringBuffer.append(TEXT_39);
    	}
}
    stringBuffer.append(TEXT_40);
    } else {
    stringBuffer.append(TEXT_41);
    stringBuffer.append(importManager.getImportedName("java.util.Collections"));
    stringBuffer.append(TEXT_42);
    }
    stringBuffer.append(TEXT_43);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_44);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_45);
    for (Iterator it = genNodes.iterator(); it.hasNext();) {
	GenNode nextNode = (GenNode) it.next();
    stringBuffer.append(TEXT_46);
    stringBuffer.append(importManager.getImportedName(nextNode.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_47);
    }
    stringBuffer.append(TEXT_48);
    stringBuffer.append(importManager.getImportedName("java.util.Collections"));
    stringBuffer.append(TEXT_49);
    stringBuffer.append(TEXT_50);
    final Map<GenClass, GenTopLevelNode> genClass2Phantom = genDiagram.getGenClass2PhantomMap();
    stringBuffer.append(TEXT_51);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_52);
    stringBuffer.append(importManager.getImportedName("java.util.LinkedList"));
    stringBuffer.append(TEXT_53);
    if (genDiagram.isSynchronized() && genClass2Phantom.size() > 0) {
    stringBuffer.append(TEXT_54);
    }
    stringBuffer.append(TEXT_55);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_56);
    stringBuffer.append(importManager.getImportedName("java.util.LinkedList"));
    stringBuffer.append(TEXT_57);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.commands.DeferredLayoutCommand"));
    stringBuffer.append(TEXT_58);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.commands.DeferredLayoutCommand"));
    stringBuffer.append(TEXT_59);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy"));
    stringBuffer.append(TEXT_60);
    if (genDiagram.isSynchronized() && genClass2Phantom.size() > 0) {
    stringBuffer.append(TEXT_61);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_62);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_63);
    stringBuffer.append(importManager.getImportedName("java.util.LinkedList"));
    stringBuffer.append(TEXT_64);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_65);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_66);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Diagram"));
    stringBuffer.append(TEXT_67);
    stringBuffer.append(TEXT_68);
    
if (!genClass2Phantom.isEmpty()) {

    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.resource.Resource"));
    stringBuffer.append(TEXT_69);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_70);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_71);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_72);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_73);
    
}
for (Iterator phantoms = genClass2Phantom.values().iterator(); phantoms.hasNext();) {
	GenTopLevelNode phantomNode = (GenTopLevelNode) phantoms.next();

    stringBuffer.append(TEXT_74);
    stringBuffer.append(importManager.getImportedName(phantomNode.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_75);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(TEXT_77);
    }
if (!genClass2Phantom.isEmpty()) {

    stringBuffer.append(TEXT_78);
    }
    stringBuffer.append(TEXT_79);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_82);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_83);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_84);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_85);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_88);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_89);
    stringBuffer.append(importManager.getImportedName("java.util.Collections"));
    stringBuffer.append(TEXT_90);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_91);
    stringBuffer.append(importManager.getImportedName("java.util.ArrayList"));
    stringBuffer.append(TEXT_92);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_93);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_94);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_95);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest"));
    stringBuffer.append(TEXT_96);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Diagram"));
    stringBuffer.append(TEXT_97);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_98);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest"));
    stringBuffer.append(TEXT_99);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_100);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.common.core.command.CompositeCommand"));
    stringBuffer.append(TEXT_101);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.common.core.command.CompositeCommand"));
    stringBuffer.append(TEXT_102);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages"));
    stringBuffer.append(TEXT_103);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_104);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest"));
    stringBuffer.append(TEXT_105);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest"));
    stringBuffer.append(TEXT_106);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.common.core.command.ICommand"));
    stringBuffer.append(TEXT_107);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.commands.CreateCommand"));
    stringBuffer.append(TEXT_108);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart"));
    stringBuffer.append(TEXT_109);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy"));
    stringBuffer.append(TEXT_110);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_111);
    stringBuffer.append(importManager.getImportedName("java.util.Collections"));
    stringBuffer.append(TEXT_112);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.commands.SetViewMutabilityCommand"));
    stringBuffer.append(TEXT_113);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter"));
    stringBuffer.append(TEXT_114);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart"));
    stringBuffer.append(TEXT_115);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_116);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_117);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_118);
    }
    stringBuffer.append(TEXT_119);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_120);
    stringBuffer.append(importManager.getImportedName("java.util.LinkedList"));
    stringBuffer.append(TEXT_121);
    stringBuffer.append(importManager.getImportedName("java.util.Map"));
    stringBuffer.append(TEXT_122);
    stringBuffer.append(importManager.getImportedName("java.util.HashMap"));
    stringBuffer.append(TEXT_123);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_124);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_125);
    stringBuffer.append(importManager.getImportedName("java.util.LinkedList"));
    stringBuffer.append(TEXT_126);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_127);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_128);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_129);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_130);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_131);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_132);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_133);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_134);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_135);
    
for (Iterator containers = genDiagram.getAllContainers().iterator(); containers.hasNext();) {
	GenContainerBase nextContainer = (GenContainerBase) containers.next();
	if (nextContainer instanceof GenCompartment) {
		continue;
	}
	if (nextContainer instanceof GenNode && ((GenNode) nextContainer).getModelFacet() == null) {
		continue;
	}

    stringBuffer.append(TEXT_136);
    stringBuffer.append(importManager.getImportedName(nextContainer.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_137);
    
}		
    stringBuffer.append(TEXT_138);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_139);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_140);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_141);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_142);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_143);
    stringBuffer.append(importManager.getImportedName("java.util.Collections"));
    stringBuffer.append(TEXT_144);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_145);
    stringBuffer.append(importManager.getImportedName("java.util.LinkedList"));
    stringBuffer.append(TEXT_146);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_147);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_148);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_149);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest"));
    stringBuffer.append(TEXT_150);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest"));
    stringBuffer.append(TEXT_151);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.core.util.ViewUtil"));
    stringBuffer.append(TEXT_152);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart"));
    stringBuffer.append(TEXT_153);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest"));
    stringBuffer.append(TEXT_154);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest"));
    stringBuffer.append(TEXT_155);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants"));
    stringBuffer.append(TEXT_156);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants"));
    stringBuffer.append(TEXT_157);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_158);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.IAdaptable"));
    stringBuffer.append(TEXT_159);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.IAdaptable"));
    stringBuffer.append(TEXT_160);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_161);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_162);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_163);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_164);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_165);
    
boolean createPhantoms = false;
List genLinks = genDiagram.getLinks();

    stringBuffer.append(TEXT_166);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_168);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Diagram"));
    stringBuffer.append(TEXT_169);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EClass"));
    stringBuffer.append(TEXT_170);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_171);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EClass"));
    stringBuffer.append(TEXT_172);
    
for (Iterator it = genLinks.iterator(); it.hasNext();) {
	GenLink nextLink = (GenLink) it.next();
	if (nextLink.getModelFacet() instanceof TypeLinkModelFacet) {
		TypeLinkModelFacet typeLinkModelFacet = (TypeLinkModelFacet) nextLink.getModelFacet();

    stringBuffer.append(TEXT_173);
    stringBuffer.append(typeLinkModelFacet.getMetaClass().getInterfaceName());
    stringBuffer.append(TEXT_174);
    stringBuffer.append(nextLink.getVisualID());
    stringBuffer.append(TEXT_175);
    
	}
}

    stringBuffer.append(TEXT_176);
    
for (Iterator it = genLinks.iterator(); it.hasNext();) {
	GenLink nextLink = (GenLink) it.next();
	if (nextLink.getModelFacet() instanceof TypeLinkModelFacet) {
		TypeLinkModelFacet typeLinkModelFacet = (TypeLinkModelFacet) nextLink.getModelFacet();
		GenFeature childMetaFeature = typeLinkModelFacet.getChildMetaFeature();
		GenFeature sourceMetaFeature = typeLinkModelFacet.getSourceMetaFeature();
		GenFeature targetMetaFeature = typeLinkModelFacet.getTargetMetaFeature();

    stringBuffer.append(TEXT_177);
    stringBuffer.append(typeLinkModelFacet.getMetaClass().getInterfaceName());
    stringBuffer.append(TEXT_178);
    stringBuffer.append(nextLink.getVisualID());
    stringBuffer.append(TEXT_179);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_180);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EClass"));
    stringBuffer.append(TEXT_181);
    stringBuffer.append(importManager.getImportedName(childMetaFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_182);
    stringBuffer.append(childMetaFeature.getGenClass().getClassifierAccessorName());
    stringBuffer.append(TEXT_183);
    		if (childMetaFeature.isListType()) {
    stringBuffer.append(TEXT_184);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_185);
    stringBuffer.append(getFeatureValueGetter("container", childMetaFeature, true, importManager));
    stringBuffer.append(TEXT_186);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_187);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_188);
    		} else {
    stringBuffer.append(TEXT_189);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_190);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_191);
    stringBuffer.append(getFeatureValueGetter("container", childMetaFeature, true, importManager));
    stringBuffer.append(TEXT_192);
    		}
    stringBuffer.append(TEXT_193);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_194);
    stringBuffer.append(importManager.getImportedName(nextLink.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_195);
    stringBuffer.append(getFeatureValueGetter("nextValue", targetMetaFeature, true, importManager));
    stringBuffer.append(TEXT_196);
     if (targetMetaFeature.isListType()){ 
    stringBuffer.append(TEXT_197);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_198);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_199);
     } 
    stringBuffer.append(TEXT_200);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_201);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_202);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_203);
     if (sourceMetaFeature != null) {
    stringBuffer.append(TEXT_204);
    stringBuffer.append(getFeatureValueGetter("nextValue", sourceMetaFeature, true, importManager));
    stringBuffer.append(TEXT_205);
     		if (sourceMetaFeature.isListType()){ 
    stringBuffer.append(TEXT_206);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_207);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_208);
     		}
    stringBuffer.append(TEXT_209);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_210);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_211);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_212);
    stringBuffer.append(genDiagram.getElementTypesQualifiedClassName());
    stringBuffer.append(TEXT_213);
    stringBuffer.append(nextLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_214);
     } else { // sourceMetaFeature == null 
    stringBuffer.append(TEXT_215);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_216);
    stringBuffer.append(genDiagram.getElementTypesQualifiedClassName());
    stringBuffer.append(TEXT_217);
    stringBuffer.append(nextLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_218);
     }
    stringBuffer.append(TEXT_219);
    
		if (childMetaFeature.isListType()) {

    stringBuffer.append(TEXT_220);
    
		}

    stringBuffer.append(TEXT_221);
    
	}
}

    stringBuffer.append(TEXT_222);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_223);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EClass"));
    stringBuffer.append(TEXT_224);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Diagram"));
    stringBuffer.append(TEXT_225);
    
for (int linkIndex = 0; linkIndex < genLinks.size(); linkIndex++) {
	boolean phantomsOnly = true;

    stringBuffer.append(TEXT_226);
    
GenLink nextLink = (GenLink) genLinks.get(linkIndex);
if (false == nextLink.getModelFacet() instanceof FeatureLinkModelFacet) {
	continue;
}
FeatureLinkModelFacet linkFMF = (FeatureLinkModelFacet) nextLink.getModelFacet();
GenFeature genFeature = linkFMF.getMetaFeature();
GenTopLevelNode phantomNode = (GenTopLevelNode) genClass2Phantom.get(genFeature.getTypeGenClass());
if (phantomsOnly ? (!genFeature.isContains() || phantomNode == null) : (genFeature.isContains())) {
// Processing only features which are isPhantoms == phantomsOnly
	continue;
}

    stringBuffer.append(TEXT_227);
    stringBuffer.append(importManager.getImportedName(genFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_228);
    stringBuffer.append(genFeature.getGenClass().getClassifierAccessorName());
    stringBuffer.append(TEXT_229);
    	if (genFeature.isListType()) {
    stringBuffer.append(TEXT_230);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_231);
    stringBuffer.append(getFeatureValueGetter("container", genFeature, true, importManager));
    stringBuffer.append(TEXT_232);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_233);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_234);
    	} else {
    stringBuffer.append(TEXT_235);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_236);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_237);
    stringBuffer.append(getFeatureValueGetter("container", genFeature, true, importManager));
    stringBuffer.append(TEXT_238);
    	}
    	if (phantomsOnly) {
    stringBuffer.append(TEXT_239);
    stringBuffer.append(importManager.getImportedName(phantomNode.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_240);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_241);
    	}
    stringBuffer.append(TEXT_242);
    stringBuffer.append(importManager.getImportedName(genDiagram.getElementTypesQualifiedClassName()));
    stringBuffer.append(TEXT_243);
    stringBuffer.append(nextLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_244);
    stringBuffer.append(importManager.getImportedName(nextLink.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_245);
    	if (createPhantoms) {
    stringBuffer.append(TEXT_246);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_247);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_248);
    stringBuffer.append(importManager.getImportedName(phantomNode.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_249);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorGen().getPlugin().getActivatorQualifiedClassName()));
    stringBuffer.append(TEXT_250);
    stringBuffer.append(phantomNode.getUniqueIdentifier());
    stringBuffer.append(TEXT_251);
    	}
    stringBuffer.append(TEXT_252);
    	if (phantomsOnly) {
    stringBuffer.append(TEXT_253);
    	}
	if (genFeature.isListType()) {
    stringBuffer.append(TEXT_254);
    	}
    stringBuffer.append(TEXT_255);
    
}

for (int linkIndex = 0; linkIndex < genLinks.size(); linkIndex++) {
	boolean phantomsOnly = false;

    stringBuffer.append(TEXT_256);
    
GenLink nextLink = (GenLink) genLinks.get(linkIndex);
if (false == nextLink.getModelFacet() instanceof FeatureLinkModelFacet) {
	continue;
}
FeatureLinkModelFacet linkFMF = (FeatureLinkModelFacet) nextLink.getModelFacet();
GenFeature genFeature = linkFMF.getMetaFeature();
GenTopLevelNode phantomNode = (GenTopLevelNode) genClass2Phantom.get(genFeature.getTypeGenClass());
if (phantomsOnly ? (!genFeature.isContains() || phantomNode == null) : (genFeature.isContains())) {
// Processing only features which are isPhantoms == phantomsOnly
	continue;
}

    stringBuffer.append(TEXT_257);
    stringBuffer.append(importManager.getImportedName(genFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_258);
    stringBuffer.append(genFeature.getGenClass().getClassifierAccessorName());
    stringBuffer.append(TEXT_259);
    	if (genFeature.isListType()) {
    stringBuffer.append(TEXT_260);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_261);
    stringBuffer.append(getFeatureValueGetter("container", genFeature, true, importManager));
    stringBuffer.append(TEXT_262);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_263);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_264);
    	} else {
    stringBuffer.append(TEXT_265);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_266);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_267);
    stringBuffer.append(getFeatureValueGetter("container", genFeature, true, importManager));
    stringBuffer.append(TEXT_268);
    	}
    	if (phantomsOnly) {
    stringBuffer.append(TEXT_269);
    stringBuffer.append(importManager.getImportedName(phantomNode.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_270);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_271);
    	}
    stringBuffer.append(TEXT_272);
    stringBuffer.append(importManager.getImportedName(genDiagram.getElementTypesQualifiedClassName()));
    stringBuffer.append(TEXT_273);
    stringBuffer.append(nextLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_274);
    stringBuffer.append(importManager.getImportedName(nextLink.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_275);
    stringBuffer.append(TEXT_276);
    	if (phantomsOnly) {
    stringBuffer.append(TEXT_277);
    	}
	if (genFeature.isListType()) {
    stringBuffer.append(TEXT_278);
    	}
    stringBuffer.append(TEXT_279);
    }
    stringBuffer.append(TEXT_280);
    stringBuffer.append(TEXT_281);
    stringBuffer.append(TEXT_282);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Diagram"));
    stringBuffer.append(TEXT_283);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_284);
    stringBuffer.append(TEXT_285);
    
// an inner class 

    stringBuffer.append(TEXT_286);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_287);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_288);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_289);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.IAdaptable"));
    stringBuffer.append(TEXT_290);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_291);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_292);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_293);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.IElementType"));
    stringBuffer.append(TEXT_294);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.IElementType"));
    stringBuffer.append(TEXT_295);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter"));
    stringBuffer.append(TEXT_296);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.IElementType"));
    stringBuffer.append(TEXT_297);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_298);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_299);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.IElementType"));
    stringBuffer.append(TEXT_300);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.IElementType"));
    stringBuffer.append(TEXT_301);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.IAdaptable"));
    stringBuffer.append(TEXT_302);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.IElementType"));
    stringBuffer.append(TEXT_303);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_304);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_305);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_306);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_307);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_308);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.IAdaptable"));
    stringBuffer.append(TEXT_309);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_310);
    return stringBuffer.toString();
  }
}