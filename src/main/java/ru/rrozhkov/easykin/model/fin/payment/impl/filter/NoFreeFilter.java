package ru.rrozhkov.easykin.model.fin.payment.impl.filter;

import ru.rrozhkov.easykin.model.fin.payment.IPayment;
import ru.rrozhkov.easykin.report.impl.Filter;

public class NoFreeFilter extends Filter {
	public boolean filter() {
		return !((IPayment)obj).getAmount().free();
	}
}