package ru.rrozhkov.easykin.service.calc.impl;

import ru.rrozhkov.easykin.fin.Money;
import ru.rrozhkov.easykin.fin.util.FormatUtil;
import ru.rrozhkov.easykin.service.calc.Result;

public class DefaultResult extends Result {
	private String name;
	
	public DefaultResult(String name, Money sum) {
		super(sum);
		this.name = name;
	}

	@Override
	public String toString() {
		return name+"\nsum = " + FormatUtil.formatMoney(getSum()) + "\n\n";
	}
}