package ru.rrozhkov.easykin.gui.style.impl.custom;

import ru.rrozhkov.easykin.family.IKinPerson;
import ru.rrozhkov.easykin.gui.style.IDataConverter;
import ru.rrozhkov.easykin.gui.style.IStyle;
import ru.rrozhkov.easykin.gui.style.ITableStyle;

public class FamilyStyle implements IStyle<IKinPerson> {

	public ITableStyle tableStyle() {
		return new FamilyTableStyle();
	}

	public IDataConverter<IKinPerson> dataConverter() {
		return new FamilyConverter();
	}

}
