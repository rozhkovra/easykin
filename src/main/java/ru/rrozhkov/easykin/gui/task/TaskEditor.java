package ru.rrozhkov.easykin.gui.task;

import ru.rrozhkov.easykin.context.MasterDataContext;
import ru.rrozhkov.easykin.gui.EasyKinWindow;
import ru.rrozhkov.easykin.gui.FormFactory;
import ru.rrozhkov.easykin.gui.IGUIEditor;
import ru.rrozhkov.easykin.gui.PanelFactory;
import ru.rrozhkov.easykin.model.task.IComment;
import ru.rrozhkov.easykin.model.task.ITask;
import ru.rrozhkov.lib.collection.CollectionUtil;

import javax.swing.*;
import java.awt.*;

public class TaskEditor extends JPanel implements IGUIEditor{
	private ITask task;
	private MasterDataContext context;
	private EasyKinWindow parent;
	public TaskEditor(MasterDataContext context, EasyKinWindow parent, ITask task) {
		super();
		this.task = task;
		this.context = context;
		this.parent = parent;
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		add(FormFactory.createTaskForm(context, parent, task));
		if(task!=null && !CollectionUtil.isNullOrEmpty(task.comments()))
			add(PanelFactory.createTaskCommentPanel(this, task.comments()));
	}
	public TaskEditor(MasterDataContext context, EasyKinWindow parent) {
		this(context, parent, null);
	}

	public void edit(int index){
		if(getComponentCount()>2)
			return;
		if(task==null || task.comments().isEmpty())
			return;
		if(index > task.comments().size()-1 || index < 0)
			return;
		IComment comment =  CollectionUtil.get(task.comments(), index);
		add(FormFactory.createCommentForm(context,this, comment));
		validate();
	}

	public void closeEditor() {
		if(getComponentCount()<3)
			return;
		Component form = getComponent(2);
		remove(form);
		validate();
	}
}
