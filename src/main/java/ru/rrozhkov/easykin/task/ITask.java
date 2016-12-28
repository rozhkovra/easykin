package ru.rrozhkov.easykin.task;

import java.util.Date;

import ru.rrozhkov.easykin.category.Category;

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