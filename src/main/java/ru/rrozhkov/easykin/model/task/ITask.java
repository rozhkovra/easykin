package ru.rrozhkov.easykin.model.task;

import java.util.Collection;
import java.util.Date;

import ru.rrozhkov.easykin.model.category.Category;
import ru.rrozhkov.easykin.model.category.ICategory;

public interface ITask {
	public int getId();
	public String getName();
	public Date getCreateDate();
	public Date getPlanDate();
	public Priority getPriority();
	public ICategory getCategory();
	public Date getCloseDate();
	public Status getStatus();
	public Collection<IComment> comments();
}