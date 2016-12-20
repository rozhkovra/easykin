package ru.rrozhkov.easykin.service.calc;

import ru.rrozhkov.easykin.service.calc.impl.DefaultCalcBean;
import ru.rrozhkov.easykin.service.calc.impl.DefaultCalculator;
import ru.rrozhkov.easykin.service.calc.impl.ServiceCalcBean;
import ru.rrozhkov.easykin.service.calc.impl.ServiceCalculator;
import ru.rrozhkov.easykin.service.calc.impl.electricity.ElectricityCalcBean;
import ru.rrozhkov.easykin.service.calc.impl.electricity.ElectricityCalculator;
import ru.rrozhkov.easykin.service.calc.impl.gaz.GazCalcBean;
import ru.rrozhkov.easykin.service.calc.impl.gaz.GazCalculator;
import ru.rrozhkov.easykin.service.calc.impl.water.WaterCalcBean;
import ru.rrozhkov.easykin.service.calc.impl.water.WaterCalculator;
import ru.rrozhkov.easykin.service.calc.impl.water.hot.HotWaterCalcBean;
import ru.rrozhkov.easykin.service.calc.impl.water.hot.HotWaterCalculator;

public class CalculatorFactory {
	public static Calculator getCalculator(CalcBean bean){
		if(bean instanceof GazCalcBean)
			return new GazCalculator((GazCalcBean)bean);
		else if (bean instanceof WaterCalcBean)
			return new WaterCalculator((WaterCalcBean)bean);
		else if (bean instanceof ElectricityCalcBean)
			return new ElectricityCalculator((ElectricityCalcBean)bean);
		else if (bean instanceof HotWaterCalcBean)
			return new HotWaterCalculator((HotWaterCalcBean) bean);
		else if (bean instanceof DefaultCalcBean)
			return new DefaultCalculator((DefaultCalcBean) bean);
		else if (bean instanceof ServiceCalcBean)
			return new ServiceCalculator((ServiceCalcBean) bean);
		return null;
	}
}