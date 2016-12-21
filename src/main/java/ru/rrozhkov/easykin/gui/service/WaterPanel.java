package ru.rrozhkov.easykin.gui.service;

import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;

import ru.rrozhkov.easykin.gui.service.util.CalcUtil;
import ru.rrozhkov.easykin.service.calc.impl.water.WaterCalc;

public class WaterPanel extends Panel{
	public static String HEADER_LABEL_TEXT = "WATER"; 
	public static String COLD_PREV_MESURE_LABEL_TEXT = "Cold previous mesure";
	public static String COLD_CURRENT_MESURE_LABEL_TEXT = "Cold current mesure";
	public static String HOT_PREV_MESURE_LABEL_TEXT = "Hot previous mesure";
	public static String HOT_CURRENT_MESURE_LABEL_TEXT = "Hot current mesure";
	public static String RATE_IN_LABEL_TEXT = "RateIn";
	public static String RATE_OUT_LABEL_TEXT = "RateOut";
	public static String ODN_LABEL_TEXT = "Odn";
	private static final long serialVersionUID = 1L;
	private JTextField coldPrevMesureField = null;
	private JTextField coldCurrentMesureField = null;
	private JTextField hotPrevMesureField = null;
	private JTextField hotCurrentMesureField = null;
	private JTextField rateInField = null;
	private JTextField rateOutField = null;
	private JTextField odnField = null;
	private JLabel coldPrevMesureLabel = null;
	private JLabel coldCurrentMesureLabel = null;
	private JLabel hotPrevMesureLabel = null;
	private JLabel hotCurrentMesureLabel = null;
	private JLabel rateInLabel = null;
	private JLabel rateOutLabel = null;
	private JLabel odnLabel = null;
	
	public WaterPanel(WaterCalc calcBean) {
		super(calcBean);
		setLayout(new GridLayout(10,2)); 
 
		add(getCalcBox());
		add(new JLabel(""));
		add(new JLabel(HEADER_LABEL_TEXT)); 
		add(getItogoLabel()); 
		add(getColdPrevMesureLabel()); 
		add(getColdPrevMesureField()); 
		add(getColdCurrentMesureLabel()); 
		add(getColdCurrentMesureField()); 
		add(getHotPrevMesureLabel()); 
		add(getHotPrevMesureField()); 
		add(getHotCurrentMesureLabel()); 
		add(getHotCurrentMesureField()); 
		add(getRateInLabel()); 
		add(getRateInField()); 
		add(getRateOutLabel()); 
		add(getRateOutField()); 
		add(getOdnLabel()); 
		add(getOdnField());
	    add(getCalcButton());	 
	}

	public JTextField getRateOutField() {
		if(rateOutField == null){
			rateOutField = new JTextField(6);
			String text = String.valueOf(((WaterCalc)calc).getOutRate());
			rateOutField.setText(text);			
		}
		return rateOutField;
	}

	private Component getRateOutLabel() {
		if(rateOutLabel == null)
			rateOutLabel = new JLabel(RATE_OUT_LABEL_TEXT); 
		return rateOutLabel;
	}

	public JTextField getRateInField() {
		if(rateInField == null){
			rateInField = new JTextField(6);
			String text = String.valueOf(((WaterCalc)calc).getInRate());
			rateInField.setText(text);			
		}
		return rateInField;
	}

	private Component getRateInLabel() {
		if(rateInLabel == null)
			rateInLabel = new JLabel(RATE_IN_LABEL_TEXT); 
		return rateInLabel;
	}
	public JTextField getHotCurrentMesureField() {
		if(hotCurrentMesureField == null){
			hotCurrentMesureField = new JTextField(5);
			String text = String.valueOf(((WaterCalc)calc).getHotCurrentMesure());
			hotCurrentMesureField.setText(text);			
		}
		return hotCurrentMesureField;
	}

	private Component getHotCurrentMesureLabel() {
		if(hotCurrentMesureLabel == null)
			hotCurrentMesureLabel = new JLabel(HOT_CURRENT_MESURE_LABEL_TEXT); 
		return hotCurrentMesureLabel;
	}

	public JTextField getHotPrevMesureField() {
		if(hotPrevMesureField == null){
			hotPrevMesureField = new JTextField(5);
			String text = String.valueOf(((WaterCalc)calc).getHotPrevMesure());
			hotPrevMesureField.setText(text);						
		}
		return hotPrevMesureField;
	}

	private Component getHotPrevMesureLabel() {
		if(hotPrevMesureLabel == null)
			hotPrevMesureLabel = new JLabel(HOT_PREV_MESURE_LABEL_TEXT); 
		return hotPrevMesureLabel;
	}

	public JTextField getColdPrevMesureField(){
		if(coldPrevMesureField == null){
			coldPrevMesureField = new JTextField(5);
			String text = String.valueOf(((WaterCalc)calc).getColdPrevMesure());
			coldPrevMesureField.setText(text);						
		}
		return coldPrevMesureField;
	}

	public JTextField getColdCurrentMesureField(){
		if(coldCurrentMesureField == null){
			coldCurrentMesureField = new JTextField(5);
			String text = String.valueOf(((WaterCalc)calc).getColdCurrentMesure());
			coldCurrentMesureField.setText(text);						
		}
		return coldCurrentMesureField;
	}

	public JTextField getOdnField(){
		if(odnField == null){
			odnField = new JTextField(6);
			String text = String.valueOf(((WaterCalc)calc).getOdn());
			odnField.setText(text);									
		}
		return odnField;
	}
	
	public JLabel getColdPrevMesureLabel(){
		if(coldPrevMesureLabel == null)
			coldPrevMesureLabel = new JLabel(COLD_PREV_MESURE_LABEL_TEXT); 
		return coldPrevMesureLabel;
	}
	
	public JLabel getColdCurrentMesureLabel(){
		if(coldCurrentMesureLabel == null)
			coldCurrentMesureLabel = new JLabel(COLD_CURRENT_MESURE_LABEL_TEXT); 
		return coldCurrentMesureLabel;
	}
	
	public JLabel getOdnLabel(){
		if(odnLabel == null)
			odnLabel = new JLabel(ODN_LABEL_TEXT); 
		return odnLabel;
	}

	@Override
	public void updateBean() {
		super.updateBean();
		WaterCalc bean = (WaterCalc)getCalc();
		bean.setColdPrevMesure(CalcUtil.doubleNUllOrEmpty(getColdPrevMesureField().getText()));
		bean.setColdCurrentMesure(CalcUtil.doubleNUllOrEmpty(getColdCurrentMesureField().getText()));
		bean.setHotPrevMesure(CalcUtil.doubleNUllOrEmpty(getHotPrevMesureField().getText()));
		bean.setHotCurrentMesure(CalcUtil.doubleNUllOrEmpty(getHotCurrentMesureField().getText()));
		bean.setInRate(CalcUtil.moneyNUllOrEmpty(getRateInField().getText()));
		bean.setOutRate(CalcUtil.moneyNUllOrEmpty(getRateOutField().getText()));
		bean.setOdn(CalcUtil.moneyNUllOrEmpty(getOdnField().getText()));
	}
}