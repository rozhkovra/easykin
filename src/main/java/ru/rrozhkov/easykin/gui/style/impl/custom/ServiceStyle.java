package ru.rrozhkov.easykin.gui.style.impl.custom;

import ru.rrozhkov.easykin.gui.style.IDataConverter;
import ru.rrozhkov.easykin.gui.style.IStyle;
import ru.rrozhkov.easykin.gui.style.ITableStyle;
import ru.rrozhkov.easykin.model.auto.service.IService;

public class ServiceStyle implements IStyle<IService> {

	public ITableStyle<IService> tableStyle() {
		return new ServiceTableStyle();
	}

	public IDataConverter<IService> dataConverter() {
		return new ServiceConverter();
	}

}
