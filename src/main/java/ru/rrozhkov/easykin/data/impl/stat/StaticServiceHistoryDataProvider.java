package ru.rrozhkov.easykin.data.impl.stat;

import ru.rrozhkov.easykin.auto.Body;
import ru.rrozhkov.easykin.auto.Brend;
import ru.rrozhkov.easykin.auto.ICar;
import ru.rrozhkov.easykin.auto.Model;
import ru.rrozhkov.easykin.auto.impl.CarFactory;
import ru.rrozhkov.easykin.auto.service.IService;
import ru.rrozhkov.easykin.data.impl.SingleCollectionDataProvider;

public class StaticServiceHistoryDataProvider extends SingleCollectionDataProvider<IService, ICar> {
	public StaticServiceHistoryDataProvider() {
		super(new StaticAutoServiceDataProvider().getData(), CarFactory.createCar(Brend.TOYOTA, Model.VISTA, Body.SEDAN, 1995, 1.8));
	}
}