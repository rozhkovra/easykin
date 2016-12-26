package ru.rrozhkov.easykin.auto.service.impl;

import java.util.Date;

import ru.rrozhkov.easykin.fin.Money;

public class DetailService extends Service {
	public DetailService(String name, Money price, Date date) {
		super(name, price, date);;
	}
	@Override
	public String toString() {
		return "\n  " + getName() + ", " + getPrice()+"\n";
	}
}