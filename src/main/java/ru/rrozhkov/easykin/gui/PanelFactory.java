package ru.rrozhkov.easykin.gui;

import static ru.rrozhkov.easykin.service.calc.CalculationType.ANTENNA;
import static ru.rrozhkov.easykin.service.calc.CalculationType.HEATING;
import static ru.rrozhkov.easykin.service.calc.CalculationType.HOUSE;
import static ru.rrozhkov.easykin.service.calc.CalculationType.INTERCOM;
import static ru.rrozhkov.easykin.service.calc.impl.CalcFactory.createDefaultCalc;
import static ru.rrozhkov.easykin.service.calc.impl.CalcFactory.createElectricityCalc;
import static ru.rrozhkov.easykin.service.calc.impl.CalcFactory.createGazCalc;
import static ru.rrozhkov.easykin.service.calc.impl.CalcFactory.createHotWaterCalc;
import static ru.rrozhkov.easykin.service.calc.impl.CalcFactory.createServiceCalc;
import static ru.rrozhkov.easykin.service.calc.impl.CalcFactory.createWaterCalc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JPanel;

import ru.rrozhkov.easykin.auto.ICar;
import ru.rrozhkov.easykin.auto.service.IService;
import ru.rrozhkov.easykin.category.Category;
import ru.rrozhkov.easykin.data.impl.SingleCollectionDataProvider;
import ru.rrozhkov.easykin.data.impl.stat.AllDataProvider;
import ru.rrozhkov.easykin.fin.Money;
import ru.rrozhkov.easykin.gui.auto.AutoPanel;
import ru.rrozhkov.easykin.gui.auto.CarPanel;
import ru.rrozhkov.easykin.gui.auto.service.ServiceForm;
import ru.rrozhkov.easykin.gui.service.ServicePanel;
import ru.rrozhkov.easykin.gui.style.impl.custom.FamilyStyle;
import ru.rrozhkov.easykin.gui.style.impl.custom.PaymentStyle;
import ru.rrozhkov.easykin.gui.style.impl.custom.ServiceStyle;
import ru.rrozhkov.easykin.gui.style.impl.custom.TaskStyle;
import ru.rrozhkov.easykin.service.calc.impl.ServiceCalc;

public class PanelFactory {
	private static JPanel createFamilyPanel(){		
		return new TablePanel(AllDataProvider.get(Category.FAMILY).getData(), new FamilyStyle());
	}
	private static JPanel createChildPanel(){
		return new TablePanel(AllDataProvider.get(Category.CHILD).getData(), new FamilyStyle());
	}
	public static JPanel createAutoServicePanel(){
		return new TablePanel(AllDataProvider.get(Category.AUTO).getData(), new ServiceStyle());
	}
	private static JPanel createHomePanel() {
		return new JPanel();
	}
	private static JPanel createFinPanel() {
		return new JPanel();
	}
	private static JPanel createWorkPanel() {
		return new JPanel();
	}
	private static JPanel createPaymentPanel() {
		return new TablePanel(AllDataProvider.get(Category.PAYMENT).getData(), new PaymentStyle());
	}
	private static JPanel createDocPanel() {
		return new JPanel();
	}
	public static JPanel createCarPanel() {
		return new CarPanel(((SingleCollectionDataProvider<IService, ICar>)AllDataProvider.get(Category.AUTO)).getSingleData());
	}
	private static JPanel createAutoPanel() {
		return new AutoPanel();
	}
	public static JPanel createServiceForm(){
		return new ServiceForm(AllDataProvider.get(Category.AUTO));
	}
	public static JPanel createTaskPanel(){
		return new TablePanel(AllDataProvider.get(Category.TASK).getData(), new TaskStyle());
	}
	public static JPanel createServicePanel(){
		return new ServicePanel(
				(ServiceCalc)createServiceCalc(
							Arrays.asList(
	    		  createWaterCalc(487, 495, 379, 386, new Money(14.14), new Money(17.25), new Money(12.20))
	      		, createHotWaterCalc(379, 386, new Money(78.95), new Money(15.12))
	      		, createElectricityCalc(51523, 51685, new Money(3.32), new Money(0.0))
	      		, createGazCalc(77.90, 81.20, new Money(80.06))
	      		, createDefaultCalc(HEATING, new Money(1453.95))
	      		, createDefaultCalc(ANTENNA, new Money(72.00))
	      		, createDefaultCalc(INTERCOM, new Money(70.00))
	      		, createDefaultCalc(HOUSE, new Money(1049.49)))));
	}
	public static Map<Category, JPanel> createPanels(){
        Map<Category, JPanel> panels = new HashMap<Category, JPanel>();
        panels.put(Category.FAMILY, createFamilyPanel());
        panels.put(Category.AUTO, createAutoPanel());
        panels.put(Category.CHILD, createChildPanel());
        panels.put(Category.HOME, createHomePanel());
        panels.put(Category.FIN, createFinPanel());
        panels.put(Category.WORK, createWorkPanel());
        panels.put(Category.PAYMENT, createPaymentPanel());
        panels.put(Category.DOC, createDocPanel());
        panels.put(Category.TASK, createTaskPanel());
        panels.put(Category.SERVICE, createServicePanel());
        return panels;
	}
}