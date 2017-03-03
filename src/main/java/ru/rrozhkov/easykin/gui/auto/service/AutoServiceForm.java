package ru.rrozhkov.easykin.gui.auto.service;

import ru.rrozhkov.easykin.gui.IGUIEditor;
import ru.rrozhkov.easykin.gui.util.GuiUtil;
import ru.rrozhkov.easykin.model.auto.service.IService;
import ru.rrozhkov.easykin.model.auto.service.impl.ServiceFactory;
import ru.rrozhkov.easykin.model.fin.MoneyFactory;
import ru.rrozhkov.easykin.util.DateUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class AutoServiceForm extends JPanel{
	private static final long serialVersionUID = 1L;
	private JTextField nameField;
	private JTextField priceField;
	private JTextField dateField;
	private JLabel nameLabel;
	private JLabel priceLabel;
	private JLabel dateLabel;
	private JButton closeButton;
	private IService service;
	private IGUIEditor parent;
	public AutoServiceForm(IGUIEditor parent, IService service) {
		this.service = service;
		this.parent = parent;
		fill();
	}
	
	public AutoServiceForm(IGUIEditor parent) {
		this(parent, ServiceFactory.createService("", MoneyFactory.create(), new Date()));
	}
	
	private void fill(){
		setLayout(new GridLayout(5,2)); 		
		add(GuiUtil.getEmptyLabel());
		add(GuiUtil.getEmptyLabel());
		add(getNameLabel()); 
		add(getNameField()); 
		add(getPriceLabel()); 
		add(getPriceField()); 
		add(getDateLabel()); 
		add(getDateField());
		add(GuiUtil.getEmptyLabel());
		add(getCloseButton());
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