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
package org.eclipse.gmf.dev;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.dev.hook.EditPartTraceListener;
import org.eclipse.gmf.dev.hook.EditPartTracer;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.viewers.AbstractTreeViewer;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.part.ViewPart;

/**
 * @author dstadnik
 */
public class EditPartTraceView extends ViewPart {

	private TreeViewer viewer;
	private List<IAction> actions;
	private IWorkbenchPart part;
	private Stack<CommandCreatedEvent> history = new Stack<CommandCreatedEvent>();

	private IPartListener partListener = new IPartListener() {

		public void partActivated(IWorkbenchPart part) {
			install(part);
		}

		public void partDeactivated(IWorkbenchPart part) {
			install(null);
		}

		public void partBroughtToTop(IWorkbenchPart part) {}

		public void partOpened(IWorkbenchPart part) {}

		public void partClosed(IWorkbenchPart part) {}
	};

	private EditPartTraceListener traceListener = new EditPartTraceListener() {

		public void commandRequested(EditPart editPart, Request request) {
			traceCommandRequested(editPart, request);
		}

		public void commandCreated(EditPart editPart, Request request, Command command, Map sources) {
			traceCommandCreated(editPart, request, command, sources);
		}
	};

	private List<EditPartTraceRecord> getRecords() {
		return (List<EditPartTraceRecord>) viewer.getInput();
	}

	private TopEditPartTraceRecord getLastRecord() {
		List<EditPartTraceRecord> records = getRecords();
		if (records.isEmpty()) {
			return null;
		}
		return (TopEditPartTraceRecord) records.get(records.size() - 1);
	}

	protected void setSite(IWorkbenchPartSite site) {
		super.setSite(site);
		site.getWorkbenchWindow().getPartService().addPartListener(partListener);
	}

	public void createPartControl(Composite parent) {
		viewer = new TreeViewer(parent);
		viewer.setLabelProvider(new TraceLabelProvider());
		viewer.setContentProvider(new TraceContentProvider());
		viewer.setInput(new ArrayList());
		makeActions();
		fillActions();
	}

	protected void makeActions() {
		actions = new ArrayList<IAction>();
		actions.add(new Action("Expand") {

			public void run() {
				Iterator selection = ((IStructuredSelection) viewer.getSelection()).iterator();
				while (selection.hasNext()) {
					viewer.expandToLevel(selection.next(), AbstractTreeViewer.ALL_LEVELS);
				}
			}
		});
		actions.add(new Action("Flush") {

			public void run() {
				getRecords().clear();
				viewer.refresh(true);
			}
		});
	}

	protected void fillActions() {
		IToolBarManager mgr = getViewSite().getActionBars().getToolBarManager();
		for (IAction action : actions) {
			mgr.add(action);
		}
	}

	public void setFocus() {
		if (viewer == null) {
			return;
		}
		Control control = viewer.getControl();
		if (control != null && !control.isDisposed()) {
			control.setFocus();
		}
	}

	public void dispose() {
		getSite().getWorkbenchWindow().getPartService().removePartListener(partListener);
		install(null);
		super.dispose();
	}

	protected void install(IWorkbenchPart part) {
		EditPartTracer tracer = getTracer(this.part, false);
		if (tracer != null) {
			tracer.removeTraceListener(traceListener);
			this.part = null;
		}
		tracer = getTracer(part, true);
		if (tracer != null) {
			tracer.addTraceListener(traceListener);
			this.part = part;
		}
	}

	protected static EditPartTracer getTracer(IWorkbenchPart part, boolean hook) {
		if (part == null) {
			return null;
		}
		GraphicalViewer viewer = (GraphicalViewer) part.getAdapter(GraphicalViewer.class);
		EditPartTracer tracer = EditPartTracer.getInstance(viewer);
		if (tracer == null && hook) {
			tracer = EditPartTracer.install(viewer);
		}
		return tracer;
	}

	protected void traceCommandRequested(EditPart editPart, Request request) {
		CommandCreatedEvent event = new CommandCreatedEvent();
		event.editPart = editPart;
		event.request = request;
		history.push(event);
	}

