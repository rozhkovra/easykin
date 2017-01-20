package ru.rrozhkov.easykin.gui.style.impl.custom;

import ru.rrozhkov.easykin.gui.style.ICollectionConverter;
import ru.rrozhkov.easykin.gui.style.IStyle;
import ru.rrozhkov.easykin.gui.style.ITableStyle;
import ru.rrozhkov.easykin.model.family.IKinPerson;

public class FamilyStyle implements IStyle<IKinPerson> {

	public ITableStyle<IKinPerson> tableStyle() {
		return new FamilyTableStyle();
	}

	public ICollectionConverter<IKinPerson> dataConverter() {
		return new FamilyConverter(tableStyle().getColumnCount());
	}

}