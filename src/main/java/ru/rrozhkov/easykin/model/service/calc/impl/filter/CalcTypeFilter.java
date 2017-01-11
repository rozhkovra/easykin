package ru.rrozhkov.easykin.model.service.calc.impl.filter;

import ru.rrozhkov.easykin.filter.impl.Filter;
import ru.rrozhkov.easykin.model.service.calc.CalculationType;
import ru.rrozhkov.easykin.model.service.calc.ICalculation;

public class CalcTypeFilter extends Filter {
	private CalculationType type;
	
	public CalcTypeFilter(CalculationType type) {
		this.type = type;
	}

	public boolean filter() {
		return type.equals(((ICalculation)obj).getType());
	}
}