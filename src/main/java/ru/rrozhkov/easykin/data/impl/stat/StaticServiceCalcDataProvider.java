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
import ru.rrozhkov.easykin.model.service.calc.impl.ServiceCalc;
import ru.rrozhkov.lib.collection.CollectionUtil;
import ru.rrozhkov.lib.data.impl.CollectionDataProvider;

public class StaticServiceCalcDataProvider extends CollectionDataProvider<ServiceCalc> {

	private static Collection<ServiceCalc> serviceCalcs = Arrays.asList(
				(ServiceCalc)createServiceCalc("Декабрь 2016", 
					Arrays.asList(
//  		  				createWaterCalc(487, 495, 379, 386, new Money(14.14), new Money(17.25), new Money(12.20))
							createDefaultCalc(WATER, new Money(1.22), true)	
							, createDefaultCalc(HOTWATER, new Money(941.19), true)
//    						, createHotWaterCalc(379, 386, new Money(78.95), new Money(15.12))
							, createElectricityCalc(15332, 15429, new Money(3.56), new Money(0.0), true)
							, createGazCalc(0.0, 0.0, new Money(80.06), true)
							, createDefaultCalc(HEATING, new Money(1520.62), true)
							, createDefaultCalc(REPAIR, new Money(341.03), true)
							, createDefaultCalc(ANTENNA, new Money(72.00), true)
							, createDefaultCalc(INTERCOM, new Money(30.00), true)
							, createDefaultCalc(HOUSE, new Money(1116.75), true)
							)
				)
				,(ServiceCalc)createServiceCalc("Январь 2017", 
						Arrays.asList(
								createDefaultCalc(WATER, new Money(0.00), false)	
								, createDefaultCalc(HOTWATER, new Money(0.00), false)
								, createElectricityCalc(15429, 15429, new Money(3.56), new Money(0.0), false)
								, createGazCalc(0.0, 0.0, new Money(80.06), true)
								, createDefaultCalc(HEATING, new Money(1520.62), false)
								, createDefaultCalc(REPAIR, new Money(341.03), true)
								, createDefaultCalc(ANTENNA, new Money(72.00), true)
								, createDefaultCalc(INTERCOM, new Money(30.00), true)
								, createDefaultCalc(HOUSE, new Money(1116.75), false)
								)
					)
			);
	public StaticServiceCalcDataProvider() {
		super(CollectionUtil.<ServiceCalc>copy(serviceCalcs));
	}
}