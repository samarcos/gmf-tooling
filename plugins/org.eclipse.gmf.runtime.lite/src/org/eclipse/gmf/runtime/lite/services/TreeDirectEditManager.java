package org.eclipse.gmf.runtime.lite.services;

import java.lang.reflect.Constructor;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.ControlListener;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ICellEditorListener;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartListener;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.gef.requests.DirectEditRequest;
import org.eclipse.gef.tools.CellEditorLocator;

/**
 * Manages the direct edit operation by creating and maintaining the 
 * {@link org.eclipse.jface.viewers.CellEditor} and executing the resulting command if 
 * the cell editor value has changed.
 */
public abstract class TreeDirectEditManager {

private EditPartListener editPartListener;
private ControlListener controlListener;
private ICellEditorListener cellEditorListener;
private boolean showingFeedback;
private boolean dirty;
private DirectEditRequest request;
private CellEditorLocator locator;
private EditPart source;
private CellEditor ce;
private Class editorType;
private boolean committing = false;
private Object feature;
private Listener scrollListener;

/**
 * Constructs a new DirectEditManager for the given source edit part. The cell editor 
 * will be created by instantiating the type <i>editorType</i>. The cell editor will be 
 * placed using the given CellEditorLocator.
 * 
 * @param source the source edit part
 * @param editorType the cell editor type
 * @param locator the locator
 */
public TreeDirectEditManager(EditPart source, Class editorType, 
		CellEditorLocator locator) {
	this.source = source;
	this.locator = locator;
	this.editorType = editorType;
}

/**
 * Constructs a new DirectEditManager for the given source edit part. The cell editor 
 * will be created by instantiating the type <i>editorType</i>. The cell editor will be 
 * placed using the given CellEditorLocator.
 * 
 * @param source the source edit part
 * @param editorType the cell editor type
 * @param locator the locator
 * @param feature If the EditPart supports direct editing of multiple features, this parameter can be
 * used to discriminate among them.
 * @since 3.2
 */
public TreeDirectEditManager(EditPart source, Class editorType, 
		CellEditorLocator locator, Object feature) {
	this(source, editorType, locator );
	this.feature = feature;
}

/**
 * Cleanup is done here.  Any feedback is erased and listeners unhooked.  If the cell
 * editor is not <code>null</code>, it will be {@link CellEditor#deactivate() deativated},
 * {@link CellEditor#dispose() disposed}, and set to <code>null</code>.
 */
protected void bringDown() {
	eraseFeedback();
	unhookListeners();
	if (getCellEditor() != null) {
		getCellEditor().deactivate();
		getCellEditor().dispose();
		setCellEditor(null);
	}
	request = null;
	dirty = false;
}

/**
 * Commits the current value of the cell editor by getting a {@link Command} from the 
 * source edit part and executing it via the {@link CommandStack}.  Finally, 
 * {@link #bringDown()} is called to perform and necessary cleanup.
 */
protected void commit() {
	if (committing)
		return;
	committing = true;
	try {
		eraseFeedback();
		if (isDirty()) {
			CommandStack stack = 
					getEditPart().getViewer().getEditDomain().getCommandStack();
			stack.execute(getEditPart().getCommand(getDirectEditRequest()));
		}
	} finally {
		bringDown();
		committing = false;
	}
}

/**
 * Creates the cell editor on the given composite.  The cell editor is created by 
 * instantiating the cell editor type passed into this DirectEditManager's constuctor.
 * @param composite the composite to create the cell editor on
 * @return the newly created cell editor
 */
protected CellEditor createCellEditorOn(Composite composite) {
	try {
		Constructor constructor = editorType.getConstructor(new Class[]{Composite.class});
		return (CellEditor)constructor.newInstance(new Object[]{composite});
	} catch (Exception e) {
		return null;
	}
}

/**
 * Creates and returns the DirectEditRequest.
 * @return the direct edit request
 */
protected DirectEditRequest createDirectEditRequest() {
	DirectEditRequest req = new DirectEditRequest();
	req.setCellEditor(getCellEditor());
	req.setDirectEditFeature(getDirectEditFeature());
	return req;
}

/**
 * Asks the source edit part to erase source feedback.
 */
protected void eraseFeedback() {
	if (showingFeedback) {
		getEditPart().eraseSourceFeedback(getDirectEditRequest());
		showingFeedback = false;
	}
}

/**
 * Returns the cell editor.
 * @return the cell editor
 */
protected CellEditor getCellEditor() {
	return ce;
}

private Control getControl() {
	return ce.getControl();
}

/**
 * @return <code>Object</code> that can be used if the EditPart supports direct editing of multiple 
 * features, this parameter can be used to discriminate among them.
 * @since 3.2
 */
protected Object getDirectEditFeature() {
	return feature;
}

/**
 * Returns the direct edit request, creating it if needed.
 * @return the direct edit request
 */
protected DirectEditRequest getDirectEditRequest() {
	if (request == null)
		request = createDirectEditRequest();
	return request;
}

/**
 * Returns the source edit part.
 * @return the source edit part
 */
protected EditPart getEditPart() {
	return source;
}

private CellEditorLocator getLocator() {
	return locator;
}

private void handleValueChanged() {
	setDirty(true);
	showFeedback();
	placeCellEditor();
}

private void hookListeners() {
	Composite control = (Composite) getEditPart().getViewer().getControl();

	controlListener = new ControlAdapter() {
		public void controlMoved(ControlEvent e) {
			// This must be handled async because during scrolling, the CellEditor moves 
			// first, but then afterwards the viewport Scrolls, which would cause the 
			// shadow to move twice
			Display.getCurrent().asyncExec(new Runnable() {
				public void run() {
					placeCellEditor();
				}
			});
		}
		public void controlResized(ControlEvent e) {
			placeCellEditor();
		}
	};
	control.addControlListener(controlListener);

	scrollListener = new Listener() {
		public void handleEvent(Event e) {
			placeCellEditor();
		}
	};			
	if (control.getHorizontalBar() != null) {
		control.getHorizontalBar().addListener(SWT.Selection, scrollListener);
	}
	if (control.getVerticalBar() != null) {
		control.getVerticalBar().addListener(SWT.Selection, scrollListener);
	}
	cellEditorListener = new ICellEditorListener() {
		public void applyEditorValue() {
			commit();
		}
		public void cancelEditor() {
			bringDown();
		}
		public void editorValueChanged(boolean old, boolean newState) {
			handleValueChanged();
		}
	};
	getCellEditor().addListener(cellEditorListener);
	
	editPartListener = new EditPartListener.Stub () {
		public void partDeactivated(EditPart editpart) {
			bringDown();
		}
	};
	getEditPart().addEditPartListener(editPartListener);
}

/**
 * Initializes the cell editor.  Subclasses should implement this to set the initial text 
 * and add things such as {@link VerifyListener VerifyListeners}, if needed.
 */
protected abstract void initCellEditor();

/**
 * Returns <code>true</code> if the cell editor's value has been changed.
 * @return <code>true</code> if the cell editor is dirty
 */
protected boolean isDirty() {
	return dirty;
}

private void placeCellEditor() {
	getLocator().relocate(getCellEditor());
}

/**
 * Sets the cell editor to the given editor.
 * @param editor the cell editor
 */
protected void setCellEditor(CellEditor editor) {
	ce = editor;
	if (ce == null)
		return;
	hookListeners();
}

/**
 * Sets the dirty property.
 * @param value the dirty property
 */
protected void setDirty(boolean value) {
	dirty = value;
}

/**
 * Sets the source edit part.
 * @param source the source edit part
 */
protected void setEditPart(EditPart source) {
	this.source = source;
//	source.addEditPartListener();
}

/**
 * Sets the CellEditorLocator used to place the cell editor in the correct location.
 * @param locator the locator
 */
public void setLocator(CellEditorLocator locator) {
	this.locator = locator;
}

/**
 * Shows the cell editor when direct edit is started.  Calls {@link #initCellEditor()},
 * {@link CellEditor#activate()}, and {@link #showFeedback()}.
 */
public void show() {
	if (getCellEditor() != null)
		return;
	Composite composite = (Composite)source.getViewer().getControl();
	setCellEditor(createCellEditorOn(composite));
	if (getCellEditor() == null)
		return;
	initCellEditor();
	getCellEditor().activate();
	placeCellEditor();
	getControl().setVisible(true);
	getCellEditor().setFocus();
	showFeedback();
}

/**
 * Asks the source edit part to show source feedback.
 */
public void showFeedback() {
	showingFeedback = true;
	getEditPart().showSourceFeedback(getDirectEditRequest());
}

/**
 * Unhooks listeners.  Called from {@link #bringDown()}.
 * TODO: hookListeners() and unhookListeners() should have the same visibility.
 */
protected void unhookListeners() {
	getEditPart().removeEditPartListener(editPartListener);
	editPartListener = null;
	
	if (getCellEditor() == null)
		return;
	getCellEditor().removeListener(cellEditorListener);
	cellEditorListener = null;

	Composite control = (Composite) getEditPart().getViewer().getControl(); 	
	if (control == null || control.isDisposed())
		return;
	control.removeControlListener(controlListener);
	controlListener = null;

	if (control.getHorizontalBar() != null) {
		control.getHorizontalBar().removeListener(SWT.Selection, scrollListener);
	}
	if (control.getVerticalBar() != null) {
		control.getVerticalBar().removeListener(SWT.Selection, scrollListener);
	}
}
}
