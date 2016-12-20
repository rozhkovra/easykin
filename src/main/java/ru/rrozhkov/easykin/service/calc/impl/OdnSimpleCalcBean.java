package ru.rrozhkov.easykin.service.calc.impl;

import ru.rrozhkov.easykin.fin.Money;

public abstract class OdnSimpleCalcBean extends SimpleCalcBean {
	protected Money odn;
	
	public OdnSimpleCalcBean(double prevMesure, double currentMesure, Money rate,
			Money odn) {
		super(prevMesure, currentMesure, rate);
		this.odn = odn;
	}
	public Money getOdn() {
		return odn;
	}
	public void setOdn(Money odn) {
		this.odn = odn;
	}
}