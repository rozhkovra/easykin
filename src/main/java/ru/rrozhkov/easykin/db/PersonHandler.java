package ru.rrozhkov.easykin.db;

import java.sql.SQLException;
import java.util.Collection;

import ru.rrozhkov.easykin.model.person.IPerson;
import ru.rrozhkov.easykin.model.person.impl.convert.DBPersonConverter;

public class PersonHandler {
	public static String select = "select * from PERSON";
	
	public static Collection<IPerson> select() throws SQLException {
		return DBManager.instance().<IPerson>select(select,new DBPersonConverter());
	}
}