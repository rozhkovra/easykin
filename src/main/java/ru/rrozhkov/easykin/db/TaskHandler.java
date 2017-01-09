package ru.rrozhkov.easykin.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;

import ru.rrozhkov.easykin.model.task.ITask;
import ru.rrozhkov.easykin.model.task.Priority;
import ru.rrozhkov.easykin.model.task.Status;
import ru.rrozhkov.easykin.model.task.impl.TaskFactory;
import ru.rrozhkov.easykin.util.CollectionUtil;
import ru.rrozhkov.easykin.util.DateUtil;

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
	
	public static int addTask(ITask task){
		int id = -1;
		DBManager dbManager = new DBManager();
		Statement stmt = null;
		ResultSet result = null;
		try { 
			stmt = dbManager.openStatement();
			StringBuilder idBuilder = new StringBuilder("SELECT MAX(ID)+1 AS ID FROM TASK");
			result = stmt.executeQuery(idBuilder.toString());
			while(result.next()){
				id = result.getInt("ID");
			}		          			
			StringBuilder builder = new StringBuilder("INSERT INTO TASK(ID, NAME, CREATEDATE, PLANDATE, PRIORITYID, CATEGORYID, CLOSEDATE, STATUSID)")
				.append(" VALUES(")
				.append(id).append(",")
				.append("\'").append(task.getName()).append("\'").append(",")
				.append("\'").append(DateUtil.formatSql(task.getCreateDate())).append("\'").append(",")
				.append("\'").append(DateUtil.formatSql(task.getPlanDate())).append("\'").append(",")
				.append(Priority.priority(task.getPriority())).append(",")
				.append(task.getCategory().getId()).append(",")
				.append("NULL,")
				.append(Status.status(task.getStatus()))
				.append(")");
			stmt.executeUpdate(builder.toString());
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
		return id;
	}
}
