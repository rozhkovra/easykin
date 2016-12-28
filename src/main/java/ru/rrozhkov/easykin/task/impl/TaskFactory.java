package ru.rrozhkov.easykin.task.impl;

import java.util.Date;

import ru.rrozhkov.easykin.category.Category;
import ru.rrozhkov.easykin.task.ITask;
import ru.rrozhkov.easykin.task.Priority;
import ru.rrozhkov.easykin.task.Status;

public class TaskFactory{
	public static ITask createTask(int id, String name, Date createDate, Date plannedDate,
			int priority, int categoryId, String categoryName, Date closeDate, int status) {
		return new Task(id, name, createDate, plannedDate, Priority.priority(priority)
				, new Category(categoryId,categoryName), closeDate, Status.status(status));
	}
}