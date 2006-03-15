/*
 * Copyright (c) 2006 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Michael Golubev (Borland) - initial API and implementation
 */

package org.eclipse.gmf.internal.common.reconcile;

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

public class Reconciler {
	private final ReconcilerConfig myConfig;

	public Reconciler(ReconcilerConfig config){
		myConfig = config;
	}
	
	protected void handleNotMatchedCurrent(EObject current){
		//FIXME ??? Is it user escape -- check history ???
		//FIXME How to handle not macthed old ???
	}
	
	public void reconcileResource(Resource current, Resource old){
		reconcileContents(current.getContents(), old.getContents());
	}
	
	public void reconcileTree(EObject currentRoot, EObject oldRoot){
		reconcileVertex(currentRoot, oldRoot);
		reconcileContents(currentRoot.eContents(), oldRoot.eContents());
	}
	
	private void reconcileVertex(EObject current, EObject old){
		assert current.eClass().equals(old.eClass());
		DecisionMaker[] decisionMakers = myConfig.getDecisionMakers(current.eClass());
		for (int i = 0; i < decisionMakers.length; i++){
			DecisionMaker next = decisionMakers[i];
			Decision decision = next.makeDecision(current, old);
			decision.apply(current, old, next.getFeature());
		}
	}
	
	private void reconcileContents(Collection allCurrents, Collection allOlds){
		for (Iterator currentContents = allCurrents.iterator(); currentContents.hasNext();){
			EObject nextCurrent = (EObject) currentContents.next();
			EObject nextOld = findMatched(nextCurrent, allOlds);
			if (nextOld == null){
				handleNotMatchedCurrent(nextCurrent);
			} else {
				reconcileTree(nextCurrent, nextOld);
			}
		}
	}
	
	private EObject findMatched(EObject current, Collection allOld){
		EClass eClass = current.eClass();
		Matcher matcher = myConfig.getMatcher(eClass);
		EObject result = null;
		if (matcher != Matcher.FALSE){
			for (Iterator all = allOld.iterator(); result == null && all.hasNext();){
				EObject next = (EObject)all.next();
				if (eClass.equals(next.eClass()) && matcher.match(current, next)){
					result = next;
				}
			}
		}
		return result;
	}

}
