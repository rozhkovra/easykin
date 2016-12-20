package ru.rrozhkov.easykin.auto.service.impl;

import java.util.Collection;
import java.util.Date;

import ru.rrozhkov.easykin.auto.service.IDetail;
import ru.rrozhkov.easykin.auto.service.IRepairService;
import ru.rrozhkov.easykin.fin.Money;
import ru.rrozhkov.easykin.util.DateUtil;

public class RepairService extends Service implements IRepairService {
	private Collection<IDetail> details;

	public RepairService(String name, Money money, Date date,
			Collection<IDetail> details) {
		super(name, money, date);
		this.details = details;
	}

	public Collection<IDetail> getDetails() {
		return details;
	}

	@Override
	public String toString() {
		return "\n " + getName()
				+ ", " + getPrice() + ", " + DateUtil.format(getDate())
				+ "\n details=" + details + "\n";
	}	
}