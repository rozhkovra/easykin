package ru.rrozhkov.easykin.service.calc.impl.water;

import ru.rrozhkov.easykin.fin.Money;
import ru.rrozhkov.easykin.service.calc.impl.Calculator;

public class WaterCalculator extends Calculator {
	public WaterCalculator(WaterCalc calcBean) {
		super(calcBean);
	}

	public WaterResult calculate() {
		WaterCalc calcBean = (WaterCalc)getCalc();
		double coldDelta = calcBean.getColdCurrentMesure()-calcBean.getColdPrevMesure();
		Money coldSum = new Money(coldDelta*(calcBean.getInRate().add(calcBean.getOutRate()).getValue()));
		double hotDelta = calcBean.getHotCurrentMesure()-calcBean.getHotPrevMesure();
		Money hotSum = new Money(hotDelta*calcBean.getOutRate().getValue());
		Money sum = coldSum.add(hotSum).add(calcBean.getOdn());
		return new WaterResult(coldDelta, coldSum, hotDelta, hotSum, sum);
	}
}