package ru.rrozhkov.easykin.model.service.calc.impl.def;

import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.model.fin.util.FormatUtil;
import ru.rrozhkov.easykin.model.service.calc.impl.Result;

public class DefaultResult extends Result {
	private String name;
	
	public DefaultResult(String name, Money sum) {
		super(sum);
		this.name = name;
	}

	@Override
	public String toString() {
		return name+"\nsum = " + FormatUtil.formatMoney(getResult()) + "\n\n";
	}
}