package ru.rrozhkov.easykin.task.impl;

import java.util.Date;

import ru.rrozhkov.easykin.category.Category;
import ru.rrozhkov.easykin.task.ITask;
import ru.rrozhkov.easykin.task.Priority;
import ru.rrozhkov.easykin.task.Status;

public class Task implements ITask, Comparable<ITask>{
	
	protected String name;
	protected Date createDate;
	protected Date planDate;
	protected Priority priority;
	protected int categoryId;
	protected Date closeDate;
	protected Status status;
	
	public Task(String name, Date createDate, Date plannedDate,
			Priority priority, int categoryId, Date closeDate, Status status) {
		super();
		this.name = name;
		this.createDate = createDate;
		this.planDate = plannedDate;
		this.priority = priority;
		this.categoryId = categoryId;
		this.closeDate = closeDate;
		this.status = status;
	}

	
	public String getName() {
		return name;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public Date getPlanDate() {
		return planDate;
	}

	public Priority getPriority() {
		return priority;
	}

	public int getCategory() {
		return categoryId;
	}

	public Date getCloseDate() {
		return closeDate;
	}

	public Status getStatus() {
		return status;
	}

	public int compareTo(ITask o) {
		int val = 0;
		if(val==0)
			val = getStatus().compareTo(o.getStatus());
		if(val==0)
			val = (int) (getPlanDate().getTime()-o.getPlanDate().getTime());
		if(val==0)
			val = getPriority().compareTo(o.getPriority());
		if(val==0)
			val = getName().compareTo(o.getName());
		return val;
	}
}