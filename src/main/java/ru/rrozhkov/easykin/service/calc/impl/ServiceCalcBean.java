package ru.rrozhkov.easykin.service.calc.impl;

import java.util.ArrayList;
import java.util.Collection;

import ru.rrozhkov.easykin.service.calc.CalcBean;

public class ServiceCalcBean extends CalcBean {
	private Collection<CalcBean> beans = new ArrayList<CalcBean>();

	public ServiceCalcBean(Collection<CalcBean> beans) {
		this.beans = beans;
	}

	public Collection<CalcBean> getBeans() {
		return beans;
	}
	
	public String getName() {
		return "";
	}
}