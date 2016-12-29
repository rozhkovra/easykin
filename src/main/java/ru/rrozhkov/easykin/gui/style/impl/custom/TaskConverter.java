package ru.rrozhkov.easykin.gui.style.impl.custom;

import java.util.LinkedList;
import java.util.List;

import ru.rrozhkov.easykin.gui.style.impl.DataConverter;
import ru.rrozhkov.easykin.model.task.ITask;
import ru.rrozhkov.easykin.util.DateUtil;

public class TaskConverter extends DataConverter<ITask>{
	public String[] entryToStringArr(int i, ITask t){
		List<String> list = new LinkedList<String>();
		list.add(String.valueOf(i));
		list.add(t.getName());
		list.add(DateUtil.format(t.getPlanDate()));
		list.add(t.getPriority().toString());
		list.add(t.getCategory().getName());
		list.add(t.getStatus().toString());
		return list.toArray(new String[list.size()]);
	}
}