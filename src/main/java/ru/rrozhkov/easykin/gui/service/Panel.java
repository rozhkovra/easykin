package ru.rrozhkov.easykin.gui.service;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ru.rrozhkov.easykin.fin.util.FormatUtil;
import ru.rrozhkov.easykin.service.calc.CalcBean;
import ru.rrozhkov.easykin.service.calc.Calculator;
import ru.rrozhkov.easykin.service.calc.CalculatorFactory;

public abstract class Panel extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	public static String CALC_LABEL_TEXT = "Calc";
	private JLabel itogoLabel = null;
	private JButton calcButton = null;
	private JCheckBox calcBox = null;
	private Calculator calculator;
	protected CalcBean calcBean; 
	
	public Panel(CalcBean calcBean) {
		super();
		this.calcBean = calcBean;
		this.calculator = CalculatorFactory.getCalculator(calcBean);
	}
	public void actionPerformed(ActionEvent e) {
		if(isCalc()) {
			updateBean();
			updateUI();
		}
	}
	@Override
	public void updateUI() {
		super.updateUI();
		if(calculator!=null)
			getItogoLabel().setText(FormatUtil.formatMoney(calculator.calculate().getSum()));
	}
	public JLabel getItogoLabel(){
		if(itogoLabel == null)
			itogoLabel  = new JLabel("");
		return itogoLabel;
	}
	public JButton getCalcButton(){
	    if(calcButton==null){
	    	calcButton = new JButton(CALC_LABEL_TEXT);
	    	calcButton.addActionListener(this);
	    }
		return calcButton;
	}
	public JCheckBox getCalcBox(){
	    if(calcBox==null){
	    	calcBox = new JCheckBox();
	    	calcBox.setSelected(true);
	    }
		return calcBox;
	}
	private boolean isCalc(){
		return getCalcBox().isSelected();
	}
	public CalcBean getCalcBean(){
		return calcBean;
	}
	public void updateBean(){
		calcBean.setCalc(isCalc());
	}
}