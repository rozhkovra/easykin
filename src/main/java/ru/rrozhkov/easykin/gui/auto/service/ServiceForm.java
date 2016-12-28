package ru.rrozhkov.easykin.gui.auto.service;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ru.rrozhkov.easykin.auto.service.IService;
import ru.rrozhkov.easykin.auto.service.impl.ServiceFactory;
import ru.rrozhkov.easykin.data.ICollectionDataProvider;
import ru.rrozhkov.easykin.fin.Money;
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
	ICollectionDataProvider<IService> dataProvider;
	public ServiceForm(IService service) {
		this.service = service;
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
	
	public ServiceForm() {
		this(ServiceFactory.createService("", new Money(), new Date()));
	}
	
	public ServiceForm(ICollectionDataProvider<IService> dataProvider) {
		this();
		this.dataProvider = dataProvider;
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
	            }           
	        });
	    }
		return closeButton;
	}
}