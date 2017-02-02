package ru.rrozhkov.easykin.model.fin.payment.impl.convert;

import static ru.rrozhkov.easykin.model.fin.payment.impl.PaymentFactory.createDetailPayment;
import static ru.rrozhkov.easykin.model.fin.payment.impl.filter.PaymentFilterFactory.createNoFreeFilter;

import java.util.Collection;

import ru.rrozhkov.easykin.model.auto.service.IService;
import ru.rrozhkov.easykin.model.auto.service.impl.RepairService;
import ru.rrozhkov.easykin.model.convert.IConverter;
import ru.rrozhkov.easykin.model.fin.payment.IPayment;
import ru.rrozhkov.easykin.model.fin.payment.impl.PaymentFactory;
import ru.rrozhkov.easykin.util.CollectionUtil;
import ru.rrozhkov.easykin.util.FilterUtil;

public class ServiceConverter implements IConverter<Collection<IService>,Collection<IPayment>> {
	public Collection<IPayment> convert(Collection<IService> entries) {
		Collection<IPayment> collection = CollectionUtil.<IPayment>create();
		for(IService service : entries){
			collection.add(new SingleConverter().convert(service));
			for(IService detailService : service.services()){
				collection.add(createDetailPayment(detailService.getName(),detailService.getPrice(),detailService.getDate()));
			}
		}
		return FilterUtil.<IPayment>filter(collection, createNoFreeFilter());
	}
	
	class SingleConverter implements IConverter<IService, IPayment> {
		public IPayment convert(IService entry) {
			if(entry instanceof RepairService){
				return PaymentFactory.createAutoRepairPayment(entry.getName(),entry.getPrice(),entry.getDate());
			}
			return PaymentFactory.createAutoPayment(entry.getName(),entry.getPrice(),entry.getDate());
		}
	}
}