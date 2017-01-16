package ru.rrozhkov.easykin.model.fin.payment.impl.filter;

import ru.rrozhkov.easykin.filter.IFilter;
import ru.rrozhkov.easykin.model.fin.payment.IPayment;

public class PaymentFilterFactory {
	public static IFilter<IPayment> createNoFreeFilter(){
		return new NoFreeFilter();
	}
}