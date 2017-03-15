package ru.rrozhkov.easykin.gui.service;

import ru.rrozhkov.easykin.gui.image.ImageManager;
import ru.rrozhkov.easykin.model.service.calc.impl.CalcFactory;
import ru.rrozhkov.easykin.model.service.calc.impl.ServiceCalc;

import javax.swing.*;
import java.awt.*;

public class ServiceWindow extends JFrame{
	private static final long serialVersionUID = 1L;

	public ServiceWindow(JPanel panel) throws HeadlessException {
		super("Коммунальные услуги");
		setIconImage(ImageManager.logo(this.getClass()));
		setContentPane(panel);
    	setExtendedState(ServiceWindow.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        setVisible(true);
	}

	public static void main(String[] args){
		ServiceCalc calc = (ServiceCalc) CalcFactory.createEmptyServiceCalc();

		final Panel panel = PanelFactory.getPanel(null, calc);
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new ServiceWindow(panel);
			}
		});
	}
}