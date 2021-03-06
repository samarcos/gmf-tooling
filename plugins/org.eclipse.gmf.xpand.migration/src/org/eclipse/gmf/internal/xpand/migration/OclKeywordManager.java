/**
 * Copyright (c) 2008 Borland Software Corp.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alexander Shatalin (Borland) - initial API and implementation
 */
package org.eclipse.gmf.internal.xpand.migration;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.gmf.internal.xpand.expression.ast.Identifier;

public class OclKeywordManager {

	private static final Set<String> OCL_KEYWORDS = new HashSet<String>();

	static {
		OCL_KEYWORDS.add("self");
		OCL_KEYWORDS.add("if");
		OCL_KEYWORDS.add("then");
		OCL_KEYWORDS.add("else");
		OCL_KEYWORDS.add("endif");
		OCL_KEYWORDS.add("and");
		OCL_KEYWORDS.add("or");
		OCL_KEYWORDS.add("xor");
		OCL_KEYWORDS.add("not");
		OCL_KEYWORDS.add("implies");
		OCL_KEYWORDS.add("let");
		OCL_KEYWORDS.add("in");
		OCL_KEYWORDS.add("true");
		OCL_KEYWORDS.add("false");
		OCL_KEYWORDS.add("init");
		OCL_KEYWORDS.add("null");
		OCL_KEYWORDS.add("Set");
		OCL_KEYWORDS.add("Bag");
		OCL_KEYWORDS.add("Sequence");
		OCL_KEYWORDS.add("Collection");
		OCL_KEYWORDS.add("OrderedSet");
		OCL_KEYWORDS.add("iterate");
		OCL_KEYWORDS.add("forAll");
		OCL_KEYWORDS.add("exists");
		OCL_KEYWORDS.add("isUnique");
		OCL_KEYWORDS.add("any");
		OCL_KEYWORDS.add("one");
		OCL_KEYWORDS.add("collect");
		OCL_KEYWORDS.add("select");
		OCL_KEYWORDS.add("reject");
		OCL_KEYWORDS.add("collectNested");
		OCL_KEYWORDS.add("sortedBy");
		OCL_KEYWORDS.add("closure");
		OCL_KEYWORDS.add("oclIsKindOf");
		OCL_KEYWORDS.add("oclIsTypeOf");
		OCL_KEYWORDS.add("oclAsType");
		OCL_KEYWORDS.add("oclIsNew");
		OCL_KEYWORDS.add("oclIsUndefined");
		OCL_KEYWORDS.add("oclIsInvalid");
		OCL_KEYWORDS.add("oclIsInState");
		OCL_KEYWORDS.add("allInstances");
		OCL_KEYWORDS.add("String");
		OCL_KEYWORDS.add("Integer");
		OCL_KEYWORDS.add("UnlimitedNatural");
		OCL_KEYWORDS.add("Real");
		OCL_KEYWORDS.add("Boolean");
		OCL_KEYWORDS.add("Tuple");
		OCL_KEYWORDS.add("OclAny");
		OCL_KEYWORDS.add("OclVoid");
		OCL_KEYWORDS.add("Invalid");
		OCL_KEYWORDS.add("OclMessage");
		OCL_KEYWORDS.add("OclInvalid");
		OCL_KEYWORDS.add("end");
		OCL_KEYWORDS.add("while");
		OCL_KEYWORDS.add("out");
		OCL_KEYWORDS.add("object");
		OCL_KEYWORDS.add("transformation");
		OCL_KEYWORDS.add("import");
		OCL_KEYWORDS.add("library");
		OCL_KEYWORDS.add("metamodel");
		OCL_KEYWORDS.add("mapping");
		OCL_KEYWORDS.add("query");
		OCL_KEYWORDS.add("helper");
		OCL_KEYWORDS.add("inout");
		OCL_KEYWORDS.add("when");
		OCL_KEYWORDS.add("var");
		OCL_KEYWORDS.add("configuration");
		OCL_KEYWORDS.add("intermediate");
		OCL_KEYWORDS.add("property");
		OCL_KEYWORDS.add("class");
		OCL_KEYWORDS.add("population");	
		OCL_KEYWORDS.add("map");
		OCL_KEYWORDS.add("new");
		OCL_KEYWORDS.add("xmap");
		OCL_KEYWORDS.add("late");
		OCL_KEYWORDS.add("log");
		OCL_KEYWORDS.add("assert");
		OCL_KEYWORDS.add("with");
		OCL_KEYWORDS.add("resolve");
		OCL_KEYWORDS.add("resolveone");
		OCL_KEYWORDS.add("resolveIn");
		OCL_KEYWORDS.add("resolveoneIn");
		OCL_KEYWORDS.add("invresolve");
		OCL_KEYWORDS.add("invresolveone");
		OCL_KEYWORDS.add("invresolveIn");
		OCL_KEYWORDS.add("invresolveoneIn");
		OCL_KEYWORDS.add("modeltype");
		OCL_KEYWORDS.add("uses");
		OCL_KEYWORDS.add("where");
		OCL_KEYWORDS.add("refines");
// was removed from QVT lexer?		
		OCL_KEYWORDS.add("enforcing");
		OCL_KEYWORDS.add("access");
		OCL_KEYWORDS.add("extends");
		OCL_KEYWORDS.add("blackbox");
		OCL_KEYWORDS.add("abstract");
		OCL_KEYWORDS.add("static");
		OCL_KEYWORDS.add("result");
		OCL_KEYWORDS.add("main");
		OCL_KEYWORDS.add("this");
		OCL_KEYWORDS.add("switch");
		OCL_KEYWORDS.add("case");
		OCL_KEYWORDS.add("xselect");         
		OCL_KEYWORDS.add("xcollect");      
		OCL_KEYWORDS.add("selectOne");       
		OCL_KEYWORDS.add("collectOne");    
		OCL_KEYWORDS.add("collectselect");   
		OCL_KEYWORDS.add("collectselectOne");
		OCL_KEYWORDS.add("return");
		OCL_KEYWORDS.add("rename");
		OCL_KEYWORDS.add("disjuncts");
		OCL_KEYWORDS.add("merges");
		OCL_KEYWORDS.add("inherits");
		OCL_KEYWORDS.add("forEach");
		OCL_KEYWORDS.add("forOne");
		OCL_KEYWORDS.add("compute");
		OCL_KEYWORDS.add("Dict");
		OCL_KEYWORDS.add("List");
		OCL_KEYWORDS.add("break");
		OCL_KEYWORDS.add("composes");
		OCL_KEYWORDS.add("constructor");
		OCL_KEYWORDS.add("continue");
		OCL_KEYWORDS.add("datatype");
		OCL_KEYWORDS.add("default");
		OCL_KEYWORDS.add("derived");
		OCL_KEYWORDS.add("do");
		OCL_KEYWORDS.add("elif");
		OCL_KEYWORDS.add("enum");
		OCL_KEYWORDS.add("except");
		OCL_KEYWORDS.add("exception");
		OCL_KEYWORDS.add("from");
		OCL_KEYWORDS.add("literal");
		OCL_KEYWORDS.add("ordered");
		OCL_KEYWORDS.add("primitive");
		OCL_KEYWORDS.add("raise");
		OCL_KEYWORDS.add("readonly");
		OCL_KEYWORDS.add("references");
		OCL_KEYWORDS.add("tag");
		OCL_KEYWORDS.add("try");
		OCL_KEYWORDS.add("typedef");
		OCL_KEYWORDS.add("unlimited");
		OCL_KEYWORDS.add("invalid");
	}

	/**
	 * @return true if passed identifier was recognized as OCL keyword and
	 *         should be escaped during migration
	 */
	public boolean isOclKeyword(Identifier identifier) {
		return isOclKeyword(identifier.getValue());
	}

	public boolean isOclKeyword(String identifier) {
		return OCL_KEYWORDS.contains(identifier);
	}

	/**
	 * @return original identifier value if passed identifier is not an OCL
	 *         keyword or escaped identifier value in case it should be escaped
	 */
	public String getValidIdentifierValue(Identifier identifier) {
		return getValidIdentifierValue(identifier.getValue());
	}

	public String getValidIdentifierValue(String identifier) {
		if (!isOclKeyword(identifier)) {
			return identifier;
		}
		return OclCs.ESCAPE_PREFIX + identifier;
	}

}
