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
			, int hotPrevMesure, int hotCurrentMesure, Money inRate, Money outRate, Money odn) {
		return new WaterCalc(coldPrevMesure, coldCurrentMesure, hotPrevMesure
				, hotCurrentMesure, inRate, outRate, odn);
	}
	
	public static ICalculation createHotWaterCalc(int hotPrevMesure, int hotCurrentMesure
								, Money rate, Money odn) {
		return new HotWaterCalc(hotPrevMesure, hotCurrentMesure,rate, odn);
	}

	public static ICalculation createElectricityCalc(int prevMesure, int currentMesure
								, Money rate, Money odn) {
		return new ElectricityCalc(prevMesure, currentMesure, rate, odn);
	}

	public static ICalculation createGazCalc(double gazPrevMesure, double gazCurrentMesure
								, Money gazRate) {
		return new GazCalc(gazPrevMesure, gazCurrentMesure, gazRate);
	}

	public static ICalculation createDefaultCalc(CalculationType name, Money sum) {
		return new DefaultCalc(name, sum);
	}
	
	public static ICalculation createServiceCalc(Collection<ICalculation> beans) {
		return new ServiceCalc(beans);
	}
}