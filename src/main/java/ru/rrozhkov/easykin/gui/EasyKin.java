package ru.rrozhkov.easykin.gui;

import ru.rrozhkov.easykin.context.MasterDataContext;
import ru.rrozhkov.easykin.db.impl.HSQLDBServer;

public class EasyKin 
{
    public static void main( String[] args ) {
        final HSQLDBServer dbServer = new HSQLDBServer("easykin", "file:data/easykin");
        dbServer.start();
    	final MasterDataContext context = new MasterDataContext();
    	context.init();
    	javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new EasyKinWindow(dbServer, context);
            }   
        });
    }
}