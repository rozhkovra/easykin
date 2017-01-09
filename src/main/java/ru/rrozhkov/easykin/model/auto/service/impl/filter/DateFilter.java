package ru.rrozhkov.easykin.model.auto.service.impl.filter;

import java.util.Date;

import ru.rrozhkov.easykin.filter.impl.Filter;
import ru.rrozhkov.easykin.model.auto.service.IService;

public class DateFilter extends Filter{
	private Date start;
	private Date end;
	public DateFilter(Date start, Date end) {
		this.start = start;
		this.end = end;
	}
	
	public boolean filter(){
		return ((IService)obj).getDate().getTime()>=start.getTime() 
				&& ((IService)obj).getDate().getTime()<end.getTime();
	}
}