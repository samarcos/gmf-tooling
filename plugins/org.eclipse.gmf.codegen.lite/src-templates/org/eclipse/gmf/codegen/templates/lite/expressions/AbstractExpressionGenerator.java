package org.eclipse.gmf.codegen.templates.lite.expressions;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.common.codegen.*;

public class AbstractExpressionGenerator
{
  protected static String nl;
  public static synchronized AbstractExpressionGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    AbstractExpressionGenerator result = new AbstractExpressionGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "/*" + NL + " * ";
  protected final String TEXT_3 = NL + " */";
  protected final String TEXT_4 = NL;
  protected final String TEXT_5 = NL;
  protected final String TEXT_6 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public abstract class ";
  protected final String TEXT_7 = " {\t\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static final boolean DISABLED_NO_IMPL_EXCEPTION_LOG = Boolean.valueOf(Platform.getDebugOption(";
  protected final String TEXT_8 = ".getInstance().getBundle().getSymbolicName() + \"/debug/disableNoExprImplExceptionLog\")).booleanValue();" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate String body;" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate EClassifier context;" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate Map env;\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */\t" + NL + "\tprivate IStatus status = Status.OK_STATUS;\t" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_9 = "(EClassifier context) {" + NL + "\t\tthis.context = context;" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */\t" + NL + "\tprotected ";
  protected final String TEXT_10 = "(String body, EClassifier context, Map env) {" + NL + "\t\tthis.body = body;" + NL + "\t\tthis.context = context;" + NL + "\t\tthis.env = env;" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */\t" + NL + "\tprotected void setStatus(int severity, String message, Throwable throwable) {\t\t" + NL + "\t\tString pluginID = ";
  protected final String TEXT_11 = ".ID;" + NL + "\t\tthis.status = new Status(severity, pluginID, -1, (message != null) ? message : \"\", throwable); //$NON-NLS-1$" + NL + "\t\tif(!this.status.isOK()) {" + NL + "\t\t\t";
  protected final String TEXT_12 = NL + "\t\t\t\t\t.getInstance().logError(\"Expression problem:\" + message + \"body:\"+ body, throwable); //$NON-NLS-1$ //$NON-NLS-2$" + NL + "\t\t" + NL + "\t\t}" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */\t" + NL + "\tprotected abstract Object doEvaluate(Object context, Map env);" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */\t" + NL + "\tpublic Object evaluate(Object context) {" + NL + "\t\treturn evaluate(context, Collections.EMPTY_MAP);" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */\t" + NL + "\tpublic Object evaluate(Object context, Map env) {" + NL + "\t\tif(context().isInstance(context)) {" + NL + "\t\t\ttry {" + NL + "\t\t\t\treturn doEvaluate(context, env);" + NL + "\t\t\t} catch(Exception e) {" + NL + "\t\t\t\tif(DISABLED_NO_IMPL_EXCEPTION_LOG && e instanceof NoImplException) {" + NL + "\t\t\t\t\treturn null;" + NL + "\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_13 = NL + "\t\t\t\t\t.getInstance().logError(\"Expression evaluation failure: \" + body, e);" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\treturn null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */\t" + NL + "\tpublic IStatus getStatus() {" + NL + "\t\treturn status;" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */\t" + NL + "\tpublic String body() {" + NL + "\t\treturn body;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic EClassifier context() {" + NL + "\t\treturn context;" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */\t" + NL + "\tpublic Map environment() {" + NL + "\t\treturn env;" + NL + "\t}\t" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void assignTo(EStructuralFeature feature, EObject target) {" + NL + "\t\tObject value = evaluate(target);" + NL + "\t\tvalue = (value != null) ? performCast(value, feature) : null;" + NL + "\t\tif (feature.isMany()) {" + NL + "\t\t\tCollection destCollection = (Collection) target.eGet(feature);" + NL + "\t\t\tdestCollection.clear();" + NL + "\t\t\tif(value instanceof Collection) {" + NL + "\t\t\t\tCollection valueCollection = (Collection) value;" + NL + "\t\t\t\tfor (Iterator it = valueCollection.iterator(); it.hasNext();) {" + NL + "\t\t\t\t\tdestCollection.add(performCast(it.next(), feature));" + NL + "\t\t\t\t}" + NL + "\t\t\t} else {" + NL + "\t\t\t\tdestCollection.add(value);" + NL + "\t\t\t}" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\ttarget.eSet(feature, value);" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */\t" + NL + "\tprotected Object performCast(Object value, ETypedElement targetType) {" + NL + "\t\tif(targetType.getEType() == null || targetType.getEType().getInstanceClass() == null) {" + NL + "\t\t\treturn value;" + NL + "\t\t}" + NL + "\t\tClass targetClass = targetType.getEType().getInstanceClass();\t" + NL + "\t\tif(value != null && value instanceof Number) {" + NL + "\t\t\tNumber num = (Number)value;" + NL + "\t\t\tClass valClass = value.getClass();\t\t\t" + NL + "\t\t\tClass targetWrapperClass = targetClass;" + NL + "\t\t\tif(targetClass.isPrimitive()) {" + NL + "\t\t\t\ttargetWrapperClass = EcoreUtil.wrapperClassFor(targetClass);" + NL + "\t\t\t}\t\t\t" + NL + "\t\t\tif(valClass.equals(targetWrapperClass)) {" + NL + "\t\t\t\treturn value;\t\t\t\t" + NL + "\t\t\t}" + NL + "\t\t\tif(Number.class.isAssignableFrom(targetWrapperClass)) {" + NL + "\t\t\t\tif(targetWrapperClass.equals(Byte.class)) return new Byte(num.byteValue());" + NL + "\t\t\t\tif(targetWrapperClass.equals(Integer.class)) return new Integer(num.intValue());" + NL + "\t\t\t\tif(targetWrapperClass.equals(Short.class)) return new Short(num.shortValue());" + NL + "\t\t\t\tif(targetWrapperClass.equals(Long.class)) return new Long(num.longValue());\t\t\t\t\t" + NL + "\t\t\t\tif(targetWrapperClass.equals(BigInteger.class)) return BigInteger.valueOf(num.longValue());" + NL + "\t\t\t\tif(targetWrapperClass.equals(Float.class)) return new Float(num.floatValue());" + NL + "\t\t\t\tif(targetWrapperClass.equals(Double.class)) return new Double(num.doubleValue());" + NL + "\t\t\t\tif(targetWrapperClass.equals(BigDecimal.class)) return new BigDecimal(num.doubleValue());" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\treturn value;" + NL + "\t}\t" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */\t" + NL + "\tpublic static final ";
  protected final String TEXT_14 = " createNullExpression(EClassifier context) {" + NL + "\t\treturn new ";
  protected final String TEXT_15 = "(context) {" + NL + "\t\t\tprotected Object doEvaluate(Object context, Map env) {" + NL + "\t\t\t\t// TODO - log entry about not provider available for this expression" + NL + "\t\t\t\treturn null;" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */\t" + NL + "\tpublic static class NoImplException extends RuntimeException {" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */\t" + NL + "\t\tpublic NoImplException(String message) {" + NL + "\t\t\tsuper(message);" + NL + "\t\t}" + NL + "\t}\t" + NL + "}";
  protected final String TEXT_16 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
final GenDiagram genDiagram = (GenDiagram) ((Object[]) argument)[0];
final ImportAssistant importManager = (ImportAssistant) ((Object[]) argument)[1];
final GenExpressionProviderContainer providerContainer = genDiagram.getEditorGen().getExpressionProviders();

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
    
importManager.registerInnerClass("NoImplException");
importManager.addImport("java.math.BigDecimal");
importManager.addImport("java.math.BigInteger");
importManager.addImport("java.util.Collection");
importManager.addImport("java.util.Collections");
importManager.addImport("java.util.Iterator");
importManager.addImport("java.util.Map");
importManager.addImport("org.eclipse.core.runtime.IStatus");
importManager.addImport("org.eclipse.core.runtime.Status");
importManager.addImport("org.eclipse.emf.ecore.EObject");
importManager.addImport("org.eclipse.emf.ecore.EStructuralFeature");
importManager.addImport("org.eclipse.emf.ecore.ETypedElement");
importManager.addImport("org.eclipse.emf.ecore.EClassifier");
importManager.addImport("org.eclipse.emf.ecore.util.EcoreUtil");
importManager.addImport("org.eclipse.core.runtime.Platform");

    stringBuffer.append(TEXT_6);
    stringBuffer.append(providerContainer.getAbstractExpressionClassName());
    stringBuffer.append(TEXT_7);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorGen().getPlugin().getActivatorQualifiedClassName()));
    stringBuffer.append(TEXT_8);
    stringBuffer.append(providerContainer.getAbstractExpressionClassName());
    stringBuffer.append(TEXT_9);
    stringBuffer.append(providerContainer.getAbstractExpressionClassName());
    stringBuffer.append(TEXT_10);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorGen().getPlugin().getActivatorQualifiedClassName()));
    stringBuffer.append(TEXT_11);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorGen().getPlugin().getActivatorQualifiedClassName()));
    stringBuffer.append(TEXT_12);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorGen().getPlugin().getActivatorQualifiedClassName()));
    stringBuffer.append(TEXT_13);
    stringBuffer.append(providerContainer.getAbstractExpressionClassName());
    stringBuffer.append(TEXT_14);
    stringBuffer.append(providerContainer.getAbstractExpressionClassName());
    stringBuffer.append(TEXT_15);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_16);
    return stringBuffer.toString();
  }
}
