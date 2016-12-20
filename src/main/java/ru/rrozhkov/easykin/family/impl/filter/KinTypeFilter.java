package ru.rrozhkov.easykin.family.impl.filter;

import ru.rrozhkov.easykin.family.KinType;
import ru.rrozhkov.easykin.family.impl.KinPerson;
import ru.rrozhkov.easykin.report.impl.Filter;

public class KinTypeFilter extends Filter{
	private KinType[] kinTypes;

	public KinTypeFilter(KinType[] kinTypes) {
		this.kinTypes = kinTypes;
	}
	
	public boolean filter(){
		for(KinType kinType : kinTypes){
			if(kinType.equals(((KinPerson)obj).getKinType()))
				return true;
		}
		return false;
	}
}