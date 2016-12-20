package ru.rrozhkov.easykin.gui.service;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;

import ru.rrozhkov.easykin.service.calc.impl.gaz.GazCalcBean;

public class GazPanel extends Panel{
	public static String HEADER_LABEL_TEXT = "GAZ"; 
	public static String PREV_MESURE_LABEL_TEXT = "Previous mesure";
	public static String CURRENT_MESURE_LABEL_TEXT = "Current mesure";
	public static String RATE_LABEL_TEXT = "Rate";
	private static final long serialVersionUID = 1L;
	private JTextField prevMesureField = null;
	private JTextField currentMesureField = null;
	private JTextField rateField = null;
	private JLabel prevMesureLabel = null;
	private JLabel currentMesureLabel = null;
	private JLabel rateLabel = null;
	
	public GazPanel(GazCalcBean calcBean) {
		super(calcBean);
		setLayout(new GridLayout(6,2)); 
 
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
		add(getCalcButton());
	}
	
	public JTextField getPrevMesureField(){
		if(prevMesureField == null){
			prevMesureField = new JTextField(5);
			String text = String.valueOf(((GazCalcBean)calcBean).getPrevMesure());
			prevMesureField.setText(text);			
		}
		return prevMesureField;
	}

	public JTextField getCurrentMesureField(){
		if(currentMesureField == null){
			currentMesureField = new JTextField(5);
			String text = String.valueOf(((GazCalcBean)calcBean).getCurrentMesure());
			currentMesureField.setText(text);			
		}
		return currentMesureField;
	}
	
	public JTextField getRateField(){
		if(rateField == null){
			rateField = new JTextField(5);
			String text = String.valueOf(((GazCalcBean)calcBean).getRate());
			rateField.setText(text);			
		}
		return rateField;
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

	@Override
	public void updateBean() {
		super.updateBean();
		GazCalcBean bean = (GazCalcBean)getCalcBean();
		bean.setPrevMesure(CalcUtil.doubleNUllOrEmpty(getPrevMesureField().getText()));
		bean.setCurrentMesure(CalcUtil.doubleNUllOrEmpty(getCurrentMesureField().getText()));
		bean.setRate(CalcUtil.moneyNUllOrEmpty(getRateField().getText()));
	}
}