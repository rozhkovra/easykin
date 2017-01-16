package ru.rrozhkov.easykin.model.task.impl.filter;

import ru.rrozhkov.easykin.filter.IFilter;
import ru.rrozhkov.easykin.model.task.ITask;

public class OnlyWorkFilter implements IFilter<ITask> {
	public boolean filter(ITask obj) {
		return obj.getCategory().isWork();
	}
}