package ru.rrozhkov.easykin.family.impl;

import java.util.Collection;

import ru.rrozhkov.easykin.family.IFamily;
import ru.rrozhkov.easykin.family.IKinPerson;

public class Family implements IFamily {
	private Collection<IKinPerson> persons;
	
	public Family(Collection<IKinPerson> persons) {
		this.persons = persons;
	}

	public Collection<IKinPerson> getPersons() {
		return persons;
	}

	@Override
	public String toString() {
		return "Family \n"+persons;
	}	
}