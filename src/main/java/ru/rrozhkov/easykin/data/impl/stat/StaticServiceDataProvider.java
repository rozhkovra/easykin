package ru.rrozhkov.easykin.data.impl.stat;

import static ru.rrozhkov.easykin.service.calc.CalculationType.ANTENNA;
import static ru.rrozhkov.easykin.service.calc.CalculationType.HEATING;
import static ru.rrozhkov.easykin.service.calc.CalculationType.HOUSE;
import static ru.rrozhkov.easykin.service.calc.CalculationType.INTERCOM;
import static ru.rrozhkov.easykin.service.calc.impl.CalcFactory.createDefaultCalc;
import static ru.rrozhkov.easykin.service.calc.impl.CalcFactory.createElectricityCalc;
import static ru.rrozhkov.easykin.service.calc.impl.CalcFactory.createGazCalc;
import static ru.rrozhkov.easykin.service.calc.impl.CalcFactory.createHotWaterCalc;
import static ru.rrozhkov.easykin.service.calc.impl.CalcFactory.createServiceCalc;
import static ru.rrozhkov.easykin.service.calc.impl.CalcFactory.createWaterCalc;

import java.util.Arrays;
import java.util.Collection;

import ru.rrozhkov.easykin.data.impl.SingleCollectionDataProvider;
import ru.rrozhkov.easykin.fin.Money;
import ru.rrozhkov.easykin.service.calc.ICalculation;

public class StaticServiceDataProvider extends SingleCollectionDataProvider<ICalculation, ICalculation> {
	private static Collection<ICalculation> calcs = Arrays.asList(
  		  createWaterCalc(487, 495, 379, 386, new Money(14.14), new Money(17.25), new Money(12.20))
    		, createHotWaterCalc(379, 386, new Money(78.95), new Money(15.12))
    		, createElectricityCalc(51523, 51685, new Money(3.32), new Money(0.0))
    		, createGazCalc(77.90, 81.20, new Money(80.06))
    		, createDefaultCalc(HEATING, new Money(1453.95))
    		, createDefaultCalc(ANTENNA, new Money(72.00))
    		, createDefaultCalc(INTERCOM, new Money(70.00))
    		, createDefaultCalc(HOUSE, new Money(1049.49)));
	public StaticServiceDataProvider() {
		super(calcs, createServiceCalc(calcs));
	}
}