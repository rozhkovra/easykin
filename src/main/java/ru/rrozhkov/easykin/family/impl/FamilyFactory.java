package ru.rrozhkov.easykin.family.impl;

import java.util.Collection;

import ru.rrozhkov.easykin.family.IFamily;
import ru.rrozhkov.easykin.family.IKinPerson;
import ru.rrozhkov.easykin.family.KinType;
import ru.rrozhkov.easykin.person.Sex;
import ru.rrozhkov.easykin.util.DateUtil;

public class FamilyFactory {
	public static IKinPerson createFather(String surname, String name, String secondName, String birthDate){
		return new KinPerson(surname,name,secondName,DateUtil.parse(birthDate),Sex.MALE,KinType.FATHER);
	}
	public static IKinPerson createMother(String surname, String name, String secondName, String birthDate){
		return new KinPerson(surname,name,secondName,DateUtil.parse(birthDate),Sex.FEMALE,KinType.MOTHER);
	}
	public static IKinPerson createSun(String surname, String name, String secondName, String birthDate){
		return new KinPerson(surname,name,secondName,DateUtil.parse(birthDate),Sex.MALE,KinType.SUN);
	}
	public static IKinPerson createDaughter(String surname, String name, String secondName, String birthDate){
		return new KinPerson(surname,name,secondName,DateUtil.parse(birthDate),Sex.FEMALE,KinType.DAUGHTER);
	}
	public static IFamily createFamily(Collection<IKinPerson> persons){
		return new Family(persons);
	}
}