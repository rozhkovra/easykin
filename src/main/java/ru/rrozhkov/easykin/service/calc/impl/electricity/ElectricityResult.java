package ru.rrozhkov.easykin.service.calc.impl.electricity;

import ru.rrozhkov.easykin.fin.Money;
import ru.rrozhkov.easykin.fin.util.FormatUtil;
import ru.rrozhkov.easykin.service.calc.impl.Result;

public class ElectricityResult extends Result {
	private double delta;
	private Money deltaSum;
	
	public ElectricityResult(double delta, Money deltaSum, Money sum) {
		super(sum);
		this.delta = delta;
		this.deltaSum = deltaSum;
	}

	public double getDelta() {
		return delta;
	}

	public Money getDeltaSum() {
		return deltaSum;
	}

	@Override
	public String toString() {
		return "ELECTRICITY"
//				+ "\nDelta = "+FormatUtil.formatMoney(getDelta())
				+ "\ndeltaSum = "+FormatUtil.formatMoney(getDeltaSum())
				+ "\nsum = "+FormatUtil.formatMoney(getResult())
				+ "\n\n";
	}
}