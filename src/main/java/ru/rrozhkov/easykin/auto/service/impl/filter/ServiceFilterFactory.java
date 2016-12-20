package ru.rrozhkov.easykin.auto.service.impl.filter;

import java.util.Date;

import ru.rrozhkov.easykin.report.IFilter;

public class ServiceFilterFactory {
	public static IFilter createDateFilter(Date start, Date end){
		return new DateFilter(start,end);
	}
	public static IFilter createOnlyRepairFilter(){
		return new OnlyRepairFilter();
	}
	public static IFilter createNoFreeFilter(){
		return new NoFreeFilter();
	}
}
