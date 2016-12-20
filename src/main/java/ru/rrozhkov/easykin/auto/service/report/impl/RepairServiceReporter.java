package ru.rrozhkov.easykin.auto.service.report.impl;

import java.util.Collection;

import ru.rrozhkov.easykin.auto.service.IRepairService;
import ru.rrozhkov.easykin.auto.service.IServiceHistory;
import ru.rrozhkov.easykin.auto.service.impl.filter.OnlyRepairFilter;
import ru.rrozhkov.easykin.auto.service.util.RepairUtil;
import ru.rrozhkov.easykin.fin.Money;
import ru.rrozhkov.easykin.report.IFilter;
import ru.rrozhkov.easykin.util.CollectionUtil;
import ru.rrozhkov.easykin.util.FilterUtil;

public class RepairServiceReporter extends ServiceReporter {

	public RepairServiceReporter(IServiceHistory history) {
		super(history);
	}

	public Money getDetailsSum() {
		Money value = new Money();
		Collection<IFilter> allFilters = CollectionUtil.<IFilter>merge2copy(filters,new OnlyRepairFilter());
		for(Object service : FilterUtil.filter(history.getServices(), allFilters)){
			value.add(RepairUtil.getDetailsPrice((IRepairService)service));
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