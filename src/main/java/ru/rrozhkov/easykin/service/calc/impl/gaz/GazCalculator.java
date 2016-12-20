package ru.rrozhkov.easykin.service.calc.impl.gaz;

import ru.rrozhkov.easykin.fin.Money;
import ru.rrozhkov.easykin.service.calc.Calculator;

public class GazCalculator extends Calculator {
	public GazCalculator(GazCalcBean gaz) {
		super(gaz);
	}

	public GazResult calculate() {
		GazCalcBean calcBean = (GazCalcBean)getCalcBean(); 
		double delta = calcBean.getCurrentMesure()-calcBean.getPrevMesure();
		return  new GazResult(delta, new Money(delta*calcBean.getRate().getValue()));
	}
}