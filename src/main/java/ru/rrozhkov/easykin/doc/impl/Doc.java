package ru.rrozhkov.easykin.doc.impl;

import java.io.File;

import ru.rrozhkov.easykin.doc.DocType;
import ru.rrozhkov.easykin.doc.IDoc;
import ru.rrozhkov.easykin.person.IPerson;

public abstract class Doc implements IDoc {
	protected DocType docType;
	private IPerson person;
	private File scan;

	public Doc(DocType docType, IPerson person, File scan) {
		this.docType = docType;
		this.person = person;
		this.scan = scan;
	}

	public DocType getDocType() {
		return docType;
	}

	public IPerson getPerson() {
		return person;
	}

	public File getScan() {
		return scan;
	}	
}