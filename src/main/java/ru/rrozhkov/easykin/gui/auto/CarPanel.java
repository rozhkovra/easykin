package ru.rrozhkov.easykin.gui.auto;

import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ru.rrozhkov.easykin.model.auto.ICar;

public class CarPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTextField brendField = null;
	private JTextField modelField = null;
	private JTextField bodyField = null;
	private JTextField yearField = null;
	private JTextField volumeField = null;
	private JLabel brendLabel = null;
	private JLabel modelLabel = null;
	private JLabel bodyLabel = null;
	private JLabel yearLabel = null;
	private JLabel volumeLabel = null;
	private ICar car;
	public CarPanel(ICar car) {
		this.car = car;
		
		setLayout(new GridLayout(5,2)); 		
 
		add(getBrendLabel()); 
		add(getBredField()); 
		add(getModelLabel()); 
		add(getModelField()); 
		add(getBodyLabel()); 
		add(getBodyField()); 
		add(getYearLabel()); 
		add(getYearField()); 
		add(getVolumeLabel()); 
		add(getVolumeField()); 
	}
	
	private JTextField getVolumeField() {
		if(volumeField == null){
			volumeField = new JTextField(10);
			volumeField.setText(String.valueOf(car.getVolume()));
			volumeField.setEditable(false);
		}
		return volumeField;
	}

	private Component getVolumeLabel() {
		if(volumeLabel == null)
			volumeLabel = new JLabel("Объем"); 
		return volumeLabel;
	}

	private JTextField getYearField() {
		if(yearField == null){
			yearField = new JTextField(10);
			yearField.setText(String.valueOf(car.getYear()));
			yearField.setEditable(false);
		}
		return yearField;
	}

	private Component getYearLabel() {		
		if(yearLabel == null)
			yearLabel = new JLabel("Год"); 
		return yearLabel;
	}

	public JTextField getBredField(){
		if(brendField == null){
			brendField = new JTextField(10);
			brendField.setText(car.getBrend().toString());
			brendField.setEditable(false);
		}
		return brendField;
	}

	public JTextField getModelField(){
		if(modelField == null){
			modelField = new JTextField(10);
			modelField.setText(car.getModel().toString());
			modelField.setEditable(false);
		}
		return modelField;
	}
	
	public JTextField getBodyField(){
		if(bodyField == null){
			bodyField = new JTextField(10);
			bodyField.setText(car.getBody().toString());
			bodyField.setEditable(false);
		}
		return bodyField;
	}
	
	public JLabel getBrendLabel(){
		if(brendLabel == null)
			brendLabel = new JLabel("Марка"); 
		return brendLabel;
	}
	
	public JLabel getModelLabel(){
		if(modelLabel == null)
			modelLabel = new JLabel("Модель"); 
		return modelLabel;
	}
	
	public JLabel getBodyLabel(){
		if(bodyLabel == null)
			bodyLabel = new JLabel("Кузов"); 
		return bodyLabel;
	}
}