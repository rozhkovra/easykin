package ru.rrozhkov.easykin.auto;

import ru.rrozhkov.easykin.doc.IDoc;
import ru.rrozhkov.easykin.person.IPerson;

public interface IRegisteredCar extends ICar {
	IPerson getOwner();
	IDoc getTechPassport();
}