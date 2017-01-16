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

import ru.rrozhkov.easykin.data.impl.SingleCollectionDataProvider;
import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.model.service.calc.ICalculation;
import ru.rrozhkov.easykin.model.service.calc.impl.ServiceCalc;
import ru.rrozhkov.easykin.util.CollectionUtil;

public class StaticServiceDataProvider extends SingleCollectionDataProvider<ServiceCalc, String> {
	private static Collection<ICalculation> calcs = Arrays.asList(
//  		  		createWaterCalc(487, 495, 379, 386, new Money(14.14), new Money(17.25), new Money(12.20))
		  	createDefaultCalc(WATER, new Money(1.22), true)	
			, createDefaultCalc(HOTWATER, new Money(941.19), false)
//    		, createHotWaterCalc(379, 386, new Money(78.95), new Money(15.12))
    		, createElectricityCalc(51523, 51685, new Money(3.32), new Money(0.0), false)
    		, createGazCalc(0.0, 0.0, new Money(80.06), true)
    		, createDefaultCalc(HEATING, new Money(1520.62), false)
    		, createDefaultCalc(REPAIR, new Money(341.03), false)
    		, createDefaultCalc(ANTENNA, new Money(72.00), false)
    		, createDefaultCalc(INTERCOM, new Money(30.00), false)
    		, createDefaultCalc(HOUSE, new Money(1116.75), false));
	public StaticServiceDataProvider() {
		super(CollectionUtil.<ServiceCalc>merge2copy(CollectionUtil.<ServiceCalc>create()
				, (ServiceCalc)createServiceCalc("Декабрь 2016", calcs)), "Декабрь 2016");
	}
}