package ru.rrozhkov.easykin.gui.task;

import ru.rrozhkov.easykin.auth.AuthManager;
import ru.rrozhkov.easykin.context.MasterDataContext;
import ru.rrozhkov.easykin.db.impl.TaskHandler;
import ru.rrozhkov.easykin.gui.Form;
import ru.rrozhkov.easykin.gui.IGUIEditor;
import ru.rrozhkov.easykin.gui.util.GuiUtil;
import ru.rrozhkov.easykin.model.category.convert.ArrayCategoryConverter;
import ru.rrozhkov.easykin.model.task.ITask;
import ru.rrozhkov.easykin.model.task.Status;
import ru.rrozhkov.easykin.model.task.impl.TaskFactory;
import ru.rrozhkov.easykin.service.impl.TaskService;
import ru.rrozhkov.easykin.util.DateUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TaskForm extends Form {
	private static final long serialVersionUID = 1L;
	private JTextField nameField;
	private JTextField planDateField;
	private JComboBox priorityComboBox;
	private JComboBox categoryComboBox;
	private JLabel nameLabel;
	private JLabel planDateLabel;
	private JLabel priorityLabel;
	private JLabel categoryLabel;
	private JButton doneButton;
	
	private ITask task;
	private MasterDataContext context;
	
	public TaskForm(MasterDataContext context, IGUIEditor parent) {
		this(context, parent, TaskFactory.newTask());
	}

	public TaskForm(MasterDataContext context, IGUIEditor parent, ITask task) {
		super(parent);
		this.context = context;
		this.task = task;
		fill();
	}
	
	protected void fill(){
		setLayout(new GridLayout(7,2));
		add(GuiUtil.getEmptyLabel());
		if(!task.getStatus().isClose()){
			if(task.getId()!=-1){
				add(getDoneButton());
			}else
				add(GuiUtil.getEmptyLabel());
		}else{
			add(getCloseDateLabel());
		}
		add(getNameLabel()); 
		add(getNameField()); 
		add(getPlanDateLabel()); 
		add(getPlanDateField()); 
		add(getPriorityLabel()); 
		add(getPriorityComboBox()); 
		add(getCategoryLabel()); 
		add(getCategoryComboBox()); 
		if(!task.getStatus().isClose()){
			add(getOkButton());
		}else
			add(GuiUtil.getEmptyLabel());
		add(getCancelButton());
	}
	
	private Component getCloseDateLabel() {
 		return new JLabel(DateUtil.format(task.getCloseDate()));
	}

	private JTextField getNameField(){
		if(nameField == null){
			nameField = new JTextField(250);
			nameField.setText(task.getName());
			if(task.getStatus().isClose())
				nameField.setEditable(false);
		}
		return nameField;
	}

	private JTextField getPlanDateField(){
		if(planDateField == null){
			planDateField = new JTextField(10);
			planDateField.setText(DateUtil.format(task.getPlanDate()));
			if(task.getStatus().isClose())
				planDateField.setEditable(false);
		}
		return planDateField;
	}
	
	private JComboBox getPriorityComboBox(){
		if(priorityComboBox == null){
			priorityComboBox = new JComboBox(context.priorities());
			priorityComboBox.setSelectedItem(task.getPriority().toString());
			if(task.getStatus().isClose())
				priorityComboBox.setEditable(false);
		}
		return priorityComboBox;
	}
	
	private JComboBox getCategoryComboBox(){
		if(categoryComboBox == null){
			categoryComboBox = new JComboBox(categories());
			categoryComboBox.setSelectedItem(task.getCategory().getName());
			if(task.getStatus().isClose())
				categoryComboBox.setEditable(false);
		}
		return categoryComboBox;
	}
	
	private String[] categories() {
		return new ArrayCategoryConverter().convert(context.categories());
	}

	private JLabel getNameLabel(){
		if(nameLabel == null)
			nameLabel = new JLabel("Описание"); 
		return nameLabel;
	}
	
	private JLabel getPlanDateLabel(){
		if(planDateLabel == null)
			planDateLabel = new JLabel("Плановая дата"); 
		return planDateLabel;
	}

	private JLabel getPriorityLabel(){
		if(priorityLabel == null)
			priorityLabel = new JLabel("Приоритет"); 
		return priorityLabel;
	}

	private JLabel getCategoryLabel(){
		if(categoryLabel == null)
			categoryLabel = new JLabel("Категория"); 
		return categoryLabel;
	}

	protected void update() {
		task = TaskFactory.createTask(task.getId(), getNameField().getText(), task.getCreateDate()
				, DateUtil.parse(getPlanDateField().getText()), priorityComboBox.getSelectedIndex()+1
				, categoryComboBox.getSelectedIndex()+1, "", null, Status.status(Status.OPEN));
	}

	private Component getDoneButton() {
	    if(doneButton==null){
	    	doneButton = new JButton("Выполнить");
	    	doneButton.addActionListener(new ActionListener() {           
	            public void actionPerformed(ActionEvent e) {
	            	update();
	            	if(!validateTask())
	            		return;
	            	try{
	            		TaskHandler.close(task);
	            	}catch(Exception ex){
	            		ex.printStackTrace();
	            	}
	        		context.init();
	            	parent.refresh();
	            }

				private boolean validateTask() {
					return !"".equals(task.getName());
				}                      
	        });
	    }
		return doneButton;
	}

	protected void ok() {
		update();
		if(!validateData())
			return;
		try{
			AuthManager authManager = AuthManager.instance();
			if(task.getId()==-1) {
				TaskService.create(authManager.signedPerson().getId(), task);
			}else
				TaskHandler.update(task);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		context.init();
		parent.refresh();
	}

	protected boolean validateData() {
		return !"".equals(task.getName()) && AuthManager.instance()!=null;
	}
}