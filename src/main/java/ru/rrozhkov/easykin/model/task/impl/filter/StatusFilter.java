package ru.rrozhkov.easykin.model.task.impl.filter;

import ru.rrozhkov.easykin.filter.impl.Filter;
import ru.rrozhkov.easykin.model.task.ITask;
import ru.rrozhkov.easykin.model.task.Status;

public class StatusFilter extends Filter {
	private Status status;
	
	public StatusFilter(Status status) {
		this.status = status;
	}

	public boolean filter() {
		return status.equals(((ITask)obj).getStatus());
	}
}