package ru.rrozhkov.easykin.service.calc.impl.water.hot;

import ru.rrozhkov.easykin.fin.Money;
import ru.rrozhkov.easykin.service.calc.CalculationType;
import ru.rrozhkov.easykin.service.calc.impl.OdnSimpleCalc;

public class HotWaterCalc extends OdnSimpleCalc {
	
	public HotWaterCalc(double hotPrevMesure, double hotCurrentMesure,
			Money rate, Money odn) {
		super(hotPrevMesure, hotCurrentMesure, rate, odn);
	}
	
	public String getName() {
		return CalculationType.HOTWATER.toString();
	}
}