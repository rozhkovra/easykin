package ru.rrozhkov.easykin.service.calc.impl.gaz;

import ru.rrozhkov.easykin.fin.Money;
import ru.rrozhkov.easykin.fin.util.FormatUtil;
import ru.rrozhkov.easykin.service.calc.impl.Result;

public class GazResult extends Result {
	private double delta;
	
	public GazResult(double delta, Money sum) {
		super(sum);
		this.delta = delta;
	}

	public double getDelta(){
		return delta;
	}

	@Override
	public String toString() {
		return "GAZ"
//				+ "\nDelta = "+formatCurrency(getDelta())
				+ "\nSum = "+FormatUtil.formatMoney(getResult())
				+ "\n\n";
	}
}