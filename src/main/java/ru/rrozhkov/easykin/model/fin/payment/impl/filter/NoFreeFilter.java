package ru.rrozhkov.easykin.model.fin.payment.impl.filter;

import ru.rrozhkov.easykin.filter.impl.Filter;
import ru.rrozhkov.easykin.model.fin.payment.IPayment;

public class NoFreeFilter extends Filter {
	public boolean filter() {
		return !((IPayment)obj).getAmount().free();
	}
}