package ru.rrozhkov.easykin.context;

import java.sql.SQLException;
import java.util.Collection;

import ru.rrozhkov.easykin.db.CategoryHandler;
import ru.rrozhkov.easykin.db.KinPersonHandler;
import ru.rrozhkov.easykin.db.PersonHandler;
import ru.rrozhkov.easykin.db.TaskHandler;
import ru.rrozhkov.easykin.model.category.ICategory;
import ru.rrozhkov.easykin.model.family.IKinPerson;
import ru.rrozhkov.easykin.model.person.IPerson;
import ru.rrozhkov.easykin.model.task.ITask;
import ru.rrozhkov.easykin.model.task.Priority;

public class EasyKinContext {
	private Collection<ICategory> categories;
	private Collection<ITask> tasks;
	private Collection<IPerson> persons;
	private Collection<IKinPerson> kinPersons;

	public EasyKinContext() {
	}
	
	public void init(){
		try{
			this.categories = CategoryHandler.select();
			this.tasks = TaskHandler.select();
			this.persons = PersonHandler.select();
			this.kinPersons = KinPersonHandler.select();
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

	public Collection<IPerson> persons() {
		return persons;
	}

	public Collection<IKinPerson> kinPersons() {
		return kinPersons;
	}
}