	protected void traceCommandCreated(EditPart editPart, Request request, Command command, Map sources) {
		if (history.isEmpty()) {
			throw new IllegalStateException("Command requested event was not received.");
		}
		CommandCreatedEvent event = (CommandCreatedEvent) history.pop();
		event.editPart = editPart;
		event.request = request;
		event.command = command;
		event.sources = sources;
		if (history.isEmpty()) {
			EditPartTraceRecord record = trace(event, true);
			if (record != null) {
				TopEditPartTraceRecord lastRecord = getLastRecord();
				if (lastRecord != null && lastRecord.equalTree(record)) {
					lastRecord.requested();
					viewer.refresh(lastRecord, true);
				} else {
					getRecords().add(record);
					viewer.add(getRecords(), record);
				}
			}
		} else {
			CommandCreatedEvent parent = (CommandCreatedEvent) history.peek();
			if (parent.siblings == null) {
				parent.siblings = new ArrayList<CommandCreatedEvent>();
			}
			parent.siblings.add(event);
		}
	}

	protected EditPartTraceRecord trace(CommandCreatedEvent event, boolean top) {
		if (event.request != null && isIgnored(event.request)) {
			return null;
		}
		StringBuffer text = new StringBuffer();
		text.append(DevUtils.getSimpleClassName(event.editPart));
		text.append(" : ");
		if (event.request != null) {
			text.append(String.valueOf(event.request.getType()));
		}
		text.append(" -> ");
		text.append(DevUtils.getSimpleClassName(event.command));
		List<EditPartTraceRecord> kids = new ArrayList<EditPartTraceRecord>();
		if (event.editPart != null) {
			kids.add(EditPartTraceConstructor.createEditPartNode(event.editPart));
		}
		if (event.request != null) {
			kids.add(EditPartTraceConstructor.createRequestNode(event.request));
		}
		if (event.command != null) {
			kids.add(EditPartTraceConstructor.createCommandNode(event.command, event));
		}
		if (event.siblings != null) {
			for (CommandCreatedEvent sibling : event.siblings) {
				EditPartTraceRecord kid = trace(sibling, false);
				if (kid != null) {
					kids.add(kid);
				}
			}
		}
		EditPartTraceRecord[] akids = (EditPartTraceRecord[]) kids.toArray(new EditPartTraceRecord[kids.size()]);
		return top ? new TopEditPartTraceRecord(text.toString(), DevPlugin.EVENT_IMAGE, akids) : new EditPartTraceRecord(text.toString(), DevPlugin.EVENT_IMAGE, akids);
	}

	protected boolean isIgnored(Request request) {
		String ignored = DevPlugin.getOption(DevPlugin.IGNORED_REQUESTS_OPTION);
		if (ignored == null) {
			return false;
		}
		String type = String.valueOf(request.getType());
		return ignored.indexOf(type) >= 0;
	}

	private class TraceContentProvider implements ITreeContentProvider {

		public void dispose() {}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {}

		public Object getParent(Object element) {
			if (element instanceof TopEditPartTraceRecord) {
				return getRecords();
			} else if (element instanceof EditPartTraceRecord) {
				return ((EditPartTraceRecord) element).getParent();
			}
			return null;
		}

		public boolean hasChildren(Object element) {
			if (element instanceof Collection) {
				return !((Collection) element).isEmpty();
			} else if (element instanceof EditPartTraceRecord) {
				return ((EditPartTraceRecord) element).getKids().length > 0;
			}
			return false;
		}

		public Object[] getChildren(Object parentElement) {
			if (parentElement instanceof Collection) {
				return ((Collection) parentElement).toArray();
			} else if (parentElement instanceof EditPartTraceRecord) {
				return ((EditPartTraceRecord) parentElement).getKids();
			}
			return null;
		}

		public Object[] getElements(Object inputElement) {
			return getChildren(inputElement);
		}
	}

	private static class TraceLabelProvider extends LabelProvider {

		public String getText(Object element) {
			String text = null;
			if (element instanceof EditPartTraceRecord) {
				text = ((EditPartTraceRecord) element).getLabel();
			}
			if (text == null) {
				return "<unspecified>";
			}
			if (element instanceof TopEditPartTraceRecord) {
				text += " (" + ((TopEditPartTraceRecord) element).getTimesRequested() + ")";
			}
			return text;
		}

		public Image getImage(Object element) {
			String imageId = null;
			if (element instanceof EditPartTraceRecord) {
				imageId = ((EditPartTraceRecord) element).getImageId();
			}
			if (imageId == null) {
				imageId = DevPlugin.INFO_IMAGE;
			}
			return DevPlugin.getImage(imageId);
		}
	}

	private class TopEditPartTraceRecord extends EditPartTraceRecord {

		private int timesRequested = 1;

		public TopEditPartTraceRecord(String label, String imageId, EditPartTraceRecord[] kids) {
			super(label, imageId, kids);
		}

		public int getTimesRequested() {
			return timesRequested;
		}

		public void requested() {
			timesRequested++;
		}
	}
}
