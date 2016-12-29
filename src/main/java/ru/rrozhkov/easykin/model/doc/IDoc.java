package ru.rrozhkov.easykin.model.doc;

import java.io.File;

import ru.rrozhkov.easykin.model.person.IPerson;

public interface IDoc {
	DocType getDocType();
	IPerson getPerson();
	File getScan();
}