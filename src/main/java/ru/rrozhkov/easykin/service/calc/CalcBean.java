package ru.rrozhkov.easykin.service.calc;

public abstract class CalcBean {
	private boolean isCalc = true; 
	public boolean isCalc(){return isCalc;}
	public void setCalc(boolean isCalc){this.isCalc=isCalc;}
	public abstract String getName();
}