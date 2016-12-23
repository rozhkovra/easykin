package ru.rrozhkov.easykin.task.impl;

import java.util.Date;

import ru.rrozhkov.easykin.task.ITask;

public class TaskFactory{
	public static ITask createTask(int id, String name, Date createDate, Date plannedDate,
			int priority, int categoryId, Date closeDate, int status) {
		return new Task(id, name, createDate, plannedDate, priority, categoryId, closeDate, status);
	}
}