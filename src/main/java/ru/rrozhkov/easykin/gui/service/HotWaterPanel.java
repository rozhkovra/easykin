package ru.rrozhkov.easykin.gui.service;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;

import ru.rrozhkov.easykin.gui.service.util.CalcUtil;
import ru.rrozhkov.easykin.service.calc.impl.water.hot.HotWaterCalc;

public class HotWaterPanel extends Panel{
	public static String HEADER_LABEL_TEXT = "HOT WATER"; 
	public static String PREV_MESURE_LABEL_TEXT = "Предыдущие показания";
	public static String CURRENT_MESURE_LABEL_TEXT = "Текущие показания";
	public static String RATE_LABEL_TEXT = "Тариф";
	public static String ODN_LABEL_TEXT = "ОДН";
	private static final long serialVersionUID = 1L;
	private JTextField prevMesureField = null;
	private JTextField currentMesureField = null;
	private JTextField rateField = null;
	private JTextField odnField = null;
	private JLabel prevMesureLabel = null;
	private JLabel currentMesureLabel = null;
	private JLabel rateLabel = null;
	private JLabel odnLabel = null;
	
	public HotWaterPanel(HotWaterCalc calcBean) {
		super(calcBean);
		setLayout(new GridLayout(7,2)); 
 
		add(getCalcBox());
		add(new JLabel(""));
		add(new JLabel(HEADER_LABEL_TEXT)); 
		add(getItogoLabel()); 
		add(getPrevMesureLabel()); 
		add(getPrevMesureField()); 
		add(getCurrentMesureLabel()); 
		add(getCurrentMesureField()); 
		add(getRateLabel()); 
		add(getRateField()); 
		add(getOdnLabel()); 
		add(getOdnField());
	    add(getCalcButton());	 
	}
	
	public JTextField getPrevMesureField(){
		if(prevMesureField == null){
			prevMesureField = new JTextField(5);
			String text = String.valueOf(((HotWaterCalc)calc).getPrevMesure());
			prevMesureField.setText(text);			
		}
		return prevMesureField;
	}

	public JTextField getCurrentMesureField(){
		if(currentMesureField == null){
			currentMesureField = new JTextField(5);
			String text = String.valueOf(((HotWaterCalc)calc).getCurrentMesure());
			currentMesureField.setText(text);			
		}
		return currentMesureField;
	}
	
	public JTextField getRateField(){
		if(rateField == null){
			rateField = new JTextField(5);
			String text = String.valueOf(((HotWaterCalc)calc).getRate());
			rateField.setText(text);			
		}
		return rateField;
	}

	public JTextField getOdnField(){
		if(odnField == null){
			odnField = new JTextField(6);
			String text = String.valueOf(((HotWaterCalc)calc).getOdn());
			odnField.setText(text);			
		}
		return odnField;
	}
	
	public JLabel getPrevMesureLabel(){
		if(prevMesureLabel == null)
			prevMesureLabel = new JLabel(PREV_MESURE_LABEL_TEXT); 
		return prevMesureLabel;
	}
	
	public JLabel getCurrentMesureLabel(){
		if(currentMesureLabel == null)
			currentMesureLabel = new JLabel(CURRENT_MESURE_LABEL_TEXT); 
		return currentMesureLabel;
	}
	
	public JLabel getRateLabel(){
		if(rateLabel == null)
			rateLabel = new JLabel(RATE_LABEL_TEXT); 
		return rateLabel;
	}

	public JLabel getOdnLabel(){
		if(odnLabel == null)
			odnLabel = new JLabel(ODN_LABEL_TEXT); 
		return odnLabel;
	}

	@Override
	public void updateBean() {
		super.updateBean();
		HotWaterCalc bean = (HotWaterCalc)getCalc();
		bean.setPrevMesure(CalcUtil.doubleNUllOrEmpty(getPrevMesureField().getText()));
		bean.setCurrentMesure(CalcUtil.doubleNUllOrEmpty(getCurrentMesureField().getText()));
		bean.setRate(CalcUtil.moneyNUllOrEmpty(getRateField().getText()));
		bean.setOdn(CalcUtil.moneyNUllOrEmpty(getOdnField().getText()));
	}
}