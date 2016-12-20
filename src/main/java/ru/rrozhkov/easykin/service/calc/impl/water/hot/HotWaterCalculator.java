package ru.rrozhkov.easykin.service.calc.impl.water.hot;

import ru.rrozhkov.easykin.fin.Money;
import ru.rrozhkov.easykin.service.calc.Calculator;

public class HotWaterCalculator extends Calculator {
	public HotWaterCalculator(HotWaterCalcBean calcBean) {
		super(calcBean);
	}

	public HotWaterResult calculate() {
		HotWaterCalcBean calcBean = (HotWaterCalcBean)getCalcBean();
		double hotDelta = calcBean.getCurrentMesure()-calcBean.getPrevMesure();
		Money hotSum = new Money(hotDelta*calcBean.getRate().getValue());
		Money sum = hotSum.add(calcBean.getOdn());
		return new HotWaterResult(hotDelta, hotSum, sum);
	}
}