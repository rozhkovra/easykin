package ru.rrozhkov.easykin.model.service.calc.impl.water.hot;

import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.model.fin.util.FormatUtil;
import ru.rrozhkov.easykin.model.service.calc.impl.Result;

public class HotWaterResult extends Result {
	private double hotDelta;
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
				+ "\nSum = "+FormatUtil.formatMoney(getResult())
				+ "\n\n";
	}
}