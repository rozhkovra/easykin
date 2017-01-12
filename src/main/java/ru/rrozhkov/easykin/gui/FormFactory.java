package ru.rrozhkov.easykin.gui;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;

import ru.rrozhkov.easykin.data.impl.SingleCollectionDataProvider;
import ru.rrozhkov.easykin.data.impl.stat.AllDataProvider;
import ru.rrozhkov.easykin.db.CategoryHandler;
import ru.rrozhkov.easykin.gui.auto.service.ServiceForm;
import ru.rrozhkov.easykin.gui.service.ServicePanel;
import ru.rrozhkov.easykin.gui.task.TaskForm;
import ru.rrozhkov.easykin.model.category.ICategory;
import ru.rrozhkov.easykin.model.service.calc.impl.ServiceCalc;

public class FormFactory {
	public static JPanel createServiceCalcForm(){
		return new ServicePanel(new ServiceCalc(
				((SingleCollectionDataProvider<ServiceCalc, String>)AllDataProvider.get(10)).getSingleData(),
				AllDataProvider.get(10).getData(), false));
	}
	public static JPanel createTaskForm(JFrame parent){
		return new TaskForm(parent);
	}
	public static JPanel createServiceForm(JFrame parent){
		return new ServiceForm(parent);
	}
	
	public static Map<String, JPanel> createPanels(JFrame parent){
        Collection<ICategory> categories = CategoryHandler.getCategories();
		Map<String, JPanel> panels = new HashMap<String, JPanel>();
		for(ICategory category : categories){
			if(category.getId()==1){
				panels.put(category.getName(), createTaskForm(parent));
			}else if(category.getId()==2){
				panels.put(category.getName(), new JPanel());
			}else if(category.getId()==3){
		        panels.put(category.getName(), new JPanel());
			}else if(category.getId()==4){
		        panels.put(category.getName(), createServiceForm(parent));
			}else if(category.getId()==5){
		        panels.put(category.getName(), new JPanel());
			}else if(category.getId()==6){
		        panels.put(category.getName(), new JPanel());
			}else if(category.getId()==7){
		        panels.put(category.getName(), new JPanel());
			}else if(category.getId()==8){
		        panels.put(category.getName(), createTaskForm(parent));
			}else if(category.getId()==9){
		        panels.put(category.getName(), createTaskForm(parent));
			}else if(category.getId()==10){
		        panels.put(category.getName(), createServiceCalcForm());
			}
		}
        return panels;
	}
}
