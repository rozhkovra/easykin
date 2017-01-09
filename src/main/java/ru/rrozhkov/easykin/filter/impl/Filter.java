package ru.rrozhkov.easykin.filter.impl;

import ru.rrozhkov.easykin.filter.IFilter;

public abstract class Filter implements IFilter {
	protected Object obj;
	public void setObj(Object obj){
		this.obj = obj;
	}
}