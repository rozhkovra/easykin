package ru.rrozhkov.easykin.auto.service.impl;

import java.util.Date;

import ru.rrozhkov.easykin.auto.service.IDetail;
import ru.rrozhkov.easykin.fin.Money;

public class Detail implements IDetail {
	private String name;
	private Money price;
	private Date buyDate;
	
	public Detail(String name, Money price, Date date) {
		this.name = name;
		this.price = price;
		this.buyDate = date;
	}

	public String getName() {
		return name;
	}

	public Money getPrice() {
		return price;
	}

	public Date getBuyDate() {
		return buyDate;
	}

	@Override
	public String toString() {
		return "\n  " + name + ", " + price+"\n";
	}	
}