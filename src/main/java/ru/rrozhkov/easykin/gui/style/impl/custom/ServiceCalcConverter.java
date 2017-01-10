package ru.rrozhkov.easykin.gui.style.impl.custom;

import static ru.rrozhkov.easykin.model.service.calc.impl.CalculatorFactory.getCalculator;
import ru.rrozhkov.easykin.gui.style.impl.DataConverter;
import ru.rrozhkov.easykin.model.service.calc.CalculationType;
import ru.rrozhkov.easykin.model.service.calc.impl.ServiceCalc;
import ru.rrozhkov.easykin.model.service.calc.impl.util.ServiceCalcUtil;
import ru.rrozhkov.easykin.util.DateUtil;

public class ServiceCalcConverter extends DataConverter<ServiceCalc> {
	public String[] entryToStringArr(int i, ServiceCalc entry) {
		return new String[]{entry.getName(), DateUtil.format(entry.getDate())
				, getCalculator(ServiceCalcUtil.getCalcByType(entry, CalculationType.WATER)).calculate().toString()
				, getCalculator(ServiceCalcUtil.getCalcByType(entry,CalculationType.HOTWATER)).calculate().toString()
				, getCalculator(ServiceCalcUtil.getCalcByType(entry,CalculationType.ELECTRICITY)).calculate().toString()
				, getCalculator(ServiceCalcUtil.getCalcByType(entry,CalculationType.GAZ)).calculate().toString()
				, getCalculator(ServiceCalcUtil.getCalcByType(entry,CalculationType.HEATING)).calculate().toString()
				, getCalculator(ServiceCalcUtil.getCalcByType(entry,CalculationType.ANTENNA)).calculate().toString()
				, getCalculator(ServiceCalcUtil.getCalcByType(entry,CalculationType.INTERCOM)).calculate().toString()
				, getCalculator(ServiceCalcUtil.getCalcByType(entry,CalculationType.HOUSE)).calculate().toString()
				, getCalculator(ServiceCalcUtil.getCalcByType(entry,CalculationType.REPAIR)).calculate().toString()
				, getCalculator(entry).calculate().toString()};
	}
}