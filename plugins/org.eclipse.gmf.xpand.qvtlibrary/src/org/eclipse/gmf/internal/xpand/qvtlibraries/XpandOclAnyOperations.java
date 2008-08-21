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
package org.eclipse.gmf.internal.xpand.qvtlibraries;

import org.eclipse.ocl.types.AnyType;
import org.eclipse.ocl.types.PrimitiveType;

public class XpandOclAnyOperations {

	public static class Metainfo {

		private static final String OCLANY_CONTEXT = Activator.OCL_LIBRARY_PACKAGE + Activator.OCL_PATH_SEPARATOR + AnyType.SINGLETON_NAME;

		private static final String[] COMPARE_TO = new String[] { OCLANY_CONTEXT, AnyType.SINGLETON_NAME, PrimitiveType.BOOLEAN_NAME };

		public static String[] xpandCompareTo(Object self, Object parameter) {
			return COMPARE_TO;
		}
	}

	public Boolean xpandCompareTo(Object self, Object parameter) {
		if (self == null) {
			return parameter == null;
		}
		if (parameter == null) {
			return false;
		}
		if (self instanceof Comparable) {
			return ((Comparable) self).compareTo(parameter) == 0;
		}
		return String.valueOf(self).compareTo(String.valueOf(parameter)) == 0;

	}

}
