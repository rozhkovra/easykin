package ru.rrozhkov.easykin.model.service.calc.impl;

import java.util.Collection;

import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.model.service.calc.CalculationType;
import ru.rrozhkov.easykin.model.service.calc.ICalculation;
import ru.rrozhkov.easykin.model.service.calc.impl.def.DefaultCalc;
import ru.rrozhkov.easykin.model.service.calc.impl.electricity.ElectricityCalc;
import ru.rrozhkov.easykin.model.service.calc.impl.gaz.GazCalc;
import ru.rrozhkov.easykin.model.service.calc.impl.water.WaterCalc;
import ru.rrozhkov.easykin.model.service.calc.impl.water.hot.HotWaterCalc;

public class CalcFactory {
	public static ICalculation createWaterCalc(int coldPrevMesure, int coldCurrentMesure
			, int hotPrevMesure, int hotCurrentMesure, Money inRate, Money outRate, Money odn, boolean isPaid) {
		return new WaterCalc(coldPrevMesure, coldCurrentMesure, hotPrevMesure
				, hotCurrentMesure, inRate, outRate, odn, isPaid);
	}
	
	public static ICalculation createHotWaterCalc(int hotPrevMesure, int hotCurrentMesure
								, Money rate, Money odn, boolean isPaid) {
		return new HotWaterCalc(hotPrevMesure, hotCurrentMesure,rate, odn, isPaid);
	}

	public static ICalculation createElectricityCalc(int prevMesure, int currentMesure
								, Money rate, Money odn, boolean isPaid) {
		return new ElectricityCalc(prevMesure, currentMesure, rate, odn, isPaid);
	}

	public static ICalculation createGazCalc(double gazPrevMesure, double gazCurrentMesure
								, Money gazRate, boolean isPaid) {
		return new GazCalc(gazPrevMesure, gazCurrentMesure, gazRate, isPaid);
	}

	public static ICalculation createDefaultCalc(CalculationType name, Money sum, boolean isPaid) {
		return new DefaultCalc(name, sum, isPaid);
	}
	
	public static ICalculation createServiceCalc(String name, Collection<ICalculation> beans) {
		return new ServiceCalc(name, beans);
	}
}