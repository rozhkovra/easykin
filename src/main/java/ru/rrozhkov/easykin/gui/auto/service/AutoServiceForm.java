package ru.rrozhkov.easykin.gui.auto.service;

import ru.rrozhkov.easykin.gui.Form;
import ru.rrozhkov.easykin.gui.IGUIEditor;
import ru.rrozhkov.easykin.gui.util.GuiUtil;
import ru.rrozhkov.easykin.model.auto.service.IService;
import ru.rrozhkov.easykin.model.auto.service.impl.ServiceFactory;
import ru.rrozhkov.easykin.model.fin.MoneyFactory;
import ru.rrozhkov.easykin.util.DateUtil;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class AutoServiceForm extends Form {
	private static final long serialVersionUID = 1L;
	private JTextField nameField;
	private JTextField priceField;
	private JTextField dateField;
	private JLabel nameLabel;
	private JLabel priceLabel;
	private JLabel dateLabel;
	private IService service;
	public AutoServiceForm(IGUIEditor parent, IService service) {
		super(parent);
		this.service = service;
		fill();
	}
	
	public AutoServiceForm(IGUIEditor parent) {
		this(parent, ServiceFactory.createService("", MoneyFactory.create(), new Date()));
	}
	
	protected void fill(){
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
		add(getCancelButton());
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
}