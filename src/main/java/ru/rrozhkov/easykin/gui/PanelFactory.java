package ru.rrozhkov.easykin.gui;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;

import ru.rrozhkov.easykin.data.impl.SingleCollectionDataProvider;
import ru.rrozhkov.easykin.data.impl.stat.AllDataProvider;
import ru.rrozhkov.easykin.db.CategoryHandler;
import ru.rrozhkov.easykin.db.TaskHandler;
import ru.rrozhkov.easykin.gui.auto.AutoPanel;
import ru.rrozhkov.easykin.gui.auto.CarPanel;
import ru.rrozhkov.easykin.gui.service.ServicePanel;
import ru.rrozhkov.easykin.gui.style.impl.custom.FamilyStyle;
import ru.rrozhkov.easykin.gui.style.impl.custom.PaymentStyle;
import ru.rrozhkov.easykin.gui.style.impl.custom.ServiceCalcStyle;
import ru.rrozhkov.easykin.gui.style.impl.custom.ServiceStyle;
import ru.rrozhkov.easykin.gui.style.impl.custom.TaskStyle;
import ru.rrozhkov.easykin.gui.task.TaskForm;
import ru.rrozhkov.easykin.model.auto.ICar;
import ru.rrozhkov.easykin.model.auto.service.IService;
import ru.rrozhkov.easykin.model.category.ICategory;
import ru.rrozhkov.easykin.model.service.calc.impl.ServiceCalc;
import ru.rrozhkov.easykin.model.task.ITask;
import ru.rrozhkov.easykin.model.task.Status;
import ru.rrozhkov.easykin.model.task.impl.filter.TaskFilterFactory;
import ru.rrozhkov.easykin.util.FilterUtil;

public class PanelFactory {
	private static JPanel createFamilyPanel(){		
		return new TablePanel(AllDataProvider.get(3).getData(), new FamilyStyle());
	}
	private static JPanel createChildPanel(){
		return new TablePanel(AllDataProvider.get(2).getData(), new FamilyStyle());
	}
	public static JPanel createAutoServicePanel(){
		return new TablePanel(AllDataProvider.get(4).getData(), new ServiceStyle());
	}
	private static JPanel createHomePanel(Collection<ITask> tasks) {
		return new TablePanel(tasks, new TaskStyle());
	}
	private static JPanel createFinPanel() {
		return new JPanel();
	}
	private static JPanel createWorkPanel(Collection<ITask> tasks) {
		return new TablePanel(tasks, new TaskStyle());
	}
	private static JPanel createPaymentPanel() {
		return new TablePanel(AllDataProvider.get(6).getData(), new PaymentStyle());
	}
	private static JPanel createDocPanel() {
		return new JPanel();
	}
	public static JPanel createCarPanel() {
		return new CarPanel(((SingleCollectionDataProvider<IService, ICar>)AllDataProvider.get(4)).getSingleData());
	}
	private static JPanel createAutoPanel() {
		return new AutoPanel();
	}
	public static JPanel createServiceForm(){
		return new ServicePanel(new ServiceCalc(
				((SingleCollectionDataProvider<ServiceCalc, String>)AllDataProvider.get(10)).getSingleData(),
				AllDataProvider.get(10).getData()));
	}
	public static JPanel createTaskForm(JFrame parent){
		return new TaskForm(parent);
	}
	
	public static JPanel createTaskPanel(Collection<ITask> tasks){
		return new TablePanel(tasks, new TaskStyle());
	}
	public static JPanel createServicePanel(){
		return new TablePanel(AllDataProvider.get(10).getData(), new ServiceCalcStyle());
	}
	public static Map<String, JPanel> createPanels(){
        Collection<ICategory> categories = CategoryHandler.getCategories();
        Collection<ITask> tasks = FilterUtil.filter(TaskHandler.getTasks(),TaskFilterFactory.createStatusFilter(Status.OPEN));
		Map<String, JPanel> panels = new HashMap<String, JPanel>();
		for(ICategory category : categories){
			if(category.getId()==1){
				panels.put(category.getName(), createHomePanel(FilterUtil.filter(tasks, TaskFilterFactory.createOnlyHomeFilter())));
			}else if(category.getId()==2){
				panels.put(category.getName(), createChildPanel());
			}else if(category.getId()==3){
		        panels.put(category.getName(), createFamilyPanel());
			}else if(category.getId()==4){
		        panels.put(category.getName(), createAutoPanel());
			}else if(category.getId()==5){
		        panels.put(category.getName(), createFinPanel());
			}else if(category.getId()==6){
		        panels.put(category.getName(), createPaymentPanel());
			}else if(category.getId()==7){
		        panels.put(category.getName(), createDocPanel());
			}else if(category.getId()==8){
		        panels.put(category.getName(), createWorkPanel(FilterUtil.filter(tasks, TaskFilterFactory.createOnlyWorkFilter())));
			}else if(category.getId()==9){
		        panels.put(category.getName(), createTaskPanel(tasks));
			}else if(category.getId()==10){
		        panels.put(category.getName(), createServicePanel());
			}
		}
        return panels;
	}
}