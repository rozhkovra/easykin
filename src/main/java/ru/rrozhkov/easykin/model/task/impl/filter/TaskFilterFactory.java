package ru.rrozhkov.easykin.model.task.impl.filter;

import ru.rrozhkov.easykin.model.task.ITask;
import ru.rrozhkov.easykin.model.task.Status;
import ru.rrozhkov.lib.filter.IFilter;

public class TaskFilterFactory {
	public static IFilter<ITask> createOnlyHomeFilter(){
		return new OnlyHomeFilter();
	}
	public static IFilter<ITask> createOnlyWorkFilter(){
		return new OnlyWorkFilter();
	}
	public static IFilter<ITask> createStatusFilter(Status status){
		return new StatusFilter(status);
	}
}
