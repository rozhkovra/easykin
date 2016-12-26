package ru.rrozhkov.easykin.auto.service.util;

import ru.rrozhkov.easykin.auto.service.IService;
import ru.rrozhkov.easykin.fin.Money;

public class RepairUtil {
	public static Money getDetailsPrice(IService service){
		Money sum = new Money();
		for (IService detail : service.services()) {
			sum.add(detail.getPrice());
		}
		return sum;
	}
}
