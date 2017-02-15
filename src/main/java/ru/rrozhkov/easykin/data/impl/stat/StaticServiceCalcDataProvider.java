package ru.rrozhkov.easykin.data.impl.stat;

import static ru.rrozhkov.easykin.model.service.calc.CalculationType.ANTENNA;
import static ru.rrozhkov.easykin.model.service.calc.CalculationType.HEATING;
import static ru.rrozhkov.easykin.model.service.calc.CalculationType.HOTWATER;
import static ru.rrozhkov.easykin.model.service.calc.CalculationType.HOUSE;
import static ru.rrozhkov.easykin.model.service.calc.CalculationType.INTERCOM;
import static ru.rrozhkov.easykin.model.service.calc.CalculationType.REPAIR;
import static ru.rrozhkov.easykin.model.service.calc.CalculationType.WATER;
import static ru.rrozhkov.easykin.model.service.calc.impl.CalcFactory.createDefaultCalc;
import static ru.rrozhkov.easykin.model.service.calc.impl.CalcFactory.createElectricityCalc;
import static ru.rrozhkov.easykin.model.service.calc.impl.CalcFactory.createGazCalc;
import static ru.rrozhkov.easykin.model.service.calc.impl.CalcFactory.createServiceCalc;

import java.util.Arrays;
import java.util.Collection;

import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.model.fin.MoneyFactory;
import ru.rrozhkov.easykin.model.service.calc.impl.ServiceCalc;
import ru.rrozhkov.lib.collection.CollectionUtil;
import ru.rrozhkov.lib.data.impl.CollectionDataProvider;

public class StaticServiceCalcDataProvider extends CollectionDataProvider<ServiceCalc> {

	private static Collection<ServiceCalc> serviceCalcs = Arrays.asList(
				(ServiceCalc)createServiceCalc("Декабрь 2016", 
					Arrays.asList(
//  		  				createWaterCalc(487, 495, 379, 386, new Money(14.14), new Money(17.25), new Money(12.20))
							createDefaultCalc(WATER, MoneyFactory.create(1.22), true)
							, createDefaultCalc(HOTWATER, MoneyFactory.create(941.19), true)
//    						, createHotWaterCalc(379, 386, new Money(78.95), new Money(15.12))
							, createElectricityCalc(15332, 15429, MoneyFactory.create(3.56), MoneyFactory.create(0.0), true)
							, createGazCalc(0.0, 0.0, MoneyFactory.create(80.06), true)
							, createDefaultCalc(HEATING, MoneyFactory.create(1520.62), true)
							, createDefaultCalc(REPAIR, MoneyFactory.create(341.03), true)
							, createDefaultCalc(ANTENNA, MoneyFactory.create(72.00), true)
							, createDefaultCalc(INTERCOM, MoneyFactory.create(30.00), true)
							, createDefaultCalc(HOUSE, MoneyFactory.create(1116.75), true)
							)
				)
				,(ServiceCalc)createServiceCalc("Январь 2017", 
						Arrays.asList(
								createDefaultCalc(WATER, MoneyFactory.create(373.22), false)
								, createDefaultCalc(HOTWATER, MoneyFactory.create(0.00), false)
								, createElectricityCalc(15429, 15429, MoneyFactory.create(3.56), MoneyFactory.create(0.0), false)
								, createGazCalc(0.0, 0.0, MoneyFactory.create(80.06), true)
								, createDefaultCalc(HEATING, MoneyFactory.create(1520.62), false)
								, createDefaultCalc(REPAIR, MoneyFactory.create(341.03), true)
								, createDefaultCalc(ANTENNA, MoneyFactory.create(72.00), true)
								, createDefaultCalc(INTERCOM, MoneyFactory.create(30.00), true)
								, createDefaultCalc(HOUSE, MoneyFactory.create(1116.75), false)
								)
					)
			);
	public StaticServiceCalcDataProvider() {
		super(CollectionUtil.<ServiceCalc>copy(serviceCalcs));
	}
}