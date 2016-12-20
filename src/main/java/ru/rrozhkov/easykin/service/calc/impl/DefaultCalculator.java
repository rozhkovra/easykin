package ru.rrozhkov.easykin.service.calc.impl;

import ru.rrozhkov.easykin.service.calc.Calculator;

public class DefaultCalculator extends Calculator {
	public DefaultCalculator(DefaultCalcBean calcBean) {
		super(calcBean);
	}

	public DefaultResult calculate() {
		DefaultCalcBean calcBean = (DefaultCalcBean)getCalcBean();
		return new DefaultResult(calcBean.getName(), calcBean.getSum());
	}
}