package ru.rrozhkov.easykin.model.auto.service.impl;

import java.util.Collection;
import java.util.Date;

import ru.rrozhkov.easykin.model.auto.service.IService;
import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.util.DateUtil;

public class RepairService extends Service{
	private Collection<IService> details;

	public RepairService(String name, Money money, Date date,
			Collection<IService> details) {
		super(name, money, date);
		this.details = details;
	}

	public Collection<IService> services() {
		return details;
	}

	@Override
	public String toString() {
		return "\n " + getName()
				+ ", " + getPrice() + ", " + DateUtil.format(getDate())
				+ "\n details=" + details + "\n";
	}	
}