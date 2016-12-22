package ru.rrozhkov.easykin.service.calc.impl.water.hot;

import ru.rrozhkov.easykin.fin.Money;
import ru.rrozhkov.easykin.service.calc.impl.Calculator;

public class HotWaterCalculator extends Calculator {
	public HotWaterCalculator(HotWaterCalc calc) {
		super(calc);
	}

	public HotWaterResult calculate() {
		HotWaterCalc calc = (HotWaterCalc)getCalc();
		double hotDelta = calc.getCurrentMesure()-calc.getPrevMesure();
		Money hotSum = new Money(calc.getRate()).multiply(hotDelta);
		Money sum = hotSum.add(calc.getOdn());
		return new HotWaterResult(hotDelta, hotSum, sum);
	}
}