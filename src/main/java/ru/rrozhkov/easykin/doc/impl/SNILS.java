package ru.rrozhkov.easykin.doc.impl;

import static ru.rrozhkov.easykin.doc.DocType.SNILS;

import java.io.File;

import ru.rrozhkov.easykin.person.IPerson;

public class SNILS extends Doc {
	private String number;

	public SNILS(IPerson person, String number, File scan) {
		super(SNILS, person, scan);
		this.number = number;
	}

	public String getNumber() {
		return number;
	}
}