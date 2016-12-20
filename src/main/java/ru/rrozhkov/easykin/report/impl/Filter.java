package ru.rrozhkov.easykin.report.impl;

import ru.rrozhkov.easykin.report.IFilter;

public abstract class Filter implements IFilter {
	protected Object obj;
	public void setObj(Object obj){
		this.obj = obj;
	}
}