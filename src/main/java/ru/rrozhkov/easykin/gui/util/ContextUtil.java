package ru.rrozhkov.easykin.gui.util;

import javax.swing.JTabbedPane;

import ru.rrozhkov.easykin.context.MasterDataContext;
import ru.rrozhkov.easykin.model.category.ICategory;
import ru.rrozhkov.lib.util.DateUtil;

public class ContextUtil {
	public static ICategory getCurrentCategory(MasterDataContext context, JTabbedPane tabs){
		int index = tabs.getSelectedIndex();
		String categoryName = tabs.getTitleAt(index);
		for(ICategory category : context.categories()){
			if(categoryName.equals(category.getName()))
				return category;
		}
		return null;
	}
	public static String title(){
		return "EasyKin, " + DateUtil.todayWeek();
	}
}