package ru.rrozhkov.easykin.auto.service.impl;

import java.util.Collection;

import ru.rrozhkov.easykin.auto.ICar;
import ru.rrozhkov.easykin.auto.service.IService;
import ru.rrozhkov.easykin.auto.service.IServiceHistory;

public class ServiceHistory implements IServiceHistory {
	private ICar car;
	private Collection<IService> services;
	
	public ServiceHistory(ICar car, Collection<IService> services) {
		this.car = car;
		this.services = services;
	}

	public ICar getCar() {
		return car;
	}

	public Collection<IService> getServices() {
		return services;
	}

	@Override
	public String toString() {
		return "\ncar=" + car + "\nservices={" + services + "}\n";
	}	
}