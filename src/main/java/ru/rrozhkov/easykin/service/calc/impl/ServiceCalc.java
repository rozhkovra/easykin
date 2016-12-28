package ru.rrozhkov.easykin.service.calc.impl;

import java.util.Collection;
import java.util.Date;

import ru.rrozhkov.easykin.service.calc.CalculationType;
import ru.rrozhkov.easykin.service.calc.ICalculation;

public class ServiceCalc extends Calculation {
	private Date date;
	private Collection<ICalculation> beans;

	public ServiceCalc(Collection<ICalculation> beans) {
		this.beans = beans;
		this.date = new Date();
	}

	public Collection<ICalculation> getBeans() {
		return beans;
	}
	
	public String getName() {
		return "";
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