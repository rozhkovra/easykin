package ru.rrozhkov.easykin.gui.task;

import ru.rrozhkov.easykin.context.MasterDataContext;
import ru.rrozhkov.easykin.db.impl.CommentHandler;
import ru.rrozhkov.easykin.gui.IGUIEditor;
import ru.rrozhkov.easykin.model.task.IComment;
import ru.rrozhkov.easykin.model.task.impl.TaskFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CommentForm extends JPanel{
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JLabel textLabel;
	private JButton closeButton;
	private JButton saveButton;
	private IComment comment;
	private IGUIEditor parent;
	private MasterDataContext context;

	public CommentForm(MasterDataContext context, IGUIEditor parent, int taskId) {
		this(context, parent, TaskFactory.newComment(taskId));
	}

	public CommentForm(MasterDataContext context, IGUIEditor parent, IComment comment) {
		this.context = context;
		this.parent = parent;
		this.comment = comment;
		fill();
	}
	
	private void fill(){
		setLayout(new GridLayout(4, 2));
		add(getEmptyLabel());
		add(getEmptyLabel());
		add(getTextLabel());
		add(getTextField());
		add(getSaveButton());
		add(getCloseButton());
	}
	
	private Component getEmptyLabel() {
		return new JLabel(""); 
	}

	private JTextField getTextField(){
		if(textField == null){
			textField = new JTextField(250);
			textField.setText(comment.getText());
		}
		return textField;
	}

	private JLabel getTextLabel(){
		if(textLabel == null)
			textLabel = new JLabel("Текст");
		return textLabel;
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

	private JButton getSaveButton(){
		if(saveButton==null){
			saveButton = new JButton("Сохранить");
			saveButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					update();
					if(!validate())
						return;
					try{
						if(comment.getId()==-1)
							CommentHandler.insert(comment);
						else
							CommentHandler.update(comment);
					}catch(Exception ex){
						ex.printStackTrace();
					}
					context.init();
					parent.refresh();
				}

				private boolean validate() {
					return !"".equals(comment.getText());
				}
			});
		}
		return saveButton;
	}

	protected void update() {
		comment = TaskFactory.createComment(comment.getId(), getTextField().getText(), comment.getDate(), comment.getTaskId());
	}
}