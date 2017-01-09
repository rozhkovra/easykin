package ru.rrozhkov.easykin.model.service.calc.impl.filter;

import ru.rrozhkov.easykin.model.service.calc.CalculationType;
import ru.rrozhkov.easykin.report.IFilter;

public class ServiceCalcFilterFactory {
	public static IFilter createCalcTypeFilter(CalculationType type){
		return new CalcTypeFilter(type);
	}
}