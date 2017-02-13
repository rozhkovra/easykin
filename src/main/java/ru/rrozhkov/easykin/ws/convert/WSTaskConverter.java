package ru.rrozhkov.easykin.ws.convert;

import ru.rrozhkov.easykin.model.task.ITask;
import ru.rrozhkov.easykin.ws.bean.TaskBean;
import ru.rrozhkov.lib.convert.IConverter;

public class WSTaskConverter implements IConverter<ITask, TaskBean> {

	public TaskBean convert(ITask task) {
		TaskBean bean = new TaskBean();
		bean.setId(task.getId());
		bean.setName(task.getName());
		bean.setCreateDate(task.getCreateDate());
		bean.setPlanDate(task.getPlanDate());
		bean.setCategory(task.getCategory());
		bean.setPriority(task.getPriority());
		bean.setCloseDate(task.getCloseDate());
		bean.setStatus(task.getStatus());
		return bean;
	}
	
}
