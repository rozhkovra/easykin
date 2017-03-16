package ru.rrozhkov.easykin.gui;

import ru.rrozhkov.easykin.auth.AuthManager;
import ru.rrozhkov.easykin.context.MasterDataContext;
import ru.rrozhkov.easykin.db.impl.HSQLDBServer;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class EasyKin 
{
    static final HSQLDBServer dbServer = new HSQLDBServer("easykin", "file:data/easykin");

    public static void main( String[] args ) {
        dbServer.start();
        start();
    }

    public static void start() {
        final AuthManager authManager = AuthManager.auth();
        if (!authManager.isSignedIn()) {
            dbServer.shutdown();
            System.exit(0);
        }
        final MasterDataContext context = new MasterDataContext(authManager.signedPerson());
        context.init();
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame window = new EasyKinWindow(context);
                window.addWindowListener(new WindowAdapter() {
                    public void windowClosing(WindowEvent e) {
                        authManager.signOut();
                        dbServer.shutdown();
                        System.exit(0);
                    }
                });
            }
        });
    }
}