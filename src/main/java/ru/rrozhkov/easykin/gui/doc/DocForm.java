package ru.rrozhkov.easykin.gui.doc;

import ru.rrozhkov.easykin.gui.IGUIEditor;
import ru.rrozhkov.easykin.gui.util.GuiUtil;
import ru.rrozhkov.easykin.model.doc.IDoc;
import ru.rrozhkov.easykin.util.DateUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DocForm extends JPanel{
	private static final long serialVersionUID = 1L;
	private JTextField typeField;
	private JTextField numberField;
	private JTextField seriesField;
	private JTextField dateField;
	private JLabel typeLabel;
	private JLabel numberLabel;
	private JLabel seriesLabel;
	private JLabel dateLabel;
	private JButton closeButton;

	private IDoc doc;
	private IGUIEditor parent;

	public DocForm(IGUIEditor parent, IDoc doc) {
		this.parent = parent;
		this.doc = doc;
		fill();
	}
	
	private void fill(){
		setLayout(new GridLayout(7, 2));
		add(GuiUtil.getEmptyLabel());
		add(GuiUtil.getEmptyLabel());
		add(getTypeLabel());
		add(getTypeField());
		add(getNumberLabel());
		add(getNumberField());
		add(getSeriesLabel());
		add(getSeriesField());
		add(getDateLabel());
		add(getDateField());
		add(GuiUtil.getEmptyLabel());
		add(getCloseButton());
	}

	private JTextField getTypeField(){
		if(typeField == null){
			typeField = new JTextField(250);
			typeField.setText(doc.getDocType().toString());
			typeField.setEditable(false);
		}
		return typeField;
	}

	private JTextField getNumberField(){
		if(numberField == null){
			numberField = new JTextField(250);
			numberField.setText(doc.getNumber());
			numberField.setEditable(false);
		}
		return numberField;
	}

	private JTextField getSeriesField(){
		if(seriesField == null){
			seriesField = new JTextField(250);
			seriesField.setText(doc.getSeries());
			seriesField.setEditable(false);
		}
		return seriesField;
	}

	private JTextField getDateField(){
		if(dateField == null){
			dateField = new JTextField(10);
			dateField.setText(DateUtil.format(doc.getDate()));
			dateField.setEditable(false);
		}
		return dateField;
	}

	private JLabel getTypeLabel(){
		if(typeLabel == null)
			typeLabel = new JLabel("Тип");
		return typeLabel;
	}

	private JLabel getNumberLabel(){
		if(numberLabel == null)
			numberLabel = new JLabel("Номер");
		return numberLabel;
	}

	private JLabel getSeriesLabel(){
		if(seriesLabel == null)
			seriesLabel = new JLabel("Серия");
		return seriesLabel;
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