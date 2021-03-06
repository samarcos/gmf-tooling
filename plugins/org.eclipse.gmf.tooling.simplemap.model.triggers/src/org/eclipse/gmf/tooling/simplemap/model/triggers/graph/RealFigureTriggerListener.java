/**
 * Copyright (c) 2010-2012 ISBAN S.L
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 * 		Ruben De Dios (ISBAN S.L)
 * 		Andrez Alvarez Mattos (ISBAN S.L)
 */
package org.eclipse.gmf.tooling.simplemap.model.triggers.graph;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.transaction.NotificationFilter;
import org.eclipse.emf.transaction.ResourceSetListener;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.TriggerListener;
import org.eclipse.gmf.gmfgraph.Figure;
import org.eclipse.gmf.gmfgraph.GMFGraphPackage;
import org.eclipse.gmf.gmfgraph.RealFigure;

public class RealFigureTriggerListener extends TriggerListener implements ResourceSetListener {

	public static NotificationFilter replaceFigureFilter;

	public RealFigureTriggerListener() {
		super(NotificationFilter.createNotifierTypeFilter(RealFigure.class));
	}

	static {

		replaceFigureFilter = NotificationFilter.createNotifierTypeFilter(RealFigure.class).and(NotificationFilter.createEventTypeFilter(Notification.SET))
				.and(NotificationFilter.createFeatureFilter(RealFigure.class, GMFGraphPackage.REAL_FIGURE__CHILDREN));

	}

	@Override
	protected Command trigger(TransactionalEditingDomain domain, Notification notification) {

		if (replaceFigureFilter.matches(notification)) {
			Figure oldFigure = (Figure) notification.getOldValue();
			Figure newFigure = (Figure) notification.getNewValue();

			return new SetActualFigureTrigger(domain, oldFigure, newFigure);
		}

		return null;
	}

}
