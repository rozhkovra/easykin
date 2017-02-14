package ru.rrozhkov.easykin.gui.task;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ru.rrozhkov.easykin.context.MasterDataContext;
import ru.rrozhkov.easykin.db.impl.TaskHandler;
import ru.rrozhkov.easykin.gui.IGUIEditor;
import ru.rrozhkov.easykin.model.category.convert.ArrayCategoryConverter;
import ru.rrozhkov.easykin.model.task.ITask;
import ru.rrozhkov.easykin.model.task.Status;
import ru.rrozhkov.easykin.model.task.impl.TaskFactory;
import ru.rrozhkov.easykin.util.DateUtil;

public class TaskForm extends JPanel{
	private static final long serialVersionUID = 1L;
	private JTextField nameField;
	private JTextField planDateField;
	private JComboBox priorityComboBox;
	private JComboBox categoryComboBox;
	private JLabel nameLabel;
	private JLabel planDateLabel;
	private JLabel priorityLabel;
	private JLabel categoryLabel;
	private JButton saveButton;
	private JButton closeButton;
	private JButton doneButton;
	
	private ITask task;
	private IGUIEditor parent;
	private MasterDataContext context;
	
	public TaskForm(MasterDataContext context, IGUIEditor parent) {
		this(context, parent, TaskFactory.newTask());
	}

	public TaskForm(MasterDataContext context, IGUIEditor parent, ITask task) {
		this.context = context;
		this.parent = parent;
		this.task = task;
		fill();
	}
	
	private void fill(){
		setLayout(new GridLayout(7,2));
		add(getEmptyLabel());
		if(!task.getStatus().isClose()){
			if(task.getId()!=-1){
				add(getDoneButton());
			}else
				add(getEmptyLabel());
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
			add(getSaveButton());
		}else
			add(getEmptyLabel());
		add(getCloseButton());
	}
	
	private Component getCloseDateLabel() {
 		return new JLabel(DateUtil.format(task.getCloseDate()));
	}

	private Component getEmptyLabel() {
		return new JLabel(""); 
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
	
	public JButton getSaveButton(){
	    if(saveButton==null){
	    	saveButton = new JButton("Сохранить");
	    	saveButton.addActionListener(new ActionListener() {           
	            public void actionPerformed(ActionEvent e) {
	            	update();
	            	if(!validateTask())
	            		return;
	            	try{
	            		if(task.getId()==-1)
		            		TaskHandler.insert(task);
	            		else
	            			TaskHandler.update(task);
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
		return saveButton;
	}
	
	protected void update() {
		task = TaskFactory.createTask(task.getId(), getNameField().getText(), task.getCreateDate()
				, DateUtil.parse(getPlanDateField().getText()), priorityComboBox.getSelectedIndex()+1
				, categoryComboBox.getSelectedIndex()+1, "", null, Status.status(Status.OPEN));
	}

	private Component getCloseButton() {
	    if(closeButton==null){
	    	closeButton = new JButton("Закрыть");
	    	closeButton.addActionListener(new ActionListener() {           
	            public void actionPerformed(ActionEvent e) {
					parent.closeEditor();
	            }
	        });
	    }
		return closeButton;
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
}