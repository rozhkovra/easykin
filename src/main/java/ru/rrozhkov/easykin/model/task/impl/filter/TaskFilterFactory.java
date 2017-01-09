package ru.rrozhkov.easykin.model.task.impl.filter;

import ru.rrozhkov.easykin.filter.IFilter;

public class TaskFilterFactory {
	public static IFilter createOnlyHomeFilter(){
		return new OnlyHomeFilter();
	}
	public static IFilter createOnlyWorkFilter(){
		return new OnlyWorkFilter();
	}
}
