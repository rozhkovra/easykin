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
		super(false);
		this.name = name;
		this.beans = beans;
		this.date = new Date();
	}

	public Collection<ICalculation> calcs() {
		return beans;
	}
	
	public String getName() {
		return name;
	}

	public Date getDate() {
		return date;
	}
	
	public CalculationType getType() {
		return CalculationType.ALL;
	}

	@Override
	public boolean isPaid() {
		boolean isPaid = true;
		for(ICalculation calc : beans){
			if(!((Calculation)calc).isPaid())
				isPaid = false;
		}
		return isPaid;
	}	
}