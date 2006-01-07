package org.eclipse.gmf.graphdef.codegen.templates;

import org.eclipse.gmf.gmfgraph.*;
import org.eclipse.gmf.gmfgraph.util.*;
import java.util.*;

public class DecorationFigureGenerator
{
  protected static String nl;
  public static synchronized DecorationFigureGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    DecorationFigureGenerator result = new DecorationFigureGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "/**" + NL + " * @generated" + NL + " */" + NL + "class ";
  protected final String TEXT_2 = " extends ";
  protected final String TEXT_3 = " {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_4 = "() {";
  protected final String TEXT_5 = NL;
  protected final String TEXT_6 = "\t\t";
  protected final String TEXT_7 = " ";
  protected final String TEXT_8 = " = new ";
  protected final String TEXT_9 = "();";
  protected final String TEXT_10 = NL;
  protected final String TEXT_11 = NL + "\t\torg.eclipse.draw2d.geometry.PointList pl = new org.eclipse.draw2d.geometry.PointList();";
  protected final String TEXT_12 = NL + "\t\tpl.addPoint(";
  protected final String TEXT_13 = ", ";
  protected final String TEXT_14 = ");";
  protected final String TEXT_15 = NL + "\t\t";
  protected final String TEXT_16 = ".setTemplate(pl);";
  protected final String TEXT_17 = NL + "\t\tsetScale(";
  protected final String TEXT_18 = ", ";
  protected final String TEXT_19 = ");";
  protected final String TEXT_20 = NL;
  protected final String TEXT_21 = NL + "\t\t";
  protected final String TEXT_22 = ".setFill(";
  protected final String TEXT_23 = ");";
  protected final String TEXT_24 = NL + "\t\t";
  protected final String TEXT_25 = ".setOutline(";
  protected final String TEXT_26 = ");";
  protected final String TEXT_27 = NL + "\t\t";
  protected final String TEXT_28 = ".setLineWidth(";
  protected final String TEXT_29 = ");";
  protected final String TEXT_30 = NL + "\t\t";
  protected final String TEXT_31 = ".setLineStyle(org.eclipse.draw2d.Graphics.";
  protected final String TEXT_32 = ");";
  protected final String TEXT_33 = NL + "\t\t";
  protected final String TEXT_34 = ".setFillXOR(";
  protected final String TEXT_35 = ");";
  protected final String TEXT_36 = NL + "\t\t";
  protected final String TEXT_37 = ".setOutlineXOR(";
  protected final String TEXT_38 = ");";
  protected final String TEXT_39 = NL + "\t\t";
  protected final String TEXT_40 = ".addPoint(new org.eclipse.draw2d.geometry.Point(";
  protected final String TEXT_41 = ", ";
  protected final String TEXT_42 = "));";
  protected final String TEXT_43 = NL + "\t\t";
  protected final String TEXT_44 = ".setCornerDimensions(new org.eclipse.draw2d.geometry.Dimension(";
  protected final String TEXT_45 = ", ";
  protected final String TEXT_46 = "));";
  protected final String TEXT_47 = NL + "\t}" + NL + "}";
  protected final String TEXT_48 = NL;

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    
DecorationFigure figure = (DecorationFigure) argument;
assert false == figure instanceof CustomFigure;
final Point scale;
scale = null; //XXX
final GMFGraphSwitch fqnSwitch = new FigureQualifiedNameSwitch();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(figure.getName());
    stringBuffer.append(TEXT_2);
    stringBuffer.append(fqnSwitch.doSwitch(figure));
    stringBuffer.append(TEXT_3);
    stringBuffer.append(figure.getName());
    stringBuffer.append(TEXT_4);
    
DecorationFigure df = figure;
String decFigVarName = "this";
    stringBuffer.append(TEXT_5);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(fqnSwitch.doSwitch(df));
    stringBuffer.append(TEXT_7);
    stringBuffer.append(decFigVarName);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(fqnSwitch.doSwitch(df));
    stringBuffer.append(TEXT_9);
    stringBuffer.append(TEXT_10);
     /*include FigureChildren*/ 
    if ((df instanceof PolylineDecoration || df instanceof PolygonDecoration) && !((Polyline) df).getTemplate().isEmpty()) {
    stringBuffer.append(TEXT_11);
    	for (Iterator pointIt = ((Polyline) df).getTemplate().iterator(); pointIt.hasNext(); ) {
		Point p = (Point) pointIt.next();
    stringBuffer.append(TEXT_12);
    stringBuffer.append(p.getX());
    stringBuffer.append(TEXT_13);
    stringBuffer.append(p.getY());
    stringBuffer.append(TEXT_14);
    } /*for*/ 
    stringBuffer.append(TEXT_15);
    stringBuffer.append(decFigVarName);
    stringBuffer.append(TEXT_16);
    } /*if instanceof */ 
    if (scale != null) {
    stringBuffer.append(TEXT_17);
    stringBuffer.append(scale.getX());
    stringBuffer.append(TEXT_18);
    stringBuffer.append(scale.getY());
    stringBuffer.append(TEXT_19);
    }
    
Shape shapeFigure = (Shape) figure;
String shapeVarName = "this";

    stringBuffer.append(TEXT_20);
    
// PERHAPS, do this with reflection?

    if (shapeFigure.eIsSet(GMFGraphPackage.eINSTANCE.getShape_Fill())) {
    stringBuffer.append(TEXT_21);
    stringBuffer.append(shapeVarName);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(shapeFigure.isFill());
    stringBuffer.append(TEXT_23);
    } if (shapeFigure.eIsSet(GMFGraphPackage.eINSTANCE.getShape_Outline())) {
    stringBuffer.append(TEXT_24);
    stringBuffer.append(shapeVarName);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(shapeFigure.isOutline());
    stringBuffer.append(TEXT_26);
    } if (shapeFigure.eIsSet(GMFGraphPackage.eINSTANCE.getShape_LineWidth())) {
    stringBuffer.append(TEXT_27);
    stringBuffer.append(shapeVarName);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(shapeFigure.getLineWidth());
    stringBuffer.append(TEXT_29);
    } if (shapeFigure.eIsSet(GMFGraphPackage.eINSTANCE.getShape_LineKind())) {
    stringBuffer.append(TEXT_30);
    stringBuffer.append(shapeVarName);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(shapeFigure.getLineKind().getName());
    stringBuffer.append(TEXT_32);
    } if (shapeFigure.eIsSet(GMFGraphPackage.eINSTANCE.getShape_XorFill())) {
    stringBuffer.append(TEXT_33);
    stringBuffer.append(shapeVarName);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(shapeFigure.isXorFill());
    stringBuffer.append(TEXT_35);
    } if (shapeFigure.eIsSet(GMFGraphPackage.eINSTANCE.getShape_XorOutline())) {
    stringBuffer.append(TEXT_36);
    stringBuffer.append(shapeVarName);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(shapeFigure.isXorOutline());
    stringBuffer.append(TEXT_38);
    } if (shapeFigure instanceof Polyline && !((Polyline) shapeFigure).getTemplate().isEmpty()) {
	for (Iterator pointIt = ((Polyline) shapeFigure).getTemplate().iterator(); pointIt.hasNext(); ) {
		Point p = (Point) pointIt.next();
    stringBuffer.append(TEXT_39);
    stringBuffer.append(shapeVarName);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(p.getX());
    stringBuffer.append(TEXT_41);
    stringBuffer.append(p.getY());
    stringBuffer.append(TEXT_42);
    }
    } else if (shapeFigure instanceof RoundedRectangle) {
		RoundedRectangle rrFigure = (RoundedRectangle) shapeFigure;
    stringBuffer.append(TEXT_43);
    stringBuffer.append(shapeVarName);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(rrFigure.getCornerWidth());
    stringBuffer.append(TEXT_45);
    stringBuffer.append(rrFigure.getCornerHeight());
    stringBuffer.append(TEXT_46);
    }
    stringBuffer.append(TEXT_47);
    stringBuffer.append(TEXT_48);
    return stringBuffer.toString();
  }
}
