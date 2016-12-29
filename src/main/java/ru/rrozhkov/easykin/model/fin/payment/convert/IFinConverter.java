package ru.rrozhkov.easykin.model.fin.payment.convert;

import ru.rrozhkov.easykin.model.fin.payment.IPayment;

public interface IFinConverter<T> {
	IPayment convert(T entry);
}