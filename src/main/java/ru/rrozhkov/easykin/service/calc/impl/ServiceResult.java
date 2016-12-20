package ru.rrozhkov.easykin.service.calc.impl;

import ru.rrozhkov.easykin.fin.Money;
import ru.rrozhkov.easykin.fin.util.FormatUtil;
import ru.rrozhkov.easykin.service.calc.Result;

public class ServiceResult extends Result {
	public ServiceResult(Money sum) {
		super(sum);
	}

	@Override
	public String toString() {
		return "SERVICERESULT [sum=" + FormatUtil.formatMoney(getSum()) + "]";
	}
}