package ru.rrozhkov.easykin.service.calc.impl.electricity;

import ru.rrozhkov.easykin.fin.Money;
import ru.rrozhkov.easykin.service.calc.CalculationType;
import ru.rrozhkov.easykin.service.calc.impl.OdnSimpleCalc;

public class ElectricityCalc extends OdnSimpleCalc {


	public ElectricityCalc(int prevMesure, int currentMesure, Money rate,
			Money odn) {
		super(prevMesure, currentMesure, rate, odn);
	}
	
	public String getName() {
		return CalculationType.ELECTRICITY.toString();
	}
}