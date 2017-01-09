package ru.rrozhkov.easykin.model.task.impl.filter;

import ru.rrozhkov.easykin.filter.impl.Filter;
import ru.rrozhkov.easykin.model.task.ITask;

public class OnlyWorkFilter extends Filter {
	public boolean filter() {
		return ((ITask)obj).getCategory().isWork();
	}
}