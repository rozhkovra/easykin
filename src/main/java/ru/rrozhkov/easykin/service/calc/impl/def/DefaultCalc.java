package ru.rrozhkov.easykin.service.calc.impl.def;

import ru.rrozhkov.easykin.fin.Money;
import ru.rrozhkov.easykin.service.calc.CalculationType;
import ru.rrozhkov.easykin.service.calc.impl.Calculation;

public class DefaultCalc extends Calculation {
	private Money sum;
	private CalculationType type;

	public DefaultCalc(CalculationType type, Money sum) {
		this.sum = sum;
		this.type = type;
	}

	public Money getSum() {
		return sum;
	}

	public CalculationType getType() {
		return type;
	}

	public void setSum(Money sum) {
		this.sum = sum;
	}	
}