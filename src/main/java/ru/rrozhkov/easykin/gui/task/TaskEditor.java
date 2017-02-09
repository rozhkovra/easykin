package ru.rrozhkov.easykin.gui.task;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import ru.rrozhkov.easykin.context.EasyKinContext;
import ru.rrozhkov.easykin.gui.EasyKinWindow;
import ru.rrozhkov.easykin.gui.FormFactory;
import ru.rrozhkov.easykin.gui.PanelFactory;
import ru.rrozhkov.easykin.model.task.ITask;
import ru.rrozhkov.lib.collection.CollectionUtil;

public class TaskEditor extends JPanel {

	public TaskEditor(EasyKinContext context, EasyKinWindow parent, ITask task) {
		super();
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		add(FormFactory.createTaskForm(context, parent, task));
		if(!CollectionUtil.isNullOrEmpty(task.comments()))
			add(PanelFactory.createTaskCommentPanel(parent,task.comments()));
	}
	public TaskEditor(EasyKinContext context, EasyKinWindow parent) {
		super();
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		add(FormFactory.createTaskForm(context, parent, null));
	}
}
