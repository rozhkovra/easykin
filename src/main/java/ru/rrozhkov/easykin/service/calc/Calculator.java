package ru.rrozhkov.easykin.service.calc;

public abstract class Calculator {
	protected CalcBean calcBean;
	public Calculator(CalcBean bean) {this.calcBean = bean;}
	public CalcBean getCalcBean(){return calcBean;}
	public abstract Result calculate();
}