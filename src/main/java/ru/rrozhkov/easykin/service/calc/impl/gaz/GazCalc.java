package ru.rrozhkov.easykin.service.calc.impl.gaz;

import ru.rrozhkov.easykin.fin.Money;
import ru.rrozhkov.easykin.service.calc.CalculationType;
import ru.rrozhkov.easykin.service.calc.impl.SimpleCalc;

public class GazCalc extends SimpleCalc {
	public GazCalc(double gazPrevMesure, double gazCurrentMesure,
			Money gazRate) {
		super(gazPrevMesure, gazCurrentMesure,gazRate);
	}

	public String getName() {
		return CalculationType.GAZ.toString();
	}
}