package ru.rrozhkov.easykin.gui;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JPanel;

import ru.rrozhkov.easykin.context.EasyKinContext;
import ru.rrozhkov.easykin.data.impl.SingleCollectionDataProvider;
import ru.rrozhkov.easykin.data.impl.stat.AllDataProvider;
import ru.rrozhkov.easykin.gui.auto.AutoPanel;
import ru.rrozhkov.easykin.gui.auto.CarForm;
import ru.rrozhkov.easykin.gui.style.impl.custom.FamilyStyle;
import ru.rrozhkov.easykin.gui.style.impl.custom.PaymentStyle;
import ru.rrozhkov.easykin.gui.style.impl.custom.ServiceCalcStyle;
import ru.rrozhkov.easykin.gui.style.impl.custom.ServiceStyle;
import ru.rrozhkov.easykin.gui.style.impl.custom.TaskStyle;
import ru.rrozhkov.easykin.model.auto.ICar;
import ru.rrozhkov.easykin.model.auto.service.IService;
import ru.rrozhkov.easykin.model.category.ICategory;
import ru.rrozhkov.easykin.model.task.ITask;
import ru.rrozhkov.easykin.model.task.impl.filter.TaskFilterFactory;
import ru.rrozhkov.easykin.util.FilterUtil;

public class PanelFactory {
	private static JPanel createFamilyPanel(EasyKinWindow parent){		
		return new TablePanel(parent, new Table(AllDataProvider.get(3).getData(), new FamilyStyle()));
	}
	private static JPanel createChildPanel(EasyKinWindow parent){
		return new TablePanel(parent, new Table(AllDataProvider.get(2).getData(), new FamilyStyle()));
	}
	public static JPanel createAutoServicePanel(EasyKinWindow parent){
		return new TablePanel(parent, new Table(AllDataProvider.get(4).getData(), new ServiceStyle()));
	}
	private static JPanel createHomePanel(EasyKinWindow parent, Collection<ITask> tasks) {
		return new TablePanel(parent, new Table(tasks, new TaskStyle()));
	}
	private static JPanel createFinPanel() {
		return new JPanel();
	}
	private static JPanel createWorkPanel(EasyKinWindow parent, Collection<ITask> tasks) {
		return new TablePanel(parent, new Table(tasks, new TaskStyle()));
	}
	private static JPanel createPaymentPanel(EasyKinWindow parent) {
		return new TablePanel(parent, new Table(AllDataProvider.get(6).getData(), new PaymentStyle()));
	}
	private static JPanel createDocPanel() {
		return new JPanel();
	}
	public static JPanel createCarPanel() {
		return new CarForm(((SingleCollectionDataProvider<IService, ICar>)AllDataProvider.get(4)).getSingleData());
	}
	private static JPanel createAutoPanel(EasyKinWindow parent) {
		return new AutoPanel(parent);
	}
	
	public static JPanel createTaskPanel(EasyKinWindow parent, Collection<ITask> tasks){
		return new TablePanel(parent, new Table(tasks, new TaskStyle()));
	}
	public static JPanel createServicePanel(EasyKinWindow parent){
		return new TablePanel(parent, new Table(AllDataProvider.get(10).getData(), new ServiceCalcStyle()));
	}
	public static Map<String, JPanel> createPanels(EasyKinWindow parent, EasyKinContext context){
		Map<String, JPanel> panels = new HashMap<String, JPanel>();
		for(ICategory category : context.categories()){
			JPanel panel = null;
			if(category.getId()==1){
				 panel = createHomePanel(parent, FilterUtil.filter(context.tasks(), TaskFilterFactory.createOnlyHomeFilter()));
			}else if(category.getId()==2){
				panel = createChildPanel(parent);
			}else if(category.getId()==3){
				panel = createFamilyPanel(parent);
			}else if(category.getId()==4){
				panel = createAutoPanel(parent);
			}else if(category.getId()==5){
				panel = createFinPanel();
			}else if(category.getId()==6){
				panel = createPaymentPanel(parent);
			}else if(category.getId()==7){
				panel = createDocPanel();
			}else if(category.getId()==8){
				panel = createWorkPanel(parent, FilterUtil.filter(context.tasks(), TaskFilterFactory.createOnlyWorkFilter()));
			}else if(category.getId()==9){
				panel = createTaskPanel(parent, context.tasks());
			}else if(category.getId()==10){
				panel = createServicePanel(parent);
			}
			panels.put(category.getName(),panel);
		}
        return panels;
	}
}