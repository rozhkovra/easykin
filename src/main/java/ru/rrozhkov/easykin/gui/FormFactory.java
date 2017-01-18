package ru.rrozhkov.easykin.gui;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;

import ru.rrozhkov.easykin.data.impl.SingleCollectionDataProvider;
import ru.rrozhkov.easykin.data.impl.stat.AllDataProvider;
import ru.rrozhkov.easykin.gui.auto.service.ServiceForm;
import ru.rrozhkov.easykin.gui.service.ServicePanel;
import ru.rrozhkov.easykin.gui.task.TaskForm;
import ru.rrozhkov.easykin.model.auto.service.IService;
import ru.rrozhkov.easykin.model.category.ICategory;
import ru.rrozhkov.easykin.model.service.calc.impl.ServiceCalc;
import ru.rrozhkov.easykin.model.task.ITask;

public class FormFactory {
	private static Map<String, JPanel> panels = new HashMap<String, JPanel>();
	public static JPanel createServiceCalcForm(){
		return new ServicePanel(new ServiceCalc(
				((SingleCollectionDataProvider<ServiceCalc, String>)AllDataProvider.get(10)).getSingleData(),
				AllDataProvider.get(10).getData()));
	}
	public static JPanel createTaskForm(JFrame parent, Object obj){
		if(obj!=null && obj instanceof ITask)
			return new TaskForm(parent,(ITask)obj);
		return new TaskForm(parent);
	}
	public static JPanel createServiceForm(JFrame parent, Object obj){
		if(obj!=null && obj instanceof IService)
			return new ServiceForm(parent,(IService)obj);
		return new ServiceForm(parent);
	}
	
	public static JPanel getFormPanel(JFrame parent, ICategory category, Object obj) {
		if(category.getId()==1){
			return createTaskForm(parent,obj);
		}else if(category.getId()==2){
			return new JPanel();
		}else if(category.getId()==3){
			return new JPanel();
		}else if(category.getId()==4){
			return createServiceForm(parent,obj);
		}else if(category.getId()==5){
			return new JPanel();
		}else if(category.getId()==6){
			return new JPanel();
		}else if(category.getId()==7){
			return new JPanel();
		}else if(category.getId()==8){
			return createTaskForm(parent,obj);
		}else if(category.getId()==9){
			return createTaskForm(parent,obj);
		}else if(category.getId()==10){
			return createServiceCalcForm();
		}
		return new JPanel();
	}
}
