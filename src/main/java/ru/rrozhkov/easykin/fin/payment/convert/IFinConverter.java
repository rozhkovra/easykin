package ru.rrozhkov.easykin.fin.payment.convert;

import ru.rrozhkov.easykin.fin.payment.IPayment;

public interface IFinConverter<T> {
	IPayment convert(T entry);
}