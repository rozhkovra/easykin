package ru.rrozhkov.easykin.gui.style.impl.custom;

import ru.rrozhkov.easykin.gui.style.impl.DataConverter;
import ru.rrozhkov.easykin.model.auto.service.IService;
import ru.rrozhkov.easykin.util.DateUtil;

public class ServiceConverter extends DataConverter<IService> {
	public String[] entryToStringArr(int i, IService entry) {
		return new String[]{String.valueOf(i), entry.getName(), entry.getPrice().toString(), DateUtil.format(entry.getDate())};
	}
}