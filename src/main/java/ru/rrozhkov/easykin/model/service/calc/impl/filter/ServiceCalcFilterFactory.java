package ru.rrozhkov.easykin.model.service.calc.impl.filter;

import ru.rrozhkov.easykin.filter.IFilter;
import ru.rrozhkov.easykin.model.service.calc.CalculationType;

public class ServiceCalcFilterFactory {
	public static IFilter createCalcTypeFilter(CalculationType type){
		return new CalcTypeFilter(type);
	}
}