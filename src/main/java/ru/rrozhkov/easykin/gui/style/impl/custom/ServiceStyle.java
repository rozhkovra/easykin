package ru.rrozhkov.easykin.gui.style.impl.custom;

import ru.rrozhkov.easykin.auto.service.IService;
import ru.rrozhkov.easykin.gui.style.IDataConverter;
import ru.rrozhkov.easykin.gui.style.IStyle;
import ru.rrozhkov.easykin.gui.style.ITableStyle;

public class ServiceStyle implements IStyle<IService> {

	public ITableStyle tableStyle() {
		return new ServiceTableStyle();
	}

	public IDataConverter<IService> dataConverter() {
		return new ServiceConverter();
	}

}
