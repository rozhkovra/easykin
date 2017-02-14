package ru.rrozhkov.easykin.gui.task;

import ru.rrozhkov.easykin.context.MasterDataContext;
import ru.rrozhkov.easykin.gui.EasyKinWindow;
import ru.rrozhkov.easykin.gui.FormFactory;
import ru.rrozhkov.easykin.gui.PanelFactory;
import ru.rrozhkov.easykin.model.task.ITask;
import ru.rrozhkov.lib.collection.CollectionUtil;

import javax.swing.*;

public class TaskEditor extends JPanel {

	public TaskEditor(MasterDataContext context, EasyKinWindow parent, ITask task) {
		super();
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		add(FormFactory.createTaskForm(context, parent, task));
		if(!CollectionUtil.isNullOrEmpty(task.comments()))
			add(PanelFactory.createTaskCommentPanel(this, task.comments()));
	}
	public TaskEditor(MasterDataContext context, EasyKinWindow parent) {
		super();
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		add(FormFactory.createTaskForm(context, parent, null));
	}

	public void edit(int index){
		add(new JLabel("Hello world!"));
		validate();
	}
}
