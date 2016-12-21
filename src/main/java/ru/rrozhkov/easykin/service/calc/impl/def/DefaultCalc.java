package ru.rrozhkov.easykin.service.calc.impl.def;

import ru.rrozhkov.easykin.fin.Money;
import ru.rrozhkov.easykin.service.calc.impl.Calculation;

public class DefaultCalc extends Calculation {
	private Money sum;
	private String name;

	public DefaultCalc(String name, Money sum) {
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