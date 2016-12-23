package ru.rrozhkov.easykin.task.impl;

import java.util.Date;

import ru.rrozhkov.easykin.task.ITask;

public class Task implements ITask, Comparable<ITask>{
	
	protected String name;
	protected Date createDate;
	protected Date planDate;
	protected int priority;
	protected int categoryId;
	protected Date closeDate;
	protected int status;
	private int id;
	
	public Task(int id, String name, Date createDate, Date plannedDate,
			int priority, int categoryId, Date closeDate, int status) {
		super();
		this.id = id;
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

	public int getPriority() {
		return priority;
	}

	public int getCategory() {
		return categoryId;
	}

	public Date getCloseDate() {
		return closeDate;
	}

	public int getStatus() {
		return status;
	}

	public int getId() {
		return id;
	}

	public int compareTo(ITask o) {
		int val = 0;
		if(val==0)
			val = (int) (getPlanDate().getTime()-o.getPlanDate().getTime());
		if(val==0)
			val = getName().compareTo(o.getName());
		return val;
	}
}