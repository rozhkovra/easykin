package ru.rrozhkov.easykin.model.task.impl.filter;

import ru.rrozhkov.easykin.filter.IFilter;
import ru.rrozhkov.easykin.model.task.Status;

public class TaskFilterFactory {
	public static IFilter createOnlyHomeFilter(){
		return new OnlyHomeFilter();
	}
	public static IFilter createOnlyWorkFilter(){
		return new OnlyWorkFilter();
	}
	public static IFilter createStatusFilter(Status status){
		return new StatusFilter(status);
	}
}
