package ru.rrozhkov.easykin.gui;

import ru.rrozhkov.easykin.context.MasterDataContext;

public class EasyKin 
{
    public static void main( String[] args ) {
    	final MasterDataContext context = new MasterDataContext();
    	context.init();
    	javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new EasyKinWindow(context);   
            }   
        });
    }
}