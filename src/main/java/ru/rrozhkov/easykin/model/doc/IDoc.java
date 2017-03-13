package ru.rrozhkov.easykin.model.doc;

import java.io.File;
import java.util.Date;

import ru.rrozhkov.easykin.model.person.IPerson;

public interface IDoc {
	DocType getDocType();
	IPerson getPerson();
	String getNumber();
	String getSeries();
	File getScan();
	Date getDate();
}