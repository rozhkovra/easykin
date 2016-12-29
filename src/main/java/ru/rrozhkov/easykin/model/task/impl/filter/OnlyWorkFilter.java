package ru.rrozhkov.easykin.model.task.impl.filter;

import ru.rrozhkov.easykin.model.task.ITask;
import ru.rrozhkov.easykin.report.impl.Filter;

public class OnlyWorkFilter extends Filter {
	public boolean filter() {
		return ((ITask)obj).getCategory().isWork();
	}
}