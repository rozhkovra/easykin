package ru.rrozhkov.easykin.model.task;

import ru.rrozhkov.easykin.model.convert.IConverter;

public interface ITaskConverter<T> extends IConverter<T, ITask> {
	ITask convert(T entry);
}