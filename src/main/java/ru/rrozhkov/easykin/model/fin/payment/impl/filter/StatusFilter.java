package ru.rrozhkov.easykin.model.fin.payment.impl.filter;

import ru.rrozhkov.easykin.filter.IFilter;
import ru.rrozhkov.easykin.model.fin.Status;
import ru.rrozhkov.easykin.model.fin.payment.IPayment;

public class StatusFilter implements IFilter<IPayment> {
	private Status status;
	public StatusFilter(Status status) {
		this.status = status;
	}

	public boolean filter(IPayment obj) {
		return status.equals(obj.getStatus());
	}

}
