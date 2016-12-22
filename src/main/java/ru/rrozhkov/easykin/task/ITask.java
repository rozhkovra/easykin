package ru.rrozhkov.easykin.task;

import java.util.Date;

public interface ITask {
	public String getName();
	public Date getCreateDate();
	public Date getPlanDate();
	public Priority getPriority();
	public int getCategory();
	public Date getCloseDate();
	public Status getStatus();
}