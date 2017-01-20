package ru.rrozhkov.easykin.context;

import java.sql.SQLException;
import java.util.Collection;

import ru.rrozhkov.easykin.db.CategoryHandler;
import ru.rrozhkov.easykin.db.TaskHandler;
import ru.rrozhkov.easykin.model.category.ICategory;
import ru.rrozhkov.easykin.model.task.ITask;
import ru.rrozhkov.easykin.model.task.Priority;

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
	
	public Priority[] priorities(){
		return new Priority[]{
			Priority.IMPOTANT_FAST,
			Priority.IMPOTANT_NOFAST,
			Priority.SIMPLE
			};
	}
}