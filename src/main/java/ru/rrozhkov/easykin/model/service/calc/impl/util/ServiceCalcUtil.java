package ru.rrozhkov.easykin.model.service.calc.impl.util;

import java.util.Collection;
import java.util.List;

import ru.rrozhkov.easykin.model.service.calc.CalculationType;
import ru.rrozhkov.easykin.model.service.calc.ICalculation;
import ru.rrozhkov.easykin.model.service.calc.impl.ServiceCalc;
import ru.rrozhkov.easykin.model.service.calc.impl.filter.ServiceCalcFilterFactory;
import ru.rrozhkov.easykin.util.FilterUtil;

public class ServiceCalcUtil {
	public static ICalculation getCalcByType(ServiceCalc entry, CalculationType type){
		Collection<ICalculation> calcs = FilterUtil.filter(entry.getBeans()
				, ServiceCalcFilterFactory.createCalcTypeFilter(type));
		if(calcs.size()==0)
			return null;
		return ((List<ICalculation>)calcs).get(0);
	}
}