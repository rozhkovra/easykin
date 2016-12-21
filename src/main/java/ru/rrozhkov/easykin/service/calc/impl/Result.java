package ru.rrozhkov.easykin.service.calc.impl;

import ru.rrozhkov.easykin.fin.Money;
import ru.rrozhkov.easykin.service.calc.IResult;

public abstract class Result implements IResult {
	protected Money sum;
	public Result(Money sum){
		this.sum = sum;
	}
	public Money getResult(){return sum;}
}