package ru.rrozhkov.easykin.model.service.calc.impl;

import ru.rrozhkov.easykin.model.service.calc.ICalculation;

public abstract class Calculation implements ICalculation{
	private boolean needCalc = true; 
	private boolean isPaid = false;
	public boolean isPaid() {return isPaid;}
	public void setPaid(boolean isPaid) {this.isPaid = isPaid;}
	public boolean needCalc(){return needCalc;}
	public void setCalc(boolean needCalc){this.needCalc=needCalc;}	
}