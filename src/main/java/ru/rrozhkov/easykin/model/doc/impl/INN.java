package ru.rrozhkov.easykin.model.doc.impl;

import static ru.rrozhkov.easykin.model.doc.DocType.INN;

import java.io.File;

import ru.rrozhkov.easykin.model.person.IPerson;

public class INN extends Doc {
	private String number;

	public INN(IPerson person, String number, File scan) {
		super(INN, person, scan);
		this.number = number;
	}

	public String getNumber() {
		return number;
	}
}