package ru.rrozhkov.easykin.model.fin.payment.convert;

import ru.rrozhkov.easykin.model.convert.IConverter;
import ru.rrozhkov.easykin.model.fin.payment.IPayment;

public interface IFinConverter<T> extends IConverter<T,IPayment> {
	IPayment convert(T entry);
}