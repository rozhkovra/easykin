package ru.rrozhkov.easykin.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBManager {
	private static DBManager dbManager;
    private Connection connection;
    
    private DBManager(){    	
    }
    
    public static DBManager instance(){
    	if(dbManager==null)
    		dbManager = new DBManager();
    	return dbManager;
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
    
	public Statement openStatement() throws SQLException, ClassNotFoundException{
		return connect().createStatement();
	}

	public boolean closeStatement(Statement stmt) throws SQLException{
		if(stmt!=null && !stmt.isClosed()){
			stmt.close();
			return disconnect();
		}
		return false;
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
}