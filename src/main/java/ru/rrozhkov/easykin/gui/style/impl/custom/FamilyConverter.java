package ru.rrozhkov.easykin.gui.style.impl.custom;

import ru.rrozhkov.easykin.family.IKinPerson;
import ru.rrozhkov.easykin.gui.style.impl.DataConverter;
import ru.rrozhkov.easykin.util.DateUtil;

public class FamilyConverter extends DataConverter<IKinPerson> {
	public String[] entryToStringArr(int i, IKinPerson entry) {
		return new String[]{String.valueOf(i), entry.getSurname(), entry.getName(), entry.getSecondName(), DateUtil.format(entry.getBirthDate())};
	}
}