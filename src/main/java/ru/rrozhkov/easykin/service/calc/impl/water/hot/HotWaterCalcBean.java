package ru.rrozhkov.easykin.service.calc.impl.water.hot;

import ru.rrozhkov.easykin.fin.Money;
import ru.rrozhkov.easykin.service.calc.impl.OdnSimpleCalcBean;

public class HotWaterCalcBean extends OdnSimpleCalcBean {
	
	public HotWaterCalcBean(double hotPrevMesure, double hotCurrentMesure,
			Money rate, Money odn) {
		super(hotPrevMesure, hotCurrentMesure, rate, odn);
	}
	@Override
	public String getName() {
		return "HotWater";
	}
}