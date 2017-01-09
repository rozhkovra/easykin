package ru.rrozhkov.easykin.model.service.calc.impl;

import java.util.Collection;
import java.util.Date;

import ru.rrozhkov.easykin.model.service.calc.CalculationType;
import ru.rrozhkov.easykin.model.service.calc.ICalculation;

public class ServiceCalc extends Calculation {
	private Date date;
	private String name;
	private Collection<ICalculation> beans;

	public ServiceCalc(String name, Collection<ICalculation> beans) {
		this.name = name;
		this.beans = beans;
		this.date = new Date();
	}

	public Collection<ICalculation> getBeans() {
		return beans;
	}
	
	public String getName() {
		return name;
	}

	public Date getDate() {
		return date;
	}
	
	public ICalculation getCalcByType(CalculationType type){
		for(ICalculation calc : beans){
			if(type.equals(calc.getType()))
				return calc;
		}
		return null;
	}

	public CalculationType getType() {
		return CalculationType.ALL;
	}
}