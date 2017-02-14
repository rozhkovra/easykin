package ru.rrozhkov.easykin.gui.task;

import ru.rrozhkov.easykin.context.MasterDataContext;
import ru.rrozhkov.easykin.db.impl.TaskHandler;
import ru.rrozhkov.easykin.gui.IGUIEditor;
import ru.rrozhkov.easykin.model.category.convert.ArrayCategoryConverter;
import ru.rrozhkov.easykin.model.task.IComment;
import ru.rrozhkov.easykin.model.task.Status;
import ru.rrozhkov.easykin.model.task.impl.TaskFactory;
import ru.rrozhkov.easykin.util.DateUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CommentForm extends JPanel{
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JLabel textLabel;
	private JButton closeButton;

	private IComment comment;
	private IGUIEditor parent;
	private MasterDataContext context;

	public CommentForm(MasterDataContext context, IGUIEditor parent) {
		this(context, parent, TaskFactory.newComment());
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
		add(getEmptyLabel());
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
}