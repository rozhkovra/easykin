package ru.rrozhkov.easykin.model.fin.payment.convert;

import ru.rrozhkov.easykin.model.fin.payment.convert.impl.ServiceConverter;

public class FinConverterFactory {
	public static ServiceConverter createServiceConverter(){
		return new ServiceConverter();
	}
}