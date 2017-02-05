package ru.rrozhkov.easykin.model.fin.payment.impl.filter;

import ru.rrozhkov.easykin.model.fin.payment.IPayment;
import ru.rrozhkov.easykin.model.fin.payment.Status;
import ru.rrozhkov.lib.filter.IFilter;

public class PaymentFilterFactory {
	public static IFilter<IPayment> createNoFreeFilter(){
		return new NoFreeFilter();
	}
	public static IFilter<IPayment> createStatusFilter(Status status){
		return new StatusFilter(status);
	}
}