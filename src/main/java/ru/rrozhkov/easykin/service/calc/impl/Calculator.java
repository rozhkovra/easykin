package ru.rrozhkov.easykin.service.calc.impl;

import ru.rrozhkov.easykin.service.calc.ICalculator;

public abstract class Calculator implements ICalculator {
	protected Calculation calc;
	public Calculator(Calculation calc) {this.calc = calc;}
	public Calculation getCalc(){return calc;}
}