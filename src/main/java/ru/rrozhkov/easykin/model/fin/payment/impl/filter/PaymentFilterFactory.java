package ru.rrozhkov.easykin.model.fin.payment.impl.filter;

import ru.rrozhkov.easykin.report.IFilter;

public class PaymentFilterFactory {
	public static IFilter createNoFreeFilter(){
		return new NoFreeFilter();
	}
}