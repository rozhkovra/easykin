package ru.rrozhkov.easykin.task.impl.filter;

import ru.rrozhkov.easykin.report.impl.Filter;
import ru.rrozhkov.easykin.task.ITask;

public class OnlyWorkFilter extends Filter {
	public boolean filter() {
		return ((ITask)obj).getCategory().isWork();
	}
}