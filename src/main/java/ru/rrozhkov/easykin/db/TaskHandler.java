package ru.rrozhkov.easykin.db;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Date;

import ru.rrozhkov.easykin.model.task.ITask;
import ru.rrozhkov.easykin.model.task.Priority;
import ru.rrozhkov.easykin.model.task.Status;
import ru.rrozhkov.easykin.model.task.impl.convert.DBTaskConverter;
import ru.rrozhkov.easykin.util.DateUtil;

public class TaskHandler {
	private static String TABLENAME = "TASK";
	
	public static String select = "SELECT TASK.*, CATEGORY.NAME as CATEGORYNAME FROM TASK"
			+" INNER JOIN CATEGORY ON TASK.CATEGORYID = CATEGORY.ID"
			+" ORDER BY TASK.STATUSID, TASK.PLANDATE, TASK.PRIORITYID, TASK.CATEGORYID";

	public static String selectForPerson = "SELECT TASK.*, CATEGORY.NAME as CATEGORYNAME FROM TASK"
			+" INNER JOIN CATEGORY ON TASK.CATEGORYID = CATEGORY.ID"
			+" INNER JOIN TASK2PERSON ON TASK2PERSON.TASK = TASK.ID AND TASK2PERSON.PERSON=#person#"
			+" ORDER BY TASK.STATUSID, TASK.PLANDATE, TASK.PRIORITYID, TASK.CATEGORYID";

	public static Collection<ITask> select() throws SQLException{
		return DBManager.instance().<ITask>select(select, new DBTaskConverter());
	}

	public static Collection<ITask> selectForPerson(int id) throws SQLException{
		return DBManager.instance().<ITask>select(selectForPerson.replace("#person#", String.valueOf(id)), new DBTaskConverter());
	}
	
	public static int insert(ITask task) throws SQLException{
		try {
			int id = DBManager.instance().nextId(TABLENAME);
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
			DBManager.instance().executeUpdate(builder.toString());
			return id;
		} catch (Exception e) { 
			throw new SQLException(e); 
		}
	}
	
	public static int update(ITask task) throws SQLException{
		try {
			StringBuilder builder = new StringBuilder("UPDATE TASK SET ")
				.append(" NAME=").append("\'").append(task.getName()).append("\'").append(",")
				.append(" PLANDATE=").append("\'").append(DateUtil.formatSql(task.getPlanDate())).append("\'").append(",")
				.append(" PRIORITYID=").append(Priority.priority(task.getPriority())).append(",")
				.append(" CATEGORYID=").append(task.getCategory().getId())
				.append(" WHERE ID=").append(task.getId());
			int count = DBManager.instance().executeUpdate(builder.toString());
			return count;
		} catch (Exception e) { 
			throw new SQLException(e); 
		} 

	}

	public static int close(ITask task) throws SQLException{
		try {
			StringBuilder builder = new StringBuilder("UPDATE TASK SET ")
				.append(" CLOSEDATE=").append("\'").append(DateUtil.formatSql(new Date())).append("\'").append(",")
				.append(" STATUSID=").append(Status.status(Status.CLOSE))
				.append(" WHERE ID=").append(task.getId());
			int count = DBManager.instance().executeUpdate(builder.toString());
			return count;
		} catch (Exception e) { 
			throw new SQLException(e); 
		} 

	}
}