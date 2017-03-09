package ru.rrozhkov.easykin.gui.service;

import ru.rrozhkov.easykin.model.fin.MoneyFactory;
import ru.rrozhkov.easykin.model.service.calc.impl.ServiceCalc;
import ru.rrozhkov.easykin.util.DateUtil;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

import static ru.rrozhkov.easykin.model.service.calc.CalculationType.*;
import static ru.rrozhkov.easykin.model.service.calc.impl.CalcFactory.*;
import static ru.rrozhkov.easykin.model.service.calc.impl.CalcFactory.createDefaultCalc;

public class ServiceWindow extends JFrame{
	private static final long serialVersionUID = 1L;

	public ServiceWindow(JPanel panel) throws HeadlessException {
		super();
		setContentPane(panel);
    	setExtendedState(ServiceWindow.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        setVisible(true);
	}

	public static void main(String[] args){
		ServiceCalc calc = (ServiceCalc)createServiceCalc(DateUtil.parse("01.01.2017"),
				Arrays.asList(
						createDefaultCalc(WATER, MoneyFactory.create(0.00), false)
						, createDefaultCalc(HOTWATER, MoneyFactory.create(0.00), false)
						, createElectricityCalc(0, 0, MoneyFactory.create(3.56), MoneyFactory.create(0.0), false)
						, createGazCalc(0.0, 0.0, MoneyFactory.create(80.06), false)
						, createDefaultCalc(HEATING, MoneyFactory.create(0.00), false)
						, createDefaultCalc(REPAIR, MoneyFactory.create(0.00), false)
						, createDefaultCalc(ANTENNA, MoneyFactory.create(0.00), false)
						, createDefaultCalc(INTERCOM, MoneyFactory.create(40.00), false)
						, createDefaultCalc(HOUSE, MoneyFactory.create(0.00), false)
				)
		);

		final Panel panel = PanelFactory.getPanel(null, calc);
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new ServiceWindow(panel);
			}
		});
	}
}