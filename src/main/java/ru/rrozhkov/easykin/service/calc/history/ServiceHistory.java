package ru.rrozhkov.easykin.service.calc.history;

import java.util.Collection;

import ru.rrozhkov.easykin.service.calc.impl.ServiceCalc;

public class ServiceHistory {
	private Collection<ServiceCalc> calcs;

	public ServiceHistory(Collection<ServiceCalc> calcs) {
		this.calcs = calcs;
	}
	
	
}
