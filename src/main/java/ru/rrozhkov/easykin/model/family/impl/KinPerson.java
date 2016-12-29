package ru.rrozhkov.easykin.model.family.impl;

import java.util.Date;

import ru.rrozhkov.easykin.model.family.IKinPerson;
import ru.rrozhkov.easykin.model.family.KinType;
import ru.rrozhkov.easykin.model.person.Sex;
import ru.rrozhkov.easykin.model.person.impl.Person;
import ru.rrozhkov.easykin.util.DateUtil;

public class KinPerson extends Person implements IKinPerson{
	private KinType kinType;
	
	public KinPerson(String surname, String name, String secondName,
			Date birthDate, Sex sex, KinType kinType) {
		super(surname, name, secondName, birthDate, sex);
		this.kinType = kinType; 
	}

	public KinType getKinType() {
		return kinType;
	}

	@Override
	public String toString() {
		return kinType + ", "
				+ getSurname() + ", " + getName()
				+ ", " + getSecondName() + ", "
				+ DateUtil.format(getBirthDate()) + ", " + getSex() + "\n";
	}	
}