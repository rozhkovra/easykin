package ru.rrozhkov.easykin.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBManager {
	private static DBManager dbManager;
    private Connection connection;
    
    private DBManager(){    	
    }
    
    public static DBManager getInstance(){
    	if(dbManager==null)
    		dbManager = new DBManager();
    	return dbManager;
    }
    
    private Connection openConnection() throws ClassNotFoundException, SQLException{
		if(connection==null || connection.isClosed()){
			Class.forName("org.hsqldb.jdbc.JDBCDriver"); 
			connection =  DriverManager.getConnection( "jdbc:hsqldb:hsql://localhost/easykin", "SA", "");
		}
		return connection;
    }

    private boolean closeConnection() throws SQLException{
    	if(connection!=null && !connection.isClosed()){
    		connection.close();
    		return true;
    	}
    	return false;
    }
    
	public Statement openStatement() throws SQLException, ClassNotFoundException{
		return openConnection().createStatement();
	}

	public boolean closeStatement(Statement stmt) throws SQLException{
		if(stmt!=null && !stmt.isClosed()){
			stmt.close();
			return closeConnection();
		}
		return false;
	}
}
