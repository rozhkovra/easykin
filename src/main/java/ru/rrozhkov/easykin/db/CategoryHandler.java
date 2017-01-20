package ru.rrozhkov.easykin.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import ru.rrozhkov.easykin.model.category.ICategory;
import ru.rrozhkov.easykin.model.category.convert.DBCategoryConverter;
import ru.rrozhkov.easykin.model.convert.IConverter;
import ru.rrozhkov.easykin.util.CollectionUtil;

public class CategoryHandler {
	public static String selectCategories = "SELECT * FROM category ORDER BY ID";
	
	public static Collection<ICategory> selectCategories() throws SQLException{
		ResultSet result = null; 
		try { 
			Collection<ICategory> categories = CollectionUtil.<ICategory>create();
			IConverter<ResultSet,ICategory> converter = new DBCategoryConverter();
			result = DBManager.getInstance().executeQuery(selectCategories);
			while(result.next()){
				categories.add(converter.convert(result));
			}
			return categories;
		} catch (Exception e) { 
			throw new SQLException(e); 
		} finally {
			try {
				if(result!=null)
					result.close();
			}catch (SQLException e) {
				throw new SQLException(e);			}
		} 
	}
}