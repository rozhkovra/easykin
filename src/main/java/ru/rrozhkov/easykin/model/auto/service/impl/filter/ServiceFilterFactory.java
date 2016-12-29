package ru.rrozhkov.easykin.model.auto.service.impl.filter;

import java.util.Date;

import ru.rrozhkov.easykin.report.IFilter;

public class ServiceFilterFactory {
	public static IFilter createDateFilter(Date start, Date end){
		return new DateFilter(start,end);
	}
	public static IFilter createNoFreeFilter(){
		return new NoFreeFilter();
	}
}