package ru.rrozhkov.easykin.model.service.calc.impl;

import static ru.rrozhkov.easykin.model.service.calc.impl.CalculatorFactory.getCalculator;
import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.model.service.calc.ICalculation;

public class ServiceCalculator extends Calculator {
	public ServiceCalculator(ServiceCalc calcBean) {
		super(calcBean);
	}

	public ServiceResult calculate() {
		ServiceCalc calcBean = (ServiceCalc)getCalc();
		Money itogo = new Money();
		for(ICalculation calc : calcBean.calcs()){
			Calculation bean = (Calculation)calc;
			if(bean.needCalc()){
				itogo.add(getCalculator(bean).calculate().getResult());
			}
		}
		return new ServiceResult(itogo);
	}
}