package ru.rrozhkov.easykin.model.auto.service.impl.filter;

import ru.rrozhkov.easykin.filter.IFilter;
import ru.rrozhkov.easykin.model.auto.service.IService;

public class NoFreeFilter implements IFilter<IService> {
	public boolean filter(IService obj) {
		return !obj.getPrice().free();
	}
}