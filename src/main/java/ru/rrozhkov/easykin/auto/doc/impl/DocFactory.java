package ru.rrozhkov.easykin.auto.doc.impl;

import java.io.File;
import java.util.Date;

import ru.rrozhkov.easykin.doc.IDoc;
import ru.rrozhkov.easykin.person.IPerson;

public class DocFactory {
	public static IDoc createTechPassport(IPerson person, String number, String series,
			String org, Date issueDate, File scan, String regNumber, String specComment) {
		return new TechPassport(person, number, series, org, issueDate, scan, regNumber, specComment);
	}
}