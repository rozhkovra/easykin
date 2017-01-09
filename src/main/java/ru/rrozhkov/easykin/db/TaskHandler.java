package ru.rrozhkov.easykin.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;

import ru.rrozhkov.easykin.model.task.ITask;
import ru.rrozhkov.easykin.model.task.impl.TaskFactory;
import ru.rrozhkov.easykin.util.CollectionUtil;

public class TaskHandler {
	public static Collection<ITask> getTasks(){
		Collection<ITask> tasks = CollectionUtil.<ITask>create();
		DBManager dbManager = new DBManager();
		Statement stmt = null; 
		ResultSet result = null; 
		try { 
			stmt = dbManager.openStatement();
			StringBuilder builder = new StringBuilder("SELECT TASK.*, CATEGORY.NAME as CATEGORYNAME FROM TASK")
									.append(" INNER JOIN CATEGORY ON TASK.CATEGORYID = CATEGORY.ID")
									.append(" ORDER BY TASK.PLANDATE");
			result = stmt.executeQuery(builder.toString());
			while(result.next()){
				tasks.add(TaskFactory.createTask(result.getInt("id"), result.getString("name"), result.getDate("createdate")
						, result.getDate("plandate"), result.getInt("priorityid"), result.getInt("categoryid")
						, result.getString("categoryname"), result.getDate("closedate"), result.getInt("statusid")));
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
