package ru.rrozhkov.easykin.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;

import ru.rrozhkov.easykin.model.category.Category;
import ru.rrozhkov.easykin.model.category.ICategory;
import ru.rrozhkov.easykin.util.CollectionUtil;

public class CategoryHandler {
	public static Collection<ICategory> selectCategories(){
		Collection<ICategory> categories = CollectionUtil.<ICategory>create();
		DBManager dbManager = DBManager.getInstance();
		Statement stmt = null; 
		ResultSet result = null; 
		try { 
			stmt = dbManager.openStatement(); 
			result = stmt.executeQuery("SELECT * FROM category ORDER BY ID");
			while(result.next()){
				categories.add(new Category(result.getInt("id"), result.getString("name")));
			}		          
		} catch (Exception e) { 
			e.printStackTrace(System.out); 
		} finally {
			try {
				if(result!=null)
					result.close();
				dbManager.closeStatement(stmt);
			}catch (SQLException e) {
				e.printStackTrace();
			}
		} 
		return categories;
	}
}
