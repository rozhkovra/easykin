package ru.rrozhkov.easykin.auto.service.impl.filter;

import ru.rrozhkov.easykin.auto.service.IRepairService;
import ru.rrozhkov.easykin.report.impl.Filter;

public class OnlyRepairFilter extends Filter {
	public boolean filter() {
		return obj instanceof IRepairService;
	}
}