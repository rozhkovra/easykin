package ru.rrozhkov.easykin.gui.payment;

import ru.rrozhkov.easykin.gui.IGUIEditor;
import ru.rrozhkov.easykin.gui.util.GuiUtil;
import ru.rrozhkov.easykin.model.fin.payment.IPayment;
import ru.rrozhkov.easykin.model.fin.payment.PaymentCategory;
import ru.rrozhkov.easykin.util.DateUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaymentForm extends JPanel{
	private static final long serialVersionUID = 1L;
	private JTextField commentField;
	private JTextField amountField;
	private JTextField dateField;
	private JLabel nameLabel;
	private JLabel priceLabel;
	private JLabel dateLabel;
	private JButton closeButton;
	private IPayment payment;
	private IGUIEditor parent;
	private JComboBox categoryComboBox;
	private JLabel categoryLabel;
	
	public PaymentForm(IGUIEditor parent, IPayment payment) {
		this.payment = payment;
		this.parent = parent;
		fill();
	}

	public PaymentForm(IGUIEditor parent) {
		this(parent, null);
	}

	
	private void fill(){
		setLayout(new GridLayout(6,2)); 		
		add(GuiUtil.getEmptyLabel());
		add(GuiUtil.getEmptyLabel());
		add(getCommentLabel()); 
		add(getCommentField()); 
		add(getAmountLabel()); 
		add(getAmountField()); 
		add(getDateLabel()); 
		add(getDateField());
		add(getCategoryLabel()); 
		add(getCategoryComboBox()); 
		add(GuiUtil.getEmptyLabel());
		add(getCloseButton());
	}

	private JTextField getCommentField(){
		if(commentField == null){
			commentField = new JTextField(50);
			commentField.setText(payment.getComment());
		}
		return commentField;
	}

	private JTextField getAmountField(){
		if(amountField == null){
			amountField = new JTextField(10);
			amountField.setText(payment.getAmount().toString());
		}
		return amountField;
	}
	
	private JTextField getDateField(){
		if(dateField == null){
			dateField = new JTextField(10);
			dateField.setText(DateUtil.format(payment.getDate()));
		}
		return dateField;
	}
	
	private JComboBox getCategoryComboBox(){
		if(categoryComboBox == null){
			categoryComboBox = new JComboBox(new PaymentCategory[]{
					PaymentCategory.AUTO,
					PaymentCategory.AUTODETAIL,
					PaymentCategory.AUTOREPAIR,
					PaymentCategory.SERVICE,
					PaymentCategory.TASK
					}
			);
			categoryComboBox.setSelectedItem(payment.getCategory());
		}
		return categoryComboBox;
	}
	
	private JLabel getCommentLabel(){
		if(nameLabel == null)
			nameLabel = new JLabel("Описание"); 
		return nameLabel;
	}
	
	private JLabel getAmountLabel(){
		if(priceLabel == null)
			priceLabel = new JLabel("Цена"); 
		return priceLabel;
	}
	
	private JLabel getDateLabel(){
		if(dateLabel == null)
			dateLabel = new JLabel("Дата"); 
		return dateLabel;
	}
	
	private JLabel getCategoryLabel(){
		if(categoryLabel == null)
			categoryLabel = new JLabel("Категория"); 
		return categoryLabel;
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