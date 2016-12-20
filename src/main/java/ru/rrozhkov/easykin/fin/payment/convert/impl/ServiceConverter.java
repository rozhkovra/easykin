package ru.rrozhkov.easykin.fin.payment.convert.impl;

import static ru.rrozhkov.easykin.auto.service.impl.filter.ServiceFilterFactory.createNoFreeFilter;
import static ru.rrozhkov.easykin.auto.service.impl.filter.ServiceFilterFactory.createOnlyRepairFilter;
import static ru.rrozhkov.easykin.fin.payment.impl.PaymentFactory.createDetailPayment;
import static ru.rrozhkov.easykin.fin.payment.impl.PaymentFactory.createServicePayment;

import java.util.Collection;

import ru.rrozhkov.easykin.auto.service.IDetail;
import ru.rrozhkov.easykin.auto.service.IRepairService;
import ru.rrozhkov.easykin.auto.service.IService;
import ru.rrozhkov.easykin.fin.payment.IPayment;
import ru.rrozhkov.easykin.fin.payment.convert.IFinConverter;
import ru.rrozhkov.easykin.util.CollectionUtil;
import ru.rrozhkov.easykin.util.FilterUtil;

public class ServiceConverter implements IFinConverter<IService> {
	
	public IPayment convert(IService entry) {
		return createServicePayment(entry);
	}

	public Collection<IPayment> convert(Collection<IService> entries) {
		Collection<IPayment> collection = CollectionUtil.<IPayment>create();
		for(IService service : FilterUtil.<IService>filter(entries, createNoFreeFilter())){
			collection.add(convert(service));
		}
		for(IService service : FilterUtil.<IService>filter(entries, createOnlyRepairFilter())){
			collection.addAll(convertDetails(((IRepairService)service).getDetails()));
		}
		return collection;
	}

	private Collection<? extends IPayment> convertDetails(Collection<IDetail> details) {
		Collection<IPayment> collection = CollectionUtil.<IPayment>create();
		for(IDetail detail : details) {
			collection.add(createDetailPayment(detail));
		}
		return collection;
	}
}