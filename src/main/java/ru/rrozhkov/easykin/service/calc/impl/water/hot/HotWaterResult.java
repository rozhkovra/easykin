package ru.rrozhkov.easykin.service.calc.impl.water.hot;

import ru.rrozhkov.easykin.fin.Money;
import ru.rrozhkov.easykin.fin.util.FormatUtil;
import ru.rrozhkov.easykin.service.calc.Result;

public class HotWaterResult extends Result {
	private double hotDelta = 0;
	private Money hotSum;
	
	public HotWaterResult(double hotDelta,
			Money hotSum, Money sum) {
		super(sum);
		this.hotDelta = hotDelta;
		this.hotSum = hotSum;
	}
	public double getHotDelta() {
		return hotDelta;
	}
	public Money getHotSum() {
		return hotSum;
	}
	public String toString(){
		return "HOTWATER"
//				+ "\nHotDelta = "+formatInt(getHotDelta())
				+ "\nHotSum = "+FormatUtil.formatMoney(getHotSum())
				+ "\nSum = "+FormatUtil.formatMoney(getSum())
				+ "\n\n";
	}
}