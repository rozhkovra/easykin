package ru.rrozhkov.easykin.doc;

import java.io.File;

import ru.rrozhkov.easykin.person.IPerson;

public interface IDoc {
	DocType getDocType();
	IPerson getPerson();
	File getScan();
}