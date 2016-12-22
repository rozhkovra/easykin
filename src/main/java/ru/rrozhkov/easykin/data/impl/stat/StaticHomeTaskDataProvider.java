package ru.rrozhkov.easykin.data.impl.stat;

import static ru.rrozhkov.easykin.task.impl.filter.TaskFilterFactory.createOnlyHomeFilter;

import java.util.Collection;

import ru.rrozhkov.easykin.task.ITask;
import ru.rrozhkov.easykin.util.FilterUtil;


public class StaticHomeTaskDataProvider extends StaticTaskDataProvider{
	@Override
	public Collection<ITask> getData() {
		return FilterUtil.filter(super.getData(),createOnlyHomeFilter());
	}	
}