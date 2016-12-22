package ru.rrozhkov.easykin.service.calc.impl.electricity;

import ru.rrozhkov.easykin.fin.Money;
import ru.rrozhkov.easykin.service.calc.impl.Calculator;

public class ElectricityCalculator extends Calculator {
	
	public ElectricityCalculator(ElectricityCalc bean) {
		super(bean);
	}

	public ElectricityResult calculate() {
		ElectricityCalc calcBean = (ElectricityCalc)getCalc();
		double delta = calcBean.getCurrentMesure()-calcBean.getPrevMesure();
		Money deltaSum = new Money(calcBean.getRate()).multiply(delta);
		return new ElectricityResult(delta, deltaSum, deltaSum.add(calcBean.getOdn()));
	}
}