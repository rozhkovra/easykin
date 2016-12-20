package ru.rrozhkov.easykin.fin;

import ru.rrozhkov.easykin.fin.util.FormatUtil;

public class Money {
	double value;
	
	public Money() {
		this.value = 0.0;
	}

	public Money(double value) {
		this.value = value;
	}

	public Money(int rubles, int kopeck) {
		this.value = (double)rubles + ((double)kopeck)/100;
	}

	public int getRubles() {
		return (int)value;
	}

	public int getKopeck() {
		return (int)((value - getRubles())*100);
	}

	@Override
	public String toString() {
		return FormatUtil.formatRubles(getRubles()) + "." + FormatUtil.formatKopeck(getKopeck());
	}
	
	public Money add(Money money){
		this.value+=money.value;
		return this;
	}

	public Money substract(Money money){
		this.value-=money.value;
		return this;
	}
}