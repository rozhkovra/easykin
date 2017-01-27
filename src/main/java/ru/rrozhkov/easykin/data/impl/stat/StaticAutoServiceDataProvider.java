package ru.rrozhkov.easykin.data.impl.stat;

import java.util.Arrays;

import ru.rrozhkov.easykin.data.impl.CollectionDataProvider;
import ru.rrozhkov.easykin.model.auto.service.IService;
import ru.rrozhkov.easykin.model.auto.service.impl.ServiceFactory;
import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.util.CollectionUtil;
import ru.rrozhkov.easykin.util.DateUtil;

public class StaticAutoServiceDataProvider extends CollectionDataProvider<IService>{
	
	public StaticAutoServiceDataProvider(){
        super(CollectionUtil.copy(Arrays.asList(
            	ServiceFactory.createRepairService("Замена свечей", new Money(0.0), DateUtil.parse("04.01.2017"), Arrays.asList(ServiceFactory.createDetail("Свечи NGK 16мм",new Money(580.0), DateUtil.parse("04.01.2017")),ServiceFactory.createDetail("Свечной ключ на 16мм",new Money(190.0), DateUtil.parse("03.01.2017"))))
            	,ServiceFactory.createService("Заправка", new Money(1000.0), DateUtil.parse("12.01.2017"))
            	,ServiceFactory.createService("Заправка", new Money(500.0), DateUtil.parse("24.01.2017"))
            	)));
	}
}