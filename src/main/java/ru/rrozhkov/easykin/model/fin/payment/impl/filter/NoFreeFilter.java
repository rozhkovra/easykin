package ru.rrozhkov.easykin.model.fin.payment.impl.filter;

import ru.rrozhkov.easykin.filter.IFilter;
import ru.rrozhkov.easykin.model.fin.payment.IPayment;

public class NoFreeFilter implements IFilter<IPayment> {
	public boolean filter(IPayment obj) {
		return !obj.getAmount().free();
	}
}