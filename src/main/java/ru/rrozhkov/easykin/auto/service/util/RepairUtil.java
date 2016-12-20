package ru.rrozhkov.easykin.auto.service.util;

import ru.rrozhkov.easykin.auto.service.IDetail;
import ru.rrozhkov.easykin.auto.service.IRepairService;
import ru.rrozhkov.easykin.fin.Money;

public class RepairUtil {
	public static Money getDetailsPrice(IRepairService service){
		Money sum = new Money();
		for (IDetail detail : service.getDetails()) {
			sum.add(detail.getPrice());
		}
		return sum;
	}
}
