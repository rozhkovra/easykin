package ru.rrozhkov.easykin.gui.service;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ru.rrozhkov.easykin.model.fin.util.FormatUtil;
import ru.rrozhkov.easykin.model.service.calc.ICalculator;
import ru.rrozhkov.easykin.model.service.calc.impl.Calculation;
import ru.rrozhkov.easykin.model.service.calc.impl.CalculatorFactory;

public abstract class Panel extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	public static String CALC_LABEL_TEXT = "Пуск";
	private JLabel itogoLabel = null;
	private JButton calcButton = null;
	private ICalculator calculator;
	protected Calculation calc; 
	
	public Panel(Calculation calc) {
		super();
		this.calc = calc;
		this.calculator = CalculatorFactory.getCalculator(calc);
	}
	public void actionPerformed(ActionEvent e) {
			updateBean();
			updateUI();
	}
	@Override
	public void updateUI() {
		super.updateUI();
		if(calculator!=null)
			getItogoLabel().setText(FormatUtil.formatMoney(calculator.calculate().getResult()));
	}
	public JLabel getItogoLabel(){
		if(itogoLabel == null){
			itogoLabel  = new JLabel("");
			itogoLabel.setFont(itogoLabel.getFont().deriveFont(Font.BOLD, 20));			
		}
		return itogoLabel;
	}
	public JLabel getEmptyLabel(){
		return new JLabel("");
	}
	public JLabel getCalcTypeLabel(){
		return new JLabel(String.valueOf(calc.getType()));
	}
	public JButton getCalcButton(){
	    if(calcButton==null){
	    	calcButton = new JButton(CALC_LABEL_TEXT);
	    	calcButton.addActionListener(this);
	    }
		return calcButton;
	}
	public Calculation getCalc(){
		return calc;
	}
	abstract public void updateBean();
}