package ru.rrozhkov.easykin.model.task.impl;

import java.util.Date;

import ru.rrozhkov.easykin.model.category.Category;
import ru.rrozhkov.easykin.model.task.ITask;
import ru.rrozhkov.easykin.model.task.Priority;
import ru.rrozhkov.easykin.model.task.Status;

public class TaskFactory{
	public static ITask createTask(int id, String name, Date createDate, Date plannedDate,
			int priority, int categoryId, String categoryName, Date closeDate, int status) {
		return new Task(id, name, createDate, plannedDate, Priority.priority(priority)
				, new Category(categoryId,categoryName), closeDate, Status.status(status));
	}
	
	public static ITask newTask(){
		return TaskFactory.createTask(-1, "", new Date(), new Date(), Priority.priority(Priority.SIMPLE)
				, 1, "", null, Status.status(Status.OPEN));
	}
}