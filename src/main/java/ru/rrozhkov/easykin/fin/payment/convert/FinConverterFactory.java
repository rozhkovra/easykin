package ru.rrozhkov.easykin.fin.payment.convert;

import ru.rrozhkov.easykin.fin.payment.convert.impl.ServiceConverter;

public class FinConverterFactory {
	public static ServiceConverter createServiceConverter(){
		return new ServiceConverter();
	}
}