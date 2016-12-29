package ru.rrozhkov.easykin.gui.style.impl.custom;

import ru.rrozhkov.easykin.gui.style.IDataConverter;
import ru.rrozhkov.easykin.gui.style.IStyle;
import ru.rrozhkov.easykin.gui.style.ITableStyle;
import ru.rrozhkov.easykin.model.service.calc.impl.ServiceCalc;

public class ServiceCalcStyle implements IStyle<ServiceCalc> {

	public ITableStyle<ServiceCalc> tableStyle() {
		return new ServiceCalcTableStyle();
	}

	public IDataConverter<ServiceCalc> dataConverter() {
		return new ServiceCalcConverter();
	}

}
