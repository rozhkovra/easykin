package ru.rrozhkov.easykin.data.impl;

import java.util.Collection;

import ru.rrozhkov.easykin.context.EasyKinContext;
import ru.rrozhkov.easykin.model.auto.service.IService;
import ru.rrozhkov.easykin.model.fin.payment.IPayment;
import ru.rrozhkov.easykin.model.fin.payment.impl.convert.FinConverterFactory;
import ru.rrozhkov.easykin.model.service.calc.impl.ServiceCalc;
import ru.rrozhkov.easykin.model.task.ITask;
import ru.rrozhkov.lib.convert.IConverter;
import ru.rrozhkov.lib.data.impl.CollectionDataProvider;

public class PaymentDataProvider extends CollectionDataProvider<IPayment> {
	private static IConverter<Collection<IService>,Collection<IPayment>> serviceConverter 
										= FinConverterFactory.createServiceConverter();
	private static IConverter<Collection<ServiceCalc>,Collection<IPayment>> serviceCalcConverter 
										= FinConverterFactory.createServiceCalcConverter();
	private static IConverter<Collection<ITask>,Collection<IPayment>> taskConverter 
										= FinConverterFactory.createTaskConverter();

	public PaymentDataProvider(EasyKinContext context) {
		super(serviceConverter.convert(context.services()));
		this.collection.addAll(serviceCalcConverter.convert(context.calcs()));
		this.collection.addAll(taskConverter.convert(context.tasks()));
	}	
}