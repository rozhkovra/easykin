package ru.rrozhkov.easykin.model.fin.payment.convert.impl;

import static ru.rrozhkov.easykin.model.fin.payment.impl.PaymentFactory.createDetailPayment;
import static ru.rrozhkov.easykin.model.fin.payment.impl.PaymentFactory.createServicePayment;
import static ru.rrozhkov.easykin.model.fin.payment.impl.filter.PaymentFilterFactory.createNoFreeFilter;

import java.util.Collection;

import ru.rrozhkov.easykin.model.auto.service.IService;
import ru.rrozhkov.easykin.model.fin.payment.IPayment;
import ru.rrozhkov.easykin.model.fin.payment.convert.IFinConverter;
import ru.rrozhkov.easykin.util.CollectionUtil;
import ru.rrozhkov.easykin.util.FilterUtil;

public class ServiceConverter implements IFinConverter<IService> {
	
	public IPayment convert(IService entry) {
		return createServicePayment(entry);
	}

	public Collection<IPayment> convert(Collection<IService> entries) {
		Collection<IPayment> collection = CollectionUtil.<IPayment>create();
		for(IService service : entries){
			collection.add(convert(service));
			for(IService detailService : service.services()){
				collection.add(createDetailPayment(detailService));
			}
		}
		return FilterUtil.<IPayment>filter(collection, createNoFreeFilter());
	}
}