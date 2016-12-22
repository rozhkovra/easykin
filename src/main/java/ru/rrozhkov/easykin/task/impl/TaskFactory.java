package ru.rrozhkov.easykin.task.impl;

import java.util.Date;

import ru.rrozhkov.easykin.task.ITask;
import ru.rrozhkov.easykin.task.Priority;
import ru.rrozhkov.easykin.task.Status;

public class TaskFactory{

	public static ITask createTask(String name, int categoryId) {
		return new Task(name, new Date(), new Date(), Priority.SIMPLE, categoryId, null, Status.OPEN);
	}

	public static ITask createTask(String name, Date createDate, Date plannedDate,
			Priority priority, int categoryId, Date closeDate, Status status) {
		return new Task(name, createDate, plannedDate, priority, categoryId, closeDate, status);
	}
}