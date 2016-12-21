package ru.rrozhkov.easykin.gui.service;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;

import ru.rrozhkov.easykin.gui.service.util.CalcUtil;
import ru.rrozhkov.easykin.service.calc.impl.def.DefaultCalc;

public class DefaultPanel extends Panel {
	public static String HEADER_LABEL_TEXT = ""; 
	public static String SUM_LABEL_TEXT = "Сумма";
	private static final long serialVersionUID = 1L;
	private JTextField sumField = null;
	private JLabel sumLabel = null;
	
	public DefaultPanel(DefaultCalc calcBean) {		
		super(calcBean);
		setLayout(new GridLayout(4,2));		
 
		add(getCalcBox());
		add(new JLabel(""));
		add(new JLabel(calcBean.getName())); 
		add(getItogoLabel()); 
		add(getSumLabel()); 
		add(getSumField()); 
		add(getCalcButton());
	}
	public JTextField getSumField(){
		if(sumField == null){
			sumField = new JTextField(10);
			String sum = String.valueOf(((DefaultCalc)calc).getSum());
			sumField.setText(sum);
		}
		return sumField;
	}
	public JLabel getSumLabel(){
		if(sumLabel == null)
			sumLabel = new JLabel(SUM_LABEL_TEXT); 
		return sumLabel;
	}
	@Override
	public void updateBean() {
		super.updateBean();
		DefaultCalc bean = (DefaultCalc)getCalc();
		bean.setSum(CalcUtil.moneyNUllOrEmpty(getSumField().getText()));
	}
}