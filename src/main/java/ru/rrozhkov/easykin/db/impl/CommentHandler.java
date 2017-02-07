package ru.rrozhkov.easykin.db.impl;

import java.sql.SQLException;
import java.util.Collection;

import ru.rrozhkov.easykin.model.task.IComment;
import ru.rrozhkov.easykin.model.task.impl.convert.DBCommentConverter;

public class CommentHandler {
	private static String TABLENAME = "COMMENT";
	
	public static String select = "SELECT * FROM "+TABLENAME;
	public static String selectForTask = "SELECT * FROM "+TABLENAME+" where taskId=#taskId#";

	public static Collection<IComment> select() throws SQLException{
		return EasyKinDBManager.instance().<IComment>select(select, new DBCommentConverter());
	}
	
	public static Collection<IComment> selectForTask(int taskId) throws SQLException{
		return EasyKinDBManager.instance().<IComment>select(selectForTask.replace("#taskId#", String.valueOf(taskId)), new DBCommentConverter());
	}
}