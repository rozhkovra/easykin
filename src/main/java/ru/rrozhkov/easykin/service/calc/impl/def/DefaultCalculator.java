package ru.rrozhkov.easykin.service.calc.impl.def;

import ru.rrozhkov.easykin.service.calc.impl.Calculator;


public class DefaultCalculator extends Calculator {
	public DefaultCalculator(DefaultCalc calcBean) {
		super(calcBean);
	}

	public DefaultResult calculate() {
		DefaultCalc calcBean = (DefaultCalc)getCalc();
		return new DefaultResult(String.valueOf(calcBean.getType()), calcBean.getSum());
	}
}