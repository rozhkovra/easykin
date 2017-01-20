package ru.rrozhkov.easykin.model.fin.payment.convert.impl;

import java.util.Collection;

import ru.rrozhkov.easykin.model.auto.service.IService;
import ru.rrozhkov.easykin.model.convert.IConverter;
import ru.rrozhkov.easykin.model.fin.payment.IPayment;

public class FinConverterFactory {
	public static IConverter<Collection<IService>,Collection<IPayment>> createServiceConverter(){
		return new ServiceConverter();
	}
}