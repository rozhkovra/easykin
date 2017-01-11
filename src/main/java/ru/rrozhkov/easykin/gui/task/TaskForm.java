package ru.rrozhkov.easykin.gui.task;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ru.rrozhkov.easykin.db.CategoryHandler;
import ru.rrozhkov.easykin.db.TaskHandler;
import ru.rrozhkov.easykin.model.category.ICategory;
import ru.rrozhkov.easykin.model.task.ITask;
import ru.rrozhkov.easykin.model.task.Priority;
import ru.rrozhkov.easykin.model.task.Status;
import ru.rrozhkov.easykin.model.task.impl.TaskFactory;
import ru.rrozhkov.easykin.util.CollectionUtil;
import ru.rrozhkov.easykin.util.DateUtil;

public class TaskForm extends JPanel{
	private static final long serialVersionUID = 1L;
	private boolean added = false;
	private JTextField nameField;
	private JTextField planDateField;
	private JComboBox priorityComboBox;
	private JComboBox categoryComboBox;
	private JLabel nameLabel;
	private JLabel planDateLabel;
	private JLabel priorityLabel;
	private JLabel categoryLabel;
	private JButton addButton;
	private JButton closeButton;
	private ITask task;
	private JFrame parent;
	
	public TaskForm(JFrame parent) {
		this(parent, TaskFactory.createTask(-1, "", new Date(), new Date(), Priority.priority(Priority.SIMPLE)
				, 1, "", null, Status.status(Status.OPEN)));
	}

	public TaskForm(JFrame parent, ITask task) {
		this.parent = parent;
		this.task = task;
		fill();
	}
	
	private void fill(){
		setLayout(new GridLayout(6,2)); 		
		add(getEmptyLabel());
		add(getEmptyLabel());
		add(getNameLabel()); 
		add(getNameField()); 
		add(getPlanDateLabel()); 
		add(getPlanDateField()); 
		add(getPriorityLabel()); 
		add(getPriorityComboBox()); 
		add(getCategoryLabel()); 
		add(getCategoryComboBox()); 
		add(getCloseButton());
		add(getAddButton());		
	}
	
	private Component getEmptyLabel() {
		return new JLabel(""); 
	}

	private JTextField getNameField(){
		if(nameField == null){
			nameField = new JTextField(250);
			nameField.setText(task.getName());
		}
		return nameField;
	}

	private JTextField getPlanDateField(){
		if(planDateField == null){
			planDateField = new JTextField(10);
			planDateField.setText(DateUtil.format(task.getPlanDate()));
		}
		return planDateField;
	}
	
	private JComboBox getPriorityComboBox(){
		if(priorityComboBox == null){
			String[] items = {
					Priority.IMPOTANT_FAST.toString(),
					Priority.IMPOTANT_NOFAST.toString(),
					Priority.SIMPLE.toString()
					};
			priorityComboBox = new JComboBox(items);
			priorityComboBox.setSelectedItem(task.getPriority().toString());
		}
		return priorityComboBox;
	}
	
	private JComboBox getCategoryComboBox(){
		if(categoryComboBox == null){
			categoryComboBox = new JComboBox(categories());
			categoryComboBox.setSelectedItem(task.getCategory().getName());
		}
		return categoryComboBox;
	}
	
	private String[] categories() {
		Collection<ICategory> categories = CategoryHandler.getCategories();
		Collection<String> items = CollectionUtil.<String>create(); 
		for(ICategory category : categories)
			items.add(category.getName());
		return items.toArray(new String[items.size()]);
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
	
	public JButton getAddButton(){
	    if(addButton==null){
	    	addButton = new JButton("Добавить");
	    	addButton.addActionListener(new ActionListener() {           
	            public void actionPerformed(ActionEvent e) {
	            	update();
	            	if(!validateTask())
	            		return;
	            	try{
	            		TaskHandler.addTask(task);
	            	}catch(Exception ex){
	            		ex.printStackTrace();
	            	}
	            	added = true;
	            	System.out.println(added);
	            	parent.repaint();
	            }

				private boolean validateTask() {
					return !added && !"".equals(task.getName());
				}           
	        });
	    }
		return addButton;
	}
	
	protected void update() {
		task = TaskFactory.createTask(-1, getNameField().getText(), new Date()
				, DateUtil.parse(getPlanDateField().getText()), priorityComboBox.getSelectedIndex()+1
				, categoryComboBox.getSelectedIndex()+1, "", null, Status.status(Status.OPEN));
	}

	private Component getCloseButton() {
	    if(closeButton==null){
	    	closeButton = new JButton("Закрыть");
	    	closeButton.addActionListener(new ActionListener() {           
	            public void actionPerformed(ActionEvent e) {
	            	added = false;
	            	System.out.println(added);
	            	Component form = parent.getContentPane().getComponent(1);
	            	parent.getContentPane().remove(form);
	            	parent.repaint();
	            }           
	        });
	    }
		return closeButton;
	}
}