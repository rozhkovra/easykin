package ru.rrozhkov.easykin.gui.task;

import ru.rrozhkov.easykin.auth.AuthManager;
import ru.rrozhkov.easykin.context.EasyKinContext;
import ru.rrozhkov.easykin.context.IContext;
import ru.rrozhkov.easykin.db.impl.TaskHandler;
import ru.rrozhkov.easykin.gui.Form;
import ru.rrozhkov.easykin.gui.IGUIEditor;
import ru.rrozhkov.easykin.gui.util.GuiUtil;
import ru.rrozhkov.easykin.model.category.convert.ArrayCategoryConverter;
import ru.rrozhkov.easykin.model.task.Status;
import ru.rrozhkov.easykin.model.task.impl.TaskFactory;
import ru.rrozhkov.easykin.service.impl.TaskService;
import ru.rrozhkov.easykin.util.DateUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TaskFilter extends Form {
	private static final long serialVersionUID = 1L;
	private JComboBox priorityComboBox;
	private JComboBox statusComboBox;
	private Component priorityLabel;
	private Component statusLabel;
	private IContext context;

	public TaskFilter(IContext context, IGUIEditor parent){
		super(parent);
		this.context = context;
		fill();
	}
	
	protected void fill(){
		setLayout(new GridLayout(3, 2));
		add(getPriorityLabel()); 
		add(getPriorityComboBox()); 
		add(getStatusLabel());
		add(getStatusComboBox());
		add(getOkButton());
		add(getCancelButton());
	}
	
	private JComboBox getPriorityComboBox(){
		if(priorityComboBox == null){
			priorityComboBox = new JComboBox(((EasyKinContext)context).masterData().priorities());
		}
		return priorityComboBox;
	}
	
	private JComboBox getStatusComboBox(){
		if(statusComboBox == null){
			statusComboBox = new JComboBox(((EasyKinContext)context).masterData().statuses());
		}
		return statusComboBox;
	}

	private Component getPriorityLabel(){
		if(priorityLabel == null)
			priorityLabel = GuiUtil.label("Приоритет");
		return priorityLabel;
	}

	private Component getStatusLabel(){
		if(statusLabel == null)
			statusLabel = GuiUtil.label("Статус");
		return statusLabel;
	}

	protected void ok() {
		parent.closeEditor();
	}
}