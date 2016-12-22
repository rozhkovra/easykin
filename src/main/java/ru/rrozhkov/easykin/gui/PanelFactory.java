package ru.rrozhkov.easykin.gui;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JPanel;

import ru.rrozhkov.easykin.auto.ICar;
import ru.rrozhkov.easykin.auto.service.IService;
import ru.rrozhkov.easykin.category.ICategory;
import ru.rrozhkov.easykin.data.impl.SingleCollectionDataProvider;
import ru.rrozhkov.easykin.data.impl.stat.AllDataProvider;
import ru.rrozhkov.easykin.db.CategoryHandler;
import ru.rrozhkov.easykin.gui.auto.AutoPanel;
import ru.rrozhkov.easykin.gui.auto.CarPanel;
import ru.rrozhkov.easykin.gui.auto.service.ServiceForm;
import ru.rrozhkov.easykin.gui.service.ServicePanel;
import ru.rrozhkov.easykin.gui.style.impl.custom.FamilyStyle;
import ru.rrozhkov.easykin.gui.style.impl.custom.PaymentStyle;
import ru.rrozhkov.easykin.gui.style.impl.custom.ServiceStyle;
import ru.rrozhkov.easykin.gui.style.impl.custom.TaskStyle;
import ru.rrozhkov.easykin.service.calc.ICalculation;
import ru.rrozhkov.easykin.service.calc.impl.ServiceCalc;

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
	private static JPanel createHomePanel() {
		return new TablePanel(AllDataProvider.get(1).getData(), new TaskStyle());
	}
	private static JPanel createFinPanel() {
		return new JPanel();
	}
	private static JPanel createWorkPanel() {
		return new TablePanel(AllDataProvider.get(8).getData(), new TaskStyle());
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
		return new ServiceForm(AllDataProvider.get(4));
	}
	public static JPanel createTaskPanel(){
		return new TablePanel(AllDataProvider.get(9).getData(), new TaskStyle());
	}
	public static JPanel createServicePanel(){
		return new ServicePanel((ServiceCalc)((SingleCollectionDataProvider<ICalculation, ICalculation>)AllDataProvider.get(10)).getSingleData());
	}
	public static Map<String, JPanel> createPanels(){
        Collection<ICategory> categories = CategoryHandler.getCategories();        
		Map<String, JPanel> panels = new HashMap<String, JPanel>();
		for(ICategory category : categories){
			if(category.getId()==1){
				panels.put(category.getName(), createHomePanel());
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
		        panels.put(category.getName(), createWorkPanel());
			}else if(category.getId()==9){
		        panels.put(category.getName(), createTaskPanel());
			}else if(category.getId()==10){
		        panels.put(category.getName(), createServicePanel());
			}
		}
        return panels;
	}
}