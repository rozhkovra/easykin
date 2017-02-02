package ru.rrozhkov.easykin.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;

import ru.rrozhkov.easykin.model.convert.IConverter;
import ru.rrozhkov.easykin.util.CollectionUtil;

public class DBManager {
	private static DBManager dbManager;
    private Connection connection;
	private static String nextId = "SELECT MAX(ID)+1 AS ID FROM #table#";
    
    private DBManager(){    	
    }
    
    public static DBManager instance(){
    	if(dbManager==null)
    		dbManager = new DBManager();
    	return dbManager;
    }
    
    public int nextId(String tableName) throws SQLException {
		ResultSet result = null;
		try {
			int id = -1;
			result = DBManager.instance().executeQuery(nextId.replace("#table#", tableName));
			while(result.next()){
				id = result.getInt("ID");
			}
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
	
	public <T> Collection<T> select(String select, IConverter<ResultSet,T> converter) throws SQLException {
		ResultSet result = null;
		try {
			Collection<T> collection = CollectionUtil.<T>create();
			result = DBManager.instance().executeQuery(select);
			while(result.next()){
				collection.add((T)converter.convert(result));
			}
			return collection;
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
	
	public ResultSet executeQuery(String query) throws SQLException{
		Statement stmt = null;  
		try { 
			stmt = dbManager.openStatement(); 
			return stmt.executeQuery(query);
		} catch (Exception e) { 
			throw new SQLException(e); 
		} finally {
			try {
				dbManager.closeStatement(stmt);
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public int executeUpdate(String query) throws SQLException {
		Statement stmt = null;  
		try { 
			stmt = dbManager.openStatement(); 
			return stmt.executeUpdate(query);
		} catch (Exception e) { 
			throw new SQLException(e); 
		} finally {
			try {
				dbManager.closeStatement(stmt);
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}		
	}
    
    private Connection connect() throws ClassNotFoundException, SQLException{
		if(connection==null || connection.isClosed()){
			Class.forName("org.hsqldb.jdbc.JDBCDriver"); 
			connection =  DriverManager.getConnection( "jdbc:hsqldb:hsql://localhost/easykin", "SA", "");
		}
		return connection;
    }

    private boolean disconnect() throws SQLException{
    	if(connection!=null && !connection.isClosed()){
    		connection.close();
    		return true;
    	}
    	return false;
    }
    
	private Statement openStatement() throws SQLException, ClassNotFoundException{
		return connect().createStatement();
	}

	private boolean closeStatement(Statement stmt) throws SQLException{
		if(stmt!=null && !stmt.isClosed()){
			stmt.close();
			return disconnect();
		}
		return false;
	}
}