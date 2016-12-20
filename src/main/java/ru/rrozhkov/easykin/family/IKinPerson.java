package ru.rrozhkov.easykin.family;

import ru.rrozhkov.easykin.person.IPerson;

public interface IKinPerson extends IPerson{
	KinType getKinType();
}