package ru.rrozhkov.easykin.service.calc.impl;

import java.util.Collection;

import ru.rrozhkov.easykin.service.calc.ICalculation;

public class ServiceCalc extends Calculation {
	private Collection<ICalculation> beans;

	public ServiceCalc(Collection<ICalculation> beans) {
		this.beans = beans;
	}

	public Collection<ICalculation> getBeans() {
		return beans;
	}
	
	public String getName() {
		return "";
	}
}