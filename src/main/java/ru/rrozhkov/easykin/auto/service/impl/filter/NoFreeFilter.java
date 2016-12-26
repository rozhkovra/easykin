package ru.rrozhkov.easykin.auto.service.impl.filter;

import ru.rrozhkov.easykin.auto.service.IService;
import ru.rrozhkov.easykin.report.impl.Filter;

public class NoFreeFilter extends Filter {
	public boolean filter() {
		return !((IService)obj).getPrice().free();
	}
}