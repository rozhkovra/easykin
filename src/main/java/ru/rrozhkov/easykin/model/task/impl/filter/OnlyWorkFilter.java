package ru.rrozhkov.easykin.model.task.impl.filter;

import ru.rrozhkov.easykin.filter.IFilter;
import ru.rrozhkov.easykin.model.task.ITask;

public class OnlyWorkFilter implements IFilter {
	public boolean filter(Object obj) {
		return ((ITask)obj).getCategory().isWork();
	}
}