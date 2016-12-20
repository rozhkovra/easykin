package ru.rrozhkov.easykin.data.impl;

import ru.rrozhkov.easykin.auto.service.IService;
import ru.rrozhkov.easykin.data.ICollectionDataProvider;
import ru.rrozhkov.easykin.fin.payment.IPayment;
import ru.rrozhkov.easykin.fin.payment.convert.FinConverterFactory;
import ru.rrozhkov.easykin.fin.payment.convert.impl.ServiceConverter;

public class PaymentDataProvider extends CollectionDataProvider<IPayment> {
	private static ServiceConverter serviceConverter = FinConverterFactory.createServiceConverter();
	protected ICollectionDataProvider<IService> serviceData;

	public PaymentDataProvider(ICollectionDataProvider<IService> serviceData) {
		super(serviceConverter.convert(serviceData.getData()));
		this.serviceData = serviceData;
	}	
}