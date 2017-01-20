package ru.rrozhkov.easykin.gui.style.impl.custom;

import ru.rrozhkov.easykin.gui.style.impl.CollectionConverter;
import ru.rrozhkov.easykin.model.family.IKinPerson;
import ru.rrozhkov.easykin.util.DateUtil;

public class FamilyConverter extends CollectionConverter<IKinPerson> {
	public FamilyConverter(int colSize) {
		super(colSize);
	}

	public String[] convert(int i, IKinPerson entry) {
		return new String[]{String.valueOf(i), entry.getSurname(), entry.getName(), entry.getSecondName(), DateUtil.format(entry.getBirthDate())};
	}
}