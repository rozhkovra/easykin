package ru.rrozhkov.easykin.gui.person;

import ru.rrozhkov.easykin.gui.IGUIEditor;
import ru.rrozhkov.easykin.gui.util.GuiUtil;
import ru.rrozhkov.easykin.model.person.IPerson;
import ru.rrozhkov.easykin.util.DateUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PersonForm extends JPanel{
	private static final long serialVersionUID = 1L;
	private JTextField surnameField;
	private JTextField nameField;
	private JTextField secondNameField;
	private JTextField birthDateField;
	private JLabel surnameLabel;
	private JLabel nameLabel;
	private JLabel secondNameLabel;
	private JLabel birthDateLabel;
	private JButton closeButton;

	private IPerson person;
	private IGUIEditor parent;

	public PersonForm(IGUIEditor parent, IPerson person) {
		this.parent = parent;
		this.person = person;
		fill();
	}
	
	private void fill(){
		setLayout(new GridLayout(7, 2));
		add(GuiUtil.getEmptyLabel());
		add(GuiUtil.getEmptyLabel());
		add(getSurnameLabel());
		add(getSurnameField());
		add(getNameLabel());
		add(getNameField());
		add(getSecondNameLabel());
		add(getSecondNameField());
		add(getBirthDateLabel());
		add(getBirthDateField());
		add(GuiUtil.getEmptyLabel());
		add(getCloseButton());
	}

	private JTextField getSurnameField(){
		if(surnameField == null){
			surnameField = new JTextField(250);
			surnameField.setText(person.getSurname());
			surnameField.setEditable(false);
		}
		return surnameField;
	}

	private JTextField getNameField(){
		if(nameField == null){
			nameField = new JTextField(250);
			nameField.setText(person.getName());
			nameField.setEditable(false);
		}
		return nameField;
	}

	private JTextField getSecondNameField(){
		if(secondNameField == null){
			secondNameField = new JTextField(250);
			secondNameField.setText(person.getSecondName());
			secondNameField.setEditable(false);
		}
		return secondNameField;
	}

	private JTextField getBirthDateField(){
		if(birthDateField == null){
			birthDateField = new JTextField(10);
			birthDateField.setText(DateUtil.format(person.getBirthDate()));
			birthDateField.setEditable(false);
		}
		return birthDateField;
	}

	private JLabel getSurnameLabel(){
		if(surnameLabel == null)
			surnameLabel = new JLabel("Фамилия");
		return surnameLabel;
	}

	private JLabel getNameLabel(){
		if(nameLabel == null)
			nameLabel = new JLabel("Имя");
		return nameLabel;
	}

	private JLabel getSecondNameLabel(){
		if(secondNameLabel == null)
			secondNameLabel = new JLabel("Отчество");
		return secondNameLabel;
	}

	private JLabel getBirthDateLabel(){
		if(birthDateLabel == null)
			birthDateLabel = new JLabel("Дата рождения");
		return birthDateLabel;
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