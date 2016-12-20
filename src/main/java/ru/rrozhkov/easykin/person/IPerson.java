package ru.rrozhkov.easykin.person;

import java.util.Date;

public interface IPerson{
	String getSurname();
	String getName();
	String getSecondName();
	Date getBirthDate();
	Sex getSex();
}