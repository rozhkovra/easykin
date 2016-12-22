package ru.rrozhkov.easykin.task.impl.filter;

import ru.rrozhkov.easykin.category.Category;
import ru.rrozhkov.easykin.report.impl.Filter;
import ru.rrozhkov.easykin.task.ITask;

public class OnlyHomeFilter extends Filter {
	public boolean filter() {
		return Category.HOME.equals(((ITask)obj).getCategory());
	}
}