package ru.rrozhkov.easykin.auto.doc.impl;

import java.io.File;
import java.util.Date;

import ru.rrozhkov.easykin.doc.DocType;
import ru.rrozhkov.easykin.doc.impl.Passport;
import ru.rrozhkov.easykin.person.IPerson;

public class TechPassport extends Passport {
	private String regNumber;
	private String specComment;

	public TechPassport(IPerson person, String number, String series, String org, 
			Date issueDate, File scan, String regNumber, String specComment) {
		super(person, number, series, org, issueDate, scan);
		this.regNumber = regNumber;
		this.specComment = specComment;
		this.docType = DocType.TECHPASSPORT;
	}
	
	public String getRegNumber() {
		return regNumber;
	}

	public String getSpecComment() {
		return specComment;
	}
}