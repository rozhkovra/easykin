package ru.rrozhkov.easykin.gui.style.impl.custom;

import ru.rrozhkov.easykin.gui.style.IDataConverter;
import ru.rrozhkov.easykin.gui.style.IStyle;
import ru.rrozhkov.easykin.gui.style.ITableStyle;
import ru.rrozhkov.easykin.model.task.ITask;

public class TaskStyle implements IStyle<ITask> {

	public ITableStyle<ITask> tableStyle() {
		return new TaskTableStyle();
	}

	public IDataConverter<ITask> dataConverter() {
		return new TaskConverter();
	}
}