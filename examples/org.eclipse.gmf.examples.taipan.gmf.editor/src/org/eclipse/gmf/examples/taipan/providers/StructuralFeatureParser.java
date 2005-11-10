/*
 * Copyright (c) 2005 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Dmitri Stadnik (Borland) - initial API and implementation
 */
package org.eclipse.gmf.examples.taipan.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserEditStatus;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractModelCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;

/**
 * @generated
 */
public class StructuralFeatureParser implements IParser {

	/**
	 * @generated
	 */
	private EStructuralFeature feature;

	/**
	 * @generated
	 */
	public StructuralFeatureParser(EStructuralFeature feature) {
		this.feature = feature;
	}

	/**
	 * @generated
	 */
	public ICommand getParseCommand(IAdaptable adapter, String newString, int flags) {
		EObject element = (EObject) adapter.getAdapter(EObject.class);
		SetRequest request = new SetRequest(element, feature, newString);
		final SetValueCommand actualCommand = new SetValueCommand(request);
		String label = feature.getName();
		return new AbstractModelCommand(label, actualCommand.getAffectedObjects()) {

			protected CommandResult doExecute(IProgressMonitor progressMonitor) {
				actualCommand.execute(progressMonitor);
				return actualCommand.getCommandResult();
			}
		};
	}

	/**
	 * @generated
	 */
	public String getPrintString(IAdaptable adapter, int flags) {
		EObject element = (EObject) adapter.getAdapter(EObject.class);
		Object value = element.eGet(feature);
		if (value != null) {
			String literalValue = value.toString();
			if (literalValue.length() > 0) {
				return literalValue;
			}
		}
		return getDefaultValue();
	}

	/**
	 * @generated
	 */
	protected String getDefaultValue() {
		String defaultValue = feature.getDefaultValueLiteral();
		if (defaultValue == null) {
			defaultValue = ""; //$NON-NLS-1$
		}
		return defaultValue;
	}

	/**
	 * @generated
	 */
	public String getEditString(IAdaptable adapter, int flags) {
		return getPrintString(adapter, flags);
	}

	/**
	 * @generated
	 */
	public IParserEditStatus isValidEditString(IAdaptable element, String editString) {
		return ParserEditStatus.EDITABLE_STATUS;
	}

	/**
	 * @generated
	 */
	public boolean isAffectingEvent(Object event, int flags) {
		if (event instanceof Notification) {
			if (feature == ((Notification) event).getFeature()) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @generated
	 */
	public IContentAssistProcessor getCompletionProcessor(IAdaptable element) {
		return null;
	}
}
