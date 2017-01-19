package ru.rrozhkov.easykin.gui.util;

import javax.swing.JTabbedPane;

import ru.rrozhkov.easykin.context.EasyKinContext;
import ru.rrozhkov.easykin.model.category.ICategory;

public class ContextUtil {
	public static ICategory getCategoryByTabIndex(EasyKinContext context, JTabbedPane tabs, int index){
		String categoryName = tabs.getTitleAt(index);
		for(ICategory category : context.categories()){
			if(categoryName.equals(category.getName()))
				return category;
		}
		return null;
	}
}