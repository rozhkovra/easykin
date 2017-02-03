package ru.rrozhkov.easykin.data.impl;

import java.util.Collection;

import ru.rrozhkov.easykin.model.auto.service.IService;
import ru.rrozhkov.easykin.model.convert.IConverter;
import ru.rrozhkov.easykin.model.fin.payment.IPayment;
import ru.rrozhkov.easykin.model.fin.payment.impl.convert.FinConverterFactory;
import ru.rrozhkov.easykin.model.service.calc.impl.ServiceCalc;

public class PaymentDataProvider extends CollectionDataProvider<IPayment> {
	private static IConverter<Collection<IService>,Collection<IPayment>> serviceConverter 
										= FinConverterFactory.createServiceConverter();
	private static IConverter<Collection<ServiceCalc>,Collection<IPayment>> serviceCalcConverter 
										= FinConverterFactory.createServiceCalcConverter();

	public PaymentDataProvider(Collection<IService> services, Collection<ServiceCalc> calcs) {
		super(serviceConverter.convert(services));
		this.collection.addAll(serviceCalcConverter.convert(calcs));
	}	
}