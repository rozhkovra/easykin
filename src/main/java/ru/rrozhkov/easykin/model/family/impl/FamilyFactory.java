package ru.rrozhkov.easykin.model.family.impl;

import java.sql.Date;
import java.util.Collection;

import ru.rrozhkov.easykin.model.family.IFamily;
import ru.rrozhkov.easykin.model.family.IKinPerson;
import ru.rrozhkov.easykin.model.family.KinType;
import ru.rrozhkov.easykin.model.person.Sex;
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
	public static IKinPerson create(int id, String surname, String name,
			String secondName, Date date, Sex sex, KinType kinType) {
		return new KinPerson(id, surname,name,secondName,date,sex,kinType);
	}
}