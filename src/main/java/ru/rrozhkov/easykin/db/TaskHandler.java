package ru.rrozhkov.easykin.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Date;

import ru.rrozhkov.easykin.model.convert.IConverter;
import ru.rrozhkov.easykin.model.task.ITask;
import ru.rrozhkov.easykin.model.task.Priority;
import ru.rrozhkov.easykin.model.task.Status;
import ru.rrozhkov.easykin.model.task.impl.convert.DBTaskConverter;
import ru.rrozhkov.easykin.util.CollectionUtil;
import ru.rrozhkov.easykin.util.DateUtil;

public class TaskHandler {
	public static String selectTasks = "SELECT TASK.*, CATEGORY.NAME as CATEGORYNAME FROM TASK"
			+" INNER JOIN CATEGORY ON TASK.CATEGORYID = CATEGORY.ID"
			+" ORDER BY TASK.STATUSID, TASK.PLANDATE, TASK.PRIORITYID, TASK.CATEGORYID";
	
	public static String newTaskId = "SELECT MAX(ID)+1 AS ID FROM TASK";

	public static Collection<ITask> selectTasks() throws SQLException{
		ResultSet result = null; 
		try {
			Collection<ITask> tasks = CollectionUtil.<ITask>create();
			IConverter<ResultSet,ITask> converter = new DBTaskConverter();
			result = DBManager.getInstance().executeQuery(selectTasks);
			while(result.next()){
				tasks.add(converter.convert(result));
			}
			return tasks;
		} catch (Exception e) { 
			throw new SQLException(e); 
		} finally {
			try {
				if(result!=null)
					result.close();
			}catch (SQLException e) {
				throw new SQLException(e);
			}
		}
	}
	
	public static int insertTask(ITask task) throws SQLException{
		ResultSet result = null;
		try {
			int id = -1;
			DBManager dbManager = DBManager.getInstance();
			result = dbManager.executeQuery(newTaskId);
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
			dbManager.executeUpdate(builder.toString());
			return id;
		} catch (Exception e) { 
			throw new SQLException(e); 
		} finally {
			try {
				if(result!=null)
					result.close();
			}catch (SQLException e) {
				throw new SQLException(e);
			}
		} 

	}
	
	public static int updateTask(ITask task) throws SQLException{
		try {
			StringBuilder builder = new StringBuilder("UPDATE TASK SET ")
				.append(" NAME=").append("\'").append(task.getName()).append("\'").append(",")
				.append(" PLANDATE=").append("\'").append(DateUtil.formatSql(task.getPlanDate())).append("\'").append(",")
				.append(" PRIORITYID=").append(Priority.priority(task.getPriority())).append(",")
				.append(" CATEGORYID=").append(task.getCategory().getId())
				.append(" WHERE ID=").append(task.getId());
			int count = DBManager.getInstance().executeUpdate(builder.toString());
			return count;
		} catch (Exception e) { 
			throw new SQLException(e); 
		} 

	}

	public static int closeTask(ITask task) throws SQLException{
		try {
			StringBuilder builder = new StringBuilder("UPDATE TASK SET ")
				.append(" CLOSEDATE=").append("\'").append(DateUtil.formatSql(new Date())).append("\'").append(",")
				.append(" STATUSID=").append(Status.status(Status.CLOSE))
				.append(" WHERE ID=").append(task.getId());
			int count = DBManager.getInstance().executeUpdate(builder.toString());
			return count;
		} catch (Exception e) { 
			throw new SQLException(e); 
		} 

	}
}