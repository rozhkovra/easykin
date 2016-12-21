package ru.rrozhkov.easykin.service.calc.impl;

import ru.rrozhkov.easykin.service.calc.ICalculation;

public abstract class Calculation implements ICalculation{
	private boolean needCalc = true; 
	public boolean needCalc(){return needCalc;}
	public void setCalc(boolean needCalc){this.needCalc=needCalc;}	
}