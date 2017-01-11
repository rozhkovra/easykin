package ru.rrozhkov.easykin.gui.auto.service;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ru.rrozhkov.easykin.model.auto.service.IService;
import ru.rrozhkov.easykin.model.auto.service.impl.ServiceFactory;
import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.util.DateUtil;

public class ServiceForm extends JPanel{
	private static final long serialVersionUID = 1L;
	private JTextField nameField;
	private JTextField priceField;
	private JTextField dateField;
	private JLabel nameLabel;
	private JLabel priceLabel;
	private JLabel dateLabel;
	private JButton addButton;
	private JButton closeButton;
	private IService service;
	private JFrame parent;
	public ServiceForm(JFrame parent, IService service) {
		this.service = service;
		this.parent = parent;
		fill();
	}
	
	public ServiceForm(JFrame parent) {
		this(parent, ServiceFactory.createService("", new Money(), new Date()));
	}
	
	private void fill(){
		setLayout(new GridLayout(5,2)); 		
		add(getEmptyLabel());
		add(getEmptyLabel());
		add(getNameLabel()); 
		add(getNameField()); 
		add(getPriceLabel()); 
		add(getPriceField()); 
		add(getDateLabel()); 
		add(getDateField());
		add(getCloseButton());
		add(getAddButton());
	}
	
	private Component getEmptyLabel() {
		return new JLabel(""); 
	}

	private JTextField getNameField(){
		if(nameField == null){
			nameField = new JTextField(50);
			nameField.setText(service.getName());
		}
		return nameField;
	}

	private JTextField getPriceField(){
		if(priceField == null){
			priceField = new JTextField(10);
			priceField.setText(service.getPrice().toString());
		}
		return priceField;
	}
	
	private JTextField getDateField(){
		if(dateField == null){
			dateField = new JTextField(10);
			dateField.setText(DateUtil.format(service.getDate()));
		}
		return dateField;
	}
	
	private JLabel getNameLabel(){
		if(nameLabel == null)
			nameLabel = new JLabel("Описание"); 
		return nameLabel;
	}
	
	private JLabel getPriceLabel(){
		if(priceLabel == null)
			priceLabel = new JLabel("Цена"); 
		return priceLabel;
	}
	
	private JLabel getDateLabel(){
		if(dateLabel == null)
			dateLabel = new JLabel("Дата"); 
		return dateLabel;
	}
	
	public JButton getAddButton(){
	    if(addButton==null){
	    	addButton = new JButton("Добавить");
	    }
		return addButton;
	}
	
	private Component getCloseButton() {
	    if(closeButton==null){
	    	closeButton = new JButton("Закрыть");
	    	closeButton.addActionListener(new ActionListener() {           
	            public void actionPerformed(ActionEvent e) {
	            	Component form = parent.getContentPane().getComponent(1);
	            	parent.getContentPane().remove(form);
	            	parent.repaint();
	            }           
	        });
	    }
		return closeButton;
	}
}