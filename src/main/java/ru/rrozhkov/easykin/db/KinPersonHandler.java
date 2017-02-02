package ru.rrozhkov.easykin.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import ru.rrozhkov.easykin.model.convert.IConverter;
import ru.rrozhkov.easykin.model.family.IKinPerson;
import ru.rrozhkov.easykin.model.family.impl.convert.DBKinPersonConverter;
import ru.rrozhkov.easykin.util.CollectionUtil;

public class KinPersonHandler {
	public static String select = "select * from PERSON inner join KINPERSON on PERSON.id = KINPERSON.person";
	
	public static Collection<IKinPerson> select() throws SQLException {
		ResultSet result = null;
		try{
			Collection<IKinPerson> persons = CollectionUtil.<IKinPerson>create();
			IConverter<ResultSet,IKinPerson> converter = new DBKinPersonConverter();
			result = DBManager.instance().executeQuery(select);
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
