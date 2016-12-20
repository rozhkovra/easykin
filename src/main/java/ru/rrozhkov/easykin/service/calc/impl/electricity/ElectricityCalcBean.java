package ru.rrozhkov.easykin.service.calc.impl.electricity;

import ru.rrozhkov.easykin.fin.Money;
import ru.rrozhkov.easykin.service.calc.impl.OdnSimpleCalcBean;

public class ElectricityCalcBean extends OdnSimpleCalcBean {


	public ElectricityCalcBean(int prevMesure, int currentMesure, Money rate,
			Money odn) {
		super(prevMesure, currentMesure, rate, odn);
	}
	
	public String getName() {
		return "Electricity";
	}
}