package ru.rrozhkov.easykin.gui.service;

import ru.rrozhkov.easykin.service.calc.CalcBean;
import ru.rrozhkov.easykin.service.calc.impl.DefaultCalcBean;
import ru.rrozhkov.easykin.service.calc.impl.ServiceCalcBean;
import ru.rrozhkov.easykin.service.calc.impl.electricity.ElectricityCalcBean;
import ru.rrozhkov.easykin.service.calc.impl.gaz.GazCalcBean;
import ru.rrozhkov.easykin.service.calc.impl.water.WaterCalcBean;
import ru.rrozhkov.easykin.service.calc.impl.water.hot.HotWaterCalcBean;

public class PanelFactory {
	public static Panel getPanel(CalcBean bean){
		if(bean instanceof GazCalcBean)
			return new GazPanel((GazCalcBean) bean);
		else if (bean instanceof WaterCalcBean)
			return new WaterPanel((WaterCalcBean) bean);
		else if (bean instanceof ElectricityCalcBean)
			return new ElectricityPanel((ElectricityCalcBean) bean);
		else if (bean instanceof HotWaterCalcBean)
			return new HotWaterPanel((HotWaterCalcBean) bean);
		else if (bean instanceof DefaultCalcBean)
			return new DefaultPanel((DefaultCalcBean) bean);
		else if (bean instanceof ServiceCalcBean)
			return new ServicePanel((ServiceCalcBean) bean);
		return null;
	}
}