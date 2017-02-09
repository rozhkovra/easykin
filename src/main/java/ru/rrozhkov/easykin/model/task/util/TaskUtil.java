package ru.rrozhkov.easykin.model.task.util;

import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.model.task.ITask;

public class TaskUtil {
	public static boolean withPayment(ITask task){
		return task.getName().contains("$");
	}
	
	public static Money extractAmount(ITask task){
		if(withPayment(task)){
			String text = task.getName();
			int index = text.indexOf('$');
			int lastIndex = text.lastIndexOf('$');
			String value = text.substring(index, lastIndex);
			return new Money(Double.valueOf(value));
		}
		return null;
	}
}
