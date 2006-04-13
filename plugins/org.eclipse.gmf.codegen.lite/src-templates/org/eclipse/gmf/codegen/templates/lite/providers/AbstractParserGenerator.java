package org.eclipse.gmf.codegen.templates.lite.providers;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.common.codegen.*;

public class AbstractParserGenerator
{
  protected static String nl;
  public static synchronized AbstractParserGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    AbstractParserGenerator result = new AbstractParserGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "/*" + NL + " * ";
  protected final String TEXT_3 = NL + " */";
  protected final String TEXT_4 = NL;
  protected final String TEXT_5 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public abstract class ";
  protected final String TEXT_6 = " {" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static Object parseValue(";
  protected final String TEXT_7 = " feature, Object value) throws IllegalArgumentException {" + NL + "\t\tif (value == null) {" + NL + "\t\t\tthrow new IllegalArgumentException();" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_8 = " type = feature.getEAttributeType();" + NL + "\t\tClass iClass = type.getInstanceClass();" + NL + "\t\tif (Boolean.TYPE.equals(iClass) || Boolean.class.equals(iClass)) {" + NL + "\t\t\tif (value instanceof Boolean) {" + NL + "\t\t\t\t// ok" + NL + "\t\t\t} else if (value instanceof String) {" + NL + "\t\t\t\tvalue = Boolean.valueOf((String) value);" + NL + "\t\t\t} else {" + NL + "\t\t\t\tthrow new IllegalArgumentException(\"Value of type Boolean is expected\");" + NL + "\t\t\t}" + NL + "\t\t} else if (Character.TYPE.equals(iClass) || Character.class.equals(iClass)) {" + NL + "\t\t\tif (value instanceof Character) {" + NL + "\t\t\t\t// ok" + NL + "\t\t\t} else if (value instanceof String) {" + NL + "\t\t\t\tString s = (String) value;" + NL + "\t\t\t\tif (s.length() == 0) {" + NL + "\t\t\t\t\tthrow new IllegalArgumentException();\t//XXX: ?" + NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\tvalue = new Character(s.charAt(0));" + NL + "\t\t\t\t}" + NL + "\t\t\t} else {" + NL + "\t\t\t\tthrow new IllegalArgumentException(\"Value of type Character is expected\");" + NL + "\t\t\t}" + NL + "\t\t} else if (Byte.TYPE.equals(iClass) || Byte.class.equals(iClass)) {" + NL + "\t\t\tif (value instanceof Byte) {" + NL + "\t\t\t\t// ok" + NL + "\t\t\t} else if (value instanceof Number) {" + NL + "\t\t\t\tvalue = new Byte(((Number) value).byteValue());" + NL + "\t\t\t} else if (value instanceof String) {" + NL + "\t\t\t\tString s = (String) value;" + NL + "\t\t\t\tif (s.length() == 0) {" + NL + "\t\t\t\t\tvalue = null;" + NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\tvalue = Byte.valueOf(s);" + NL + "\t\t\t\t\t} catch (NumberFormatException nfe) {" + NL + "\t\t\t\t\t\tthrow new IllegalArgumentException(\"String value does not convert to Byte value\");" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t} else {" + NL + "\t\t\t\tthrow new IllegalArgumentException(\"Value of type Byte is expected\");" + NL + "\t\t\t}" + NL + "\t\t} else if (Short.TYPE.equals(iClass) || Short.class.equals(iClass)) {" + NL + "\t\t\tif (value instanceof Short) {" + NL + "\t\t\t\t// ok" + NL + "\t\t\t} else if (value instanceof Number) {" + NL + "\t\t\t\tvalue = new Short(((Number) value).shortValue());" + NL + "\t\t\t} else if (value instanceof String) {" + NL + "\t\t\t\tString s = (String) value;" + NL + "\t\t\t\tif (s.length() == 0) {" + NL + "\t\t\t\t\tvalue = null;" + NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\tvalue = Short.valueOf(s);" + NL + "\t\t\t\t\t} catch (NumberFormatException nfe) {" + NL + "\t\t\t\t\t\tthrow new IllegalArgumentException(\"String value does not convert to Short value\");" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t} else {" + NL + "\t\t\t\tthrow new IllegalArgumentException(\"Value of type Short is expected\");" + NL + "\t\t\t}" + NL + "\t\t} else if (Integer.TYPE.equals(iClass) || Integer.class.equals(iClass)) {" + NL + "\t\t\tif (value instanceof Integer) {" + NL + "\t\t\t\t// ok" + NL + "\t\t\t} else if (value instanceof Number) {" + NL + "\t\t\t\tvalue = new Integer(((Number) value).intValue());" + NL + "\t\t\t} else if (value instanceof String) {" + NL + "\t\t\t\tString s = (String) value;" + NL + "\t\t\t\tif (s.length() == 0) {" + NL + "\t\t\t\t\tvalue = null;" + NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\tvalue = Integer.valueOf(s);" + NL + "\t\t\t\t\t} catch (NumberFormatException nfe) {" + NL + "\t\t\t\t\t\tthrow new IllegalArgumentException(\"String value does not convert to Integer value\");" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t} else {" + NL + "\t\t\t\tthrow new IllegalArgumentException(\"Value of type Integer is expected\");" + NL + "\t\t\t}" + NL + "\t\t} else if (Long.TYPE.equals(iClass) || Long.class.equals(iClass)) {" + NL + "\t\t\tif (value instanceof Long) {" + NL + "\t\t\t\t// ok" + NL + "\t\t\t} else if (value instanceof Number) {" + NL + "\t\t\t\tvalue = new Long(((Number) value).longValue());" + NL + "\t\t\t} else if (value instanceof String) {" + NL + "\t\t\t\tString s = (String) value;" + NL + "\t\t\t\tif (s.length() == 0) {" + NL + "\t\t\t\t\tvalue = null;" + NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\tvalue = Long.valueOf(s);" + NL + "\t\t\t\t\t} catch (NumberFormatException nfe) {" + NL + "\t\t\t\t\t\tthrow new IllegalArgumentException(\"String value does not convert to Long value\");" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t} else {" + NL + "\t\t\t\tthrow new IllegalArgumentException(\"Value of type Long is expected\");" + NL + "\t\t\t}" + NL + "\t\t} else if (Float.TYPE.equals(iClass) || Float.class.equals(iClass)) {" + NL + "\t\t\tif (value instanceof Float) {" + NL + "\t\t\t\t// ok" + NL + "\t\t\t} else if (value instanceof Number) {" + NL + "\t\t\t\tvalue = new Float(((Number) value).floatValue());" + NL + "\t\t\t} else if (value instanceof String) {" + NL + "\t\t\t\tString s = (String) value;" + NL + "\t\t\t\tif (s.length() == 0) {" + NL + "\t\t\t\t\tvalue = null;" + NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\tvalue = Float.valueOf(s);" + NL + "\t\t\t\t\t} catch (NumberFormatException nfe) {" + NL + "\t\t\t\t\t\tthrow new IllegalArgumentException(\"String value does not convert to Float value\");" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t} else {" + NL + "\t\t\t\tthrow new IllegalArgumentException(\"Value of type Float is expected\");" + NL + "\t\t\t}" + NL + "\t\t} else if (Double.TYPE.equals(iClass) || Double.class.equals(iClass)) {" + NL + "\t\t\tif (value instanceof Double) {" + NL + "\t\t\t\t// ok" + NL + "\t\t\t} else if (value instanceof Number) {" + NL + "\t\t\t\tvalue = new Double(((Number) value).doubleValue());" + NL + "\t\t\t} else if (value instanceof String) {" + NL + "\t\t\t\tString s = (String) value;" + NL + "\t\t\t\tif (s.length() == 0) {" + NL + "\t\t\t\t\tvalue = null;" + NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\tvalue = Double.valueOf(s);" + NL + "\t\t\t\t\t} catch (NumberFormatException nfe) {" + NL + "\t\t\t\t\t\tthrow new IllegalArgumentException(\"String value does not convert to Double value\");" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t} else {" + NL + "\t\t\t\tthrow new IllegalArgumentException(\"Value of type Double is expected\");" + NL + "\t\t\t}" + NL + "\t\t} else if (String.class.equals(iClass)) {" + NL + "\t\t\tvalue = String.valueOf(value);" + NL + "\t\t} else if (type instanceof ";
  protected final String TEXT_9 = ") {" + NL + "\t\t\tif (value instanceof String) {" + NL + "\t\t\t\t";
  protected final String TEXT_10 = " literal = ((";
  protected final String TEXT_11 = ") type).getEEnumLiteralByLiteral((String) value);" + NL + "\t\t\t\tif (literal == null) {" + NL + "\t\t\t\t\tthrow new IllegalArgumentException(\"Unknown literal: \" + value);" + NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\tvalue = literal.getInstance();" + NL + "\t\t\t\t}" + NL + "\t\t\t} else {" + NL + "\t\t\t\tthrow new IllegalArgumentException(\"Value of type String is expected\");" + NL + "\t\t\t}" + NL + "\t\t} else {" + NL + "\t\t\tthrow new IllegalArgumentException(\"Unsupported type\");" + NL + "\t\t}" + NL + "\t\treturn value;" + NL + "\t}" + NL + "}";
  protected final String TEXT_12 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    GenDiagram genDiagram = (GenDiagram) ((Object[]) argument)[0];
    ImportAssistant importManager = (ImportAssistant) ((Object[])argument)[1];
    stringBuffer.append(TEXT_1);
    
String copyrightText = genDiagram.getEditorGen().getCopyrightText();
if (copyrightText != null && copyrightText.trim().length() > 0) {

    stringBuffer.append(TEXT_2);
    stringBuffer.append(copyrightText.replaceAll("\n", "\n * "));
    stringBuffer.append(TEXT_3);
    }
    stringBuffer.append(TEXT_4);
    
importManager.emitPackageStatement(stringBuffer);
importManager.markImportLocation(stringBuffer);

    stringBuffer.append(TEXT_5);
    stringBuffer.append(genDiagram.getAbstractParserClassName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EAttribute"));
    stringBuffer.append(TEXT_7);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EDataType"));
    stringBuffer.append(TEXT_8);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EEnum"));
    stringBuffer.append(TEXT_9);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EEnumLiteral"));
    stringBuffer.append(TEXT_10);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EEnum"));
    stringBuffer.append(TEXT_11);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_12);
    return stringBuffer.toString();
  }
}
