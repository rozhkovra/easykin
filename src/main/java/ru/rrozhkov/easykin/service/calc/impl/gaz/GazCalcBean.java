package ru.rrozhkov.easykin.service.calc.impl.gaz;

import ru.rrozhkov.easykin.fin.Money;
import ru.rrozhkov.easykin.service.calc.impl.SimpleCalcBean;

public class GazCalcBean extends SimpleCalcBean {
	public GazCalcBean(double gazPrevMesure, double gazCurrentMesure,
			Money gazRate) {
		super(gazPrevMesure, gazCurrentMesure,gazRate);
	}

	@Override
	public String getName() {
		return "Gaz";
	}
}