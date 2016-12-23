package ru.rrozhkov.easykin.task;

import java.util.Date;

public interface ITask {
	public int getId();
	public String getName();
	public Date getCreateDate();
	public Date getPlanDate();
	public int getPriority();
	public int getCategory();
	public Date getCloseDate();
	public int getStatus();
}