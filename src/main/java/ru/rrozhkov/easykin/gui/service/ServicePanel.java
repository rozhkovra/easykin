package ru.rrozhkov.easykin.gui.service;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import ru.rrozhkov.easykin.model.service.calc.ICalculation;
import ru.rrozhkov.easykin.model.service.calc.impl.ServiceCalc;

public class ServicePanel extends Panel {
	private static final long serialVersionUID = 1L;
	
	public ServicePanel(ServiceCalc serviceCalcBean) {
		super(serviceCalcBean);
        fill();
	}

	private void fill() {
		setLayout(new GridLayout(5,4));
        for(ICalculation bean : ((ServiceCalc)calc).calcs()){
        	add(PanelFactory.getPanel(bean));
        }
        add(getCalcButton());
        add(getItogoLabel());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for(Component component : getComponents()){
			if(component instanceof Panel)
				((Panel)component).actionPerformed(e);
		}
		super.actionPerformed(e);
	}	
}