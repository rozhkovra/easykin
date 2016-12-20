package ru.rrozhkov.easykin.service.calc;

import ru.rrozhkov.easykin.fin.Money;

public abstract class Result {
	protected Money sum;
	public Result(Money sum){
		this.sum = sum;
	}
	public Money getSum(){return sum;}
}