package ru.rrozhkov.easykin.gui.service;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;

import ru.rrozhkov.easykin.gui.service.util.CalcUtil;
import ru.rrozhkov.easykin.model.fin.util.FormatUtil;
import ru.rrozhkov.easykin.model.service.calc.impl.def.DefaultCalc;

public class DefaultPanel extends Panel { 
	private static final long serialVersionUID = 1L;
	private JTextField sumField;
	private JLabel sumLabel;
	
	public DefaultPanel(DefaultCalc calcBean) {		
		super(calcBean);
		fill();
	}
	
	private void fill(){
		setLayout(new GridLayout(4,2));		
 		add(getCalcBox());
		add(new JLabel(""));
		add(new JLabel(String.valueOf(calc.getType()))); 
		add(getItogoLabel()); 
		add(getSumLabel()); 
		add(getSumField()); 
		add(getCalcButton());
	}
	
	public JTextField getSumField(){
		if(sumField == null){
			sumField = new JTextField(10);
			String sum = FormatUtil.formatEditMoney(((DefaultCalc)calc).getSum());
			sumField.setText(sum);
		}
		return sumField;
	}
	public JLabel getSumLabel(){
		if(sumLabel == null)
			sumLabel = new JLabel("Сумма"); 
		return sumLabel;
	}
	@Override
	public void updateBean() {
		super.updateBean();
		DefaultCalc bean = (DefaultCalc)getCalc();
		bean.setSum(CalcUtil.moneyNUllOrEmpty(getSumField().getText()));
	}
}