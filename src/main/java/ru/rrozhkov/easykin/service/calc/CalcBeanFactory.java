package ru.rrozhkov.easykin.service.calc;

import java.util.Collection;

import ru.rrozhkov.easykin.fin.Money;
import ru.rrozhkov.easykin.service.calc.impl.DefaultCalcBean;
import ru.rrozhkov.easykin.service.calc.impl.ServiceCalcBean;
import ru.rrozhkov.easykin.service.calc.impl.electricity.ElectricityCalcBean;
import ru.rrozhkov.easykin.service.calc.impl.gaz.GazCalcBean;
import ru.rrozhkov.easykin.service.calc.impl.water.WaterCalcBean;
import ru.rrozhkov.easykin.service.calc.impl.water.hot.HotWaterCalcBean;

public class CalcBeanFactory {
	public static CalcBean createWaterCalcBean(int coldPrevMesure, int coldCurrentMesure
								, int hotPrevMesure, int hotCurrentMesure, Money inRate
								, Money outRate, Money odn) {
		return new WaterCalcBean(coldPrevMesure, coldCurrentMesure, hotPrevMesure
				, hotCurrentMesure, inRate, outRate, odn);
	}
	
	public static CalcBean createHotWaterCalcBean(int hotPrevMesure, int hotCurrentMesure
								, Money rate, Money odn) {
		return new HotWaterCalcBean(hotPrevMesure, hotCurrentMesure,rate, odn);
	}

	public static CalcBean createElectricityCalcBean(int prevMesure, int currentMesure
								, Money rate, Money odn) {
		return new ElectricityCalcBean(prevMesure, currentMesure, rate, odn);
	}

	public static CalcBean createGazCalcBean(double gazPrevMesure, double gazCurrentMesure
								, Money gazRate) {
		return new GazCalcBean(gazPrevMesure, gazCurrentMesure, gazRate);
	}

	public static CalcBean createDefaultCalcBean(String name, Money sum) {
		return new DefaultCalcBean(name, sum);
	}
	
	public static CalcBean createServiceCalcBean(Collection<CalcBean> beans) {
		return new ServiceCalcBean(beans);
	}
}