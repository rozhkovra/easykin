package ru.rrozhkov.easykin.model.auto.service.impl.filter;

import ru.rrozhkov.easykin.filter.impl.Filter;
import ru.rrozhkov.easykin.model.auto.service.IService;

public class NoFreeFilter extends Filter {
	public boolean filter() {
		return !((IService)obj).getPrice().free();
	}
}