package ru.rrozhkov.easykin.model.auto.service.util;

import ru.rrozhkov.easykin.model.auto.service.IService;
import ru.rrozhkov.easykin.model.fin.Money;

public class RepairUtil {
	public static Money getDetailsPrice(IService service){
		Money sum = new Money();
		for (IService detail : service.services()) {
			sum.add(detail.getPrice());
		}
		return sum;
	}
}
