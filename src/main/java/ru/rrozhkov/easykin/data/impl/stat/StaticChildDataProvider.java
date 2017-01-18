package ru.rrozhkov.easykin.data.impl.stat;

import java.util.Collection;

import ru.rrozhkov.easykin.model.family.IKinPerson;
import ru.rrozhkov.easykin.model.family.KinType;
import ru.rrozhkov.easykin.model.family.impl.filter.KinFilterFactory;
import ru.rrozhkov.easykin.util.FilterUtil;

public class StaticChildDataProvider extends StaticPersonDataProvider{	
	public Collection<IKinPerson> getData() {		
		return FilterUtil.filter(super.getData(), KinFilterFactory.create(new KinType[]{KinType.SUN, KinType.DAUGHTER}));
	}
}