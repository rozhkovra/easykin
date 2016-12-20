package ru.rrozhkov.easykin.service.calc.impl;

import static ru.rrozhkov.easykin.service.calc.CalculatorFactory.getCalculator;
import ru.rrozhkov.easykin.fin.Money;
import ru.rrozhkov.easykin.service.calc.CalcBean;
import ru.rrozhkov.easykin.service.calc.Calculator;

public class ServiceCalculator extends Calculator {
	public ServiceCalculator(ServiceCalcBean calcBean) {
		super(calcBean);
	}

	public ServiceResult calculate() {
		ServiceCalcBean calcBean = (ServiceCalcBean)getCalcBean();
		Money itogo = new Money();
		for(CalcBean bean : calcBean.getBeans()){
			if(bean.isCalc()){
				System.out.println(getCalculator(bean).calculate());
				itogo.add(getCalculator(bean).calculate().getSum());
			}
		}
		System.out.println("\n\nItogo = "+itogo);
		return new ServiceResult(itogo);
	}
}