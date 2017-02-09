package ru.rrozhkov.easykin.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

import ru.rrozhkov.easykin.context.EasyKinContext;
import ru.rrozhkov.easykin.gui.auto.service.AutoServiceForm;
import ru.rrozhkov.easykin.gui.service.ServiceCalcForm;
import ru.rrozhkov.easykin.gui.task.TaskEditor;
import ru.rrozhkov.easykin.gui.task.TaskForm;
import ru.rrozhkov.easykin.model.auto.service.IService;
import ru.rrozhkov.easykin.model.category.ICategory;
import ru.rrozhkov.easykin.model.service.calc.impl.ServiceCalc;
import ru.rrozhkov.easykin.model.task.ITask;

public class FormFactory {
	public static JPanel createServiceCalcForm(JFrame parent, Object obj){
		if(obj!=null && obj instanceof ServiceCalc)
			return new ServiceCalcForm((ServiceCalc)obj);
		return new JPanel();
	}
	public static JPanel createTaskForm(EasyKinContext context,JFrame parent, Object obj){
		if(obj!=null && obj instanceof ITask)
			return new TaskForm(context, parent,(ITask)obj);
		return new TaskForm(context, parent);
	}
	public static JPanel createTaskEditor(EasyKinContext context,JFrame parent, Object obj){
		if(obj!=null && obj instanceof ITask)
			return new TaskEditor(context, (EasyKinWindow)parent,(ITask)obj);
		return new TaskEditor(context, (EasyKinWindow)parent);
	}
	public static JPanel createServiceForm(JFrame parent, Object obj){
		if(obj!=null && obj instanceof IService)
			return new AutoServiceForm(parent,(IService)obj);
		return new AutoServiceForm(parent);
	}
	
	public static JPanel getFormPanel(EasyKinContext context, JFrame parent, ICategory category, Object obj) {
		if(category.getId()==1){
			return createTaskEditor(context, parent,obj);
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
			return createTaskForm(context, parent,obj);
		}else if(category.getId()==9){
			return createTaskForm(context, parent,obj);
		}else if(category.getId()==10){
			return createServiceCalcForm(parent,obj);
		}
		return new JPanel();
	}
}
