package ru.rrozhkov.easykin.data.impl.stat;

import static ru.rrozhkov.easykin.model.family.impl.FamilyFactory.createDaughter;
import static ru.rrozhkov.easykin.model.family.impl.FamilyFactory.createFather;
import static ru.rrozhkov.easykin.model.family.impl.FamilyFactory.createMother;
import static ru.rrozhkov.easykin.model.family.impl.FamilyFactory.createSun;

import java.util.Arrays;

import ru.rrozhkov.easykin.data.impl.CollectionDataProvider;
import ru.rrozhkov.easykin.model.family.IKinPerson;
import ru.rrozhkov.easykin.util.CollectionUtil;

public class StaticPersonDataProvider extends CollectionDataProvider<IKinPerson>{
	public StaticPersonDataProvider(){
		super(CollectionUtil.copy(Arrays.asList(
    		createFather("Рожков","Роман","Александрович","29.08.1985")
    		,createMother("Берсенёва","Татьяна","Михайловна","04.05.1972")
        	,createDaughter("Берсенёва","Серафима","Андреевна","04.06.1996")
        	,createSun("Рожков","Алексей","Романович","28.08.2013"))));	
    }
}