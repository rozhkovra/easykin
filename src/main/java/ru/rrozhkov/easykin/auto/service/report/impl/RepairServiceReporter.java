package ru.rrozhkov.easykin.auto.service.report.impl;

import ru.rrozhkov.easykin.auto.service.IService;
import ru.rrozhkov.easykin.auto.service.IServiceHistory;
import ru.rrozhkov.easykin.auto.service.util.RepairUtil;
import ru.rrozhkov.easykin.fin.Money;
import ru.rrozhkov.easykin.util.FilterUtil;

public class RepairServiceReporter extends ServiceReporter {

	public RepairServiceReporter(IServiceHistory history) {
		super(history);
	}

	public Money getDetailsSum() {
		Money value = new Money();
		for(IService service : FilterUtil.<IService>filter(history.getServices(), filters)){
			value.add(RepairUtil.getDetailsPrice(service));
		}						
		return value;
	}
	
	protected String getReportHeader(){
		return "Отчет по услугам c деталями.";
	}

	protected String getReportFooter(){
		return "Итого услуг на: "+getSum()+"\nИтого запчастей на: "+getDetailsSum()+"\nИтого: "+getSum().add(getDetailsSum());
	}

}