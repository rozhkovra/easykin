package ru.rrozhkov.easykin.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import ru.rrozhkov.easykin.model.convert.IConverter;
import ru.rrozhkov.easykin.model.person.IPerson;
import ru.rrozhkov.easykin.model.person.impl.convert.DBPersonConverter;
import ru.rrozhkov.easykin.util.CollectionUtil;

public class PersonHandler {
	public static String selectPerson = "select * from PERSON";
	
	public static Collection<IPerson> select() throws SQLException {
		ResultSet result = null;
		try{
			Collection<IPerson> persons = CollectionUtil.<IPerson>create();
			IConverter<ResultSet,IPerson> converter = new DBPersonConverter();
			result = DBManager.instance().executeQuery(selectPerson);
			while(result.next()){
				persons.add(converter.convert(result));
			}
			return persons;
		}catch(Exception e){
			throw new SQLException(e);
		} finally {
			try{
				if(result!=null)
					result.close();
			}catch(SQLException e){
				throw new SQLException(e);
			}
		}
	}
}