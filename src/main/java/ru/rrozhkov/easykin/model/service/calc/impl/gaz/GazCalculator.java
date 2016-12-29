package ru.rrozhkov.easykin.model.service.calc.impl.gaz;

import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.model.service.calc.impl.Calculator;

public class GazCalculator extends Calculator {
	public GazCalculator(GazCalc gaz) {
		super(gaz);
	}

	public GazResult calculate() {
		GazCalc calcBean = (GazCalc)getCalc(); 
		double delta = calcBean.getCurrentMesure()-calcBean.getPrevMesure();
		return  new GazResult(delta, new Money(calcBean.getRate()).multiply(delta));
	}
}