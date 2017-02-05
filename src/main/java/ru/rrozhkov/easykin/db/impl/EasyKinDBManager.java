package ru.rrozhkov.easykin.db.impl;

import ru.rrozhkov.lib.db.IDBManager;
import ru.rrozhkov.lib.db.impl.DBManager;

public class EasyKinDBManager extends DBManager{
	private String connectPath = "jdbc:hsqldb:hsql://localhost/easykin";
	private String user = "SA";
	private String pass = "";
    
    private EasyKinDBManager(){    	
    }
    
    public static IDBManager instance(){
    	if(dbManager==null){
   	    	dbManager = new EasyKinDBManager();
    	}
    	return dbManager;
    }

	@Override
	protected String getConnectPath() {
		return connectPath;
	}

	@Override
	protected String getUser() {
		return user;
	}

	@Override
	protected String getPass() {
		return pass;
	}    
}