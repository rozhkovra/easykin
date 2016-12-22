package ru.rrozhkov.easykin.auto.impl;

import ru.rrozhkov.easykin.auto.Body;
import ru.rrozhkov.easykin.auto.Brend;
import ru.rrozhkov.easykin.auto.IRegisteredCar;
import ru.rrozhkov.easykin.auto.Model;
import ru.rrozhkov.easykin.doc.IDoc;
import ru.rrozhkov.easykin.person.IPerson;

public class RegisteredCar extends Car implements IRegisteredCar {
	private IPerson owner;
	private IDoc techPassport;
	public RegisteredCar(Brend brend, Model model, Body body, int year,
			double volume, IPerson owner, IDoc techPassport) {
		super(brend, model, body, year, volume);
		this.owner = owner;
		this.techPassport = techPassport;
	}

	public IPerson getOwner() {
		return owner;
	}

	public IDoc getTechPassport() {
		return techPassport;
	}

	@Override
	public String toString() {
		return getBrend()+ ", " + getModel() + ", " + getBody()
				+ ", " + getYear() + ", " + getVolume() + ", " 
				+ owner + ", " + techPassport;
	}
}