package ru.rrozhkov.easykin.auto.service.impl;

import java.util.Date;

import ru.rrozhkov.easykin.auto.service.IService;
import ru.rrozhkov.easykin.fin.Money;
import ru.rrozhkov.easykin.util.DateUtil;

public class Service implements IService{
	private String name;
	private Money money;
	private Date date;
	
	public Service(String name, Money money, Date date) {
		this.name = name;
		this.money = money;
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public Money getPrice() {
		return money;
	}

	public Date getDate() {
		return date;
	}

	@Override
	public String toString() {
		return "\n " + name + ", " + money + ", " + DateUtil.format(date);
	}	
}