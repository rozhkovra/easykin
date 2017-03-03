package ru.rrozhkov.easykin.gui;

import ru.rrozhkov.easykin.context.MasterDataContext;
import ru.rrozhkov.easykin.db.impl.HSQLDBServer;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class EasyKin 
{
    public static void main( String[] args ) {
        final HSQLDBServer dbServer = new HSQLDBServer("easykin", "file:data/easykin");
        dbServer.start();
    	final MasterDataContext context = new MasterDataContext();
    	context.init();
    	javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame window = new EasyKinWindow(context);
                window.addWindowListener(new WindowAdapter() {
                    public void windowClosing(WindowEvent e) {
                        dbServer.shutdown();
                        System.exit(0);
                    }
                });
            }   
        });
    }
}