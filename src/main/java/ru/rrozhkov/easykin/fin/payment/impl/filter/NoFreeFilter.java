package ru.rrozhkov.easykin.fin.payment.impl.filter;

import ru.rrozhkov.easykin.fin.payment.IPayment;
import ru.rrozhkov.easykin.report.impl.Filter;

public class NoFreeFilter extends Filter {
	public boolean filter() {
		return !((IPayment)obj).getAmount().free();
	}
}