package ru.rrozhkov.easykin.service.calc.impl;

import static ru.rrozhkov.easykin.service.calc.impl.CalculatorFactory.getCalculator;
import ru.rrozhkov.easykin.fin.Money;
import ru.rrozhkov.easykin.service.calc.ICalculation;

public class ServiceCalculator extends Calculator {
	public ServiceCalculator(ServiceCalc calcBean) {
		super(calcBean);
	}

	public ServiceResult calculate() {
		ServiceCalc calcBean = (ServiceCalc)getCalc();
		Money itogo = new Money();
		for(ICalculation calc : calcBean.getBeans()){
			Calculation bean = (Calculation)calc;
			if(bean.needCalc()){
				System.out.println(getCalculator(bean).calculate());
				itogo.add(getCalculator(bean).calculate().getResult());
			}
		}
		System.out.println("\n\nItogo = "+itogo);
		return new ServiceResult(itogo);
	}
}