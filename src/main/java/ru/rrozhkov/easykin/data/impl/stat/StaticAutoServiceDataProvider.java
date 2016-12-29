package ru.rrozhkov.easykin.data.impl.stat;

import static ru.rrozhkov.easykin.model.auto.service.impl.ServiceFactory.createDetail;
import static ru.rrozhkov.easykin.model.auto.service.impl.ServiceFactory.createRepairService;
import static ru.rrozhkov.easykin.model.auto.service.impl.ServiceFactory.createService;

import java.util.Arrays;
import java.util.Date;

import ru.rrozhkov.easykin.data.impl.CollectionDataProvider;
import ru.rrozhkov.easykin.model.auto.service.IService;
import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.util.CollectionUtil;

public class StaticAutoServiceDataProvider extends CollectionDataProvider<IService>{
	
	public StaticAutoServiceDataProvider(){
        super(CollectionUtil.copy(Arrays.asList(
            	createService("Заправка", new Money(1000.0), new Date())
            	,createRepairService("Замена масла", new Money(350.50), new Date(),Arrays.asList(createDetail("Масло",new Money(1500.0), new Date())))
            	,createRepairService("Замена масляного фильтра", new Money(0.0), new Date(), Arrays.asList(createDetail("Масляный фильтр",new Money(450.0), new Date()))))
            	));
	}
}