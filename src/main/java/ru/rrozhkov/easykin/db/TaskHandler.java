package ru.rrozhkov.easykin.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;

import ru.rrozhkov.easykin.task.ITask;
import ru.rrozhkov.easykin.task.impl.TaskFactory;
import ru.rrozhkov.easykin.util.CollectionUtil;

public class TaskHandler {
	public static Collection<ITask> getTasks(){
		Collection<ITask> tasks = CollectionUtil.<ITask>create();
		DBManager dbManager = new DBManager();
		Statement stmt = null; 
		ResultSet result = null; 
		try { 
			stmt = dbManager.openStatement(); 
			result = stmt.executeQuery("SELECT * FROM task");
			while(result.next()){
				tasks.add(TaskFactory.createTask(result.getInt("id"), result.getString("name")
						, result.getDate("createdate"), result.getDate("plandate"), result.getInt("priorityid")
						, result.getInt("categoryid"), result.getDate("closedate"), result.getInt("statusid")));
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
		return tasks;
	}
}