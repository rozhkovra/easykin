package ru.rrozhkov.easykin.model.family.impl.filter;

import ru.rrozhkov.easykin.filter.IFilter;
import ru.rrozhkov.easykin.model.family.IKinPerson;
import ru.rrozhkov.easykin.model.family.KinType;

public class KinFilterFactory {
	public static IFilter<IKinPerson> createKinTypeFilter(KinType[] kinTypes){
		return new KinTypeFilter(kinTypes); 
	}
}