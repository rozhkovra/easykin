package ru.rrozhkov.easykin.service.calc.impl;

import ru.rrozhkov.easykin.fin.Money;
import ru.rrozhkov.easykin.service.calc.CalcBean;

public class DefaultCalcBean extends CalcBean {
	private Money sum;
	private String name;

	public DefaultCalcBean(String name, Money sum) {
		this.sum = sum;
		this.name = name;
	}

	public Money getSum() {
		return sum;
	}

	public String getName() {
		return name;
	}

	public void setSum(Money sum) {
		this.sum = sum;
	}	
}