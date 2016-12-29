package ru.rrozhkov.easykin.model.task;

import java.util.Date;

import ru.rrozhkov.easykin.model.category.Category;

public interface ITask {
	public int getId();
	public String getName();
	public Date getCreateDate();
	public Date getPlanDate();
	public Priority getPriority();
	public Category getCategory();
	public Date getCloseDate();
	public Status getStatus();
}