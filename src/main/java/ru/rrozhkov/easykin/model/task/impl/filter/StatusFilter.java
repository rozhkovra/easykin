package ru.rrozhkov.easykin.model.task.impl.filter;

import ru.rrozhkov.easykin.filter.IFilter;
import ru.rrozhkov.easykin.model.task.ITask;
import ru.rrozhkov.easykin.model.task.Status;

public class StatusFilter implements IFilter<ITask> {
	private Status status;
	
	public StatusFilter(Status status) {
		this.status = status;
	}

	public boolean filter(ITask obj) {
		return status.equals(obj.getStatus());
	}
}