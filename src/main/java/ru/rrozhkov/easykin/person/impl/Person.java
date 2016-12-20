package ru.rrozhkov.easykin.person.impl;

import java.util.Date;

import ru.rrozhkov.easykin.person.IPerson;
import ru.rrozhkov.easykin.person.Sex;
import ru.rrozhkov.easykin.util.DateUtil;

public class Person implements IPerson {
	private String surname;
	private String name;
	private String secondName;
	private Date birthDate;
	private Sex sex;
	
	public Person(String surname, String name, String secondName, Date birthDate, Sex sex) {	
		this.surname = surname;
		this.name = name;
		this.secondName = secondName;
		this.birthDate = birthDate;
		this.sex = sex;
	}

	public String getSurname() {
		return surname;
	}

	public String getName() {
		return name;
	}

	public String getSecondName() {
		return secondName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public Sex getSex() {
		return sex;
	}

	@Override
	public String toString() {
		return surname + ", " + name
				+ ", " + secondName + ", " + DateUtil.format(birthDate)
				+ ", " + sex;
	}
}