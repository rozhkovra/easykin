package ru.rrozhkov.easykin.model.service.calc.history;

import java.util.Collection;

import ru.rrozhkov.easykin.model.service.calc.impl.ServiceCalc;

public class ServiceHistory {
	private Collection<ServiceCalc> calcs;

	public ServiceHistory(Collection<ServiceCalc> calcs) {
		this.calcs = calcs;
	}
	
	
}
