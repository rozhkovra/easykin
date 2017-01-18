package ru.rrozhkov.easykin.context;

import java.util.Collection;

import ru.rrozhkov.easykin.db.CategoryHandler;
import ru.rrozhkov.easykin.db.TaskHandler;
import ru.rrozhkov.easykin.model.category.ICategory;
import ru.rrozhkov.easykin.model.task.ITask;
import ru.rrozhkov.easykin.model.task.Status;
import ru.rrozhkov.easykin.model.task.impl.filter.TaskFilterFactory;
import ru.rrozhkov.easykin.util.FilterUtil;

public class EasyKinContext {
	private Collection<ICategory> categories;
	private Collection<ITask> tasks;

	public EasyKinContext() {
		super();
	}
	
	public EasyKinContext init(){
		this.categories = CategoryHandler.selectCategories();
		this.tasks = FilterUtil.filter(TaskHandler.selectTasks(),TaskFilterFactory.createStatusFilter(Status.OPEN));
		return this;
	}

	public Collection<ICategory> getCategories() {
		return categories;
	}

	public Collection<ITask> getTasks() {
		return tasks;
	}
}