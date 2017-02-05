package ru.rrozhkov.easykin.gui;

import ru.rrozhkov.easykin.context.EasyKinContext;

public class EasyKin 
{
    public static void main( String[] args ) {
    	final EasyKinContext context = new EasyKinContext();
    	context.init();
    	javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new EasyKinWindow(context);   
            }   
        });
    }
}