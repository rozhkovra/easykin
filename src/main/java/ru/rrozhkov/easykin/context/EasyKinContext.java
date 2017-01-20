package ru.rrozhkov.easykin.context;

import java.sql.SQLException;
import java.util.Collection;

import ru.rrozhkov.easykin.db.CategoryHandler;
import ru.rrozhkov.easykin.db.TaskHandler;
import ru.rrozhkov.easykin.model.category.ICategory;
import ru.rrozhkov.easykin.model.task.ITask;

public class EasyKinContext {
	private Collection<ICategory> categories;
	private Collection<ITask> tasks;

	public EasyKinContext() {
	}
	
	public void init(){
		try{
			this.categories = CategoryHandler.selectCategories();
			this.tasks = TaskHandler.selectTasks();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	public Collection<ICategory> categories() {
		return categories;
	}

	public Collection<ITask> tasks() {
		return tasks;
	}
}