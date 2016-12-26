package ru.rrozhkov.easykin.fin.payment.impl.filter;

import ru.rrozhkov.easykin.report.IFilter;

public class PaymentFilterFactory {
	public static IFilter createNoFreeFilter(){
		return new NoFreeFilter();
	}
}