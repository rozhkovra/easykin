package ru.rrozhkov.easykin.model.service.calc.impl;

import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.model.fin.util.FormatUtil;

public class ServiceResult extends Result {
	public ServiceResult(Money sum) {
		super(sum);
	}

	@Override
	public String toString() {
		return "SERVICERESULT [sum=" + FormatUtil.formatMoney(getResult()) + "]";
	}
}