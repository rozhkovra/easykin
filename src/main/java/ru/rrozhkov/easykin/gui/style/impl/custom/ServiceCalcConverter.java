package ru.rrozhkov.easykin.gui.style.impl.custom;

import static ru.rrozhkov.easykin.service.calc.impl.CalculatorFactory.getCalculator;
import ru.rrozhkov.easykin.gui.style.impl.DataConverter;
import ru.rrozhkov.easykin.service.calc.CalculationType;
import ru.rrozhkov.easykin.service.calc.impl.ServiceCalc;
import ru.rrozhkov.easykin.util.DateUtil;

public class ServiceCalcConverter extends DataConverter<ServiceCalc> {
	public String[] entryToStringArr(int i, ServiceCalc entry) {
		return new String[]{String.valueOf(i), DateUtil.format(entry.getDate())
				, getCalculator(entry.getCalcByType(CalculationType.WATER)).calculate().getResult().toString()
				, getCalculator(entry.getCalcByType(CalculationType.HOTWATER)).calculate().getResult().toString()
				, getCalculator(entry.getCalcByType(CalculationType.ELECTRICITY)).calculate().getResult().toString()
				, getCalculator(entry.getCalcByType(CalculationType.GAZ)).calculate().getResult().toString()
				, getCalculator(entry.getCalcByType(CalculationType.HEATING)).calculate().getResult().toString()
				, getCalculator(entry.getCalcByType(CalculationType.ANTENNA)).calculate().getResult().toString()
				, getCalculator(entry.getCalcByType(CalculationType.INTERCOM)).calculate().getResult().toString()
				, getCalculator(entry.getCalcByType(CalculationType.HOUSE)).calculate().getResult().toString()};
	}
}