package ru.rrozhkov.easykin.model.family.impl.filter;

import ru.rrozhkov.easykin.filter.impl.Filter;
import ru.rrozhkov.easykin.model.family.KinType;
import ru.rrozhkov.easykin.model.family.impl.KinPerson;

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