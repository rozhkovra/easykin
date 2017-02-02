package ru.rrozhkov.easykin.data.impl;

import java.util.Collection;

import ru.rrozhkov.easykin.data.ICollectionDataProvider;
import ru.rrozhkov.easykin.model.auto.service.IService;
import ru.rrozhkov.easykin.model.convert.IConverter;
import ru.rrozhkov.easykin.model.fin.payment.IPayment;
import ru.rrozhkov.easykin.model.fin.payment.impl.convert.FinConverterFactory;

public class PaymentDataProvider extends CollectionDataProvider<IPayment> {
	private static IConverter<Collection<IService>,Collection<IPayment>> serviceConverter 
										= FinConverterFactory.createServiceConverter();
	protected ICollectionDataProvider<IService> serviceData;

	public PaymentDataProvider(ICollectionDataProvider<IService> serviceData) {
		super(serviceConverter.convert(serviceData.getData()));
		this.serviceData = serviceData;
	}	
}